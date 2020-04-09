package test.messaging.activemq_publisher.resource;

import java.time.Year;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import test.messaging.activemq_publisher.entity.ReportRequest;
import test.messaging.activemq_publisher.entity.ReportResponse;
import test.messaging.activemq_publisher.service.ReportService;

@RestController
@RequestMapping("report")
public class ReportController {

	@Autowired
	ReportService reportService;
	
	@PostMapping()
	ResponseEntity<ReportResponse> initiateReportRequest(@RequestBody ReportRequest request){
		
		System.out.println("In controller");
		 return new ResponseEntity<ReportResponse>(
			     reportService.inititateReportRequest(request), 
			      HttpStatus.OK);
	}
	
	@GetMapping("/age")
	ResponseEntity<String> age(
	  @RequestParam("yearOfBirth") int yearOfBirth) {
	  
	    if (isInFuture(yearOfBirth)) {
	        return new ResponseEntity<>(
	          "Year of birth cannot be in the future", 
	          HttpStatus.BAD_REQUEST);
	    }
	 
	    return new ResponseEntity<>(
	      "Your age is " + calculateAge(yearOfBirth), 
	      HttpStatus.OK);
	}	
	
	  private int calculateAge(int yearOfBirth) {
	        return currentYear() - yearOfBirth;
	    }

	    private boolean isInFuture(int year) {
	        return currentYear() < year;
	    }

	    private int currentYear() {
	        return Year.now().getValue();
	    }
	
}
