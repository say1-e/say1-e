import java.util.Scanner;
public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();
		
		int n = 1;
		int k = 1;
		int nMk = 1;
		for (int i = 1 ; i <= N ; i++) {
			n *= i;
		}
		
		for (int i = 1 ; i <= K ; i++) {
			k *= i;
		}
		
		for (int i = 1 ; i <= N-K ; i++) {
			nMk *= i;
		}
		
		System.out.println(n/(k*nMk));
				
	}

}
