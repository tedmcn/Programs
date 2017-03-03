import java.util.*;
public class Prob
{
  public static void main(String[] args)
  {
    Scanner console = new Scanner(System.in);
    int num = console.nextInt();
    boolean solution = highLow(num);
    if(solution == true)
    {
      System.out.println("Yes!");
    }else
    {
      System.out.println("No!");
    }
  }
  public static boolean highLow(int num)
  {
    boolean alternate = true;
    while(num>0)
    {
      int digit1 = num%10;
      int digit2 = (num/10)%10;
      if((digit1 >=5 && digit2 <=4)||(digit1 <= 4 && digit2 >=5)||((num/10) == 0))
      {
        alternate = true;
        num/=10;
      }else
      {
        return false;
      }
    }
    return alternate;
  }
}
