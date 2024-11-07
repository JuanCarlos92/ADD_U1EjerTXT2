package org.example;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Scanner;

/**
 * Crea un programa que copie un fichero importante.txt a seguridad.txt,
 * pero si seguridad.txt ya existe, el programa debe preguntarte si deseas sobrescribirlo (sí/no).
 */
public class Ejer8_CopiarConOpciones {
    public static void main(String[] args) {
        Path pathOrigen = Paths.get("C:\\Users\\juanc\\Desktop\\AccesoDatos\\ficheros\\importante.txt");
        Path pathDestino = Paths.get("C:\\Users\\juanc\\Desktop\\AccesoDatos\\ficherosCopia\\seguridad.txt");

        File file = new File(pathOrigen.toString());
        File fileDestino = new File(pathDestino.toString());
        Scanner sc = new Scanner(System.in);

        try {
            if (file.exists()) {
                // Copiar el fichero
                if (fileDestino.exists()) {
                    System.out.print("El archivo 'seguridad.txt' ya existe. ¿Deseas sobrescribirlo? (sí/no): ");
                    String respuesta = sc.nextLine().trim().toLowerCase();
                    if (respuesta.equals("si")) {
                        Files.copy(pathOrigen, pathDestino, StandardCopyOption.REPLACE_EXISTING);
                        System.out.println("Fichero se ha sobreescrito correctamente a --> " + pathDestino.toString());

                    } else {
                        System.out.println("CANCELADO, el archivo no fue sobrescrito.");
                    }

                } else {
                    Files.copy(pathOrigen, pathDestino);
                    System.out.println("Fichero copiado correctamente a --> " + pathDestino.toString());
                }

            } else {

                System.out.println("El fichero de origen no existe");
            }

        } catch (IOException e) {
            System.out.println("Ocurrió un error al copiar el fichero.");
            e.printStackTrace();


        } finally {
            sc.close();
        }
    }
}
