import java.util.*;
import java.io.*;

public class Main {
    public static int sum = 0;
    public static int[] arr = new int[6];
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine(), " ");
        int idx = 0;
        while(stk.hasMoreTokens()){
            arr[idx++] = Integer.parseInt(stk.nextToken());
            sum += arr[idx-1];
        }
        int answer = Integer.MAX_VALUE;
        for(int i=0;i<6;i++){
            for(int j=0;j<6;j++){
                for(int k=0;k<6;k++){
                    if(i!=j && i!=k && j!=k){
                        answer = Math.min(answer, getDiff(i,j,k));
                    }
                }
            }
        }
        System.out.println(answer);
    }
    public static int getDiff(int i, int j, int k){
        int compareSum = arr[i] + arr[j] + arr[k];
        int compareSum2 = Math.abs(compareSum - sum);
        return Math.abs(compareSum - compareSum2);
    }
}