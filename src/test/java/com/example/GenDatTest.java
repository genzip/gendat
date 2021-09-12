package com.example;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;

public class GenDatTest {
	@Test
	void testCreateHeaderR1() {
		GenDat gen = new GenDat();
		List<String> head = gen.createHeader(2, 14);
		assertEquals(40, head.size());
		assertEquals("GPKEY", head.get(0));
		assertEquals("V02", head.get(1));
		assertEquals("V14", head.get(13));
		assertEquals(null, head.get(14));
		assertEquals(null, head.get(39));
	}
	@Test
	void testCreateHeaderR2() {
		GenDat gen = new GenDat();
		List<String> head = gen.createHeader(15, 27);
		assertEquals(40, head.size());
		assertEquals("GPKEY", head.get(0));
		assertEquals(null, head.get(1));
		assertEquals(null, head.get(13));
		assertEquals("V15", head.get(14));
		assertEquals("V27", head.get(26));
		assertEquals(null, head.get(27));
		assertEquals(null, head.get(39));
	}
	@Test
	void testCreateHeaderR3() {
		GenDat gen = new GenDat();
		List<String> head = gen.createHeader(28, 40);
		assertEquals(40, head.size());
		assertEquals("GPKEY", head.get(0));
		assertEquals(null, head.get(1));
		assertEquals(null, head.get(26));
		assertEquals("V28", head.get(27));
		assertEquals("V40", head.get(39));
	}
	@Test
	void testCreate() {
		GenDat gen = new GenDat();
		assertDoesNotThrow(() -> gen.create(3, "./test.cvs"));
	}
}
