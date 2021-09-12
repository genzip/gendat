package com.example;

import java.util.Iterator;
import java.util.List;
import java.util.Random;

/**
 * 1行分のデータを作成するBulder
 */
public class RecordBuilder {
	private List<String> recordHeader;
	private int gpkey;
	private String separate;
	private Random rand;
	
	public RecordBuilder() {
		setSeparate(",");
		setRand(new Random());
	}

	public String build() {
		StringBuffer buf = new StringBuffer();

		Iterator<String> ite = getRecordHeader().iterator();
		String sep = getSeparate();
		for(int i = 0; ite.hasNext(); i++) {
			String str = ite.next();
			if (null == str) {
				// nop
			} else if (str.equals(Columns.GPKEY)) {
				buf.append(createGPVal());
			} else {
				buf.append(createVal(i));
			}
			if (ite.hasNext()) {
				buf.append(sep);
			}
		}
		return buf.toString();
	}
	
	public void setSeparate(String separate) {
		this.separate = separate;
	}

	public RecordBuilder setRecordHeader(List<String> recordHeader) {
		this.recordHeader = recordHeader;
		return this;
	}

	public RecordBuilder setGpkey(int gpkey) {
		this.gpkey = gpkey;
		return this;
	}

	String createVal(int i) {
		int a = getRand().nextInt(99999999);
		int b = getRand().nextInt(99999999);
		return String.format("%3s:%08d%08d", getRecordHeader().get(i), a, b);
	}

	String createGPVal() {
		return String.format("GPKEY:%014d", getGpkey());
	}
	
	List<String> getRecordHeader() {
		return recordHeader;
	}

	int getGpkey() {
		return gpkey;
	}

	String getSeparate() {
		return separate;
	}

	private Random getRand() {
		return rand;
	}

	private void setRand(Random rand) {
		this.rand = rand;
	}

}
