package com.obsidiskrivemaskine.GUI;

import com.obsidiskrivemaskine.ObsidiSkriveMaskineMod;
import com.obsidiskrivemaskine.block.ObsidiCodingMachine;
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
    private final int book_image_height = 250;
    private final int book_image_width = 250;
    private static String pageText;
    private static ResourceLocation texture;
    private boolean textureBound = false;

    public ErrorBookGUIScreen()
    {
        texture = new ResourceLocation(ObsidiSkriveMaskineMod.MODID + ":GUI/error_book.png");
    }

    @Override
    public void initGui() {
        buttonList.clear();
    }

    @Override
    public void drawScreen(int mouseX, int mouseY, float partialTicks) {
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);

        //Load text to display
        ArrayList<String> errors = ObsidiCodingMachine.recentErrors;
        if(errors != null && errors.size() > 0)
            for(String error : errors)
                pageText += error;
        else
            pageText = "No errors! Good job.";

        mc.getTextureManager().bindTexture(texture);
        int offsetFromScreenLeft = (width - book_image_width) / 2;
        drawTexturedModalRect(offsetFromScreenLeft, 2, 0, 0, book_image_width, book_image_height);

        fontRendererObj.drawSplitString(pageText, offsetFromScreenLeft + 36, 34, 116, 0);

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
        return true;
    }


}
