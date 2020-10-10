import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.Files;
import java.io.BufferedWriter;
import java.io.IOException;

class IOExceptionCase3 {
    public static void main(String[] args) {
        try {
            md1();
        }
        catch(IOException e) {
            e.printStackTrace();
        }
    }
    public static void md1() throws IOException {       //Specify to skip IOException
        md2();
    }
    public static void md2() throws IOException {
        Path file = Paths.get("D:\\Github\\java\\testfile.txt");
        BufferedWriter writer = null;
        writer = Files.newBufferedWriter(file);           //possible IOException
        writer.write('A');                              //possible IOException
        writer.write('Z');                              //Possible IOException

        if (writer != null) {
            writer.close();
        }
    }
}
