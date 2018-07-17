package reflect;

import other.entity.Son;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @author shancm
 * @pachage reflect
 * @description:
 * @date 2018/6/7
 */
public class ReflectDemo {
    public static void main(String[] args) {

        Class clazz = Son.class;
        Class clazz2 = new Son().getClass();

        Field[] fields = clazz.getFields();
        Field[] declaredFields = clazz.getDeclaredFields();
        Method[] methods = clazz.getMethods();
        Method[] declaredMethods = clazz.getDeclaredMethods();

        /*for (Field field : fields) {
            System.out.println("filed : "+field);
        }
        for (Field field : declaredFields) {
            System.out.println(field);
        }*/
        /*for (Method method : methods) {
            System.out.println("method : "+method);
        }
        for (Method method : declaredMethods) {
            System.out.println(method);
        }*/

        Class superclass = clazz.getSuperclass();
        Field[] fields1 = superclass.getFields();
        Field[] declaredFields1 = superclass.getDeclaredFields();
        for (Field field : fields1) {
            System.out.println("field : "+field);
        }
        /*for (Field field : declaredFields1) {
            System.out.println("declaredFields : "+field);
        }*/
    }
}
