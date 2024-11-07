package org.example;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

/**
 * Crea un programa que mueva un fichero llamado documento.txt a un nuevo directorio llamado archivos y lo
 * renombre como documento_final.txt. Si el directorio no existe, debe crearlo.
 */
public class Ejer4_MoveryRenombrar {
    public static void main(String[] args) {
        Path origen = Paths.get("C:\\Users\\juanc\\Desktop\\AccesoDatos\\documento.txt");
        Path directorio = Paths.get("C:\\Users\\juanc\\Desktop\\AccesoDatos\\archivos");
        Path destino = Paths.get("C:\\Users\\juanc\\Desktop\\AccesoDatos\\archivos\\documento_final.txt");

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
