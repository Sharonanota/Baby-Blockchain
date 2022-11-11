package Babyblockchain;


import java.security.KeyPair;
import java.security.PrivateKey;
public class Account{

 private int vote;

  KeyPair GameWallet= keyPairs.keys() ;
   public Account(KeyPair gameWallet) {
    // GameWallet = gameWallet;
}
public Account() {
}
String ID = calculateHash();
 
 public void updateBalance(int balance) {
 this.vote =balance;
}
public int getBalance() {
    return vote;
}

public static byte[] signData(PrivateKey key, String msg)  {
	
	return Signatures.GenerateSignature( msg.getBytes(), key);

}
private  String calculateHash() {
	 
	return hash.hash_sha256(
			GameWallet.getPublic().toString()
				);
	  
}
 
}