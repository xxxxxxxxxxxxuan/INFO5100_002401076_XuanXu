import org.w3c.dom.*;
import javax.xml.parsers.*;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class XMLHandler {
    public static void parseAndModifyXML(String filePath, String outputFilePath) throws Exception {
        File file = new File(filePath);
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document doc = builder.parse(file);

        System.out.println("XML Parsing Result:");
        NodeList bookNodes = doc.getElementsByTagName("Book");
        for (int i = 0; i < bookNodes.getLength(); i++) {
            Element bookElement = (Element) bookNodes.item(i);
            Book book = parseBookFromXml(bookElement);
            book.printDetails();
        }

        List<String> authors = new ArrayList<>();
        authors.add("Author D1");
        Book newBook = new Book("Book D", 2024, 350, authors);
        doc.getDocumentElement().appendChild(newBook.toXmlElement(doc));

        System.out.println("\nAfter Adding New Book:");
        bookNodes = doc.getElementsByTagName("Book");
        for (int i = 0; i < bookNodes.getLength(); i++) {
            Element bookElement = (Element) bookNodes.item(i);
            Book book = parseBookFromXml(bookElement);
            book.printDetails();
        }

        saveXmlToFile(doc, outputFilePath);
    }

    private static Book parseBookFromXml(Element bookElement) {
        String title = getElementTextContent(bookElement, "title");
        int publishedYear = Integer.parseInt(getElementTextContent(bookElement, "publishedYear"));
        int numberOfPages = Integer.parseInt(getElementTextContent(bookElement, "numberOfPages"));

        List<String> authors = new ArrayList<>();
        NodeList authorNodes = bookElement.getElementsByTagName("author");
        for (int j = 0; j < authorNodes.getLength(); j++) {
            authors.add(authorNodes.item(j).getTextContent());
        }

        return new Book(title, publishedYear, numberOfPages, authors);
    }

    private static String getElementTextContent(Element parent, String elementName) {
        NodeList nodeList = parent.getElementsByTagName(elementName);
        return nodeList.item(0).getTextContent();
    }

    private static void saveXmlToFile(Document doc, String filePath) throws Exception {
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        transformer.setOutputProperty(OutputKeys.INDENT, "yes");
        DOMSource source = new DOMSource(doc);
        StreamResult result = new StreamResult(new File(filePath));
        transformer.transform(source, result);

        System.out.println("\nModified XML has been saved to: " + filePath);
    }
}
