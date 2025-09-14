import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	static int[][] pic;
	static boolean[][] visited;
	static int N,M;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		pic = new int[N][M];
		for (int i = 0 ; i < N ; i++) {
			st = new StringTokenizer(br.readLine()," ");
			for (int j = 0 ; j < M ; j++) pic[i][j] = Integer.parseInt(st.nextToken());
		}
		
		int picCnt = 0;
		int maxPic = 0;
		visited = new boolean[N][M];
		for (int i = 0 ; i < N ; i++) {
			for (int j = 0 ; j < M ; j++) {
				if (visited[i][j] || pic[i][j] == 0) continue;
				picCnt++;
				maxPic = Math.max(maxPic, bfs(i,j));
			}
		}
		
		System.out.println(picCnt);
		System.out.println(maxPic);
	}
	public static int bfs(int i, int j) {
		Deque<int[]> q = new ArrayDeque<>();
		int picture = 0;
		
		q.add(new int[] {i,j});
		visited[i][j] = true;
		while (!q.isEmpty()) {
			int[] cur = q.poll();
			picture++;
			for (int d = 0 ; d < 4 ; d++) {
				int nx = cur[0] + dx[d];
				int ny = cur[1] + dy[d];
				if (nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
				if (visited[nx][ny] || pic[nx][ny] == 0) continue;
				visited[nx][ny] = true;
				q.add(new int[] {nx,ny});
			}
		}
		return picture;
	}

}
