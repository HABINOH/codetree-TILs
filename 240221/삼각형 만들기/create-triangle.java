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
            for(int j=i+1;j<n;j++){
                for(int k=j+1;k<n;k++){
                    answer = Math.max(answer, Math.abs(getRectangleArea(i,j,k)));
                }
            }
        }
        System.out.print(answer);
    }
    public static int getRectangleArea(int one, int two, int three){
        int cal = 0;
        if(((x[one] == x[two]) || (x[one] == x[three]) || (x[two] == x[three])) || ((y[one] == y[two]) || (y[one] == y[three]) || (y[two] == y[three]))) {
            cal = ((x[one] * y[two]) + (x[two] * y[three]) + (x[three] * y[one]))
            - ((x[two] * y[one]) + (x[three] * y[two]) + (x[one] * y[three]));
        }
        return cal;
    }
}