package number;

import java.text.NumberFormat;

public class NumberFormatTest1 {
    public static void main(String[] args) {

        // �����������ӡ�D���Ǳ�������Double���ͣ���������Ļ�ȡ�����޷�����ʹ��
        double percent = 0.0001;
        // ���һ�£�ȷ�����С������
        System.out.println("С����" + percent);
        // ��ȡ��ʽ������
        NumberFormat nt = NumberFormat.getPercentInstance();
        // ���ðٷ�����ȷ��2��������λС��
        nt.setMinimumFractionDigits(2);
        // ����ʽ�������
        System.out.println("�ٷ�����" + nt.format(percent));

        java.text.DecimalFormat df = new java.text.DecimalFormat("#");
        String strSummaryTakingQty = df.format(23);
        String strSummaryShipmentQty = df.format(2.3);
        String strSummarySignedQty = df.format(23.0);
        System.out.println("strSummaryTakingQty : " + strSummaryTakingQty);
        System.out.println("strSummaryShipmentQty : " + strSummaryShipmentQty);
        System.out.println("strSummarySignedQty : " + strSummarySignedQty);
    }
}
