package org.openmrs.module.outgoingmessageexceptions.api.impl;

import org.openmrs.api.context.Context;
import org.openmrs.api.impl.BaseOpenmrsService;
import org.openmrs.module.outgoingmessageexceptions.OutgoingMessage;
import org.openmrs.module.outgoingmessageexceptions.api.OutgoingMessageExceptionsService;
import org.openmrs.module.registrationcore.api.MpiErrorHandlingService;
import org.openmrs.module.xdssender.api.service.XdsErrorHandlingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component("outgoingmessageexceptions.MpiErrorHandlingService")
public class MpiErrorHandlingServiceImpl extends BaseOpenmrsService implements MpiErrorHandlingService, XdsErrorHandlingService {
	
	@Autowired
	private OutgoingMessageExceptionsService outgoingMessageExceptionsService;
	
	@Override
	public void handle(String messageBody, String failureReason, String destination, String type, Boolean failure) {
		
		OutgoingMessage message = new OutgoingMessage();
		message.setOwner(Context.getUserService().getUser(1));
		message.setDestination(destination);
		message.setFailure(failure);
		message.setFailureReason(failureReason);
		message.setMessageBody(messageBody);
		message.setType(type);
		message.setTimestamp(new Date());
		
		outgoingMessageExceptionsService.saveItem(message);
	}
}
