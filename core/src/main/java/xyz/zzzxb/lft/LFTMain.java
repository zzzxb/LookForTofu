package xyz.zzzxb.lft;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.*;
import xyz.zzzxb.lft.game.*;

public class LFTMain extends Game {
    public SpriteBatch batch;

    @Override
    public void create() {
        batch = new SpriteBatch();
        setScreen(new MenuScreen(this));
    }

    @Override
    public void dispose(){
        batch.dispose();
    }
}
