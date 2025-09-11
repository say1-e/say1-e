import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] num = new int[N];
		long sum = 0;
		int[] cnt = new int[8001];
		int maxCnt = 0;
		for (int i = 0 ; i < N ; i++) {
			num[i] = Integer.parseInt(br.readLine());
			sum += num[i];
			cnt[num[i]+4000]++;
			if (maxCnt < cnt[num[i]+4000]) maxCnt = cnt[num[i]+4000];
		}
		Arrays.sort(num);
		System.out.println(Math.round((double)sum / N));
		System.out.println(num[N/2]);
		
		List<Integer> arr = new ArrayList<>();
		for (int i = 0 ; i < 8001 ; i++) {
			if (maxCnt == cnt[i]) arr.add(i-4000);
		}
		Collections.sort(arr);
		System.out.println(arr.size() > 1 ? arr.get(1) : arr.get(0));
		
		System.out.println(num[N-1] - num[0]);
	}

}
