import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[][] point = new int[n][2];
        int answer = Integer.MAX_VALUE;

        for(int i=0;i<n;i++){
            StringTokenizer stk = new StringTokenizer(br.readLine(), " ");
            point[i][0] = Integer.parseInt(stk.nextToken());
            point[i][1] = Integer.parseInt(stk.nextToken());
        }

        for(int i=0;i<n;i++){
            int minX=Integer.MAX_VALUE;
            int minY=Integer.MAX_VALUE;
            int maxX=Integer.MIN_VALUE;
            int maxY=Integer.MIN_VALUE;
            for(int j=0;j<n;j++){
                if(i==j){continue;}

                //왼쪽 작은 값
                minX = Math.min(minX, point[j][0]);
                //오른쪽 작은 값
                minY = Math.min(minY, point[j][1]);

                //위쪽 큰 값
                maxX = Math.max(maxX, point[j][0]);
                //아랫쪽 작은 값
                maxY = Math.max(maxY, point[j][1]);
            }
            //사각형 넓이 구하기
            int result = (maxX - minX) * (maxY - minY);
            answer = Math.min(answer, result);
        }
        System.out.print(answer);
    }
}