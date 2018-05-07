package org.openmrs.module.outgoingmessageexceptions.api.retry.impl;

import org.openmrs.module.outgoingmessageexceptions.OutgoingMessage;
import org.openmrs.module.outgoingmessageexceptions.api.retry.RetryInvoker;
import org.springframework.stereotype.Service;

@Service
public class XdsBRetryInvoker implements RetryInvoker {
	
	@Override
	public void retry(OutgoingMessage outgoingMessage) {
	
	}
}
