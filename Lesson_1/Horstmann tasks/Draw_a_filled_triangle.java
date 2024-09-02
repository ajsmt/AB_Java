/** 
   A program to draw a filled triangle.
	https://codecheck.io/files/wiley/codecheck-bjlo-1-intro-103	
*/

public class Triangle {
    public static void main(String[] args) {
        for (int i = 1; i <= 4; i++) {
            for (int j = 4 - i; j > 0; j--) {
                System.out.print(" ");
            }
            for (int k = 1; k <= 2 * i - 1; k++) {
                System.out.print("x");
            }
            System.out.println();
        }
    }
}