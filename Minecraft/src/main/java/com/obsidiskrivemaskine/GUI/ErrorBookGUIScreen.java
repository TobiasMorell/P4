package com.obsidiskrivemaskine.GUI;

import com.obsidiskrivemaskine.ObsidiSkriveMaskineMod;
import com.obsidiskrivemaskine.block.ObsidiCodingMachine;
import com.obsidiskrivemaskine.item.ErrorBook;
import compiler.Utility.ErrorHandling;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.renderer.texture.TextureManager;
import net.minecraft.client.resources.I18n;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by morell on 5/16/16.
 */
public class ErrorBookGUIScreen extends GuiScreen {
    private final int book_image_height = 256;
    private final int book_image_width = 256;
    private static ResourceLocation texture;
    public static ErrorBook errorLog;
    public StringBuilder text;
    private boolean pendingErrors = true;

    public ErrorBookGUIScreen()
    {
        texture = new ResourceLocation(ObsidiSkriveMaskineMod.MODID + ":GUI/error_book.png");
        text = new StringBuilder();
    }

    @Override
    public void initGui() {
        buttonList.clear();
        super.initGui();
    }

    @Override
    public void drawScreen(int mouseX, int mouseY, float partialTicks) {
        this.drawDefaultBackground();
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        //Load text to display. As drawScreen is called each tick, pendingScreen is used to avoid the errors being written multiple times
        if(pendingErrors) {
            if (errorLog.errors != null && errorLog.errors.size() > 0) {
                for (String error : errorLog.errors) {
                    text.append(error);
                    text.append("\n");
                }
            } else {
                text.append("No Errors... Yet\n");
            }
            pendingErrors = false;
        }

        mc.getTextureManager().bindTexture(texture);
        int offsetFromScreenLeft = (width - book_image_width) / 2;
        drawTexturedModalRect(offsetFromScreenLeft, 2, 0, 0, book_image_width, book_image_height);

        fontRendererObj.drawSplitString(text.toString(), offsetFromScreenLeft + 36, 34, 200, 0);
        super.drawScreen(mouseX, mouseY, partialTicks);
    }

    @Override
    protected void mouseClicked(int mouseX, int mouseY, int mouseButton) throws IOException {

    }

    @Override
    public void onGuiClosed() {

    }

    @Override
    public boolean doesGuiPauseGame() {
        return false;
    }


}
