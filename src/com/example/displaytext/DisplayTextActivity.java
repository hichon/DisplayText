package com.example.displaytext;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class DisplayTextActivity extends Activity {
	private EditText inputLine;
	private Button addButton;
	private Button clearButton;
	private TextView displayText;
	private Text text;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		inputLine = (EditText) findViewById(R.id.inputLine);
		addButton = (Button) findViewById(R.id.addButton);
		clearButton = (Button) findViewById(R.id.clearButton);
		displayText = (TextView) findViewById(R.id.displayText);

		text = new Text("");
		inputLine.setText("");
		displayText.setText("");
		setButton();
		
		inputLine.addTextChangedListener(new TextWatcher() {
			@Override
			public void onTextChanged(CharSequence s, int start, int before,
					int count) {
				// inputLine���X�V���ꂽ��AdisplayText��inputLine�̒l�ɉ����ă{�^���̗L��/������ݒ肷��B
				setButton();

			}

			@Override
			public void beforeTextChanged(CharSequence s, int start, int count,
					int after) {
				// ���g�p�B
			}

			@Override
			public void afterTextChanged(Editable s) {
				// ���g�p�B
			}
		});

		addButton.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				// �ǉ��{�^���������ꂽ��AinputLine�̒l��Text�I�u�W�F�N�g�ɒǉ����AdisplayText�ɕ\������B
				// �܂��AdisplayText��inputLine�̒l�ɉ����ă{�^���̗L��/������ݒ肷��B
/*
				if (text.getLineNum() < 10) {
					text.addLine(inputLine.getText().toString());
					displayText.setText(text.toString());
					inputLine.setText("");
					setButton();
				}
*/
			}
		});

		clearButton.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				// �����{�^���������ꂽ��AText�I�u�W�F�N�g��displayText���N���A����B
				// �܂��AdisplayText��inputLine�̒l�ɉ����ă{�^���̗L��/������ݒ肷��B
/*				text.clear();
				displayText.setText(text.toString());
				setButton();
*/
			}
		});
	}

/* ��₱�����Ȃ�̂ŏȗ�
	@Override
	protected void onPause() {
		super.onPause();
		// Text�I�u�W�F�N�g��inputLine�̒l���v���t�@�����X�ɕۑ�����B
		SharedPreferences prefer = getPreferences(MODE_PRIVATE);
		SharedPreferences.Editor editor = prefer.edit();
		editor.putString("text", text.toString());
		editor.putString("line", inputLine.getText().toString());
		editor.commit();
	}

	@Override
	protected void onResume() {
		super.onResume();
		// �v���t�@�����X����Text�I�u�W�F�N�g��inputLine�̒l���擾����B
		// �܂��AdisplayText��inputLine�̒l�ɉ����ă{�^���̗L��/������ݒ肷��B
		SharedPreferences prefer = getPreferences(MODE_PRIVATE);
		text = new Text(prefer.getString("text", ""));
		displayText.setText(text.toString());
		inputLine.setText(prefer.getString("line", ""));
		setButton();
	}
*/

	private void setButton() {
		// displayText��inputLineText�̏�Ԃ���ǉ��{�^���Ə����{�^���̗L��/������ݒ肷��B
		if (displayText.getText().length() > 0) {
			clearButton.setEnabled(true);
		} else {
			clearButton.setEnabled(false);
		}
		if (inputLine.getText().length() > 0) {
			if (text.getLineNum() < 10) {
				addButton.setEnabled(true);
			}
		} else {
			addButton.setEnabled(false);
		}
	}
}