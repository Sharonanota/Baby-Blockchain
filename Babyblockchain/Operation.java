package Babyblockchain;
import java.security.PublicKey;


public class Operation{
	public Account sender;  
	public Account recipients; 
	public int Player; 
	public byte[] signature; 
	PublicKey pubkey ;
	PublicKey candPubkey;
	byte[] msg;
	 
	public Operation(Account Player, Account candidate, int Play,  byte[] signature) {
		this.sender = Player;
		this.recipients =candidate;
		this.Player = Play;
		this.signature = signature;
        this.msg = Player.ID.getBytes();
		this.candPubkey=candidate.GameWallet.getPublic();
		this.pubkey=Player.GameWallet.getPublic();
		
	}
	 

   public Operation createOperation(){
    if(!verifyOperation() == true){
    
	System.out.println("Operation failed");
   

	return null;

	}else{
       
	  int remainder=	sender.getBalance() -Player;
	  recipients.updateBalance(Player);
	  sender.updateBalance(remainder);
      Operation output = new Operation(this.sender, this.recipients, Player, signature);
      
	  System.out.println(output);

		return output;

	}
	
   }
//    verification
	public boolean verifyOperation() {
		boolean verify = Signatures.VerifySignature(msg, signature, pubkey);
		if(verify==false){
         System.out.println("verification failed, cannot Play!!");
          return false;
		}
		if(sender.getBalance() <1 || sender.getBalance()>1){
          System.out.println("Invalid account value");
		  System.out.println(sender.getBalance() );
		  return false;
		}
		if(Player<1 || Player>1){
			System.out.println("You fail");
			return false;
		}
		return true;

}
}
