/**
 * 
 */
package net.test.joblauncher.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Data;

/**
 *
 * @author Torsten Weidmann (torsten.weidmann@net-m.de)
 */
@Entity
@Table(name = "jobs")
@Data
public class JobEntity {
	
	@Id
	@SequenceGenerator(name = "JOB_ID_GENERATOR", sequenceName = "JOB_ID_SEQ", allocationSize = 1, initialValue = 100)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "JOB_ID_GENERATOR")
	private long id;
	
	@Column(nullable = false, name = "callurl")
	private String callUrl;
	
	@Column(nullable = false)
	private long interval;
	
	@Column(name = "nextexecution")
	@Temporal(TemporalType.TIMESTAMP)
	private Date nextExecution;
	
	public void incrementNextExecution() {
		long incrementedExecution = nextExecution.getTime() + interval;
		nextExecution = new Date(incrementedExecution);
	}

}
