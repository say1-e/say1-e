import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
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
		Deque<int[]> q = new ArrayDeque<>();
		int rawTomato = 0;
		for (int i = 0 ; i < N ; i++) {
			st = new StringTokenizer(br.readLine()," ");
			for (int j = 0 ; j < M ; j++) {
				tomato[i][j] = Integer.parseInt(st.nextToken());
				if (tomato[i][j] == 1) q.add(new int[] {i,j});
				else if (tomato[i][j] == 0) rawTomato++;
			}
		}
		
		//처음부터 다 익었다면?
		if (rawTomato == 0) {
			System.out.println(0);
			return;
		}
		
		int maxDay = 1;
		while (!q.isEmpty()) {
			int[] cur = q.poll();
			for (int d = 0 ; d < 4 ; d++) {
				int nx = cur[0] + dx[d];
				int ny = cur[1] + dy[d];
				if (nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
				if (tomato[nx][ny] != 0 ) continue; //day갱신 혹은 벽(-1) 패쓰
				tomato[nx][ny] = tomato[cur[0]][cur[1]]+1;
				rawTomato--;
				q.add(new int[] {nx,ny});
			}
			maxDay = Math.max(tomato[cur[0]][cur[1]], maxDay);
		}
		
		System.out.println(rawTomato == 0 ? maxDay-1 : -1);
	}
}
