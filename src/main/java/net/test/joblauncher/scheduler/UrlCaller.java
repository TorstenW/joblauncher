/**
 * 
 */
package net.test.joblauncher.scheduler;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import lombok.extern.slf4j.Slf4j;
import net.test.joblauncher.dao.JobDao;
import net.test.joblauncher.entity.JobEntity;

/**
 *
 * @author Torsten Weidmann (torsten.weidmann@net-m.de)
 */
@Component
@Slf4j
public class UrlCaller {
	
	@Autowired
	private JobDao jobDao;
	
	@Scheduled(fixedRate = 1000) 
	public void execute() {
		log.info("================ NEW EXECUTION ===============");
		List<JobEntity> jobs = jobDao.findAll();
		Long now = new Date().getTime();
		for(JobEntity job : jobs) {
			if(job.getNextExecution().getTime() <= now) {
				RestTemplate restTemplate = new RestTemplate();
				ResponseEntity<String> response = restTemplate.getForEntity(job.getCallUrl(), String.class);
				log.info("Response for Job {}: {}", job.getId(), response.getBody());
				job.incrementNextExecution();
				jobDao.save(job);
			}
		}
	}

}
