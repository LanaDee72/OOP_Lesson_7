import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        
        View view = new View(new Calculator(), new Logger("Log.txt"));
        view.start();
    }
}
