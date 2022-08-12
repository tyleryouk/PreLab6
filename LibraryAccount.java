//Tyler Youk - Library Account Class
//Records whether the patron has any overdue material and how much money, in fines, has been assessed to the patron
public class LibraryAccount extends Account {
  
  //fields
  private double bFineSize = 0.0; //book fine
  private double iFineSize = 0.0; //items fine
  private int numBooksOverdue = 0;
  private int numItemsOverdue = 0;
  
  //constructors
  //the first constructor takes a single String input that is the account number.
  LibraryAccount(String inputANum){
    super(inputANum); 
  }
  
  //the second constructor takes four inputs: a String that is the account number, an int that is the balance limit, a double that is the book fine, and a double that is the reserved items fine. 
  LibraryAccount(String inputANum, int inputBLim, double inputBFine, double inputIFine){
    super(inputANum, inputBLim); 
    bFineSize = inputBFine;
    iFineSize = inputIFine;
  }
 
  //methods
  //Takes a single double value as input and returns nothing. The input value will be the size of the fine that is assessed each day a book is overdue.
  public void setBookFine(double s){
     bFineSize = s;
  }
  
  //Takes no input and returns a double. Returns the amount that will be fined for each day a book is overdue.
  public double getBookFine(){
    return bFineSize; 
  }
  
  //Takes a single double value as input and returns nothing. The input value will be the size of the fine that is assessed each day a reserved item is overdue.
  public void setReserveFine(double rF){
     iFineSize = rF;
  }
  //Takes no input and returns a double. Returns the amount that will be fined for each day a reserved item is overdue.
  public double getReserveFine(){
    return iFineSize; 
  }
  
  //Takes no input and returns nothing. Increases by one the number of overdue books on the account.
  public void incrementOverdueBooks(){
    numBooksOverdue++;
  }
  //Takes no input and returns nothing. Decreases by one the number of overdue books on the account. Does not decrease the count below zero.
  public void decrementOverdueBooks(){
    numBooksOverdue--;
  }
  
  //Takes no input and returns an int. Returns the number of overdue books on the account.
  public int getNumberOverdueBooks(){
    return numBooksOverdue; 
  }
  
  //Takes no input and returns nothing. Increases by one the number of overdue reserved items on the account.
  public void incrementOverdueReserve(){
    numItemsOverdue++;
  }
  
  //Takes no input and returns nothing. Decreases by one the number of overdue reserved items on the account. Does not decrease the count below zero.
  public void decrementOverdueReserve(){
    numItemsOverdue--;
  }
  //Takes no input and returns an int. Returns the number of overdue reserved items on the account.
  public int getNumberOverdueReserve(){
    return numItemsOverdue;
  }
  
  //Takes no input and returns a boolean. Returns true if the account's balance is equal or less than the account's balance limit. Returns false otherwise.
  public boolean canBorrow(){
    if(this.getBalance() <= this.getBalanceLimit()){
      return true;
    } else {
       return false; 
      }
  }
  
  //Takes no input and returns nothing. Increases the account's balance by the product of the number of overdue books and the book fine, 
                                        //and increases the account's balance by the product of the number of overdue reserved items and the reserved items fine.
  public void endOfDay(){
    double feesB;
    double feesI;
    feesB = ((double)this.getNumberOverdueBooks() * this.getBookFine());
    feesI = ((double)this.getNumberOverdueReserve() * this.getReserveFine());
    this.charge(feesB);
    this.charge(feesI);
  }
  
  
  //other methods - main method for testing
  public static void main(String[] args){
    LibraryAccount cornbread = new LibraryAccount("Cornbread"); //should print account intialized + all starting values
    /*going to pick up fees and call end of day, make sure to test the following
      setBookFine(double), getBookFine(), setReserveFine(double), getReserveFine(), incrementOverdueBooks(), decrementOverdueBooks(), getNumberOverdueBooks()
      incrementOverdueReserve(), decrementOverdueReserve(), getNumberOverdueReserve(), canBorrow(), endOfDay()*/
    System.out.println(cornbread.getBalance()); //should print 0.0 
    cornbread.setBookFine(3.4);
    System.out.println(cornbread.getBookFine()); //should print 3.4
    cornbread.setReserveFine(2.8);
    System.out.println(cornbread.getReserveFine()); //should print 2.8
    for(int i = 0; i < 4; i++){
    cornbread.incrementOverdueBooks();
    }
    System.out.println(cornbread.getNumberOverdueBooks()); //should print 4
    cornbread.decrementOverdueBooks();
    System.out.println(cornbread.getNumberOverdueBooks()); //should print 3
    for(int i = 0; i < 6; i++){
    cornbread.incrementOverdueReserve();
    }
    System.out.println(cornbread.getNumberOverdueReserve()); //should print 6
    cornbread.decrementOverdueReserve();
    System.out.println(cornbread.getNumberOverdueReserve()); //should print 5
    System.out.println(cornbread.canBorrow()); //should print true
    cornbread.setBalanceLimit(3);
    cornbread.endOfDay();
    System.out.println(cornbread.getBalance()); //should print 24.2 (3.4*3 + 2.8*5)
    System.out.println(cornbread.getBalanceLimit()); //should print 3.0
    System.out.println(cornbread.canBorrow()); //should print false

            //by simply running end of day, we can knock out all other methods
    
    //simple test for 4 arguement constructor
    System.out.println("test2"); 
    LibraryAccount cornbread2 = new LibraryAccount("Cornbread2",8 ,10.2 ,12.4);  //should print account intialized + all starting values
    System.out.println(cornbread2.getBalanceLimit()); //should print 8.0
    System.out.println(cornbread2.getBookFine()); //should print 10.2
    System.out.println(cornbread2.getReserveFine()); //should print 12.4
  }
}
