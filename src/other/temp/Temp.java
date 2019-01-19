package other.temp;

import javax.sound.midi.Soundbank;
import java.io.File;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.*;

/**
 * @author shancm
 * @pachage other.temp
 * @description:
 * @date 2018/5/30
 */
public class Temp {
	private long aLong;

	private Integer a;

	public Integer getA() {
		return a;
	}

	public void setA(Integer a) {
		this.a = a;
	}

	public static void main(String[] args) throws ParseException {
//        Temp temp = new Temp();
//        System.out.println(other.temp.getA());
//        System.out.println("".equals(null));

//        System.out.println(temp.aLong);

//        String a = "OID_ACCTNO,STAT_ACCT,TYPE_BAL,DATE_OPEN, DT_INFOMODI,CUR_CODE,PROGRAM_ID,USER_NO,MERCHANT_INDUSTRY, COUNTRY_CODE,AMT_BALCUR,AMT_BALAVAL,AMT_BALFRZ,AMT_LASTBAL,DATE_ACCT_LAST,PAY_PWD,TYPE_ACCTLOG";
//
//        String[] split = a.split(",");
//        System.out.println(split.length);

//        File file = new File("D:\\workspace\\billion-workspace\\billion-old-projects\\uubee_order\\uubee_order_core\\src\\main\\java\\com\\uubee\\order\\comp\\SyncCallService.java");
//        System.out.println(file.getName().replace(".java", ""));

//        Temp temp = new Temp();

//        ZoneId zoneId = ZoneId.systemDefault();
//        LocalDate localDate = LocalDate.now();
//        localDate = localDate.plusDays(-1);
//        ZonedDateTime zdt = localDate.atStartOfDay(zoneId);
//        Date date = Date.from(zdt.toInstant());

//        System.out.println(date);

//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//        Date parse = sdf.parse("2019-01-06");
//        System.out.println(date.after(parse));
//        System.out.println(parse.before(date));
//        System.out.println(parse.after(new Date()));


//        List<String> list = new ArrayList<>(4);
//        list.add("1");
//        list.add("2");

//        list.stream().filter()

		Set<String> fileNames = new HashSet<>(12);
		fileNames.add(".idea");
		fileNames.add("target");
		fileNames.add("cache");
		fileNames.add("caches");
		fileNames.add("logs");
		fileNames.add("log");

		File file = new File("D:\\workspace\\keynes-workspace");
		delete(file, fileNames);



	}



	private static void delete(File root, Set<String> fileNames) {

		File[] files = root.listFiles();
		for (File file : files) {
			if (file.isDirectory()) {
				if ("target".equals(root.getName())) {
					deleteDir(root);
				}else {
					delete(file, fileNames);
				}
			}
		}
	}

	private static void deleteDir(File direct){
		File[] files = direct.listFiles();
		for (File file : files) {
			if(file.isDirectory()){
				deleteDir(file);
			}else {
				file.delete();
			}
		}
	}


}
