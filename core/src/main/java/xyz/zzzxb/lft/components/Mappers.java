package xyz.zzzxb.lft.components;

import com.badlogic.ashley.core.ComponentMapper;

/**
 * zzzxb
 * 2024/8/6
 */
public final class Mappers {
    public static final ComponentMapper<VisualComponent> VISUAL_CM;
    public static final ComponentMapper<PositionComponent> POSITION_CM;

    static {
        VISUAL_CM = ComponentMapper.getFor(VisualComponent.class);
        POSITION_CM = ComponentMapper.getFor(PositionComponent.class);
    }

    private Mappers() {}
}
