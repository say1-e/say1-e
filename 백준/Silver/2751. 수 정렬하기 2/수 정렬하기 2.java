import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		Set<Integer> num = new HashSet<>();
		
		for (int i = 0 ; i < N ; i++) {
			num.add(Integer.parseInt(br.readLine()));
		}
		
		List<Integer> Num = new ArrayList<>(num);
		Collections.sort(Num);
		
		for (int n : Num) {
			System.out.println(n);
		}
		
	}

}
