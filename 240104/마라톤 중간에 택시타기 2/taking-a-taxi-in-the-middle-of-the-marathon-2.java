import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        StringTokenizer stk;
        int[] x = new int[n];
        int[] y = new int[n];
        for(int i=0;i<n;i++){
            stk = new StringTokenizer(br.readLine(), " ");
            
            x[i] = Integer.parseInt(stk.nextToken());
            y[i] = Integer.parseInt(stk.nextToken());
        }
        int maxNumber = Integer.MAX_VALUE;
        for(int i=1;i<n-1;i++){
            int dist = 0;
            int preIndex = 0;
            for(int j=1;j<n;j++){
                if(i==j){continue;}
                dist += Math.abs(x[preIndex] - x[j]) + Math.abs(y[preIndex] - y[j]);
                preIndex = j;
            }
            maxNumber = Math.min(maxNumber, dist);
        }
        System.out.println(maxNumber);
    }
}