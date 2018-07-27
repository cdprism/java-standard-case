package other.billionbusiness;

import java.io.*;
import java.util.*;

/**
 * @author shancm
 * @package other.billionbusiness
 * @description:
 * @date 2018/7/16
 */
public class SplitBusi {
	private int total = 0;

	public static void main(String[] args) throws IOException {
		//源文件
		File source = new File("D:\\workspace\\billion-workspace\\billion-old-projects\\uubee_order\\uubee_order_core\\src\\main\\java\\com\\uubee\\order");

		//引用文件
		File direction = new File("D:\\workspace\\billion-workspace\\billion-old-projects\\billion-trader\\billion-trader-core\\src\\main\\java\\com\\billion\\traderservice\\core\\service");


		SplitBusi splitBusi = new SplitBusi();
		Map<String, String> serviceMethodsMap = splitBusi.findServiceMethods(new File(""));
		Set<Map.Entry<String, String>> entries = serviceMethodsMap.entrySet();
		for (Map.Entry<String, String> entry : entries) {
			System.out.println(entry.getKey() + " : " + entry.getValue());
		}
		splitBusi.invokedMethods(serviceMethodsMap, direction);
	}

	/**
	 * 获取service结尾的方法
	 */
	private Map<String, String> findServiceMethods(File file) throws IOException {
		Map<String, String> res = new HashMap<>(16);
		String key = "";
		String value = "";
		Reader reader = new FileReader(file);
		BufferedReader br = new BufferedReader(reader);

		String content = "";
		while (!Objects.isNull(content = br.readLine())) {
			key = "";
			value = "";
			Set<String> splitResult = splitResult(content);

			//获取包含"."和"service"的语句方法
			for (String s : splitResult) {
				if (s.contains(".")) {
					String[] split4findService = s.split("\\.");
					for (String s1 : split4findService) {
						if (s1.endsWith("Service")) {
							key = s1;
						}
						if (s1.endsWith(");")) {
							value = getClearMethod(s1);
						}
					}
					if (isNotBlank(key) && isNotBlank(value)) {
						res.put(key, value);
					}
				}
			}
		}
		return res;
	}

	/**
	 * 按 " "和"=" 拆分
	 */
	private Set<String> splitResult(String origin) {
		Set<String> result = new HashSet<>();
		String[] firstSplit = origin.split("\\ ");
		for (String s : firstSplit) {
			String[] secondSplit = s.split("=");
			for (String s1 : secondSplit) {
				result.add(s1);
			}
		}
		return result;
	}

	/**
	 * 获取纯净的方法
	 */
	private String getClearMethod(String method) {
		String[] split = method.split("\\(");
		for (String s : split) {
			if (!s.endsWith(");")) {
				return s;
			}
		}
		return "";
	}

	//=================================================

	/**
	 * 获取相应的调用方法
	 */
	private void invokedMethods(Map<String, String> map, File direction) throws IOException {
		Set<Map.Entry<String, String>> entries = map.entrySet();
		for (Map.Entry<String, String> entry : entries) {
			recursiveFile(direction, entry);
		}
	}

	private void recursiveFile(File direction, Map.Entry<String, String> entry) throws IOException {
		if (!direction.isFile()) {
			File[] files = direction.listFiles();
			for (File file : files) {
				recursiveFile(file, entry);
			}
		} else {
			//调用查找方法
			detectContent(direction, entry);
		}
	}

	private int getMethod(String content, PrintWriter writer) {
		if (content.contains("{")) {
			this.total++;
		}
		if (content.contains("}")) {
			this.total--;
			if (this.total == 0) {
				writer.println("}");
			}
		}
		return this.total;
	}

	private void detectContent(File file, Map.Entry<String, String> entry) throws IOException {
		BufferedReader br = null;
		PrintWriter pw = null;
		try {
			Reader reader = new FileReader(file);
			br = new BufferedReader(reader);

			if (file.getName().replace(".java", "").toLowerCase().equals(entry.getKey().toLowerCase())) {
				String content = "";
				int secondPublic = 0;
				boolean flagAnnotation = false;
				int flagMethod = 0;
				boolean flag = false;

				File outputFile = createOutputFile(file);
				Writer writer = new FileWriter(outputFile);
				pw = new PrintWriter(writer);

				while (!Objects.isNull(content = br.readLine())) {
					//读取类信息
					if (content.trim().startsWith("public")) {
						secondPublic++;
					}
					if (secondPublic < 2) {
						pw.println(content);
//						System.out.println(content);
					}

					if (secondPublic >= 2) {
						if (content.trim().startsWith("/**")) {
							flagAnnotation = true;
						}

						if (content.trim().endsWith("*/")) {
//						System.out.println(content);
							if (flagAnnotation) {
								pw.println("*/");
							}
							flagAnnotation = false;
						}

						String[] split = content.split("\\ ");
						for (String s : split) {
							if (s.startsWith(entry.getValue() + "(") && content.trim().startsWith("public")) {
								flag = true;
							}
						}
						if (flag) {
							flagMethod = getMethod(content, pw);
							if (flagMethod == 0) {
								flag = false;
							}
						}
						if (flagAnnotation || (flagMethod != 0)) {
							pw.println(content);
//						System.out.println(content);
						}
					}
				}
				pw.println("}");
				pw.close();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			br.close();
		}
	}

	//=============================================

	/**
	 * 创建写入文件
	 */
	private File createOutputFile(File file) throws IOException {
		String absolutePath = file.getAbsolutePath();
		File temp;
		int i = 0;
		while (true) {
			i++;
			String replace = absolutePath.replace(".java", i + "wahaha.java");
			temp = new File(replace);
			if (!temp.exists()) {
				temp.createNewFile();
				break;
			}
		}
		return temp;
	}


	public static boolean isBlank(final CharSequence cs) {
		int strLen;
		if (cs == null || (strLen = cs.length()) == 0) {
			return true;
		}
		for (int i = 0; i < strLen; i++) {
			if (Character.isWhitespace(cs.charAt(i)) == false) {
				return false;
			}
		}
		return true;
	}

	public static boolean isNotBlank(final CharSequence cs) {
		return !isBlank(cs);
	}
}
