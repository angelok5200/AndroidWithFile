package com.example.fal;
import com.example.fal.filework;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.EditText;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private final static String FILE_NAME = "content.txt";
    RadioGroup radioGroup;
    RadioButton radioButton;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void CancelButton (View v){

        Button buttonCancel = findViewById(R.id.button_cancel);
        buttonCancel.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                textView.setText("");
            }
        });
    }

    public void OkButton (View v){

        radioGroup = findViewById(R.id.radioGroup);
        textView = findViewById(R.id.InputText);

        Button buttonApply = findViewById(R.id.button_apply);

        buttonApply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int radioId = radioGroup.getCheckedRadioButtonId();

                radioButton = findViewById(radioId);
                textView.setTextColor(radioButton.getTextColors());
                EditText textBox = findViewById(R.id.InputText);
                filework.saveFile(textView, textBox);
            }
        });
    }

    public void checkButton(View v) {
        int radioId = radioGroup.getCheckedRadioButtonId();

        radioButton = findViewById(radioId);

        Toast.makeText(this, "Selected Radio Button: " + radioButton.getText(),
                Toast.LENGTH_SHORT).show();
    }

    public void open(View view) throws FileNotFoundException {

        FileInputStream fin = null;
        TextView textView = findViewById(R.id.text);
        fin = openFileInput(FILE_NAME);
        filework.openFile(textView, fin);
    }

}