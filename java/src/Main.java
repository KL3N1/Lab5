public class Main {
    public static void main(String[] args) {
        try {
            // Создаём меню
            Menu menu = new Menu();
            menu.addDish(new Dish("Борщ", 250.0f, 1));
            menu.addDish(new Dish("Пельмени", 300.0f, 1));
            menu.print();

            // Создаём клиента и сотрудника
            Client client = new Client("Иван Иванов", "89005555555");
            Employee employee = new Employee("Сергей Петров", 101);

            // Работа с одномерным массивом заказов
            System.out.println("Работа с одномерным массивом заказов:");
            Order[] orders = new Order[3];
            for (int i = 0; i < orders.length; i++) {
                orders[i] = new Order(client, employee);
                try {
                    orders[i].addDish(menu.getDish(i % menu.getDishCount()));
                } catch (IndexOutOfBoundsException e) {
                    System.out.printf("Ошибка добавления блюда в заказ %d: %s%n", i + 1, e.getMessage());
                }
                orders[i].print();
            }

            // Работа с двумерным массивом заказов
            System.out.println("Работа с двумерным массивом заказов:");
            Order[][] orderMatrix = new Order[3][3]; // 3 дня, 3 столика

            for (int day = 0; day < 3; day++) {
                for (int table = 0; table < 3; table++) {
                    orderMatrix[day][table] = new Order(client, employee);
                    try {
                        orderMatrix[day][table].addDish(menu.getDish((day + table) % menu.getDishCount()));
                    } catch (IndexOutOfBoundsException e) {
                        System.out.printf("Ошибка добавления блюда: День %d, Стол %d: %s%n", day + 1, table + 1, e.getMessage());
                    }
                }
            }

            // Печать двумерного массива заказов
            for (int day = 0; day < 3; day++) {
                System.out.printf("День %d:%n", day + 1);
                for (int table = 0; table < 3; table++) {
                    System.out.printf("  Стол %d:%n", table + 1);
                    orderMatrix[day][table].print();
                }
            }

        } catch (Exception e) {
            System.out.println("Общая ошибка: " + e.getMessage());
        }
    }
}
