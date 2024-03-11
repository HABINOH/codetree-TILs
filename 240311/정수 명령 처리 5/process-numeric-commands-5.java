import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        ArrayList<Integer> list = new ArrayList<>();

        for(int i=0;i<n;i++){
            StringTokenizer stk = new StringTokenizer(br.readLine());
            String command = stk.nextToken();
            if(command.equals("push_back")){
                list.add(Integer.parseInt(stk.nextToken()));
            }else if(command.equals("pop_back")){
                list.remove(list.size()-1);
            }else if(command.equals("size")){
                System.out.println(list.size());
            }else{
                int index = Integer.parseInt(stk.nextToken());
                System.out.println(list.get(index-1));
            }
        }
    }
}