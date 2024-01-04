import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] people = new int[n+1];
        for(int i=1;i<=n;i++){
           people[i] = Integer.parseInt(br.readLine());
        }
        int minDist = Integer.MAX_VALUE;
        for(int i=1;i<=n;i++){
            int distSum = 0;
            for(int j=1;j<=n;j++){
                // 방과 방 사이 거리
                // i<j => j-i && i>j => j-i+n
                // 위에 두개를 묶어서 하려면 %n 이 필요함
                int dist = (j-i+n) % n; 
                distSum += dist * people[j];
            }
            minDist = Math.min(minDist, distSum);
        }
        System.out.println(minDist);

    }
}