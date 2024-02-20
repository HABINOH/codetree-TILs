import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[][] point = new int[n][2];
        for(int i=0;i<n;i++){
            StringTokenizer stk = new StringTokenizer(br.readLine(), " ");
            point[i][0] = Integer.parseInt(stk.nextToken());
            point[i][1] = Integer.parseInt(stk.nextToken());
        }
        int answer = Integer.MAX_VALUE;
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                int calX = (point[i][0] - point[j][0]) * (point[i][0] - point[j][0]);
                int calY = (point[i][1] - point[j][1]) * (point[i][1] - point[j][1]);
                answer = Math.min(answer, calX+calY);
            }
        }
        System.out.print(answer);
    }
}