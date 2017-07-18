package org.openmrs.module.outgoingmessageexceptions.fragment.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.lang.StringUtils;
import org.openmrs.module.outgoingmessageexceptions.OutgoingMessage;
import org.openmrs.module.outgoingmessageexceptions.api.OutgoingMessageExceptionsService;
import org.openmrs.ui.framework.annotation.FragmentParam;
import org.openmrs.ui.framework.annotation.SpringBean;
import org.openmrs.ui.framework.fragment.FragmentModel;

import java.io.IOException;
import java.text.SimpleDateFormat;

public class ExceptionDetailsFragmentController {
	
	public void controller(FragmentModel model,
	        @SpringBean OutgoingMessageExceptionsService outgoingMessageExceptionsService,
	        @FragmentParam(value = "messageId", required = true) Integer messageId) throws IOException {
		String message = outgoingMessageExceptionsService.getMessageById(messageId);
		
		ObjectMapper mapper = new ObjectMapper();
		mapper.setDateFormat(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSSSSS"));
		OutgoingMessage outgoingMessage = mapper.readValue(message, OutgoingMessage.class);
		model.addAttribute("outgoingMessage", outgoingMessage);
	}
}
