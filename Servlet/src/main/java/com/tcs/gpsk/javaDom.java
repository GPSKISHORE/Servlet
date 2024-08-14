package com.tcs.gpsk;

import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class javaDom {

	public static void main(String[] args) {
		DocumentBuilderFactory doc=DocumentBuilderFactory.newInstance();
		try {
			DocumentBuilder d=doc.newDocumentBuilder();
			Document dd=d.parse("C:\\Users\\gpski\\git\\Servlet\\Servlet\\src\\main\\webapp\\WEB-INF\\web.xml");
			NodeList nl=dd.getChildNodes();
//			System.out.println(nl);
//			System.out.println(nl.getLength());
			for(int i=0;i<nl.getLength();i++) {
				Node nd=nl.item(i);
				if(nd.getNodeType()==Node.ELEMENT_NODE) {
					Element el=(Element)nd;
//					System.out.println(el);
					String tn=el.getTagName();
					String con=el.getTextContent();
					System.out.println("tag "+tn+" "+con);
					System.out.println("\\\\\\\\\\\\"+el.getElementsByTagName("servlet-name").item(i).getTextContent());
					}
			}
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
