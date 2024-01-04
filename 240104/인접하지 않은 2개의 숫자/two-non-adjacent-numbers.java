import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer stk = new StringTokenizer(br.readLine(), " ");
        int[] numbers = new int[n];
        int idx = 0;
        while(stk.hasMoreTokens()){
            numbers[idx++] = Integer.parseInt(stk.nextToken());
        }
        int resultNum = 0;
        for(int i=0;i<numbers.length-2;i++){
            int oneNumber = numbers[i];
            for(int j=i+2;j<numbers.length;j++){
                int twoNumber = numbers[j];
                resultNum = Math.max(oneNumber + twoNumber, resultNum);
            }
        }
        System.out.println(resultNum);
    }
}