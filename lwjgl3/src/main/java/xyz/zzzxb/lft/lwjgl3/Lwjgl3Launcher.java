package xyz.zzzxb.lft.lwjgl3;

import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Application;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3ApplicationConfiguration;
import xyz.zzzxb.lft.GameMain;
import xyz.zzzxb.lft.config.Config;
import xyz.zzzxb.lft.screen.MenuScreen;

/**
 * Launches the desktop (LWJGL3) application.
 */
public class Lwjgl3Launcher {
    public static void main(String[] args) {
        if (StartupHelper.startNewJvmIfRequired()) return; // This handles macOS support and helps on Windows.
        new Lwjgl3Application(new GameMain(), getDefaultConfiguration());
    }

    private static Lwjgl3ApplicationConfiguration getDefaultConfiguration() {
        Lwjgl3ApplicationConfiguration configuration = new Lwjgl3ApplicationConfiguration();
        configuration.setTitle(Config.TITLE);
        configuration.useVsync(true);
        //// Limits FPS to the refresh rate of the currently active monitor.
        configuration.setForegroundFPS(Lwjgl3ApplicationConfiguration.getDisplayMode().refreshRate);
        //// If you remove the above line and set Vsync to false, you can get unlimited FPS, which can be
        //// useful for testing performance, but can also be very stressful to some hardware.
        //// You may also need to configure GPU drivers to fully disable Vsync; this can cause screen tearing.
        configuration.setWindowedMode(Config.SCREEN_WIDTH, Config.SCREEN_HEIGHT);
        configuration.setWindowIcon(
            Config.ICON_NAME + "128.png",
            Config.ICON_NAME + "64.png",
            Config.ICON_NAME + "32.png",
            Config.ICON_NAME + "16.png");
        return configuration;
    }
}
