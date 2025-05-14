package ContactManagementSys;

import java.util.List;
import java.util.Scanner;

public class Driver {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ContactManager manager = new ContactManager();
        boolean b = true;

        while (b) {
            System.out.println("\nContact Management System");
            System.out.println("1. Add Contact");
            System.out.println("2. Search by Name");
            System.out.println("3. Search by Number");
            System.out.println("4. Update Contact");
            System.out.println("5. Delete Contact");
            System.out.println("6. Exit");
            System.out.print("Choose an option: ");

            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    System.out.print("Name: ");
                    String name = scanner.nextLine();
                    if (!InputChecking.isCorrectName(name)) {
                        System.out.println("Incorrect name");
                        break;
                    }
                    System.out.print("Phone: ");
                    String phone = scanner.nextLine();
                    if (!InputChecking.isCorrectPhone(phone)) {
                        System.out.println("Incorrect phone number");
                        break;
                    }
                    System.out.print("Email: ");
                    String email = scanner.nextLine();
                    if (!InputChecking.isCorrectEmail(email)) {
                        System.out.println("Incorrect email");
                        break;
                    }
                    Contact a = manager.addContact(name, phone, email);
                    System.out.println(a);
                    break;
                case 2:
                    System.out.print("Enter name : ");
                    String searchName = scanner.nextLine();
                    List<Contact> byName = manager.searchByName(searchName);
                    if (byName.isEmpty()) {
                        System.err.println("No contacts found.");
                    } else {
                        byName.forEach(System.out::println);
                    }
                    break;
                case 3:
                    System.out.print("Enter number to search: ");
                    String searchNum = scanner.nextLine();
                    List<Contact> byNum = manager.searchByNumber(searchNum);
                    if (byNum.isEmpty()) {
                        System.err.println("No contacts found.");
                    } else {
                        byNum.forEach(System.out::println);
                    }
                    break;
                case 4:
                    System.out.print("Enter ID to update: ");
                    int updateId = Integer.parseInt(scanner.nextLine());
                    System.out.print("New Name: ");
                    String newName = scanner.nextLine();
                    if (!InputChecking.isCorrectName(newName)) {
                        System.err.println("Incorrect name");
                        break;
                    }
                    System.out.print("New Phone: ");
                    String newPhone = scanner.nextLine();
                    if (!InputChecking.isCorrectPhone(newPhone)) {
                        System.err.println("Incorrect phone number");
                        break;
                    }
                    System.out.print("New Email: ");
                    String newEmail = scanner.nextLine();
                    if (!InputChecking.isCorrectEmail(newEmail)) {
                        System.err.println("Incorrect email");
                        break;
                    }
                    boolean updated = manager.updateContact(updateId, newName, newPhone, newEmail);
                    System.out.println(updated ? "Contact updated successfully." : "Contact ID not found.");
                    break;
                case 5:
                    System.out.print("Enter ID to delete: ");
                    int deleteId = Integer.parseInt(scanner.nextLine());
                    boolean deleted = manager.deleteById(deleteId);
                    System.out.println(deleted ? "Contact deleted." : "Contact ID not found.");
                    break;
                case 6:
                    b = false;
                    System.err.println("Exiting. Goodbye!");
                    break;
                default:
                    System.err.println("Incorrect option");
            }
        }
        scanner.close();
    }
}
