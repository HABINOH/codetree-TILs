import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer stk = new StringTokenizer(br.readLine(), " ");
        int idx = 0;
        int[] numbers = new int[n];
        while(stk.hasMoreTokens()){
            numbers[idx++] = Integer.parseInt(stk.nextToken());
        }
        int result = 0;
        for(int i=0;i<n;i++){
            for(int j=i;j<n;j++){
                int sum = 0;
                for(int k=i; k<=j; k++){
                    sum += numbers[k];
                }
                if(j!=0)sum /= j;
                for(int k=i; k<=j; k++){
                    if(numbers[k] == sum){result++; break;}
                }
            }
        }
        System.out.println(result);
    }
}