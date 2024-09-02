/**
   A program to draw a 5-step staircase
	https://codecheck.io/files/wiley/codecheck-bjlo-1-intro-104
*/

public class Staircase
{
   public static void main(String[] args)
   {
      System.out.println("____");
        for (int i = 0; i < 5; i++) {
            System.out.print("I__");
            for (int j = 0; j < i; j++) {
                System.out.print("___");    
            }
            System.out.println("I___");
        }

   }
}