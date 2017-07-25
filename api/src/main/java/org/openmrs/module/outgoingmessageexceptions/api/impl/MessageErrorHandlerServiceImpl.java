package org.openmrs.module.outgoingmessageexceptions.api.impl;

import org.openmrs.api.context.Context;
import org.openmrs.api.impl.BaseOpenmrsService;
import org.openmrs.module.outgoingmessageexceptions.OutgoingMessage;
import org.openmrs.module.outgoingmessageexceptions.api.MessageErrorHandlerService;
import org.openmrs.module.outgoingmessageexceptions.api.OutgoingMessageExceptionsService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;

public class MessageErrorHandlerServiceImpl extends BaseOpenmrsService implements MessageErrorHandlerService {
	
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
