




import java.security.KeyPair;
import java.security.PrivateKey;
public class Account{

 private int Game;
KeyPair GameWallet = keyPairs.keys();
String ID = calculateHash();
 
 public void updateBalance(int balance) {
 this.Game =balance;
}
public int getBalance() {
    return Game;
}

public static byte[] signData(PrivateKey key, String msg) {
	
 return Signatures.GenerateSignature( msg.getBytes(), key);

}

private String calculateHash(){
   String value = "";
 try {
  value = Hash.hash_sha256(
    GameWallet.getPublic().toString()
     );
 } catch (Exception e) {
  
  e.printStackTrace();
 }
   return value;
}
 
}