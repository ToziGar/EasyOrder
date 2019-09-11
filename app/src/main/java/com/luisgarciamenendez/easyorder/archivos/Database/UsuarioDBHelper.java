package com.luisgarciamenendez.easyorder.archivos.Database;



import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

import static com.luisgarciamenendez.easyorder.archivos.Database.UsuariosContract.usuariosdb.TABLE_NAME;

public class UsuarioDBHelper extends SQLiteOpenHelper {
    static SQLiteDatabase db;

    /*************************************************************************************/
    /** https://developer.android.com/training/data-storage/sqlite                      **/
    /*************************************************************************************/

    // If you change the database schema, you must increment the database version.
   // public static final int DATABASE_VERSION = 1;
    // public static final String DATABASE_NAME = "usuarios.db";

    private static UsuarioDBHelper mDatabaseInstance=null;
    private Context mContext;

    private static final String SQL_CREATE_ENTRIES =
            "CREATE TABLE IF NOT EXISTS " + TABLE_NAME + " ("+
                    UsuariosContract.usuariosdb.COLUMN_EMAIL + " TEXT," +
                    UsuariosContract.usuariosdb.COLUMN_PASSWORD + " TEXT," +
                    UsuariosContract.usuariosdb.COLUMN_TYPE + " TEXT)";

    private static final String SQL_DELETE_ENTRIES =
            "DROP TABLE IF EXISTS " + TABLE_NAME;

    public static UsuarioDBHelper newInstance(Context context,String DATABASE_NAME, SQLiteDatabase.CursorFactory factory, int DATABASE_VERSION){
        if(mDatabaseInstance==null){
            mDatabaseInstance=new UsuarioDBHelper(context.getApplicationContext(),DATABASE_NAME,null,DATABASE_VERSION);
        }
        return mDatabaseInstance;
    }

    public UsuarioDBHelper(Context context,String DATABASE_NAME, SQLiteDatabase.CursorFactory factory, int DATABASE_VERSION) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        mContext=context;
    }


    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_ENTRIES);
    }

    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // This database is only a cache for online data, so its upgrade policy is
        // to simply to discard the data and start over
        db.execSQL(SQL_DELETE_ENTRIES);
        onCreate(db);
    }
    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        onUpgrade(db, oldVersion, newVersion);
    }

    public ArrayList llenar_lv(){
        ArrayList<String> lista = new ArrayList<>();
        SQLiteDatabase database = this.getWritableDatabase();
        String q = "SELECT * FROM Usuarios";
        Cursor registros = database.rawQuery(q,null);
        if(registros.moveToFirst()){
            do{
                lista.add(registros.getString(0));
            }while(registros.moveToNext());
        }
        return lista;
    }
}



