import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static long c;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		long a = Long.parseLong(st.nextToken());
		long b = Long.parseLong(st.nextToken());
		c = Long.parseLong(st.nextToken());
		System.out.println(multiple(a,b));
	}

	public static long multiple(long a, long b) {
		if (b == 0) return 1;
		
		long half = multiple(a,b/2);
		long result = (half * half) % c;
		
		if (b % 2 == 1) {
			result = (result * a) % c;
		}
		
		return result;
	}
}