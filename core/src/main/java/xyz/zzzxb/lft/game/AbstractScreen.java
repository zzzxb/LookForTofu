package xyz.zzzxb.lft.game;

import com.badlogic.gdx.*;
import xyz.zzzxb.lft.*;

/**
 * @author zzzxb
 * 2024/9/29
 */
public abstract class AbstractScreen implements Screen {
    protected LFTMain game;

    public AbstractScreen(LFTMain game){
        this.game = game;
    }

    @Override
    public abstract void show();

    @Override
    public abstract void render(float delta);

    @Override
    public void hide(){};

    @Override
    public void dispose(){};

    @Override
    public void resize(int width, int height){
    }

    @Override
    public void pause(){

    }

    @Override
    public void resume(){

    }
}
