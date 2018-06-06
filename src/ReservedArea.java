/**
 * @author shancm
 * @pachage PACKAGE_NAME
 * @description:
 * @date 2018/5/25
 */
public class ReservedArea {
    private void yell() {
        System.out.println("w");
    }

    public static void main(String[] args) {
//        List<Integer> list = new ArrayList<>();
//        System.out.println(list.size());

        ReservedArea reservedArea = new ReservedArea();
        for (int i = 0; i < 10; i++) {
            reservedArea.yell();
        }

    }
}
