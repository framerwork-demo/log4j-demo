package jms.activeMQ;

import javax.jms.Connection;
import javax.jms.DeliveryMode;
import javax.jms.Destination;
import javax.jms.Message;
import javax.jms.MessageProducer;
import javax.jms.Session;
import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.command.ActiveMQQueue;

/** 
 * ��Ϣ����ģ�ͷ�����Ϣ��activeMQ 
 * @author Ickes 
 */
public class QueueSend {

    public static void main(String[] args) throws Exception {
        // ��һ��������url����һ��jms Connection��
        ActiveMQConnectionFactory connectionfactory = new ActiveMQConnectionFactory("tcp://localhost:61616");
        Connection connection = connectionfactory.createConnection();
        connection.start();
        // �ڶ���������connection��ȡsession
        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        // ����������Ϣ��Ŀ�ĵ�
        Destination destination = new ActiveMQQueue("gosun");
        // ���Ĳ���������Ϣ������
        MessageProducer producer = session.createProducer(destination);
        // ���ò��־û�
        producer.setDeliveryMode(DeliveryMode.NON_PERSISTENT);
        // ���岽��������Ϣ
        Message msg = session.createTextMessage("JMS ����������ICKES");
        // ����������������JMS������Ϣ������
        producer.send(msg);
        // ���߲����ر�����
        session.close();
        connection.close();
        
        System.out.println("����");
    }
}
