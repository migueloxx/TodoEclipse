package nio_io;

import java.io.*;
import java.nio.file.DirectoryIteratorException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ImprimirArchivos {

		public void salidaIo(){
			System.out.println("Ficheros del directorio con io : ");
			File f = new File("C:/users");
			String[] archivos = f.list();
			for (int i=0; i < archivos.length; i++){
				System.out.println(archivos[i]);
			}
		}

		public void salidaNio(){
			System.out.println("Ficheros del directorio con nio:");
			Path dir = Paths.get("C:/users");
			try (DirectoryStream<Path> stream = Files.newDirectoryStream(dir)) {
			 for (Path file: stream) {
			 System.out.println(file.getFileName());
			 }
			} catch (IOException | DirectoryIteratorException e) {
			 System.err.println(e);
			}
		}
}