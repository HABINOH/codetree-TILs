import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer stk = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(stk.nextToken());
        int budget = Integer.parseInt(stk.nextToken());
        int[] student = new int[n];
        for(int i=0;i<n;i++){
            student[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(student);

        int answer = 0;
        for(int i=0;i<n;i++){
            int tempBudget = budget;
            int cnt = 1;
            //i를 반값으로
            tempBudget -= student[i] / 2;
            
            for(int j=0;j<n;j++){
                if(i==j){continue;}
                //j들 선물주기
                if(tempBudget - student[j] >= 0){
                    tempBudget -= student[j];
                    cnt++;
                }
            }
            answer = Math.max(answer, cnt);
        }
        System.out.print(answer);
    }
}