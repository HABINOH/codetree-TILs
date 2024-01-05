import java.util.*;
import java.io.*;

public class Main {
    public static int[][] number = new int[3][5];

    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] numbers = new String[n];
        for(int i=0;i<n;i++){
            numbers[i] = br.readLine();
        }
        int result = -1;
        for(int i=0; i<n-2; i++){
            for(int j=i+1; j<n-1; j++){
                for(int k=j+1; k<n; k++){
                    int carryNum = carry(numbers[i], numbers[j], numbers[k]);
                    result = Math.max(result, carryNum);
                    number = new int[3][5];
                }
            }
        }
        System.out.println(result);
    }
    public static int carry(String one, String two, String three){
        numberSet(one, 0);
        numberSet(two, 1);
        numberSet(three, 2);

        int[] sum = new int[5];
        for(int i=0;i<5;i++){
            sum[i] = (number[0][i] + number[1][i] + number[2][i]);
            if(sum[i] >= 10 ){
                return -1;
            }
        }
        String str = Integer.toString(sum[4]) + Integer.toString(sum[3]) + Integer.toString(sum[2]) + Integer.toString(sum[1]) + Integer.toString(sum[0]);
        
        return Integer.parseInt(str);
    }
    //0 : 4자리
    //1 : 3자리
    //2 : 2자리
    //3 : 1자리
    public static void numberSet(String num, int idx){
        if(num.length() > 4){
            number[idx][4] = Character.getNumericValue(num.charAt(0));
            number[idx][3] = Character.getNumericValue(num.charAt(1));
            number[idx][2] = Character.getNumericValue(num.charAt(2));
            number[idx][1] = Character.getNumericValue(num.charAt(3));
            number[idx][0] = Character.getNumericValue(num.charAt(4));
        }
        else if(num.length() > 3){
            number[idx][3] = Character.getNumericValue(num.charAt(0));
            number[idx][2] = Character.getNumericValue(num.charAt(1));
            number[idx][1] = Character.getNumericValue(num.charAt(2));
            number[idx][0] = Character.getNumericValue(num.charAt(3));
        }
        else if(num.length() > 2){
            number[idx][2] = Character.getNumericValue(num.charAt(0));
            number[idx][1] = Character.getNumericValue(num.charAt(1));
            number[idx][0] = Character.getNumericValue(num.charAt(2));
        }
        else if(num.length() > 1){
            number[idx][1] = Character.getNumericValue(num.charAt(0));
            number[idx][0] = Character.getNumericValue(num.charAt(1));
        }
        else if(num.length() > 0){
            number[idx][0] = Character.getNumericValue(num.charAt(0));
        }
    }
}