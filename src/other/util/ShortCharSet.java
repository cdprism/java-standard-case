package other.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

/**
 * @author shancm
 * @package other.util
 * @description:
 * @date 2018/8/25
 */
public class ShortCharSet {


	public static void main(String[] args) {
		String url = "eyJvcyI6IkFuZHJvaWQiLCJ2ZXJzaW9uIjoiMi4wLjUiLCJzZXNzaW9uX2lkIjoiQllKMzgxMWEyZTJkNTdhNTg1MWQzNzg2MmQ3ZGNiMmM4NWMiLCJkZXZpY2VfaWQiOiJzTnk5M3JYcWlPZWZxYzM3emY3UHFzeXBuZnVkcU12Nm5xeWRwSjM0bXEyZnJNXC83bmFcL0tcLzVrPSIsImRhdGEiOiJwdjZDXC9xYitndjZtXC9vTCtwdjZDXC9xYisifQ";
		System.out.println(ShortText(url));
	}

	public static String ShortText(String string){
		String key = "Geek";                 //自定义生成MD5加密字符串前的混合KEY
		String[] chars = new String[]{          //要使用生成URL的字符
				"a","b","c","d","e","f","g","h",
				"i","j","k","l","m","n","o","p",
				"q","r","s","t","u","v","w","x",
				"y","z","0","1","2","3","4","5",
				"6","7","8","9","A","B","C","D",
				"E","F","G","H","I","J","K","L",
				"M","N","O","P","Q","R","S","T",
				"U","V","W","X","Y","Z"
		};

		String hex = EncryptionUtil.md5(key + string);
		int hexLen = hex.length();
		int subHexLen = hexLen / 8;
		String[] ShortStr = new String[4];

		for (int i = 0; i < subHexLen; i++) {
			String outChars = "";
			int j = i + 1;
			String subHex = hex.substring(i * 8, j * 8);
			long idx = Long.valueOf("3FFFFFFF", 16) & Long.valueOf(subHex, 16);

			for (int k = 0; k < 6; k++) {
				int index = (int) (Long.valueOf("0000003D", 16) & idx);
				outChars += chars[index];
				idx = idx >> 5;
			}
			ShortStr[i] = outChars;
		}

		String result = "";
		for (String s : ShortStr) {
			result += s;
		}
		return result;
	}


	private static void print(Object messagr){
		System.out.println(messagr);
	}
}
