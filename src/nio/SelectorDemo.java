package nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.Channel;
import java.nio.channels.FileChannel;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

/**
 * @author shancm
 * @package nio
 * @description:
 * @date 2018/11/22
 */
public class SelectorDemo {

	public static void main(String[] args) {

	}

	private static void blockSocket() {
		FileChannel in;
		try {
			SocketChannel socketChannel = SocketChannel.open(new InetSocketAddress("127.0.0.1", 1234));

			 in = FileChannel.open(Paths.get(""), StandardOpenOption.READ);

			ByteBuffer buffer = ByteBuffer.allocate(1024);

			while (in.read(buffer) != -1){
				buffer.flip();
				socketChannel.write(buffer);
				buffer.clear();
			}

			in.close();
			socketChannel.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static void blockServerSocket() {

		try {
			ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
			serverSocketChannel.bind(new InetSocketAddress(1234));
			serverSocketChannel.accept();


		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
