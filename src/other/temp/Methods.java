package other.temp;

import other.entity.Person;

import java.util.Objects;

/**
 * @author shancm
 * @package other.temp
 * @description:
 * @date 2018/8/1
 */
public class Methods {

	private void count() throws InterruptedException {
		for (int i = 0; i < 10; i++) {
			System.out.println(i);
			Thread.sleep(500L);
		}
	}

	public static void main(String[] args) throws InterruptedException {
//		Methods methods = new Methods();
//		methods.count();
//		methods.count();
		Person person = new Person();
		person.setName("");
		System.out.println(Objects.isNull(person.getName()));
	}


}
