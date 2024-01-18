import java.util.*;
import java.io.*;
public class Main {
    public static char[] line = new char[102]; 
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        for(int i=0;i<n;i++){
            StringTokenizer stk = new StringTokenizer(br.readLine(), " ");
            int pos = Integer.parseInt(stk.nextToken());
            char ch = stk.nextToken().charAt(0);
            line[pos] = ch;
        }
        //start 와 end 를 잡고
        //H와 G 개수가 다르면 start를 한칸 땡기고
        //비교하고 그래도 다르면 end를 한칸 땡기고
        //반복 -> 2중 for문으로 완전탐색
        int answer = 0;
        for(int i=0;i<=101;i++){
            for(int j=i+1; j<=101; j++){
                if((line[i] == 'G' || line[i] == 'H') && (line[j] == 'G' || line[j] == 'H')){
                    int cntH = 0;
                    int cntG = 0;
                    
                    for(int k=i; k<j+1; k++){
                        if(line[k] == 'H'){cntH++;}
                        else if(line[k] == 'G'){cntG++;}
                    }
                    if(cntH == cntG){
                        answer = Math.max(answer, j-i);
                    }
                }
            }
        }
        System.out.println(answer);
    }
}