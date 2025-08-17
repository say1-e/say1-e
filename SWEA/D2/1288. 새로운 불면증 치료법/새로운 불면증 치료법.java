import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Solution {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1 ; tc <= T ; tc++) {
			int[] num = new int[10];
			int cnt = 0;
			String str = br.readLine();
			while(!Arrays.stream(num).allMatch(x -> x>=1)) {
				cnt++;
				String str2 = String.valueOf(Integer.parseInt(str) * cnt);
				for (char c : str2.toCharArray()) {
					int i = c - '0';
					num[i]++;
				}
			}
			sb.append("#").append(tc).append(" ").append(Integer.parseInt(str) * cnt).append("\n");
		}
		System.out.println(sb.toString().trim());
	}
}
