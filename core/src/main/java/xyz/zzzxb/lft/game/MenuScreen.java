package xyz.zzzxb.lft.game;


import com.badlogic.gdx.*;
import com.badlogic.gdx.graphics.*;
import com.badlogic.gdx.graphics.g2d.*;
import com.badlogic.gdx.math.*;
import com.badlogic.gdx.scenes.scene2d.*;
import com.badlogic.gdx.scenes.scene2d.ui.*;
import com.badlogic.gdx.scenes.scene2d.ui.Button.*;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton.*;
import com.badlogic.gdx.scenes.scene2d.utils.*;
import com.badlogic.gdx.utils.*;
import com.badlogic.gdx.utils.viewport.*;
import xyz.zzzxb.lft.*;


/**
 * @author zzzxb
 * 2024/9/29
 */
public class MenuScreen extends AbstractScreen{
    private OrthographicCamera camera;
    private Skin skin;
    private TextureRegion[] logos;
    private int activeLogo;
    private boolean logoOut;
    private int logoOutY;
    private boolean animationPull;
    private Stage stage;
    private ImageButton beginButton;
    private ScreenViewport screenViewport;

    public MenuScreen(LFTMain game){
        super(game);
    }

    @Override
    public void show(){
        Gdx.app.log("[当前屏幕] - {}", "菜单");
        game.batch = new SpriteBatch();
        camera = new OrthographicCamera();
        camera.setToOrtho(false, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        camera.position.x = 0;
        camera.position.y = 0;
        skin = new Skin(new TextureAtlas("atlas/menu.atlas"));
        screenViewport = new ScreenViewport();
        stage = new Stage(screenViewport, game.batch);
        Gdx.input.setInputProcessor(stage);

        logos = new TextureRegion[]{
            skin.getRegion("spring"),
            skin.getRegion("summer"),
            skin.getRegion("autumn"),
            skin.getRegion("winter"),
        };
        activeLogo = MathUtils.random(logos.length - 1);
        beginButton = new ImageButton(
            new TextureRegionDrawable(skin.getRegion("begin-up")),
            new TextureRegionDrawable(skin.getRegion("begin-down")),
            new TextureRegionDrawable(skin.getRegion("begin-checked"))
        );
        beginButton.setPosition(Gdx.graphics.getWidth() / 2f - beginButton.getWidth() / 2f, beginButton.getHeight() * 3);
        stage.addActor(beginButton);
    }

    @Override
    public void render(float delta){
        ScreenUtils.clear(Color.WHITE);
        stage.act();
        stage.draw();
        camera.update();
        game.batch.setProjectionMatrix(camera.combined);

        game.batch.begin();
        TextureRegion logo = logos[activeLogo];
        game.batch.draw(logo, ((Gdx.graphics.getWidth() / 2f) - (logo.getRegionWidth() / 2f)), fadeAway(logo.getRegionHeight()));
        if(beginButton.isOver()){
            TextureRegion selectL = skin.getRegion("select");
            game.batch.draw(selectL, beginButton.getX() - selectL.getRegionWidth() - 5, beginButton.getY());
            TextureRegion selectR = new TextureRegion(selectL);
            selectR.flip(true, false);
            game.batch.draw(selectR, beginButton.getX() + beginButton.getWidth() + 5, beginButton.getY());
        }
        game.batch.end();

        if(!logoOut && beginButton.isChecked()){
            Gdx.app.log("[按钮点击] - {}", "开始游戏");
            logoOut = true;
        }
    }

    public int fadeAway(int logoHeight){
        int logoY = Gdx.graphics.getHeight() - logoHeight * 2;
        if(!logoOut){
            return logoY;
        }

        if(!animationPull && logoOutY > -logoHeight / 2){
            logoOutY -= 4;
        }else{
            animationPull = true;
            logoOutY += 5;
        }

        if(logoOutY + logoY >= Gdx.graphics.getHeight()){
            Gdx.app.log("[切换屏幕] - {}", "切换到游戏界面");
            game.setScreen(new GameScreen(game));
        }

        return logoY + logoOutY;
    }

    @Override
    public void resize(int width, int height){
        camera.setToOrtho(false, width, height);
        screenViewport.setScreenSize(width, height);
        beginButton.setPosition(width / 2f - beginButton.getWidth() / 2f, beginButton.getHeight() * 3);
    }

    @Override
    public void hide(){
        dispose();
    }

    @Override
    public void dispose(){
        stage.dispose();
        skin.dispose();
    }
}
