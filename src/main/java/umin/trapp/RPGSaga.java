package umin.trapp;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class RPGSaga {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context=new ClassPathXmlApplicationContext("applicationContext.xml");

        Process process=context.getBean("Process",Process.class);

        process.getInfoAboutWarriorsCollection();

        context.close();
    }
}