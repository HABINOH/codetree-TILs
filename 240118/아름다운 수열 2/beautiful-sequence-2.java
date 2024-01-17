import java.util.*;
import java.io.*;
public class Main {
    public static int n = 0;
    public static int m = 0;
    public static int[] arr = new int[3];
    public static boolean[] visit = new boolean[3];
    public static int result = 0;
    public static ArrayList<Integer> numberA = new ArrayList<>();
    public static ArrayList<int[]> comp = new ArrayList<>();
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        n = Integer.parseInt(stk.nextToken());
        m = Integer.parseInt(stk.nextToken());
        
        stk = new StringTokenizer(br.readLine(), " ");
        while(stk.hasMoreTokens()){
            numberA.add(Integer.parseInt(stk.nextToken()));
        }
        stk = new StringTokenizer(br.readLine(), " ");
        ArrayList<Integer> numberB = new ArrayList<>();
        while(stk.hasMoreTokens()){
            numberB.add(Integer.parseInt(stk.nextToken()));
        }
        comb(0, numberB);

        for(int i=0;i<comp.size();i++){
            int[] resultNumbers = comp.get(i);
            for(int j=0;j<=n-m;j++){
                if(numberA.get(j) == resultNumbers[0]
                && numberA.get(j+1) == resultNumbers[1]
                && numberA.get(j+2) == resultNumbers[2]){result++;}
            }
        }

        System.out.print(result);
    }
    public static void comb(int cnt, ArrayList<Integer> number){
        if(cnt==m){
            comp.add(Arrays.copyOf(arr, arr.length));
            return;
        }
        for(int i=0;i<m;i++){
            if(!visit[i]){
                visit[i] = true;
                arr[cnt] = number.get(i);
                comb(cnt+1, number);
                visit[i] = false;
            }
        }
    }
}