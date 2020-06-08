package framework.util;

import gangz.purchase.domain.request.PurchaseRequest;
import gangz.purchase.domain.request.PurchaseRequestDTO;
import org.apache.commons.beanutils.PropertyUtilsBean;

import java.lang.reflect.InvocationTargetException;

public class ObjectUtil {
    public static void copyProperties(Object dst, Object src)  {
        try {
            new PropertyUtilsBean().copyProperties(dst, src);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
