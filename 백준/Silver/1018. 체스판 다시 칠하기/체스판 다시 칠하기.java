import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		char[][] board = new char[N][M];
		
		for (int i = 0 ; i < N ; i++) {
			String line = br.readLine();
			board[i] = line.toCharArray();
		}
		
		int minPaint = Integer.MAX_VALUE;
		
		for (int i = 0 ; i <= N-8 ; i++) {
			for (int j = 0 ; j <= M-8 ; j++) {
				int paint = getMinPaint(board,i,j);
				minPaint = Math.min(minPaint, paint);
				}
			}
		
		System.out.println(minPaint);
		
		
	}
	
	public static int getMinPaint(char[][] board, int x, int y) {
		int countW = 0;
		int countB = 0;
		
		char startColor = 'W';
		
		for (int i = x ; i < x + 8 ; i++) {
			for (int j = y ; j < y + 8 ; j++) {
				if ((i+j)%2 == 0) {
					if (board[i][j] != 'W') countW++;
					if (board[i][j] != 'B') countB++;
				} else {
					if (board[i][j] != 'W') countB++;
					if (board[i][j] != 'B') countW++;
				}
			}
		}
		return Math.min(countW, countB);
	}

}
