import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        String[][] str = new String[n][n];

        for(int i=0;i<n;i++){
            String s = br.readLine();
            str[i] = s.split(" ");
        }
        int result = 0;
        for(int i=0;i<n;i++){
            for(int j=0;j<n-2;j++){
                result = Math.max(result , Integer.parseInt(str[i][j])
                +Integer.parseInt(str[i][j+1])
                +Integer.parseInt(str[i][j+2]));
            }
        }
        System.out.println(result);
    }
}