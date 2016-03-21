/**
 * 
 */
package net.test.joblauncher.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 *
 * @author Torsten Weidmann (torsten.weidmann@net-m.de)
 */
@ControllerAdvice
public class GlobalDefaultExceptionHandler {
	
	@ExceptionHandler(value = Exception.class)
    public ResponseEntity<String> genericError(HttpServletRequest req, Exception e) {
		return new ResponseEntity<>("Server error", HttpStatus.INTERNAL_SERVER_ERROR);
    }
	
}
