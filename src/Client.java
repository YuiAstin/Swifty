import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Client {
	private Socket socket = null;
	
	public Client(String host, int port) {
		try {
			socket = new Socket(host, port);
			Scanner inputFromUser = new Scanner(System.in, "UTF-8");
			
			DataInputStream dis = new DataInputStream(socket.getInputStream());
			DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
			
			String data = "";
			System.out.println(dis.readUTF());
			while (true) {
				System.out.print("-------------------------------------------");
				// Sent data from client
				System.out.print("\nClient sent: ");
				data = inputFromUser.nextLine();
				dos.writeUTF(data);
				// Response from server
				String respond = dis.readUTF();
				System.out.print("Client received:\n" + respond.substring(1) + "\n");
				if (respond.substring(0, 1).equals("1")) {
					System.out.println("Bye forever from server");
					break;
				}
			}
		} catch (Exception ex) {
			System.out.println("Error: " + ex);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Client client = new Client("localhost", 5050);

	}

}
