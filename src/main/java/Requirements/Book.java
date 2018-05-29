package Requirements;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class Book {
    private String name;
    private String author;
    private ArrayList<Chapter> chapters;

    public Book(String name, String author) {
        if(name==null || author==null || name.isEmpty() || author.isEmpty())
            throw new IllegalArgumentException("Nulls are not accepted");
        this.name=name;
        this.author=author;
        this.chapters = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public String getAuthor() {
        return author;
    }

    public void addChapter(String chapter, String number) {
        chapters.add(new Chapter(chapter, number));
    }

    public int getNumberOfChapters() {
        return chapters.size();
    }

    public ArrayList<Chapter> getAllChapters() {
        Collections.sort(chapters);
        return  chapters;
    }
}
