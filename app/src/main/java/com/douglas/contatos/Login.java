package com.douglas.contatos;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Login extends AppCompatActivity {

    private EditText login;
    private EditText senha;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        login = (EditText) findViewById(R.id.campoLogin);
        senha = (EditText) findViewById(R.id.campoSenha);

        findViewById(R.id.btnEntrar).setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {

                final String email = login.getText().toString();
                final String pass = senha.getText().toString();

                if (!validarLogin(email)) {
                    login.setError("Login inválido!");
                }
                if (!validarSenha(pass)) {
                    senha.setError("Senha inválida!");
                }
                if (validarLogin(email) && validarSenha(pass)){
                    startPrincipal();
                }

            }

        });

    }

    private boolean validarLogin(String email) {
        String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

        Pattern pattern = Pattern.compile(EMAIL_PATTERN);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

    private boolean validarSenha(String pass) {
        if (pass != null && pass.length() > 6) {
            return true;
        }
        return false;
    }

    public void startCadastro(View view) {
        Intent cadastro = new Intent(this, Cadastro.class);
        startActivityForResult(cadastro, 9999);
    }

    private void startPrincipal() {
        Intent principal = new Intent(this, Principal.class);
        startActivity(principal);
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == RESULT_OK) {
            String email = data.getExtras().getString("email");
            EditText txtEmailLogin = (EditText) findViewById(R.id.campoLogin);
            txtEmailLogin.setText(email);
        }
    }

}
