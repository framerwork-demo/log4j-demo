package number;

import java.text.NumberFormat;

public class NumberFormatTest1 {
    public static void main(String[] args) {

        // 这里的数后面加“D”是表明它是Double类型，否则相除的话取整，无法正常使用
        double percent = 0.0001;
        // 输出一下，确认你的小数无误
        System.out.println("小数：" + percent);
        // 获取格式化对象
        NumberFormat nt = NumberFormat.getPercentInstance();
        // 设置百分数精确度2即保留两位小数
        nt.setMinimumFractionDigits(2);
        // 最后格式化并输出
        System.out.println("百分数：" + nt.format(percent));

        java.text.DecimalFormat df = new java.text.DecimalFormat("#");
        String strSummaryTakingQty = df.format(23);
        String strSummaryShipmentQty = df.format(2.3);
        String strSummarySignedQty = df.format(23.0);
        System.out.println("strSummaryTakingQty : " + strSummaryTakingQty);
        System.out.println("strSummaryShipmentQty : " + strSummaryShipmentQty);
        System.out.println("strSummarySignedQty : " + strSummarySignedQty);
    }
}
