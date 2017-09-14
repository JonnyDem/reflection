package reflection;


import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class HackService {
    public static void main(String[] args) throws IllegalAccessException, NoSuchFieldException, InvocationTargetException {
        hackFieldsAndArray();
        hackMethods();
    }
    private static void hackFieldsAndArray() throws IllegalAccessException, NoSuchFieldException {
        User user = new User();
        Class<? extends User> userClass = user.getClass();
        Field[] declaredFields = userClass.getDeclaredFields();
        for(Field f:declaredFields){
            System.out.println("name: " + f.getName() + ", type: " + f.getType());
            f.setAccessible(true);
            Object o = f.get(user);
            if(f.getType().isArray()){
                Field field = userClass.getDeclaredField("array");
                field.setAccessible(true);
                int[] array = (int[]) field.get(user);
                for(int i:array){
                    System.out.println("before changing: " + i);
                }
                array[1] = 9876;
                int[] newArray = (int[]) field.get(user);
                System.out.println();
                for(int i:newArray){
                    System.out.println("after changing: " + i);
                }
                System.out.println();
            }
            if(f.getName().equals("name")&&o instanceof String){
                Field field = userClass.getDeclaredField("name");
                System.out.println("before changing: " + o);
                field.setAccessible(true);
                field.set(user,"John");
                String str = (String) f.get(user);
                System.out.println("after changing: " + str);
                System.out.println();
            }
            if(f.getName().equals("surname")&&o==null){
                Field field = userClass.getDeclaredField("surname");
                System.out.println("before changing: " + o);
                field.setAccessible(true);
                field.set(user,"Smith");
                String str = (String) f.get(user);
                System.out.println("after changing: " + str);
                System.out.println();
            }
            if(f.getName().equals("id")&&o instanceof Integer){
                Field field = userClass.getDeclaredField("id");
                System.out.println("before changing: " + o);
                field.setAccessible(true);
                field.set(user,987);
                int newId = (Integer) f.get(user);
                System.out.println("after changing: " + newId);
                System.out.println();
            }
            if(f.getName().equals("age")&&o instanceof Integer){
                Field field = userClass.getDeclaredField("age");
                System.out.println("before changing: " + o);
                field.setAccessible(true);
                field.set(user,47);
                int newAge = (Integer) f.get(user);
                System.out.println("after changing: " + newAge);
                System.out.println();
            }
        }
    }
    private static void hackMethods() throws InvocationTargetException, IllegalAccessException {
        User user = new User();
        Class<? extends User> userClass = user.getClass();
        Method[] methods = userClass.getDeclaredMethods();
        for(Method m: methods){
             m.setAccessible(true);
            System.out.println("method: " + m.getName() + " invokes: " + m.invoke(user));
        }
    }
}

