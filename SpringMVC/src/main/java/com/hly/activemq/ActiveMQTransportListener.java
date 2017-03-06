package com.hly.activemq;

import java.io.IOException;

import org.apache.activemq.transport.TransportListener;
import org.apache.log4j.Logger;

/**
 * ��Ϣ�������
 * 
 * @author hly
 * 
 */
public class ActiveMQTransportListener implements TransportListener {
	private Logger log = Logger.getLogger(ActiveMQTransportListener.class);

	/**
	 * ����Ϣ����������м��
	 * 
	 * @param command
	 */
	public void onCommand(Object o) {
	}

	/**
	 * �Լ�ص����쳣���д���
	 * 
	 * @param error
	 */
	public void onException(IOException error) {
		log.error("onException -> ��Ϣ���������Ӵ���......", error);
	}

	/**
	 * ��failoverʱ����
	 */
	public void transportInterupted() {
		log.warn("transportInterupted -> ��Ϣ���������ӷ����ж�...");
		// ����Ϳ���״̬���б�ʶ��
	}

	/**
	 * ��ص�failover�ָ�����д���
	 */
	public void transportResumed() {
		log.info("transportResumed -> ��Ϣ�����������ѻָ�...");
		// ����Ϳ��Խ���״̬��ʶ��
	}
}
