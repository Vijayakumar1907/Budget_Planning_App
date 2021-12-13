package com.example.paavai_budget_plan;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import org.w3c.dom.Text;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Login extends AppCompatActivity {


    TextInputLayout textInputLayout_pass;
    TextInputEditText textInputEditText_pass;

    TextInputLayout textInputLayout_email;
    TextInputEditText textInputEditText_email;



    Button Login_button;
    TextView NewUser;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        // hididg the action bar and flagging fullscreen
        getSupportActionBar().hide();
        // this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        Login_button = findViewById(R.id.Login_btn);
        NewUser = findViewById(R.id.NewPassword_Login);

        textInputLayout_email = findViewById(R.id.Email_Lt);
        textInputEditText_email = findViewById(R.id.Email_Et);

        textInputLayout_pass = findViewById(R.id.Pass_Lt);
        textInputEditText_pass = findViewById(R.id.Pass_Et);

        String email = textInputEditText_email.getText().toString();
        String pass = textInputEditText_pass.getText().toString();



        textInputLayout_pass.setHelperText("Enter password");
        textInputLayout_email.setHelperText("Username");



        textInputEditText_email.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                if (!email.isEmpty()){
                    textInputLayout_email.setHelperText(" ");
                    if (!pass.isEmpty()){
                        textInputLayout_pass.setHelperText(" ");
                    }
                }

                       /* if (email.isEmpty()){
                            textInputLayout_email.setHelperText("");
                            textInputLayout_email.setError("Please enter your email");
                        }else if (pass.isEmpty()){
                            textInputLayout_pass.setHelperText("Must contains minimum 5 characters");
                            textInputLayout_pass.setError("Please enter the password");
                        }else if (pass.length()>=6){
                            Pattern pattern = Pattern.compile("[@^a-zA-Z0-9]");
                            Matcher matcher = pattern.matcher(pass);

                            boolean isPassHasSpcChar = matcher.find();

                            if (isPassHasSpcChar){
                                textInputLayout_pass.setHelperText("Strong Password");
                            }else {
                                textInputLayout_pass.setHelperText("");
                                textInputLayout_pass.setError("Weak password");
                            }
                        }else {
                            textInputLayout_pass.setHelperText("");
                            textInputLayout_pass.setError("contains minimum 5 characters");
                        }*/


            }

            @Override
            public void afterTextChanged(Editable editable) {


            }
        });



        Login_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                if (!pass.isEmpty() && !email.isEmpty()){
                    Intent intent = new Intent(getApplicationContext(),Register.class);
                    startActivity(intent);
                    finish();
                }else if (pass.isEmpty() && email.isEmpty()){

                    textInputLayout_pass.setError("Please Enter your Password");
                    textInputLayout_email.setError("This field can,t be empty");
                }



            }
        });

        NewUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),Register.class);
                startActivity(intent);
                finish();
            }
        });




    }
}