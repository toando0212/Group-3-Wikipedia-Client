package vn.edu.usth.wikipediaclient;

import android.media.Image;

public class Article {
    private String title;
    private  String description;
    private int imageSrcId;
    private String content;

    public Article(String title, String description, String content, int imageSrcId) {
        this.title = title;
        this.description = description;
        this.imageSrcId = imageSrcId;
        this.content = content;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() { return description; }

    public int getImageResourceId() { return imageSrcId; }

    public String getContent() {return  content;}
}
