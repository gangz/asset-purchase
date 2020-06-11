package framework.util;


import org.apache.commons.beanutils.PropertyUtilsBean;

public class ObjectUtil {
    public static void copyProperties(Object dst, Object src)  {
        try {
            new PropertyUtilsBean().copyProperties(dst, src);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
