import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(stk.nextToken());
        int k = Integer.parseInt(stk.nextToken());

        int[] arr = new int[10001];
        for(int i=0;i<n;i++){
            stk = new StringTokenizer(br.readLine(), " ");
            int num = Integer.parseInt(stk.nextToken());
            char score = stk.nextToken().charAt(0);

            if(score == 'G'){
                arr[num] = 1;
            }else{
                arr[num] = 2;
            }
        }
        int maxSum = 0;
        for(int i=0;i<=10000-k;i++){ //전체 범위에서 범위(구간)만큼 빼서 반복
            int sum = 0;
            for(int j=i; j<=i+k;j++){ //범위를 잡는다 (구간 지정)
                sum += arr[j]; //구간 내 값 합산
            }
            maxSum = Math.max(maxSum, sum);
        }
        System.out.println(maxSum);
    }
}