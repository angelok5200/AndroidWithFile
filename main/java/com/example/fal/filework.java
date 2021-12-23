package com.example.fal;

import android.widget.TextView;
import android.widget.Toast;

import java.io.FileInputStream;
import java.io.IOException;

import com.example.fal.MainActivity;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.EditText;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import androidx.appcompat.app.AppCompatActivity;

public class filework extends MainActivity{

    private final static String FILE_NAME = "content.txt";

    public static void saveFile(TextView textView, EditText textBox){

        FileOutputStream fos = null;
        try {
            String text = textBox.getText().toString();
            fos = textView.getContext().openFileOutput(FILE_NAME, MODE_PRIVATE);
            fos.write(text.getBytes());
            Toast.makeText(textView.getContext(), "Файл сохранен", Toast.LENGTH_SHORT).show();
        }
        catch(IOException ex) {

            Toast.makeText(textView.getContext(), ex.getMessage(), Toast.LENGTH_SHORT).show();
        }
        finally{
            try{
                if(fos!=null)
                    fos.close();
            }
            catch(IOException ex){

                Toast.makeText(textView.getContext(), ex.getMessage(), Toast.LENGTH_SHORT).show();
            }
        }
    }

    public static void openFile(TextView textView, FileInputStream fin){

        try {
            byte[] bytes = new byte[fin.available()];
            fin.read(bytes);
            String text = new String (bytes);
            textView.setText(text);
        }
        catch(IOException ex) {
            Toast.makeText(textView.getContext(), ex.getMessage(), Toast.LENGTH_SHORT).show();
        }
        finally{

            try{
                if(fin!=null)
                    fin.close();
            }
            catch(IOException ex){

                Toast.makeText(textView.getContext(), ex.getMessage(), Toast.LENGTH_SHORT).show();
            }
        }
    }
}
