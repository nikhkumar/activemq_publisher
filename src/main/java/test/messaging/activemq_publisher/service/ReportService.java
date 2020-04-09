package test.messaging.activemq_publisher.service;

import org.springframework.stereotype.Service;

import test.messaging.activemq_publisher.entity.ReportRequest;
import test.messaging.activemq_publisher.entity.ReportResponse;

@Service
public interface ReportService {
	
	public ReportResponse inititateReportRequest(ReportRequest request);

}
