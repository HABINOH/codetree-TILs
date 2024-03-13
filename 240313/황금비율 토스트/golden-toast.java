import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer stk = new StringTokenizer(br.readLine());
        int bread = Integer.parseInt(stk.nextToken());
        int secret = Integer.parseInt(stk.nextToken());

        LinkedList<Character> list = new LinkedList<>();
        stk = new StringTokenizer(br.readLine());
        String str = stk.nextToken();
        for(int i=0;i<str.length();i++){
            list.addLast(str.charAt(i));
        }
        ListIterator<Character> it = list.listIterator(list.size()-1); 
        for(int i=0;i<secret;i++){
            stk = new StringTokenizer(br.readLine());
            str = stk.nextToken();
            if(str.equals("L")){
                if(it.hasNext()) 
                    it.next();
            }else if(str.equals("R")){
                if(it.hasPrevious())
                    it.previous();
            }else if(str.equals("D")){
                if(it.hasPrevious()){
                    it.previous();
                }
                it.remove();
            }else{
                char c = stk.nextToken().charAt(0);
                it.add(c);
            }
        }
        for(int i=0;i<list.size();i++){
            System.out.print(list.get(i));
        }
    }
}