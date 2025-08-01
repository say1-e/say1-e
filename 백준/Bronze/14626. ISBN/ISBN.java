import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String isbn = sc.nextLine();
		String[] ISBN = isbn.split("");
		
		int sum = 0;
		int n = 0;
		
		for (int i = 0 ; i < 13 ; i++) {
			if (ISBN[i].equals("*")) {
				n = i;
				continue;
			} else {
				if (i%2==0) {
					sum+=Integer.parseInt(ISBN[i]);
				} else {
					sum += Integer.parseInt(ISBN[i])*3;
				}
			}
		}
		
		int m = 0;
		int a = 10-sum%10;
		
		if (n%2==0) {
			m = a;
		} else if (a==3 || a==6 || a==9) {
			m = a/3;
		} else if (a==2 || a==5 || a==8) {
			m = (a+10)/3;
		} else if (a==1 || a==4 || a==7) {
			m = (a+20)/3;
		} else {
			m = 0;
		}
		
		System.out.println(m);
		
		
	}

}
