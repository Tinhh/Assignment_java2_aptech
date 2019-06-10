import java.util.Scanner;

public class Main {
    public int a;
    public int snttt;
    public static void main(String args[]){
//        Counter ct = new Counter();
        Main ex = new Main();

        ex.khaibao();
        Runnable r1 = new Runnable() {
            @Override
            public void run() {

                for (int i = 0; i < 100 ; i++) {
                    ex.submit();
                    try {
                        Thread.sleep(500);
                    }catch (Exception E){}
                }
            }
        };
        Thread t1 = new Thread(r1);
        t1.start();
        Thread t2 = new Thread(r1);
        t2.start();

    }
    public void khaibao(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập vào số x");
        a = scanner.nextInt();
        for (int i = a + 1; ; i++) {
            if (xacdinh_a(i)) {
                snttt = i;
                System.out.println("Số nguyên tố tiếp theo " + snttt);
                break;
            }
        }
    }
    public synchronized void submit() {


        for (int i = snttt + 1; ; i++) {
            if (xacdinh_a(i)) {
                snttt = i;
                System.out.println("Số nguyên tố tiếp theo " + snttt);
                break;
            }
        }
    }

    public synchronized static boolean  xacdinh_a(int a){
        if(a < 2){
            return false;
        }
        int squareRoot = (int) Math.sqrt(a);
        for (int i = 2; i <= squareRoot ; i++) {
            if(a % i == 0){
                return false;
            }
        }
        return true;
    }
}
