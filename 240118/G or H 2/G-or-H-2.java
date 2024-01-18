import java.util.*;
import java.io.*;
public class Main {
    public static char[] line = new char[101]; 
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int start = 201;
        int end = 0;
        for(int i=0;i<n;i++){
            StringTokenizer stk = new StringTokenizer(br.readLine(), " ");
            int pos = Integer.parseInt(stk.nextToken());
            char ch = stk.nextToken().charAt(0);
            line[pos] = ch;
            start = Math.min(start, pos);
            end = Math.max(end, pos);
        }
        //start 와 end 를 잡고
        //H와 G 개수가 다르면 start를 한칸 땡기고
        //비교하고 그래도 다르면 end를 한칸 땡기고
        //반복
        int answer = 0;
        boolean flag = true;
        while(start!=end){
            int cntH = 0;
            int cntG = 0;
            for(int i=start; i<=end; i++){
                if(line[i] == 'H'){cntH++;}
                else if(line[i] == 'G'){cntG++;}
            }
            if(cntH == cntG){
                answer = end - start;
                break;
            }else{
                if(flag){
                    for(int i=start+1; i<=end; i++){
                        if(line[i] == 'H' || line[i] == 'G'){
                            start = i;
                            break;
                        }
                    }
                }else{
                    for(int i=end-1; i>=start; i--){
                        if(line[i] == 'H' || line[i] == 'G'){
                            end = i;
                            break;
                        }
                    }
                }
                flag = !flag;
            }
        }
        System.out.println(answer);
    }
}