package com.betoe.minhasvacinas.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.betoe.minhasvacinas.ForgotPasswordActivity;
import com.betoe.minhasvacinas.R;
import com.betoe.minhasvacinas.RegisterActivity;
import com.betoe.minhasvacinas.model.User;
import com.betoe.minhasvacinas.rest.APIClient;
import com.betoe.minhasvacinas.rest.UserEndPoint;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {

    private TextView inputEmail;
    private TextView inputPassword;
    private TextView forgotPassword;
    private Button login;
    private Button register;
    private Intent i;

    public String email;
    public String password;

    public String serviceName;
    public String serviceEmail;
    public String servicePassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        inputEmail = (TextView) findViewById(R.id.loginEmailId);
        inputPassword = (TextView) findViewById(R.id.loginPasswordId);
        forgotPassword = (TextView) findViewById(R.id.loginForgotPasswordId);
        login = (Button) findViewById(R.id.loginSignInButtonId);
        register = (Button) findViewById(R.id.loginSignUpButton);

    }

    public void signIn(View view) {
        email = inputEmail.getText().toString();
        password = inputPassword.getText().toString();

        attemptLogin();
        loadData();

    }

    public void signUp(View view) {
        i = new Intent(LoginActivity.this, RegisterActivity.class);
        startActivity(i);

    }

    public void forgotPassword(View view) {
        i = new Intent(LoginActivity.this, ForgotPasswordActivity.class);
        startActivity(i);
    }

    private void attemptLogin() {

        if (TextUtils.isEmpty(email)) {
            inputEmail.setError("Preencher esse campo");
        } else {
            inputEmail.setError(null);
            inputEmail.clearFocus();
        }

        if (TextUtils.isEmpty(password)) {
            inputPassword.setError("Preencher esse campo");
        } else {
            inputPassword.setError(null);
            inputPassword.clearFocus();
        }
    }

    private void loadData() {
        String user1 = "RobertoEv";

        final UserEndPoint apiService = APIClient.getClient().create(UserEndPoint.class);
        Call<User> call = apiService.getUser(user1);
        call.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                serviceName = response.body().getName().toString();
                serviceEmail = response.body().getEmail().toString();
                servicePassword = response.body().getPassword().toString();

                if (email.equals(serviceEmail) && password.equals(servicePassword)){
                    i = new Intent(LoginActivity.this, MainActivity.class);
                    i.putExtra("email", serviceEmail);
                    i.putExtra("name", serviceName);
                    startActivity(i);
                } else {
                    Toast.makeText(LoginActivity.this, "Login ou Senha Invalidos", Toast.LENGTH_SHORT).show();

                }
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {

            }
        });
    }

}

//class LoginActivity : AppCompatActivity() {
//
//        override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_login)
//
//        loginForgotPasswordId.setOnClickListener {
//        startActivity(Intent(this, ForgotPasswordActivity::class.java))
//        }
//
//        loginSignInButtonId.setOnClickListener {
//        var validator = verifyBlankSpaces()
//        if (validator) {
//        startActivity(Intent(this, MainActivity::class.java))
//        }
//        }
//
//        loginSignUpButton.setOnClickListener {
//        startActivity(Intent(this, RegisterActivity::class.java))
//        }
//        }
//
//        fun verifyBlankSpaces(): Boolean {
//        var errorMessage: String = "Por favor, preencher: "
//        val email = loginEmailId?.text.toString().trim()
//        val password = loginPasswordId?.text.toString().trim()
//        var validator = true
//
//        if (email.isNullOrBlank()){
//        errorMessage = errorMessage + "\nEmail"
//        validator = false
//        }
//
//        if (password.isNullOrBlank()){
//        errorMessage = errorMessage + "\nSenha"
//        validator = false
//        }
//
//        if (validator == false) {
//        Toast.makeText(this, errorMessage, Toast.LENGTH_LONG).show()
//        }
//        return validator
//        }
//        }
