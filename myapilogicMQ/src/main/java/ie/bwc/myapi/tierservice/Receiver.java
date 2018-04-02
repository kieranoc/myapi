package ie.bwc.myapi.tierservice;

import java.util.concurrent.CountDownLatch;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Service;

import ie.bwc.myapi.models.Data;

/**
 * 
 * @author Kieran
 *
 */
@Service
public class Receiver {

	private CountDownLatch latch = new CountDownLatch(1);

	/**
	 * 
	 * @return
	 */
	public CountDownLatch getLatch() {
		return latch;
	}

	/**
	 * 
	 * @param data
	 */
	@JmsListener(destination = "mailbox")
	@SendTo("outbound.queue")
	public String receiveMessage(Data data) {
		System.out.println("Received <" + data.getId() + ">");
		latch.countDown();
		return "mq out string";
	}

}