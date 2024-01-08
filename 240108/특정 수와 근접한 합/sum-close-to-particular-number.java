import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer stk = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(stk.nextToken());
        int s = Integer.parseInt(stk.nextToken());

        stk = new StringTokenizer(br.readLine(), " ");
        int[] numbers = new int[n];
        int sumNumber = 0;
        for(int i=0;i<n;i++){
            numbers[i] = Integer.parseInt(stk.nextToken());
            sumNumber += numbers[i];
        }
        //n-2 만큼 범위를 잡는다. 
        //-> 현재 배열의 모든 값을 더한 것에 2개를 뺀다.
        int result = Integer.MAX_VALUE;
        int x=0; int y=0;
        for(int i=0;i<n-1;i++){
            for(int j=i+1;j<n;j++){
                int tempSumNumber = sumNumber;
                tempSumNumber -= numbers[i] + numbers[j];
                //tempSumNumber가 s랑 가까운지 확인
                if(result > Math.abs((s - tempSumNumber))){
                    result = Math.abs(s - tempSumNumber);
                }
            }
        }
        System.out.println(result);
    }
}