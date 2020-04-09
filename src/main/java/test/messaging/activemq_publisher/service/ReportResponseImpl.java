package test.messaging.activemq_publisher.service;

import javax.jms.Queue;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.stereotype.Service;

import test.messaging.activemq_publisher.entity.ReportRequest;
import test.messaging.activemq_publisher.entity.ReportResponse;

@Service
public class ReportResponseImpl implements ReportService {

	@Autowired
	private JmsMessagingTemplate jmsMessagingTemplate;
	@Autowired
	private Queue queue;
	
	@Override
	public ReportResponse inititateReportRequest(ReportRequest request) {
		System.out.println("In Service");

		ReportResponse response = new ReportResponse();
		try {
			this.jmsMessagingTemplate.convertAndSend(this.queue, request);	//"Hello ActiveMQ!!");
			response.setMsg("Message publised on Queue");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		// TODO Auto-generated method stub
		return response;
	}

}
