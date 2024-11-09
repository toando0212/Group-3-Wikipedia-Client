package vn.edu.usth.wikipediaclient;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.io.File;

public class DatabaseHelper extends SQLiteOpenHelper {
    // Database Information
    private static final String DATABASE_NAME = "articles.db";
    private static final int DATABASE_VERSION = 1;

    // Table Information
    public static final String TABLE_ARTICLES = "Articles";
//    public static final String COLUMN_ID = "id"; // Primary Key
    public static final String COLUMN_TITLE = "title";
    public static final String COLUMN_DESCRIPTION = "description"; // Optional
//    public static final String COLUMN_IMAGE_SRC_ID = "imageSrcId"; // Image Path/URI
    public static final String COLUMN_CONTENT = "content";

    // Constructor
    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_ARTICLES_TABLE = "CREATE TABLE " + TABLE_ARTICLES + " ("
                + "id INTEGER PRIMARY KEY AUTOINCREMENT, "
                + COLUMN_TITLE + " TEXT NOT NULL, "
                + COLUMN_DESCRIPTION + " TEXT, "
                + COLUMN_CONTENT + " TEXT NOT NULL)";
        db.execSQL(CREATE_ARTICLES_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop older table if it exists and recreate
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_ARTICLES);
        onCreate(db);
    }

    // Insert an Article
    public long insertArticle(String title, String description, String content) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_TITLE, title);
        values.put(COLUMN_DESCRIPTION, description);
//        values.put(COLUMN_IMAGE_SRC_ID, imageSrcId);
        values.put(COLUMN_CONTENT, content);

        // Insert the row and return the row ID
        return db.insert(TABLE_ARTICLES, null, values);
    }

    // Get All Articles
    public Cursor getAllArticles() {
        SQLiteDatabase db = this.getReadableDatabase();
        return db.query(TABLE_ARTICLES, null, null, null, null, null, COLUMN_TITLE + " ASC");
    }



}
