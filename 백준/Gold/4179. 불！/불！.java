import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {
	static int R,C;
	static boolean[][] visited;
	static char[][] map;
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new char[R][C];
		visited = new boolean[R][C];
		
		ArrayDeque<int[]> fireQ = new ArrayDeque<>();
		ArrayDeque<int[]> jQ = new ArrayDeque<>();
		
		for (int i = 0 ; i < R ; i++) {
			String s = br.readLine();
			for (int j = 0 ; j < C ; j++) {
				map[i][j] = s.charAt(j);
				if (map[i][j] == 'J') {
					jQ.add(new int[] {i,j});
					visited[i][j] = true;
				} else if (map[i][j] == 'F') {
					map[i][j] = 'B';
					fireQ.add(new int[] {i,j});
				}
			}
		}
		
		int time = 0;
		while (!jQ.isEmpty()) {
			int fireSz = fireQ.size();
			for (int k = 0 ; k < fireSz ; k++) {
				int[] cur = fireQ.poll();
				int x = cur[0], y = cur[1];
				for (int d = 0 ; d < 4 ; d++) {
					int nx = x + dx[d], ny = y + dy[d];
					if (nx >= 0 && ny >= 0 && nx < R && ny < C) {
						if(map[nx][ny] != '#' && map[nx][ny] != 'B') {
							map[nx][ny] = 'B';
							fireQ.add(new int[] {nx,ny});
						}
					}
				}
			}
			
			int jSz = jQ.size();
			time++;
			
			for (int k = 0 ; k < jSz; k++) {
				int[] cur = jQ.poll();
				int x = cur[0], y = cur[1];
				
				for (int d = 0 ; d < 4 ; d++) {
					int nx = x + dx[d], ny = y + dy[d];
					if (nx < 0 || ny < 0 || nx >= R || ny >= C) {
						System.out.println(time);
						return;
					}
					
					if (map[nx][ny] == '#' || map[nx][ny] == 'B') continue;
					if (visited[nx][ny]) continue;
					
					visited[nx][ny] = true;
					jQ.add(new int[] {nx,ny});
				}
			}
		}
		System.out.println("IMPOSSIBLE");
	}

}
