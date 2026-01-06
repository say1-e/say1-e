import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        String[] numToName = new String[N + 1];
        HashMap<String, Integer> nameToNum = new HashMap<>();

        for (int i = 1; i <= N; i++) {
            String name = br.readLine();
            numToName[i] = name;
            nameToNum.put(name, i);
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < M; i++) {
            String query = br.readLine();
            char first = query.charAt(0);

            if (Character.isDigit(first)) {
                int num = Integer.parseInt(query);
                sb.append(numToName[num]).append('\n');
            } else {
                sb.append(nameToNum.get(query)).append('\n');
            }
        }

        System.out.print(sb);
    }
}
