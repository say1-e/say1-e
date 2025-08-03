import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		sc.nextLine();
		
		Set<String> set = new HashSet<>();
		
		for (int i = 0 ; i < N ; i++) {
			set.add(sc.nextLine());
		}
		
		List<String> list = new ArrayList<>(set);
		
		Collections.sort(list, (a,b) -> {
			if (a.length() != b.length()) return a.length() - b.length() ;
			return a.compareTo(b);
		});
		
		for (String s : list) {
			System.out.println(s);
		}
	}
}
