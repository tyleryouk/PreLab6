/**
 * Auto Generated Java Class.
 */
public class PreLab5 {
  
  //Write a while loop that computes the sum of the first 10 positive integers.
  //Write a for loop that computes the sum the first 10 positive integers.
  
  //For each loop, you should use two variables. One that runs through the first 10 positive integers, and one that stores the result of the computation.
   //To test your code, what is the sum of the first 10 positive integers?
  public static void main(String[] args){
  
  int place = 0;
  int sum = 0;
  System.out.println(sum); //for testing
  boolean whileY = false; //true = while loop, false = for loop
  
  if(whileY == true){
      while(place < 10){
       sum = sum + place;
       place++;
      }
   }
   
  
  if(whileY == false){
      for(int p = 0; p < 10; p++){
       sum = sum + p;
      }
    }
    //both should return the same sum of (0+1+2+3+4+5+6+7+8+9) = 45  //test by pluggin true/fasle for whileY
    System.out.println(sum);
    sum = 0;
  }
  //works with both whileY = true and whileY = false
  
}
