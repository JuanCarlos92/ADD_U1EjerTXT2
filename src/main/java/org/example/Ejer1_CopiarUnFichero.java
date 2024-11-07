package org.example;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

/*
 *Crea un programa que copie un fichero de texto llamado texto.txt a un nuevo fichero llamado copia_texto.txt.
 *Asegúrate de que se sobrescriba si ya existe.
 */
public class Ejer1_CopiarUnFichero {
    public static void main(String[] args) throws IOException {
        Path pathOrigen = Paths.get("C:\\Users\\juanc\\Desktop\\AccesoDatos\\ficheros\\texto.txt");
        Path pathDestino = Paths.get("C:\\Users\\juanc\\Desktop\\AccesoDatos\\ficheros\\copia_texto.txt");

        File file = new File(pathOrigen.toString());

        try {
            if (!file.exists()) {
                file.createNewFile();
            }
            // Copiar el fichero

            Files.copy(pathOrigen, pathDestino, StandardCopyOption.REPLACE_EXISTING);
            System.out.println("Fichero copiado correctamente a --> " + pathDestino.toString());

        } catch (IOException e) {
            System.out.println("Ocurrió un error al copiar el fichero.");
            e.printStackTrace();


        }
    }
}
