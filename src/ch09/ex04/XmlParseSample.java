package ch09.ex04;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class XmlParseSample {

	public static void main(String[] args) {

		try {
			DocumentBuilderFactory factory = DocumentBuilderFactory
					.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();
			File f = new File("sample1.xml");
			Document doc = builder.parse(f);
			Element root = (Element) doc.getDocumentElement();
			NodeList children = ((Node) root).getChildNodes();
			for (int i = 0; i < children.getLength(); i++) {
				Node child = (Node) children.item(i);
				if (child instanceof Element) {
					Element childElement = (Element) child;
					System.out.println(getElementContent(childElement, "name"));
					System.out.println(getElementContent(childElement, "url"));
				}
			}
		} catch (ParserConfigurationException | SAXException | IOException e) {
			e.printStackTrace();
		}
	}

	// アイテム要素から各子要素の内容を取り出す（5）
	static String getElementContent(Element e, String TagName) {
		NodeList nl = e.getElementsByTagName(TagName);
		if (nl.getLength() == 0) {
			return "";
		}
		Node n = nl.item(0);
		Node content = n.getFirstChild();
		return content.getNodeValue();
	}

}
