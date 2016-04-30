package log4j;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class TestLog4j {
    public static void main(String[] args) {
        PropertyConfigurator.configure("D:/dev/projects/progammodels/log/log4j/src/main/resources/log4j.properties");
        Logger logger = Logger.getLogger(TestLog4j.class);
        logger.debug(" debug ");
        logger.error(" error ");
    }
}
