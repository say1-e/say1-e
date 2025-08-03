import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] num = new int[N][2];
		
		for (int i = 0 ; i < N ; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			num[i][0] = Integer.parseInt(st.nextToken());
			num[i][1] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(num, (a,b) -> {
			if (a[0]==b[0]) {
				return a[1]-b[1];
			} return a[0]-b[0];
		});
		
		StringBuilder sb = new StringBuilder();
		for (int i = 0 ; i < N ; i++) {
			sb.append(num[i][0]).append(" ").append(num[i][1]).append("\n");
		}
		System.out.print(sb);
	}

}
