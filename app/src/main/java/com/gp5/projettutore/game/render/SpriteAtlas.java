package com.gp5.projettutore.game.render;

import com.gp5.projettutore.game.render.shapes.TexturedCameraAlignedQuad;

/**
 * Created by Valentin on 05/10/2015.
 */
public class SpriteAtlas
{
    private Texture texture;
    private int gridWidth;
    private int gridHeight;
    private int columnAmount;
    private int rowAmount;

    private TexturedCameraAlignedQuad[] quadList;
    private int currentFrame;

    public SpriteAtlas(Texture texture, int gridWidth, int gridHeight, int columnAmount, int rowAmount, int sX, int sY, boolean alignX)
    {
        this.texture = texture;
        this.gridWidth = gridWidth;
        this.gridHeight = gridHeight;
        this.columnAmount = columnAmount;
        this.rowAmount = rowAmount;
        this.quadList = new TexturedCameraAlignedQuad[columnAmount * rowAmount];

        for(int i = 0;i < quadList.length;i++)
        {
            int gridX = i % columnAmount * gridWidth;
            int gridY = i / columnAmount * gridHeight;

            quadList[i] = new TexturedCameraAlignedQuad(texture, sX, sY, gridX, gridY, gridX + gridWidth, gridY + gridHeight, alignX);
        }
    }

    public void renderFrame(float x, float z)
    {
        quadList[currentFrame].draw(x, z);
    }

    public void nextFrame()
    {
        currentFrame = (++currentFrame) % (columnAmount * rowAmount);
    }

    public void setFrame(int x, int y)
    {
        setFrame(y * columnAmount + x);
    }

    public void setFrame(int frame)
    {
        currentFrame = frame;
    }

    public int getCurrentFrame()
    {
        return currentFrame;
    }
}
