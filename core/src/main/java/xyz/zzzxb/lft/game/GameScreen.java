package xyz.zzzxb.lft.game;

import com.badlogic.ashley.core.*;
import com.badlogic.gdx.*;
import com.badlogic.gdx.graphics.*;
import com.badlogic.gdx.utils.*;
import xyz.zzzxb.lft.*;


/**
 * @author zzzxb
 * 2024/9/29
 */
public class GameScreen extends AbstractScreen {
    private Engine engine;

    public GameScreen(LFTMain game){
        super(game);
    }

    @Override
    public void show(){
        Gdx.app.log("[当前屏幕] - {}", "游戏");
        engine = new PooledEngine();
    }

    @Override
    public void render(float delta){
        ScreenUtils.clear(Color.BLACK);
        engine.update(delta);
    }
}
