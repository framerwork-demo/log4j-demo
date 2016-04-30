package jms.activeMQ;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.MessageConsumer;
import javax.jms.Session;
import javax.jms.TextMessage;
import org.apache.activemq.ActiveMQConnectionFactory;

/** 
 * ��Ϣ������,�ֶ�����ʾ�� 
 * @author Ickes 
 */
public class QueuesAccept {
    public static void main(String[] args) throws Exception {
        ConnectionFactory connectionFactory = new ActiveMQConnectionFactory("tcp://localhost:61616");
        Connection conn = connectionFactory.createConnection();
        Session session = conn.createSession(false, Session.AUTO_ACKNOWLEDGE);
        conn.start();
        // ��ϢĿ�ĵ�
        Destination dest = session.createQueue("gosun");
        // ��Ϣ������
        MessageConsumer consumer = session.createConsumer(dest);
        // ������Ϣ����ʱʱ��Ϊ10�룬���ֶ�����JMS��Ϣ����������ü���
        TextMessage textMessage = (TextMessage) consumer.receive(10 * 1000);
        String text = textMessage.getText();
        System.out.println("���յ�����ϢΪ��" + text);
        // �ر�ͨ��
        consumer.close();
        session.close();
        conn.close();
    }
}
