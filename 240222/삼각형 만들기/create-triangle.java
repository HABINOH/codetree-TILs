import java.util.*;
import java.io.*;
public class Main {
    static int[] x = new int[100];
    static int[] y = new int[100];
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        for(int i=0;i<n;i++){
            StringTokenizer stk = new StringTokenizer(br.readLine(), " ");
            x[i] = Integer.parseInt(stk.nextToken());
            y[i] = Integer.parseInt(stk.nextToken());
        }
        int answer = Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(i!=j){
                    for(int k=0;k<n;k++){
                        if(k!=i && k!=j){
                            answer = Math.max(answer, getRectangleArea(i,j,k));
                        }
                    }
                }
            }
        }
        System.out.print(answer);
    }
    public static int getRectangleArea(int one, int two, int three){
        int width = 0, height = 0;
        if(((x[one] == x[two]) || (x[one] == x[three]) || (x[two] == x[three])) || ((y[one] == y[two]) || (y[one] == y[three]) || (y[two] == y[three]))) {
            // x축과 y축에 평행한 변을 찾아 넓이 계산
            width = Math.max(Math.abs(x[one] - x[two]), Math.abs(x[one] - x[three]));
            width = Math.max(width, Math.abs(x[two] - x[three]));
            
            height = Math.max(Math.abs(y[one] - y[two]), Math.abs(y[one] - y[three]));
            height = Math.max(height, Math.abs(y[two] - y[three]));
        }
        return width * height; // 직사각형 삼각형의 넓이 반환
    }
}