package collection;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by shancm on 2018/3/24.
 */
public class HashMapi {

    private LinkedListi[] listi;
    private int size;

    public void put(Object key, Object value){
        Entry entry = new Entry(key, value);
        int index = key.hashCode()%9999;
        //遍历listi[index]如果有元素的key与entry.key相同 则覆盖
        listi[index].add(entry);
        size++;
    }
    public Object get(Object key){return new Object();}
    public Object remove(Object key){return new Object();}

    @Override
    public String toString() {
        if(size==0){
            return "[]";
        }
        StringBuffer sb = new StringBuffer();
        sb.append("[");
        for (LinkedListi list : listi) {

        }
       return "";
    }

    boolean containsKay(Object key){return true;}
    boolean containsValue(Object key){return true;}
    int sieze(){return 1;}

    public HashMapi() {
        listi = new LinkedListi[999];
        size = 0;
    }

    public static void main(String[] args) {
        Map map = new HashMap();
    }

    class Entry{
        private Object key;

        public Object getKey() {
            return key;
        }

        public void setKey(Object key) {
            this.key = key;
        }

        public Object getValue() {
            return value;
        }

        public void setValue(Object value) {
            this.value = value;
        }

        public Entry() {

        }

        public Entry(Object key, Object value) {

            this.key = key;
            this.value = value;
        }

        private Object value;
    }
}
