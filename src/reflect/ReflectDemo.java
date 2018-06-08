package reflect;

import java.lang.reflect.Field;

/**
 * @author shancm
 * @pachage reflect
 * @description:
 * @date 2018/6/7
 */
public class ReflectDemo {
    public static void main(String[] args) {
        ReflectObj obj = new ReflectObj();
        Field[] fields = ReflectObj.class.getDeclaredFields();
        for (Field field : fields) {
            System.out.println(field);
        }

        /*Field[] fields1 = ReflectObj.class.getFields();
        for (Field field : fields1) {
            System.out.println(field);
        }*/


    }
}
