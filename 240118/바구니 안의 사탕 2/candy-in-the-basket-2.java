import java.util.*;
import java.io.*;
public class Main {
    public static int[] candy = new int[201];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(stk.nextToken());
        int k = Integer.parseInt(stk.nextToken());

        for(int i=0;i<n;i++){
            stk = new StringTokenizer(br.readLine(), " ");
            int candyCnt = Integer.parseInt(stk.nextToken());
            int pos = Integer.parseInt(stk.nextToken());
            candy[pos] += candyCnt;
        }

        int result = 0;
        for(int i=k;i<201-k;i++){
            int pre = candy[i-1] + candy[i-2] + candy[i-3];
            int post = candy[i] + candy[i+1] + candy[i+2] + candy[i+3];
            result = Math.max(result, pre+post);
        }
        System.out.println(result);
    }
}