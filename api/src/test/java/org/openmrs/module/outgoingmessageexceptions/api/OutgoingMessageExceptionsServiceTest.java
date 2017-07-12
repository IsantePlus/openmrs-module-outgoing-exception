/**
 * This Source Code Form is subject to the terms of the Mozilla Public License,
 * v. 2.0. If a copy of the MPL was not distributed with this file, You can
 * obtain one at http://mozilla.org/MPL/2.0/. OpenMRS is also distributed under
 * the terms of the Healthcare Disclaimer located at http://openmrs.org/license.
 *
 * Copyright (C) OpenMRS Inc. OpenMRS is a registered trademark and the OpenMRS
 * graphic logo is a trademark of OpenMRS Inc.
 */
package org.openmrs.module.outgoingmessageexceptions.api;

import org.apache.commons.io.IOUtils;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.openmrs.User;
import org.openmrs.api.UserService;
import org.openmrs.module.outgoingmessageexceptions.OutgoingMessage;
import org.openmrs.module.outgoingmessageexceptions.api.dao.OutgoingMessageExceptionsDao;
import org.openmrs.module.outgoingmessageexceptions.api.impl.OutgoingMessageExceptionsServiceImpl;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import java.io.InputStream;
import java.util.Date;

import static org.mockito.Mockito.*;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

/**
 * This is a unit test, which verifies logic in OutgoingMessageExceptionsService. It doesn't extend
 * BaseModuleContextSensitiveTest, thus it is run without the in-memory DB and Spring context.
 */
public class OutgoingMessageExceptionsServiceTest {
	private static final String OUTGOING_MESSAGE_RESPONSE_JSON = "/testOutgoingMessage.json";

	@InjectMocks
	OutgoingMessageExceptionsServiceImpl basicModuleService;

	@Mock
	OutgoingMessageExceptionsDao dao;
	
	@Mock
	UserService userService;
	
	@Before
	public void setupMocks() {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void saveItem_shouldSetOwnerIfNotSet() {
		//Given
		OutgoingMessage outgoingMessage = new OutgoingMessage();
		
		when(dao.saveItem(outgoingMessage)).thenReturn(outgoingMessage);
		
		User user = new User();
		when(userService.getUser(1)).thenReturn(user);
		
		//When
		basicModuleService.saveItem(outgoingMessage);
		
		//Then
		assertThat(outgoingMessage, hasProperty("owner", is(user)));
	}

	@Test
	public void shouldReturnMessageById() throws Exception {
		Integer testId = 1;

		when(dao.getMessageById(1)).thenReturn(prepareDummyOutgoingMessage());

		String expected = readJsonFromFile(OUTGOING_MESSAGE_RESPONSE_JSON);
		String fetched = basicModuleService.getMessageById(testId);

		assertEquals(expected, fetched);
	}

	private OutgoingMessage prepareDummyOutgoingMessage() {
		OutgoingMessage outgoingMessage = new OutgoingMessage(1, 2, "testMessageBody",
				new Date(2017, 11, 11), "testFailureReason", "testDestination",
				"testType", false);

		return outgoingMessage;
	}

	private String readJsonFromFile(String filename) throws Exception {
		Resource resource = new ClassPathResource(filename);
		String json;
		try(InputStream is = resource.getInputStream()) {
			json = IOUtils.toString(is);
		}

		return json;
	}
}

