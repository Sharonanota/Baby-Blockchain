
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.Signature;
public class Signatures {
   

     
    public static  byte[] GenerateSignature(
        byte[] input,
       PrivateKey key )
        
    {
    	byte[] signVal = new byte[0];
        Signature signature;
		try {
			signature = Signature.getInstance(
            		"SHA256withRSA");
			  signature.initSign( key);
		        signature.update(input);
		        signVal=    signature.sign();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e);
		} 
		return signVal;
      
    }
  
  
   
 
    public static boolean VerifySignature(
        byte[] input,
        byte[] signatureToVerify,
       PublicKey key)
        
    {
      
        Signature signature;
		try {
			signature = Signature.getInstance(
            		"SHA256withRSA");
			   signature.initVerify( key);
		        signature.update(input);
		    return signature
		            .verify(signatureToVerify);
		} catch ( Exception e) {
			throw new RuntimeException(e);
		}

     
    }
   
}