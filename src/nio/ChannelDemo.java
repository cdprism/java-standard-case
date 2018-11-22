package nio;

import java.io.*;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.CharacterCodingException;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CharsetEncoder;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

/**
 * @author shancm
 * @package nio
 * @description:
 * @date 2018/11/21
 */
public class ChannelDemo {

	public static void main(String[] args) throws IOException {

		//间接缓冲区
//		jvmCache();

		//直接缓冲区
//		systemCache();

		//通道传输
//		transfer();

		//分散读取 聚合写入
//		scatterAndGether();

		//编码 解码
//		encodeAndDecode();

	}


	private static void jvmCache() throws IOException {
		File in = new File("C:\\Users\\shancm\\Desktop\\pic\\Cover.jpg");
		File out = new File("C:\\Users\\shancm\\Desktop\\pic\\Cover2.jpg");

		FileInputStream inputStream = null;
		FileOutputStream outputStream = null;
		try {
			inputStream = new FileInputStream(in);
			outputStream = new FileOutputStream(out);

			FileChannel inChannel = inputStream.getChannel();
			FileChannel outChannel = outputStream.getChannel();

			ByteBuffer buffer = ByteBuffer.allocate(1024);

			while (inChannel.read(buffer) != -1) {
				buffer.flip();

				outChannel.write(buffer);

				buffer.clear();
			}

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			assert inputStream != null;
			inputStream.close();
			assert outputStream != null;
			outputStream.close();
		}
	}

	private static void systemCache() throws IOException {
		FileChannel in = FileChannel.open(Paths.get("C:\\Users\\shancm\\Desktop\\pic\\Cover.jpg"), StandardOpenOption.READ);
		FileChannel out = FileChannel.open(Paths.get("C:\\Users\\shancm\\Desktop\\pic\\Cover3.jpg"), StandardOpenOption.WRITE, StandardOpenOption.READ, StandardOpenOption.CREATE_NEW);

		//映射用户内存跟系统内存的读写
		MappedByteBuffer inBuffer = in.map(FileChannel.MapMode.READ_ONLY, 0, in.size());
		MappedByteBuffer outBuffer = out.map(FileChannel.MapMode.READ_WRITE, 0, in.size());

		byte[] bytes = new byte[inBuffer.limit()];
		inBuffer.get(bytes);
		outBuffer.put(bytes);

		/*ByteBuffer buffer = ByteBuffer.allocate(1024);

		while (in.read(buffer) != -1) {
			buffer.flip();

			out.write(buffer);

			buffer.clear();
		}

		in.close();
		out.close();*/
	}

	private static void transfer() throws IOException {
		FileChannel in = FileChannel.open(Paths.get("C:\\Users\\shancm\\Desktop\\pic\\Cover.jpg"), StandardOpenOption.READ);
		FileChannel out = FileChannel.open(Paths.get("C:\\Users\\shancm\\Desktop\\pic\\Cover4.jpg"), StandardOpenOption.WRITE, StandardOpenOption.CREATE_NEW);

		long l = in.transferTo(0, in.size(), out);
		System.out.println(l);
	}

	private static void scatterAndGether(){
		try {
			//分散读取
			RandomAccessFile in = new RandomAccessFile("C:\\Users\\shancm\\Desktop\\1.txt", "r");

			FileChannel channel = in.getChannel();

			ByteBuffer buffer1 = ByteBuffer.allocate(1024);
			ByteBuffer buffer2 = ByteBuffer.allocate(1024);

			ByteBuffer[] buffers = {buffer1, buffer2};

			channel.read(buffers);

			for (ByteBuffer buffer : buffers) {
				buffer.flip();
			}

			System.out.println(new String(buffers[0].array(), 0, buffers[0].limit()));

			//聚合写入
			RandomAccessFile out = new RandomAccessFile("C:\\Users\\shancm\\Desktop\\2.txt", "rw");
			FileChannel outChannel = out.getChannel();

			outChannel.write(buffers);


			channel.close();
			outChannel.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static void encodeAndDecode() throws CharacterCodingException {

		Charset gbk = Charset.forName("gbk");

		CharsetEncoder encoder = gbk.newEncoder();
		CharsetDecoder decoder = gbk.newDecoder();

		CharBuffer buffer = CharBuffer.allocate(1024);

		buffer.put("优秀");
		buffer.flip();

		//encoding
		ByteBuffer byteBuffer = encoder.encode(buffer);

		for (int i = 0; i < 4; i++) {
			System.out.println(byteBuffer.get());
		}

		//decoding
		byteBuffer.flip();
		CharBuffer decode = decoder.decode(byteBuffer);

		System.out.println(decode.toString());
	}


}
