import java.util.*;
class Solution {
    public String[] solution(String[][] tickets) {
        Map<String, PriorityQueue<String>> airLine = new HashMap<>();
        for (String[] t : tickets){
            airLine.computeIfAbsent(t[0], k->new PriorityQueue<>()).offer(t[1]);
        }
        
        Deque<String> st = new ArrayDeque<>();
        List<String> path = new ArrayList<>();
        st.push("ICN");
        
        while(!st.isEmpty()){
            String cur = st.peek();
            PriorityQueue<String> pq = airLine.get(cur);
            if (pq != null && !pq.isEmpty()){
                st.push(pq.poll());
            } else {
                path.add(st.pop());
            }
        }
        Collections.reverse(path);
        return path.toArray(new String[0]);
    }
}