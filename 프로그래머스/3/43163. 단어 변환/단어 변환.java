import java.util.*;
class Solution {
    static boolean[] visited;
    static int minCnt;
    static String target;
    static String[] words;
    public int solution(String begin, String target, String[] words) {
        boolean none = false;
        for (String word : words){
            if (target.equals(word)) none = true;
        }
        if (!none) return 0;
        
        this.minCnt = Integer.MAX_VALUE;
        this.target = target;
        this.words = words;
        this.visited = new boolean[words.length];
        dfs(begin,0);
        return minCnt;
    }
    
    public static void dfs(String str, int cnt){
        if (cnt >= minCnt) return;
        if (str.equals(target)){
            minCnt = Math.min(minCnt, cnt);
            return;
        }
        
        for (int i = 0 ; i < words.length ; i++){
            if (visited[i]) continue;
            int diff = 0;
            for (int j = 0 ; j < str.length() ; j++){
                if (str.charAt(j) != words[i].charAt(j)){
                    diff++;
                }
            }
            if (diff > 1) continue;
            visited[i] = true;
            dfs(words[i], cnt + 1);
            visited[i] = false;
        }
        return;
    }
}