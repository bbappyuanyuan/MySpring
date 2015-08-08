package domain;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Zifeng Yuan.
 */
public class Bean {

    private String name;
    private String clazz;
    private List<Property> properties;

    public Bean() {
        name = null;
        clazz = null;
        properties = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getClazz() {
        return clazz;
    }

    public void setClazz(String clazz) {
        this.clazz = clazz;
    }

    public List<Property> getProperties() {
        return properties;
    }

    public void setProperties(List<Property> properties) {
        this.properties = properties;
    }

    @Override
    public String toString() {
        return "Bean{" +
                "name='" + name + '\'' +
                ", clazz='" + clazz + '\'' +
                ", properties=" + properties +
                '}';
    }
}
