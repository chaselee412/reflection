package com.reflection01;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Properties;

public class ReflectDemo1 {
    public static void main(String[] args) throws IOException, ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {

//        //获取系统类加载器，加载prop.properties文件
//        InputStream is = ClassLoader.getSystemClassLoader().getResourceAsStream("prop.properties");
//        //创建Properties集合
//        Properties prop = new Properties();
//        //将文件中的数据读取到集合当中
//        prop.load(is);
//        //System.out.println(prop);
//        is.close();



//        //1.class 类中的静态方法forname("全类名"src以下路径)  包名+类名，可直接右键Student类copy reference
//        Class clazz = Class.forName("com.reflection01.Student");
//        System.out.println(clazz);
//        //通过class属性来获取
//        Class clazz2 = Student.class;
//        System.out.println(clazz2);
//        //利用对象的getclass方法来获取class的对象
//        Student s = new Student();
//        Class clazz3 = s.getClass();
//        System.out.println(clazz3);
//        System.out.println(clazz==clazz2);
//        System.out.println(clazz2==clazz3);

        //获取class对象
        //method1();
        //method2();
        Class clazz = Class.forName("com.reflection01.Student");
        Constructor constructor1 = clazz.getConstructor();
        System.out.println(constructor1);
        Constructor constructor2 = clazz.getConstructor(String.class, int.class);   //只有int构造的话会报错因为该构造器不存在
        System.out.println(constructor2);
        Class clazz1 = Class.forName("com.reflection01.Student");


        //--------下面的代码就是利用反射创建对象并调用方法---------------------
        /*
        //获取字节码文件对象
        Class clazz = Class.forName(prop.getProperty("className"));
        //获取构造器对象
        Constructor constructor = clazz.getConstructor();
        //利用构造器对象创建一个对象
        Object o = constructor.newInstance();
        //获取方法对象
        Method method = clazz.getMethod(prop.getProperty("methodName"));
        //运行方法
        method.invoke(o);*/
    }

    private static void method2() throws ClassNotFoundException {
        Class clazz = Class.forName("com.reflection01.Student");
        Constructor[] constructors = clazz.getDeclaredConstructors();
        for (Constructor constructor : constructors) {
            System.out.println(constructor);
        }
    }

    private static void method1() throws ClassNotFoundException {
        Class clazz = Class.forName("com.reflection01.Student");
        Constructor[] constructors = clazz.getConstructors();
        for (Constructor constructor : constructors) {
            System.out.println(constructor);
        }
    }
}
