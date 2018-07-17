package other.temp;

import java.io.File;

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

    public static void main(String[] args) {
//        Temp temp = new Temp();
//        System.out.println(other.temp.getA());
//        System.out.println("".equals(null));

//        System.out.println(temp.aLong);

//        String a = "OID_ACCTNO,STAT_ACCT,TYPE_BAL,DATE_OPEN, DT_INFOMODI,CUR_CODE,PROGRAM_ID,USER_NO,MERCHANT_INDUSTRY, COUNTRY_CODE,AMT_BALCUR,AMT_BALAVAL,AMT_BALFRZ,AMT_LASTBAL,DATE_ACCT_LAST,PAY_PWD,TYPE_ACCTLOG";
//
//        String[] split = a.split(",");
//        System.out.println(split.length);
        File file = new File("D:\\workspace\\billion-workspace\\billion-old-projects\\uubee_order\\uubee_order_core\\src\\main\\java\\com\\uubee\\order\\comp\\SyncCallService.java");
        System.out.println(file.getName().replace(".java", ""));
    }
}
