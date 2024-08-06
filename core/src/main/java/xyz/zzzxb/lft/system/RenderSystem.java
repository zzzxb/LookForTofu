package xyz.zzzxb.lft.system;

import com.badlogic.ashley.core.*;
import com.badlogic.ashley.utils.ImmutableArray;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import xyz.zzzxb.lft.components.Mappers;
import xyz.zzzxb.lft.components.PositionComponent;
import xyz.zzzxb.lft.components.VisualComponent;

/**
 * zzzxb
 * 2024/8/5
 */
public class RenderSystem extends EntitySystem {
    private final SpriteBatch batch;
    private final OrthographicCamera camera;

    private ImmutableArray<Entity> entities;


    public RenderSystem(OrthographicCamera camera) {
        this.camera = camera;
        batch = new SpriteBatch();
    }

    @Override
    public void addedToEngine(Engine engine) {
        entities = engine.getEntitiesFor(Family.all(VisualComponent.class, PositionComponent.class).get());
    }

    @Override
    public void update(float deltaTime) {
        VisualComponent vc;
        PositionComponent pc;

        camera.update();
        batch.begin();
        batch.setProjectionMatrix(camera.combined);

        for (Entity entity : entities) {
            vc = Mappers.VISUAL_CM.get(entity);
            pc = Mappers.POSITION_CM.get(entity);
            batch.draw(vc.textureRegion, pc.vector2.x, pc.vector2.y);
        }

        batch.end();
    }
}
