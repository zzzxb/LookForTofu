package xyz.zzzxb.lft.components;

import com.badlogic.ashley.core.Component;
import com.badlogic.gdx.math.Vector2;

/**
 * zzzxb
 * 2024/8/6
 */
public class PositionComponent implements Component {
    public Vector2 vector2;

    public PositionComponent(float x, float y) {
        this.vector2 = new Vector2(x, y);
    }
}
