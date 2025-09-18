import java.util.*;
class Solution {
    private List<Integer>[] list;
    private boolean[] visited;
    public int solution(int n, int[][] computers) {
        list = new ArrayList[n];
        for (int i = 0 ; i < n ; i++) list[i] = new ArrayList<>();
        for (int i = 0 ; i < n ; i++){
            for (int j = 0 ; j < n ; j++){
                if (computers[i][j] == 1 && i != j) list[i].add(j);
            }
        }
        visited = new boolean[n];
        int cnt = 0;
        for (int i = 0 ; i < n ; i++){
            cnt += bfs(i);
            if (list[i].isEmpty()) cnt++;
        }
        int answer = cnt;
        return answer;
    }
    public int bfs(int start){
        Deque<Integer> q = new ArrayDeque<>();
        q.add(start);
        visited[start] = true;
        
        int c = 0;
        while(!q.isEmpty()){
            int cur = q.poll();
            for (int next : list[cur]){
                if (visited[next]) continue;
                visited[next] = true;
                c++;
                q.add(next);
            }
        }
        
        if (c > 0) return 1;
        else return 0;
    }
}