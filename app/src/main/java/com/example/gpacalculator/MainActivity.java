package com.example.gpacalculator;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.gpacalculator.R;

import java.time.chrono.Era;
public class MainActivity extends AppCompatActivity {
    private EditText Credit,Grade;
    private Button addCourse,seeGpa,erase;
    private TextView textView;
    double per=0,total_credit=0,obt=0,total=0,total_grade=0,per_subject;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Credit = findViewById(R.id.editText1);
        Grade = findViewById(R.id.editText2);
        addCourse = findViewById(R.id.button);
        seeGpa = findViewById(R.id.button2);
        erase = findViewById(R.id.button3);
        textView = findViewById(R.id.textView);
        addCourse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                obt = Double.parseDouble(Credit.getText().toString());
                total = Double.parseDouble(Grade.getText().toString());
                total_credit += obt;
                total_grade += total;
                per_subject = (obt/total)*100;
                per = (total_credit/total_grade)*100;
                Toast.makeText(getApplicationContext(),"Obtained Marks : "+obt + "\nTotal Marks : "
                        + total + "\nPercentage : "+ per_subject + "%",Toast.LENGTH_LONG).show();
                Credit.setText("");
                Grade.setText("");
            }
        });
        seeGpa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double result = per/9.5;
                float Result =(float)result;
                textView.setText("PERCENTAGE :"+per+"%"+"\n"+"GPA :"+Result);
                Toast.makeText(getApplicationContext(),"Obtained Marks : "+total_credit + "\nTotal Marks : "
                        + total_grade + "\nPercentage : "+ per + "%",Toast.LENGTH_LONG).show();
            }
        });
        erase.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                per=0;
                total_credit=0;
                total_grade=0;
                obt=0;
                total=0;
                Credit.setText("");
                Grade.setText("");
                textView.setText("");
            }
        });

    }
}