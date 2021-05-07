package com.leetcode;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 1.查找内容包含关键字“SUCCESS”的所有文件的名字
 *
 * @author clown
 * @version 1.0
 * @date 2021/5/6 12:25
 */
public class Demo {
    String target = "SUCCESS";
    Pattern pattern = Pattern.compile(target);

    public static void main(String[] args) {
        Demo demo = new Demo();
        List<String> listFiles = demo.traverseFolder2("E:\\annaconda\\bin");
        List<String> res = demo.containsContext();
        for (String re : res) {
            System.out.println("re = " + re);
        }

    }

    public List<String> containsContext() {
        List<String> res = new ArrayList<>();
        for (String listFile : listFiles) {
            try {
                BufferedReader in = new BufferedReader(new FileReader(listFile));
                String str;
                while ((str = in.readLine()) != null) {
                    if (wordMatcher(str)) {
                        res.add(listFile);
                        break;
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return res;
    }

    public boolean wordMatcher(String line) {
        Matcher matcher = pattern.matcher(line);
        boolean success = matcher.find();
        return success;
    }

    List<String> listFiles = new ArrayList<>();

    public List<String> traverseFolder2(String path) {

        File file = new File(path);
        if (file.exists()) {
            File[] files = file.listFiles();
            if (null == files || files.length == 0) {
                System.out.println("文件夹是空的!");
                return null;
            } else {
                for (File file2 : files) {
                    if (file2.isDirectory()) {
                        traverseFolder2(file2.getAbsolutePath());
                    } else {
                        System.out.println("文件:" + file2.getAbsolutePath());
                        listFiles.add(file2.getAbsolutePath());
                    }
                }
            }
        } else {
            System.out.println("文件不存在!");
        }
        return listFiles;
    }

    class A {
        private int demo = 1;
    }

    @Test
    public void test() throws NoSuchFieldException {
        A a = new A();
        Object value = getAttributeValue(a, "demo");
        Field demo = a.getClass().getDeclaredField("demo");
        System.out.println(demo.getName());
        System.out.println(value);
    }

    /**
     * 获取对象属性值
     *
     * @param obj
     * @param attName
     * @return
     */
    public static Object getAttributeValue(Object obj, String attName) {
        Field field = null;
        Object value = null;
        try {
            field = obj.getClass().getDeclaredField(attName);
            // 强制访问private变量
            field.setAccessible(true);
            value = field.get(obj);
        } catch (Exception e) {
            System.out.println(obj.getClass().getName() + " no such field:" + attName);
            try {
                field = obj.getClass().getSuperclass().getDeclaredField(attName);
                // 强制访问private变量
                field.setAccessible(true);
                value = field.get(obj);
            } catch (Exception e2) {
                System.out.println(obj.getClass().getSuperclass().getName() + "no such field:" + attName);
            }

        }
        return value;

    }

}
