package org.pokemonApp;

import org.asynchttpclient.*;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class Imagen {
    public static void descargarImagen(PokemonData p){
        //Descargar imagen
        try {
            AsyncHttpClient client = Dsl.asyncHttpClient();
            FileOutputStream stream = new FileOutputStream("src/main/resources/image.png");
            client.prepareGet(p.sprites.versions.generationV.blackWhite.frontDefault).execute(new AsyncCompletionHandler<FileOutputStream>() {

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
            System.out.println("Imagen no encontrada");
        }
    }
}
