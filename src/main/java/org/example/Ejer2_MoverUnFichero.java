package org.example;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

/**
 * Escribe un programa que mueva el fichero copia_texto.txt a un directorio llamado backup.
 * Si el directorio no existe, debes crearlo.
 */
public class Ejer2_MoverUnFichero {
    public static void main(String[] args) {
        Path origen = Paths.get("C:\\Users\\juanc\\Desktop\\AccesoDatos\\ficheros\\copia_texto.txt");
        Path directorio = Paths.get("C:\\Users\\juanc\\Desktop\\AccesoDatos\\backup");
        Path destino = Paths.get("C:\\Users\\juanc\\Desktop\\AccesoDatos\\backup\\copia_texto.txt");

        File file = new File(origen.toString());
        File dir = new File(directorio.toString());

        try {
            if (!file.exists()) {
                file.createNewFile();
            }
            if (!dir.exists()) {
                dir.mkdir();
            }
            //Mover fichero

            Files.move(origen, destino, StandardCopyOption.REPLACE_EXISTING);
            System.out.println("Fichero movido correctamente a --> " + directorio.toString());
        }catch (Exception e){
            System.out.println(e.getMessage());
        }


    }
}
