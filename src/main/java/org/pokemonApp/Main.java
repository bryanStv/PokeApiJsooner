package org.pokemonApp;

import com.google.gson.Gson;
import org.asynchttpclient.*;
import java.net.URL;
import java.util.Scanner;
import java.io.*;
import java.nio.charset.StandardCharsets;

public class Main {

    public static void main(String[] args) throws Exception {

        final Gson gson = new Gson();
        Scanner tc = new Scanner(System.in);
        System.out.print("Pokemon a buscar: ");
        String nombre = tc.nextLine().toLowerCase();

        try {
            URL pokeAPI = new URL("https://pokeapi.co/api/v2/pokemon/" + nombre);
            BufferedReader in = new BufferedReader(new InputStreamReader(pokeAPI.openStream(), StandardCharsets.UTF_8));
            PokemonData p = gson.fromJson(in, PokemonData.class);
            menu(p);
            in.close();
        }catch (FileNotFoundException e){
            System.out.println("Pokemon no encontrado");
        }
    }

    private static void menu(PokemonData p){
        Scanner tc = new Scanner(System.in);
        informacionPokemon(p);
        Imagen.descargarImagen(p);
        OggPlayer.descargarOgg(p);
        System.out.println("Salir(0)| Listar movimientos(1) | Audio(2-No funciona)");
        int opcion = tc.nextInt();
        switch (opcion){
            case 0:
                System.exit(0);
            case 1:
                listarMovimientos(p);
                break;
            case 2:
                //OggPlayer.oggToWav("src/main/resources/cry.ogg");
                //OggPlayer.player(p);
                break;
        }
    }

    private static void verImagen(PokemonData p) {
        //Imagen.descargarImagen(p);
    }

    private static void listarMovimientos(PokemonData p){
        int contador = 0;
        for(PokemonData.MoveSlot i : p.moves){
            System.out.println(contador+++" --> "+i.move.name);
        }
    }

    private static void listarAbilidades(PokemonData p){
        int contador = 0;
        System.out.print("Habilidades posibles --> ");
        for (PokemonData.AbilitySlot i : p.abilities){
            System.out.print(contador+++":"+i.ability.name+" ");
        }
        System.out.println();
    }

    private static void informacionPokemon(PokemonData p){
        System.out.printf("Nombre pokemon(nº Pokedex): %s(%s)\n", p.name,p.id);
        listarAbilidades(p);
        System.out.print("Tipo(s): ");
        for(PokemonData.TypeSlot i : p.types){
            System.out.print(i.type.name+" ");
        }
        System.out.println("\nStats Base: ");
        for(PokemonData.Stat s : p.stats){
            System.out.println("\t"+s.stat.name+": "+s.baseStat);
        }
    }
}