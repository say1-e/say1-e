import java.util.Scanner;
public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		int[] card = new int[N];
		
		for (int i = 0 ; i < N ; i++) {
			card[i] = sc.nextInt();
		}
		
		int min = Integer.MAX_VALUE;
		int result = 0;
		
		for (int i = 0 ; i < N-2 ; i++) {
			for (int j = i+1 ; j < N-1 ; j++) {
				for (int k = j+1 ; k<N ; k++) {
					int sum = card[i]+card[j]+card[k];
					if (M-sum<=min && sum<=M) {
						min = M-sum;
						result = sum;
					}
					
				}
			}
		}

		System.out.println(result);
	}

}
