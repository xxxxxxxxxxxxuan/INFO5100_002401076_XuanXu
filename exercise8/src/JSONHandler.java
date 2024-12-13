import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class JSONHandler {
    public static void parseAndModifyJSON(String inputFilePath, String outputFilePath) throws Exception {
        JSONObject jsonObject = parseJsonFile(inputFilePath);

        JSONArray booksArray = (JSONArray) ((JSONObject) jsonObject.get("BookShelf")).get("Books");
        System.out.println("JSON Parsing Result:");
        System.out.println("Original Books:");
        List<Book> books = parseBooks(booksArray);
        for (Book book : books) {
            book.printDetails();
        }

        List<String> authors = new ArrayList<>();
        authors.add("Author D1");
        Book newBook = new Book("Book D", 2024, 350, authors);

        booksArray.add(newBook.toJsonObject());

        System.out.println("\nAfter Adding New Book:");
        books = parseBooks(booksArray);
        for (Book book : books) {
            book.printDetails();
        }

        saveJsonToFile(jsonObject, outputFilePath);
        System.out.println("\nUpdated JSON has been saved to: " + outputFilePath);
    }

    private static JSONObject parseJsonFile(String filePath) throws IOException, ParseException {
        JSONParser parser = new JSONParser();
        FileReader reader = new FileReader(filePath);
        return (JSONObject) parser.parse(reader);
    }

    private static void saveJsonToFile(JSONObject jsonObject, String filePath) throws IOException {
        try (FileWriter fileWriter = new FileWriter(filePath)) {
            fileWriter.write(jsonObject.toJSONString());
        }
    }

    private static List<Book> parseBooks(JSONArray booksArray) {
        List<Book> books = new ArrayList<>();
        for (Object obj : booksArray) {
            JSONObject bookObject = (JSONObject) obj;
            String title = (String) bookObject.get("title");
            int publishedYear = ((Number) bookObject.get("publishedYear")).intValue();
            int numberOfPages = ((Number) bookObject.get("numberOfPages")).intValue();

            JSONArray authorsArray = (JSONArray) bookObject.get("authors");
            List<String> authors = new ArrayList<>();
            for (Object author : authorsArray) {
                authors.add((String) author);
            }

            books.add(new Book(title, publishedYear, numberOfPages, authors));
        }
        return books;
    }

}
