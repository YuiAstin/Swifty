package main;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

import GUI.*;
public class Client {

	public static void main(String[] args) throws UnknownHostException, IOException {
		// TODO Auto-generated method stub
//		Socket socket = new Socket("113.173.218.108", 5000);
		Socket socket = new Socket("localhost", 5000);
		DataInputStream dis = new DataInputStream(socket.getInputStream());
		DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
		
		Login login = new Login(dis, dos);
		login.setVisible(true);
		Scanner inputFromUser = new Scanner(System.in, "UTF-8");
		String data = "";
		
		System.out.println("OK");
	}

}
