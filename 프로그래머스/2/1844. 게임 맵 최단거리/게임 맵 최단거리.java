import java.util.*;
class Solution {
    public int solution(int[][] maps) {
        int[] dx = {-1,1,0,0};
        int[] dy = {0,0,-1,1};
        int n = maps.length;
        int m = maps[0].length;
        int[][] dist = new int[n][m];
        boolean[][] visited = new boolean[n][m];
        Deque<int[]> q = new ArrayDeque<>();
        dist[0][0] = 1;
        q.add(new int[] {0,0});
        visited[0][0] = true;
        
        while(!q.isEmpty()){
            int[] cur = q.poll();
            int x = cur[0];
            int y = cur[1];
            
            for (int d = 0 ; d < 4 ; d++){
                int nx = x + dx[d];
                int ny = y + dy[d];
                if (nx < 0 || ny < 0 || nx >= n || ny >= m) continue;
                if (maps[nx][ny] == 0) continue;
                if (visited[nx][ny]) continue;
                visited[nx][ny] = true;
                dist[nx][ny] = dist[x][y] + 1;
                q.add(new int[] {nx,ny});
            }
        }
        return dist[n-1][m-1] == 0 ? -1 : dist[n-1][m-1];
    }
}