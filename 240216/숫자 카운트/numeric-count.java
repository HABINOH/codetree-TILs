import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        
        int askNum[] = new int[n];
        int countOne[] = new int[n];
        int countTwo[] = new int[n];

        for(int i=0;i<n;i++){
            StringTokenizer stk = new StringTokenizer(br.readLine(), " ");
            askNum[i] = Integer.parseInt(stk.nextToken());
            countOne[i] = Integer.parseInt(stk.nextToken());
            countTwo[i] = Integer.parseInt(stk.nextToken());
        }

        int answer = 0;
        
        for(int i=1;i<10;i++){
            for(int j=1;j<10;j++){
                for(int k=1;k<10;k++){
                    if(i==j || j==k || k==i){continue;}
                    
                    boolean isSuccess = true;

                    for(int z=0;z<n;z++){
                        int one = askNum[z] / 100;
                        int two = askNum[z] / 10 % 10;
                        int three = askNum[z] % 10;

                        int cntOne = 0, cntTwo = 0;

                        if(i == one){cntOne++;}
                        if(j == two){cntOne++;}
                        if(k == three){cntOne++;}
                        if(j == one || k == one){cntTwo++;}
                        if(i == two || k == two){cntTwo++;}
                        if(i == three || j == three){cntTwo++;}

                        if(cntOne != countOne[z] || cntTwo != countTwo[z]){
                            isSuccess = false;
                            break;
                        }
                    }
                    if(isSuccess) answer++;
                }
            }
        }
        System.out.println(answer);
    }
}