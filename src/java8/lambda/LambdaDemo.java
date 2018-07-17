package java8.lambda;


import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author shancm
 * @pachage java8.lambda
 * @description:
 * @date 2018/6/11
 */
public class LambdaDemo {

    public static void main(String[] args) {
        /*Thread thread = new Thread(()->{
            System.out.println(Thread.currentThread().getName());
        });
        thread.start();*/

        List<String> list = new ArrayList<>(Arrays.asList("jerry", "tom", "john"));

        List<String> collect = list.parallelStream().filter(n -> n.startsWith("j")).collect(Collectors.toList());
        Set<String> set = list.parallelStream().filter(n -> n.startsWith("j")).collect(Collectors.toSet());
        /*set.forEach(n->{
            System.out.println(n);
        });*/
        List<String> list1 = list.parallelStream().map(n -> n.toUpperCase()).collect(Collectors.toList());
        list1.forEach(n -> {
            System.out.println(n);
        });
        /*collect.forEach(n->{
             if(n.startsWith("j")){
                 System.out.println(n);
             }
        });*/
    }
}
