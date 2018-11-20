package nio;

import java.nio.Buffer;
import java.nio.ByteBuffer;

public class BufferDemo {

    public static void main(String[] args) {
        BufferDemo bufferDemo = new BufferDemo();

        ByteBuffer buffer = ByteBuffer.allocate(1024);
        bufferDemo.print(buffer);

        buffer.put("system".getBytes());

        bufferDemo.print(buffer);

        buffer.flip();

        byte[] bytes = new byte["system".length()];

        buffer.get(bytes);

        System.out.println(new String(bytes));

        bufferDemo.print(buffer);

        //可重复读取数据
        buffer.rewind();

        bufferDemo.print(buffer);

    }

    private void print(Buffer buffer){
//        System.out.println(buffer.capacity());
        System.out.println(buffer.limit());
        System.out.println(buffer.position());
        System.out.println("===========");
    }
}
