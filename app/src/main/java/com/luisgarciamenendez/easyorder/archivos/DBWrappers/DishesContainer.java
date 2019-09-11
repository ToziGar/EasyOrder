package com.luisgarciamenendez.easyorder.archivos.DBWrappers;

import android.content.Context;
import android.database.Cursor;

import com.luisgarciamenendez.easyorder.archivos.R;
import com.luisgarciamenendez.easyorder.archivos.DBManager.DBManager;

import java.util.ArrayList;
import java.util.List;


public class DishesContainer {

    private static DishesContainer instance;

    private final List<Dish> dishList;
    private Context context;

    public static DishesContainer getInstance(Context context){
        if(instance == null){
            instance = new DishesContainer(context);
        }
        return instance;
    }

    public static void initInstanceWithStubs(Context context) {
        instance = new DishesContainer(context);
        instance.initStubs();
        instance.fetchDishItems();
    }

    private DishesContainer(Context context){
        dishList = new ArrayList<>();
        this.context = context;
        fetchDishItems();
    }

    private void fetchDishItems(){
        Cursor cursor = DBManager.getInstance(context).getAllDishes();
        if (cursor.moveToFirst()) {
            do {
                Dish dish = initProduct(cursor);
                dishList.add(dish);
            } while (cursor.moveToNext());
        }
    }

    private Dish initProduct (Cursor cursor) {
        Dish dish = new Dish();
        dish.id = (cursor.getInt(cursor.getColumnIndex(DBManager.DISHES_COL_ID)));
        dish.name = (cursor.getString(cursor.getColumnIndex(DBManager.DISHES_COL_NAME)));
        dish.price = (cursor.getDouble(cursor.getColumnIndex(DBManager.DISHES_COL_PRICE)));
        dish.stock = (cursor.getInt(cursor.getColumnIndex(DBManager.DISHES_COL_STOCK)));
        dish.mipmapId = (cursor.getInt(cursor.getColumnIndex(DBManager.DISHES_COL_IMG)));
        int hasImage = cursor.getInt(cursor.getColumnIndex(DBManager.DISHES_COL_HAS_IMAGE));
        if (hasImage != 0){
            dish.hasImage = true;
            dish.imgUri = cursor.getString(cursor.getColumnIndex(DBManager.DISHES_COL_IMAGE_URI));
        } else {
            dish.hasImage = false;
            dish.imgUri = null;
        }
        return dish;
    }

    public void initStubs() {
        DBManager.getInstance(context).insertDish(R.mipmap.hamburguesa, 5.50, "Hamburguesa", 100);
        DBManager.getInstance(context).insertDish(R.mipmap.fabada, 9, "Fabada", 50);
        DBManager.getInstance(context).insertDish(R.mipmap.poteasturiano, 11.95, "Pote asturiano", 20);
        DBManager.getInstance(context).insertDish(R.mipmap.calamares, 8.00, "Calamares", 32);
        DBManager.getInstance(context).insertDish(R.mipmap.pizzadecuatroquesos, 9.50, "Pizza de cuatro quesos", 34);
        DBManager.getInstance(context).insertDish(R.mipmap.postres, 4.50, "Mousse de chocolate", 40);
        DBManager.getInstance(context).insertDish(R.mipmap.pizza, 11.30, "Pizza vegetariana", 30);
        DBManager.getInstance(context).insertDish(R.mipmap.frixuelos, 5.50, "Frisuelos", 34);
        DBManager.getInstance(context).insertDish(R.mipmap.cachopo, 12.50, "Cachopo", 14);
        DBManager.getInstance(context).insertDish(R.mipmap.batidodekiwi, 4.50, "Batido de kiwi", 53);
        DBManager.getInstance(context).insertDish(R.mipmap.batidodemango, 4.20, "Batido de mango", 23);
        DBManager.getInstance(context).insertDish(R.mipmap.ensaladadepollo, 8.50, "Ensalada de pollo", 32);
        DBManager.getInstance(context).insertDish(R.mipmap.ensaladamarinera, 10.20, "Ensalada marinera", 64);
        DBManager.getInstance(context).insertDish(R.mipmap.tortilla, 9.30, "Tortilla de patata", 64);
        DBManager.getInstance(context).insertDish(R.mipmap.tortillarellena, 10.40, "Tortilla de patata rellena", 64);
    }

    public static void refresh(Context context){
        instance = new DishesContainer(context);
    }

    public List<Dish> getDishList(){
        return dishList;
    }


    public class Dish {
        public int id;
        public int mipmapId;
        public double price;
        public String name;
        public int stock;
        public boolean hasImage;
        public String imgUri;

        public Dish(){}
    }
}
