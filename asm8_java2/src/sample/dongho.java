package sample;

import javafx.scene.control.TextArea;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class dongho {
    public TextArea dongho;

    public void KQ() {
        Runnable r = new Runnable() {
            @Override
            public void run() {
                while(true)
                {
                    LocalDateTime myDateObj = LocalDateTime.now();
                    DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("HH:mm:ss\ndd-MM-yyyy");
                    String formattedDate = myDateObj.format(myFormatObj);
                    dongho.setText(formattedDate);
                    try {
                        Thread.sleep(1000);
                        } catch (Exception E) {}
                }
            }
        };
        Thread T2 = new Thread(r);
        T2.start();
    }
}
