package sample;

import javafx.scene.control.TextArea;

import java.util.Scanner;
import java.util.*;
import static sample.Main.*;
public class dongho {
    public TextArea txtdongho;
    public void dongho(){
        Runnable r = new Runnable() {
            @Override
            public void run() {
                for (int j = 10 - 1; j >= 0; j--) {
                    for (int i = 59; i >= 0  ; i--) {

//                        txtdongho.setText(String.format("%02d",j) + ":" + String.format("%02d",i));
                        String t = String.format("%02d",j) + ":" + String.format("%02d",i);
//                        for (dongho s: arl){
//
//                        }
//                        System.out.println(t);
                        txtdongho.setText(t);


                        try {
                            Thread.sleep(1000);
                        } catch (Exception E) {
                        }
                    };
                }


            }

        };

        Thread T2 = new Thread(r);
        T2.start();

    }


}
