package java8.stream;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author shancm
 * @package java8.stream
 * @description:
 * @date 2018/6/21
 */
public class StreamDemo {


	public static void main(String[] args) {
		List<String> list = new ArrayList<>();
		list.add("tom");
		list.add("jerry");
		list.add("john");
        /*List<String> j = list.stream().filter(n ->
                n.startsWith("j")
        ).collect(Collectors.toList());*/
//        list.removeIf(n-> n.startsWith("j") && !n.endsWith("n"));

//        System.out.println(j);


//        list.stream().filter(n->n.startsWith("j")).map(n->list.remove(n));



        /*Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()){
            String next = iterator.next();
            if(next.startsWith("j")){
                iterator.remove();
                continue;
            }
            System.out.println("123");
        }
        System.out.println(list);*/

		List<Person> people = new ArrayList<>();

		people.add(new Person(3));
		people.add(new Person(4));
		people.add(new Person(1));
		people.add(new Person(2));

		people.forEach(n-> System.out.println(n.toString()));

		people.sort(Comparator.comparingInt(n->n.getAge()));
		people.forEach(n-> System.out.println(n.toString()));
	}


}
