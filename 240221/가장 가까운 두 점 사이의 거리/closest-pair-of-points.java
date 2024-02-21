import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] pointX = new int[n];
        int[] pointY = new int[n];

        for(int i=0;i<n;i++){
            StringTokenizer stk = new StringTokenizer(br.readLine(), " ");
            pointX[i] = Integer.parseInt(stk.nextToken());
            pointY[i] = Integer.parseInt(stk.nextToken());
        }
        int answer = Integer.MAX_VALUE;;
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                //i j 위치 차이 구하기
                //작은 값 갱신하기
                int cal = (pointX[i] - pointX[j]) * (pointX[i] - pointX[j]) 
                + (pointY[i] - pointY[j]) * (pointY[i] - pointY[j]);
                answer = Math.min(answer, cal);
            }
        }
        //출력
        System.out.print(answer);
    }
}