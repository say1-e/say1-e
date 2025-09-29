import java.util.*;
class Solution {
    public String solution(int[] numbers) {
        String[] num = new String[numbers.length];
        boolean flag = true;
        for (int i = 0 ; i < numbers.length ; i++) {
            num[i] = Integer.toString(numbers[i]);
            if (numbers[i] != 0) flag= false;
        }
        if (flag) return "0";
        Arrays.sort(num, new Comparator<>(){
            @Override
            public int compare(String a,String b){
                return (b+a).compareTo(a+b);
            }
        });
        StringBuilder sb = new StringBuilder();
        for (String s : num) sb.append(s);
        return sb.toString();
    }
}