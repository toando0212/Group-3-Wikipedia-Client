package vn.edu.usth.wikipediaclient;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "articles.db";
    private static final int DATABASE_VERSION = 1;

    public static final String TABLE_ARTICLES = "Articles";
    public static final String COLUMN_TITLE = "title";
    public static final String COLUMN_DESCRIPTION = "description";
    public static final String COLUMN_IMAGE_SRC_ID = "imageSrcId";
    public static final String COLUMN_CONTENT = "content";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_ARTICLES_TABLE = "CREATE TABLE " + TABLE_ARTICLES + " (" +
                COLUMN_TITLE + " TEXT PRIMARY KEY, " +
                COLUMN_DESCRIPTION + " TEXT, " +
                COLUMN_IMAGE_SRC_ID + " INTEGER, " +
                COLUMN_CONTENT + " TEXT" + ")";
        db.execSQL(CREATE_ARTICLES_TABLE);

        // Insert sample data into the Articles table
        String INSERT_SAMPLE_DATA = "INSERT INTO " + TABLE_ARTICLES + " (" +
                COLUMN_TITLE + ", " +
                COLUMN_DESCRIPTION + ", " +
                COLUMN_IMAGE_SRC_ID + ", " +
                COLUMN_CONTENT +
                ") VALUES " +
                "('Sample Article 1', 'Description 1', 101, 'Content 1'), " +
                "('Sample Article 2', 'Description 2', 102, 'Content 2'), " +
                "('Sample Article 3', 'Description 3', 103, 'Content 3');";
        db.execSQL(INSERT_SAMPLE_DATA);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_ARTICLES);
        onCreate(db);
    }
    // Insert a new article
    public long addArticle(Article article) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_TITLE, article.getTitle());
        values.put(COLUMN_DESCRIPTION, article.getDescription());
        values.put(COLUMN_IMAGE_SRC_ID, article.getImageResourceId());
        values.put(COLUMN_CONTENT, article.getContent());

        long id = db.insert(TABLE_ARTICLES, null, values);
        db.close();
        return id;
    }

    // Retrieve all articles
    public Cursor getAllArticles() {
        SQLiteDatabase db = this.getReadableDatabase();
        return db.query(TABLE_ARTICLES, null, null, null, null, null, COLUMN_TITLE + " ASC");
    }

    // Update an article by title
    public int updateArticle(Article article) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_DESCRIPTION, article.getDescription());
        values.put(COLUMN_IMAGE_SRC_ID, article.getImageResourceId());
        values.put(COLUMN_CONTENT, article.getContent());

        return db.update(TABLE_ARTICLES, values, COLUMN_TITLE + " = ?",
                new String[]{article.getTitle()});
    }

    // Delete an article by title
    public void deleteArticle(String title) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_ARTICLES, COLUMN_TITLE + " = ?", new String[]{title});
        db.close();
    }
}
