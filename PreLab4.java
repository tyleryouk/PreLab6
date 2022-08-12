/**
 * Auto Generated Java Class.
 */
public class PreLab4 {
  
  //Create a method called compareValues that returns a String, and takes two parameters x and y, both of type int. 
  //The body of your method should be a large comparison statement that does the following.
  
  //If x is larger than y, it should return the string "x is larger than y" with x and y in the string replaced with the values of x and y. (Recall the operator for String concatenation.)
  //If y is larger than x, it should return the string "y is larger than x", again with x and y replaced by the values of x and y.
  //Finally, of x and y have the same value, it should return the string "the two values are equal"
  //Test your code by calling compareValues three times, once with x larger than y, once with y larger than x, and once with the values the same to verify that you get the correct response each time.
  public String compareValues(int x, int y){
    if(x > y){
      return(x+" is larger than "+y);
    } 
    else if(y > x ){
      return(y+" is larger than "+x);
    }
    else {
      return("the two values are equal");
    }
    //return("Cash");
    //returns a String
  }
  
}
