import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String str = br.readLine();

        int result = 0;
        for(int i=0;i<str.length()-2;i++){
            for(int j=i+1;j<str.length()-1;j++){
                for(int k=j+1;k<str.length();k++){
                    if(str.charAt(i) == 'C' && str.charAt(j) == 'O' && str.charAt(k) == 'W'){
                        result++;
                    }
                }
            }
        }
        System.out.println(result);
    }
}