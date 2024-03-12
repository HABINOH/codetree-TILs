import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        LinkedList<Integer> list = new LinkedList<>();

        for(int i=0;i<n;i++){
            StringTokenizer stk = new StringTokenizer(br.readLine());
            String str = stk.nextToken();

            if(str.equals("push_front")){
                list.addFirst(Integer.parseInt(stk.nextToken()));
            }else if(str.equals("push_back")){
                list.addLast(Integer.parseInt(stk.nextToken()));
            }else if(str.equals("pop_front")){
                bw.write(list.pollFirst() + "\n");
            }else if(str.equals("pop_back")){
                bw.write(list.pollLast() + "\n");
            }else if(str.equals("size")){
                bw.write(list.size() + "\n");
            }else if(str.equals("empty")){
                if(list.isEmpty()){
                    bw.write("1\n");
                }else {
                    bw.write("0\n");
                }
            }else if(str.equals("front")){
                bw.write(list.peekFirst() + "\n");
            }else {
                bw.write(list.peekLast() + "\n");
            }
        }
        bw.flush();
        bw.close();
    }
}