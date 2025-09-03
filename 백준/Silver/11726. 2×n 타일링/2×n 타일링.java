import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int N;
    static int[] memo;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        memo = new int[N + 2];

        System.out.println(tiling(N));
    }

    public static int tiling(int n) {
        if (n == 1) return 1;
        if (n == 2) return 2;

        if (memo[n] != 0) return memo[n];

        memo[n] = (tiling(n - 1) + tiling(n - 2)) % 10007;
        return memo[n];
    }
}
