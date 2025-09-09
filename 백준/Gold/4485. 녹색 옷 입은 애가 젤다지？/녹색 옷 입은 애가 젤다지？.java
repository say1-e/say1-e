import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder(); 
		int tc = 1;
		while (true) {
			int N = Integer.parseInt(br.readLine());
			if (N == 0) break;
			
			int[][] cave = new int[N][N];
			int[][] dist = new int[N][N];
			for (int i = 0 ; i < N ; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine()," ");
				for (int j = 0; j < N; j++) {
					cave[i][j] = Integer.parseInt(st.nextToken());
					dist[i][j] = Integer.MAX_VALUE;
				}
			}
			dist[0][0] = cave[0][0];
			PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[0] - b[0]);
			pq.add(new int[] {cave[0][0],0,0}); //cost, x, y
			
			while (!pq.isEmpty()) {
				int[] cur = pq.poll();
				int cost = cur[0];
				int x = cur[1];
				int y = cur[2];
				
				if (cost > dist[x][y]) continue;
				for (int i = 0 ; i < 4 ; i++) {
					int nx = x + dx[i];
					int ny = y + dy[i];
					if (nx >= N || ny >= N || nx < 0 || ny < 0) continue;
					int nextCost = cost + cave[nx][ny];
					if (nextCost < dist[nx][ny]) {
						dist[nx][ny] = nextCost;
						pq.add(new int[] {nextCost, nx, ny});
					}
				}
			}
			sb.append("Problem ").append(tc).append(": ").append(dist[N-1][N-1]).append("\n");
			tc++;
		}
		System.out.println(sb.toString().trim());
	}
}
