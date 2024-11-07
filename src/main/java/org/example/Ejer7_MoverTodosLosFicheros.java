package org.example;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

/*
Escribe un programa que mueva todos los ficheros de un directorio descargas a un directorio documentos.
Asegúrate de que el directorio documentos existe o créalo si no.
 */
public class Ejer7_MoverTodosLosFicheros {
    public static void main(String[] args) {
        Path origen = Paths.get("C:\\Users\\juanc\\Desktop\\AccesoDatos\\descargas");
        Path destino = Paths.get("C:\\Users\\juanc\\Desktop\\AccesoDatos\\documentos");


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
                        Files.move(source, destinoArchivos, StandardCopyOption.REPLACE_EXISTING);
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


