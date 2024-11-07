package org.example;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

/*
Crea un programa que copie múltiples ficheros (por ejemplo, fichero1.txt, fichero2.txt, fichero3.txt) desde un
directorio origen a un directorio destino, sobrescribiendo ficheros existentes.
 */
public class Ejer6_CopiaMultiplesFicheros {
    public static void main(String[] args) {
        Path origen = Paths.get("C:\\Users\\juanc\\Desktop\\AccesoDatos\\origen");
        Path destino = Paths.get("C:\\Users\\juanc\\Desktop\\AccesoDatos\\destino");


        try {
            if (!Files.exists(destino)) {
                Files.createDirectories(destino);
            }
            //Copiar contenido del directorio origen al destino
            Files.walk(origen).forEach(source -> {

                try {
                    Path destinoArchivos = destino.resolve(origen.relativize(source));
                    if (Files.isDirectory(source)) {
                        if (!Files.exists(destinoArchivos)) {
                            Files.createDirectories(destinoArchivos);
                        }
                    } else {
                        Files.copy(source, destinoArchivos, StandardCopyOption.REPLACE_EXISTING);
                    }
                } catch (IOException e) {
                    System.out.println("Error al copiar: " + source + " - " + e.getMessage());
                }
            });

            System.out.println("Ficheros copiados correctamente a --> " + destino.toString());

        } catch (IOException e) {
            System.out.println("Error general: " + e.getMessage());
        }
    }
}


