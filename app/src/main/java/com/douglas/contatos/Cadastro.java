package com.douglas.contatos;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Cadastro extends AppCompatActivity {

    private EditText nome;
    private EditText contaemail;
    private EditText senha;
    private EditText confsenha;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);

        nome = (EditText) findViewById(R.id.campoNome);
        contaemail = (EditText) findViewById(R.id.campoEmailCadastro);
        senha = (EditText) findViewById(R.id.campoSenhaCadastro);
        confsenha = (EditText) findViewById(R.id.campoConfirmSenha);

        findViewById(R.id.btnCadastrar).setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {

                Intent it = new Intent();

                String name = nome.getText().toString();
                String email = contaemail.getText().toString();
                String pass = senha.getText().toString();
                String confpass = confsenha.getText().toString();

                if (!validarNome(name)) {
                    nome.setError("Nome inválido!");
                }
                if (!validarEmail(email)) {
                    contaemail.setError("Email inválido!");
                }
                if (!validarSenha(pass)) {
                    senha.setError("Senha inválida!");
                }
                if (!validarConfSenha(confpass, pass)) {
                    confsenha.setError("Senha incorreta!");
                }

                it.putExtra("email", email);

                if(validarNome(name) && validarEmail(email) && validarSenha(pass) && validarConfSenha(confpass, pass)) {
                    setResult(RESULT_OK, it);
                    finish();
                }
            }
        });

    }

    private boolean validarNome(String name) {
        if (name != null && name.length() > 3) {
            return true;
        }
        return false;
    }

    private boolean validarEmail(String email) {
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

    private boolean validarConfSenha(String confpass, String pass) {
        if (confpass.equals(pass)) {
            return true;
        }
        return false;
    }

    public void startLogin(View view){
        finish();
    }

}
