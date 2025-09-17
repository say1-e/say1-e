import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] dist = new int[N][N];
		for (int i = 0 ; i < N ; i++) {
			for (int j = 0 ; j < N ; j++) {
				if (i == j) continue;
				dist[i][j] = 1_000_000_000;
			}
		}
		int M = Integer.parseInt(br.readLine());
		for (int i = 0 ; i < M ; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			int a = Integer.parseInt(st.nextToken())-1;
			int b = Integer.parseInt(st.nextToken())-1;
			int cost = Integer.parseInt(st.nextToken());
			
			dist[a][b] = Math.min(dist[a][b], cost);
		}
		for (int k = 0 ; k < N ; k++) {
			for (int i = 0 ; i < N ; i++) {
				for (int j = 0 ; j < N ; j++) {
					dist[i][j] = Math.min(dist[i][j], dist[i][k]+dist[k][j]);
				}
			}
		}
		for (int i = 0 ; i < N ; i++) {
			for (int j = 0 ; j < N ; j++) {
				if (dist[i][j] == 1_000_000_000) dist[i][j] = 0;
				System.out.print(dist[i][j]+" ");
			}
			System.out.println();
		}
		
	}

}
