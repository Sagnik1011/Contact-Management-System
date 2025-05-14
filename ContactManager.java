package ContactManagementSys;

import java.util.ArrayList;
import java.util.List;

public class ContactManager {
    private List<Contact> contacts = new ArrayList<>();
    private int nextId = 1;

    public Contact addContact(String name, String phone, String email) {
        Contact c = new Contact(nextId++, name, phone, email);
        contacts.add(c);
        return c;
    }

    public List<Contact> searchByName(String name) {
        List<Contact> results = new ArrayList<>();
        for (Contact c : contacts) {
            if (c.getName().toLowerCase().contains(name.toLowerCase())) {
                results.add(c);
            }
        }
        return results;
    }

    public List<Contact> searchByNumber(String number) {
        List<Contact> results = new ArrayList<>();
        for (Contact c : contacts) {
            if (c.getPhoneNo().contains(number)) {
                results.add(c);
            }
        }
        return results;
    }

    public boolean deleteById(int id) {
        return contacts.removeIf(c -> c.getId() == id);
    }

    public boolean updateContact(int id, String newName, String newPhone, String newEmail) {
        for (Contact c : contacts) {
            if (c.getId() == id) {
                c.setName(newName);
                c.setPhoneNo(newPhone);
                c.setEmail(newEmail);
                return true;
            }
        }
        return false;
    }
}
