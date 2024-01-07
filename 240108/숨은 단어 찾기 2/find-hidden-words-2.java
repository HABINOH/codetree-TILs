import java.util.*;
import java.io.*;

public class Main {
    public static int[] dx = new int[]{1,1,0,-1,-1,-1,0,1};
    public static int[] dy = new int[]{0,1,1,1,0,-1,-1,-1};
    public static int n;
    public static int m;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(stk.nextToken());
        m = Integer.parseInt(stk.nextToken());

        char[][] map = new char[n][m];
        for(int i=0;i<n;i++){
            String s = br.readLine();
            for(int j=0;j<s.length();j++){
                map[i][j] = s.charAt(j);
            }   
        }
        int result = 0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(map[i][j] == 'L'){
                    for(int k=0;k<8;k++){
                        int cnt = 1;
                        int curX = i; int curY = j;
                        while(true){
                            int nx = dx[k] + curX;
                            int ny = dy[k] + curY;

                            if(inRange(nx, ny)){break;}
                            if(map[nx][ny] == 'E'){
                                cnt++;
                            }else{break;}
                            if(cnt==3){result++;}
                            curX = nx; curY = ny;
                        }
                    }
                }
            }
        }
        System.out.println(result);
    }
    public static boolean inRange(int x, int y){
        return x<0 || y<0 || x>=n || y>=m;
    }
}