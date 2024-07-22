import java.util.*;

public class LaptopMain {

    private static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {

        Set<Laptop> laptops = new HashSet<>();
        laptops.add(new Laptop("Honor", 4, 500, "Windows 11", "Серебристый"));
        laptops.add(new Laptop("Apple MacBook", 8, 1000, "MacOS", "Белый"));
        laptops.add(new Laptop("Huawei", 16, 1000, "Windows 11", "Чёрный"));
        laptops.add(new Laptop("Honor", 16, 2000, "Windows 10", "Бежевый"));
        laptops.add(new Laptop("Lenovo", 8, 500, "Windows 10", "Красный"));
        laptops.add(new Laptop("Asus", 16, 500, "Windows 11", "Серебристый"));
        laptops.add(new Laptop("Lenovo", 4, 500, "Linux", "Бежевый"));
        laptops.add(new Laptop("HP", 8, 1000, "Linux", "Белый"));
        laptops.add(new Laptop("Apple MacBook", 4, 500, "MacOS", "Белый"));
        laptops.add(new Laptop("Apple MacBook", 4, 500, "MacOS", "Белый"));

        filterLaptop(requestLaptop(), laptops);
    }

    public static HashMap<String, String> requestLaptop() {

        HashMap<String, String> requestLaptop = new HashMap<>();

        System.out.println("Для вывода списка интересующих вас моделей, ответьте, пожалуйста, на несколько вопросов."
                + System.lineSeparator());

        System.out.println("Выберите модель ноутбука.");
        System.out.println("1) Apple MacBook");
        System.out.println("2) Asus");
        System.out.println("3) Honor");
        System.out.println("4) HP");
        System.out.println("5) Huawei");
        System.out.println("6) Lenovo");
        System.out.println("7) Если затрудняетесь с ответом, нажмите Enter");
        System.out.print("Введите ваш ответ: ");
        requestLaptop.put("model", in.nextLine());
        System.out.println();

        System.out.println("Выберите объём оперативной памяти (RAM) (объём в ГБ): ");
        System.out.println("1) 4");
        System.out.println("2) 8");
        System.out.println("3) 16");
        System.out.println("4) Если затрудняетесь с ответом, введите Enter");
        System.out.print("Введите ваш ответ: ");
        requestLaptop.put("ram", in.nextLine());
        System.out.println();

        System.out.println("Выберите объём жесткого диска (HDD) (объём в ГБ): ");
        System.out.println("1) 500");
        System.out.println("2) 1000");
        System.out.println("3) 2000");
        System.out.println("4) Если затрудняетесь с ответом, введите Enter");
        System.out.print("Введите ваш ответ: ");
        requestLaptop.put("hdd", in.nextLine());
        System.out.println();

        System.out.println("Выберите тип операционной системы: ");
        System.out.println("1) MacOS");
        System.out.println("2) Linux");
        System.out.println("3) Windows 10");
        System.out.println("4) Windows 11");
        System.out.println("5) Если затрудняетесь с ответом, нажмите Enter\"");
        System.out.print("Введите ваш ответ: ");
        requestLaptop.put("operatingSystem", in.nextLine());
        System.out.println();

        System.out.println("Выберите цвет ноутбука: ");
        System.out.println("1) Бежевый");
        System.out.println("2) Белый");
        System.out.println("3) Красный");
        System.out.println("4) Серебристый");
        System.out.println("5) Чёрный");
        System.out.println("6) Если затрудняетесь с ответом, нажмите Enter");
        System.out.print("Введите ваш ответ: ");
        requestLaptop.put("color", in.nextLine());
        System.out.println();

        return requestLaptop;
    }

    public static void filterLaptop(HashMap<String, String> requestLaptop, Set<Laptop> laptops) {
        Boolean isResult = true;

        try {
            for (Laptop el : laptops) {

                if (requestLaptop.get("model").equals(el.getModel()) || requestLaptop.get("model").isEmpty()) {
                    if (Integer.parseInt(requestLaptop.get("ram")) == el.getRam()
                            || Integer.parseInt(requestLaptop.get("ram")) == 0) {
                        if (Integer.parseInt(requestLaptop.get("hdd")) == el.getHdd()
                                || Integer.parseInt(requestLaptop.get("hdd")) == 0) {
                            if (requestLaptop.get("operatingSystem").equals(el.getOperatingSystem())
                                    || requestLaptop.get("operatingSystem").isEmpty()) {
                                if (requestLaptop.get("color").equals(el.getColor())
                                        || requestLaptop.get("color").isEmpty()) {
                                    System.out.println(el);
                                    isResult = false;
                                }
                            }
                        }
                    }
                }
            }
            if (isResult) {
                System.out.println("К сожалению, по вашему запросу ничего не найдено");
            }
        } catch (Exception ex) {
            System.out.print("Ошибка! Некорректный ввод данных! ");
            System.out.println(ex.getMessage());

        } finally {
            System.out.println("Для завершения работы программы нажмите 'q'.");
            System.out.println("Для повторного запроса нажмите 0.");
            System.out.println("Для отображения всех имеющихся в наличии ноутбуков нажмите 1");
            String answerStr = in.nextLine();
            if (answerStr.charAt(0) == 'q' || answerStr.charAt(0) == 'Q') {
                System.out.println("До новой встречи!");
            } else if (answerStr.charAt(0) == '1') {
                System.out.println(laptops.toString().replaceAll("^\\[|\\,|\\]$", ""));
            } else if (answerStr.charAt(0) == '0') {
                filterLaptop(requestLaptop(), laptops);
            } else {
                System.out.println("До новой встречи!");
            }
        }
        in.close();
    }
}