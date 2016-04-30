package file;

import java.io.File;
import java.io.IOException;

public class MultithreadFileTest {
    public static void main(String[] args) {
        File aFile = new File("test.txt");
        if (!aFile.exists()) {
            try {
                aFile.createNewFile();
                System.out.println("creating a file!");
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        System.out.println("start to read a file!");
        Thread reader1 = new Thread(new FileReadTask());
        Thread reader2 = new Thread(new FileReadTask());
        reader1.start();
        reader1.start();

    }

}

class FileReadTask implements Runnable {

    public void run() {
        try {
            File aFile = new File("test.txt");
            System.out.println("reading!");
            Thread.sleep(30000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        System.out.println("awake!");

    }
}
