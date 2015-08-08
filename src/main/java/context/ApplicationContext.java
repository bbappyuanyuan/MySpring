package context;

import domain.Bean;
import domain.Property;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import support.Parser;
import support.ReflectUtils;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Zifeng Yuan.
 */
public class ApplicationContext {

    private Map<String, Bean> beanMap;
    private Map<String, Object> objectMap;

    public ApplicationContext(String path) throws Exception {
        beanMap = new HashMap<>();
        objectMap = new HashMap<>();
        SAXReader reader = new SAXReader();
        Document document = reader.read(new File(path));
        List<Element> beanList = document.getRootElement().elements("bean");
        for (Element beanElement : beanList) {
            Bean bean = Parser.parseBean(beanElement);
            beanMap.put(bean.getName(), bean);
        }
    }

    public Object getBean(String name) throws Exception {
        if (objectMap.containsKey(name))
            return objectMap.get(name);
        Bean bean = beanMap.get(name);
        Class<?> clazz = Class.forName(bean.getClazz());
        Object object = clazz.newInstance();
        List<Property> properties = bean.getProperties();
        for (Property property : properties)
            ReflectUtils.setField(object, property.getName(), property.getValue() != null ?
                    property.getValue() : getBean(property.getRef()));
        objectMap.put(name, object);
        return object;
    }
}
