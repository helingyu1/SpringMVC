package com.hly.activemq;

import java.util.HashMap;
import java.util.Map;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Component;

import com.google.gson.Gson;

/**
 * ActiveMQ ��Ϣ������
 * 
 * @author Mafly
 *
 */
@Component
public class MessageSender {
private Logger log = Logger.getLogger(MessageSender.class);
@Autowired
private JmsTemplate jmsTemplate;
private String Queue = "default_queue";
private String GoldQueue = "gold_queue";
private Gson gson = new Gson();
/**
 * �û���¼��Ϣ
 */
public void userLogin(long id, String username) {
    Map<String, Object> map = new HashMap<String, Object>();
    map.put("userid", id);
    map.put("username", username);
    System.out.println("������һ����Ϣ��");
    // ���͵���Ҷ���
    sendMessage(gson.toJson(map), 1);
}
/**
 * ���͵���Ϣ����
 * 
 * @param messgae
 * @param type
 *            ���ͣ�0:Ĭ�϶��� 1����Ҷ��� ...
 */
public void sendMessage(final String messgae, int type) {
    try {
        String destination = this.Queue;
        if (type == 1) {
            destination = GoldQueue;
        }
        jmsTemplate.send(destination, new MessageCreator() {
            public Message createMessage(Session session) throws JMSException {
                TextMessage textMessage = session.createTextMessage(messgae);
                return textMessage;
            }
        });
    } catch (Exception e) {
        log.error("", e);
    }
}
}