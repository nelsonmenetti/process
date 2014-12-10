package com.br.jty.process.entity;

import java.util.Date;

public class Message {

	String processId;
	String processInstanceId;
	String processName;	
	String stepId;
	String stepName;
	String activityId;	
	String activityName;	
	String value;
	boolean hasBeenRead;
	Date readDate;
	Date sentDate;
	
}
