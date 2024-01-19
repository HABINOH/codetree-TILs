import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());
        int t = Integer.parseInt(st.nextToken());

        int answer;

        st = new StringTokenizer(br.readLine());
        int[] heights = new int[n];
        for(int i = 0; i < n; i++){
            heights[i] = Integer.parseInt(st.nextToken());
        } 
        int[] diff = new int[n];

        for(int i = 0; i < n; i++){
            diff[i] = Math.abs(h - heights[i]);
        }

        int sum = 0;

        for(int i = 0; i < t; i++){
            sum += diff[i];
        }

        answer = sum;

        int start = 0;
        for(int i = t; i <n; i++){
            sum -= diff[start++];
            sum += diff[i];
            if(answer > sum){
                answer = sum;
            }
        }
        System.out.println(answer);
    }
}