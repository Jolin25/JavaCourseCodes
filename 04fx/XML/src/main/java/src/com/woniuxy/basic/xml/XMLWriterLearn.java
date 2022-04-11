package src.com.woniuxy.basic.xml;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.XMLWriter;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * XML写出配置文件
 * 
 * @author 小虫子的小日常
 *
 */
public class XMLWriterLearn {
	public static void main(String[] args) {
		/*
		 * 1.编写配置文件的DOM(Document Object Model 文档对象模型)树内容
		 */
		// 获取Document对象
		Document document = DocumentHelper.createDocument();
		// 添加Element、Attribute（包括属性名和属性值）、文本内容
		Element school = document.addElement("school");
		school.addAttribute("name", "SWUN");
		school.setText("小可爱的学校");
		Element major = school.addElement("major");
		major.addAttribute("name", "IOT");
		Element myClass = major.addElement("class");
		myClass.addAttribute("name", "1401");
		myClass.setText("可爱的班级");
		/*
		 * 2.设置格式
		 */
		// 获取OutputFormat对象
		OutputFormat format = OutputFormat.createPrettyPrint();
		// 利用输出格式对象设置XML的编码格式
		format.setEncoding("utf-8");
		/*
		 * 3.获取输出流，将内容写到本地
		 */
		// 获取输出流
		XMLWriter writer = null;
		try {
			writer = new XMLWriter(new FileWriter(new File("D:\\ITLearn\\IdeaProject\\xunlianying_jinjie\\JavaCourseCodes\\04fx\\XML\\src\\main\\resources\\swun.xml")),format);
			// 将内容写出
			writer.write(document);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			// 关闭流
			try {
				if (writer != null) {
					writer.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
