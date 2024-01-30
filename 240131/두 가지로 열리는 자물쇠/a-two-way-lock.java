import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        ArrayList<Integer> lockOne = new ArrayList<>();
        ArrayList<Integer> lockTwo = new ArrayList<>();

        StringTokenizer stk = new StringTokenizer(br.readLine(), " ");
        for(int i=0;i<3;i++){lockOne.add(Integer.parseInt(stk.nextToken()));}

        stk = new StringTokenizer(br.readLine(), " ");
        for(int i=0;i<3;i++){lockTwo.add(Integer.parseInt(stk.nextToken()));}

        int answer = 0;
        for(int i=1;i<=n;i++){
            for(int j=1;j<=n;j++){
                for(int k=1;k<=n;k++){
                    String str = "";
                    if((Math.abs(lockOne.get(0) - i) <= 2 || Math.abs(lockOne.get(0) - i) >= n-2)
                        && (Math.abs(lockOne.get(1) - j) <= 2 || Math.abs(lockOne.get(1) - j) >= n-2)
                        && (Math.abs(lockOne.get(2) - k) <= 2 || Math.abs(lockOne.get(2) - k) >= n-2)
                    ){answer++;}
                    else if((Math.abs(lockTwo.get(0) - i) <= 2 || Math.abs(lockTwo.get(0) - i) >= n-2)
                        && (Math.abs(lockTwo.get(1) - j) <= 2 || Math.abs(lockTwo.get(1) - j) >= n-2)
                        && (Math.abs(lockTwo.get(2) - k) <= 2 || Math.abs(lockTwo.get(2) - k) >= n-2)
                    ){answer++;}
                }
            }
        }
        System.out.println(answer);
    }
}