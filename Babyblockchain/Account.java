package Babyblockchain;

import java.security.KeyPair;
import java.security.PrivateKey;
public class Account{

 private int Player;
KeyPair GameWallet = keyPairs.keys();
String ID = calculateHash();
 
 public void updateBalance(int balance) {
 this.Player =balance;
}
public int getBalance() {
    return Player;
}

public static byte[] signData(PrivateKey key, String msg)  {
	
	return   Signatures.GenerateSignature( msg.getBytes(), key);

}

private  String calculateHash(){
   String value = "";
	try {
		value = hash.hash_sha256(
				GameWallet.getPublic().toString()
					);
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	  return value;
}
 
}