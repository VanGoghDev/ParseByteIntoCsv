package ru.firsov.kirill.javacore;
import java.io.*;
import java.nio.ByteBuffer;

public class BufferedInputFile {
    public static void main(String[] args) {
        try {
            File file = new File("C:/Users/User/Desktop/die Arbeit/89021_05.01.17_SYL4449_KHV_UUS.bin");
            FileReader fr = new FileReader(file);
            BufferedReader reader = new BufferedReader(fr);
            String line = reader.readLine();
            //ByteBuffer bb = ByteBuffer.wrap(line);
            while (line != null) {
                System.out.println(line);
                line = reader.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
} /* (Execute to see output) *///:~