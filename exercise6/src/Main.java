import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.GCMParameterSpec;
import java.security.*;
import java.util.Base64;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws Exception {
        KeyGenerator keyGen = KeyGenerator.getInstance("AES");
        keyGen.init(256);
        SecretKey aesKey = keyGen.generateKey();

        Cipher aesCipher = Cipher.getInstance("AES/GCM/NoPadding");
        byte[] iv = new byte[12];
        SecureRandom random = new SecureRandom();
        random.nextBytes(iv);
        GCMParameterSpec gcmSpec = new GCMParameterSpec(128, iv);
        aesCipher.init(Cipher.ENCRYPT_MODE, aesKey, gcmSpec);
        String message = "Hello Bob!";
        byte[] encryptedMessage = aesCipher.doFinal(message.getBytes());
        System.out.println("Encrypted Message: " + Base64.getEncoder().encodeToString(encryptedMessage));
        aesCipher.init(Cipher.DECRYPT_MODE, aesKey, gcmSpec);
        byte[] decryptedMessage = aesCipher.doFinal(encryptedMessage);
        System.out.println("Decrypted Message: " + new String(decryptedMessage));
        KeyPairGenerator rsaKeyGen = KeyPairGenerator.getInstance("RSA");
        rsaKeyGen.initialize(2048);
        KeyPair aliceKeyPair = rsaKeyGen.generateKeyPair();
        KeyPair bobKeyPair = rsaKeyGen.generateKeyPair();
        Cipher rsaCipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
        rsaCipher.init(Cipher.ENCRYPT_MODE, bobKeyPair.getPublic());
        byte[] rsaEncryptedMessage = rsaCipher.doFinal(message.getBytes());
        System.out.println("RSA Encrypted Message: " + Base64.getEncoder().encodeToString(rsaEncryptedMessage));
        rsaCipher.init(Cipher.DECRYPT_MODE, bobKeyPair.getPrivate());
        byte[] rsaDecryptedMessage = rsaCipher.doFinal(rsaEncryptedMessage);
        System.out.println("RSA Decrypted Message: " + new String(rsaDecryptedMessage));
        Signature rsaSignature = Signature.getInstance("SHA256withRSA");
        rsaSignature.initSign(aliceKeyPair.getPrivate());
        rsaSignature.update(message.getBytes());
        byte[] signature = rsaSignature.sign();
        System.out.println("Signature: " + Base64.getEncoder().encodeToString(signature));
        rsaSignature.initVerify(aliceKeyPair.getPublic());
        rsaSignature.update(message.getBytes());
        boolean isVerified = rsaSignature.verify(signature);
        System.out.println("Signature Verified: " + isVerified);
    }
}