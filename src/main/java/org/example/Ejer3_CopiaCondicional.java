package org.example;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

/**
 * Modifica el programa del Ejercicio 1 para que solo copie el fichero si texto.txt existe.
 * De lo contrario, debe mostrar un mensaje en la consola.
 */
public class Ejer3_CopiaCondicional {
    public static void main(String[] args) {
        Path pathOrigen = Paths.get("C:\\Users\\juanc\\Desktop\\AccesoDatos\\ficheros\\texto.txt");
        Path pathDestino = Paths.get("C:\\Users\\juanc\\Desktop\\AccesoDatos\\ficheros\\copia_texto.txt");

        File file = new File(pathOrigen.toString());

        try {
            if (file.exists()) {
                // Copiar el fichero
                Files.copy(pathOrigen, pathDestino, StandardCopyOption.REPLACE_EXISTING);
                System.out.println("Fichero copiado correctamente a --> " + pathDestino.toString());
            }else{
                System.out.println("El fichero no existe");
            }


        } catch (IOException e) {
            System.out.println("Ocurrió un error al copiar el fichero.");
            e.printStackTrace();


        }
    }
}