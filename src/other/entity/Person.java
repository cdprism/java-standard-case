package other.entity;

/**
 * @author shancm
 * @pachage other.entity
 * @description:
 * @date 2018/6/8
 */
public class Person {
    protected String name;
    protected Integer age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }


    public static void main(String[] args) {
        System.out.println(new Person());
    }
}
