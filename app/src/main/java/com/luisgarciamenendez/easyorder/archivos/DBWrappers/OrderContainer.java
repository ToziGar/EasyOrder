package com.luisgarciamenendez.easyorder.archivos.DBWrappers;

import android.content.Context;
import android.database.Cursor;

import com.luisgarciamenendez.easyorder.archivos.DBManager.DBManager;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class OrderContainer {

    private List<Order> orderList;
    private Context context;
    private static OrderContainer instance;

    public static OrderContainer getInstance(Context context){
        if(instance == null){
            instance = new OrderContainer(context);
        }
        return instance;
    }

    public static void initInstanceWithStubs(Context context) {
        instance = new OrderContainer(context);
        String today = getOnlyDayFromDate(new Date());
        instance.initStubs(today);
        instance.fetchOrderItems(today);
    }

    private static String getOnlyDayFromDate(Date date){
        SimpleDateFormat df = new SimpleDateFormat("MM/dd/yyyy hh:mm a");
        String dateStr = df.format(date);
        String aux[] = dateStr.split(" ");
        String onlyDay = aux[0];
        return onlyDay;
    }

    public OrderContainer(Context context){
        orderList = new ArrayList<>();
        this.context = context;
        SimpleDateFormat df = new SimpleDateFormat("MM/dd/yyyy hh:mm a");
        Date date = new Date();
        String dateStr = df.format(date);
        String aux[] = dateStr.split(" ");
        String onlyDay = aux[0];
        fetchOrderItems(onlyDay);
    }

    private void fetchOrderItems(String date){
        Cursor cursor = DBManager.getInstance(context).getOrdersByDay(date);
        if (cursor.moveToFirst()) {
            do {
                Order order = initNewOrder(cursor);
                orderList.add(order);
            } while (cursor.moveToNext());
        }
    }

    private Order initNewOrder(Cursor cursor) {
        Order order = new Order();
        order.id = cursor.getInt(cursor.getColumnIndex(DBManager.ORDERS_COL_ID));
        order.setDate(cursor.getString(cursor.getColumnIndex(DBManager.ORDERS_COL_DATA)));
        order.price = cursor.getDouble(cursor.getColumnIndex(DBManager.ORDERS_COL_PRICE));
        order.tableNum = cursor.getInt(cursor.getColumnIndex(DBManager.ORDERS_COL_NUM_TABLE));
        return order;
    }

    private void initStubs(String date) {
    }

    public static void refresh(Context context){
        instance = new OrderContainer(context);
    }

    public List<Order> getOrderList() {
        return orderList;
    }

    public class Order {
        private int id;
        private String date;
        private String day;
        private String hour;
        public int tableNum;
        public double price;

        public Order(){}

        public void setDate(String date) {
            this.date = date;
            String[] aux = date.split(" ");
            day = aux[0];
            hour = aux[1] + " " + aux[2];
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getDay() {
            return day;
        }

        public String getHour() {
            return hour;
        }

    }
}
