package BlackBoxInteger;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchFieldException {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        Class<BlackBoxInt> clazz = BlackBoxInt.class;
        Constructor<BlackBoxInt> declaredConstructor = clazz.getDeclaredConstructor(int.class);
        declaredConstructor.setAccessible(true);

        BlackBoxInt instance = declaredConstructor.newInstance(0);

        while (!input.equals("END"))  {
          String[] tokens = input.split("_");

          String nameMethod = tokens[0];
          int param = Integer.parseInt(tokens[1]);

            Method method = clazz.getDeclaredMethod(nameMethod, int.class);
            method.setAccessible(true);
            method.invoke(instance,param);

            Field innerValue = clazz.getDeclaredField("innerValue");
            innerValue.setAccessible(true);

            System.out.println(innerValue.get(instance));
            input = scanner.nextLine();
        }

    }
}
