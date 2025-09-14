import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		int[][] tomato = new int[N][M];
		List<int[]> nofresh = new ArrayList<>();
		for (int i = 0 ; i < N ; i++) {
			st = new StringTokenizer(br.readLine()," ");
			for (int j = 0 ; j < M ; j++) {
				tomato[i][j] = Integer.parseInt(st.nextToken());
				if (tomato[i][j] == 1) nofresh.add(new int[] {i,j});
			}
		}
		
		boolean[][] visited = new boolean[N][M];
		Queue<int[]> q = new LinkedList<>();
		for (int[] cur : nofresh) {
			q.offer(cur);
			visited[cur[0]][cur[1]] = true;
		}
		int cnt = 0;
		while (!q.isEmpty()) {
			int[] cur = q.poll();
			if (tomato[cur[0]][cur[1]] == -1) continue;
			for (int d = 0 ; d < 4 ; d++) {
				int nx = cur[0] + dx[d];
				int ny = cur[1] + dy[d];
				if (nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
				if (tomato[nx][ny] == -1) continue;
				if (visited[nx][ny]) continue;
				visited[nx][ny] = true;
				tomato[nx][ny] = tomato[cur[0]][cur[1]]+1;
				q.offer(new int[] {nx,ny});
			}
			cnt = Math.max(tomato[cur[0]][cur[1]], cnt);
		}
		boolean flag = true;
		for (int i = 0 ; i < N ; i++) {
			for (int j = 0 ; j < M ; j++) {
				if (tomato[i][j] == 0) flag = false;
			}
		}
		System.out.println(flag ? cnt-1 : -1);
	}
}
