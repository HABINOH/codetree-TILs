import java.util.*;
import java.io.*;
public class Main {
    public static int n = 0;
    public static int m = 0;
    public static int[] arr;
    public static boolean[] visit;
    public static int result = 0;
    public static ArrayList<Integer> numberA = new ArrayList<>();
    public static ArrayList<int[]> comp = new ArrayList<>();
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        n = Integer.parseInt(stk.nextToken());
        m = Integer.parseInt(stk.nextToken());
        arr = new int[m];
        visit = new boolean[m];
        
        stk = new StringTokenizer(br.readLine(), " ");
        while(stk.hasMoreTokens()){
            numberA.add(Integer.parseInt(stk.nextToken()));
        }
        stk = new StringTokenizer(br.readLine(), " ");
        ArrayList<Integer> numberB = new ArrayList<>();
        while(stk.hasMoreTokens()){
            numberB.add(Integer.parseInt(stk.nextToken()));
        }
        Collections.sort(numberB);
        int[] temp = new int[m];
        for(int i=0;i<=n-m;i++){
            for(int j=0;j<m;j++){ //전체 요소(N)에서 M 개수만큼 비교 할 요소 빼기
                temp[j] = numberA.get(i+j);
            }
            Arrays.sort(temp); //뺀 요소 정렬
            int count = 0;
            for(int k=0;k<temp.length;k++){
                if(temp[k] == numberB.get(k)){
                    count++;
                }
            }
            if(count == temp.length){
                result++;
            }
        }
        System.out.println(result);
    }
}