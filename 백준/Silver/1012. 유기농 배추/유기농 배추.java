import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static boolean[][] farm;
	static boolean[][] visitied;
	static int M,N,K,worm;
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 1 ; tc <= T ; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			M = Integer.parseInt(st.nextToken());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			
			farm = new boolean[N][M];
			visitied = new boolean[N][M];
			
			for (int k = 0 ; k < K ; k++) {
				st = new StringTokenizer(br.readLine()," ");
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				farm[y][x] = true;
			}
			
			worm = 0;
			for (int y = 0 ; y < N ; y++) {
				for (int x = 0 ; x < M ; x++) {
					if (farm[y][x] && !visitied[y][x]) {
						bfs(y,x);
						worm++;
					}
				}
			}
			sb.append(worm).append("\n");
		}
		System.out.println(sb.toString().trim());
	}

	public static void bfs(int j, int i) {
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] {j,i});
		visitied[j][i] = true;
		
		while(!q.isEmpty()) {
			int[] cur = q.poll();
			int cy = cur[0];
			int cx = cur[1];
			
			for (int l = 0 ; l < 4 ; l++) {
				int ny = cy + dy[l];
				int nx = cx + dx[l];
				
				if (nx >= 0 && ny >=0 && nx < M && ny <N) {
					if (farm[ny][nx] && !visitied[ny][nx]) {
						visitied[ny][nx] = true;
						q.add(new int[] {ny,nx});
					}
				}
			}
		}
	}
	

}
