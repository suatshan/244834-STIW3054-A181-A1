import java.io.IOException;

public class Main {
    public static void main(String[] args){
        try{
            WriteToExcel save = new WriteToExcel();
            save.write();

            System.out.println("Please wait for a while");
            System.out.println("Data saving......");
            Thread.sleep(1000);// Hold for 1 minute
            System.out.println("Successfully written in Excel");

        } catch (InterruptedException e1) {
            e1.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
