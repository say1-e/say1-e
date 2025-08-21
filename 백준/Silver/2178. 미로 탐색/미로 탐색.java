import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int[][] graph;
	static boolean[][] visited;
	static int[][] dist;
	static int N,M;
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	static int min = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		graph = new int[N][M];
		visited = new boolean[N][M];
		dist = new int[N][M];
		
		for (int i = 0 ; i < N ; i++) {
			String str = br.readLine();
			for (int j = 0 ; j < M ; j++) {
				graph[i][j] = str.charAt(j) - '0';
			}
		}
		
		bfs(0,0);
		System.out.println(dist[N-1][M-1]);
	}

	private static void bfs(int x, int y) {
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[]{x,y});
		visited[x][y] = true;
		dist[x][y] = 1;
		
		while(!q.isEmpty()) {
			int[] cur = q.poll();
			int cx = cur[0];
			int cy = cur[1];
			
			for (int i = 0 ; i < 4 ; i++) {
				int nx = cx + dx[i];
				int ny = cy + dy[i];
				
				if (nx >= 0 && nx < N && ny >= 0 && ny < M) {
					if (graph[nx][ny] == 1 && !visited[nx][ny]) {
						visited[nx][ny] = true;
						dist[nx][ny] = dist[cx][cy]+1;
						q.add(new int[] {nx,ny});
					}
				}
			}
		}
		
	}

}
