package org.jikebang.demo.week01;

import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.reflect.MethodUtils;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class HelloClassLoader extends ClassLoader {

    private static final String path = "/Users/mac/idea_projects/learning/java-learning/";

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {

        try {
            InputStream is = new FileInputStream(path + name + ".xlass");
            byte[] bytes = IOUtils.toByteArray(is);
            for (int i = 0; i < bytes.length; i++) {
                // 对原加密的字节进行换算处理
                bytes[i] = (byte)(255 - bytes[i]);
            }
            return defineClass(name, bytes, 0, bytes.length);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return super.loadClass(name);
    }

    public static void main(String[] args) {
        try {
            HelloClassLoader helloClassLoader = new HelloClassLoader();
            Class<?> cls = helloClassLoader.loadClass("Hello");
            // 最终结果输出"Hello, classLoader!"
            MethodUtils.invokeMethod(cls.newInstance(), "hello");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
