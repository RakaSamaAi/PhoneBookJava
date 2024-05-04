import java.util.*;

public class PhoneBook{
    private HashMap<String, HashSet<String>> contacts;

    public PhoneBook() {
        contacts = new HashMap<>();
    }

    public void addContact(String name, String phoneNumber) {
        contacts.putIfAbsent(name, new HashSet<>());
        contacts.get(name).add(phoneNumber);
    }

    public void printPhoneBook() {
        // Создаем список записей телефонной книги для сортировки
        List<Map.Entry<String, HashSet<String>>> sortedContacts = new ArrayList<>(contacts.entrySet());

        // Сортируем записи телефонной книги по убыванию количества телефонов
        sortedContacts.sort((entry1, entry2) -> Integer.compare(entry2.getValue().size(), entry1.getValue().size()));

        // Выводим отсортированные записи на экран
        for (Map.Entry<String, HashSet<String>> entry : sortedContacts) {
            System.out.println(entry.getKey() + ": " + entry.getValue().size() + " phone(s) - " + entry.getValue());
        }
    }

    public static void main(String[] args) {
        PhoneBook phoneBook = new PhoneBook();
        phoneBook.addContact("John", "123-456-7890");
        phoneBook.addContact("John", "987-654-3210");
        phoneBook.addContact("Alice", "555-123-4567");
        phoneBook.addContact("Bob", "999-888-7777");
        phoneBook.addContact("Alice", "555-987-6543");
        phoneBook.addContact("Alice", "555-777-8888");

        phoneBook.printPhoneBook();
    }
}
