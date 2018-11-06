package java8.stream;

/**
 * @author shancm
 * @package java8.stream
 * @description:
 * @date 2018/11/6
 */
public class Person {

	private Integer age;

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public Person(Integer age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "Person{" +
				"age=" + age +
				'}';
	}
}
