import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String number = br.readLine();
        String[] numbers = number.split(" ");

        int a = Integer.parseInt(numbers[0]);
        int b = Integer.parseInt(numbers[1]);
        int c = Integer.parseInt(numbers[2]);

        System.out.println(a+b+c);
        System.out.println((a+b+c) / 3);

    }
}