package com.atguigu.book.myssm;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

public class ClassPathXmlApplicationContext  implements BeanFactory {

    private Map<String ,Object> beanMap = new HashMap<>();

    private String path = "src/main/java/applicationContext.xml";

    public ClassPathXmlApplicationContext(){
        this("src/main/java/applicationContext.xml");
    }

    public ClassPathXmlApplicationContext(String path){
        //读取xml文件  初始化  放入map中
        if(path==null){
            throw new RuntimeException("没有指定配置文件");
        }
        try {
        InputStream inputStream = getClass().getClassLoader().getResourceAsStream(path);
        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
        Document document = documentBuilder.parse(inputStream);

        NodeList beanNdeList = document.getElementsByTagName("bean");
        for(int i=0;i<beanNdeList.getLength();i++){
            Node beanNode = beanNdeList.item(i);
            if(beanNode.getNodeType() == Node.ELEMENT_NODE){
                Element beanElement = (Element) beanNode;
                String beanId = beanElement.getAttribute("id");
                String className = beanElement.getAttribute("class");
                Class BeanClass = Class.forName(className);
                Object beanObj = BeanClass.newInstance();
                beanMap.put(beanId,beanObj);
            }
        }
        //组装bean  之间的依赖关系
        for(int i=0;i<beanNdeList.getLength();i++){
            Node beanNode = beanNdeList.item(i);
            if(beanNode.getNodeType() == Node.ELEMENT_NODE){
                Element beanElement = (Element) beanNode;
                String beanId = beanElement.getAttribute("id");
                NodeList beanChildNodeList = beanElement.getChildNodes();
                for(int j=0;j<beanChildNodeList.getLength();j++){
                    Node beanChildNode = beanChildNodeList.item(j);
                    if (beanChildNode.getNodeType() == Node.ELEMENT_NODE && "property".equals(beanChildNode.getNodeName())) {
                        Element propertyElement = (Element) beanChildNode;
                        String propertyName = propertyElement.getAttribute("name");
                        String propertyRef = propertyElement.getAttribute("ref");
                        Object refObj = beanMap.get(propertyRef);
                        Object beanObj = beanMap.get(beanId);
                        Class beanClazz = beanObj.getClass();
                        Field propretyField = beanClazz.getDeclaredField(propertyName);
                        propretyField.setAccessible(true);
                        propretyField.set(beanObj,refObj);
                    }
                }
            }
        }

        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
    }
    @Override
    public Object getBean(String id) {
        return beanMap.get(id);
    }
}
