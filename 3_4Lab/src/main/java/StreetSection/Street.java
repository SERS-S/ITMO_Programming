package StreetSection;

public record Street(boolean full, String name) {

    public void closeStreet(String StreetName) {

        System.out.println(StreetName + " заполнила улицу");

        try 
        {
            Thread.sleep(1500);
        } catch (InterruptedException e) 
        {
            System.out.println("Задержка прервана!");
        }
        
    }
}