package utils;

import java.sql.Date;
import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.locale.converters.DateLocaleConverter;

//将request中的数据封装到bean中(参数T类的对象clazz)
public class WebUtils {
	
	public static<T> T requestToBean(HttpServletRequest request, Class<T> clazz){
		
		try {
			T t = clazz.newInstance();
			ConvertUtils.register(new DateLocaleConverter(), Date.class);//register a Date converter
			Enumeration e = request.getParameterNames(); //get all parameter names
			while(e.hasMoreElements()){
				String name = (String) e.nextElement();
				String value = request.getParameter(name);
				BeanUtils.setProperty(t, name, value);
			}
			return t;
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} 
	}
}
