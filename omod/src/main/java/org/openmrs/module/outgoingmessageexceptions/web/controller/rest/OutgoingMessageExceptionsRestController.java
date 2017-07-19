package org.openmrs.module.outgoingmessageexceptions.web.controller.rest;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.openmrs.module.outgoingmessageexceptions.api.OutgoingMessageExceptionsService;
import org.openmrs.module.outgoingmessageexceptions.api.converter.OutgoingMessageStringToDateConverter;
import org.openmrs.module.outgoingmessageexceptions.api.model.enums.MessageType;
import org.openmrs.module.outgoingmessageexceptions.api.model.enums.SortingFieldName;
import org.openmrs.module.outgoingmessageexceptions.api.model.enums.SortingOrder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller("${artifactid}.OutgoingMessageExceptionsRestController")
@RequestMapping(value = "/rest/isanteplus", produces = MediaType.APPLICATION_JSON_VALUE)
public class OutgoingMessageExceptionsRestController {
	
	private final Logger logger = LoggerFactory.getLogger(OutgoingMessageExceptionsRestController.class);
	
	@Autowired
	OutgoingMessageExceptionsService outgoingMessageExceptionsService;
	
	@RequestMapping(value = "/message", method = RequestMethod.GET)
	@ResponseBody
	public String getMessage(@RequestParam(value = "uniqueID", required = true) String uniqueID,
	        @RequestBody(required = false) String body, HttpServletRequest request, HttpServletResponse response) {
		logger.debug("Get Single message reached");
		return uniqueID + " " + body;
	}
	
	@RequestMapping(value = "/messages", method = RequestMethod.GET)
	@ResponseBody
	public String getMessagesList(@RequestParam(value = "pageIndex", defaultValue = "1") Integer pageIndex,
	        @RequestParam(value = "pageSize", defaultValue = "100") Integer pageSize,
	        @RequestParam(value = "from", required = false) String from,
	        @RequestParam(value = "v", required = false) String v,
	        @RequestParam(value = "sortField", defaultValue = "TIMESTAMP") String sortField,
	        @RequestParam(value = "sortOrder", defaultValue = "DESC") String sortOrder,
	        @RequestParam(value = "type", required = false) String type,
	        @RequestParam(value = "failed", defaultValue = "false") Boolean failed) {
		
		SortingFieldName sortingFieldName = sortField.equals("user.name") ? SortingFieldName.OWNER : SortingFieldName
		        .valueOf(sortField.toUpperCase());
		SortingOrder sortingOrder = sortOrder != null ? SortingOrder.valueOf(sortOrder.toUpperCase()) : null;
		MessageType messageType = type != null ? MessageType.valueOf(type.toUpperCase()) : null;
		
		OutgoingMessageStringToDateConverter converter = new OutgoingMessageStringToDateConverter();
		return outgoingMessageExceptionsService.getPaginatedMessages(pageIndex, pageSize, converter.convert(from), v,
		    sortingFieldName, sortingOrder, messageType, failed);
	}
	
	@RequestMapping(value = "/messages/{id}", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public String getMessageById(@PathVariable Integer id) throws JsonProcessingException {
		logger.debug("Get Single message reached by message id");
		return outgoingMessageExceptionsService.getMessageById(id);
	}
}
