package org.openmrs.module.outgoingmessageexceptions.api;

import org.openmrs.api.OpenmrsService;
import org.openmrs.module.registrationcore.MessageErrorHandler;

public interface MessageErrorHandlerService extends MessageErrorHandler, OpenmrsService {
	
	void handle(String messageBody, String failureReason, String destination, String type, Boolean failure);
}
