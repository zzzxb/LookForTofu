package xyz.zzzxb.lft.system;

import com.badlogic.ashley.core.*;
import com.badlogic.ashley.utils.ImmutableArray;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;
import xyz.zzzxb.lft.components.VisualComponent;

/**
 * zzzxb
 * 2024/8/5
 */
public class RenderSystem extends EntitySystem {
    private final SpriteBatch batch;
    private final OrthographicCamera camera;

    private ImmutableArray<Entity> entities;
    private ComponentMapper<VisualComponent> vm = ComponentMapper.getFor(VisualComponent.class);


    public RenderSystem(OrthographicCamera camera) {
        batch = new SpriteBatch();
        this.camera = camera;
    }

    @Override
    public void addedToEngine (Engine engine) {
        entities = engine.getEntitiesFor(Family.all(VisualComponent.class).get());
    }

    @Override
    public void update(float deltaTime) {
        ScreenUtils.clear(Color.BLACK);
        camera.update();

        batch.begin();
        batch.setProjectionMatrix(camera.combined);

        for (Entity entity : entities) {
            VisualComponent visualComponent = vm.get(entity);
            batch.draw(visualComponent.textureRegion, 100, 100);
        }

        batch.end();
    }
}
