import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] x1 = new int[n];
        int[] x2 = new int[n];
        for(int i=0;i<n;i++){
            StringTokenizer stk = new StringTokenizer(br.readLine());
            x1[i] = Integer.parseInt(stk.nextToken());
            x2[i] = Integer.parseInt(stk.nextToken());
        }
        int answer = 0;
        for(int i=0;i<n;i++){
            boolean isTrue = true;
            for(int j=0;j<n;j++){
                if(i==j){continue;}
                if( ( x1[i] >= x1[j] && x2[i] <= x2[j] ) || ( x1[i] <= x1[j] && x2[i] >= x2[j] ) ){
                    isTrue = false;
                    break;
                }
            }
            if(isTrue){answer++;}
        }
        System.out.print(answer);
    }
}