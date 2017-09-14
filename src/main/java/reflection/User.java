package reflection;

public class User {

    private static int[] array = {12, 34, 56};

    private String name = "Bill";
    private String surname;
    private int id = 2;
    private int age;

    private int getAge(){
        return age;
    }

    private String job(){
        return "Programmer";
    }

}
