package com.gh.com.gh.pojo;

import com.com.gh.pojo.Book;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.junit.Test;

import java.util.List;

public class Dom4jTest {
    @Test
    public void test1() throws DocumentException {
        SAXReader saxReader = new SAXReader();
        Document document = saxReader.read("src/main/java/books.xml");
        System.out.println(document);
    }

    /**
     * 读取books.xml文件，生成Book类
     * 通过文档对象，获取根元素
     * 通过根元素，获取book标签对象
     * 遍历，处理每个book标签转换为Book类
     */
    @Test
    public void test2() throws DocumentException {
        SAXReader saxReader = new SAXReader();
        Document document = saxReader.read("src/main/java/books.xml");
        Element rootElement = document.getRootElement();
        System.out.println(rootElement);
        List<Element> books = rootElement.elements();
        for (Element book : books) {
            // System.out.println(book.asXML());
            String name = book.elementText("name");
            String price = book.elementText("price");
            String author = book.elementText("author");
            String sn = book.attributeValue("sn");
            System.out.println(new Book(sn, name, Double.parseDouble(price), author));
        }
    }
}
