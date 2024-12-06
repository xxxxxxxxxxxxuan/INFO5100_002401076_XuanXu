import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import java.util.ArrayList;
import java.util.List;

public class Book {
    private String title;
    private int publishedYear;
    private int numberOfPages;
    private List<String> authors;

    public Book(String title, int publishedYear, int numberOfPages, List<String> authors) {
        this.title = title;
        this.publishedYear = publishedYear;
        this.numberOfPages = numberOfPages;
        this.authors = authors != null ? authors : new ArrayList<>();
    }

    public Element toXmlElement(Document doc) {
        Element bookElement = doc.createElement("Book");

        Element titleElement = doc.createElement("title");
        titleElement.setTextContent(this.title);
        bookElement.appendChild(titleElement);

        Element yearElement = doc.createElement("publishedYear");
        yearElement.setTextContent(String.valueOf(this.publishedYear));
        bookElement.appendChild(yearElement);

        Element pagesElement = doc.createElement("numberOfPages");
        pagesElement.setTextContent(String.valueOf(this.numberOfPages));
        bookElement.appendChild(pagesElement);

        Element authorsElement = doc.createElement("authors");
        for (String author : this.authors) {
            Element authorElement = doc.createElement("author");
            authorElement.setTextContent(author);
            authorsElement.appendChild(authorElement);
        }
        bookElement.appendChild(authorsElement);

        return bookElement;
    }


    public JSONObject toJsonObject() {
        JSONObject bookObject = new JSONObject();
        bookObject.put("title", title);
        bookObject.put("publishedYear", publishedYear);
        bookObject.put("numberOfPages", numberOfPages);

        JSONArray authorsArray = new JSONArray();
        authorsArray.addAll(authors);
        bookObject.put("authors", authorsArray);

        return bookObject;
    }


    public void printDetails() {
        System.out.println("Title: " + title);
        System.out.println("Published Year: " + publishedYear);
        System.out.println("Number of Pages: " + numberOfPages);
        System.out.println("Authors: " + String.join(", ", authors));
        System.out.println();
    }

}