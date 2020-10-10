import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.Files;
import java.io.BufferedWriter;
import java.io.IOException;
/*
class FinallyCase {
    public static void main(String[] args) {
        Path file=Paths.get("D:\\Github\\java\\testfile.txt");
        BufferedWriter writer=null;

        try {
            writer=Files.newBufferedWriter(file);       //possible IOException
            writer.write('A');                          //possible IOException
            writer.write('B');                          //possible IOException
        } catch(IOException e) {
            e.printStackTrace();
        } finally {
            if(writer!=null)
                writer.close();
        }
    }
}
*/