import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1 ; tc <= T ; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			Queue<int[]> q = new LinkedList<>();
			PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
			st = new StringTokenizer(br.readLine()," ");
			for (int i = 0 ; i < N ; i++) {
				int priority = Integer.parseInt(st.nextToken());
				q.offer(new int[] {i, priority});
				pq.offer(priority);
			}
			
			int printIdx = 0;
			while (!q.isEmpty()) {
				int[] cur = q.poll();
				int idx = cur[0];
				int prio = cur[1];
				if (prio == pq.peek()) {
					printIdx++;
					pq.poll();
					if (idx == M) {
						sb.append(printIdx).append("\n");
						break;
					}
				} else q.offer(cur);
			}
		}
		System.out.println(sb.toString().trim());
	}
}
