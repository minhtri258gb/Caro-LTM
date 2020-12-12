package ltm.caro.util;

import javax.crypto.*;
import javax.crypto.spec.DESedeKeySpec;
import java.io.UnsupportedEncodingException;
import java.security.*;
import java.security.spec.KeySpec;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;

public class Crypto {
	private PublicKey publicKeyRSA;
	private PrivateKey privateKeyRSA;
	private SecretKey secretKey3DES;


	public Crypto() {
		// Set default
		secretKey3DES = null;

		// generate key RSA
		try {
			// RSA
			/* Doan code generate key, debug r copy value cua String pubKeyStr va priKeyStr
				SecureRandom sr = new SecureRandom();
				KeyPairGenerator kpg = KeyPairGenerator.getInstance("RSA");
				kpg.initialize(1024, sr);
				KeyPair kp = kpg.genKeyPair();
				PublicKey publicKeyRSA = kp.getPublic();
				PrivateKey privateKeyRSA = kp.getPrivate();

				String pubKeyStr = Base64.getEncoder().encodeToString(publicKeyRSA.getEncoded());
				String priKeyStr = Base64.getEncoder().encodeToString(privateKeyRSA.getEncoded());
			*/
			KeyFactory factory = KeyFactory.getInstance("RSA");
			String pubKeyStr = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCFexsPggS1WL2UUTOVhFXZfPHq9Z482Ds/cK2hutCBtV/mRIj8rb/b3D4pMJpwhwIDvgpPYkvd6tj9oqoK4QU0qSjClb+BUQ3ZJkKPkB/h3K7QoRItefasJAkEKvu4HY6JSCtcSUZdH6dsQzvL+l4FaILTTNNEO1LApLaB+EayTQIDAQAB";
			String priKeyStr = "MIICdQIBADANBgkqhkiG9w0BAQEFAASCAl8wggJbAgEAAoGBAIV7Gw+CBLVYvZRRM5WEVdl88er1njzYOz9wraG60IG1X+ZEiPytv9vcPikwmnCHAgO+Ck9iS93q2P2iqgrhBTSpKMKVv4FRDdkmQo+QH+HcrtChEi159qwkCQQq+7gdjolIK1xJRl0fp2xDO8v6XgVogtNM00Q7UsCktoH4RrJNAgMBAAECgYA07rWzd6bwV0mOuIjRQRJeVesFdvOSQ1lzdfaVDSVEWq21/fWo5ioQQQ2xfeGwwAkvfLxP8LYPQeNc6ZWvDL7oJ8+yLCQVhI2YRMvfMoivG+YjEc60bwArHGNkwbGgYsuaA4l6ngqk7qO1PDO1NuyCOEMKwyo9CYIqNxfQB1RXAQJBANffbPFSqzqwUVtRcF4u/ZTAf/n5u8ITvjjaUaw/mClnvadexgB1KrMd/NyNe8TMqaIazx2dIxtCVHa1eq28iQ0CQQCeSvXCyAOjif8dnT8WH/XHfXrcpOC7/PPsAT8WfDII5X1bKZKTWhtaCp+UdLbh/ZUivZsFNayePqmnLCvz4f5BAkA9KUgsd0ecMShbvw8fICEobAHWSTMxIXbblL9fFgV+da3+JZPjvU6DwRNLSaqvb20ASKg1s7emmXxkxbYkUy5hAkACkAochipw6loD+7i6vfe3rBNiIRU2VekJCBgiYA5bUIPQBwNFeW757TQaLi2LyRQyBMnOssjBoxgSCcgIYb9BAkAc0+G1m5enkb3sK0c2OObrz2GQctg3SSbAYdOR7b97t6faHRY0ZS3w6Lozs5nx8f44nOoxG/z1duf2uNlNhlbE";
			byte[] pubKeyHex = Base64.getDecoder().decode(pubKeyStr);
			byte[] priKeyHex = Base64.getDecoder().decode(priKeyStr);
			X509EncodedKeySpec pubSpec = new X509EncodedKeySpec(pubKeyHex);
			PKCS8EncodedKeySpec priSpec = new PKCS8EncodedKeySpec(priKeyHex);
			publicKeyRSA = factory.generatePublic(pubSpec);
			privateKeyRSA = factory.generatePrivate(priSpec);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void generateKey() {
		try {
			// 3DES
			KeyGenerator desEdeGen = KeyGenerator.getInstance("DESede");
			secretKey3DES = desEdeGen.generateKey();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public String getKey() {
		// Sinh key
		generateKey();

		// Ma hoa key
		String keyStr = Base64.getEncoder().encodeToString(secretKey3DES.getEncoded());
		keyStr = encryptRSA(keyStr);

		return keyStr;
	}

	private void setKey(String keyStr) {
		try {
			keyStr = decryptRSA(keyStr); // Giai ma RSA

			KeySpec ks = new DESedeKeySpec(Base64.getDecoder().decode(keyStr));
			SecretKeyFactory skf = SecretKeyFactory.getInstance("DESede");
			secretKey3DES = skf.generateSecret(ks);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private String encryptRSA(String data) {
		String strEncrypt = "";
		try {
			Cipher c = Cipher.getInstance("RSA");
			c.init(Cipher.ENCRYPT_MODE, publicKeyRSA);
			byte encryptOut[] = c.doFinal(data.getBytes());

			strEncrypt = Base64.getEncoder().encodeToString(encryptOut);
		} catch (NoSuchAlgorithmException | NoSuchPaddingException | InvalidKeyException |
				BadPaddingException | IllegalBlockSizeException e) {
			e.printStackTrace();
		}
		return strEncrypt;
	}

	private String decryptRSA(String data) {
		String strDecrypt = "";
		try {
			Cipher c = Cipher.getInstance("RSA");
			c.init(Cipher.DECRYPT_MODE, privateKeyRSA);
			byte decryptOut[] = c.doFinal(Base64.getDecoder().decode(data));
			strDecrypt = new String(decryptOut);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return strDecrypt;
	}

	public String encrypt(String data) {
		if (secretKey3DES == null)
			return "";

		String encryptStr = "";
		try {
			Cipher cipher = Cipher.getInstance("DESede");
			cipher.init(Cipher.ENCRYPT_MODE, secretKey3DES);
			byte[] encrypted = cipher.doFinal(data.getBytes("UTF8"));
			encryptStr = Base64.getEncoder().encodeToString(encrypted);
		} catch (NoSuchAlgorithmException | NoSuchPaddingException | InvalidKeyException |
				UnsupportedEncodingException | IllegalBlockSizeException | BadPaddingException e) {
			e.printStackTrace();
		}
		return encryptStr;
	}

	public String decrypt(String data) {
		if (secretKey3DES == null) {
			setKey(data);
			return "";
		}

		String decryptStr = "";
		try {
			Cipher dcipher = Cipher.getInstance("DESede");
			dcipher.init(Cipher.DECRYPT_MODE, secretKey3DES);
			byte[] decrypted = dcipher.doFinal(Base64.getDecoder().decode(data));
			decryptStr = new String(decrypted);
		} catch (NoSuchAlgorithmException | BadPaddingException | NoSuchPaddingException |
				IllegalBlockSizeException | InvalidKeyException e) {
			e.printStackTrace();
		}
		return decryptStr;
	}

}
