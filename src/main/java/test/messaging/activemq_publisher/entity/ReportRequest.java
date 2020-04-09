package test.messaging.activemq_publisher.entity;

import java.io.Serializable;


public class ReportRequest implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String userid;
	private String reportType;
	private String timeline;
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getReportType() {
		return reportType;
	}
	public void setReportType(String reportType) {
		this.reportType = reportType;
	}
	public String getTimeline() {
		return timeline;
	}
	public void setTimeline(String timeline) {
		this.timeline = timeline;
	}
	@Override
	public String toString() {
		return "ReportRequest [userid=" + userid + ", reportType=" + reportType + ", timeline=" + timeline + "]";
	}
	
	
	
}
