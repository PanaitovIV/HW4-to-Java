import java.util.*;

public class Main {
    static Scanner iScanner = new Scanner(System.in);
    public static void main(String[] args) {
        ArrayList<String> people = new ArrayList<>();
        people.add("Иванов Иван Иванович 45 М");
        people.add("Васильев Василий Васильевич 33 М");
        people.add("Степанова Ольга Олеговна 21 Ж");
        people.add("Воронцова Светлана Николаевна 51 Ж");
        int programRun = -1;
        while (programRun != 0) {
            System.out.println();
            System.out.println("Действия: ");
            System.out.println("[1] - Ввести новые данные;");
            System.out.println("[2] - Показать имеющиеся данные;");
            System.out.println("[3] - Отсортировать по возрасту;");
            System.out.println("[4] - Отсортировать по возрасту с помощью индексов;");
            System.out.println("[5] - Отсортировать по возрасту и полу с помощью индексов;");
            System.out.println("[0] - выход / выключение программы.");
            System.out.println();
            System.out.print("Выберите нужное действие > ");
            programRun = Integer.parseInt(iScanner.nextLine());
            System.out.println();
            if (programRun == 1) {
                inputData(people);
            }
            if (programRun == 2) {
                printData(people);
            }
            if (programRun == 3) {
                sortAge(people);
                System.out.println(people);
            }
            if (programRun == 4) {
                ArrayList<String> result = sortIndexAge(people);
                System.out.println(result);
            }
            if (programRun == 5) {
                sortIndexGenderAge(people);
            }
        }
        System.out.printf("Завершение работы! \nДо скорых встреч!");
    }

    private static ArrayList inputData(ArrayList<String> people) {
        System.out.printf("Сколько человек нужно добавить: ");
        int n = Integer.parseInt(iScanner.nextLine());
        for (int i = 0; i < n; i++) {
            System.out.print("Данные вводить в формате <Фамилия Имя Отчество Возраст Пол(М/Ж) > ");
            String data = iScanner.nextLine();
            people.add(data);
        }
        return people;
    }

    public static void printData(ArrayList<String> people) {
        for (String i : people) {
            String[] str = i.split(" ");
            System.out.println(str[0] + " " + str[1].toUpperCase().charAt(0) + "." + str[2].toUpperCase().charAt(0) + ". " + str[3] + " " + str[4]);
        }
    }

    public static ArrayList sortAge(ArrayList<String> people) {
        people.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return Integer.parseInt(o1.split(" ")[3]) - Integer.parseInt(o2.split(" ")[3]);
            }
        });
        return people;
    }

    public static ArrayList sortIndexAge(ArrayList<String> people) {
        ArrayList<Integer> tmpAge = new ArrayList<>();
        ArrayList<Integer> sort = new ArrayList<>();
        for (String item : people) {
            String[] str = item.split(" ");
            tmpAge.add(Integer.valueOf(str[3]));
            sort.add(Integer.valueOf(str[3]));
        }
        sort.sort(Comparator.naturalOrder());
        ArrayList<Integer> resultIndex = new ArrayList<>();
        for (int item : sort) {
            int r = tmpAge.indexOf(item);
            resultIndex.add(r);
        }
        ArrayList<String> result = new ArrayList<>();
        for (int i: resultIndex) {
            result.add(people.get(i));
        }
        return result;
    }

    public static void sortIndexGenderAge(ArrayList<String> people) {
        ArrayList<String> male = new ArrayList<>();
        ArrayList<String> female = new ArrayList<>();
        for (String item : people) {
            String[] str = item.split(" ");
            if(str[4].equals("М")){
                male.add(item);
            }
            else{
                female.add(item);
            }
        }
        male = sortAge(male);
        female = sortAge(female);
        ArrayList<String> result = new ArrayList<>();
        result.addAll(male);
        result.addAll(female);
        System.out.println(result);
    }
}