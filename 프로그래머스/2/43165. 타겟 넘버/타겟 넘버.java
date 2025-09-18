import java.util.*;

class Solution {
    private int[] str;
    private int N;
    private int cnt, answer;
    public int solution(int[] numbers, int target) {
        this.str = numbers;
        this.N = target;
        this.answer = 0;
        comb(0, 0);
        return answer;
    }
    
    public void comb(int idx, int sum){
        if (idx == str.length) {
            if (sum == N) answer++;
            return;
        }
        //선택 O
        comb(idx+1, sum + str[idx]);
        //선택 X
        comb(idx+1, sum - str[idx]);
    }
}