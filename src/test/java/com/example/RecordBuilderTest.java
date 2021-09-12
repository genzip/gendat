package com.example;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

public class RecordBuilderTest {
	@Test
	void testBuild() {
		List<String> h = new ArrayList<String>();
		h.add(null);
		h.add(null);
		h.add("GPKEY");
		h.add("V04");
		h.add("V05");
		h.add(null);
		
		RecordBuilder builder = new RecordBuilder().setGpkey(1);
		builder.setRecordHeader(h);
		// assertEquals(",,GPKEY:.+1,V04:.+,V05:.+,", builder.build());
		assertTrue(builder.build().matches(",,GPKEY:.+1,V04:.+,V05:.+,"));
	}

	@Test
	void testCreateGPVal() {
		RecordBuilder builder = new RecordBuilder().setGpkey(1);
		assertEquals(20, builder.createGPVal().length());
		assertEquals("GPKEY:00000000000001", builder.createGPVal());
	}

	@Test
	void testCreateVal() {
		RecordBuilder builder = new RecordBuilder();
		builder.setRecordHeader(Arrays.asList("GPKEY", "V01", "V02"));
		String first = builder.createVal(1);
		String next = builder.createVal(1);
		assertEquals(20, first.length());
		assertEquals(20, next.length());
		assertTrue(first.matches("V01:.+"));
		assertNotEquals(first, next);
	}
}
