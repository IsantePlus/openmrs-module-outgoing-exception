/**
 * This Source Code Form is subject to the terms of the Mozilla Public License,
 * v. 2.0. If a copy of the MPL was not distributed with this file, You can
 * obtain one at http://mozilla.org/MPL/2.0/. OpenMRS is also distributed under
 * the terms of the Healthcare Disclaimer located at http://openmrs.org/license.
 *
 * Copyright (C) OpenMRS Inc. OpenMRS is a registered trademark and the OpenMRS
 * graphic logo is a trademark of OpenMRS Inc.
 */
package org.openmrs.module.outgoingmessageexceptions.api.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import org.openmrs.api.APIException;
import org.openmrs.api.UserService;
import org.openmrs.api.impl.BaseOpenmrsService;
import org.openmrs.module.outgoingmessageexceptions.OutgoingMessage;
import org.openmrs.module.outgoingmessageexceptions.api.OutgoingMessageExceptionsService;
import org.openmrs.module.outgoingmessageexceptions.api.dao.OutgoingMessageExceptionsDao;

public class OutgoingMessageExceptionsServiceImpl extends BaseOpenmrsService implements OutgoingMessageExceptionsService {
	
	OutgoingMessageExceptionsDao dao;
	
	UserService userService;
	
	/**
	 * Injected in moduleApplicationContext.xml
	 */
	public void setDao(OutgoingMessageExceptionsDao dao) {
		this.dao = dao;
	}
	
	/**
	 * Injected in moduleApplicationContext.xml
	 */
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	
	@Override
	public OutgoingMessage getItemByUuid(String uuid) throws APIException {
		return dao.getItemByUuid(uuid);
	}
	
	@Override
	public OutgoingMessage saveItem(OutgoingMessage outgoingMessage) throws APIException {
		if (outgoingMessage.getOwner() == null) {
			outgoingMessage.setOwner(userService.getUser(1));
		}
		
		return dao.saveItem(outgoingMessage);
	}
	
	@Override
	public String getMessageById(Integer id) throws APIException, JsonProcessingException {
		
		OutgoingMessage outgoingMessage = dao.getMessageById(id);
		ObjectMapper mapper = new ObjectMapper();
		
		SimpleModule module = new SimpleModule();
		module.addSerializer(OutgoingMessage.class, new OutgoingMessage.OutgoingMessageSerializer());
		mapper.registerModule(module);
		
		return mapper.writeValueAsString(outgoingMessage);
	}
}