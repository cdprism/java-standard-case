package other.temp;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @author shancm
 * @package other.temp
 * @description:
 * @date 2018/8/29
 */
public class IteratorTemp {

	public static void main(String[] args) throws ParseException {
		Integer[] aray = {1, 2, 3, 4};
		List<Integer> list = Arrays.asList(aray);

		/*Iterator<Integer> iterator = list.iterator();

		while (iterator.hasNext()){
			Integer next = iterator.next();
			iterator.remove();
			System.out.println(next);
		}*/

		/*boolean overDueState = false;

		if(!overDueState){
			for (Integer i : aray) {
				overDueState = Objects.equals(i, 3);
				if(overDueState){
					break;
				}
			}
		}
		System.out.println(overDueState);*/

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		String beforeDate = "2018-8-31 11:00:00";
		String afterDate = "2018-8-31 23:00:00";
		Date now = new Date();
		Date before = sdf.parse(beforeDate);
		Date after = sdf.parse(afterDate);
		System.out.println(now.compareTo(before));
		System.out.println(now.getTime() - before.getTime());

		System.out.println(after.getTime() - before.getTime());




	}
}
