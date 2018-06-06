package resolve;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by shancm on 2018/3/27.
 */
public class Resolve {
    public void resolve(String string){
//        List<String> orign = new ArrayList();
//        orign.add("RPC00028 > 30 && RPC00028 <= 100");
//        orign.add("RPC00028 > 100 && RPC00028 <= 140");
//        for (int i = 0; i < orign.size(); i++) {
//        }
        List<ArrayList<String>> orign = new ArrayList<>();
        List<ArrayList<String>> list = new ArrayList<>();
        String string1 = "RPC00028 > 30 && RPC00028 <= 100";
        String string2 = "RPC00028 > 100 && RPC00028 <= 140";
        String string3 = "RPC00028 > 140 && RPC00028 <= 240";
        orign.add(resolveItem(string1));
        orign.add(resolveItem(string2));
        orign.add(resolveItem(string3));
        for (int i = 0; i < orign.size(); i++) {
            for (int j = 1; j < orign.size(); j++) {
                if(i!=j){
                    if(!recognizeNum(orign.get(i), orign.get(j))){
                        System.out.println("repeat1");
                    }
                    if(recognizeSymbol(orign.get(i), orign.get(j))){
                        System.out.println("repeat2");
                    }
                }
            }
        }
    }

    private ArrayList<String> resolveItem(String string){
        String[] decomposed = string.split(" ");
        ArrayList<String> list = new ArrayList<>();
            for (int i = 0; i < decomposed.length; i++) {
                list.add(decomposed[i]);
        }
        return list;
    }

    public boolean hasSymbol(String string){
        List<String> symnol = new ArrayList();
        symnol.add(">=");
        symnol.add("<=");
        symnol.add("=");
        for (String str:symnol) {
            if(string.equals(str)){
                return true;
            }
        }
        return false;
    }

    public boolean recognizeNum(ArrayList<String> list1, List<String> list2){
        int list1front = Integer.parseInt(list1.get(2));
        int list1end = Integer.parseInt(list1.get(6));
        int list2front = Integer.parseInt(list2.get(2));
        int list2end = Integer.parseInt(list2.get(6));
        if(list1front>list2front){
            return list1end-list2front >= (list1end-list1front) + (list2end-list2front);
        }else {
            return list2end-list1front >= (list1end-list1front) + (list2end-list2front);
        }
    }

    //[RPC00028, >, 70, &&, RPC00028, <=, 120]
    //[RPC00028, >, 30, &&, RPC00028, <=, 70]
    public boolean recognizeSymbol(ArrayList<String> list1, List<String> list2){
        int list1front = Integer.parseInt(list1.get(2));
        int list1end = Integer.parseInt(list1.get(6));
        int list2front = Integer.parseInt(list2.get(2));
        int list2end = Integer.parseInt(list2.get(6));
        if(list1front==list2front) {
            if(hasSymbol(list1.get(1)) && hasSymbol(list2.get(5))){
                return true;
            }
        }
        if(list2front==list1front){
            if(hasSymbol(list2.get(1)) && hasSymbol(list1.get(5))){
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Resolve resolve = new Resolve();
        resolve.resolve("");
    }
}
