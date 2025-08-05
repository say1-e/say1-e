import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int[] Num = new int[2*N];
		for (int i = 0 ; i < N ; i++) {
			Num[i] = i+1;
		}
		
		int front = 0;
		int rear = N;
		
		while (rear - front >1) {
			front++;
			Num[rear++] = Num[front++];
		}
		
		System.out.println(Num[front]);
	}
}