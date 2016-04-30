package date;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.google.common.collect.Lists;

public class DateTeset {
    private static final String FORMAT_YYYY_MM_DD = "yyyy-MM-dd";
    private static final String FORMAT_YYYY_MM_DD2 = "yyyy/MM/dd";


    public static void main(String[] args) {
        System.out.println("start");
        test();
        System.out.println("end");
    }

    public static void test() {
        String maybeDateValue = "2016--3--28";
        List<String> dateForms = Lists.newArrayList(FORMAT_YYYY_MM_DD, FORMAT_YYYY_MM_DD2);
        for (String dateForm : dateForms) {
            SimpleDateFormat dataConvert = new SimpleDateFormat(dateForm);
            try {
                /**
                 * ���ֵĺ�Ԥ�ڵĲ�ͬ��û����ȷ�������淶������ʹ��������ʽ������У���ʽ��ֻͨ���ܲ��ܽ������ж��ǲ��еġ�
                 */
                Date date = dataConvert.parse(maybeDateValue);
                System.out.println(date);
            } catch (ParseException e) {
                // ����ʧ��
            }
        }

    }

}
