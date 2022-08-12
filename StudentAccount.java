//Tyler Youk - Student Account
public class StudentAccount extends Account {
  
  //fields
    private String name = "";
    private String address = "";
    LibraryAccount studentLibraryAccount; //initalize in set 
    CreditAccount studentTuitionAccount; //initalize in set 
    CreditAccount studentDiningAccount; //initalize in set
    
    private double refundAmount = 0.0;
    
  //constructors
  //The StudentAccount should have a single constructor that takes two String values as input. The first is the account number and the second is the account owner's name.
    public StudentAccount(String in1, String in2){
      super(in1);
      name = in2;
    }
      
  //methods
  //Takes a single input that is a String value and returns nothing. Changes the account owner's name to the input value.
  public void setName(String n){
     name = n;
  }
  
  //Takes no input and returns a String value. Returns the account owner's name.
  public String getName(){
    return name; 
  }

  //Takes a single input that is a String value and returns nothing. Changes the account owner's address to the input value.
  public void setAddress(String a){
     address = a;
  }

  //Takes no input and returns a String value. Returns the account owner's address.
  public String getAddress(){
    return address; 
  }

  //Takes a single input that is a LibraryAccount value and returns nothing. 
  //Changes the library account associated with this account to the input value. 
  //There does not have to be a library account associated with this account so the input value may be null.
  public void setLibraryAccount(LibraryAccount a){
     a = new LibraryAccount(""); //initalizing library account
     studentLibraryAccount = a;
  }

   //Takes no input and returns a LibraryAccount value. Returns the library account associated with this account.
  public LibraryAccount getLibraryAccount(){
    return studentLibraryAccount;
  }

   //Takes a single input that is a CreditAccount value and returns nothing. 
   //Changes the tuition account associated with this account to the input value. There does not have to be a tuition account associated with this account so the input value may be null.
  public void setTuitionAccount(CreditAccount c){
    c = new CreditAccount("", 0); //initalizing Tuition account
    studentTuitionAccount = c;
  }
   
   //Takes no input and returns a CreditAccount value. Returns the tuition account associated with this account.
  public CreditAccount getTuitionAccount(){
    return studentTuitionAccount; 
  }

  //Takes a single input that is a CreditAccount value and returns nothing
  //Changes the dining account associated with this account to the input value. There does not have to be a dining account associated with this account so the input value may be null.
  public void setDiningAccount(CreditAccount d){
    d = new CreditAccount("", 0); //initaliziing dining account
    studentDiningAccount = d;
  }
  
  //Takes no input and returns a CreditAccount value. Returns the dining account associated with this account.
  public CreditAccount getDiningAccount(){
    return studentDiningAccount; 
  }
  
  //getBalance: the getBalance method of StudentAccount should sum the balances of the library account, tuition account, and dining account that are associated with this account (if those accounts exist).
  // The method should then subtract the account's refund amount from this sum and return that value.
  public double getBalance(){
    double sBalance = 0.0;
    boolean notNullL = (studentLibraryAccount != null);
    boolean notNullT = (studentTuitionAccount != null);
    boolean notNullD = (studentDiningAccount != null);
      if(notNullL == true) {
      sBalance = sBalance + studentLibraryAccount.getBalance();
      }
      if(notNullT == true){
      sBalance = sBalance + studentTuitionAccount.getBalance();
      } 
      if(notNullD == true){
      sBalance = sBalance + studentDiningAccount.getBalance();  
      }
    sBalance = sBalance - refundAmount;
    return sBalance;
     
  }
  
  
  //first subtract the input amount by the accounts's refund amount. 
  //If this difference is positive and the tuition account exists, the tuition account's balance should be increased by the difference. 
  //Otherwise, the account's refund amount should be set to the negation of this difference.
  public void charge(double c){
      double difference = c - refundAmount; //subtract the input amount by the account's refund amount
      //positive = charge is greater, negative = charge is less than refund
      
      if(difference >= 0 && (studentTuitionAccount != null)){ //if charge is greater than refund amount, charge adds to tuition account balance
        studentTuitionAccount.credit(difference); //tuition account's balance should be increased by the refund amount left
                                                  //tuition account balance represents how much tuition needs to be paid off
      }  else { //if refund amount can pay it, then use refund amount
      refundAmount = -(difference); //same thing as refundAmount - c
     }
    
  }
  
  //credit: the credit method of StudentAccount processes a payment to the student account,
  //and the payment should be used to decrease the balances of the associated accounts in the following order:
  // tuition, dining, library (if they exist). That is, you first apply the payment to reduce the tuition account balance.
  //If there is any money left after reducing the tuition account, you reduce the dining account balance next and then the library account balance.
  // If after reducing each existing account there is money left over, it should be added to the student account's refund amount. 
  //The total amount you apply to the associated accounts' balances should not exceed the input to this method.
  public void credit(double c){
    while(c > 0){
      double payableTuition = (studentTuitionAccount.getMonthlyPayment() - studentTuitionAccount.getAmountPaidThisMonth()); //amount that can be paid by credit
      if((studentTuitionAccount != null) && payableTuition >= c){ //filling student Tuition account first
          studentTuitionAccount.credit(c); //In Credit account, credit() increases, increase balance and amountPaid, balance needs to increase until it equals monthly payment
          c = 0; //credit fulfills Tuition account, credit is added to balance and amountPaid, which are both still under the monthly payment. 
      }  else if((studentTuitionAccount != null) && (payableTuition < c)){ //some left over
          c = c - payableTuition; //c is now reducted by payale tuition
          studentTuitionAccount.credit(payableTuition); //balance and amountPaid will be increased so that it equals monthly payment (paid off tuition)
      }
      
       //going on to fill dining with rest of c
      double payableDining = (studentDiningAccount.getMonthlyPayment() - studentDiningAccount.getAmountPaidThisMonth()); 
      if((studentDiningAccount != null) && payableDining >= c){ 
          studentDiningAccount.credit(c); 
          c = 0;
      }  else if((studentDiningAccount != null) && (payableDining < c)){ //some left over
          c = c - payableDining; 
          studentDiningAccount.credit(payableDining); //balance and amountPaid will be increased so that it equals monthly payment (paid off Dining)
      }
      
      //going to fill Library with rest of c
      //Library account is different in that the balance reflects how much should be paid off
      double payableLibrary = (studentLibraryAccount.getBalance()); 
      if((studentLibraryAccount != null) && payableLibrary >= c){ 
          studentLibraryAccount.credit(c); //will use all of c to decrease balance
          c = 0;
      }  else if((studentLibraryAccount != null) && (payableLibrary < c)){ //some left over
          c = c - payableLibrary; 
          studentLibraryAccount.credit(payableLibrary); //all of Library balance will be paid off
      }
     //end of while loop, still some c left over.//going to add c to refund amount so it doesn't just dissapear
      refundAmount = refundAmount + c;
      break;
    } 
  }

  //For the tuition and dining accounts, the account's balance should only be decreased(*increased) until the account's amount paid this month equals the monthly payment.
  //For the library account, the account's balance should not be reduced below zero.
  
  //other methods - main method to test
  public static void main(String[] args){
     StudentAccount kobe = new StudentAccount("k2022", "kob"); //should print account initalized + starting values
     System.out.println(kobe.getName()); //should print kob
     kobe.setName("kobe");
     System.out.println(kobe.getName()); //should print kobe
     kobe.setAddress("22384 Hessler");
     System.out.println(kobe.getAddress()); //should print 22384 Hessler
     System.out.println(kobe.getLibraryAccount()); //should print null
     LibraryAccount kLib = new LibraryAccount("k2022L",4, 4.2, 5.2) ; //should print account initalized + starting values (6x)
     kobe.setLibraryAccount(kLib); 
     CreditAccount kTuition = new CreditAccount("k2022T",6.2);
     kobe.setTuitionAccount(kTuition);
     CreditAccount kDining = new CreditAccount("k2022D",6.2);
     kobe.setDiningAccount(kDining);
     //accounts all initialized
     
     //dividor
     System.out.println(" ");
     System.out.println("DIVIDOR, setting balances and testing charge");
     System.out.println(kobe.getBalance()); //should print 0.0
     kobe.studentTuitionAccount.credit(10.2); //Tuition account - credit increases balance, this is the balance that has been paid which needs to equal monthly payment
     kobe.studentDiningAccount.credit(2.4); //Dining account - credit increases balance, this is the balance that has been paid which needs to equal monthly payment
     kobe.studentLibraryAccount.charge(8.8); //library account - charge increases balance, this is the balance that needs to be paid off
     System.out.println(kobe.getBalance()); //should print 21.4
     System.out.println(kobe.refundAmount); //should print 0.0
     kobe.charge(12.4);
     System.out.println(kobe.getBalance()); //should print 33.8 (balance increased by 12.4, not affected by refundAmount
     System.out.println(kobe.refundAmount); //should print 0.0
     kobe.refundAmount = 18.0;
     kobe.charge(13.4);
     System.out.println(kobe.getBalance()); //should print 29.2 (Real balance is still 33.8, but now incorperating refundAmount so printing balance of 33.8 - 4.6)
     System.out.println(kobe.refundAmount); //should print 4.6 (4.6 refund amount left over after 13.4 charge)
     
     //dividor
     System.out.println(" ");
     System.out.println("DIVIDOR, testing credit");
     System.out.print("Starting Tuition Balance:" + kobe.studentTuitionAccount.getBalance()); 
     System.out.print(" Starting Dining Balance:" + kobe.studentDiningAccount.getBalance()); 
     System.out.print(" Starting Library Balance:" + kobe.studentLibraryAccount.getBalance()); 
     System.out.println(" Starting Refund Balance:" +kobe.refundAmount);   //should print 22.6, 2.4, 8.8 (know this is right because all added up = 33.8), 4.6
     //note that monthly payment is still set to 40.0
     System.out.print("Monthly Payments:" + kobe.studentTuitionAccount.getMonthlyPayment()); 
     System.out.println(" " +kobe.studentDiningAccount.getMonthlyPayment()); //should print 40.0 40.0
     kobe.credit(2.2);
     System.out.println("New Tuition Balance: " +kobe.studentTuitionAccount.getBalance()); //should print 24.8 (22.6 + 2.2 = 24.8)
     kobe.credit(18.4);
     System.out.print("New Tuition Balance:" +kobe.studentTuitionAccount.getBalance()); 
     System.out.print(" New Dining Balance:" +kobe.studentDiningAccount.getBalance()); 
     System.out.print(" New Library Balance:" +kobe.studentLibraryAccount.getBalance()); 
     System.out.println(" New Refund Balance:" +kobe.refundAmount); //should print 40.0 (maxed at Monthly), 5.6 (rest 3.2 to dining, 3.2+2.4 + 5.6), 8.8 (stays the same), 4.6 (stays the same)
     System.out.println("Final run");
     kobe.credit(34.4 + 8); //34.4 covers dining, Library from 8.8 to .8
     kobe.credit(2.8); //Library from .8 to 0, refund amount increases by 2 (two different credits to ensure that leftover credit functionality works)
     System.out.print("Final Tuition Balance:" + kobe.studentTuitionAccount.getBalance()); 
     System.out.print(" Final Dining Balance:" + kobe.studentDiningAccount.getBalance()); 
     System.out.print(" Final Library Balance:" + kobe.studentLibraryAccount.getBalance()); 
     System.out.println(" Final Refund Balance:" + kobe.refundAmount); //should print 40.0 (maxed at Monthly), 40.0 (maxed at Monthly), 0.0 balance paid off, 6.6 (2+4.6)
     
  }
  
}
