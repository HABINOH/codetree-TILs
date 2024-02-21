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
        int dis = Integer.MAX_VALUE;
        int answer = 0;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(i==j){continue;}
                //i j 위치 차이 구하기
                int compDis = Math.abs(point[i][0] - point[j][0]) + Math.abs(point[i][1] - point[j][1]);
                //작은 값 갱신하기
                if(dis >= compDis){
                    answer = Math.abs(point[i][0] - point[j][0]) * Math.abs(point[i][0] - point[j][0]);
                    answer += Math.abs(point[i][1] - point[j][1]) * Math.abs(point[i][1] - point[j][1]);
                    dis = compDis;
                }
                //갱신되면 두 점사이 거리의 제곱값 저장
            }
        }
        //출력
        System.out.print(answer);
    }
}