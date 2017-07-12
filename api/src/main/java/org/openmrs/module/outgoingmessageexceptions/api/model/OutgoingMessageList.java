package org.openmrs.module.outgoingmessageexceptions.api.model;

import com.google.gson.annotations.Expose;
import org.openmrs.module.outgoingmessageexceptions.OutgoingMessage;

import java.time.LocalDate;
import java.util.List;

public final class OutgoingMessageList {
	
	@Expose
	private final Integer total;
	
	@Expose
	private final Integer page;
	
	@Expose
	private final Integer pageSize;
	
	@Expose
	private final LocalDate from;
	
	@Expose
	private final List<OutgoingMessage> data;
	
	public OutgoingMessageList(Integer page, Integer pageSize, LocalDate from, List<OutgoingMessage> data) {
		this.total = data.size();
		this.page = page;
		this.pageSize = pageSize;
		this.from = from;
		this.data = data;
	}
	
	public Integer getTotal() {
		return total;
	}
	
	public Integer getPage() {
		return page;
	}
	
	public Integer getPageSize() {
		return pageSize;
	}
	
	public LocalDate getFrom() {
		return from;
	}
	
	public OutgoingMessage getData(int index) {
		return data.get(index);
	}
}
