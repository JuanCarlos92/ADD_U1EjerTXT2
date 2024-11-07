package org.example;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Desarrolla un programa que copie un fichero y registre la acción en un fichero de log registro.txt, indicando
 * qué fichero fue copiado y a dónde se copió. Si el fichero de log no existe, créalo.
 */
public class Ejer9_RegistroDeCopias {
    public static void main(String[] args) {
        Path pathOrigen = Paths.get("C:\\Users\\juanc\\Desktop\\AccesoDatos\\ficheros\\ficheroderegistro.txt");
        Path pathDestino = Paths.get("C:\\Users\\juanc\\Desktop\\AccesoDatos\\ficherosCopia\\ficheroderegistro_copia.txt");
        Path pathLog = Paths.get("C:\\Users\\juanc\\Desktop\\AccesoDatos\\registros\\registro.txt");

        File fileOrigen = new File(pathOrigen.toString());
        File fileLog = new File(pathLog.toString());

        try {
            if (fileOrigen.exists()) {
                // Copiar el archivo
                Files.copy(pathOrigen, pathDestino, StandardCopyOption.REPLACE_EXISTING);
                System.out.println("Fichero copiado correctamente a --> " + pathDestino.toString());

                // Crear o actualizar el log
                FileWriter log = new FileWriter(fileLog, true); // 'true' para agregar al archivo
                DateTimeFormatter dateTime = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
                String fechaHora = LocalDateTime.now().format(dateTime);

                // Escribir la acción en el archivo de log
                log.write("[" + fechaHora + "] Copiado: " + pathOrigen.toString() + " a " + pathDestino.toString() + "\n");
                log.close();

                System.out.println("Registro de la acción guardado en --> " + pathLog.toString());

            } else {
                System.out.println("El fichero origen no existe.");
            }

        } catch (IOException e) {
            System.out.println("Ocurrió un error al copiar el fichero o escribir en el log.");
            e.printStackTrace();
        }
    }
}