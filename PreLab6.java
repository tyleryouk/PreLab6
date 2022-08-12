

public class PreLab6{
  
 
  
  
  
  public static void main(String[] args){
    int[] a = new int[1000];
    for(int i=0; i<1000; i++){
    a[i] = i+1;
    }
    
    //a[0] = 1
    //a[999] = 1000
    
    //sum of all elements with an even index
     int sumEven = 0;
    for(int i=0;i<1000;i++) {
      if(i%2==0)
      sumEven = sumEven+a[i];
    }
    
    //sum of all elements with an odd index
    int sumOdd = 0;
    for(int i=0;i<1000;i++) {
      if(i%2==1)
      sumOdd = sumOdd+a[i];
    }
    
    //System.out.println(a[999]); //test
    System.out.println("Sum even: "+ sumEven);
    System.out.println("Sum odd: " + sumOdd);
    
  }
}
