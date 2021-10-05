package com.example.exercise;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class StudentForm extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_form);

        Intent intent = getIntent();

        TextView nameView = findViewById(R.id.nameView);
        nameView.setText((String)intent.getExtras().get("name"));

        Button button = (Button) findViewById(R.id.submit);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(StudentForm.this, MainActivity.class);
                intent1.putExtra("response", nameView.getText().toString());
                setResult(RESULT_OK, intent1);
                finish();
            }
        });
    }
}