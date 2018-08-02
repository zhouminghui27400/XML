package cn.maven.xml;

/**
 * Hello world!
 *
 */
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;
import java.util.Scanner;
public class App {
    static org.dom4j.Document document = null;
    static Element root = null;
    static Scanner input = new Scanner(System.in);



        public static void main (String[]args){
            System.out.println("*******欢迎进入xml节点操作*********");
            System.out.println("********请输入你的选择*************");
            System.out.println("********1.查询所有****************");
            System.out.println("*********2.修改*******************");
            System.out.println("*********3.删除*******************");
            System.out.println("*********4.增加*******************");
            getDocument();
            int chose = input.nextInt();
            switch (chose) {
                case 1:   //查询所有
                    findAll();
                    break;
                case 2:  //修改
                    update();
                    break;
                case 3:  //删除
                    delete();
                    break;
                case 4:   //增加
                    add();
                    break;

            }


        }

        private static void add () {
            Element grade = root.addElement("class");
            grade.addAttribute("name", "3班");
            Element clazz = grade.addElement("student");
            clazz.addAttribute("id", "小红1");
            clazz.addAttribute("id", "小红2");
            saveXml();

            System.out.println("增加成功");
        }

        private static void delete () {

            Iterator<Element> grades =root.elementIterator();//拿到根节点下的所有的字节点
            while(grades.hasNext()){
                Element grade =grades.next();
                if (grade.attributeValue("name").equals("1班")){
                    root.remove(grade);
                }
            }

            System.out.println("删除成功");
            saveXml();
        }

        private static void update () {
            System.out.println("请输入需要修改的名称：");
            String answer = input.next();
            System.out.println("请输入修改后的名称：");
            String gradeName = input.next();
            Iterator<Element> paters=root.elementIterator();

            while (paters.hasNext()) {
                Element seed=paters.next();
                //找到修改的节点=
                if (seed.attributeValue("name").equals("1班")) {
                    Iterator<Element> pater = seed.elementIterator();
                    while (pater.hasNext()) {
                        Element name = pater.next();
                        if (name.getText().equals(answer)) {
                            name.setText(gradeName);
                        }
                    }
                }
            }
                saveXml();
            }





        private static void saveXml () {
            XMLWriter writer = null;
            OutputFormat format = null;

            try {
                format = OutputFormat.createPrettyPrint();
                writer = new XMLWriter(new FileWriter("src/resources/BdSchool.xml"), format);
                writer.write(document);
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        private static void findAll () {
            Iterator<Element> grades = root.elementIterator();
            while (grades.hasNext()) {
                Element grade = grades.next();
                System.out.println("班级的名称是：" + grade.attributeValue("name"));
                Iterator<Element> classes = grade.elementIterator();
                while (classes.hasNext()) {
                    Element clazz = classes.next();
                    System.out.println("学生的id：" + clazz.attributeValue("id"));
                    if (!clazz.getTextTrim().equals("")){
                        System.out.println("学生是的姓名："+clazz.getTextTrim());
                    }

                }
            }
        }

        public static void getDocument () {

            SAXReader reader = new SAXReader();
            try {
                document = reader.read("src/resources/BdSchool.xml");
                root = document.getRootElement();
            } catch (DocumentException e) {
                e.printStackTrace();
            }
        }
    }
