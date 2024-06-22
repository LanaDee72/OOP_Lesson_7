import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Logger {
    
    private final File logFile;

    public Logger(String filePath) throws IOException{
        logFile = new File(filePath);
        if (!logFile.exists()) {
            logFile.createNewFile();
        }
    }

    public void writeToLog(String message) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(logFile, true))) {
            writer.write(new SimpleDateFormat("yyyy-MM-dd HH:mm").format(new Date()) + " ");
            writer.write(message);
            writer.newLine();
        } catch (IOException e) {
            System.out.println("Ошибка при записи в лог-файл");
        }
    }
       

}
