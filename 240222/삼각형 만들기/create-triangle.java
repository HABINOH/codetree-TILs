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
        int answer = 0;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(i!=j){
                    for(int k=0;k<n;k++){
                        if(i!=k && j!=k){
                            if((x[i] == x[j] || x[i] == x[k] || x[j] == x[k]) && 
                            (y[i] == y[j] || y[i] == y[k] || y[j] == y[k])){
                                answer = Math.max(answer, getArea(i,j,k));
                            }
                        }
                    }
                }
            }
        }
        System.out.println(answer);
    }
    public static int getArea(int i, int j, int k){
        return Math.abs( 
            (x[i] * y[j] + x[j] * y[k] + x[k] * y[i]) - 
            (x[j] * y[i] + x[k] * y[j] + x[i] * y[k]) );
    }
}