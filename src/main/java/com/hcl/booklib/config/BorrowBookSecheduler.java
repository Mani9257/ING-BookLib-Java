package com.hcl.booklib.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.hcl.booklib.service.SchedulerServiceImpl;


@Component
public class BorrowBookSecheduler {

	@Autowired
	private SchedulerServiceImpl schedulerServiceImpl;
	
	@Scheduled(cron = "0 */1 * * * *")
	public void runTask() {
		schedulerServiceImpl.runTask();
	}
}
