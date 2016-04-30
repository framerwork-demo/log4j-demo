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
 * ʹ�ü��������Զ�������Ϣ 
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
     * ���Դ��� 
     * @param args 
     * @throws Exception 
     */
    public static void main(String[] args) throws Exception {
        ConnectionFactory connectionFactory = new ActiveMQConnectionFactory("tcp://localhost:61616");
        Connection conn = connectionFactory.createConnection();
        Session session = conn.createSession(false, Session.AUTO_ACKNOWLEDGE);
        conn.start();
        // ��ϢĿ�ĵ�
        Destination dest = session.createQueue("gosun");
        // ��Ϣ������
        MessageConsumer consumer = session.createConsumer(dest);
        consumer.setMessageListener(new QueuesAcceptListener());
        // ���ﲻ�ܹر����ӣ�һ���رռ�����Ҳ�͹رգ��Ǿͽ��ղ�����Ϣ��
    }

}
