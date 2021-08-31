```
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.lang.StringBuilder;
import java.util.regex.Pattern;
public class Main {
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        String target;
        for(int i = 0; i < n; i++){
            target = br.readLine();
            boolean check = Pattern.matches("^(100+1+|01)+$", target);
            if(check)
                sb.append("YES\n");
            else
                sb.append("NO\n");
        }
        System.out.println(sb.toString());
    }
}
```
java.util.regex.Pattern이용
^: 문자열 시작
$: 문자열 끝
+: 
