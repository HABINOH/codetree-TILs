import java.util.*;
import java.io.*;
public class Main {
    static int sum = 0;
    static int[] develop = new int[5];
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer stk = new StringTokenizer(br.readLine(), " ");
        int n = 0;
        while(stk.hasMoreTokens()){
            develop[n++] = Integer.parseInt(stk.nextToken());
            sum += develop[n-1];
        }
        int answer = Integer.MAX_VALUE;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                for(int k=0;k<n;k++){
                    for(int q=0;q<n;q++){
                        if((i!=j && i!=k && i!=q) &&
                        (j!=k && j!=q) && (k!=q)){
                            answer = Math.min(answer, getDiff(i,j,k,q));
                        }
                    }
                }
            }
        }
        if(answer == Integer.MAX_VALUE){System.out.print(-1);}
        else {System.out.print(answer);}
    }
    public static int getDiff(int i, int j, int k, int q){
        int sum1 = develop[i] + develop[j];
        int sum2 = develop[k] + develop[q];
        int sum3 = sum - sum1 - sum2;
        
        if((sum1 != sum2) && (sum1 != sum3) && (sum2 != sum3)){
            int max = Math.max(Math.max(sum1, sum2), sum3);
            int min = Math.min(Math.min(sum1, sum2), sum3);
            return Math.abs(max - min);
        }
        return Integer.MAX_VALUE;
    }
}