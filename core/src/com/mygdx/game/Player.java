package com.mygdx.game;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.Actor;

public class Player extends Actor {
    Rectangle bounds;
    AssetManager manager;
    float speedy, gravity;
    Player()
    {
        setX(200);
        setY(532 / 2 - 600 / 2);
        setSize(288,288);
        bounds = new Rectangle();
        speedy = 0;
        gravity = 850f;
    }
    @Override
    public void act(float delta)
    {
        moveBy(0, speedy * delta);
        speedy -= gravity * delta;
        bounds.set(getX(), getY(), getWidth(), getHeight());
    }
    @Override
    public void draw(Batch batch, float parentAlpha) {
        super.draw(batch, parentAlpha);
        batch.draw(manager.get("bosponja.png", Texture.class),
                getX(), getY());
    }
    public Rectangle getBounds() {
        return bounds;
    }
    public void setManager(AssetManager manager) {
        this.manager = manager;
    }
    void impulso()
    {
        speedy = 400f;
    }
}
