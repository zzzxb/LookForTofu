package xyz.zzzxb.lft.screen;

import com.badlogic.gdx.Game;

/**
 * zzzxb
 * 2024/8/5
 */
public class MenuScreen extends AbstractScreen {
    public MenuScreen(Game game) {
        super(game);
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {

    }

    @Override
    public void hide() {
        super.game.setScreen(new GameScreen(game));
    }
}
