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
				// inputLineが更新されたら、displayTextとinputLineの値に応じてボタンの有効/無効を設定する。
				setButton();

			}

			@Override
			public void beforeTextChanged(CharSequence s, int start, int count,
					int after) {
				// 未使用。
			}

			@Override
			public void afterTextChanged(Editable s) {
				// 未使用。
			}
		});

		addButton.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				// 追加ボタンが押されたら、inputLineの値をTextオブジェクトに追加し、displayTextに表示する。
				// また、displayTextとinputLineの値に応じてボタンの有効/無効を設定する。
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
				// 消去ボタンが押されたら、TextオブジェクトとdisplayTextをクリアする。
				// また、displayTextとinputLineの値に応じてボタンの有効/無効を設定する。
/*				text.clear();
				displayText.setText(text.toString());
				setButton();
*/
			}
		});
	}

/* ややこしくなるので省略
	@Override
	protected void onPause() {
		super.onPause();
		// TextオブジェクトとinputLineの値をプレファレンスに保存する。
		SharedPreferences prefer = getPreferences(MODE_PRIVATE);
		SharedPreferences.Editor editor = prefer.edit();
		editor.putString("text", text.toString());
		editor.putString("line", inputLine.getText().toString());
		editor.commit();
	}

	@Override
	protected void onResume() {
		super.onResume();
		// プレファレンスからTextオブジェクトとinputLineの値を取得する。
		// また、displayTextとinputLineの値に応じてボタンの有効/無効を設定する。
		SharedPreferences prefer = getPreferences(MODE_PRIVATE);
		text = new Text(prefer.getString("text", ""));
		displayText.setText(text.toString());
		inputLine.setText(prefer.getString("line", ""));
		setButton();
	}
*/

	private void setButton() {
		// displayTextとinputLineTextの状態から追加ボタンと消去ボタンの有効/無効を設定する。
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