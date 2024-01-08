import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine(), " ");
        
        int n = Integer.parseInt(stk.nextToken());
        int k = Integer.parseInt(stk.nextToken());

        stk = new StringTokenizer(br.readLine(), " ");
        int numbers[] = new int[n];
        int z = 0;
        while(stk.hasMoreTokens()){
            numbers[z++] = Integer.parseInt(stk.nextToken());
        }
        int result = 0;
        for(int i=0;i<n-k;i++){
            int sum = 0;
            for(int j=i;j<i+k;j++){
                sum += numbers[j];
            }
            result = Math.max(result, sum);
        }
        System.out.println(result);
    }
}