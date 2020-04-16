package com.geektech.recyclerview2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import static android.app.Activity.RESULT_OK;

public  class Main2Activity extends AppCompatActivity implements IonTextClick {
    public static String TEXT_KEY = "text_key";

    EditText nameEdit;
    SomeClass someClass;
    EditText streetEdit;
    EditText classEdit;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);



        nameEdit = findViewById(R.id.main_2_edit);
        streetEdit=findViewById(R.id.main_2_dataEdit);
        classEdit=findViewById(R.id.main_2_classEdit);



        Button back = findViewById(R.id.main_2_BACK);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                someClass.name = nameEdit.getText().toString();
                someClass.street=streetEdit.getText().toString();
                someClass.class1=classEdit.getText().toString();
                Log.d("ololo", someClass.name);
                intent.putExtra(MainActivity.RESULT_KEY, someClass);
                setResult(RESULT_OK, intent);
                finish();
            }
        });

        if (getIntent() != null) {
            someClass = (SomeClass) getIntent().getSerializableExtra(TEXT_KEY);
            nameEdit.setText(someClass.name);
            someClass = (SomeClass) getIntent().getSerializableExtra(TEXT_KEY);
            classEdit.setText(someClass.class1);
            someClass = (SomeClass) getIntent().getSerializableExtra(TEXT_KEY);
            streetEdit.setText(someClass.street);

        } else {
            TextView name = findViewById(R.id.main_2_text);
            name.setText("Nothing to show");
            TextView class1 = findViewById(R.id.main_2_class);
            name.setText("Nothing to show");
            TextView street1 = findViewById(R.id.main_2_street);
            name.setText("Nothing to show");
       }
    }

    public void Save(View view){
        someClass.name=nameEdit.getText().toString();
        someClass.class1 = classEdit.getText().toString();
        someClass.street = streetEdit.getText().toString();
        TextView name1 = (TextView) findViewById(R.id.main_2_text);
        name1.setText(someClass.name);
        TextView class1 = (TextView) findViewById(R.id.main_2_class);
        class1.setText(someClass.class1);
        TextView data1 = (TextView) findViewById(R.id.main_2_street);
        data1.setText(someClass.street);
    }

    @Override
    public void onTextClick(SomeClass someClass) {

    }
}
