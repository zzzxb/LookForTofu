package xyz.zzzxb.lft.system;

import com.badlogic.ashley.core.*;
import com.badlogic.gdx.graphics.g2d.*;

/**
 * @author zzzxb
 * 2024/9/30
 */
public class RenderSystem extends EntitySystem{
    private SpriteBatch batch;

    @Override
    public void update(float deltaTime){
        batch.begin();
        batch.end();
    }
}
