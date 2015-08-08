package support;

import org.apache.commons.beanutils.ConvertUtils;

import java.lang.reflect.Field;

/**
 * Created by Zifeng Yuan.
 */
public class ReflectUtils {

    public static Object getField(Object object, String name) throws Exception {
        Field field = object.getClass().getDeclaredField(name);
        field.setAccessible(true);
        return field.get(object);
    }

    public static void setField(Object object, String name, Object value) throws Exception {
        Field field = object.getClass().getDeclaredField(name);
        field.setAccessible(true);
        field.set(object, ConvertUtils.convert(value, field.getType()));
    }
}
