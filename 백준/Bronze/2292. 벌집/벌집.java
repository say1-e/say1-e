import java.util.Scanner;
public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int room = 1;
		int x = 1;
		
		while (x < N) {
			x += room*6;
			room++;
		}
		
		System.out.println(room);
	}

}
