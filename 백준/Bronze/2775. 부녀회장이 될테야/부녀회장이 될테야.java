import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for (int t = 0 ; t < T ; t++) {
			int k = sc.nextInt();
			int n = sc.nextInt();
			int[][] apt = new int[k+1][n];
			
			for (int i = 0 ; i < n ; i++) {
				for (int j = 0 ; j < k+1 ; j++) {
					apt[j][0]=1;
					apt[0][i]=i+1;
				}
			}
			
			for (int j = 1 ; j < k+1 ; j++) {
				for (int i = 1 ; i < n ; i++) {
					int sum = 0;
					for (int h = 0 ; h <= i ; h++) {
						sum += apt[j-1][h];
					}
					apt[j][i] = sum;
				}
			}
			
			System.out.println(apt[k][n-1]);
			
		}
		
	}

}
