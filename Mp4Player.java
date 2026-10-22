package Adapter;

public class Mp4Player implements AdvancedMediaPlayer {
    @Override
    public void playVlc(String fileName) {
        // No hace nada - el reproductor MP4 no soporta VLC
    }
    
    @Override
    public void playMp4(String fileName) {
        System.out.println("Reproduciendo archivo mp4: " + fileName);
    }
}