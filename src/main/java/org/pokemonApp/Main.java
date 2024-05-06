package org.pokemonApp;

import com.google.gson.Gson;

import javax.sound.sampled.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;
import java.io.*;
import java.nio.charset.StandardCharsets;

public class Main {
    public static void main(String[] args) throws Exception {
        final Gson gson = new Gson();
        Scanner tc = new Scanner(System.in);
        System.out.print("Nombre pokemon: ");
        String nombre = tc.nextLine();

        URL pokeAPI = new URL("https://pokeapi.co/api/v2/pokemon/"+nombre);
        BufferedReader in = new BufferedReader(new InputStreamReader(pokeAPI.openStream(), StandardCharsets.UTF_8));

        PokemonData p = gson.fromJson(in, PokemonData.class);

        System.out.println(p.name+" --> "+p.species.url);

        System.out.println(p.cries.latest);
        //oggPlayer(p.cries.latest);
        oggPlayer();

        int contador = 0;
        for(PokemonData.MoveSlot i : p.moves){
            System.out.println(contador+++" --> "+i.move.name);
        }

        in.close();
    }

    private static void oggPlayer(){
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

        } catch (UnsupportedAudioFileException | LineUnavailableException | IOException e) {
            e.printStackTrace();
        }
    }
}