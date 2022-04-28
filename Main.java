package com.company;

import java.io.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class Main {

    public static void main(String[] args) {
        try (ObjectOutputStream oos1 = new ObjectOutputStream(new FileOutputStream("C://Games/savegames/save1.txt"))) {
            GameProgress gameProgress1 = new GameProgress(99, 18, 6, 10.6);
            oos1.writeObject(gameProgress1);
        } catch (IOException ex) {
            ex.getMessage();
        }

        try (ObjectOutputStream oos2 = new ObjectOutputStream(new FileOutputStream("C://Games/savegames/save2.txt"))) {
            GameProgress gameProgress2 = new GameProgress(66, 24, 10, 55.1);
            oos2.writeObject(gameProgress2);
        } catch (IOException ex) {
            ex.getMessage();
        }

        try (ObjectOutputStream oos3 = new ObjectOutputStream(new FileOutputStream("C://Games/savegames/save3.txt"))) {
            GameProgress gameProgress3 = new GameProgress(20, 30, 18, 74.0);
            oos3.writeObject(gameProgress3);
        } catch (IOException ex) {
            ex.getMessage();
        }

        try (ZipOutputStream zip1 = new ZipOutputStream(new FileOutputStream("C://Games/savegames/zip1.zip"));
             FileInputStream oos11 = new FileInputStream("C://Games/savegames/save1.txt");
             FileInputStream oos21 = new FileInputStream("C://Games/savegames/save2.txt");
             FileInputStream oos31 = new FileInputStream("C://Games/savegames/save3.txt");) {

            ZipEntry entry = new ZipEntry("save1.txt");
            zip1.putNextEntry(entry);
            byte[] buffer1 = new byte[oos11.available()];
            oos11.read(buffer1);
            zip1.write(buffer1);
            zip1.closeEntry();

            zip1.putNextEntry(new ZipEntry("save2.txt"));
            byte[] buffer2 = new byte[oos21.available()];
            oos21.read(buffer2);
            zip1.write(buffer2);
            zip1.closeEntry();

            zip1.putNextEntry(new ZipEntry("save3.txt"));
            byte[] buffer3 = new byte[oos31.available()];
            oos31.read(buffer3);
            zip1.write(buffer3);
            zip1.closeEntry();

        } catch (IOException ex) {
            ex.getMessage();
        }

        File oos1 = new File("C://Games/savegames", "save1.txt");
        File oos2 = new File("C://Games/savegames", "save2.txt");
        File oos3 = new File("C://Games/savegames", "save3.txt");
        try {
            oos1.createNewFile();
            oos2.createNewFile();
            oos3.createNewFile();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        oos1.delete();
        oos2.delete();
        oos3.delete();
    }
}
