package com.obsidiskrivemaskine.GUI;


import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.MalformedURLException;

/**
 * Created by esben on 14/04/16.
 */
public class DynamicClassLoader extends ClassLoader{

    public DynamicClassLoader(ClassLoader parent) {
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
                System.out.println("Printing Data: " + data);
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
}
