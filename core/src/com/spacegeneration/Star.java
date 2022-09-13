package com.spacegeneration;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

import java.util.Random;

public class Star
{
    ShapeRenderer shapeRenderer;
    SpriteBatch batch;
    Random rand;
    int randomX;
    int randomY;
    int randomRadius;
    boolean twinkle;
    double rateOfTwinkle = 1000;
    double start = System.currentTimeMillis();
    double finish;
    double timeElapsed;
    public Star()
    {
        shapeRenderer = new ShapeRenderer();
        rand = new Random();
        randomX = rand.nextInt(Gdx.graphics.getWidth());
        randomY = rand.nextInt(Gdx.graphics.getHeight());
        randomRadius = rand.nextInt(2) + 1;
        twinkle = rand.nextBoolean();
    }

    public void starRenderer()
    {
        finish = System.currentTimeMillis();
        timeElapsed = finish - start;
        shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
        shapeRenderer.setColor(1, 1, 1, 1);
        if (twinkle == true)
        {
            if ((timeElapsed % rateOfTwinkle) == 0)
            {
                randomRadius = rand.nextInt(2) + 1;
                shapeRenderer.circle(randomX, randomY, randomRadius);
            }else
            {
                shapeRenderer.circle(randomX, randomY, randomRadius);
            }

        }else
        {
            shapeRenderer.circle(randomX, randomY, randomRadius);
        }
        shapeRenderer.end();
        rateOfTwinkle = rand.nextInt(1000);
    }

    public void starDispose()
    {
        shapeRenderer.dispose();
    }
}
