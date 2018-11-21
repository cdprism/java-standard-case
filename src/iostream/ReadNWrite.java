package iostream;

import java.io.*;

/**
 * Created by shancm on 2018/3/25.
 */
public class ReadNWrite {
    public static void main(String[] args) {
        int length;
        byte[] bytes = new byte[1024];
        File file = new File("D:\\workspace\\subllime workspace\\女儿情.txt");
        File des = new File("D:/workspace/subllime workspace/女儿情9.txt");
        try {
            /*InputStream is = new FileInputStream(file);
            length = is.read(bytes);*/
            OutputStream os = new FileOutputStream(des);
            PrintWriter writer = new PrintWriter(os);
            writer.println("123");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
