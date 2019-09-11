package com.luisgarciamenendez.easyorder.archivos.Formularios;


import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.luisgarciamenendez.easyorder.archivos.Database.Usuario;
import com.luisgarciamenendez.easyorder.archivos.MainActivity;
import com.luisgarciamenendez.easyorder.archivos.R;
import com.luisgarciamenendez.easyorder.archivos.Database.UsuarioDBHelper;

public class LoginActivity extends AppCompatActivity {

    private static final String[] DUMMY_CREDENTIALS = new String[]{
            "foo@example.com:hello", "bar@example.com:world"
    };
    private UserLoginTask mAuthTask = null;
    private AutoCompleteTextView txtEmail;
    private EditText txtPassword;
    TextView txtRegistrarme;
    Button btnConectar;



    @Override
                    protected void onCreate(Bundle savedInstanceState) {
                        super.onCreate(savedInstanceState);
                        setContentView(R.layout.activity_login);

                        txtEmail = (AutoCompleteTextView) findViewById(R.id.email);
                        txtPassword = (EditText) findViewById(R.id.password);
                        btnConectar = (Button) findViewById(R.id.btnConectarme);

                        btnConectar.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {

                                if (txtEmail.getText().toString().equals("admin") && txtPassword.getText().toString().equals("admin")) {
                                    Toast.makeText(getApplicationContext(), "Te has conectado como: Administrador", Toast.LENGTH_SHORT).show();

                                    Intent intent = new Intent(LoginActivity.this, ListaActivity.class);
                                    startActivity(intent);

                } else {
                    attemptLogin();
                    }
            }
        });

        txtRegistrarme = (TextView) findViewById(R.id.btnSincuenta);

        txtRegistrarme.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(LoginActivity.this, RegistroActivity.class);
                startActivity(intent);


            }
        });
    }


    public class UserLoginTask extends AsyncTask<Void, Void, Boolean> {

        private final String mEmail;
        private final String mPassword;

        UserLoginTask(String email, String password) {
            mEmail = email;
            mPassword = password;
        }

        @Override
        protected Boolean doInBackground(Void... params) {
            // TODO: attempt authentication against a network service.

            try {
                // Simulate network access.
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                return false;
            }

            for (String credential : DUMMY_CREDENTIALS) {
                String[] pieces = credential.split(":");
                if (pieces[0].equals(mEmail)) {
                    // Account exists, return true if the password matches.
                    return pieces[1].equals(mPassword);
                }
            }

            // TODO: register the new account here.
            return true;
        }

        @Override
        protected void onPostExecute(final Boolean success) {
            mAuthTask = null;


            if (success) {
                finish();
            } else {
                txtPassword.setError(getString(R.string.error_incorrect_password));
                txtPassword.requestFocus();
            }
        }

        @Override
        protected void onCancelled() {
            mAuthTask = null;
        }
    }

    private void attemptLogin() {
        if (mAuthTask != null) {
            return;
        }

        // Reset errors.
        txtEmail.setError(null);
        txtPassword.setError(null);

        // Store values at the time of the activity_login attempt.
        String email = txtEmail.getText().toString();
        String password = txtPassword.getText().toString();

        boolean cancel = false;
        View focusView = null;

        // Check for a valid password, if the user entered one.
        if (TextUtils.isEmpty(password)) {
            txtPassword.setError(getString(R.string.error_field_required));
            focusView = txtPassword;
            cancel = true;
        }else if (!TextUtils.isEmpty(password) && !isPasswordValid(password)) {
            txtPassword.setError(getString(R.string.error_invalid_password));
            focusView = txtPassword;
            cancel = true;
        }
        // Check for a valid email address.
        if (TextUtils.isEmpty(email)) {
            txtEmail.setError(getString(R.string.error_field_required));
            focusView = txtEmail;
            cancel = true;
        } else if (!isEmailValid(email)) {
            txtEmail.setError(getString(R.string.error_invalid_email));
            focusView = txtEmail;
            cancel = true;
        }

        if (cancel) {
            // There was an error; don't attempt activity_login and focus the first
            // form field with an error.
            focusView.requestFocus();

        } else {
            mAuthTask = new UserLoginTask(email, password);
            mAuthTask.execute((Void) null);

            ingresar();
        }
    }

    private boolean isEmailValid(String email) {
        //TODO: Replace this with your own logic
        return email.contains("@");
    }

    private boolean isPasswordValid(String password) {
        //TODO: Replace this with your own logic
        return password.length() > 5;
    }

    public void ingresar() {
        UsuarioDBHelper admin = new UsuarioDBHelper(this, "usuarios.db", null, 1);
        SQLiteDatabase db = admin.getWritableDatabase();

        String correo = txtEmail.getText().toString();
        String clave = txtPassword.getText().toString();

        Cursor fila = db.rawQuery("select email,password from usuarios where email ='" + correo + "' and password ='" + clave + "'", null);

        if (fila.moveToFirst() == true) {
            String email = fila.getString(0);
            String pass = fila.getString(1);
            String tipo = Usuario.getTipo();

            if (correo.equals("administrador@gmail.com") && clave.equals(pass)) {
                Intent intent = new Intent(LoginActivity.this, ListaActivity.class);
                SharedPreferences preferencias = getSharedPreferences("datos",Context.MODE_PRIVATE);
                SharedPreferences.Editor editor=preferencias.edit();
                editor.putString("mail", correo);
                editor.putString("password", clave);
                editor.commit();
                Toast.makeText(getApplicationContext(), "Te has conectado como: " + correo , Toast.LENGTH_LONG).show();
                startActivity(intent);
            }else if (correo.equals(email) && clave.equals(pass)) {
                final CheckBox checkBox = (CheckBox) findViewById(R.id.checkBox);
                if (checkBox.isChecked()) {
                    Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                    SharedPreferences preferencias = getSharedPreferences("datos",Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor=preferencias.edit();
                    editor.putString("mail", correo);
                    editor.putString("password", clave);
                    editor.commit();
                    Toast.makeText(getApplicationContext(), "Te has conectado como: " + correo, Toast.LENGTH_LONG).show();
                    startActivity(intent);
                }else{
                    Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                    SharedPreferences preferencias = getSharedPreferences("datos",Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor=preferencias.edit();
                    editor.putString("mail", correo);
                    editor.putString("password", clave);
                    editor.commit();
                    Toast.makeText(getApplicationContext(), "Te has conectado como: " + correo , Toast.LENGTH_LONG).show();
                    startActivity(intent);
                }
            }
        }else {
                Toast.makeText(getApplicationContext(), "El correo o la contraseña son erroneos ", Toast.LENGTH_SHORT).show();
                txtEmail.setText("");
                txtPassword.setText("");
            }
        }
}



