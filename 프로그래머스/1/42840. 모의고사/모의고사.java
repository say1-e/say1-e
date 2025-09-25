import java.util.*;
class Solution {
    public int[] solution(int[] answers) {
        int[] scores = new int[3];
        scores[0] = Method1(answers);
        scores[1] = Method2(answers);
        scores[2] = Method3(answers);
        //max값 구하기
        int max = 0;
        for (int i = 0 ; i < 3 ; i++){
            if (max < scores[i]) max = scores[i];
        }
        //max값과 일치하는 사람들 answer에 담기
        List<Integer> result = new ArrayList<>();
        for (int i = 0 ; i < 3 ; i++){
            if (max == scores[i]) result.add(i);
        }
        return result.stream().mapToInt(i -> i + 1).toArray();
    }
    
    
    public static int Method1(int[] answers){
        int sum = 0;
        int num = 1;
        for (int i = 0 ; i < answers.length ; i++){
            if (num == answers[i]) sum++;
            num++;
            if (num > 5) num = 1;
        }
        return sum;
    }
    
    public static int Method2(int[] answers){
        int sum = 0;
        int idx = 0;
        int[] ans = {1,3,4,5};
        for (int i = 0 ; i < answers.length ; i++){
            if (i % 2 == 0 && answers[i] == 2) sum++;
            if (i % 2 != 0){
                if (answers[i] == ans[idx]) sum++;
                idx++;
                if (idx == ans.length) idx = 0;
            }
        }
        return sum;
    }
    
    public static int Method3(int[] answers){
        int sum = 0;
        int idx = 0;
        int[] ans = {3,1,2,4,5};
        for (int i = 0 ; i < answers.length ; i++){
            if (answers[i] == ans[idx]) sum++;
            if (i % 2 != 0) {
                idx++;
                if (idx == ans.length) idx = 0;
            }
        }
        return sum;
    }
}