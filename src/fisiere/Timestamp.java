package fisiere;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Timestamp {

   public Timestamp()
    { try { FileWriter x = new FileWriter( System.getProperty("user.dir") + "\\src\\fisiere\\audit\\Audit.csv");

        x.write("");
        x.close();
           }

    catch (IOException e) {
        e.printStackTrace();
    }
    }

    public void Audit(String actiune) {

        try {
        BufferedWriter Audit = new BufferedWriter(new FileWriter(System.getProperty("user.dir") + ("\\src\\fisiere\\audit\\Audit.csv"),true));
        LocalDateTime timp = LocalDateTime.now();
        DateTimeFormatter formatare = DateTimeFormatter.ofPattern("HH:mm:ss dd/MM/yyyy");
        String timpformatat = timp.format(formatare);
        Audit.write(actiune + "," + timpformatat+"\n");
        Audit.close();
              }
     catch(IOException ioException)

        {
            ioException.printStackTrace();
        }
    }
}
