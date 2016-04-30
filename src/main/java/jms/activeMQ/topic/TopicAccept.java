package jms.activeMQ.topic;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.MessageConsumer;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.jms.Topic;
import org.apache.activemq.ActiveMQConnectionFactory;

/** 
 * 消费者从主题中订阅消息 
 * @author Ickes 
 * 
 */
public class TopicAccept {
    public static void main(String[] args) throws Exception {
        ConnectionFactory connectionFactory = new ActiveMQConnectionFactory("tcp://localhost:8161");
        Connection conn = connectionFactory.createConnection();
        Session session = conn.createSession(false, Session.AUTO_ACKNOWLEDGE);
        conn.start();
        // 主题目的地
        Topic topic = session.createTopic("testTopic");
        // 注册订阅者
        MessageConsumer consumer = session.createConsumer(topic);
        // 手动获取消息
        TextMessage textMessage = (TextMessage) consumer.receive(10 * 1000);
        String text = textMessage.getText();
        System.out.println("接收到的消息为：" + text);
        // 关闭通道
        consumer.close();
        session.close();
        conn.close();
    }
}
