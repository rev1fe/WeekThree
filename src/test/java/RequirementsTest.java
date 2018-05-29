import Requirements.Book;
import Requirements.Chapter;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


public class RequirementsTest {
    private static final String VALID_CHAPTER = "HelloWorld";
    private static final String VALID_NUMBER = "2.2";

    private static final String VALID_CHAPTER_TWO = "It is ME";
    private static final String VALID_NUMBER_TWO= "2.3";

    private static final String INVALID_NUMBER = "2.2.3";
    private static final String NULL_STRING= null;

    private static final String VALID_NAME = "HelloWorld";
    private static final String VALID_AUTHOR = "2.2";

    private Chapter chapter;
    private Book book;

    @Before
    public void setUp(){
        chapter = new Chapter(VALID_CHAPTER, VALID_NUMBER);
        book = new Book(VALID_NAME, VALID_AUTHOR);
    }

    @Test
    public void chapterAcceptsNameAndNumber(){
        Assert.assertNotNull("Chapter Should NOT be null", chapter.getChapter());
        Assert.assertNotNull("Number Should NOT be null", chapter.getNumber());
    }

    @Test(expected = IllegalArgumentException.class)
    public void chapterNameIsNotNull(){
        Chapter nullChapter = new Chapter(NULL_STRING, VALID_NUMBER);
        Assert.assertNotNull("Chapter Should NOT be null", nullChapter.getChapter());
    }

    @Test
    public void shouldBePossibleToCompare(){
        Assert.assertTrue( "Chapter should implement Comparable", chapter instanceof Comparable);
    }

    @Test
    public void shouldOverrideEquals() throws NoSuchMethodException {
        chapter.getClass().getMethod("equals", Object.class);
        Assert.assertEquals(chapter.getClass(), chapter.getClass().getMethod("equals", Object.class).getDeclaringClass() );
    }


    @Test
    public void shouldOverrideHashCode() throws NoSuchMethodException {
        chapter.getClass().getMethod("hashCode");
        Assert.assertEquals(chapter.getClass(), chapter.getClass().getMethod("hashCode").getDeclaringClass() );
    }

    @Test
    public void bookHasNameAndAuthor(){
        Assert.assertEquals(VALID_NAME, book.getName());
        Assert.assertEquals(VALID_AUTHOR, book.getAuthor());
    }

    @Test(expected = IllegalArgumentException.class)
    public void bookNameCannotBeNullThrowsException(){
        new Book(NULL_STRING, VALID_AUTHOR);
    }

    @Test(expected = IllegalArgumentException.class)
    public void bookAuthorCannotBeNullThrowsException(){
        new Book(VALID_NAME, NULL_STRING);
    }

    @Test(expected = IllegalArgumentException.class)
    public void chapterNumberCannotBeMoreThanTwoLevels(){
        new Chapter(VALID_CHAPTER, INVALID_NUMBER);
    }

    @Test(expected = IllegalArgumentException.class)
    public void bookNameCannotBeEmptyExceptionIsThrown(){
        String emptyName = "";
        new Book(emptyName, VALID_AUTHOR);
    }

    @Test(expected = IllegalArgumentException.class)
    public void bookAuthorCannotBeEmptyExceptionIsThrown(){
        String emptyAuthor = "";
        new Book(VALID_NAME, emptyAuthor);
    }

    @Test
    public void newChapterObjectIsCreate(){
        int nrChapters = book.getNumberOfChapters();
        Assert.assertEquals(0, nrChapters);
        book.addChapter(VALID_CHAPTER, VALID_NUMBER);
        nrChapters = book.getNumberOfChapters();
        Assert.assertEquals(1, nrChapters);
    }

    @Test
    public void returnAllChaptersSorted(){
        book.addChapter(VALID_CHAPTER_TWO, VALID_NUMBER_TWO);
        book.addChapter(VALID_CHAPTER, VALID_NUMBER);

        ArrayList<Chapter> chapters = book.getAllChapters();

        Assert.assertEquals("2.2", chapters.get(0).getNumber());
        Assert.assertEquals("2.3", chapters.get(1).getNumber());
    }


}
