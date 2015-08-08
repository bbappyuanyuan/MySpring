package support;

import domain.Bean;
import domain.Property;
import org.dom4j.Element;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Zifeng Yuan.
 */
public class Parser {

    public static Bean parseBean(Element element) {
        Bean bean = new Bean();
        bean.setName(element.attributeValue("name"));
        bean.setClazz(element.attributeValue("class"));
        List<Property> properties = new ArrayList<>();
        List<Element> propertyList = element.elements("property");
        for (Element propertyElement : propertyList)
            properties.add(parseProperty(propertyElement));
        bean.setProperties(properties);
        return bean;
    }

    private static Property parseProperty(Element element) {
        Property property = new Property();
        property.setName(element.attributeValue("name"));
        property.setRef(element.attributeValue("ref"));
        property.setValue(element.attributeValue("value"));
        return property;
    }
}
