package com.example;

import java.util.ArrayList;
import java.util.List;

public class Columns {
	public static String GPKEY = "GPKEY";
	public static Columns DEFAULT = new Columns(); 
	private List<String> columnList;

	public Columns() {
		setColumnList(createDefaultColumns(40));
	}
	
	public List<String> getColumnList() {
		return columnList;
	}

	void setColumnList(List<String> column) {
		this.columnList = column;
	}

	private List<String> createDefaultColumns(int size) {
		List<String> result = new ArrayList<>(size);
		result.add(Columns.GPKEY);
		for (int pos = 2; pos <= size; pos++) {
			result.add(String.format("V%02d", pos));
		}
		return result;
	}
}
