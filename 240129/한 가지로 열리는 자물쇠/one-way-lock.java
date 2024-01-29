import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n =Integer.parseInt(br.readLine());
        StringTokenizer stk = new StringTokenizer(br.readLine(), " ");

        int[] arr = new int[3];
        for(int i=0;i<3;i++){
            arr[i] = Integer.parseInt(stk.nextToken());
        }
        int answer = 0;
        for(int i=1;i<=n;i++){
            for(int j=1;j<=n;j++){
                for(int k=1;k<=n;k++){
                    int one = Math.abs(arr[0] - i);
                    int two = Math.abs(arr[1] - j);
                    int three = Math.abs(arr[2] - k);

                    if(one<=2 || two<=2 || three<=2){
                        answer++;
                    }
                }
            }
        }
        System.out.println(answer);
    }
}