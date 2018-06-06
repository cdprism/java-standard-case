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
        File des = new File("D:/workspace/subllime workspace/女儿情1.txt");
        try {
            InputStream is = new FileInputStream(file);
            length = is.read(bytes);
            OutputStream os = new FileOutputStream(des);


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
