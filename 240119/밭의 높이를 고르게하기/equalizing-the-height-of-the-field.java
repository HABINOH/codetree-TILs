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
        int answer = 0;
        for(int i=0;i<n;i++){
            int right = 0;
            int left = 0;
            int lengthSum = 1;
            for(int j=i+1; j<n; j++){
                if((heights[i] == heights[j]-1) || (heights[i] == heights[j]+1)){right++;}
                else {break;}
            }
            for(int j=i-1; j>=0; j--){
                if((heights[i] == heights[j]-1) || (heights[i] == heights[j]+1)){left++;}
                else {break;}
            }
            lengthSum += right + left;
            if(lengthSum >= t){
                answer = Math.max(answer, lengthSum);
            }
        }
        System.out.print(answer-1);
    }
}