package com.example.exercise;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button form = (Button) findViewById(R.id.form);
        form.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText name = (EditText) findViewById(R.id.nameInput);
                Intent intent = new Intent(MainActivity.this, StudentForm.class);
                intent.putExtra("name", name.getText().toString());

                startActivityForResult(intent, 1);
            }
        });

        Button services = (Button) findViewById(R.id.services);
        services.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, StudentService.class);
                startActivityForResult(intent, 2);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent intent){
        super.onActivityResult(requestCode, resultCode, intent);
        if (requestCode == 1 && resultCode == RESULT_OK){
            String successMessage = (String) intent.getExtras().get("response");
            Toast.makeText(MainActivity.this, "Thank for your submission, "+successMessage, Toast.LENGTH_SHORT).show();
        }
        if (requestCode == 2 && resultCode == RESULT_OK){
            String successMessage = (String) intent.getExtras().get("response");
            Toast.makeText(MainActivity.this, "Thank for using " + successMessage + " service", Toast.LENGTH_SHORT).show();
        }
    }
}