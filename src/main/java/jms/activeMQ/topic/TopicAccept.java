package jms.activeMQ.topic;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.MessageConsumer;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.jms.Topic;
import org.apache.activemq.ActiveMQConnectionFactory;

/** 
 * �����ߴ������ж�����Ϣ 
 * @author Ickes 
 * 
 */
public class TopicAccept {
    public static void main(String[] args) throws Exception {
        ConnectionFactory connectionFactory = new ActiveMQConnectionFactory("tcp://localhost:8161");
        Connection conn = connectionFactory.createConnection();
        Session session = conn.createSession(false, Session.AUTO_ACKNOWLEDGE);
        conn.start();
        // ����Ŀ�ĵ�
        Topic topic = session.createTopic("testTopic");
        // ע�ᶩ����
        MessageConsumer consumer = session.createConsumer(topic);
        // �ֶ���ȡ��Ϣ
        TextMessage textMessage = (TextMessage) consumer.receive(10 * 1000);
        String text = textMessage.getText();
        System.out.println("���յ�����ϢΪ��" + text);
        // �ر�ͨ��
        consumer.close();
        session.close();
        conn.close();
    }
}
