package AesProject_1;
import java.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.xml.bind.DatatypeConverter;
public class aesalgorithm {
	
public SecretKey keyGenrate() throws Exception
{
	KeyGenerator generator = KeyGenerator.getInstance("AES");
	generator.init(128);
	SecretKey sec = generator.generateKey();
	//System.out.println(sec);
	return sec;
}
public String encryptor(String msg , SecretKey sec) throws Exception
{Cipher c= Cipher.getInstance("AES");
c.init(Cipher.ENCRYPT_MODE, sec);
	byte[] encryptedText = c.doFinal(msg.getBytes("UTF-8"));
	String mama=Base64.getEncoder().encodeToString(encryptedText);
return mama;
}
public byte[] decryptor(byte[] decryptVal , SecretKey sec) throws Exception
{
	Cipher c = Cipher.getInstance("AES");
	c.init(Cipher.DECRYPT_MODE, sec);
	// byte[] decryptVal = Base64.getDecoder().decode(code);
	byte[] decryptedText= c.doFinal(decryptVal);
	return decryptedText;
}
public String  bytesToHex(byte[] hash) {
        return DatatypeConverter.printHexBinary(hash);
    }
/*public static void main(String args[])throws Exception
{
	aesalgorithm dd = new aesalgorithm();
	SecretKey kaka=dd.keyGenrate();
	System.out.println(kaka);
}*/
}
