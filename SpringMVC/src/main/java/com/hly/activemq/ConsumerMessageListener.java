package com.hly.activemq;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

/**
 * �����߼�����
 * 
 * @author hly
 */
@Component
public class ConsumerMessageListener implements MessageListener {
	private Logger log = Logger.getLogger(ConsumerMessageListener.class);

	public void onMessage(Message arg0) {
		// �������͵���Ϣ���е��ı���Ϣ����ǿ��ת����
		TextMessage textMessage = (TextMessage) arg0;
		try {
			System.out.println("���յ�����Ϣ�����ǣ�" + textMessage.getText());
			// TODO: ��ϲ�����κ�����...
		} catch (JMSException e) {
			log.error("", e);
		}
	}
}
