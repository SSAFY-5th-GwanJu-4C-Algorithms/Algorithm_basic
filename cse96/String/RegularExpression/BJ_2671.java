import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.lang.StringBuilder;
import java.util.regex.Pattern;
public class Main {
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String target = br.readLine();
        boolean check = Pattern.matches("^(100+1+|01)+$", target);
        if(check)
            sb.append("SUBMARINE\n");
        else
            sb.append("NOISE\n");
        System.out.println(sb);
    }
}
