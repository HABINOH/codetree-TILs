import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int[] numbers = Arrays.stream(str.split(""))
                            .mapToInt(Integer::parseInt)
                            .toArray();

        int len = numbers.length;
        int maxNumber = 0;
        for(int i=1;i<len;i++){
            if(numbers[i] == 0){numbers[i] = 1;}
            else {numbers[i] = 0;}

            maxNumber = Math.max(maxNumber, changeNumber(numbers));
            //System.out.println("maxNumber" + maxNumber);

            if(numbers[i] == 0){numbers[i] = 1;}
            else {numbers[i] = 0;}
        }
        System.out.println(maxNumber);
    }

    public static int changeNumber(int[] numbers){
        int mul = 1;
        int result = 0;
        for(int i=numbers.length-1;i>=0;i--){
            result += numbers[i] * mul;
            //System.out.println("result" + result);
            mul *= 2;
        }
        return result;
    }
}