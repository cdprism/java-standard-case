package collection;

import java.util.Arrays;

/**
 * Created by shancm on 2018/3/21.
 */
public class ArrayListi {
    private static final int DEFAULTCAPACITY = 10;
    private Object[] element;
    private Integer size;
    private Integer capacity;

    public ArrayListi(){
        this(DEFAULTCAPACITY);
    }

    public ArrayListi(int icapacity){
        capacity = icapacity;
        size=0;
        this.element = new Object[capacity];
    }

    public int size() {
        return size;
    }

    public Object get(int index) {
        return element[index];
    }

    public boolean isEmpty() {
        if(element[0] != null) {
            return false;
        }else {
            return true;
        }
    }

    public void add(Object obj){
        if(capacity == size){
            ++capacity;
        }
        Object[] newobj = Arrays.copyOf(element, capacity);
        newobj[size] = obj;
        element = newobj;
        size++;
    }

    public boolean remove(Object object) {
        for (int i = 0; i < element.length; i++) {
            if(object.equals(element[i])) {
                System.arraycopy(element, i+1, element, i, size-i-1);
                /*size--;
                element = Arrays.copyOf(element, size);*/
                element[--size] = null;
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        StringBuilder string = new StringBuilder();
        for (Object object : element) {
            if(object != null) {
                string.append(object);
            }
        }
        return "["+string.toString()+"]";
    }

    public static void main(String[] args) {
        ArrayListi arrayi = new ArrayListi(1);
        arrayi.add(1);
        arrayi.add(2);
        arrayi.add(2);
        arrayi.add(3);
        System.out.println(arrayi.remove(4));
        System.out.println(arrayi);
        for (int i=0; i<arrayi.size; i++
             ) {
            System.out.println(arrayi.get(i));
        }
    }
}
