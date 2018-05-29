package Requirements;

public class Chapter implements Comparable<Chapter> {
    private String chapter;
    private String number;

    public Chapter(String chapter, String number) {
        if(chapter == null){
            this.chapter = "Invalid Name";
            throw new IllegalArgumentException("Chapter cannot be null");
        }
        else
            this.chapter = chapter;

        String[] strings = number.split("\\.");
        if(strings.length >= 3)
        {
            throw new IllegalArgumentException("Chapter cannot be more than 2 levels");
        }
        else
            this.number = number;
    }

    public String getChapter() {
        return chapter;
    }

    public String getNumber() {
        return number;
    }

    @Override
    public int compareTo(Chapter o) {
        return chapter.compareTo(o.getChapter());
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }
}
