import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
import java.util.Arrays;

public class Solution {

    static final int INF = 1_000_000_000;
    static final int[] dx = {-1, 1, 0, 0};
    static final int[] dy = {0, 0, -1, 1};

    static class Node implements Comparable<Node> {
        int x, y, cost;
        Node(int x, int y, int cost) {
            this.x = x; this.y = y; this.cost = cost;
        }
        @Override
        public int compareTo(Node o) {
            return Integer.compare(this.cost, o.cost);
        }
    }

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine().trim());
        for (int tc = 1; tc <= T; tc++) {
            int N = Integer.parseInt(br.readLine().trim());

            int[][] map = new int[N][N];
            for (int i = 0; i < N; i++) {
                String line = br.readLine().trim();
                for (int j = 0; j < N; j++) {
                    map[i][j] = line.charAt(j) - '0';
                }
            }

            int[][] dist = new int[N][N];
            for (int[] row : dist) Arrays.fill(row, INF);
            dist[0][0] = 0;

            PriorityQueue<Node> pq = new PriorityQueue<>();
            pq.offer(new Node(0, 0, 0));

            while (!pq.isEmpty()) {
                Node cur = pq.poll();

                // 이미 더 좋은 경로가 있으면 스킵
                if (cur.cost > dist[cur.x][cur.y]) continue;

                // 도착지에 도달했고 현재 비용이 확정 최소면 더 볼 필요 없음 (조기 종료)
                if (cur.x == N - 1 && cur.y == N - 1) break;

                for (int dir = 0; dir < 4; dir++) {
                    int nx = cur.x + dx[dir];
                    int ny = cur.y + dy[dir];

                    if (nx < 0 || ny < 0 || nx >= N || ny >= N) continue;

                    int nextCost = cur.cost + map[nx][ny];
                    if (nextCost < dist[nx][ny]) {
                        dist[nx][ny] = nextCost;
                        pq.offer(new Node(nx, ny, nextCost));
                    }
                }
            }

            sb.append("#").append(tc).append(" ").append(dist[N-1][N-1]).append("\n");
        }

        System.out.print(sb.toString());
    }
}
