package other.colletion2;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author shancm
 * @package other.colletion2
 * @description:
 * @date 2018/6/29
 */
public class colletionDemo {

//    private final List<Integer> list = new ArrayList<>(2);
    private  List<Integer> list = new ArrayList<>(2);

    public static void main(String[] args) {
        colletionDemo streamDemo = new colletionDemo();
        streamDemo.list =  new LinkedList<>();
        streamDemo.list.add(2);
        System.out.println(streamDemo.list);
    }
}
