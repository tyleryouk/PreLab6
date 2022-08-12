//Tyler Youk

import java.lang.*;

public class Lab4 {
  
  /** Input two doubles and return the larger of the two doubles. */
  public static double maxDouble(double o, double t){
    if(o > t){
      return o;
    }  
    else if(o == t){
       return o; //doesn't matter which we return, both are the same value
    }
    else{
       return t;
    }
  }

  /** Input three doubles and return the middle value of the three. */
  public static double middleValue(double o, double t, double th){
    double mValue = 0.0;
    if(o >= t && o <= th || o <= t && o >= th){
      mValue = o; 
    }
    else if(t >= o && t <= th || t <= o && t >= th){
      mValue = t;
    }
    else if(th >= o && th <= t || th <= o && th >= t){
      mValue = th; 
    }
    return mValue;
  }
  
    /** Input a double value and return the closest int value.  The int value should be rounded
    * so that if the fractional value is 0.5 or greater, it rounds up and if it is less than 0.5
    * it rounds down.
    */
  public static int roundDouble(double x){
     int rounded = (int)Math.round(x);
     return rounded;
  }
  
  //main method for testing
    public static void main(String args[]){
      Lab4 tester = new Lab4();
      System.out.println(Lab4.maxDouble(4.3, 3.8)); //should print 4.3
      System.out.println(Lab4.middleValue(2.4, 3.9, 4.6)); //should print 3.9
      System.out.println(Lab4.roundDouble(2.2)); //should print 2
      System.out.println(Lab4.roundDouble(5.5)); //should print 6
   }
  
 
}
