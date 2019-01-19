package other.temp;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.OpenOption;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.*;

/**
 * @author shancm
 * @package other.temp
 * @description:
 * @date 2019/1/4
 */
public class Query {
	public static void main(String[] args) throws IOException {
		FileChannel channel1 = FileChannel.open(Paths.get("C:\\Users\\shancm\\Desktop\\1.txt"), StandardOpenOption.READ);
		FileChannel channel2 = FileChannel.open(Paths.get("C:\\Users\\shancm\\Desktop\\2.txt"), StandardOpenOption.READ);

		Set<String> list1 = cache(channel1);
		Set<String> list2 = cache(channel2);

		System.out.println(list1.size());
		System.out.println(list2.size());

		for (String s : list1) {
			if(list2.contains(s)){
				continue;
			}
			System.out.println(s);
		}


	}

	private static Set<String> cache(FileChannel fileChannel) throws IOException {
		ByteBuffer buffer = ByteBuffer.allocate(10240);
		Set<String> list = null;
		while ((fileChannel.read(buffer)) != -1) {
			buffer.flip();

			String context = new String(buffer.array());

			String[] split = context.split("\n");

			list = new HashSet<>(split.length);

			Collections.addAll(list, split);

			/*for (String s : split) {
				if(list.contains(s)){
					System.out.println(s);
				}
				list.add(s);
			}*/

			buffer.clear();
		}

		return list;
	}
}
