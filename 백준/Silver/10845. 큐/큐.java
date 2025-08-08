import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		Deque<String> que = new ArrayDeque<>();
		int N = Integer.parseInt(br.readLine());
		
		for (int i = 0 ; i < N ; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String q = st.nextToken();
			
			if (q.equals("push")) {
				que.offer(st.nextToken());
			} else if (q.equals("pop")) {
				if (que.isEmpty()) sb.append("-1\n");
				else sb.append(que.pollFirst()+"\n");
			} else if (q.equals("size")) {
				sb.append(que.size()+"\n");
			} else if (q.equals("empty")) {
				sb.append(que.isEmpty() ? "1\n" : "0\n");
			} else if (q.equals("front")) {
				if (que.isEmpty()) sb.append("-1\n");
				else sb.append(que.peek()+"\n");
			} else if (q.equals("back")) {
				if (que.isEmpty()) sb.append("-1\n");
				else sb.append(que.peekLast()+"\n");
			}
		}
		System.out.println(sb.toString());
	}
}
