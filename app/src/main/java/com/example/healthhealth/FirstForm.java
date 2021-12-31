package com.example.healthhealth;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import com.basgeekball.awesomevalidation.AwesomeValidation;
import com.basgeekball.awesomevalidation.ValidationStyle;
import com.basgeekball.awesomevalidation.utility.RegexTemplate;
import com.google.common.collect.Range;

public class FirstForm extends AppCompatActivity {
    EditText name,lastname,height,weigth;
    TextView age;
    Button btn_submit;
    AwesomeValidation awesomeValidation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //Remove title bar
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);

//Remove notification bar
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_form);

        name=findViewById(R.id.name);


        lastname=findViewById(R.id.lastname);
        height=findViewById(R.id.height);
        weigth=findViewById(R.id.weigth);
        // set a change listener on the SeekBar
        SeekBar seekBar = findViewById(R.id.seekBar);
        seekBar.setOnSeekBarChangeListener(seekBarChangeListener);
        int agenum = seekBar.getProgress();
        age = findViewById(R.id.age);
        age.setText(agenum+"");
        btn_submit=findViewById(R.id.btn_submit);

        awesomeValidation=new AwesomeValidation(ValidationStyle.BASIC);
        awesomeValidation.addValidation(this,R.id.name, RegexTemplate.NOT_EMPTY,R.string.nameinvalid);
        awesomeValidation.addValidation(this,
                R.id.lastname,
                RegexTemplate.NOT_EMPTY,
                R.string.lastnameinvalid);
        awesomeValidation.addValidation(this,R.id.height, Range.closed(100,250),R.string.validheight);
        awesomeValidation.addValidation(this,R.id.weigth, Range.closed(35,250),R.string.validweight);
        btn_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(awesomeValidation.validate()) {
                    Toast.makeText(getApplicationContext(), "Form Valid", Toast.LENGTH_SHORT).show();
                    openActivity2();
                }
                else {
                    Toast.makeText(getApplicationContext(), "Form Unvalid", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
    SeekBar.OnSeekBarChangeListener seekBarChangeListener = new SeekBar.OnSeekBarChangeListener() {

        @Override
        public void onProgressChanged(SeekBar seekBar, int agenum, boolean fromUser) {
            // updated continuously as the user slides the thumb
            age.setText(String.valueOf(agenum));

        }

        @Override
        public void onStartTrackingTouch(SeekBar seekBar) {
            // called when the user first touches the SeekBar
        }

        @Override
        public void onStopTrackingTouch(SeekBar seekBar) {
            // called after the user finishes moving the SeekBar
        }
    };


    public void openActivity2(){

        String userName =  name.getText().toString();
        String userLastname =lastname.getText().toString();

        Intent intent = new Intent(this,MainActivity.class);
        intent.putExtra("username",userName);
        intent.putExtra("lastname",userLastname);
        intent.putExtra("age",age.getText().toString());
        intent.putExtra("height",height.getText().toString());
        intent.putExtra("weight",weigth.getText().toString());
        startActivity(intent);
    }
}