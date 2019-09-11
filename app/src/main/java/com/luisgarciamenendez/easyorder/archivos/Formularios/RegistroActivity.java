package com.luisgarciamenendez.easyorder.archivos.Formularios;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


import com.luisgarciamenendez.easyorder.archivos.R;
import com.luisgarciamenendez.easyorder.archivos.Database.UsuarioDBHelper;
import com.luisgarciamenendez.easyorder.archivos.Database.UsuariosContract;

import java.util.regex.Pattern;


public class RegistroActivity extends AppCompatActivity {
    private static final String[] DUMMY_CREDENTIALS = new String[]{
         "foo@example.com:hello", "bar@example.com:world"
         };
         private UserLoginTask mAuthTask = null;
         private AutoCompleteTextView txtEmail;
         private EditText txtPassword;
         TextView txtConectarme;
         Button btnAñadir;
         UsuarioDBHelper mDbHelper;
         SQLiteDatabase db;
         private static final Pattern PASSWORD_PATTERN = Pattern.compile("^" + "(?=.*[0-9])" + "(?=.*[a-z])" + "(?=.*[A-Z])" + "(?=\\S+$)" + ".{8,}" + "$");


    @Override
         protected void onCreate(Bundle savedInstanceState) {
         super.onCreate(savedInstanceState);
         setContentView(R.layout.activity_register);


         /*************************************************************************************/
        /** https://developer.android.com/training/data-storage/sqlite                      **/
        /***********************************************************************************/
        mDbHelper = UsuarioDBHelper.newInstance(this, "usuarios.db", null, 1);


        btnAñadir = (Button) findViewById(R.id.btnRegistrarse);

        btnAñadir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtEmail = (AutoCompleteTextView) findViewById(R.id.email);
                txtPassword = (EditText) findViewById(R.id.password);
                db = mDbHelper.getWritableDatabase();
                mDbHelper.onCreate(db);

                if (db != null) {
                    attemptLogin();


                } else {
                    Toast toast = Toast.makeText(getApplicationContext(), "El usuario no ha podido registrarse. ", Toast.LENGTH_LONG);
                    toast.show();
                }
                db.close();
            }
        });


        txtConectarme = (TextView) findViewById(R.id.btnTengocuenta);

        txtConectarme.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

               Intent volver = new Intent(RegistroActivity.this, LoginActivity.class);
               startActivity(volver);


            }
        });
    }


    public class UserLoginTask extends AsyncTask<Void, Void, Boolean> {
        private final String mEmail;
        private final String mPassword;

        UserLoginTask(String email, String password) {
            this.mEmail = email;
            this.mPassword = password;
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
            txtPassword.setError(getString(R.string.error_field_required2));
            focusView = txtPassword;
            cancel = true;
        }

        // Check for a valid email address.
        if(!TextUtils.isEmpty(email)){
         ComprobarCorreoExistente();
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

            registrar();
        }
    }

    private boolean isEmailValid(String email) {
        //TODO: Replace this with your own logic
        return Patterns.EMAIL_ADDRESS.matcher(email).matches();
    }

    private boolean isPasswordValid(String password) {
        //TODO: Replace this with your own logic
        return PASSWORD_PATTERN.matcher(password).matches();
    }

    public void ComprobarCorreoExistente() {
        UsuarioDBHelper admin = new UsuarioDBHelper(this, "usuarios.db", null, 1);
        SQLiteDatabase db = admin.getWritableDatabase();

        String correo = txtEmail.getText().toString();

        Cursor fila = db.rawQuery("select email from usuarios where email ='" + correo + "'", null);

        if (fila.moveToFirst() == true) {
            String email = fila.getString(0);

            if (correo.equals(email)) {
                boolean cancel = false;
                View focusView = null;

                txtEmail.setError(getString(R.string.error_mail_repetido));
                focusView = txtEmail;
                cancel = true;
                Toast.makeText(getApplicationContext(), "No se ha registrado por que este correo ya existe.", Toast.LENGTH_SHORT).show();

            }
        }
    }
    public void registrar() {
        UsuarioDBHelper admin = new UsuarioDBHelper(this, "usuarios.db", null, 1);
        SQLiteDatabase db = admin.getWritableDatabase();

        String correo = txtEmail.getText().toString();

        Cursor fila = db.rawQuery("select email from usuarios where email ='" + correo + "'", null);

        if (fila.moveToFirst() == true) {
            String email = fila.getString(0);

            if (correo.equals(email)) {
                txtEmail.setError(getString(R.string.error_mail_repetido));
                Toast.makeText(getApplicationContext(), "No se ha registrado por que este correo ya existe.", Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(RegistroActivity.this, RegistroActivity.class);
                startActivity(intent);
            }
            }else {
            String em = txtEmail.getText().toString();
            String passw = txtPassword.getText().toString();
            String tipo = "Usuario";

            ContentValues values = new ContentValues();
            values.put(UsuariosContract.usuariosdb.COLUMN_EMAIL, em);
            values.put(UsuariosContract.usuariosdb.COLUMN_PASSWORD, passw);
            values.put(UsuariosContract.usuariosdb.COLUMN_TYPE, tipo);
            long newRowId = db.insert(UsuariosContract.usuariosdb.TABLE_NAME, null, values);
            Intent intent = new Intent(RegistroActivity.this, LoginActivity.class);
            startActivity(intent);

            Toast toast = Toast.makeText(getApplicationContext(), "El usuario se agrego correctamente. ", Toast.LENGTH_LONG);
            toast.show();
        }
        }


    }





