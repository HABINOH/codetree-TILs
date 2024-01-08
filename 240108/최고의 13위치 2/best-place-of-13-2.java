import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        
        int[][] map = new int[n][n];
        for(int i=0;i<n;i++){
            StringTokenizer stk = new StringTokenizer(br.readLine(), " ");
            int j = 0;
            while(stk.hasMoreTokens()){
                map[i][j++] = Integer.parseInt(stk.nextToken());
            }
        }
        int sum = 0;
        int result = 0;
        for(int i=0;i<n-1;i++){
            for(int j=0;j<n-2;j++){
                //1*3 격자 잡기
                for(int k=i+1;k<n;k++){
                    for(int z=0;z<n-2;z++){
                        //1*3 2번째 격자 잡기
                        sum = map[i][j] + map[i][j+1] + map[i][j+2];
                        sum += map[k][z] + map[k][z+1] + map[k][z+2];

                        result = Math.max(result, sum);
                    }
                }
            }
        }
        //마지막 줄 체크
        for(int i=n-1;i<n;i++){
            for(int j=0;j<n-5;j++){
                sum = map[i][j] + map[i][j+1] + map[i][j+2];
                for(int k=j+1;k<n-5;k++){
                    sum += map[i][k] + map[i][k+1] + map[i][k+2];
                }
                result = Math.max(result, sum);
            }
        }
        System.out.println(result);
    }
}