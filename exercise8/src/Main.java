public class Main {
    public static void main(String[] args) throws Exception {
            String xmlFilePath = "books.xml";
            String modifiedXmlFilePath = "books_added.xml";
            XMLHandler.parseAndModifyXML(xmlFilePath, modifiedXmlFilePath);
            System.out.println("-------------------------------");

            String jsonFilePath = "books.json";
            String modifiedJsonFilePath = "books_added.json";
            JSONHandler.parseAndModifyJSON(jsonFilePath, modifiedJsonFilePath);

    }
}
