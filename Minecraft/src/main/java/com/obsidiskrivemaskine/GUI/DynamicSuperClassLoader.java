package com.obsidiskrivemaskine.GUI;

import com.obsidiskrivemaskine.SyncRobot;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

/**
 * Created by esben on 14/04/16.
 */
public class DynamicSuperClassLoader extends ClassLoader{

    public DynamicSuperClassLoader(ClassLoader parent) {
        super(parent);
    }

    public Class loadClass(String name, String filepath) throws ClassNotFoundException {
        try {
            FileInputStream input = new FileInputStream(filepath);
            ByteArrayOutputStream buffer = new ByteArrayOutputStream();
            int data = input.read();

            while(data != -1){
                buffer.write(data);
                data = input.read();
            }

            input.close();

            byte[] classData = buffer.toByteArray();

            return defineClass(name, classData, 0, classData.length);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    public static SyncRobot newClassLoader(String className, String filepath) {
        ClassLoader parentClassLoader = DynamicSuperClassLoader.class.getClassLoader();
        DynamicSuperClassLoader classLoader;
        classLoader = new DynamicSuperClassLoader(parentClassLoader);
        try {
            Class <? extends SyncRobot> clas = classLoader.loadClass(className, filepath);
            SyncRobot sr = clas.newInstance();
            return sr;
        }
        catch (Exception e){
            System.out.println("Class loading failed");
            e.printStackTrace();
            return null;
        }
    }

}
