package repository;

import org.w3c.dom.Document;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
/**
 * This class is for defining the creation of the XML file.
 */
public class XMLUtils {
        /**
         * The method create XML file.
         * @param keyName of the driver type or of the url.
         * @return driver or url.
         * @throws Exception
         */
        public static String getData(String keyName) throws Exception{
            File fXmlFile = new File("C:\\Users\\edenmm\\IdeaProjects\\Pomvom\\src\\main\\resources\\data.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(fXmlFile);
            doc.getDocumentElement().normalize();
            return doc.getElementsByTagName(keyName).item(0).getTextContent();
        }
    }
