import java.util.*;
class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        for (int i = 0 ; i < commands.length ; i++) {
            answer[i] = func(array, i, commands);
        }
        return answer;
    }
    public int func(int[] array, int idx, int[][] commands){
        int n = commands[idx][1] - commands[idx][0] +1;
        int[] arr = new int[n];
        int num = 0;
        for (int i = commands[idx][0]-1 ; i <= commands[idx][1]-1 ; i++){
            arr[num++] = array[i];
        }
        Arrays.sort(arr);
        return arr[commands[idx][2]-1];
    }
}