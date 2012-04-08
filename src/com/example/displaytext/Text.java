package com.example.displaytext;

import java.util.ArrayList;
import java.util.Arrays;

public class Text {
	private ArrayList<String> lines;

	public Text(String text) {
		// ����������s�ŕ������ă��X�g�Ɋi�[����B
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
		// ���X�g�̕���������s�ŋ�؂��Č����������ʂ�Ԃ��B
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