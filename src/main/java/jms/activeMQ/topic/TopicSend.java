package jms.activeMQ.topic;

import javax.jms.Connection;  
import javax.jms.DeliveryMode;  
import javax.jms.Message;  
import javax.jms.MessageProducer;  
import javax.jms.Session;  
import javax.jms.Topic;  
import org.apache.activemq.ActiveMQConnectionFactory;  
import org.apache.activemq.command.ActiveMQTopic;  
  
/** 
 * �����߷�����Ϣ�������� 
 * @author Ickes 
 * 
 */  
public class TopicSend {  
    public static void main(String[] args) throws Exception {  
        // ��һ��������url����һ��jms Connection��  
        ActiveMQConnectionFactory connectionfactory = new ActiveMQConnectionFactory("tcp://localhost:8161");  
        Connection connection = connectionfactory.createConnection();  
        connection.start();  
        // �ڶ���������connection��ȡsession  
        Session session = connection.createSession(false,Session.AUTO_ACKNOWLEDGE);  
        // ������������һ��Topic  
        Topic topic= new ActiveMQTopic("testTopic");    
        // ���Ĳ����������������ڽ���Ϣ����������  
        MessageProducer producer = session.createProducer(topic);   
        // ���ò��־û�  
        producer.setDeliveryMode(DeliveryMode.NON_PERSISTENT);  
        // ���岽��������Ϣ  
        Message msg = session.createTextMessage("JMS ����������ICKES");  
        producer.send(msg);  
        //���߲����ر�����  
        session.close();  
        connection.close();  
    }  
}
