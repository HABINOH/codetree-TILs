import java.util.*;
import java.io.*;
public class Main {
    public static int sum = 0;
    static int[] developer = new int[6];
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine(), " ");
        int n = 0;
        while(stk.hasMoreTokens()){
            developer[n++] = Integer.parseInt(stk.nextToken());
            sum += developer[n-1];
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
        System.out.println(answer);
    }
    public static int getDiff(int i, int j, int k, int q){
        int sum1 = developer[i] + developer[j];
        int sum2 = developer[k] + developer[q];
        int sum3 = sum - sum1 - sum2;

        int max = Math.max(Math.max(sum1, sum2), sum3);
        int min = Math.min(Math.min(sum1, sum2), sum3);

        return Math.abs(max-min);
    }
}