package Sliding_Window;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Acmicpc_14465_소가길을건너간이유5 {

	static int N,K,B;
    
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.valueOf(st.nextToken());
        K = Integer.valueOf(st.nextToken());
        B = Integer.valueOf(st.nextToken());
        
        int[] street = new int[N+1];
        
        Arrays.fill(street,1);
        
        for(int i=0; i<B; i++){
            int num = Integer.valueOf(br.readLine());
            street[num] = 0;
        }
        
        int left = 1;
        int right = 1;
        int sum = 0;
        int answer = Integer.MAX_VALUE;
        
        while(right <= N){
            if(right<=K){
                sum += street[right++];
            }
            
            if(right > K){
                sum -= street[left++];
                sum += street[right++];
            }
            
            answer = Math.min(answer, K-sum);
        }
        
        System.out.println(answer);
        
    }

}
