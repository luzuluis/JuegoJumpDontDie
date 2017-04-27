package com.jumpdontdie.actors;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;

/**
 * Created by Luis on 27/04/2017.
 */
public class ActorCaja extends Actor {
    private TextureRegion caja;

    public ActorCaja(TextureRegion caja) {
        this.caja=caja;
        setSize(caja.getRegionWidth(),caja.getRegionHeight());
    }

    @Override
    public void act(float delta) {
        setX(getX()-250*delta);
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        batch.draw(caja,getX(),getY());
    }
}