package BUS;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.security.*;
import java.security.KeyStore.SecretKeyEntry;
import java.security.cert.CertificateException;

import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;

public class Encryption {
	static public String Encrypt(String data)
	{
		try {
			
			KeyPairGenerator keygen = KeyPairGenerator.getInstance("RSA");
			keygen.initialize(2048);
			KeyPair pair = keygen.generateKeyPair();
			PublicKey pubKey = pair.getPublic();
			Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
			cipher.init(Cipher.ENCRYPT_MODE, pubKey);
			byte[] input = data.getBytes();
			cipher.update(input);
			byte[] cipherText = cipher.doFinal(); 
			return cipherText.toString();
		} catch (NoSuchAlgorithmException | NoSuchPaddingException | InvalidKeyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "";
		} catch (BadPaddingException | IllegalBlockSizeException e) {
			e.printStackTrace();
			return "";
		}
	}
	static public String Decrypt(String data)
	{
		try {			
			KeyPairGenerator keygen = KeyPairGenerator.getInstance("RSA");
			keygen.initialize(2048);
			KeyPair pair = keygen.generateKeyPair();
			PublicKey pubKey = pair.getPublic();
			Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
			cipher.init(Cipher.ENCRYPT_MODE, pubKey);
			cipher.init(Cipher.DECRYPT_MODE, pair.getPrivate());
			byte[] dataBytes = data.getBytes();
			byte[] decipheredText = cipher.doFinal(dataBytes);
			return decipheredText.toString();

		} catch (NoSuchAlgorithmException | NoSuchPaddingException | InvalidKeyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "";
		} catch (BadPaddingException | IllegalBlockSizeException e) {
			e.printStackTrace();
			return "";
		}
		
	}
	public static void StoringIntoKeyStore()
	{		   
		      //Creating the KeyStore object
		      KeyStore keyStore;
			try {
				keyStore = KeyStore.getInstance("JCEKS");
				
				//Loading the KeyStore object
			      char[] password = "pasuwaado".toCharArray();
			      String path = "C:/Program Files/Java/jdk-12.0.1/lib/security/cacerts";  // must change directory
			      java.io.FileInputStream fis = new FileInputStream(path);
			      keyStore.load(fis, password);
			      
			      //Creating the KeyStore.ProtectionParameter object
			      KeyStore.ProtectionParameter protectionParam = new KeyStore.PasswordProtection(password);

			      //Creating SecretKey object
			      SecretKey mySecretKey = new SecretKeySpec("pasuwaado".getBytes(), "RSA");
			      
			      //Creating SecretKeyEntry object
			      KeyStore.SecretKeyEntry secretKeyEntry = new KeyStore.SecretKeyEntry(mySecretKey);
			      keyStore.setEntry("Aria", secretKeyEntry, protectionParam);

			      //Storing the KeyStore object
			      java.io.FileOutputStream fos = null;
			      fos = new java.io.FileOutputStream("YuiStore");
			      keyStore.store(fos, password);
			      System.out.println("data stored");
			} catch (KeyStoreException | CertificateException | IOException | NoSuchAlgorithmException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	public static void RetrieveKeyStore()
	{		   
		      //Creating the KeyStore object
		      KeyStore keyStore;
			try {
				keyStore = KeyStore.getInstance("JCEKS");
				
				//Loading the KeyStore object
			      char[] password = "pasuwaado".toCharArray();
			      String path = "C:/Program Files/Java/jdk-12.0.1/lib/security/cacerts";  // must change directory
			      java.io.FileInputStream fis = new FileInputStream(path);
			      keyStore.load(fis, password);
			      
			      //Creating the KeyStore.ProtectionParameter object
			      KeyStore.ProtectionParameter protectionParam = new KeyStore.PasswordProtection(password);

			      //Creating SecretKey object
			      SecretKey mySecretKey = new SecretKeySpec("pasuwaado".getBytes(), "RSA");
			      
			      //Creating SecretKeyEntry object
			      KeyStore.SecretKeyEntry secretKeyEntry = new KeyStore.SecretKeyEntry(mySecretKey);			      
			      keyStore.setEntry("Aria", secretKeyEntry, protectionParam);
			      
			      //Creating the KeyStore.SecretKeyEntry object
			      SecretKeyEntry secretKeyEnt = (SecretKeyEntry)keyStore.getEntry("secretKeyAlias", protectionParam);

			      //Creating SecretKey object
			      SecretKey mysecretKey = secretKeyEnt.getSecretKey();
			      
			} catch (KeyStoreException | CertificateException | IOException | NoSuchAlgorithmException | UnrecoverableEntryException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
}
