/**
 * 
 */
package net.test.joblauncher.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;
import net.test.joblauncher.dao.JobDao;
import net.test.joblauncher.entity.JobEntity;

/**
 *
 * @author Torsten Weidmann (torsten.weidmann@net-m.de)
 */
@RestController
@Slf4j
@RequestMapping("/schedule")
public class ScheduleController {
	
	private final JobDao jobDao;
	
	@Autowired
	public ScheduleController(JobDao jobDao) {
		this.jobDao = jobDao;
	}
	
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public ResponseEntity<String> addJob(@RequestParam(value = "callurl") String url,
			@RequestParam(value = "interval") long interval) {
		log.info("Received request to addJob with url {} and interval {}", url, interval);
		JobEntity jobEntity = new JobEntity();
		jobEntity.setInterval(interval);
		jobEntity.setCallUrl(url);
		jobEntity.setNextExecution(new Date());
		jobDao.save(jobEntity);
		return new ResponseEntity<>("Success", HttpStatus.OK);
	}

}
