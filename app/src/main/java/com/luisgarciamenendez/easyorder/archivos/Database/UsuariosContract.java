package com.luisgarciamenendez.easyorder.archivos.Database;

import android.provider.BaseColumns;


public final class UsuariosContract {

    /*************************************************************************************/
    /** https://developer.android.com/training/data-storage/sqlite                      **/
    /*************************************************************************************/

    UsuariosContract() {}


    public static class usuariosdb implements BaseColumns {
        public static final String TABLE_NAME = "usuarios";
        public static String COLUMN_EMAIL = "email";
        public static final String COLUMN_PASSWORD = "password";
        public static final String COLUMN_TYPE = "tipo";


    }
}