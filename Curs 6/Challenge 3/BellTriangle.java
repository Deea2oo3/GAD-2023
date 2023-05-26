import java.util.Scanner;

public class BellTriangle {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("Enter the number of rows for Bell's triangle: ");
            int n = sc.nextInt();
            int[][] bell = new int[n][n];
            bell[0][0] = 1;
            for (int i = 1; i < n; i++) {
                bell[i][0] = bell[i-1][i-1];
                for (int j = 1; j <= i; j++) {
                    bell[i][j] = bell[i-1][j-1] + bell[i][j-1];
                }
            }
            System.out.println("Bell's triangle:");
            for (int i = 0; i < n; i++) {
                for (int j = 0; j <= i; j++) {
                    System.out.print(bell[i][j] + " ");
                }
                System.out.println();
            }
        }
    }
}