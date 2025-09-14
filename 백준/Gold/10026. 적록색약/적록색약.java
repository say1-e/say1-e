import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	static boolean[][] visited;
	static char[][] pic,RGpic;
	static int N;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		pic = new char[N][N];
		RGpic = new char[N][N];
		for (int i = 0 ; i < N ; i++) {
			String s = br.readLine();
			for (int j = 0 ; j < N ; j++) {
				pic[i][j] = s.charAt(j);
				if (pic[i][j] == 'G') RGpic[i][j] = 'R';
				else RGpic[i][j] = pic[i][j];
			}
		}
		visited = new boolean[N][N];
		int normalCnt = 0;
		for (int i = 0 ; i < N ; i++) {
			for (int j = 0 ; j < N ; j++) {
				if (visited[i][j]) continue;
				bfs(i,j,pic);
				normalCnt++;
			}
		}
		visited = new boolean[N][N];
		int RGCnt = 0;
		for (int i = 0 ; i < N ; i++) {
			for (int j = 0 ; j < N ; j++) {
				if (visited[i][j]) continue;
				bfs(i,j,RGpic);
				RGCnt++;
			}
		}
		
		System.out.println(normalCnt+" "+RGCnt);
	}

	private static void bfs(int i, int j, char[][] pic) {
		Deque<int[]> q = new ArrayDeque<>();
		q.add(new int[] {i,j});
		visited[i][j] = true;
		
		while(!q.isEmpty()) {
			int[] cur = q.poll();
			for (int d = 0 ; d < 4 ; d++) {
				int nx = cur[0] + dx[d];
				int ny = cur[1] + dy[d];
				if (nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
				if (visited[nx][ny]) continue;
				if (pic[nx][ny] == pic[i][j]) {
					visited[nx][ny] = true;
					q.add(new int[] {nx,ny});
				}
			}
		}
	}

}
