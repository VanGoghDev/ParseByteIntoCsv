package ru.firsov.kirill.javacore;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        File bFile = new File("C:/Users/User/Desktop/die Arbeit/89021_05.01.17_SYL4449_KHV_UUS.bin");
        byte[] data = read (bFile);
        write(data);
    }

    private static List<Byte> ParseCsv(String filePath) throws IOException {
        List<Byte> data = new ArrayList<Byte>();
        List<String> fileLines = Files.readAllLines(Paths.get(filePath));
        for (String fileLine : fileLines) {
            String[] splitedText = fileLine.split(",");
            ArrayList<Byte> columnList = new ArrayList<Byte>();
            for (int i = 0; i < splitedText.length; i++) {
                //if (IsColumnPart)
            }
        }
    }

    private static byte[] read(File bFile) throws IOException {
        try (BufferedInputStream bf = new BufferedInputStream(
                new FileInputStream(bFile))) {
            byte[] data = new byte[bf.available()];
            bf.read(data);
            return data;
        }
    }

    public static byte[] read(String bFile) throws IOException {
        return read(new File(bFile).getAbsoluteFile());
    }

    private static void write(byte[] data) throws IOException {
        Writer writer = null;
        try {
            writer = new BufferedWriter(new OutputStreamWriter(
                    new FileOutputStream("filename.txt"), "utf-8"));
            writer.write(String.valueOf(data));

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {writer.close();} catch (
                    Exception e) {/*ignore*/}
        }
    }
}
