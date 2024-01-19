import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(stk.nextToken());
        int h = Integer.parseInt(stk.nextToken());
        int t = Integer.parseInt(stk.nextToken());

        stk = new StringTokenizer(br.readLine(), " ");
        int idx = 0;
        int[] heights = new int[n];
        while(stk.hasMoreTokens()){
            heights[idx++] = Integer.parseInt(stk.nextToken());
        }
        int answer = Integer.MAX_VALUE;
        for(int i=0;i<n-t;i++){
            int sum = 0;
            for(int j=i; j<i+t; j++){
                sum += Math.abs(h - heights[j]);
            }
            answer = Math.min(answer, sum);
        }
        System.out.print(answer);
    }
}