/**
 * This Source Code Form is subject to the terms of the Mozilla Public License,
 * v. 2.0. If a copy of the MPL was not distributed with this file, You can
 * obtain one at http://mozilla.org/MPL/2.0/. OpenMRS is also distributed under
 * the terms of the Healthcare Disclaimer located at http://openmrs.org/license.
 *
 * Copyright (C) OpenMRS Inc. OpenMRS is a registered trademark and the OpenMRS
 * graphic logo is a trademark of OpenMRS Inc.
 */

package org.openmrs.module.outgoingmessageexceptions.fragment.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.openmrs.module.outgoingmessageexceptions.OutgoingMessage;
import org.openmrs.module.outgoingmessageexceptions.api.OutgoingMessageExceptionsService;
import org.openmrs.ui.framework.annotation.FragmentParam;
import org.openmrs.ui.framework.annotation.SpringBean;
import org.openmrs.ui.framework.fragment.FragmentModel;
import org.openmrs.ui.framework.fragment.FragmentRequest;

import java.io.IOException;
import java.text.SimpleDateFormat;

public class ExceptionDetailsFragmentController {
	
	public void controller(FragmentModel model, FragmentRequest request,
	        @SpringBean OutgoingMessageExceptionsService outgoingMessageExceptionsService,
	        @FragmentParam(value = "messageId", required = true) Integer messageId) throws IOException {
		String message = outgoingMessageExceptionsService.getMessageById(messageId);
		
		ObjectMapper mapper = new ObjectMapper();
		mapper.setDateFormat(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSSSSS"));
		OutgoingMessage outgoingMessage = mapper.readValue(message, OutgoingMessage.class);
		model.addAttribute("outgoingMessage", outgoingMessage);
		
		request.setProviderName("outgoing-message-exceptions"); // set the proper path to the fragment view (with '-' chars)
	}
}
