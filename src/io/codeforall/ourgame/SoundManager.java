package io.codeforall.ourgame;

import javax.sound.sampled.*;
import java.io.IOException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;

public abstract class SoundManager {

    private static final Logger LOGGER = Logger.getLogger(SoundManager.class.getName());

    public static void startBackgroundMusic() {
            new Thread(() -> {
                try {
                    URL musicURL = SoundManager.class.getResource("/music.wav");
                    if (musicURL == null) {
                        LOGGER.log(Level.SEVERE, "The music file could not be found.");
                        return;
                    }
                    AudioInputStream backgroundMusicStream = AudioSystem.getAudioInputStream(musicURL);

                    Clip backgroundMusic = AudioSystem.getClip();
                    backgroundMusic.open(backgroundMusicStream);

                    FloatControl gainControl = (FloatControl) backgroundMusic.getControl(FloatControl.Type.MASTER_GAIN);
                    gainControl.setValue(-10.0f);

                    backgroundMusic.loop(Clip.LOOP_CONTINUOUSLY);

                } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
                    LOGGER.log(Level.SEVERE, "Failed to play background music", e);
                }
            }).start();
    }
}