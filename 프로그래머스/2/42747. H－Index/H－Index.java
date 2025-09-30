import java.util.*;
class Solution {
    public int solution(int[] citations) {
        Arrays.sort(citations);
        int answer = 0;
        for (int i = citations.length ; i >= 0 ; i--){
            if (func(i,citations)){
                answer = i;
                break;
            }
        }
        return answer;
    }
    public boolean func(int h, int[] arr){
        int up = 0;
        int down = 0;
        for (int num : arr){
            if (num >= h) up++;
            else down++;
        }
        if (up >= h && down <= h) return true;
        else return false;
    }
}