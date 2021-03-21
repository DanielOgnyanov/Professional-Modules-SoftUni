package WorkingWithAbstraction.GreedyTimes;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        long capacityBag = Long.parseLong(scanner.nextLine());
        String[] initialItemNameAndQuantity = scanner.nextLine().split("\\s+");

        Map<String, LinkedHashMap<String, Long>> saveAllItems = new LinkedHashMap<>();
        long gold = 0;
        long gem = 0;
        long money = 0;

        for (int i = 0; i < initialItemNameAndQuantity.length; i += 2) {
            FindTypeOfItem findTypeOfItem = new FindTypeOfItem(capacityBag, initialItemNameAndQuantity, saveAllItems, i).invoke();
            if (findTypeOfItem.is()) continue;
            String name = findTypeOfItem.getName();
            long currentQuantity = findTypeOfItem.getCurrentQuantity();
            String typeOfItem = findTypeOfItem.getTypeOfItem();

            switch (typeOfItem) {
                case "Gem":
                    if (addingQuantityOfItems(saveAllItems, currentQuantity, typeOfItem, "Gold")) continue;
                    break;
                case "Cash":
                    if (addingQuantityOfItems(saveAllItems, currentQuantity, typeOfItem, "Gem")) continue;
                    break;
            }

            if (!saveAllItems.containsKey(typeOfItem)) {
                saveAllItems.put((typeOfItem), new LinkedHashMap<String, Long>());
            }

            if (!saveAllItems.get(typeOfItem).containsKey(name)) {
                saveAllItems.get(typeOfItem).put(name, 0L);
            }


            saveAllItems.get(typeOfItem).put(name, saveAllItems.get(typeOfItem).get(name) + currentQuantity);
            if (typeOfItem.equals("Gold")) {
                gold += currentQuantity;
            } else if (typeOfItem.equals("Gem")) {
                gem += currentQuantity;
            } else if (typeOfItem.equals("Cash")) {
                money += currentQuantity;
            }
        }

        printFinalResult(saveAllItems);
    }

    private static boolean addingQuantityOfItems(Map<String, LinkedHashMap<String, Long>> saveAllItems, long currentQuantity, String typeOfItem, String gold2) {
        if (!saveAllItems.containsKey(typeOfItem)) {
            if (saveAllItems.containsKey(gold2)) {
                if (currentQuantity > saveAllItems.get("Gold").values().stream().mapToLong(e -> e).sum()) {
                    return true;
                }
            } else {
                return true;
            }
        } else if (saveAllItems.get(typeOfItem).values().stream()
                .mapToLong(e -> e).sum() + currentQuantity > saveAllItems.get(gold2).values().stream().mapToLong(e -> e).sum()) {
            return true;
        }
        return false;
    }

    private static void printFinalResult(Map<String, LinkedHashMap<String, Long>> saveAllItems) {
        for (var x : saveAllItems.entrySet()) {
            Long sumValues = x.getValue().values().stream().mapToLong(l -> l).sum();

            System.out.println(String.format("<%s> $%s", x.getKey(), sumValues));

            x.getValue().entrySet().stream().sorted((e1, e2) -> e2.getKey().compareTo(e1.getKey())).forEach(i -> System.out.println("##" + i.getKey() + " - " + i.getValue()));

        }
    }

    public static class FindTypeOfItem {
        private boolean myResult;
        private long capacityBag;
        private String[] initialItemNameAndQuantity;
        private Map<String, LinkedHashMap<String, Long>> saveAllItems;
        private int i;
        private String name;
        private long currentQuantity;
        private String typeOfItem;

        public FindTypeOfItem(long capacityBag, String[] initialItemNameAndQuantity, Map<String, LinkedHashMap<String, Long>> saveAllItems, int i) {
            this.capacityBag = capacityBag;
            this.initialItemNameAndQuantity = initialItemNameAndQuantity;
            this.saveAllItems = saveAllItems;
            this.i = i;
        }

        boolean is() {
            return myResult;
        }

        public String getName() {
            return name;
        }

        public long getCurrentQuantity() {
            return currentQuantity;
        }

        public String getTypeOfItem() {
            return typeOfItem;
        }

        public FindTypeOfItem invoke() {
            name = initialItemNameAndQuantity[i];
            currentQuantity = Long.parseLong(initialItemNameAndQuantity[i + 1]);

            typeOfItem = "";

            if (name.length() == 3) {
                typeOfItem = "Cash";
            } else if (name.toLowerCase().endsWith("gem")) {
                typeOfItem = "Gem";
            } else if (name.toLowerCase().equals("gold")) {
                typeOfItem = "Gold";
            }

            if (typeOfItem.equals("")) {
                myResult = true;
                return this;
            } else if (capacityBag < saveAllItems.values().stream()
                    .map(Map::values)
                    .flatMap(Collection::stream)
                    .mapToLong(e -> e).sum() + currentQuantity) {
                myResult = true;
                return this;
            }
            myResult = false;
            return this;
        }
    }
}
