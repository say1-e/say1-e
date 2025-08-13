import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int S = Integer.parseInt(br.readLine());
		int[] sw = new int[S];
		
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		for (int i = 0 ; i < S ; i++) sw[i] = Integer.parseInt(st.nextToken());
		
		int N = Integer.parseInt(br.readLine());
		
		for (int i = 0 ; i < N ; i++) {
			st = new StringTokenizer(br.readLine()," ");
			int sex = Integer.parseInt(st.nextToken());
			int num = Integer.parseInt(st.nextToken());
			
			if (sex == 1) {
				for (int j = num-1 ; j < S ; j += num) sw[j] ^= 1;
			} else {
				if (sw[num-1] == 0) sw[num-1] = 1;
				else sw[num-1] = 0;
				int idx = 1;
				while(num-1+idx < S && num-1-idx >= 0 && sw[num-1+idx] == sw[num-1-idx]) {
							sw[num-1+idx] ^= 1;
							sw[num-1-idx] ^= 1;
						idx++;
				}
			}
		}
		for (int i = 0 ; i < S ; i++) {
			sb.append(sw[i]).append(" ");
			if ((i+1) % 20 == 0) sb.append("\n");
		}
		System.out.println(sb.toString());
	}
}
