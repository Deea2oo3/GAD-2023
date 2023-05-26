import java.util.Scanner;

public class PascalTriangle {
    public static void main(String[] args) {
        try (Scanner input = new Scanner(System.in)) {
            System.out.print("Enter the number of rows: ");
            int numRows = input.nextInt();
            
            // initialize the first two rows
            int[][] triangle = new int[numRows][];
            triangle[0] = new int[] {1};
            triangle[1] = new int[] {1, 1};
            
            // calculate the rest of the rows
            for (int i = 2; i < numRows; i++) {
                triangle[i] = new int[i+1];
                triangle[i][0] = 1;
                triangle[i][i] = 1;
                for (int j = 1; j < i; j++) {
                    triangle[i][j] = triangle[i-1][j-1] + triangle[i-1][j];
                }
            }
            
            // print the triangle
            for (int i = 0; i < numRows; i++) {
                for (int j = 0; j <= i; j++) {
                    System.out.print(triangle[i][j] + " ");
                }
                System.out.println();
            }
        }
    }
}
