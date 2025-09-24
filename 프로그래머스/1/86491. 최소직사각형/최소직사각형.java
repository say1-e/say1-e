class Solution {
    public int solution(int[][] sizes) {
        int maxX = 0;
        int maxY = 0;
        for (int i = 0; i < sizes.length ; i++){
            int x = Math.max(sizes[i][0], sizes[i][1]);
            int y = Math.min(sizes[i][0], sizes[i][1]);
            if (maxX < x) maxX = x;
            if (maxY < y) maxY = y;
        }
        
        return maxX * maxY;
    }
}