import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer stk = new StringTokenizer(br.readLine() ," ");

        int n = Integer.parseInt(stk.nextToken());
        int m = Integer.parseInt(stk.nextToken());

        char[][] board = new char[n][m];
        for(int i=0;i<n;i++){
            StringTokenizer inputBorad = new StringTokenizer(br.readLine(), " ");
            int j = 0;
            while(inputBorad.hasMoreTokens()){
                board[i][j++] = inputBorad.nextToken().charAt(0);
            }
        }
        int result=0;
        for(int i=1;i<n;i++){
            for(int j=1;j<m;j++){
                for(int k=i+1;k<n-1;k++){
                    for(int z=j+1;z<m-1;z++){
                        if(board[0][0] != board[i][j] && 
                        board[i][j] != board[k][z] &&
                        board[k][z] != board[n-1][m-1]){result++;}
                    }
                }   
            }
        }
        System.out.println(result);
    }
}