// if you run into trouble downloading and installing the Enthuware .jar
// here's the program you can run to recreate it
// download this file -- https://enthuware.com/etsviewer/etsviewer.txt
// place it in this project's root directory (you'll see where it goes in this repo)
// run this program
// the recreated .jar will now be in the same directory as the text file, and it should run fine

package com.skillstorm;

import java.io.*;
import java.nio.file.*;
public class Enthuware {
    public static void main(String[] args) throws IOException {
        byte[] data = Files.readAllBytes(Paths.get("etsviewer.txt"));
        data = java.util.Base64.getDecoder().decode(data);
        Files.write(Paths.get("etsviewer.jar"), data, new OpenOption[]{StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING});
    }
}
