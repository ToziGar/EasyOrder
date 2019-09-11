package com.luisgarciamenendez.easyorder.archivos.DBManager;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBManager extends SQLiteOpenHelper {

    private static DBManager instance;

    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "Datos";

    //PRODUCTOS
    public static final String DISHES_TABLE = "Products";
    public static final String DISHES_COL_NAME = "name";
    public static final String DISHES_COL_PRICE = "price";
    public static final String DISHES_COL_IMG = "img";
    public static final String DISHES_COL_STOCK = "stock";
    public static final String DISHES_COL_HAS_IMAGE = "hasimage";
    public static final String DISHES_COL_IMAGE_URI = "imageuri";
    public static final String DISHES_COL_ID = "id";

    public static final String DISHES_TABLE_CREATE = "CREATE TABLE " + DISHES_TABLE +
            "("+ DISHES_COL_ID +" INTEGER PRIMARY KEY AUTOINCREMENT, " +
            DISHES_COL_NAME + " TEXT, " +
            DISHES_COL_PRICE + " REAL, " +
            DISHES_COL_STOCK + " INTEGER, " +
            DISHES_COL_HAS_IMAGE + " INTEGER, " +
            DISHES_COL_IMAGE_URI + " TEXT, " +
            DISHES_COL_IMG + " INTEGER);";

    public static final String DISHES_TABLE_RESET = "DELETE FROM " + DISHES_TABLE;

    //ORDENES
    public static final String ORDERS_TABLE = "Orders";
    public static final String ORDERS_COL_ID = "id";
    public static final String ORDERS_COL_DATA = "date";
    public static final String ORDERS_COL_PRICE = "price";
    public static final String ORDERS_COL_NUM_TABLE = "numtable";

    public static final String ORDERS_TABLE_CREATE = "CREATE TABLE " + ORDERS_TABLE +
            "("+ ORDERS_COL_ID +" INTEGER PRIMARY KEY AUTOINCREMENT, " +
            ORDERS_COL_NUM_TABLE + " INTEGER, " +
            ORDERS_COL_DATA + " TEXT, " +
            ORDERS_COL_PRICE + " REAL);";

    public static final String ORDERS_TABLE_RESET = "DELETE FROM " + ORDERS_TABLE;


    //SELECTED
    public static final String SELECTED_TABLE = "Selected";
    public static final String SELECTED_COL_ID = "id";
    public static final String SELECTED_COL_NAME = "name";
    public static final String SELECTED_COL_NUMQUANTITY = "quantity";
    public static final String SELECTED_COL_ID_PRODUCTS = "id_products";
    public static final String SELECTED_COL_ID_ORDER = "id_order";

    public static final String SELECTED_TABLE_CREATE = "CREATE TABLE " + SELECTED_TABLE +
            "("+ SELECTED_COL_ID +" INTEGER PRIMARY KEY AUTOINCREMENT, " +
            SELECTED_COL_NAME + " TEXT, " +
            SELECTED_COL_NUMQUANTITY + " INTEGER, " +
            SELECTED_COL_ID_PRODUCTS + " INTEGER REFERENCES Products(id), " +
            SELECTED_COL_ID_ORDER + " INTEGER REFERENCES Orders(id));";

    public static final String SELECTED_TABLE_RESET = "DELETE FROM " + SELECTED_TABLE;


    public DBManager(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    public static synchronized DBManager getInstance(Context context){
        if (instance == null){
            instance = new DBManager(context);
        }
        return instance;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(DISHES_TABLE_CREATE);
        db.execSQL(ORDERS_TABLE_CREATE);
        db.execSQL(SELECTED_TABLE_CREATE);
    }

    public void insertDish(int img, double price, String name, int stock){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(DISHES_COL_NAME, name);
        contentValues.put(DISHES_COL_PRICE, price);
        contentValues.put(DISHES_COL_IMG, img);
        contentValues.put(DISHES_COL_STOCK, stock);
        contentValues.put(DISHES_COL_HAS_IMAGE, false);
        db.insert(DISHES_TABLE, null, contentValues);
    }

    public void insertDish(String imgUri, double price, String name, int stock){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(DISHES_COL_NAME, name);
        contentValues.put(DISHES_COL_PRICE, price);
        contentValues.put(DISHES_COL_IMAGE_URI, imgUri);
        contentValues.put(DISHES_COL_STOCK, stock);
        contentValues.put(DISHES_COL_HAS_IMAGE, true);
        db.insert(DISHES_TABLE, null, contentValues);
    }

    public void updateDish(String name, int stock){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(DISHES_COL_STOCK, stock);
        db.update(DISHES_TABLE, contentValues, DISHES_COL_NAME + "=?", new String[]{name});
    }

    public void updateDish(int id, int stock){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(DISHES_COL_STOCK, stock);
        db.update(DISHES_TABLE, contentValues, DISHES_COL_ID + "=?", new String[]{String.valueOf(id)});
    }

    public void updateDish(int id, int hasImage, String imgUri, double price, String name){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(DISHES_COL_PRICE, price);
        contentValues.put(DISHES_COL_NAME, name);
        contentValues.put(DISHES_COL_HAS_IMAGE, hasImage);
        contentValues.put(DISHES_COL_IMAGE_URI, imgUri);
        db.update(DISHES_TABLE, contentValues, DISHES_COL_ID + "=?", new String[]{String.valueOf(id)});
    }

    public void deleteDish(String name){
        SQLiteDatabase db = this.getWritableDatabase();
        String whereClause = DISHES_COL_NAME + "=?";
        String[] whereArgs = new String[] { name };
        db.delete(DISHES_TABLE, whereClause, whereArgs);
    }

    public Cursor getAllDishes(){
        SQLiteDatabase db = this.getReadableDatabase();
        String[] columns = {DISHES_COL_ID, DISHES_COL_NAME, DISHES_COL_PRICE, DISHES_COL_STOCK, DISHES_COL_IMG, DISHES_COL_HAS_IMAGE, DISHES_COL_IMAGE_URI};
        Cursor c = db.query(
                DISHES_TABLE,                            // The table to query
                columns,                                // The columns to return
                null,                                   // The columns for the WHERE clause
                null,                                   // The values for the WHERE clause
                null,                                   // don't group the rows
                null,                                   // don't filter by row groups
                DISHES_COL_NAME                                    // The sort order
        );
        return c;
    }

    public Cursor getOrdersByDay(String date){
        SQLiteDatabase db = this.getReadableDatabase();
        String[] columns = {ORDERS_COL_ID,ORDERS_COL_NUM_TABLE, ORDERS_COL_DATA, ORDERS_COL_PRICE};
        String compDateStart = date + " 00:00 AM";
        String compDateEnd = date + " 12:59 PM";
        String[] valuesWhere = {compDateStart, compDateEnd};
        Cursor c = db.query(
                ORDERS_TABLE,                         // The table to query
                columns,                                // The columns to return
                ORDERS_COL_DATA + " BETWEEN ? AND ?",               // The columns for the WHERE clause
                valuesWhere,                            // The values for the WHERE clause
                null,                                   // don't group the rows
                null,                                   // don't filter by row groups
                ORDERS_COL_DATA + " DESC"             // The sort order
        );
        return c;
    }

//    public Cursor getOrdersBetween(String startDay, String endDay){
//        SQLiteDatabase db = this.getReadableDatabase();
//        String[] columns = {ORDERS_COL_NUM_TABLE, ORDERS_COL_DATA, ORDERS_COL_PRICE};
//        String compStartDay = startDay + "00:00 AM";
//        String compEndDay = endDay + "11:59 PM";
//        String[] valuesWhere = {compStartDay, compEndDay};
//        Cursor c = db.query(
//                ORDERS_TABLE,                         // The table to query
//                columns,                                // The columns to return
//                ORDERS_COL_DATA + " BETWEEN ? AND ?",        // The columns for the WHERE clause
//                valuesWhere,                                   // The values for the WHERE clause
//                null,                                   // don't group the rows
//                null,                                   // don't filter by row groups
//                ORDERS_COL_DATA + " DESC"             // The sort order
//        );
//        return c;
//    }

    public Cursor getAllOrders(){
        SQLiteDatabase db = this.getReadableDatabase();
        String[] columns = {ORDERS_COL_ID,ORDERS_COL_NUM_TABLE, ORDERS_COL_DATA, ORDERS_COL_PRICE};
        Cursor c = db.query(
                ORDERS_TABLE,                         // The table to query
                columns,                                // The columns to return
                null,                                   // The columns for the WHERE clause
                null,                                   // The values for the WHERE clause
                null,                                   // don't group the rows
                null,                                   // don't filter by row groups
                ORDERS_COL_DATA + " DESC"             // The sort order
        );
        return c;
    }

    public void insertOrder(double price, String date, int numtable){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(ORDERS_COL_PRICE, price);
        contentValues.put(ORDERS_COL_DATA, date);
        contentValues.put(ORDERS_COL_NUM_TABLE, numtable);
        db.insert(ORDERS_TABLE, null, contentValues);
    }

    public void resetTableDishes(){
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL(DISHES_TABLE_RESET);
    }

    public void resetTableOrders(){
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL(ORDERS_TABLE_RESET);
    }

    public void resetTableSelected(){
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL(SELECTED_TABLE_RESET);
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + DISHES_TABLE);
        onCreate(db);
    }
}
