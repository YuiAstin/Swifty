package BUS;

import java.security.*;

import javax.crypto.*;

public class Encryption {
	static public String Encrypt(String data)
	{
		try {
			Signature sign = Signature.getInstance("SHA256withRSA");
			KeyPairGenerator keygen = KeyPairGenerator.getInstance("DSA");
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
			Signature sign = Signature.getInstance("SHA256withRSA");
			KeyPairGenerator keygen = KeyPairGenerator.getInstance("DSA");
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
}
