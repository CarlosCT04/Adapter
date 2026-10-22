package Adapter;

public class AudioPlayer implements MediaPlayer {
    @Override
    public void play(String audioType, String fileName) {
        if(audioType.equalsIgnoreCase("mp3")) {
            System.out.println("Reproduciendo archivo mp3: " + fileName);
        } else {
            System.out.println("Tipo de medio inválido: " + audioType);
        }
    }
}