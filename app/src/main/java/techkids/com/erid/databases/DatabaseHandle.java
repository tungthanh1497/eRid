package techkids.com.erid.databases;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tungthanh.1497 on 06/17/2017.
 */

public class DatabaseHandle {
    // 1: create instance MyDatabase
    private MyDatabase myDatabase;

    public DatabaseHandle(Context context) {
        myDatabase = new MyDatabase(context);
    }

    // 2: create instance databasehandle
    private static DatabaseHandle instance;

    public static DatabaseHandle getInstance(Context context) {
        if (instance == null) {
            instance = new DatabaseHandle(context);
        }
        return instance;
    }

    // 3: create instance SQLiteDatabase
    private SQLiteDatabase storyDatabase;

    // 4: get list story
    public List<StoryModel> getListStory() {
        storyDatabase = myDatabase.getReadableDatabase();
        List<StoryModel> storyModelList = new ArrayList<>();
        Cursor cursor = storyDatabase.rawQuery("select * from tbl_short_story", null);
        cursor.moveToFirst();

        while (!cursor.isAfterLast()) {
            int id = cursor.getInt(0);
            String image = cursor.getString(1);
            String title = cursor.getString(2);
            String description = cursor.getString(3);
            String content = cursor.getString(4);
            String author = cursor.getString(5);
            boolean bookmark = (cursor.getInt(6) != 0);

            StoryModel storyModel = new StoryModel(id, image, title, description, content, author, bookmark);
            storyModelList.add(storyModel);
            cursor.moveToNext();
        }
        return storyModelList;
    }
    public List<String> getListTitleStory() {
        storyDatabase = myDatabase.getReadableDatabase();
        List<String> storyModelList = new ArrayList<>();
        Cursor cursor = storyDatabase.rawQuery("select * from tbl_short_story", null);
        cursor.moveToFirst();

        while (!cursor.isAfterLast()) {
            String title = cursor.getString(2);
            storyModelList.add(title);
            cursor.moveToNext();
        }
        return storyModelList;
    }
}
