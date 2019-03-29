package com.example.testing0211;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;


public class MainActivity extends AppCompatActivity {

    private SQLiteDatabase db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //创建数据库
        createDatabase();
        //创建数据表
        createTable();
        //增加数据
        insertData();
        //删除数据
        //deleteData();
        //修改数据
        //updateData();
        //查询数据、获取数据、读取数据
        queryData();
    }


//  SQL语法查询、获取、读取
//    private void queryData(){
//        String sql = "SELECT * FROM testing00 WHERE id_number=6181905057";      // * 表示字段列表部分是所有字段
//        //String aql = "SELECT id_number FROM testing
//        db.execSQL(sql);
//    }


//    SQLite语法查询
    private  boolean queryData() {
        //查询数据
        String table = "testing00";
        //String[] columns = {"user_name", "id_number", "age", "phone", "email"};//查询的字段列表
        String[] columns = { "id_number"};
        String selection = null;//查询的where字句
        String[] selectionArgs = null;
        String groupBy = null;
        String having = null;
        String orderBy = null;
        //处理数据
        Cursor c = db.query(table, columns, selection, selectionArgs, groupBy, having, orderBy);

//        查询下一条数据
//        Cursor c = db.query(table,columns,selection,selectionArgs,groupBy,having,groupBy);
//        c.moveToFirst();
//        c.moveToNext();
//        String name = c.getString(0);

//        if (c.moveToFirst()) {
//            String user_name = c.getString(0);
//            String id_number = c.getString(1);
//            int age = c.getInt(2);
//            String phone = c.getString(3);
//            String email = c.getString(4);
//            Log.d("SQL", "user_name:" + user_name + " id_number:" + id_number + " age:" + age + " phone:" + phone + " email:" + email);
//            c.close();
//        }

//        if (c.moveToFirst()) {
//            String id_number = c.getString(0);
//            Log.d("SQL",  " id_number:" + id_number);
//            c.close();
//        }

        // 遍历cursor
//        if (c.moveToFirst()) {
//            while(!c.isAfterLast()){
//                String id_number = c.getString(0);
//                Log.d("SQL",  " id_number:" + id_number);
//                c.moveToNext();
//            }
//            c.close();
//        }

        // 查询单个数据
//        if (c.moveToFirst()) {
//            while(!c.isAfterLast()){
//                if (c.getString(0).equals("E0E01E000A6263A6A501")){
//                    Log.d("SQL",  " id_number:" + c.getString(0));
//                    break;
//                }else{
//                    c.moveToNext();
//                }
//            }
//            c.close();
//        }

        boolean a=false;
        if (c.moveToFirst()) {
            while(!c.isAfterLast()){
                if (c.getString(0).equals("E0E01E000A6263A6A501")){
                    a=true;
                    break;
                }else{
                    c.moveToNext();
                }
            }
            c.close();
        }
        if(a)
            return true;
        else
            return false;
    }


    //  SQL语法修改
    private void updateData() {
        String sql = "UPDATE testing SET age = 22 WHERE user_name = 'Lily'";
        db.execSQL(sql);
    }


//  SQL语法删除
    private void deleteData() {
        String sql = "DELETE FROM testing WHERE user_name = 'Lily'";
        //String sql = "DELETE FROM testing WHERE age > 27";
        //String sql = "DELETE FROM testing";                     //删除所有数据
        db.execSQL(sql);
        Log.d("SQL","删除成功");
    }

//    SQLite语法删除
//    private void deleteData(){
//        String user_name = "Lily";
//        int age = 50;
//        String table = "testing";
//        String whereClause = "age>? OR user_name=?";
//        String[] whereArgs = {age+"",user_name};
//        int affectedRows = db.delete(table,whereClause,whereArgs);
//        Log.d("SQL","受影响的行数"+affectedRows);
//    }


    //  SQL语法增加
//    private void insertData() {
//        String sql = "INSERT INTO testing "+
//                "(user_name,age,phone,email) "+
//                "values "+
//                "('江',40,'13333333333','123@qq.com')";
//        db.execSQL(sql);
//    }


//    SQLite语法增加
     private void insertData(){
        String table = "testing00";
        String nullColumnHack = null;
        ContentValues values = new ContentValues();
        values.put("user_name","小猪佩奇");
        values.put("id_number","6181905050");
        values.put("age",1);
        values.put("phone","18051173908");
        values.put("email","peppa@pig.com");
        long id= db.insert(table,nullColumnHack,values);
        Log.d("SQLITE","新增加的数据id："+id);

        //如果想要增加多条数据，应该new ContentValues(),或者调用values.clear()方法清空数据，再put值
        values = new ContentValues();
        values.put("user_name","大白");
        values.put("id_number","6181905051");
        values.put("age",2);
        values.put("phone","18168532518");
        values.put("email","dabai@pig.com");
        db.insert(table,nullColumnHack,values);

         values = new ContentValues();
         values.put("user_name","赵小康");
         values.put("id_number","6181905057");
         values.put("age",24);
         values.put("phone","18861512095");
         values.put("email","zhaoxk0211@163.com");
         db.insert(table,nullColumnHack,values);

         values = new ContentValues();
         values.put("user_name","江南大学");
         values.put("id_number","6181905060");
         values.put("age",60);
         values.put("phone","18861512060");
         values.put("email","jnuniversity@edu.com");
         db.insert(table,nullColumnHack,values);

         values = new ContentValues();
         values.put("user_name","用户1");
         values.put("id_number","E0E01E000A6263A6A501");
         values.put("age",3);
         values.put("phone","18861512003");
         values.put("email","nami@edu.com");
         db.insert(table,nullColumnHack,values);
    }


//创建数据表
//    private void createTable() {
//        String sql = "CREATE TABLE testing ("+
//                     "user_name VARCHAR(10) UNIQUE, "+
//                     "age INTEGER, "+
//                     "phone CHAR(11) UNIQUE, "+
//                     "email VARCHAR(32) UNIQUE"+
//                     ")";
//        db.execSQL(sql);
//    }

    private void createTable() {
        String sql = "CREATE TABLE testing00 ("+
                     "user_name VARCHAR(10) UNIQUE, "+
                     "id_number VARCHAR(10) UNIQUE NOT NULL, "+
                     "age INTEGER, "+
                     "phone CHAR(11) UNIQUE, "+
                     "email VARCHAR(32) UNIQUE"+
                     ")";
        db.execSQL(sql);
    }

//    private void createTable() {
//        String sql = "CREATE TABLE personnel_management ("+
//                "unit VARCHAR(10), "+
//                "department VARCHAR(10), "+
//                "ARP VARCHAR(10), "+
//                "user_name VARCHAR(10) UNIQUE NOT NULL, "+
//                "account_number CHAR(11) UNIQUE, "+
//                "id_number CHAR(11) UNIQUE, "+
//                "phone CHAR(11) UNIQUE, "+
//                "email VARCHAR(32) UNIQUE,"+
//                "remarks VARCHAR(32),"+
//                "role VARCHAR(10), "+
//                "approver VARCHAR(10), "+
//                "visibility VARCHAR(10)"+
//                ")";
//        db.execSQL(sql);

//        String sql = "CREATE TABLE reagent_management ("+
//                "reagent_coding VARCHAR(10) UNIQUE NOT NULL, "+
//                "reagent_name VARCHAR(10), "+
//                "dangerous_nature VARCHAR(10), "+
//                "supplier VARCHAR(10), "+
//                "specification CHAR(11), "+
//                "master_metering CHAR(11), "+
//                "reamrks CHAR(11), "+
//                "in_out CHAR(2)"+
//                ")";
//        db.execSQL(sql);

//        String sql = "CREATE TABLE personal_use ("+
//                "reagent_name VARCHAR(10) , "+
//                "reagent_coding VARCHAR(10) UNIQUE NOT NULL, "+
//                "supplier VARCHAR(10), "+
//                "specification CHAR(11), "+
//                "master_metering CHAR(11), "+
//                "item_number VARCHAR(10), "+
//                "residual_amount CHAR(11), "+
//                "user CHAR(11), "+
//                "receive_time CHAR(11), "+
//                "return_time CHAR(11), "+
//                "is_return CHAR(2)"+
//                ")";
//        db.execSQL(sql);
//    }


//创建数据库
    private void createDatabase() {
        String name = "Wisdom_labs.db";
        int mode = MODE_PRIVATE;
        SQLiteDatabase.CursorFactory cursorFactory = null;
        db = openOrCreateDatabase(name,mode,cursorFactory);
    }
}
