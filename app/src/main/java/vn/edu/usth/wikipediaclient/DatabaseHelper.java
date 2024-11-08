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
//    public static final String COLUMN_ID = "id";
    public static final String COLUMN_TITLE = "title";
    public static final String COLUMN_DESCRIPTION = "description";
    public static final String COLUMN_IMAGE_SRC_ID = "imageSrcId";
    public static final String COLUMN_CONTENT = "content";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_ARTICLES_TABLE = "CREATE TABLE " + TABLE_ARTICLES + " ("
                + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COLUMN_TITLE + " TEXT NOT NULL, " +
                COLUMN_DESCRIPTION + " TEXT, " +
                COLUMN_IMAGE_SRC_ID + " INTEGER, " +
                COLUMN_CONTENT + " TEXT" + ")";
        db.execSQL(CREATE_ARTICLES_TABLE);
        db.execSQL("INSERT INTO " + TABLE_ARTICLES + " (" +
                  COLUMN_TITLE + ", " + COLUMN_DESCRIPTION + ", " +
                COLUMN_IMAGE_SRC_ID + ", " + COLUMN_CONTENT + ") VALUES " +
                "(1, 'Donald Trump - 45th president of the United States', 'This is a description for article 1.', 'Harris.jpg', 'Donald Trump (born June 14, 1946, New York, New York, U.S.) is the 45th president of the United States (2017–21); and on November 6, 2024, he again won the presidency, becoming the first president to be elected to nonconsecutive terms since Grover Cleveland. Trump’s 2024 victory, in which he defeated Vice Pres. Kamala Harris resoundingly in both the popular and Electoral College votes, marked one of the most stunning political comebacks in U.S. history.\n" +
                "On May 30, 2024, Trump became the first former president to be convicted of a crime when a New York state jury convicted him on 34 felony counts of falsifying business records in connection with a hush-money payment in 2016 to the adult-film star Stephanie Clifford, known as Stormy Daniels, who claimed to have had an affair with Trump in 2006.\n" +
                "Trump was later indicted on dozens of other federal and state charges in cases relating to his efforts to overturn Biden’s victory in the 2020 presidential election and his removal of numerous classified documents from the White House on his last day of office. Trump was also found liable in a major civil suit alleging business fraud in New York state and two civil suits accusing him of sexually abusing and defaming the writer E. Jean Carroll. With the start of his trial in the business-records case on April 15, 2024, Trump became the first former president to stand trial on criminal charges.\n" +
                "Trump is the third president in U.S. history (after Andrew Johnson in 1868 and Bill Clinton in 1998) to be impeached by the U.S. House of Representatives and the only president to be impeached twice—once (in 2019) for abuse of power and obstruction of Congress in connection with the Ukraine scandal and once (in 2021) for “incitement of insurrection” in connection with the January 6 attack on the U.S. Capitol by a violent mob of Trump supporters. Both of Trump’s impeachments ended in his acquittal by the U.S. Senate. Trump ran for reelection in 2020 but lost to former vice president Joe Biden by an Electoral College vote of 306 to 232.\n" +
                "Trump is also a real estate developer and businessman who has owned, managed, or licensed his name to hotels, casinos, golf courses, resorts, and residential properties in the New York City area and around the world. Since the 1980s Trump has lent his name to scores of retail ventures—including branded lines of clothing, cologne, food, and furniture. In the early 21st century his private conglomerate, the Trump Organization, comprised some 500 companies involved in a wide range of businesses, including hotels and resorts, residential properties, merchandise, and entertainment and television.\n'), " +
                "(2, 'Sample Article 2', 'This is a description for article 2.', 'image2.jpg', 'Content for article 2'), " +
                "(3, 'Sample Article 3', 'This is a description for article 3.', 'image3.jpg', 'Content for article 3');");

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
//        values.put(COLUMN_IMAGE_SRC_ID, article.getImageResourceId());
//        values.put(COLUMN_CONTENT, article.getContent());

        long id = db.insert(TABLE_ARTICLES, null, values);
        db.close();
        return id;
    }

    // Retrieve all articles
    public Cursor getAllArticles() {
        SQLiteDatabase db = this.getReadableDatabase();
        return db.query(TABLE_ARTICLES, null, null, null, null, null, null);
    }

    // Update an article
//    public int updateArticle(Article article) {
//        SQLiteDatabase db = this.getWritableDatabase();
//        ContentValues values = new ContentValues();
//        values.put(COLUMN_TITLE, article.getTitle());
//        values.put(COLUMN_DESCRIPTION, article.getDescription());
//        values.put(COLUMN_IMAGE_SRC_ID, article.getImageResourceId());
//        values.put(COLUMN_CONTENT, article.getContent());
//
//        return db.update(TABLE_ARTICLES, values, COLUMN_ID + " = ?",
//                new String[]{String.valueOf(article.getId())});
//    }

    // Delete an article by ID
//    public void deleteArticle(int id) {
//        SQLiteDatabase db = this.getWritableDatabase();
//        db.delete(TABLE_ARTICLES, COLUMN_ID + " = ?", new String[]{String.valueOf(id)});
//        db.close();
//    }
}
