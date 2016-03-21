/**
 * 
 */
package net.test.joblauncher.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import net.test.joblauncher.entity.JobEntity;

/**
 *
 * @author Torsten Weidmann (torsten.weidmann@net-m.de)
 */
public interface JobDao extends JpaRepository<JobEntity, Long> {

}
