import java.util.*;
import java.io.*;

public class Main {
    public static int[] dx = new int[]{1, 1, 1, -1, -1, -1, 0, 0};
    public static int[] dy = new int[]{-1, 0, 1, -1, 0, 1, -1, 1};
    public static int[][] map = new int[19][19];
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for(int i=0;i<19;i++){
            StringTokenizer stk = new StringTokenizer(br.readLine(), " ");
            int j=0;
            while(stk.hasMoreTokens()){
                map[i][j++] = Integer.parseInt(stk.nextToken());
            }
        }
        int result = 0;
        for(int i=0;i<19;i++){
            for(int j=0;j<19;j++){
                if(map[i][j] == 1 || map[i][j] == 2){
                    for(int k=0;k<8;k++){
                        int cnt = 1;
                        int curX = i;
                        int curY = j;

                        while(true){
                            int nx = curX + dx[k];
                            int ny = curY + dy[k];
                            if(inRange(nx,ny)){break;}
                            if(map[nx][ny] != map[curX][curY]){break;}
                            cnt++;
                            curX = nx; curY = ny;
                        }
                        if(cnt == 5){
                            System.out.println(map[i][j]);
                            System.out.println((i + 2 * dx[k] + 1) + " " + (j + 2 * dy[k] + 1));
                            System.exit(0);
                        }
                    }
                }
            }
        }
        System.out.println(0);
    }
    
    public static boolean inRange(int x, int y){
        return x<0 || y<0 || x>=19 || y>=19;
    }
}