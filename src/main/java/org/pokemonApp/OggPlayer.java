package org.pokemonApp;

import org.asynchttpclient.*;

import javax.sound.sampled.*;
import java.io.*;

public class OggPlayer {

    public static void player(PokemonData p) throws FileNotFoundException {
        descargarOgg(p);
        String filePath = "src/main/resources/cry.ogg";
        oggToWav(filePath);

        try {
            File file = new File(filePath);
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(file);

            AudioFormat format = audioInputStream.getFormat();
            DataLine.Info info = new DataLine.Info(SourceDataLine.class, format);

            SourceDataLine line = (SourceDataLine) AudioSystem.getLine(info);
            line.open(format);
            line.start();

            int bufferSize = (int) format.getSampleRate() * format.getFrameSize();
            byte[] buffer = new byte[bufferSize];
            int bytesRead = -1;

            while ((bytesRead = audioInputStream.read(buffer)) != -1) {
                line.write(buffer, 0, bytesRead);
            }

            line.drain();
            line.close();
            audioInputStream.close();

        } catch (UnsupportedAudioFileException | LineUnavailableException | IOException e) {
            e.printStackTrace();
        }
    }

    public static void oggToWav(String oggPath) throws FileNotFoundException {
        String oggFilePath = "src/main/resources/cry.ogg"; // Ruta del archivo Ogg de entrada
        String wavFilePath = "src/main/resources/cry.wav"; // Ruta donde se guardará el archivo WAV de salida

        try {
            // Construir el comando para convertir el archivo Ogg a WAV usando FFmpeg
            ProcessBuilder builder = new ProcessBuilder("ffmpeg", "-i", oggFilePath, "-ar", "44100", wavFilePath);

            // Ejecutar el comando
            Process process = builder.start();

            // Esperar a que el proceso termine
            process.waitFor();

            System.out.println("La conversión ha sido completada.");
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void descargarOgg(PokemonData p){
        //Descargar ogg
        try {
            AsyncHttpClient client = Dsl.asyncHttpClient();
            FileOutputStream stream = new FileOutputStream("src/main/resources/cry.ogg");
            client.prepareGet(p.cries.latest).execute(new AsyncCompletionHandler<FileOutputStream>() {

                @Override
                public AsyncHandler.State onBodyPartReceived(HttpResponseBodyPart bodyPart)
                        throws Exception {
                    stream.getChannel().write(bodyPart.getBodyByteBuffer());
                    return AsyncHandler.State.CONTINUE;
                }

                @Override
                public FileOutputStream onCompleted(Response response)
                        throws Exception {
                    return stream;
                }
            });
        }catch (FileNotFoundException e){
            System.out.println("Audio no encontrado");
        }
    }

    /*private static void oggPlayer(){
        String filePath = "src/main/resources/cries_pokemon_latest_359.ogg";

        try {
            File file = new File(filePath);
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(file);

            AudioFormat format = audioInputStream.getFormat();
            DataLine.Info info = new DataLine.Info(SourceDataLine.class, format);

            SourceDataLine line = (SourceDataLine) AudioSystem.getLine(info);
            line.open(format);
            line.start();

            int bufferSize = (int) format.getSampleRate() * format.getFrameSize();
            byte[] buffer = new byte[bufferSize];
            int bytesRead = -1;

            while ((bytesRead = audioInputStream.read(buffer)) != -1) {
                line.write(buffer, 0, bytesRead);
            }

            line.drain();
            line.close();
            audioInputStream.close();

        } catch (UnsupportedAudioFileException | LineUnavailableException | IOException | IllegalArgumentException e) {
            e.printStackTrace();
        }
    }*/
}