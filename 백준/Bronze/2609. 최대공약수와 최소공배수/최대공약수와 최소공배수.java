import java.util.Scanner;
public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		
		int size = Math.max(N, M);
		int MAX_NM = 0;
		
		for (int i = 1 ; i <= size ; i++) {
			if (N%i==0 && M%i==0) {
				MAX_NM = i;
			}
		}
		
		System.out.println(MAX_NM);
		
		
		while(true) {
			if (size%N==0 && size%M==0) {
				System.out.println(size);
				break;
			}
			size++;
		}
		
	}

}
