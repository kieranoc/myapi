package ie.bwc.myapi.tierservice;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.ObjectMessage;
import javax.jms.Session;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Service;

import ie.bwc.myapi.models.Data;

/**
 * 
 * @author Kieran
 *
 */
@Service
public class MQClient {

	@Autowired
	private JmsTemplate jmsTemplate;

	/**
	 * 
	 * @param destination
	 * @param message
	 */
	public void send(String destination, Data data) {
		System.out.println("Sending: [" + data + "] to [" + destination + "]");		
		jmsTemplate.setReceiveTimeout(500);
		Message replyMessage = jmsTemplate.sendAndReceive(destination, new MessageCreator() {
	        @Override
	        public Message createMessage(Session session) throws JMSException {
	            ObjectMessage message = session.createObjectMessage(data);
	            return message;
	        }
	    });
		System.out.println("replyMessage: [" + replyMessage + "]");
	}
	
}