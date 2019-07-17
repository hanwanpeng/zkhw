package com.zkhw.shanxi.utils;

import java.io.ByteArrayOutputStream;
import java.io.StringReader;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.soap.Node;
import javax.xml.transform.sax.SAXResult;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

import com.sun.org.apache.xml.internal.serialize.OutputFormat;
import com.sun.org.apache.xml.internal.serialize.XMLSerializer;
import com.thoughtworks.xstream.XStream;

public class XmlUtils {

	private final static String XML_DECLARATION = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>";

	public static <T> String toXML(Object obj) {
		XStream stream = getXStream();
		stream.processAnnotations(obj.getClass());
		return new StringBuffer(XML_DECLARATION).append(stream.toXML(obj)).toString();
	}

	public static <T> T fromXML(String xmlStr, Class<T> clazz) {
		XStream stream = getXStream();
		stream.processAnnotations(clazz);
		Object obj = stream.fromXML(xmlStr);
		try {
			return clazz.cast(obj);
		} catch (ClassCastException e) {
			return null;
		}
	}

	public static String getNodeValue(String xpath, String dataStr) {
		try {
			// 将字符串转为xml
			Document document = DocumentHelper.parseText(dataStr);
			// 查找节点
			Element element = (Element) document.selectSingleNode(xpath);
			if (element != null) {
				return element.getStringValue();
			}
		} catch (DocumentException e) {
			e.printStackTrace();
		}
		return "";
	}

	public static XStream getXStream() {
		return new XStream();
	}

	public static final String modelToStringXML(Object obj) {
		//StringWriter writer = new StringWriter();
		ByteArrayOutputStream op = new ByteArrayOutputStream();
		try {
			JAXBContext jaxbContext = JAXBContext.newInstance(obj.getClass());
			OutputFormat of = new OutputFormat();
			of.setCDataElements(new String[] { "^ObjectInstance"});
			
			// set any other options you'd like
			//of.setPreserveSpace(true);
			//of.setIndenting(true);
			XMLSerializer serializer = new XMLSerializer(op, of);
			SAXResult result = new SAXResult(serializer.asContentHandler());

			Marshaller marshaller = jaxbContext.createMarshaller();
			// 设置序列化的编码格式
			marshaller.setProperty(Marshaller.JAXB_ENCODING, "UTF-8");
			// 设置格式化输出
			marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			marshaller.setProperty(Marshaller.JAXB_FRAGMENT, true);
			marshaller.marshal(obj, result);
			return op.toString("UTF-8");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;

	}

	public static final Node modelToNode(Object obj, Node node) {

		try {
			JAXBContext jaxbContext = JAXBContext.newInstance(obj.getClass());
			Marshaller marshaller = jaxbContext.createMarshaller();
			marshaller.setProperty(Marshaller.JAXB_ENCODING, "UTF-8");
			marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			marshaller.marshal(obj, node);
		} catch (JAXBException e) {
			e.printStackTrace();
		}

		return node;

	}

	
	public static Object xmlToBean(String xml, Class<?> load){
		try{
		     JAXBContext context = JAXBContext.newInstance(load);  
		     Unmarshaller unmarshaller = context.createUnmarshaller(); 
		     StringReader sr= new StringReader(xml);
		     Object object = unmarshaller.unmarshal(sr);
	         //Object object = unmarshaller.unmarshal(new File(xmlPath));
		     return object;
		}catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}
	
	
}
