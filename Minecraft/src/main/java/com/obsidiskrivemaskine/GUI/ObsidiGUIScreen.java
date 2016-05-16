package com.obsidiskrivemaskine.GUI;


import compiler.ASTNodes.GeneralNodes.Node;
import compiler.TypeChecking.SymbolTable;
import compiler.Utility.*;
import compiler.Visitors.CodeGeneration.HearCodeVisitor;
import compiler.Visitors.CodeGeneration.NormalCodeVisitor;
import compiler.Visitors.CodeGeneration.RobotCodeVisitor;
import compiler.Visitors.SemanticsVisitor;
import net.minecraft.client.gui.*;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.input.Keyboard;


import javax.tools.*;
import java.io.*;

/**
 * Created by Lee on 06-04-2016.
 */
public class ObsidiGUIScreen extends GuiScreen
{
    private ResourceLocation skrivemaskinegui = new ResourceLocation("obsidiskrivemaskine:GUI/KurtSkriveMaskine.png");
    private StringBuilder text = new StringBuilder();
    private int cursorLocation = 0, saveButton = 0, resetButton = 1, i = 0;
    private char cursor = '_'; // cursor symbol
    private File obsidiFile;
    private FileWriter obsidiFileWriter;
    private FileReader obsidiFileReader;
    private ObsidiGuiTextArea textbox = new ObsidiGuiTextArea();
    private String robotName;

    @Override
    public void initGui() {
        obsidiFile = new File(System.getProperty("user.dir") + "/ObsidiCode/Test/SimpleMiner.oc");
        this.buttonList.add(new GuiButton(saveButton, this.width / 2 + 5, this.height / 2 + 125, 100, 20, "Save and Exit"));
        this.buttonList.add(new GuiButton(resetButton, this.width / 2 - 105, this.height / 2 + 125, 100, 20, "Reset"));
        loadFile();
        if (!text.toString().contains("_") && text.toString().equals(""))
            text.append(cursor);
        cursorLocation = text.length() - 1;
        super.initGui();
    }

    @Override
    protected void actionPerformed(GuiButton button) throws IOException {
        switch(button.id) {
            case 0:
                /* Closes screen and saves editor text to "DynamicClass.java" in the run folder */
                mc.thePlayer.closeScreen();
                text.deleteCharAt(cursorLocation);
                saveFile();
                //Todo call compiler from this location + load classes
                try{compileOC(robotName + ".oc");}
                catch(Exception e){
                    e.printStackTrace();
                }
                //compile();
                loadRobot();
                break;
            case 1:
                text = text.delete(0, text.toString().length());
                cursorLocation = 0;
                break;
            default:
                break;
        }

        super.actionPerformed(button);
    }

    public static void compileOC(String args) throws Exception {
        AntlrASTBuilder var14 = new AntlrASTBuilder();
        Node var15 = var14.Compile(args);
        if(var15 != null) {
            new SymbolTable(var15);
            SemanticsVisitor smv = new SemanticsVisitor();
            smv.visit(var15);
            JavaKeywordSheet jsk = new JavaKeywordSheet();
            NormalCodeVisitor jcv = new NormalCodeVisitor(jsk);
            HearCodeVisitor hcv = new HearCodeVisitor(jsk);
            RobotCodeVisitor rcv = new RobotCodeVisitor(jsk);
            jcv.visit(var15);
            hcv.visit(var15);
            rcv.visit(var15);
            JavaSourceBuffer[] sourceCode = new JavaSourceBuffer[]{jcv.GetSourceCode(), hcv.GetSourceCode(), rcv.GetSourceCode()};
            JavaSourceBuffer[] jsc = sourceCode;
            int len$ = sourceCode.length;

            for(int i$ = 0; i$ < len$; ++i$) {
                JavaSourceBuffer code = jsc[i$];
                JavaSourcePrinter.PrintSource(code);
            }

            JavaSourceCompiler var16 = new JavaSourceCompiler();
            var16.CompileJavaSource(sourceCode);
        } else {
            System.out.println("The root was null; could not compile!");
        }

        ErrorHandling.printErrors();
    }

    void loadRobot(){
        ClassLoader parentClassLoader = DynamicClassLoader.class.getClassLoader();
        DynamicClassLoader newClassLoader = new DynamicClassLoader(parentClassLoader);
        String classFile = String.format(System.getProperty("user.dir") + "/saves/CompiledSources/" + robotName + "NormalThread.class");
        System.out.println("ClassFile = " + classFile);
        try{newClassLoader.loadClass(robotName + "NormalThread", classFile);}
        catch(Exception e){
            e.printStackTrace();
            System.out.println("Failed to load NormalThread class");
        }
        classFile = String.format(System.getProperty("user.dir") + "/saves/CompiledSources/" + robotName + "HearThread.class");
        System.out.println("ClassFile = " + classFile);
        try{newClassLoader.loadClass(robotName + "HearThread", classFile);}
        catch(Exception e){
            e.printStackTrace();
            System.out.println("Failed to load HearThread class");
        }
        classFile = String.format(System.getProperty("user.dir") + "/saves/CompiledSources/" + robotName + "Robot.class");
        System.out.println("ClassFile = " + classFile);
        try{newClassLoader.loadClass(robotName + "Robot", classFile).newInstance();}
        catch(Exception e){
            e.printStackTrace();
            System.out.println("Failed to load Robot class");
        }
    }

    void compile(){
        JavaCompiler JC = ToolProvider.getSystemJavaCompiler();
        JC.run(null, null, null, "Test.java");
    }

    void saveFile(){
        File testFile = new File(robotName + ".oc");
        try {
            obsidiFileWriter = new FileWriter(testFile);
            obsidiFileWriter.write(text.toString());
            obsidiFileWriter.flush();
            obsidiFileWriter.close();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    void loadFile(){
        if(text.toString().equals("")) {
            try {
                obsidiFileReader = new FileReader(obsidiFile);
                BufferedReader br = new BufferedReader(obsidiFileReader);
                boolean firstLine = true;
                for (String line = br.readLine(); line != null; line = br.readLine()) {
                    text.append(line + '\n');
                    if(firstLine)
                    {
                        robotName = line.replace(":", "");
                        firstLine = false;
                    }
                }

                obsidiFileReader.close();
            } catch (Exception e) {
                System.out.println("Could not load file");
            }
        }
    }
    @Override
    public void drawScreen(int mouseX, int mouseY, float partialTicks) {
        this.drawDefaultBackground();

        mc.getTextureManager().bindTexture(skrivemaskinegui);

        this.drawTexturedModalRect(this.width / 2 - 128, this.height / 2 - 128, 0, 0, 256, 256);


        /* this is where the editor reads keys and writes to the screen */
        if (org.lwjgl.input.Keyboard.getEventKeyState()) {
             //
            if (isAllowedDeletion())
            {
                text.deleteCharAt(cursorLocation);
                cursorLocation--;
                text.deleteCharAt(cursorLocation);
                text.insert(cursorLocation, cursor); // moving cursor
            } else if (isAllowedNewLine()) {
                text.deleteCharAt(cursorLocation);
                text.insert(cursorLocation,'\n');
                cursorLocation++;
                text.insert(cursorLocation, cursor); // moving cursor
            } else if (isAllowedLeftArrowNavigation()){
                text.deleteCharAt(cursorLocation);
                cursorLocation--;
                text.insert(cursorLocation, cursor); // moving cursor

            } else if (isAllowedRightArrowNavigation()) {
                text.deleteCharAt(cursorLocation);
                cursorLocation++;
                text.insert(cursorLocation, cursor); // moving cursor

            } else if(Keyboard.getEventKey() == Keyboard.KEY_TAB){
                text.deleteCharAt(cursorLocation);
                for (int i = 0; i < 3; i++)
                {
                    text.insert(cursorLocation, " ");
                    cursorLocation++;
                }
                text.insert(cursorLocation, cursor); // moving cursor

            } else {
                if (isAllowedCharacters())
                {
                   // System.out.println(org.lwjgl.input.Keyboard.getEventKey());
                    text.deleteCharAt(cursorLocation);
                    text.insert(cursorLocation, org.lwjgl.input.Keyboard.getEventCharacter());
                    cursorLocation++;
                    text.insert(cursorLocation, cursor); // moving cursor
                }
            }

            org.lwjgl.input.Keyboard.destroy();
        } else if (!org.lwjgl.input.Keyboard.isCreated()) {
            try {
                org.lwjgl.input.Keyboard.create();
            } catch (Exception e)
            {}
        }

        /* writes the text string to the screen */
        textbox.drawSplitLines(text.toString(), this.width / 2 - 118, this.height / 2 -119, 238 , 0xFFFFF0);

        super.drawScreen(mouseX, mouseY, partialTicks);
    }

    /* returns true if pressed button is allowed for "writing" */
    private boolean isAllowedCharacters ()
    {
        if ( (org.lwjgl.input.Keyboard.getEventKey() != org.lwjgl.input.Keyboard.KEY_BACK)
                && (org.lwjgl.input.Keyboard.getEventKey() != org.lwjgl.input.Keyboard.KEY_LEFT )
                && (org.lwjgl.input.Keyboard.getEventKey() != org.lwjgl.input.Keyboard.KEY_RIGHT)
                && (org.lwjgl.input.Keyboard.getEventKey() != org.lwjgl.input.Keyboard.KEY_UP)
                && (org.lwjgl.input.Keyboard.getEventKey() != org.lwjgl.input.Keyboard.KEY_DOWN)
                && (org.lwjgl.input.Keyboard.getEventKey() != org.lwjgl.input.Keyboard.KEY_RSHIFT)
                && (org.lwjgl.input.Keyboard.getEventKey() != org.lwjgl.input.Keyboard.KEY_LSHIFT)
                && (org.lwjgl.input.Keyboard.getEventKey() != org.lwjgl.input.Keyboard.KEY_RCONTROL)
                && (org.lwjgl.input.Keyboard.getEventKey() != org.lwjgl.input.Keyboard.KEY_LCONTROL)
                && (org.lwjgl.input.Keyboard.getEventKey() != org.lwjgl.input.Keyboard.KEY_RMENU)
                && (org.lwjgl.input.Keyboard.getEventKey() != org.lwjgl.input.Keyboard.KEY_RMETA)
                && (org.lwjgl.input.Keyboard.getEventKey() != org.lwjgl.input.Keyboard.KEY_LMETA)
                && (org.lwjgl.input.Keyboard.getEventKey() != org.lwjgl.input.Keyboard.KEY_LMENU))
            return true;
        else
            return false;
    }

    /* returns true if the users right arrow navigation is allowed */
    private boolean isAllowedRightArrowNavigation ()
    {
        if (org.lwjgl.input.Keyboard.getEventKey() == org.lwjgl.input.Keyboard.KEY_RIGHT && cursorLocation < text.length() - 1)
            return true;
        else
            return false;
    }

    /* returns true if the users left arrow navigation is allowed */
    private boolean isAllowedLeftArrowNavigation ()
    {
        if (org.lwjgl.input.Keyboard.getEventKey() == org.lwjgl.input.Keyboard.KEY_LEFT  && cursorLocation > 0)
            return true;
        else
            return false;
    }

    /* returns true if the key press is the return key */
    private boolean isAllowedNewLine ()
    {
        if (org.lwjgl.input.Keyboard.getEventKey() == org.lwjgl.input.Keyboard.KEY_RETURN)
            return true;
        else
            return false;
    }

    /* returns true if deletion is allowed */
    private boolean isAllowedDeletion()
    {
        if ( (org.lwjgl.input.Keyboard.getEventKey() == org.lwjgl.input.Keyboard.KEY_BACK) && (text.length() > 1) && (cursorLocation > 0) )
            return true;
        else
            return false;
    }
}
