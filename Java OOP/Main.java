package harvestingFields;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Class clazz = RichSoilLand.class;
        Field[] fields = clazz.getDeclaredFields();

        String command = scanner.nextLine();

        StringBuilder all = allFields(fields);

        while (!command.equals("HARVEST")) {
            switch (command) {

                case "private":
                    privateCheck(fields, "private ");
                    break;

                case "protected":
                    protectedCheck(fields, "protected ");
                    break;

                case "public":
                    publicCheck(fields, "public ");
                    break;

                case "all":
                    System.out.println(all.toString().trim());
                    break;

            }

            command = scanner.nextLine();
        }


    }

    private static StringBuilder allFields(Field[] fields) {
        StringBuilder all = new StringBuilder();
        for (Field field : fields) {
            if (Modifier.isPrivate(field.getModifiers())) {
                all.append("private ")
                        .append(field.getType().getSimpleName())
                        .append(" ")
                        .append(field.getName())
                        .append(System.lineSeparator());
            } else if (Modifier.isProtected(field.getModifiers())) {
                all.append("protected ")
                        .append(field.getType().getSimpleName())
                        .append(" ")
                        .append(field.getName())
                        .append(System.lineSeparator());
            } else if (Modifier.isPublic(field.getModifiers())) {
                all.append("public ")
                        .append(field.getType().getSimpleName())
                        .append(" ")
                        .append(field.getName())
                        .append(System.lineSeparator());
            }
        }
        return all;
    }

    private static void publicCheck(Field[] fields, String s) {
        StringBuilder output = new StringBuilder();
        for (Field field : fields) {
            if (Modifier.isPublic(field.getModifiers())) {
                output.append(s)
                        .append(field.getType().getSimpleName())
                        .append(" ")
                        .append(field.getName())
                        .append(System.lineSeparator());
            }
        }
        System.out.println(output.toString().trim());
    }

    private static void protectedCheck(Field[] fields, String s) {
        StringBuilder builder = new StringBuilder();
        for (Field field : fields) {
            if (Modifier.isProtected(field.getModifiers())) {
                builder.append(s)
                        .append(field.getType().getSimpleName())
                        .append(" ")
                        .append(field.getName())
                        .append(System.lineSeparator());
            }
        }
        System.out.println(builder.toString().trim());
    }

    private static void privateCheck(Field[] fields, String s) {
        StringBuilder sb = new StringBuilder();
        for (Field field : fields) {
            if (Modifier.isPrivate(field.getModifiers())) {
                sb.append(s)
                        .append(field.getType().getSimpleName())
                        .append(" ")
                        .append(field.getName())
                        .append(System.lineSeparator());
            }
        }
        System.out.println(sb.toString().trim());
    }
}
