package other.billionbusiness;

import java.io.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * @author shancm
 * @package other.iostream
 * @description:
 * @date 2018/7/5
 */
public class CheckPomElements {

	public static void main(String[] args) throws IOException {

		Set<String> dependencySet = new HashSet<>();

		String origin = "uubee_thirdpay uubee_trader uubee_refund uubee_public uubee_fund uubee_query uubee_base_gateway uubee_notify uubee_cashgift uubee_withdraw uubee_user uubee_crawler uubee_bill uubee_balance uubee_busi uubee_credit uubee_account";
		String[] strings = origin.split("\\ ");
		for (String string : strings) {
			String s = "<artifactid>" + string.trim().toLowerCase() + "_interface</artifactid>";
			dependencySet.add(s);
		}

//		dependencySet.forEach(n-> System.out.println(n));

		File file = new File("" +
				//account
//				"D:\\workspace\\billion-workspace\\billion-old-projects\\billion-account\\billion-account-core"
				//pay
				"D:\\workspace\\billion-workspace\\billion-old-projects\\billion-pay\\billion-pay-core"
				//busi
//				"D:\\workspace\\billion-workspace\\billion-old-projects\\billion-busi\\billion-busi-core"
				//settle
//				"D:\\workspace\\billion-workspace\\billion-old-projects\\billion-settle\\billion-settle-core"
				+ "\\pom.xml");

		//		File file = new File("D:\\workspace\\uubee-workspace\\uubee-old-projects\\uubee_banktask\\uubee_banktask_core\\src\\main\\java\\com\\uubee\\banktask\\dubbo\\comp\\AddRefCountForAuthOrderComp.java");
		InputStream is = new FileInputStream(file);
		InputStreamReader isr = new InputStreamReader(is);
		BufferedReader br = new BufferedReader(isr);

		String content = null;

		while (!Objects.isNull(content = br.readLine())) {
			String s = content;
			dependencySet.forEach(n -> {
//				System.out.println(s.trim().toLowerCase());
				if (s.trim().toLowerCase().equals(n)) {

					System.out.println(file.getName() + " : " + n);
				}
			});
		}


	}
}
