package nio;

import java.io.FileNotFoundException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @author shancm
 * @package nio
 * @description:
 * @date 2018/7/27
 */
public class NioDemo {

	public static void main(String[] args) throws FileNotFoundException {

		RandomAccessFile randomAccessFile = new RandomAccessFile("C:\\Users\\shancm\\Desktop\\pic\\linux 目录.png", "rw");
		FileChannel channel = randomAccessFile.getChannel();

		ByteBuffer byteBuffer = ByteBuffer.allocate(48);
	}
}
