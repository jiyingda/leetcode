package concurrent.thread005;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class MyClassLoaderTest {

    public static void main(String... args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        MyClassLoader classLoader = new MyClassLoader();

        Class<?> aClass = classLoader.loadClass("concurrent.thread005.HelloWord");
        System.out.println(aClass.getClassLoader());
        Object helloWord = aClass.newInstance();
        System.out.println(helloWord);
        Method wwww = aClass.getMethod("welcom");
        String res = (String) wwww.invoke(helloWord);
        System.out.println(res);

    }
}
