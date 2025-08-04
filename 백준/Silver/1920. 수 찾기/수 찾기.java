import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] nArr = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0 ; i < N ; i++) {
			nArr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(nArr);
		
		int M = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		for (int i = 0 ; i < M ; i++) {
			int target = Integer.parseInt(st.nextToken());
			if (binarySearch(nArr,target)) {
				sb.append("1\n");
			} else sb.append("0\n");
		}
		System.out.println(sb);
	}
	
	public static boolean binarySearch(int[] arr, int key) {
		int left = 0;
		int right = arr.length-1;
		
		while (left <= right) {
			int mid = (left+right)/2;
			
			if (arr[mid] == key) return true;
			else if (arr[mid] < key) left = mid+1;
			else right = mid-1;
		}
		return false;
		
	}

}
