import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[][] time = new int[n][2];
        for(int i=0;i<n;i++){
            StringTokenizer stk = new StringTokenizer(br.readLine(), " ");
            time[i][0] = Integer.parseInt(stk.nextToken());
            time[i][1] = Integer.parseInt(stk.nextToken());
        }
        int answer = 0;
        for(int i=0;i<n;i++){
            HashMap<Integer, Integer> hashMap = new HashMap<>();
            for(int j=0;j<n;j++){
                if(i==j){continue;}
                int st = time[j][0];
                int en = time[j][1];
                for(int k=st;k<en;k++){
                    hashMap.put(k, 1);
                }
            }
            answer = Math.max(answer, hashMap.size());
        }
        System.out.print(answer);
    }
}