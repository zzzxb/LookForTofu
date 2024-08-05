package xyz.zzzxb.lft;

import com.badlogic.gdx.Game;
import xyz.zzzxb.lft.screen.GameScreen;

public class GameMain extends Game {
    @Override
    public void create() {
        setScreen(new GameScreen(this));
    }
}
