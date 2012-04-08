package com.example.displaytext;

import java.util.ArrayList;
import java.util.Arrays;

public class Text {
	private ArrayList<String> lines;

	public Text(String text) {
		// 文字列を改行で分割してリストに格納する。
		lines = new ArrayList<String>(Arrays.asList(text.split("\n")));
	}

	public void addLine(String line) {
		lines.add(line);
	}

	public int getLineNum() {
		return lines.size();
	}

	public void clear() {
		lines.clear();
	}

	@Override
	public String toString() {
		// リストの文字列を改行で区切って結合した結果を返す。
		String text = "";
		for (String line : lines) {
			if (text.isEmpty()) {
				text = line;
			} else {
				text += "\n" + line;
			}
		}
		return text;
	}
}