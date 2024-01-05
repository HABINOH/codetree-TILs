import java.util.*;
import java.io.*;

public class Main {
    public static int[] dx = new int[]{0,1,0,-1};
    public static int[] dy = new int[]{1,0,-1,0};
    public static int[][] map = new int[19][19];
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for(int i=0;i<19;i++){
            StringTokenizer stk = new StringTokenizer(br.readLine(), " ");
            int j=0;
            while(stk.hasMoreTokens()){
                map[i][j] = Integer.parseInt(stk.nextToken());
            }
        }
        int result = 0;
        for(int i=0;i<19;i++){
            for(int j=0;j<19;j++){
                if(map[i][j] == 1 || map[i][j] == 2){
                    if(dfs(i,j, 1)){
                        result = map[i][j];
                    }
                }
            }
        }
        System.out.println(result);
    }
    public static boolean dfs(int x, int y, int cnt){
        if(cnt == 5){
            return true;
        }
        for(int i=0;i<4;i++){
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(Inrange(nx,ny)){continue;}
            if(map[nx][ny] == map[x][y]){
                dfs(nx,ny,cnt+1);
            }
        }
        return false;
    }
    public static boolean Inrange(int x, int y){
        return x<0 || y<0 || x>=19 || y>=19;
    }
}