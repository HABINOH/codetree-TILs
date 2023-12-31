import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String n = br.readLine();
        String cow = br.readLine();
        String[] cows = cow.split(" ");

        int result = 0;
        for(int i=0;i<cows.length-2;i++){
            for(int j=i+1;j<cows.length-1;j++){
                for(int k=j+1;k<cows.length;k++){
                    if(Integer.parseInt(cows[i]) <= Integer.parseInt(cows[j])
                     && Integer.parseInt(cows[j]) <= Integer.parseInt(cows[k])){
                        result++;
                    }
                } 
            }
        }
        System.out.println(result);
    }
}