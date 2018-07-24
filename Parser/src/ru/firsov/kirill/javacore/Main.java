package ru.firsov.kirill.javacore;

import javax.swing.plaf.FileChooserUI;
import java.io.*;
import java.nio.ByteBuffer;
import java.nio.DoubleBuffer;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        File bFile = new File("C:/Users/User/Desktop/die Arbeit/89021_05.01.17_SYL4449_KHV_UUS.bin");
        byte[] data = readBinary(bFile);
        write(data);
        String path = "C:/Users/User/Desktop/test.txt";
        List<String> strings = ParseCsv(path);
        int f = 32;
        //binary2();
    }

    private static List<String> ParseCsv(String filePath) throws IOException {
        List<String> data = new ArrayList<>();
        //int lines = countLines(filePath);
        List<String> fileLines = Files.readAllLines(Paths.get(filePath));
        for (String fileLine : fileLines) {
            String[] splitedText = ",".split(fileLine);
            ArrayList<String> columnList = new ArrayList<>();
            for (int i = 0; i < splitedText.length; i++) {
                if (IsColumnPart(splitedText[i])) {
                    String lastText = columnList.get(columnList.size() - 1);
                    columnList.set(columnList.size() - 1, lastText + "," + splitedText[i]);
                } else {
                    columnList.add(splitedText[i]);
                }
            }
            data.add(columnList.get(0));
        }
        return data;
    }

    private static boolean IsColumnPart(String text) {
        String trimText = text.trim();
        return trimText.indexOf(" ") == trimText.lastIndexOf(" ") && trimText.endsWith(" ");
    }

    public static void binary3() throws IOException {
        FileInputStream in = null;
        FileOutputStream out = null;

        try {
            in = new FileInputStream("C:/Users/User/Desktop/die Arbeit/89021_05.01.17_SYL4449_KHV_UUS.bin");
            byte[] buffer = new byte[in.available()];
            in.read(buffer, 0, in.available());
            int i = -1;

            while ((i = in.read()) != -1) {
                System.out.println((char)i);
            }
        } catch(IOException e) {
            e.printStackTrace();
        }
    }

    public static void binary2() throws IOException {
        FileInputStream in = null;
        FileOutputStream out = null;

        try {
            in = new FileInputStream("C:/Users/User/Desktop/die Arbeit/89021_05.01.17_SYL4449_KHV_UUS.bin");
            out = new FileOutputStream("C:/Users/User/Desktop/die Arbeit/result.txt");
            int c;

            while ((c = in.read()) != -1) {
                out.write(c);
            }
        } finally {
            if (in != null) {
                in.close();
            }
            if (out != null) {
                out.close();
            }
        }
    }

    /*public static int countLines(String filename) throws IOException {
        InputStream is = new BufferedInputStream(new FileInputStream(filename));
        try {
            byte[] c = new byte[1024];
            int count = 0;
            int readChars = 0;
            boolean empty = true;
            while ((readChars = is.readBinary(c)) != -1) {
                empty = false;
                for (int i = 0; i < readChars; ++i) {
                    if (c[i] == '\n') {
                        ++count;
                    }
                }
            }
            return (count == 0 && !empty) ? 1 : count + 1;
        } finally {
            is.close();
        }
    }*/



    private static byte[] readBinary(File bFile) throws IOException {
        try (BufferedInputStream bf = new BufferedInputStream(
                new FileInputStream(bFile))) {
            byte[] data = new byte[bf.available()];
            bf.read(data);
            ByteBuffer bb = ByteBuffer.wrap(data);
            DoubleBuffer db = ((ByteBuffer)bb.rewind()).asDoubleBuffer();
            FileOutputStream fout = new FileOutputStream("C:/Users/User/Desktop/die Arbeit/result.txt");
            return data;
        }
    }

    public static byte[] readBinary(String bFile) throws IOException {
        return readBinary(new File(bFile).getAbsoluteFile());
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
