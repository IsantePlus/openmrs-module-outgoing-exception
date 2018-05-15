package org.openmrs.module.outgoingmessageexceptions.api.retry.impl;

import java.sql.Timestamp;
import org.openmrs.api.context.Context;
import org.openmrs.module.outgoingmessageexceptions.api.retry.RetrySchedulerService;
import org.openmrs.scheduler.TaskDefinition;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service("outgoingmessageexceptions.RetrySchedulerService")
public class RetrySchedulerServiceImpl implements RetrySchedulerService {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(RetrySchedulerServiceImpl.class);
	
	@Override
	public void createTaskIfNotExists() {
		createTaskIfNotExists(RetryTask.TASK_NAME, RetryTask.TASK_DESCRIPTION, RetryTask.class,
				RetryTask.DEFAULT_INTERVAL_SECONDS);
	}
	
	private void createTaskIfNotExists(String name, String description, Class retryClass, Long interval) {
		TaskDefinition result = Context.getSchedulerService().getTaskByName(name);
		
		if (result == null) {
			result = new TaskDefinition();
			
			result.setName(name);
			result.setDescription(description);
			result.setTaskClass(retryClass.getName());
			result.setRepeatInterval(interval);
			result.setStartTime(new Timestamp(System.currentTimeMillis()));
			result.setStartOnStartup(true);
			result.setCreator(Context.getAuthenticatedUser());
			
			try {
				Context.getSchedulerService().saveTaskDefinition(result);
				Context.getSchedulerService().scheduleTask(
						Context.getSchedulerService().getTaskByName(name));
				LOGGER.info(String.format("Created new scheduler task '%s'", name));
			} catch (Exception e) {
				LOGGER.error(String.format("Error during creating scheduler task '%s'", name), e);
			}
		}
	}
}
