package other.billionbusiness;

import java.io.*;
import java.util.*;

/**
 * @author shancm
 * @package other.iostream
 * @description:
 * @date 2018/7/5
 */
public class CheckMethods {

	public static void main(String[] args) throws IOException {

		Set<String> tableSet = new HashSet<>();
//		String origin = "ta_acctbal, ta_frzbill, tj_acct, esign_user_seal_info, tb_app_log, tb_apply_withdraw, tb_audit_log, tb_authrisk_log, tb_black_list, tb_busi_mng_log, tb_cashgift_user, tb_credit_serial, tb_ctl_billno, tb_digital_contract, tb_file_info, tb_flight_record, tb_info_error, tb_info_feedback, tb_info_userlog, tb_mbbelong, tb_property_info, tb_refundinfo, tb_renthouse_info, tb_risk_detail, tb_sdk_log, tb_user_trace_info, tt_info_bank, tt_set_remind, aging_detail, aging_product, aging_record, newtable, outter_req_flow, qunar_loan_aging, qunar_loan_info, qunar_refund_flow, qunar_repay_flow, tb_cash_bankdetail, tb_cash_bankserial, tb_cash_pnodetail, tb_cash_pnoinfo, tb_consumer_order, tb_finserial, tb_order_record, tb_orderinfo, tb_pay_bill, tb_pay_bill_bak, tb_paybillserial, tb_paycfg, tb_proxypay_pnoinfo, tb_proxypay_serial, tb_redcash_withdraw, tb_refund_bill, tb_refund_bill_extent_info, tb_refund_charge, tb_repay_flow, tb_withdraw_pro, tb_withdraw_record, trader_aging_product";
		//account
		String origin = "ta_acctbal, ta_frzbill, tj_acct";
		//busi
//		String origin = "esign_user_seal_info, tb_app_log, tb_apply_withdraw, tb_audit_log, tb_authrisk_log, tb_black_list, tb_busi_mng_log, tb_cashgift_user, tb_credit_serial, tb_ctl_billno, tb_digital_contract, tb_file_info, tb_flight_record, tb_info_error, tb_info_feedback, tb_info_userlog, tb_mbbelong, tb_property_info, tb_refundinfo, tb_renthouse_info, tb_risk_detail, tb_sdk_log, tb_user_trace_info, tt_info_bank, tt_set_remind";
		//pay
//		String origin = "aging_detail, aging_product, aging_record, newtable, outter_req_flow, qunar_loan_aging, qunar_loan_info, qunar_refund_flow, qunar_repay_flow, tb_cash_bankdetail, tb_cash_bankserial, tb_cash_pnodetail, tb_cash_pnoinfo, tb_consumer_order, tb_finserial, tb_order_record, tb_orderinfo, tb_pay_bill, tb_pay_bill_bak, tb_paybillserial, tb_paycfg, tb_proxypay_pnoinfo, tb_proxypay_serial, tb_redcash_withdraw, tb_refund_bill, tb_refund_bill_extent_info, tb_refund_charge, tb_repay_flow, tb_withdraw_pro, tb_withdraw_record, trader_aging_product";
		//settle
//		String origin = "balance_recon_detail, settle_detail, settle_serial, ta_account_acctno_balance, ta_account_acctno_detail, ta_account_journalizing, ta_account_payserial, ta_account_sub_balance, ta_account_subject, ta_account_trial_balance, ta_acctbal_wangmh, tb_account_balance, tb_account_trader, tb_acct_deposit_serial, ttj_acctbal, ttj_acctbal_bak, ttj_acctbal_tmp";
		String[] strings = origin.split("\\,");
		for (String string : strings) {
			String s = string.trim().toUpperCase();
			tableSet.add(s);
		}

//		Map<Integer, String> map =new HashMap<>();
//		map.put(1, "D:\\\\workspace\\\\uubee-workspace\\\\uubee-old-projects\\\\uubee_credit\\\\uubee_credit_core\\\\src\\\\main\\\\java\\\\com\\\\uubee\\\\credit\\\\config\\\\sqlmap");


		File direct = new File("" +
				//credit
//				"D:\\workspace\\uubee-workspace\\uubee-old-projects\\uubee_credit\\uubee_credit_core\\src\\main\\java\\com\\uubee\\credit\\config\\sqlmap"
				//uubee_trader
//				"D:\\workspace\\uubee-workspace\\uubee-old-projects\\Dev\\J.BS.pay\\uubee_trader\\trunk\\uubee_trader_dubbo\\src\\main\\java\\com\\uubee\\trader\\sqlmap\\config"
				//uubee_public
//				"D:\\workspace\\uubee-workspace\\uubee-old-projects\\Dev\\J.BS.pay\\uubee_gateway\\uubee_public\\branch\\uubee_public20160918\\uubee_public_core\\src\\main\\java\\com\\uubee\\aging\\config\\sqlmap"
//				"D:\\workspace\\uubee-workspace\\uubee-old-projects\\Dev\\J.BS.pay\\uubee_gateway\\uubee_public\\branch\\uubee_public20160918\\uubee_public_core\\src\\main\\java\\com\\uubee\\order\\config\\sqlmap"
//				"D:\\workspace\\uubee-workspace\\uubee-old-projects\\Dev\\J.BS.pay\\uubee_gateway\\uubee_public\\branch\\uubee_public20160918\\uubee_public_core\\src\\main\\java\\com\\uubee\\qunar\\config\\sqlmap"
				//uubee-fund
//				"D:\\workspace\\uubee-workspace\\uubee-old-projects\\uubee-fund\\uubee-fund-core\\src\\main\\java\\com\\uubee\\fund\\config\\sqlMap"
				//uubee_query
				"D:\\workspace\\uubee-workspace\\uubee-old-projects\\uubee_query\\uubee_query_core\\src\\main\\java\\com\\uubee\\query\\maps"
				//uubee_notify
//				"D:\\workspace\\uubee-workspace\\uubee-old-projects\\Dev\\J.BS.pay\\uubee_notify\\trunk\\uubee_notify_core\\src\\main\\java\\com\\uubee\\notify\\config\\ibatis"
				//uubee_cashgift
//				"D:\\workspace\\uubee-workspace\\uubee-old-projects\\Dev\\J.BS.pay\\uubee_cashgift\\branch\\uubee_cashgift\\uubee_cashgift_core\\src\\main\\java\\com\\uubee\\cashgift\\config\\sqlmap"
				//uubee_withdraw
//				"D:\\workspace\\uubee-workspace\\uubee-old-projects\\Finance\\Dev\\J.BS.finance\\uubee_withdraw\\trunk\\uubee_withdraw\\uubee_withdraw_core\\src\\main\\java\\com\\uubee\\withdraw\\config\\sqlmap"
				//uubee_user
//				"D:\\workspace\\uubee-workspace\\uubee-old-projects\\Finance\\Dev\\J.BS.finance\\uubee_user\\trunk\\uubee_user_core_dubbo\\src\\main\\java\\com\\uubee\\user\\config\\sqlmap"
				//uubee_crawler
//				"D:\\workspace\\uubee-workspace\\uubee-old-projects\\Finance\\Dev\\J.BS.finance\\uubee_crawle\\trunk\\uubee_crawler\\uubee_crawler_core\\src\\main\\java\\com\\uubee\\crawler\\config\\sqlmap"
				//uubee_bill
//				"D:\\workspace\\uubee-workspace\\uubee-old-projects\\Dev\\J.BS.core\\uubee_bill\\trunk2.0\\uubee_bill_core\\src\\main\\java\\com\\uubee\\bill\\config\\sqlmap"
				//uubee_busi
//				"D:\\workspace\\uubee-workspace\\uubee-old-projects\\Dev\\J.BS.pay\\uubee_busi\\branch\\busi20170704\\uubee_busi_core\\src\\main\\java\\com\\uubee\\busi\\config\\sqlmap"
				//uubee_credit
//				"D:\\workspace\\uubee-workspace\\uubee-old-projects\\Dev\\J.BS.core\\uubee_credit\\trunk\\uubee_credit_core\\src\\main\\java\\com\\uubee\\credit\\config\\sqlmap"
				//uubee_account
//				"D:\\workspace\\uubee-workspace\\uubee-old-projects\\uubee_account\\uubee_account_core\\src\\main\\java\\com\\uubee\\account\\ibatis"
				//uubee_paybill
//				"D:\\workspace\\uubee-workspace\\uubee-old-projects\\uubee_paybill\\uubee_paybill_core\\src\\main\\java\\com\\uubee\\paybill\\config\\sqlmap"
						+ "");

		File[] files = direct.listFiles();
		for (File file : files) {
			//		File file = new File("D:\\workspace\\uubee-workspace\\uubee-old-projects\\uubee_banktask\\uubee_banktask_core\\src\\main\\java\\com\\uubee\\banktask\\dubbo\\comp\\AddRefCountForAuthOrderComp.java");
			InputStream is = new FileInputStream(file);
			InputStreamReader isr = new InputStreamReader(is);
			BufferedReader br = new BufferedReader(isr);

			String content = null;

			while (!Objects.isNull(content = br.readLine())) {
				String[] split = content.split("\\ ");
				for (String s : split) {
					tableSet.forEach(n -> {
						if (s.length() >= n.length()) {
							if (s.substring(0, n.length()).trim().toUpperCase().equals(n)) {
								System.out.println(file.getName() + " : " + n);
							}
						}
					});
				}
			}
		}

//		String content = "ctl= billCtlInfoService.insertBillCtlInfo(ctl);";

		/*String word = "insertBillCtlInfo";

		String[] split = content.split("\\.");
		for (String s : split) {
			if(s.length()>=word.length()){
				if(s.substring(0, word.length()).equals(word)){
					System.out.println(s.substring(0, word.length()));
				}
			}
		}*/

	}
}
