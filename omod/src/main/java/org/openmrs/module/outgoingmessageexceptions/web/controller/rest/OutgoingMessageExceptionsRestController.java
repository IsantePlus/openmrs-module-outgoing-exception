package org.openmrs.module.outgoingmessageexceptions.web.controller.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller("${artifactid}.OutgoingMessageExceptionsRestController")
@RequestMapping(value = "/rest/isanteplus")
public class OutgoingMessageExceptionsRestController {
	
	private final Logger logger = LoggerFactory.getLogger(OutgoingMessageExceptionsRestController.class);
	
	@RequestMapping(value = "/message", method = RequestMethod.GET)
	@ResponseBody
	public String getMessage(@RequestParam(value = "uniqueID", required = true) String uniqueID,
	        @RequestBody(required = false) String body, HttpServletRequest request, HttpServletResponse response) {
		logger.debug("Get Single message reached");
		return uniqueID + " " + body;
	}
	
	@RequestMapping(value = "/messages", method = RequestMethod.GET)
	@ResponseBody
	public String getMessages(@RequestParam(value = "v", required = false) String scope, HttpServletRequest request,
	        HttpServletResponse response) {
		logger.debug("Get all messages reached");
		return scope;
	}
	
}
