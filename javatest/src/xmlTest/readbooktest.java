package xmlTest;
/**
 * @author Qing
 * 
 */
import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;


public class readbooktest {

	static String path = "D:/temp/unzip/Book/meta-info/pgbook.xml";
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		try {
			DocumentBuilder builder = factory.newDocumentBuilder();
			File metadataFile = new File(path);
			Document dom = builder.parse(metadataFile);
			Element root = dom.getDocumentElement();
			Element metadataElement = (Element) root.getElementsByTagName(
					"metadata").item(0);
			Element titleElement = (Element) metadataElement
					.getElementsByTagName("title").item(0);
			Element authorElement = (Element) metadataElement
					.getElementsByTagName("author").item(0);
			Element identifierElement = (Element) metadataElement
					.getElementsByTagName("identifier").item(0);
			Element publisherElement = (Element) metadataElement
					.getElementsByTagName("publisher").item(0);
			Element dateElement = (Element) metadataElement
					.getElementsByTagName("date").item(0);
			System.out.println(titleElement.getFirstChild() != null ? titleElement.getFirstChild().getNodeValue() : "");
			System.out.println(authorElement.getFirstChild() != null ? authorElement.getFirstChild().getNodeValue() : "");
			System.out.println(identifierElement.getFirstChild() != null ? identifierElement.getFirstChild().getNodeValue() : "");
			System.out.println(publisherElement.getFirstChild() != null ? publisherElement.getFirstChild().getNodeValue() : "");
			System.out.println(dateElement.getFirstChild() != null ? dateElement.getFirstChild().getNodeValue() : "");

			//front page
			Element frontpagElement = (Element) root.getElementsByTagName("frontpage").item(0);
			System.out.println(frontpagElement.getAttribute("type"));
			Element frontpitem = (Element) frontpagElement.getElementsByTagName("pitem").item(0);
			Element frontlitem = (Element) frontpagElement.getElementsByTagName("litem").item(0);
			System.out.println(frontpitem.getAttribute("src"));
			System.out.println(frontlitem.getAttribute("src"));
			
			//aboutpage
			Element aboutElement = (Element) root.getElementsByTagName("aboutpage").item(0);
			System.out.println(aboutElement.getAttribute("type"));
			Element aboutPitem = (Element) aboutElement.getElementsByTagName("pitem").item(0);
			Element aboutLitem = (Element) aboutElement.getElementsByTagName("litem").item(0);
			System.out.println(aboutPitem.getAttribute("src"));
			System.out.println(aboutLitem.getAttribute("src"));
			
			//pages
			Element pages = (Element) root.getElementsByTagName("pages")
					.item(0);
			NodeList pagelist = pages.getElementsByTagName("page");
			for (int i = 0; i < pagelist.getLength(); i++) {
				Element pageElement = (Element) pagelist.item(i);
				Element pitem = (Element) pageElement.getElementsByTagName(
						"pitem").item(0);
				Element litem = (Element) pageElement.getElementsByTagName(
						"litem").item(0);
				Element audio = (Element) pageElement.getElementsByTagName(
						"audio").item(0);
				System.out.println(pageElement.getAttribute("pageNO"));
				System.out.println(pageElement.getAttribute("type"));
				System.out.println(pitem.getAttribute("src"));
				System.out.println(litem.getAttribute("src"));
				System.out.println(pitem.getAttribute("alt"));
				System.out.println(litem.getAttribute("alt"));
				System.out.println(audio.getAttribute("src"));
				System.out.println(audio.getAttribute("length"));
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

}

