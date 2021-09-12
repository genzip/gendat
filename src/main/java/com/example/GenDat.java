package com.example;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/**
 * テストデータ生成をするクラス
 * 
 * new GenData().create(10, "/path/to/data.csv")
 */
public class GenDat {
	private List<String> r1header;
	private List<String> r2header;
	private List<String> r3header;
	private List<String> baseHeader;

	public GenDat() {
		setBaseHeader(Columns.DEFAULT.getColumns());
		setR1header(createHeader(1, 13));
		setR2header(createHeader(14, 26));
		setR3header(createHeader(27, 39));
	}

	/**
	 * countsで指定した件数のデータを作成し filenameファイルに出力する
	 * 
	 * 1件につき同じGPKEYを持つレコードを3行出力する。
	 * 
	 * @param counts
	 * @param filename
	 * @throws IOException
	 */
	public void create(int counts, String filename) throws IOException {
		Set<RecordBuilder> dat = new HashSet<RecordBuilder>();
		for (int i = 1; i <= counts; i++) {
			dat.add(new RecordBuilder().setGpkey(i).setRecordHeader(getR1header()));
			dat.add(new RecordBuilder().setGpkey(i).setRecordHeader(getR2header()));
			dat.add(new RecordBuilder().setGpkey(i).setRecordHeader(getR3header()));
		}
		FileWriter writer = new FileWriter(new File(filename));
		BufferedWriter bw = new BufferedWriter(writer);
		Iterator<RecordBuilder> ite = dat.iterator();

		// In no particular order
		while (ite.hasNext()) {
			bw.write(ite.next().build());
			bw.newLine();
		}
		bw.close();
	}

	/**
	 * RecordBuilder用のヘッダ情報を生成する
	 * 
	 * 値を作成するカラムをstartPosからendPosで指定する
	 * 
	 * 先頭(カラム位置=1)はGPKEYに固定
	 * 
	 * @param startPos 開始カラム位置(2から40)
	 * @param endPos   開始カラム位置(2から40)
	 * @return RecordBuilder用のヘッダ情報
	 */
	List<String> createHeader(int startPos, int endPos) {
		List<String> result = new ArrayList<String>(40);

		result.add(getBaseHeader().get(0)); // GPKEY
		for (int pos = 2; pos <= 40; pos++) {
			if (pos >= startPos && pos <= endPos) {
				result.add(getBaseHeader().get(pos - 1));
			} else {
				result.add(null);
			}
		}
		return result;
	}

	List<String> getR1header() {
		return r1header;
	}

	void setR1header(List<String> r1header) {
		this.r1header = r1header;
	}

	List<String> getR2header() {
		return r2header;
	}

	void setR2header(List<String> r2header) {
		this.r2header = r2header;
	}

	List<String> getR3header() {
		return r3header;
	}

	void setR3header(List<String> r3header) {
		this.r3header = r3header;
	}

	List<String> getBaseHeader() {
		return baseHeader;
	}

	void setBaseHeader(List<String> baseHeader) {
		this.baseHeader = baseHeader;
	}
}
