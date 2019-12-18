package entity.util;

import entity.sign.Operation;

import java.util.ArrayList;
import java.util.List;

/**
 *  规约结构提取工具类
 *
 * @author zhengziyan,zhoujianhang
 * @date 2019/8/25
 */
public class SignUtil {
    public static void getIndex(String s, int[] a) {
        a[0] = s.indexOf("Spec");
        a[1] = s.indexOf("extends");
        a[2] = s.indexOf("uses");
        a[3] = s.indexOf("Attr");
        a[4] = s.indexOf("Const");
        a[5] = s.indexOf("Retr");
        a[6] = s.indexOf("Tran");
        a[7] = s.indexOf("Axiom");
        a[8] = s.indexOf("End");
    }

    public static List<Operation> getRetr(String s) {
        int[] a = new int[9];
        getIndex(s, a);
        /**  a[5]为关键词“Retr”的起始地址  */
        int i = 5;
        if (a[i] < 0) {
            return null;
        }
        int index = 0;
        int distance = 10000;
        /**  以下代码用来计算离关键词“Retr”最近的关键词的起始地址  */
        for (i = 1; i < 8; i++) {
            if ((a[i] - a[5]) > 0 && (a[i] - a[5]) < distance) {
                distance = a[i] - a[5];
                index = a[i];
            }
        }
        String str1 = s.substring(a[5]+5, index-2);
        String[] str2 = str1.split("\n");
        ArrayList<Operation> retr1 = new ArrayList<Operation>();
        for (i = 0; i < str2.length ; i++) {
            Operation ope = new Operation();
            int a0 = str2[i].indexOf(";");
            int a1 = str2[i].indexOf("(");
            int a2 = str2[i].indexOf(")");
            String string1 = str2[i].substring(1, a1);
            String string2 = str2[i].substring(a1 + 1, a2);
            String string3 = str2[i].substring(a2 + 2,a0);
            String[] string4 = string2.split(",");
            String[] string5 = string3.split(",");
            ArrayList<Object> doman = new ArrayList<Object>();
            ArrayList<Object> codoman = new ArrayList<Object>();
            boolean add;
            for (int j = 0; j < string4.length; j++) {
                add = doman.add(string4[j]);
            }
            for (int j = 0; j < string5.length; j++) {
                add = codoman.add(string5[j]);
            }
            ope.setOpName(string1);
            ope.setDomainsType(doman);
            ope.setCodomainsType(codoman);
            add = retr1.add(ope);
        }
        return retr1;
    }

    public static List<Operation> getTran(String s) {
        int[] a = new int[9];
        getIndex(s, a);
        /**  a[6]为关键词“Tran”的起始地址  */
        int i = 6;
        if (a[i] < 0) {
            return null;
        }
        int index = 0;
        int distance = 10000;
        /**  以下代码用来计算离关键词“Tran”最近的关键词的起始地址  */
        for (i = 1; i <= 8; i++) {
            if ((a[i] - a[6]) > 0 && (a[i] - a[6]) < distance) {
                distance = a[i] - a[6];
                index = a[i];
            }
        }
        String str1 = s.substring(a[6]+5, index-2);
        String[] str2 = str1.split("\n");
        for (String s1:str2) {
            System.out.println("tran:" + s1);
        }

        ArrayList<Operation> tran1 = new ArrayList<Operation>();
        for (i = 0; i < str2.length ; i++) {
            Operation ope = new Operation();
            int a0 = str2[i].indexOf(";");
            int a1 = str2[i].indexOf("(");
            int a2 = str2[i].indexOf(")");
            String string1 = str2[i].substring(1, a1);
            String string2 = str2[i].substring(a1 + 1, a2);
            String string3 = str2[i].substring(a2 + 2 ,a0);
            String[] string4 = string2.split(",");
            String[] string5 = string3.split(",");
            ArrayList<Object> doman = new ArrayList<Object>();
            ArrayList<Object> codoman = new ArrayList<Object>();
            boolean add;
            for (int j = 0; j < string4.length; j++) {
                add = doman.add(string4[j]);
            }
            for (int j = 0; j < string5.length; j++) {
                add = codoman.add(string5[j]);
            }
            ope.setOpName(string1);
            ope.setDomainsType(doman);
            ope.setCodomainsType(codoman);
            add = tran1.add(ope);
        }
        return tran1;
    }

    public static void main(String[] args) {
        String s = "Spec AppointmentService;\n" +
                "\tuses OrderRequest,ListOrderResponse,OrderWithCaseResponse,GetEvaluationResponse,AccountRequest,\n" +
                "\t     OrderTimeRequest,OrderTimeResponse,OrderStatisticResponse,AddOrderRequest,SysResponse,\n" +
                "\t\t PayOrderResponse,AddAdviceRequest,AddEvaluationRequest,ExportOrderResponse;\n" +
                "\tAttr\n" +
                "\t\ttimeout:Integer;\t//下单后x分钟内不付款自动取消\n" +
                "\tRetr\n" +
                "\t\tListOrder(OrderRequest):ListOrderResponse; \t\t\t\t//查列表\n" +
                "\t\tGetOrderWithCase(OrderRequest):OrderWithCaseResponse; \t//查单个\n" +
                "\t\tGetEvaluation(OrderRequest):GetEvaluationResponse;\n" +
                "\t\tGetWaited(AccountRequest):ListOrderResponse;\t\t\t//医生查当前待咨询订单（任务）\n" +
                "\t\tGetCurrent(AccountRequest):OrderWithCaseResponse; \t\t//查询咨询中订单\t\t\n" +
                "\t\tGetSchedule(OrderTimeRequest):OrderTimeResponse; \t\t//查询预约时间段\n" +
                "\t\tGetStatistics(AccountRequest):OrderStatisticResponse;\t//查询统计数据\n" +
                "\tTran\n" +
                "\t\tAddOrder(AddOrderRequest):OrderWithCaseResponse;\t\t//预约\n" +
                "\t\tCancelOrder(OrderRequest):SysResponse;\t\t\t\t\t//取消\n" +
                "\t\tDeleteOrder(OrderRequest):SysResponse;\t\t\t\t\t//删除\t\t\n" +
                "\t\tPayOrder(OrderRequest):PayOrderResponse;\t\t\t\t//支付\n" +
                "\t\tRefundOrder(OrderRequest):SysResponse;\t\t\t\t\t//退款\n" +
                "\t\tCallNext(AccountRequest):OrderWithCaseResponse; \t\t//正常叫号\n" +
                "\t\tTimeOut(AccountRequest):OrderWithCaseResponse;\t\t\t//超时叫号\t\t\n" +
                "\t\tAddAdvice(AddAdviceRequest):SysResponse; \t\t\t\t//添加医生建议\n" +
                "\t\tAddEvaluation(AddEvaluationRequest):SysResponse;\t\t//评价医生\t\t\n" +
                "\t\tExportOrder(OrderRequest):ExportOrderResponse; //导出咨询记录\t\t\n" +
                "End\n";
        List<Operation> retr = getRetr(s);
        List<Operation> tran = getTran(s);
        System.out.println(retr.size());
        System.out.println(tran.size());
    }
}
