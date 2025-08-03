import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		sc.nextLine();
		
		String[][] list = new String[N][2];
		
		for (int i = 0 ; i < N ; i++) {
			String[] input = sc.nextLine().split(" ");
			list[i][0] = input[0];
			list[i][1] = input[1];
		}
		
		Arrays.sort(list, (a,b)-> Integer.parseInt(a[0]) - Integer.parseInt(b[0]));
		
		
		for (int i = 0 ; i < N ; i++) {
			System.out.printf("%s %s",list[i][0],list[i][1]);
			System.out.println();
		}
		
		
	}

}
