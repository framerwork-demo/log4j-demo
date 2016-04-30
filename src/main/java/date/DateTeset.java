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
                 * 表现的和预期的不同，没有正确的理解其规范。必须使用正则表达式来进行校验格式，只通过能不能解析来判断是不行的。
                 */
                Date date = dataConvert.parse(maybeDateValue);
                System.out.println(date);
            } catch (ParseException e) {
                // 解析失败
            }
        }

    }

}
