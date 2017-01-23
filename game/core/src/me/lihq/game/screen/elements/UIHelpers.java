package me.lihq.game.screen.elements;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;

/**
 * Created by Jason on 23/12/2016.
 */
public class UIHelpers
{
    /**
     * Returns drawable with single colour fill
     *
     * @param color Colour to fill drawable with
     * @return Drawable to use with LibGdx Scene2d controls
     */
    public static Drawable getBackgroundDrawable(Color color, int width, int height)
    {
        Pixmap pixmap = new Pixmap(width, height, Pixmap.Format.RGBA8888);
        pixmap.setColor(color);
        pixmap.fill();
        return new Image(new Texture(pixmap)).getDrawable();
    }

}
