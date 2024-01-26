import java.util.Set;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Map;
import java.util.HashMap;

public class Shop {
    public static void main(String[] args) {
        Set<Notebook> notebooks = new HashSet<>();
        Notebook notebook1 = new Notebook("Dell", "DOS", "Intel", 16, 512);
        Notebook notebook2 = new Notebook("Dell", "Windows", "AMD", 32, 1024);
        Notebook notebook3 = new Notebook("Apple", "MacOS", "Apple", 8, 256);
        Notebook notebook4 = new Notebook("Apple", "MacOS", "Apple", 16, 512);
        Notebook notebook5 = new Notebook("HP", "Linux", "AMD", 32, 1024);
        Notebook notebook6 = new Notebook("HP", "Windows", "Intel", 16, 512);
        Notebook notebook7 = new Notebook("Lenovo", "DOS", "Intel", 32, 512);
        Notebook notebook8 = new Notebook("Lenovo", "Windows", "Intel", 8, 256);
        Notebook notebook9 = new Notebook("Asus", "Windows", "Intel", 16, 512);
        Notebook notebook10 = new Notebook("Asus", "Linux", "AMD", 8, 256);

        notebooks.add(notebook1);
        notebooks.add(notebook2);
        notebooks.add(notebook3);
        notebooks.add(notebook4);
        notebooks.add(notebook5);
        notebooks.add(notebook6);
        notebooks.add(notebook7);
        notebooks.add(notebook8);
        notebooks.add(notebook9);
        notebooks.add(notebook10);

        Scanner input = new Scanner(System.in);
        System.out.println("\"Выберите нужные характеристики, по которым хотите отфильтровать ноутбуки: \n" +
                "1 - Брэнд (asus, hp, apple, lenovo, dell)\n" +
                "2 - Операционная система (windows, dos, macos, linux)\n" +
                "3 - Процессор (intel, amd, apple)\n" +
                "4 - ОЗУ (Гб)\n" +
                "5 - Объем ЖД (Гб)\n" +
                "0 - Завершить ввод");

        int choice;
        String value;
        Map<Integer, String> filters = new HashMap<>();

        do {
            System.out.print("Введите номер характеристики: ");
            choice = input.nextInt();
            input.nextLine();  // очистка буфера

            if (choice != 0) {
                System.out.print("Введите значение характеристики: ");
                value = input.nextLine();

                filters.put(choice, value);
            }
        } while (choice != 0);

        Set<Notebook> filteredNotebooks = filterAll(notebooks, filters);

        for (Notebook notebook : filteredNotebooks) {
            System.out.println(notebook);
        }
    }

    public static Set<Notebook> filterAll(Set<Notebook> notebooks, Map<Integer, String> filters) {
        Set<Notebook> filteredNotebooks = new HashSet<>(notebooks);

        for (Map.Entry<Integer, String> filter : filters.entrySet()) {
            int choice = filter.getKey();
            String value = filter.getValue();

            filteredNotebooks = filterOne(filteredNotebooks, choice, value);
        }

        return filteredNotebooks;
    }

    public static Set<Notebook> filterOne(Set<Notebook> notebooks, int choice, String value) {
        Set<Notebook> filteredNotebooks = new HashSet<>();

        for (Notebook notebook : notebooks) {
            switch (choice) {
                case 1:
                    if (notebook.getBrand().equalsIgnoreCase(value)) {
                        filteredNotebooks.add(notebook);
                    }
                    break;
                case 2:
                    if (notebook.getOs().equalsIgnoreCase(value)) {
                        filteredNotebooks.add(notebook);
                    }
                    break;
                case 3:
                    if (notebook.getCpu().equalsIgnoreCase(value)) {
                        filteredNotebooks.add(notebook);
                    }
                    break;
                case 4:
                    if (notebook.getRam() == Integer.parseInt(value)) {
                        filteredNotebooks.add(notebook);
                    }
                    break;
                case 5:
                    if (notebook.getStorage() == Integer.parseInt(value)) {
                        filteredNotebooks.add(notebook);
                    }
                    break;
            }
        }

        return filteredNotebooks;
    }
}
