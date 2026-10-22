package Adapter;

public class AudioPlayer implements MediaPlayer {
    private MediaAdapter mediaAdapter;

    @Override
    public void play(String audioType, String fileName) {
        // Soporte nativo para mp3
        if (audioType.equalsIgnoreCase("mp3")) {
            System.out.println("Reproduciendo archivo mp3: " + fileName);
        }
        // Formatos avanzados: se delegan al adaptador
        else if (audioType.equalsIgnoreCase("vlc") || audioType.equalsIgnoreCase("mp4")) {
            mediaAdapter = new MediaAdapter(audioType);
            mediaAdapter.play(audioType, fileName);
        } else {
            System.out.println("Tipo de medio inválido: " + audioType);
        }
    }
}
