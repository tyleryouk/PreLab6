//Tyler Youk - Credit Account
public class CreditAccount extends Account {
  
  //fields
  private double iRate;
  private double monthlyPayment = 40.0; //need to pay off $40 monthly, fixed
  private double amountPaid = 0.0;  //amount paid in the month, this should be at least $40 to avoid interest, a 
  //the balance is still what needs to be paid off

  
  //constructors
  //The CreditAccount should have a single constructor that takes 2 inputs: a String that is the account number and a double that is the interest rate.
  CreditAccount(String inputANum, double iR){
    super(inputANum); 
    iRate = iR;
  }
  
  //methods
  //Takes a single double as input and returns nothing. Changes the interest rate for the account to the input value.
  public void setInterestRate(double newI){
    iRate = newI; 
  }
  
  //Takes no input and returns a double. Returns the interest rate for the account.
  public double getInterestRate(){
    return iRate;
  }
  
  //Takes no input and returns a double. Returns the monthly payment amount. 
  //The montly payment is the amount that must be paid this month to avoid receiving an interest charge on the account balance. The monthly payment is different from the balance.
  public double getMonthlyPayment(){
    return monthlyPayment;
  }
  
  //Takes no input and returns a double. Returns the amount that has been credited to the account this month.
  public double getAmountPaidThisMonth(){
    return amountPaid; 
  }
  
  //Takes no input and returns nothing. 
  
  //After checking for an interst charge, 
  public void endOfMonth(){
    boolean iCharge;
    iCharge = (amountPaid < monthlyPayment); //First, the method should see if interest must be charged.
    if(iCharge == true){ //If the amount paid this month is less than the monthly payment
      double interest;
      interest = ((iRate/100)*this.getBalance() / 12.0);  //the account's balance is increased by product of the interest rate and the balance, divided by 12.
      super.charge(interest); //adding interest to balance
    }
    monthlyPayment = this.getBalance();//method should reset the account by setting the monthly payment to be equal to the balance 
    amountPaid = 0.0; //and setting the amount paid this month to zero.
  }
  
  //The credit method in CreditAccount must increase both the account balance and the amount paid this month by the input value.
  public void credit(double cc){
    super.charge(cc);   //increasing the balance.  In a credit account, credit charge will increase the balance.  Term "credit" is opposite for regular accounts.  
    amountPaid = amountPaid + cc; //increase amount paid this month
  }
  
  //other methods - main method for testing
  public static void main(String[] args){
    CreditAccount mars = new CreditAccount("mars", 3.2); //should print account intialized + all starting values
    mars.credit(6.0); //testing new credit method
    System.out.println(mars.getInterestRate()); //should print 3.2
    System.out.println(mars.getMonthlyPayment()); //should print 40.0 //note that we never created a method to set the monthly payment
    System.out.println(mars.getAmountPaidThisMonth()); //should print 6.0
    System.out.println(mars.getBalance()); //should print 6.0
    
    
    System.out.println("test phase2");//testing rest of methods
    //methods that I need to test: setInterestRate(double newI), getInterestRate(), getMonthlyPayment(), getAmountPaidThisMonth(), endOfMonth()
    mars.setInterestRate(4.2);
    System.out.println(mars.getInterestRate()); //should print 4.2 now
    mars.credit(30.0);
    System.out.println(mars.getBalance()); //should print 36.0 
    System.out.println(mars.getAmountPaidThisMonth()); //should print 36.0
    mars.endOfMonth();
    System.out.println(mars.getBalance()); //should print 36.126 (36.0 + ((.042*36.0)/12))
    System.out.println(mars.getMonthlyPayment()); //should print 36.126
    System.out.println(mars.getAmountPaidThisMonth()); //should print 0.0
    
    //tested all methods
  }
  
}
