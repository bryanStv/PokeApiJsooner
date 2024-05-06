package org.pokemonApp;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;

public class PNGToASCII {

    public static void print() {
        try {
            BufferedImage image = ImageIO.read(new File("src/main/resources/image.png")); // Cambia "input.png" al nombre de tu imagen
            int width = image.getWidth();
            int height = image.getHeight();

            // Escalar la imagen a un tamaño manejable (opcional)
            int scaledWidth = width / 4;
            int scaledHeight = height / 8;
            BufferedImage scaledImage = new BufferedImage(scaledWidth, scaledHeight, BufferedImage.TYPE_INT_RGB);
            scaledImage.getGraphics().drawImage(image.getScaledInstance(scaledWidth, scaledHeight, BufferedImage.SCALE_SMOOTH), 0, 0, null);

            // Convertir la imagen a ASCII
            StringBuilder asciiImage = new StringBuilder();
            for (int y = 0; y < scaledHeight; y++) {
                for (int x = 0; x < scaledWidth; x++) {
                    Color pixelColor = new Color(scaledImage.getRGB(x, y));
                    int luminosity = (int) (0.2126 * pixelColor.getRed() + 0.7152 * pixelColor.getGreen() + 0.0722 * pixelColor.getBlue());
                    char asciiChar = getAsciiChar(luminosity);
                    asciiImage.append(asciiChar);
                }
                asciiImage.append("\n");
            }

            // Mostrar la imagen ASCII
            System.out.println(asciiImage.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Mapear la luminosidad a un carácter ASCII
    private static char getAsciiChar(int luminosity) {
        char[] asciiChars = {'@', '#', '8', '&', 'o', ':', '*', '.', ' '}; // Caracteres de oscuro a claro
        int asciiIndex = (luminosity * (asciiChars.length - 1)) / 255;
        return asciiChars[asciiIndex];
    }
}