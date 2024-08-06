package xyz.zzzxb.lft.screen;


import com.badlogic.ashley.core.Component;
import com.badlogic.ashley.core.Engine;
import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.core.PooledEngine;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.utils.ScreenUtils;
import xyz.zzzxb.lft.components.Mappers;
import xyz.zzzxb.lft.components.PositionComponent;
import xyz.zzzxb.lft.components.VisualComponent;
import xyz.zzzxb.lft.config.Config;
import xyz.zzzxb.lft.system.RenderSystem;

public class GameScreen extends AbstractScreen {
    Engine engine;
    OrthographicCamera camera;

    public GameScreen(Game game) {
        super(game);
    }

    @Override
    public void show() {
        engine = new PooledEngine();
        camera = new OrthographicCamera();
        camera.setToOrtho(false, Config.SCREEN_WIDTH / 2f, Config.SCREEN_HEIGHT / 2f);

        engine.addSystem(new RenderSystem(camera));

        Texture playerTexture = new Texture("hero.png");
        Texture monsterTexture = new Texture("monster.png");

        Entity playerEntity = engine.createEntity();
        playerEntity.add(new VisualComponent(new TextureRegion(playerTexture)));
        playerEntity.add(new PositionComponent(100, 100));
        engine.addEntity(playerEntity);

        Entity monsterEntity = engine.createEntity();
        playerEntity.add(new VisualComponent(new TextureRegion(monsterTexture)));
        playerEntity.add(new PositionComponent(200, 100));
        engine.addEntity(monsterEntity);
    }

    @Override
    public void render(float delta) {
        ScreenUtils.clear(Color.BLACK);
        engine.update(delta);
    }
}
