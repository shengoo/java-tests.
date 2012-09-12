package xmlTest;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class ReadDom {

	public static void main(String[] args) {
		System.out.println("a".equals("a"));
		System.out.println("a".equals("a")? "1" : "2");
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		File src = new File("D:/temp/unzip/meta-info/pgbook.xml");
		try {
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document dom = builder.parse(src);
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
			System.out.println(titleElement.getNodeName() + "\t" + titleElement.getNodeValue());
			System.out.println(authorElement.getTextContent());
			System.out.println(publisherElement.getTextContent());

			Element pages = (Element) root.getElementsByTagName("pages")
					.item(0);
			NodeList pagelist = pages.getElementsByTagName("page");
			for (int i = 0; i < pagelist.getLength(); i++) {
				Element pageElement = (Element) pagelist.item(i);
				Element pimg = (Element) pageElement.getElementsByTagName(
						"pimg").item(0);
				Element limg = (Element) pageElement.getElementsByTagName(
						"limg").item(0);
				Element audio = (Element) pageElement.getElementsByTagName(
						"audio").item(0);
				System.out.println(pageElement.getAttribute("pageNO"));
				System.out.println(pimg.getAttribute("src"));
				System.out.println(audio.getAttribute("length"));
			}
			// NodeList metaNodes = metadataNode.getChildNodes();
			// for (int i = 0; i < metaNodes.getLength(); i++) {
			// Node node = metaNodes.item(i);
			// if (node.getNodeName().equalsIgnoreCase("title")) {
			// System.out.println(node.getNodeValue());
			// // continue;
			// }
			// Element element = (Element)metaNodes.item(i);
			// System.out.println(element.getTextContent());
			// if (node.getNodeName().equalsIgnoreCase("author")) {
			// metadata.setAuthor(node.getNodeValue());
			// continue;
			// }
			// if (node.getNodeName().equalsIgnoreCase("identifier")) {
			// metadata.setIdentifier(node.getNodeValue());
			// continue;
			// }
			// if (node.getNodeName().equalsIgnoreCase("publisher")) {
			// metadata.setPublisher(node.getNodeValue());
			// continue;
			// }
			// if (node.getNodeName().equalsIgnoreCase("date")) {
			// metadata.setDate(node.getNodeValue());
			// continue;
			// }
			// }
			// book.setMetadata(metadata);

			// NodeList pages = root.getElementsByTagName("page");
			// for (int i = 0; i < pages.getLength(); i++) {
			// File file;
			// Node pageNode = pages.item(i);
			// Page page = new Page();
			// page.setPageNum(Integer.parseInt(pageNode.getAttributes()
			// .getNamedItem("pageNO").getNodeValue().toString()));
			// NodeList details = pageNode.getChildNodes();
			// for (int j = 0; j < details.getLength(); j++) {
			// Node detail = details.item(j);
			// // if(detail.getAttributes() == null)
			// // continue;
			// String src;
			// if (detail.getNodeName().equalsIgnoreCase("pimg")) {
			// src = detail.getAttributes().getNamedItem("src")
			// .getNodeValue().toString();
			// file = new File(config.getContentFolder() + File.separator +
			// src);
			// page.setPimgFile(file);
			// continue;
			// }
			// if (detail.getNodeName().equalsIgnoreCase("limg")) {
			// src = detail.getAttributes().getNamedItem("src")
			// .getNodeValue().toString();
			// file = new File(config.getContentFolder() + File.separator +
			// src);
			// page.setLimgFile(file);
			// continue;
			// }
			// if (detail.getNodeName().equalsIgnoreCase("audio")) {
			// src = detail.getAttributes().getNamedItem("src")
			// .getNodeValue().toString();
			// file = new File(config.getContentFolder() + File.separator +
			// src);
			// int length = Integer.parseInt(detail.getAttributes()
			// .getNamedItem("length").getNodeValue()
			// .toString());
			// page.setAudioFile(file);
			// page.setAudioLength(length);
			// continue;
			// }
			// }
			// book.addPage(page);
			// }
			// config.setBook(book);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

}
