package com.idividends.data.dto;


import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
public class TaskResultTest {

	@Test
	public void valuesTest() {
		TaskResult result = null;
		for (TaskResult value : TaskResult.values()) {
			if (value.equals(TaskResult.SUCCESS)) {
				result = value;
			}
		}
		assertEquals(TaskResult.SUCCESS, result);
	}

	@Test
	public void valueOfTest() {
		assertEquals(TaskResult.valueOf("SUCCESS"), TaskResult.SUCCESS);
	}

}
