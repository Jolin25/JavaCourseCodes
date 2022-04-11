package src.com.woniuxy.basic.xml;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.io.SAXReader;

import java.io.File;

/**
 * 读取xml文件学习
 * 
 * @author 小虫子的小日常
 *
 */
public class SAXReaderLearn {
	public static void main(String[] args) {
		/*
		 * 1.获取SAXReader对象,通过该对象加载xml文件(通过获得Document对象)
		 */
		SAXReader reader = new SAXReader();
		try {
			Document document = reader.read(new File("D:\\ITLearn\\IdeaProject\\xunlianying_jinjie\\JavaCourseCodes\\04fx\\XML\\src\\main\\resources\\jdbc.xml"));

			/*
			 * 2.读取xml文件内容:方式一：原始版，不用XPath，挨着去找需要的内容
			 */
			// // 获取根元素
			// Element root = document.getRootElement();
			//
			// // 判断就是否有根元素以此来判定该XML文件是否为空
			// if (root != null) {// 如果root存在，则说明XML文件不为空
			//
			// // 获取元素
			// List<Element> namedEles = root.elements();
			// for (Element nameEle : namedEles) {
			// if (nameEle.attributeValue("name").equals("myjdbc")) {
			// List<Element> propertyEles = nameEle.elements();
			// for (Element propertyEle : propertyEles) {
			// if (propertyEle.attributeValue("name").equals("driverClass")) {
			// System.out.println("driverClass:" + propertyEle.getText());
			// } else if (propertyEle.attributeValue("name").equals("jdbcUrl"))
			// {
			// System.out.println("jdbcUrl:" + propertyEle.getText());
			// } else if (propertyEle.attributeValue("name").equals("user")) {
			// System.out.println("user:" + propertyEle.getText());
			// } else if (propertyEle.attributeValue("name").equals("password"))
			// {
			// System.out.println("password:" + propertyEle.getText());
			// }
			//
			// }
			// }
			// }
			// }

			/*
			 * 2.读取xml文件内容:方式二：XPath版，导jaxen.jar，利用给的路径去找
			 */
			// 用绝对路径（/开头，代表从        根节点开始）
			String driverClass = document
					.selectSingleNode("/jdbc-config/named-config[@name='myjdbc']/property[@name='driverClass']")
					.getText();
			System.out.println(driverClass);
			// 用相对路径（//开头，代表从任意节点开始）
			String driverClass2 = document.selectSingleNode("//property[@name='driverClass']").getText();
			System.out.println(driverClass2);
		} catch (DocumentException e) {
			e.printStackTrace();
		}
	}
}
