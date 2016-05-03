package com.obsidiskrivemaskine.GUI;

import com.obsidiskrivemaskine.AbstractRobot;
import com.obsidiskrivemaskine.SyncRobot;

import javax.tools.JavaCompiler;
import javax.tools.ToolProvider;
import java.lang.reflect.Method;

/**
 * Created by esben on 14/04/16.
 */
public class Compiler {
    public void inputTask(String fileToCompile) {
        JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();

        int compilationResult = compiler.run(null, null, null, fileToCompile);

        if (compilationResult == 0) {
            LoadClass();
        } else {
            AbstractRobot.talk("Compilation Failed");
        }
    }


    public void LoadClass(){
        try
        {
            /* Should not be necessary.*/
            Class[] argTypes = new Class[1];
            argTypes[0] = String[].class;

            SyncRobot syncRobot = newClassLoader();
            Method mainMethod = syncRobot.getClass().getDeclaredMethod("run");
            //mainMethod.invoke(syncRobot);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    public static SyncRobot newClassLoader() {
        ClassLoader parentClassLoader = DynamicSuperClassLoader.class.getClassLoader();
        DynamicSuperClassLoader classLoader;
        classLoader = new DynamicSuperClassLoader(parentClassLoader);
        try {
            Class <? extends SyncRobot> clas = classLoader.loadClass("DynamicClass");
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
