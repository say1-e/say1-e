import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int L = sc.nextInt();
		
		sc.nextLine();
		
		String engList = sc.nextLine();
		
		
		long sum = 0;
		long r = 1;
		long mod = 1234567891;
		
		for (int i = 0 ; i < L ; i++) {
			int value = engList.charAt(i) - 'a' +1;
			sum = (sum + (value * r) % mod) % mod;
			r = (r*31) % mod;
			
		}
		
		System.out.println(sum);
		
		
	}

}
