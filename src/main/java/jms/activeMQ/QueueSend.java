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
 * 消息队列模型发送消息至activeMQ 
 * @author Ickes 
 */
public class QueueSend {

    public static void main(String[] args) throws Exception {
        // 第一步：根据url创建一个jms Connection。
        ActiveMQConnectionFactory connectionfactory = new ActiveMQConnectionFactory("tcp://localhost:61616");
        Connection connection = connectionfactory.createConnection();
        connection.start();
        // 第二步：根据connection获取session
        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        // 第三步：消息的目的地
        Destination destination = new ActiveMQQueue("gosun");
        // 第四步：创建消息生产者
        MessageProducer producer = session.createProducer(destination);
        // 设置不持久化
        producer.setDeliveryMode(DeliveryMode.NON_PERSISTENT);
        // 第五步：创建消息
        Message msg = session.createTextMessage("JMS 告诉你我是ICKES");
        // 第六步：生产者向JMS发送消息到队列
        producer.send(msg);
        // 第七步：关闭连接
        session.close();
        connection.close();
        
        System.out.println("结束");
    }
}
