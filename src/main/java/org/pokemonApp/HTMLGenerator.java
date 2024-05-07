package org.pokemonApp;

import java.io.FileWriter;
import java.io.IOException;

public class HTMLGenerator {
    public static void generarHTML(PokemonData p) {
        String title = "POKEDEX";
        //String[] items = {"Item 1", "Item 2", "Item 3"};
        String pokemonImg = String.format("<img src='%s' alt='%s'>",p.sprites.versions.generationV.blackWhite.frontDefault,p.name);
        //String pokemonCry = p.cries.latest;
        String pokemonCry = String.format("<audio controls>\n" +
                "  <source src=\"%s\" type=\"audio/ogg\">\n" +
                "  Tu navegador no soporta el elemento de audio.\n" +
                "</audio>",p.cries.latest);
        String[] items = {
                p.name,
                pokemonImg,
                pokemonCry
        };

        String html = generateHTML(title, items);
        try{
            guardarHTML(html);
        }catch (IOException e){
            System.out.println("Error al generar el HTML");
        }
    }

    private static void guardarHTML(String html) throws IOException {
        FileWriter fw = null;
        try{
            fw = new FileWriter("src/main/resources/pokedex.html");
            for(int i = 0; i < html.length(); i++){
                fw.write(html.charAt(i));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally{
            if(fw != null){
                fw.close();
            }
        }
    }

    public static String generateHTML(String title, String[] items) {
        StringBuilder htmlBuilder = new StringBuilder();

        htmlBuilder.append("<!DOCTYPE html>\n");
        htmlBuilder.append("<html>\n");
        htmlBuilder.append("<head>\n");
        htmlBuilder.append("<title>").append(title).append("</title>\n");
        htmlBuilder.append("</head>\n");

        htmlBuilder.append("<body>\n");
        htmlBuilder.append("<h1>").append(title).append("</h1>\n");
        htmlBuilder.append("<table border='1'>\n");
        htmlBuilder.append("<tr>\n");
        htmlBuilder.append("<th>Nombre</th>\n");
        htmlBuilder.append("<th>Imágen</th>\n");
        htmlBuilder.append("<th>Grito</th>\n");
        htmlBuilder.append("</tr>\n");

        htmlBuilder.append("<tr>\n");
        for (String item : items) {
            htmlBuilder.append("<td>").append(item).append("</td>\n");
        }
        htmlBuilder.append("</tr>\n");

        htmlBuilder.append("</table>\n");
        htmlBuilder.append("</body>\n");
        htmlBuilder.append("</html>");

        return htmlBuilder.toString();
    }
}
