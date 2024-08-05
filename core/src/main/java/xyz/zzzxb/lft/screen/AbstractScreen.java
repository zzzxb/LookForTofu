package xyz.zzzxb.lft.screen;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Screen;

/**
 * zzzxb
 * 2024/8/5
 */
public abstract class AbstractScreen implements Screen {
    protected Game game;

    public AbstractScreen(Game game) {
        this.game = game;
    }

    @Override
    public abstract void show();

    @Override
    public abstract void render(float delta);

    @Override
    public void resize(int width, int height) {
    }

    @Override
    public void hide() {
    }

    @Override
    public void dispose() {
    }

    @Override
    public void pause() {
    }

    @Override
    public void resume() {
    }


}
