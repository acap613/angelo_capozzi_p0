package com.revature.hobbycon.jasypt;

import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;

public class JasyptTest {

	public void jasyptTest() {
		String text = "HelloWorld";
		
		String seed = "seed";
		 
		StandardPBEStringEncryptor  encryptor = new StandardPBEStringEncryptor();
		
		encryptor.setPassword(seed);
		
		String encrypted = encryptor.encrypt(text);
		
		System.out.println("Encrypted Password: " + encrypted);
		
		String decrypted = encryptor.decrypt(encrypted);
		
		System.out.println("Decrypted Password: " + decrypted);
		
	}
}
