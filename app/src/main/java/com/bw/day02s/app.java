package com.bw.day02s;

import android.app.Application;
import android.database.sqlite.SQLiteDatabase;

import com.bw.day02s.dao.DaoMaster;
import com.bw.day02s.dao.DaoSession;

public class app extends Application {

    private DaoMaster daoMaster;
    private static DaoSession daoSession;
    @Override
    public void onCreate() {
        super.onCreate();

        DaoMaster.DevOpenHelper devOpenHelper = new DaoMaster.DevOpenHelper(this, "jab.db");
        SQLiteDatabase writableDatabase = devOpenHelper.getWritableDatabase();
        daoMaster = new DaoMaster(writableDatabase);
    }
    public static DaoSession getDaoSession(){
        return daoSession;
    }
}
