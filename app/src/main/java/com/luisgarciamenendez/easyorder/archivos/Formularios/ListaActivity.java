package com.luisgarciamenendez.easyorder.archivos.Formularios;

import android.content.ContentValues;
import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

import com.luisgarciamenendez.easyorder.archivos.R;
import com.luisgarciamenendez.easyorder.archivos.Database.UsuarioDBHelper;
import static com.luisgarciamenendez.easyorder.archivos.Database.UsuariosContract.usuariosdb.COLUMN_EMAIL;
import static com.luisgarciamenendez.easyorder.archivos.Database.UsuariosContract.usuariosdb.COLUMN_TYPE;
import static com.luisgarciamenendez.easyorder.archivos.Database.UsuariosContract.usuariosdb.TABLE_NAME;

public class ListaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista);

        ListView lv;
        ArrayList<String> lista;
        ArrayAdapter adaptador;

        UsuarioDBHelper admin = new UsuarioDBHelper(this, "usuarios.db", null, 1);
        final SQLiteDatabase data = admin.getReadableDatabase();


        lv = (ListView) findViewById(R.id.lista);
        UsuarioDBHelper db = new UsuarioDBHelper(getApplicationContext(), "usuarios.db", null, 1);
        lista = db.llenar_lv();
        adaptador = new ArrayAdapter(this, android.R.layout.simple_list_item_1, lista);
        lv.setAdapter(adaptador);



        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position,
                                    long id) {
                ListView lv;
                lv = (ListView) findViewById(R.id.lista);
                String selectedFromList = (String) lv.getItemAtPosition(position);

                Cursor fila = data.rawQuery("select * from usuarios where email ='" + selectedFromList +"'", null);

                if (fila.moveToFirst() == true) {
                    String email = fila.getString(0);
                    String password = fila.getString(1);
                    String tipo = fila.getString(2);

                    SharedPreferences preferencias = getSharedPreferences("datos", Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor=preferencias.edit();
                    editor.putString("mail", selectedFromList);
                    editor.commit();
                }
                AlertDialogView();
            }
        });

    }

    private void AlertDialogView() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Elije tipo de usuario");
        String[] tipos = {"Usuario", "Camarero", "Administrador"};
        builder.setItems(tipos, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                switch (which) {
                    case 0:
                        GetTipoUsuario();
                        break;
                    case 1:
                        GetTipoCamarero();
                        break;

                    case 2:
                        GetTipoAdministrador();
                        break;
                }
            }
        });


        AlertDialog dialog = builder.create();
        dialog.show();
    }

    private void GetTipoUsuario(){
        SharedPreferences preferencias = getSharedPreferences("datos", Context.MODE_PRIVATE);
        String RecuperarEmail = preferencias.getString("mail", "");

        UsuarioDBHelper admin = new UsuarioDBHelper(this, "usuarios.db", null, 1);
        SQLiteDatabase data = admin.getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put(COLUMN_TYPE,"Usuario");

       data.update(TABLE_NAME, contentValues,COLUMN_EMAIL +" = '"+ RecuperarEmail + "'", null);
       Toast.makeText(getApplicationContext(), "Has convertido a este usuario en: Usuario ", Toast.LENGTH_LONG).show();
    }

    private void GetTipoCamarero() {
        SharedPreferences preferencias = getSharedPreferences("datos", Context.MODE_PRIVATE);
        String RecuperarEmail = preferencias.getString("mail", "");

        UsuarioDBHelper admin = new UsuarioDBHelper(this, "usuarios.db", null, 1);
        SQLiteDatabase data = admin.getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put(COLUMN_TYPE,"Camarero");

        data.update(TABLE_NAME, contentValues,COLUMN_EMAIL +" = '"+ RecuperarEmail + "'", null);
        Toast.makeText(getApplicationContext(), "Has convertido a este usuario en: Camarero ", Toast.LENGTH_LONG).show();
        }

    private void GetTipoAdministrador(){
        SharedPreferences preferencias = getSharedPreferences("datos", Context.MODE_PRIVATE);
        String RecuperarEmail = preferencias.getString("mail", "");

        UsuarioDBHelper admin = new UsuarioDBHelper(this, "usuarios.db", null, 1);
        SQLiteDatabase data = admin.getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put(COLUMN_TYPE,"Administrador");

        data.update(TABLE_NAME, contentValues,COLUMN_EMAIL +" = '"+ RecuperarEmail + "'", null);
        Toast.makeText(getApplicationContext(), "Has convertido a este usuario en: Administrador ", Toast.LENGTH_LONG).show();
    }

}




