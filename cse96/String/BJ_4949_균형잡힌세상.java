import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		Stack<Character> stack = new Stack<Character>();
		boolean flag;
		while(true) {
			stack.clear();
			flag = true; char c;
			String s = bf.readLine();
			if(s.equals(".")) break;
			int size = s.length();
			for(int i = 0; i < size; i++) {
				c = s.charAt(i);
				if(c == '(' || c =='[') {
					stack.push(c);
				}
				else if(c == ')'){
					if(stack.isEmpty() || !(stack.peek() == '(') ) {
						flag = false;
						break;
					}
					else if(stack.peek() == '(') {
						stack.pop();
					}
				}
				else if(c == ']'){
					if(stack.isEmpty() || !(stack.peek() == '[')) {
						flag = false;
						break;
					}
					else if(stack.peek() == '[') {
						stack.pop();
					}
				}
			}//for - 한줄 처리 후
			
			if(!stack.isEmpty()) flag = false;
			if(flag) System.out.println("yes");
			else System.out.println("no");
		}//while
	}
}
