import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] num = new int[N];
		for (int i = 0 ; i < N ; i++) num[i] = Integer.parseInt(br.readLine());
		Arrays.sort(num);
		int J = (int)Math.round(N * 0.15);
		double sum = 0 ;
		for (int i = J ; i < N-J ; i++) sum += num[i];
		System.out.println(Math.round(sum /(N-2*J)));
	}
}