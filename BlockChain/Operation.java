

import java.security.PublicKey;

public class Operation{
 public Account sender;  
 public Account reciepient; 
 public int Game; 
 public byte[] signature; 
 PublicKey pubkey ;
 PublicKey candPubkey;
 byte[] msg;
  
 public Operation(Account Player, Account candidate, int Game, byte[] signature) {
  this.sender = Player;
  this.reciepient =candidate;
  this.Game = Game;
  this.signature = signature;
        this.msg = Player.ID.getBytes();
  this.candPubkey=candidate.GameWallet.getPublic();
  this.pubkey=Player.GameWallet.getPublic();
  
 }
  
 // in the main java method we will create a signature using Players 
 //privatekey and also we will set the value of the Player to 1 for testing 

   public Operation createOperation(){
    if(!verifyOperation() == true){
    
 System.out.println("Operation failed");
   

 return null;

 }else{
       
   int remainder= sender.getBalance() -Game;
   reciepient.updateBalance(Game);
   sender.updateBalance(remainder);
      Operation output = new Operation(this.sender, this.reciepient, Game, signature);
      
   System.out.println(output);

  return output;

 }
	
   }
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
  if(Game<1 || Game>1){
   System.out.println("Invalid Player");
   return false;
  }
  return true;

}
}