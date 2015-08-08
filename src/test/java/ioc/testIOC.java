package ioc;

import context.ApplicationContext;
import domain.Bean;
import org.junit.Test;
import service.Fly;
import service.Run;
import service.Walk;
import support.ReflectUtils;

import java.util.Map;

/**
 * Created by Zifeng Yuan.
 */
public class testIOC {

    @Test
    public void testApplicationContext() throws Exception {
        ApplicationContext applicationContext = new ApplicationContext
                ("src/resources/applicationContext.xml");
        Map<String, Bean> beanMap = (Map<String, Bean>) ReflectUtils.getField(applicationContext,
                "beanMap");
        for (Map.Entry<String, Bean> entry : beanMap.entrySet())
            System.out.println(entry.getKey() + " : " + entry.getValue());
    }

    @Test
    public void testGetBean() throws Exception {
        ApplicationContext applicationContext = new ApplicationContext
                ("src/resources/applicationContext.xml");
        Walk walk = (Walk) applicationContext.getBean("walk");
        Run run = (Run) applicationContext.getBean("run");
        Fly fly = (Fly) applicationContext.getBean("fly");
        System.out.println(walk.getClass());
        System.out.println(run.getClass());
        System.out.println(fly.getClass());
        walk.go();
        run.go();
        fly.go();
    }
}
