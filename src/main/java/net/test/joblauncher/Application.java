/**
 * 
 */
package net.test.joblauncher;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 *
 * @author Torsten Weidmann (torsten.weidmann@net-m.de)
 */
@SpringBootApplication
@EnableScheduling
public class Application {
	
	public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
