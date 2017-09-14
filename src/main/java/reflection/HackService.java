package reflection;


import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;

public class HackService {
    public static void main(String[] args) throws IllegalAccessException, NoSuchFieldException, InvocationTargetException, NoSuchMethodException {
        hackFieldsAndArray();
        hackMethods();
    }
    private static void hackFieldsAndArray() throws IllegalAccessException, NoSuchFieldException {
        User user = new User();
        Class<? extends User> userClass = user.getClass();
        Field nameField = userClass.getDeclaredField("name");
        nameField.setAccessible(true);
        System.out.println("name: " + nameField.getName() + ", type: " + nameField.getType());
        Object o = nameField.get(user);
        System.out.println("before changing: " + o);
        nameField.set(user,"John");
        o = nameField.get(user);
        System.out.println("after changing: " + o);
        System.out.println();

        Field surnameField = userClass.getDeclaredField("surname");
        surnameField.setAccessible(true);
        System.out.println("name: " + surnameField.getName() + ", type: " +surnameField.getType());
        o = surnameField.get(user);
        System.out.println("before changing: " + o);
        surnameField.set(user,"Smith");
        o = surnameField.get(user);
        System.out.println("after changing: " + o);
        System.out.println();

        Field idField = userClass.getDeclaredField("id");
        idField.setAccessible(true);
        System.out.println("name: " + idField.getName() + ", type: " + idField.getType());
        o = idField.get(user);
        System.out.println("before changing: " + o);
        idField.set(user,987);
        o = idField.get(user);
        System.out.println("after changing: " + o);
        System.out.println();

        Field ageField = userClass.getDeclaredField("age");
        ageField.setAccessible(true);
        System.out.println("name: " + ageField.getName() + ", type: " + ageField.getType());
        o = ageField.get(user);
        System.out.println("before changing: " + o);
        ageField.set(user,76);
        o = ageField.get(user);
        System.out.println("after changing: " + o);
        System.out.println();

        Field arrayField = userClass.getDeclaredField("array");
        arrayField.setAccessible(true);
        System.out.println("name: " + arrayField.getName() + ", array: " + arrayField.getType().isArray());
        int[] array = (int[]) arrayField.get(user);
        System.out.println("before changing: " + Arrays.toString(array));
        array[1] = 123456;
        int[] newArray = (int[]) arrayField.get(user);
        System.out.println("after changing: " + Arrays.toString(newArray));
        System.out.println();

    }

    private static void hackMethods() throws InvocationTargetException, IllegalAccessException, NoSuchMethodException {
        User user = new User();
        Class<? extends User> userClass = user.getClass();
        Method method = userClass.getDeclaredMethod("job");
        method.setAccessible(true);
        System.out.println("method: " + method.getName() + " invokes: " + method.invoke(user));

        method = userClass.getDeclaredMethod("getAge");
        method.setAccessible(true);
        System.out.println("method: " + method.getName() + " invokes: " + method.invoke(user));
        }
    }


