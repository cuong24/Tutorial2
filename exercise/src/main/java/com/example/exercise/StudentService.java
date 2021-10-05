package com.example.exercise;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class StudentService extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_service);

        ArrayList<View> allButtons =  findViewById(R.id.services).getTouchables();
        for (View button: allButtons) {
            if (button instanceof Button){
                button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(StudentService.this, MainActivity.class);
                        intent.putExtra("response", ((Button) button).getText().toString());

                        setResult(RESULT_OK, intent);
                        finish();
                    }
                });
            }
        }
    }
}