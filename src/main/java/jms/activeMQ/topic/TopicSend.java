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
 * 生产者发送消息到主题中 
 * @author Ickes 
 * 
 */  
public class TopicSend {  
    public static void main(String[] args) throws Exception {  
        // 第一步：根据url创建一个jms Connection。  
        ActiveMQConnectionFactory connectionfactory = new ActiveMQConnectionFactory("tcp://localhost:8161");  
        Connection connection = connectionfactory.createConnection();  
        connection.start();  
        // 第二步：根据connection获取session  
        Session session = connection.createSession(false,Session.AUTO_ACKNOWLEDGE);  
        // 第三步：创建一个Topic  
        Topic topic= new ActiveMQTopic("testTopic");    
        // 第四步：创建生产者用于将消息发送至主题  
        MessageProducer producer = session.createProducer(topic);   
        // 设置不持久化  
        producer.setDeliveryMode(DeliveryMode.NON_PERSISTENT);  
        // 第五步：创建消息  
        Message msg = session.createTextMessage("JMS 告诉你我是ICKES");  
        producer.send(msg);  
        //第七步：关闭连接  
        session.close();  
        connection.close();  
    }  
}
