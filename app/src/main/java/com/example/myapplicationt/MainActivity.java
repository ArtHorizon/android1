
package com.example.myapplicationt;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements  View.OnClickListener,SeekBar.OnSeekBarChangeListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = (Button) findViewById(R.id.Btn3);
        button.setOnClickListener(this);
        button = (Button) findViewById(R.id.Btn1);
        button.setOnClickListener(this);
        button = (Button) findViewById(R.id.Btn2);
        button.setOnClickListener(this);
        button = (Button) findViewById(R.id.CB);
        button.setOnClickListener(this);

        SeekBar bar = (SeekBar)findViewById(R.id.SB);
        bar.setOnSeekBarChangeListener(this);
        bar.setMax(1000);
    }
    public void onClick(View view) {
        String str = new String();
        switch (view.getId()){
            case R.id.Btn1:
                str = "\"예\"버튼을 눌렀습니다.";
                break;
            case R.id.Btn2:
                str = "\"아니오\"버튼을 눌렀습니다.";
                break;
            case R.id.Btn3:
                str = "\"전송\"버튼을 눌렀습니다.";

                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setTitle("전송 문자열");
                EditText editText = (EditText)findViewById(R.id.ET);
                String dialogStr = String.valueOf(editText.getText());
                builder.setMessage(dialogStr);
                builder.setIcon(R.mipmap.ic_launcher);
                builder.setPositiveButton("OK", null);
                builder.setNegativeButton("Cancel", null);

                AlertDialog alert = builder.create();
                alert.show();
                break;

            case R.id.CB:
                CheckBox checkBox = (CheckBox)findViewById(R.id.CB);
                if(checkBox.isChecked()) checkBox.setText("항상켜기");
                else checkBox.setText("항상 켜지 않기");

                str = "체크박스를 눌렀습니다.";
                break;
        }
        Toast.makeText(getApplicationContext(), str, Toast.LENGTH_LONG).show();
    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
        Toast.makeText(getApplicationContext(), "밝기가 변경되었습니다.", Toast.LENGTH_LONG).show();

        String str = String.valueOf(progress);
        EditText textField = (EditText)findViewById(R.id.ET);
        textField.setText(str);
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {
    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {
    }
}
