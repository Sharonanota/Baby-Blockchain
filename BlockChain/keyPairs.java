

import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SecureRandom;

public class keyPairs{
    PublicKey publicKey ;
    PrivateKey privKey ;
   public static KeyPair keys() {
    SecureRandom secureRandom
    = new SecureRandom();
    KeyPair pair = null;
      KeyPairGenerator keyPairGen;
      try {
        keyPairGen = KeyPairGenerator.getInstance("RSA");
        keyPairGen.initialize(2048, secureRandom);  
         pair = keyPairGen.generateKeyPair();
      } catch (NoSuchAlgorithmException e) {
 
        e.printStackTrace();
      }
      
     return pair;
   } 
}