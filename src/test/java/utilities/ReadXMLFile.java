package utilities;

import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;

public class ReadXMLFile {

	public static String testData;
	private String xmlFilePath = "./src/test/resources/testdata/testdata.xml";
	public String readXMLValue(String xmlFilePath) {
		try {
			File xmlFile = new File(this.xmlFilePath);
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(xmlFile);
			testData = doc.getElementsByTagName(xmlFilePath).item(0).getTextContent();
		}catch (Exception e) {
			e.printStackTrace();
		}
		return testData;
	}
}
