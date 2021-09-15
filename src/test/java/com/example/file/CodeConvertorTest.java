package com.example.file;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.fail;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CodeConvertorTest {
	@Test
	@DisplayName("aTob: CSVが正常な記述")
	void testATob01() {
		try {
			assertEquals("AAAA", CodeConvertor.create("./ab.csv").aTob("aaaa"));
		} catch (IOException e) {
			fail("例外は発生しないはず", e);
		}
	}

	@Test
	@DisplayName("aTob: CSVの1番目の要素の前後に空白あり")
	void testATob02() {
		try {
			assertEquals("BBBB", CodeConvertor.create("./ab.csv").aTob("bbbb"));
		} catch (IOException e) {
			fail("例外は発生しないはず", e);
		}
	}

	@Test
	@DisplayName("aTob: CSVの2番目の要素の前後に空白あり")
	void testATob03() {
		try {
			assertEquals("CCCC", CodeConvertor.create("./ab.csv").aTob("cccc"));
		} catch (IOException e) {
			fail("例外は発生しないはず", e);
		}
	}

	@Test
	@DisplayName("aTob: CSVの2番目の要素なし")
	void testATob04() {
		try {
			assertEquals("", CodeConvertor.create("./ab.csv").aTob("dddd"));
		} catch (IOException e) {
			fail("例外は発生しないはず", e);
		}
	}

	@Test
	@DisplayName("aTob: 存在しないキー")
	void testATob05() {
		try {
			assertEquals(null, CodeConvertor.create("./ab.csv").aTob("XXX"));
		} catch (IOException e) {
			fail("例外は発生しないはず", e);
		}
	}

	@Test
	@DisplayName("bToa: aTobの逆")
	void testBToa01() {
		try {
			assertEquals("aaaa", CodeConvertor.create("./ab.csv").bToa("AAAA"));
		} catch (IOException e) {
			fail("例外は発生しないはず", e);
		}
	}

	@Test
	@DisplayName("bToa: CSV 1番目の要素なし")
	void testBToa02() {
		try {
			assertEquals("", CodeConvertor.create("./ab.csv").bToa("EEEE"));
		} catch (IOException e) {
			fail("例外は発生しないはず", e);
		}
	}

	@Test
	@DisplayName("create():指定したファイルが存在する場合")
	void testCreate1() {
		try {
			assertEquals(CodeConvertor.class, CodeConvertor.create("./ab.csv").getClass());
		} catch (IOException e) {
			fail("例外は発生しないはず", e);
		}
	}

	@Test
	@DisplayName("create():指定したファイルが存在しない")
	void testCreate2() {
		assertThrows(FileNotFoundException.class, () -> CodeConvertor.create("./notfund.csv"));
	}
}
