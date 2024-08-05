package xyz.zzzxb.lft.components;

import com.badlogic.ashley.core.Component;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

/**
 * zzzxb
 * 2024/8/5
 */
public class VisualComponent implements Component {
    public TextureRegion textureRegion;

    public VisualComponent(TextureRegion textureRegion) {
        this.textureRegion = textureRegion;
    }
}
