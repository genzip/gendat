package com.example.file;

import java.io.FileReader;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;

/**
 * コード変換クラス
 */
public class CodeConvertor {
	private Map<String, String> abMap;
	private Map<String, String> baMap;

	/**
	 * 指定したCSVファイルからCodeConvertorを生成します。
	 * 
	 * CSVファイルの先頭はヘッダー行(A,B)である必要があります。
	 * 
	 * @param filename 変換元と変換先のCSVファイル
	 * @return CodeConvertorインスタンス
	 * @throws IOException 指定したファイルが存在しない、または読めない場合
	 */
	public static CodeConvertor create(String filename) throws IOException {
		CSVFormat.Builder builder = CSVFormat.Builder.create(CSVFormat.DEFAULT).setTrim(true).setHeader("A", "B");
		Map<String, String> abMap = new TreeMap<>();
		Map<String, String> baMap = new TreeMap<>();
		try(
			FileReader reader = new FileReader(filename);
			CSVParser parser = new CSVParser(reader, builder.build());
		) {
			parser.forEach(r ->  { //r:CSVRecord
				abMap.put(r.get("A"), r.get("B"));
				baMap.put(r.get("B"), r.get("A"));
			});
		}

		return new CodeConvertor(abMap, baMap);
	}

	CodeConvertor(Map<String, String> ab, Map<String, String> ba) {
		this.abMap = ab;
		this.baMap = ba;
	}

	/**
	 * aに対応するbを返す
	 * @param a
	 * @return
	 */
	public String aTob(String a) {
		return abMap.get(a);
	}

	/**
	 * bに対応するaを返す
	 * @param b
	 * @return
	 */
	public String bToa(String b) {
		return baMap.get(b);
	}
}