package com.example;

import java.util.ArrayList;
import java.util.List;

public class Columns {
	public static String GPKEY = "GPKEY";
	public static Columns DEFAULT = new Columns(); 
	public List<String> columns;

	public Columns() {
		setColumns(createDefaultColumns(40));
	}
	
	public List<String> getColumns() {
		return columns;
	}

	void setColumns(List<String> columns) {
		this.columns = columns;
	}

	private List<String> createDefaultColumns(int size) {
		List<String> result = new ArrayList<String>(size);
		result.add(Columns.GPKEY);
		for (int pos = 2; pos <= size; pos++) {
			result.add(String.format("V%02d", pos));
		}
		return result;
	}
}
