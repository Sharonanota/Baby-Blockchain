package Babyblockchain;

import java.util.ArrayList;

public class Transaction{
	public String ID;  
	static public  int nonce;
	ArrayList <Operation> operations = new  ArrayList<Operation>();
	Operation operation;
	 
	public Transaction createTransaction(  ) {
		nonce=0;
		if(operation == null ) {
			 System.out.println("Null operation object");
				return null;
		 
		} else{
        nonce++;
		 operations.add(operation);
		 Transaction transaction =new Transaction();
		 ID= hash.hash_sha256( Integer.toString(nonce) + operation.pubkey.toString()+operation.candPubkey.toString()+ Integer.toString(operation.Player) );
			return transaction;
		}
		 
	
	}
}