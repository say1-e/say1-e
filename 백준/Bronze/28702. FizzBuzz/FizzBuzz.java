import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String[] arr = new String[3];
		arr[0] = sc.nextLine();
		arr[1] = sc.nextLine();
		arr[2] = sc.nextLine();
		
		
		int num = 0;
		
		for (int i = 0 ; i < 3 ; i++) {
			if(isNumeric(arr[i])) {
				num = Integer.parseInt(arr[i])+3-i;
				break;
			}
		}
		
		
		if (num%3==0) {
			if (num%5==0) {
				System.out.println("FizzBuzz");
			} else System.out.println("Fizz");
		} else {
			if (num%5==0) {
				System.out.println("Buzz");
			} else System.out.println(num);
		}
		
		
			
	}
	
	public static boolean isNumeric(String str) {
		try {
			Integer.parseInt(str);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}

}
