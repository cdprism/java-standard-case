package throwable;

/**
 * @author shancm
 * @pachage throwable
 * @description:
 * @date 2018/5/17
 */
public class iException extends Exception {
    private void forfun() throws iException {
        System.out.println("boring");
        throw new iException();
    }

    public static void main(String[] args) {
        iException iException = new iException();
        try {
            iException.forfun();
        }catch (throwable.iException e){
            e.printStackTrace(System.out);
            System.out.println("hehe");
        }
        System.out.println("what");
    }
}
