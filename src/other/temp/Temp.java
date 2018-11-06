package other.temp;

import javax.sound.midi.Soundbank;
import java.io.File;
import java.math.BigDecimal;
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

    public static void main(String[] args) {
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

        Temp sdf = new Temp();
        Map<Integer, BigDecimal> integerBigDecimalMap = sdf.repayPlanCalculator(300000L, "36", 2, 3);
//        Map<Integer, BigDecimal> integerBigDecimalMap = sdf.getPerMonthInterest(300000L, "36", 2, "3");
        System.out.println(integerBigDecimalMap);

    }

    public Map<Integer, BigDecimal> repayPlanCalculator(long principal, String yearRate, int month, int roundMode) {
        Map<Integer, BigDecimal> res = new HashMap<>(month);

        BigDecimal principalValue = new BigDecimal(String.valueOf(principal)).scaleByPowerOfTen(-2);
        BigDecimal monthValue = new BigDecimal(String.valueOf(month));
        BigDecimal rateValue = new BigDecimal(String.valueOf(yearRate)).scaleByPowerOfTen(-2);
        //第一个月 本金/月份 + 本金*利率
        for (int i = 1; i <= month; i++) {

            BigDecimal currentPrincipal = principalValue.divide(monthValue, roundMode);
            BigDecimal currentInterest = principalValue.multiply(rateValue).multiply(new BigDecimal(month - i + 1)).divide(new BigDecimal(12), roundMode);

            res.put(i, currentPrincipal.add(currentInterest));
        }
        return res;
    }


    public Map<Integer, BigDecimal> getPerMonthInterest(long principal, String yearRate, int totalMonth,String roundMode) {
        Map<Integer, BigDecimal> map = new HashMap<Integer, BigDecimal>();
        double yearRateVal = new BigDecimal(yearRate).scaleByPowerOfTen(-2).doubleValue();
        double monthRate = yearRateVal/12;
        BigDecimal monthInterest;
        for (int i = 1; i < totalMonth + 1; i++) {
            BigDecimal multiply = new BigDecimal(principal).multiply(new BigDecimal(monthRate));
            BigDecimal sub  = new BigDecimal(Math.pow(1 + monthRate, totalMonth)).subtract(new BigDecimal(Math.pow(1 + monthRate, i-1)));
            monthInterest = multiply.multiply(sub).divide(new BigDecimal(Math.pow(1 + monthRate, totalMonth) - 1), 2, 1);
            map.put(i, monthInterest);
        }
        return map;
    }
}
