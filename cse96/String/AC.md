```
package study.July.String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class AC {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.valueOf(br.readLine());
		for(int tc = 0; tc < T; tc++) {
			boolean flag = false;
			ArrayList<Integer> l = new ArrayList<Integer>();
			String str = br.readLine();//RDD
			
			int len = str.length();
			int N = Integer.valueOf(br.readLine());//4
			
			String s = br.readLine();//[1,2,3,4]
			String num = s.substring(1,s.length()-1);//1,2,3,4
			String[] nums = num.split(",");//1 2 3 4
			
			for(int i = 0; i < N; i++) {
				l.add(Integer.valueOf(nums[i]));
			}
			for(int i = 0; i < len; i++) {
				char c = str.charAt(i);
				if(c == 'R') {
					Collections.reverse(l);
				}
				else if(c == 'D') {
					if(l.size() == 0) {
						System.out.println("error");
						flag = true;
					}
					for(int j = 0; j < l.size(); j++) {
						if(l.get(j) == null) {
							j++;
						}
						else {
							l.remove(j);
							break;
						}
					}
					if(flag) break;
				}
			}
			if(flag) continue;
			StringBuilder sb = new StringBuilder();
			sb.append("[");
			for(int i = 0; i < l.size(); i++) {
				if(i != l.size()-1)
				sb.append(l.get(i)).append(",");
				else {
					sb.append(l.get(i));
				}
			}
			sb.append("]");
			System.out.println(sb.toString());
		}
	}

}
```
실제로 R마다 뒤집었던 코드..  
뒤집지 말라고 글이 있어서
```
package study.July.String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class AC {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.valueOf(br.readLine());
		for(int tc = 0; tc < T; tc++) {
			boolean flag = false;
			ArrayList<Integer> l = new ArrayList<Integer>();
			String str = br.readLine();//RDD
			
			int len = str.length();
			int N = Integer.valueOf(br.readLine());//4
			
			String s = br.readLine();//[1,2,3,4]
			String num = s.substring(1,s.length()-1);//1,2,3,4
			String[] nums = num.split(",");//1 2 3 4
			int[] num_arr = new int[N];
			boolean reverse = false;
			
			int start = 0;
			int end = N - 1;
			int n = N;
			for(int i = 0; i < N; i++) {
				l.add(Integer.valueOf(nums[i]));
			}
			
			for(int i = 0; i < len; i++) {
				char c = str.charAt(i);
				if(c == 'R') {
					reverse = !reverse;
				}
				else if(c == 'D') {
					n--;
					if(n < 0) {
						System.out.println("error");
						flag = true;
						break;
					}
					if(l.size() == 0) {
						System.out.println("error");
						flag = true;
						break;
					}
					if(end <= start) {
						System.out.println("error");
						flag = true;
						break;
					}
					if(reverse) {
						l.remove(l.size()-1);
					}
					if(!reverse) {
						l.remove(0);
					}
					
					if(flag) break;
				}
			}
			if(flag) continue;
			StringBuilder sb = new StringBuilder();
			if(reverse) Collections.reverse(l);
			System.out.println(l.toString().replaceAll(" ",""));
		}
	}

}

```
안뒤집고 한 코드;
