package com.idividends.data.dto;

import org.apache.commons.lang.builder.ToStringBuilder;

public class TaskDto {

	private TaskResult result;

	/**
	 * 
	 */
	public TaskDto() {
		super();
		// From the beginning there will be a result
		result = TaskResult.ERROR_NO_RESULT;
	}

	/**
	 * @return the result
	 */
	public TaskResult getResult() {
		return result;
	}

	/**
	 * @param result
	 *            the result to set
	 */
	public void setResult(TaskResult result) {
		this.result = result;
	}

	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}

}
