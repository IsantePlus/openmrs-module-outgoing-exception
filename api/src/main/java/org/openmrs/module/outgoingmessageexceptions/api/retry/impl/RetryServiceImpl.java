package org.openmrs.module.outgoingmessageexceptions.api.retry.impl;

import org.openmrs.module.outgoingmessageexceptions.api.retry.RetryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("outgoingmessageexceptions.RetryService")
public class RetryServiceImpl implements RetryService {
	
	@Autowired
	private XdsBRetryInvoker xdsBRetryInvoker;
	
	@Autowired
	private PixRetryInvoker pixRetryInvoker;
	
	@Override
	public void retryAll() {
	
	}
}
