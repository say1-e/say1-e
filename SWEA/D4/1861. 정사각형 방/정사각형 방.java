import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 1 ; tc <= T ; tc++) {
			int N = Integer.parseInt(br.readLine());
			int[][] room = new int[N][N];
			for (int i = 0 ; i < N ; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine()," ");
				for (int j = 0 ; j < N ; j++) {
					room[i][j] = Integer.parseInt(st.nextToken());
				}
				
			}
			
			int max = 0;
			int maxSpot = 0;
			for (int i = 0 ; i < N ; i++) {
				for (int j = 0 ; j < N ; j++) {
					int sum = 1;
					int x = i;
					int y = j;
					while(true) {
						boolean tf = false;
						if (x-1 >= 0 && room[x-1][y] == room[x][y] + 1) {
							x--; tf = true;
						}
						else if (x+1 < N && room[x+1][y] == room[x][y] + 1) {
							x++; tf = true;
						}
						else if (y-1 >= 0 && room[x][y-1] == room[x][y] + 1) {
							y--; tf = true;
						}
						else if (y+1 < N && room[x][y+1] == room[x][y] + 1) {
							y++; tf = true;
						}
						if (tf) sum++;
						else break;
					}
					
					if (max < sum || (max == sum && maxSpot > room[i][j])) {
						max = sum;
						maxSpot = room[i][j];
					}
				}
			}
			
			sb.append("#").append(tc).append(" ").append(maxSpot).append(" ").append(max).append("\n");
			
		}
		System.out.println(sb.toString());
	}

}
