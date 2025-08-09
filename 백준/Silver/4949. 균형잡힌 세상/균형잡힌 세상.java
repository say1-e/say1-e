import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while(true) {
			Stack<Character> stack = new Stack<>();
			boolean tf = true;
			String line = br.readLine();
			if (line == null || line.equals(".")) break;
			
			for (int i = 0 ; i < line.length() ; i++) {
				char c = line.charAt(i);
				
				if (c == '(' || c == '[') stack.push(c);
				else if (c == ')') {
					if (stack.isEmpty() || stack.pop() != '(') {
						tf = false;
						break;
					}
				}
				else if (c == ']') {
					if (stack.isEmpty() || stack.pop() != '[') {
						tf = false;
						break;
					}
				}
			}
			
			if (!stack.isEmpty()) tf = false;
			
			System.out.println(tf ? "yes" : "no");
			
		}
		
	}

}