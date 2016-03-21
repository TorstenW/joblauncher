/**
 * 
 */
package net.test.joblauncher.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Torsten Weidmann (torsten.weidmann@net-m.de)
 */
@RestController
public class TestController {
	
	@RequestMapping(value = "/test/{param}", method = RequestMethod.GET)
	public ResponseEntity<String> addJob(@PathVariable String param) {
		return new ResponseEntity<>("Called " + param, HttpStatus.OK);
	}

}
