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
        ListIterator<Character> it = list.listIterator(list.size()); 
        for(int i=0;i<secret;i++){
            stk = new StringTokenizer(br.readLine());
            str = stk.nextToken();
            if(str.equals("R")){
                if(it.hasNext()) 
                    it.next();
            }else if(str.equals("L")){
                if(it.hasPrevious())
                    it.previous();
            }else if(str.equals("D")){
                if(it.hasNext()){
                    it.next();
                    it.remove();
                }
            }else{
                char c = stk.nextToken().charAt(0);
                it.add(c);
            }
        }
        it = list.listIterator();
        while(it.hasNext())
            System.out.print(it.next());
        
    }
}