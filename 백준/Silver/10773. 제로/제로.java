import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Stack<String> stack = new Stack<>();
		int K = Integer.parseInt(br.readLine());
		
		for (int i = 0 ; i < K ; i++) {
			String s = br.readLine();
			
			if (s.equals("0")) {
				if (stack.isEmpty()) continue;
				else stack.pop();
			} else stack.push(s);
		}
		
		int sum = 0;
		while (!stack.isEmpty()) sum+=Integer.parseInt(stack.pop());
		
		System.out.println(sum);
		
		
	}

}
