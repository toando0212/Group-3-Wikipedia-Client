package vn.edu.usth.wikipediaclient;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {
    // Database Information
    private static final String DATABASE_NAME = "articles.db";
    private static final int DATABASE_VERSION = 1;

    // Table Information
    public static final String TABLE_ARTICLES = "Articles";
//    public static final String COLUMN_ID = "id"; // Primary Key
    public static final String COLUMN_TITLE = "title";
    public static final String COLUMN_DESCRIPTION = "description"; // Optional
    public static final String COLUMN_IMAGE_SRC_ID = "imageSrcId"; // Image Path/URI
    public static final String COLUMN_CONTENT = "content";

    // Constructor
    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // Create Articles Table
        String CREATE_ARTICLES_TABLE = "CREATE TABLE " + TABLE_ARTICLES + " ("
                + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COLUMN_TITLE + " TEXT NOT NULL, " +
                COLUMN_DESCRIPTION + " TEXT, " +
                COLUMN_IMAGE_SRC_ID + " TEXT, " +
                COLUMN_CONTENT + " TEXT NOT NULL)";
        db.execSQL(CREATE_ARTICLES_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop older table if it exists and recreate
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_ARTICLES);
        onCreate(db);
    }

    // Insert an Article
    public long insertArticle(String title, String description, String imageSrcId, String content) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_TITLE, title);
        values.put(COLUMN_DESCRIPTION, description);
        values.put(COLUMN_IMAGE_SRC_ID, imageSrcId);
        values.put(COLUMN_CONTENT, content);

        // Insert the row and return the row ID
        return db.insert(TABLE_ARTICLES, null, values);
    }

    // Get All Articles
    public Cursor getAllArticles() {
        SQLiteDatabase db = this.getReadableDatabase();
        return db.query(TABLE_ARTICLES, null, null, null, null, null, COLUMN_TITLE + " ASC");
    }


    // Update an Article
//    public int updateArticle(int id, String title, String description, String imageSrcId, String content) {
//        SQLiteDatabase db = this.getWritableDatabase();
//        ContentValues values = new ContentValues();
//        values.put(COLUMN_TITLE, title);
//        values.put(COLUMN_DESCRIPTION, description);
//        values.put(COLUMN_IMAGE_SRC_ID, imageSrcId);
//        values.put(COLUMN_CONTENT, content);
//
//        // Update the row with the given ID
//        return db.update(TABLE_ARTICLES, values, COLUMN_ID + "=?", new String[]{String.valueOf(id)});
//    }

    // Delete an Article
//    public int deleteArticle(int id) {
//        SQLiteDatabase db = this.getWritableDatabase();
//        return db.delete(TABLE_ARTICLES, COLUMN_ID + "=?", new String[]{String.valueOf(id)});
//    }

    // Search Articles by Title
//    public Cursor searchArticles(String keyword) {
//        SQLiteDatabase db = this.getReadableDatabase();
//        String query = "SELECT * FROM " + TABLE_ARTICLES +
//                " WHERE " + COLUMN_TITLE + " LIKE ?";
//        return db.rawQuery(query, new String[]{"%" + keyword + "%"});
//    }
}
