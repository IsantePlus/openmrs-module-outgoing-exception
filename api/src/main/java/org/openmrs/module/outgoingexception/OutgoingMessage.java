/**
 * This Source Code Form is subject to the terms of the Mozilla Public License,
 * v. 2.0. If a copy of the MPL was not distributed with this file, You can
 * obtain one at http://mozilla.org/MPL/2.0/. OpenMRS is also distributed under
 * the terms of the Healthcare Disclaimer located at http://openmrs.org/license.
 *
 * Copyright (C) OpenMRS Inc. OpenMRS is a registered trademark and the OpenMRS
 * graphic logo is a trademark of OpenMRS Inc.
 */
package org.openmrs.module.outgoingexception;

import org.openmrs.BaseOpenmrsData;
import org.openmrs.User;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.util.Date;

/**
 * Please note that a corresponding table schema must be created in liquibase.xml.
 */
//Uncomment 2 lines below if you want to make the OutgoingMessage class persistable, see also OutgoingExceptionDaoTest and liquibase.xml
@Entity(name = "outgoingexception.OutgoingMessage")
@Table(name = "outgoingexception_message")
public class OutgoingMessage extends BaseOpenmrsData {
	
	@Id
	@GeneratedValue
	@Column(name = "outgoingexception_message_id")
	private Integer id;
	
	@ManyToOne
	@JoinColumn(name = "owner")
	private User owner;
	
	@Basic
	@Column(name = "message_body", length = 255)
	private String message_body;
	
	@Basic
	@Column(name = "timestamp", length = 255)
	private Date timestamp;
	
	@Basic
	@Column(name = "failure_reason", length = 255)
	private String failure_reason;
	
	@Basic
	@Column(name = "destination", length = 255)
	private String destination;
	
	@Basic
	@Column(name = "type", length = 255)
	private String type;

	@Basic
	@Column(name = "failure")
	private Boolean failure;
	
	@Override
	public Integer getId() {
		return id;
	}
	
	@Override
	public void setId(Integer id) {
		this.id = id;
	}
	
	@Override
	public String getUuid() {
		return super.getUuid();
	}
	
	@Override
	public void setUuid(String uuid) {
		super.setUuid(uuid);
	}
	
	public User getOwner() {
		return owner;
	}
	
	public void setOwner(User owner) {
		this.owner = owner;
	}
	
	public String getMessage_body() {
		return message_body;
	}
	
	public void setMessage_body(String message_body) {
		this.message_body = message_body;
	}
	
	public Date getTimestamp() {
		return timestamp;
	}
	
	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}
	
	public String getFailure_reason() {
		return failure_reason;
	}
	
	public void setFailure_reason(String failure_reason) {
		this.failure_reason = failure_reason;
	}
	
	public String getDestination() {
		return destination;
	}
	
	public void setDestination(String destination) {
		this.destination = destination;
	}
	
	public String getType() {
		return type;
	}
	
	public void setType(String type) {
		this.type = type;
	}

	public Boolean getFailure() {
		return failure;
	}

	public void setFailure(Boolean failure) {
		this.failure = failure;
	}
}
