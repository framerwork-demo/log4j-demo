package jms.activeMQ;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.MessageListener;
import javax.jms.Session;
import javax.jms.TextMessage;
import org.apache.activemq.ActiveMQConnectionFactory;

/** 
 * 使用监听器，自动接收消息 
 * @author Lenovo 
 * 
 */
public class QueuesAcceptListener implements MessageListener {

    public void onMessage(Message message) {
        TextMessage text = (TextMessage) message;
        try {
            System.out.println(text.getText());
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }

    /** 
     * 测试代码 
     * @param args 
     * @throws Exception 
     */
    public static void main(String[] args) throws Exception {
        ConnectionFactory connectionFactory = new ActiveMQConnectionFactory("tcp://localhost:61616");
        Connection conn = connectionFactory.createConnection();
        Session session = conn.createSession(false, Session.AUTO_ACKNOWLEDGE);
        conn.start();
        // 消息目的地
        Destination dest = session.createQueue("gosun");
        // 消息消费者
        MessageConsumer consumer = session.createConsumer(dest);
        consumer.setMessageListener(new QueuesAcceptListener());
        // 这里不能关闭连接，一旦关闭监听器也就关闭，那就接收不到消息了
    }

}
