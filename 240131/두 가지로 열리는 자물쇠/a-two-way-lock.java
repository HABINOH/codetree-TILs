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
/* 식 도출
원형에서 두 수 a, b가 n이라는 수를 건너서 만나는 경우에 대한 식
건너서 만나는 경우의 거리를 k라 했을 때, 
k <= 2인지가 궁금한 상황
여기서 양변에 -를 붙이면 -k >= -2가 되고 
양변에 n을 더하면 n - k >= n - 2가 된다. 
n - k는 건너서 만나지 않았을 때의 거리이므로 
이 값은 두 수의 차의 절댓값인 |a-b|로 표현가능
따라서 |a - b| >= n - 2인지를 확인
*/