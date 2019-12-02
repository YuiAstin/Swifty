package BUS;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.*;
import java.security.KeyStore.SecretKeyEntry;
import java.security.cert.CertificateException;
import java.util.Arrays;
import java.util.Base64;

import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;

public class Encryption {
	public static SecretKeySpec secretKey;
    public static byte[] key;
 
    public static void setKey(String myKey) 
    {
        MessageDigest sha = null;
        try {
            key = myKey.getBytes("UTF-8");
            sha = MessageDigest.getInstance("SHA-1");
            key = sha.digest(key);
            key = Arrays.copyOf(key, 16); 
            secretKey = new SecretKeySpec(key, "AES");
        } 
        catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } 
        catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }
 
    public static String Encrypt(String strToEncrypt) 
    {
        try
        {
            setKey("pasuwaado");
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
            cipher.init(Cipher.ENCRYPT_MODE, secretKey);
            return Base64.getEncoder().encodeToString(cipher.doFinal(strToEncrypt.getBytes("UTF-8")));
        } 
        catch (Exception e) 
        {
            System.out.println("Error while encrypting: " + e.toString());
        }
        return null;
    }
 
    public static String Decrypt(String strToDecrypt) 
    {
        try
        {
            setKey("pasuwaado");
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5PADDING");
            cipher.init(Cipher.DECRYPT_MODE, secretKey);
            return new String(cipher.doFinal(Base64.getDecoder().decode(strToDecrypt)));
        } 
        catch (Exception e) 
        {
            System.out.println("Error while decrypting: " + e.toString());
        }
        return null;
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
