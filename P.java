import java.util.ArrayList;
import java.util.Scanner;
 class Contact {
    private String name;
    private String phone;
    private String email;
    private String address;
    public Contact(String name, String phone, String email, String address) {
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}

 class ContactManager {
    private ArrayList<Contact> contacts;
    private Scanner scanner;

    public ContactManager() {
        contacts = new ArrayList<>();
        scanner = new Scanner(System.in);
    }

    // Add contact
    public void addContact() {
        System.out.print("Enter name: ");
        String name = scanner.nextLine();
        System.out.print("Enter phone: ");
        String phone = scanner.nextLine();
        System.out.print("Enter email: ");
        String email = scanner.nextLine();
        System.out.print("Enter address: ");
        String address = scanner.nextLine();
        Contact contact = new Contact(name, phone, email, address);
        contacts.add(contact);
    }

    // Update contact
    public void updateContact() {
        System.out.print("Enter contact index (1-" + contacts.size() + "): ");
        int index = scanner.nextInt() - 1;
        scanner.nextLine(); // Consume newline left-over

        if (index >= 0 && index < contacts.size()) 
        {
            Contact contact = contacts.get(index);
            System.out.print("Enter new name: ");
            contact.setName(scanner.nextLine());
            System.out.print("Enter new phone: ");
            contact.setPhone(scanner.nextLine());
            System.out.print("Enter new email: ");
            contact.setEmail(scanner.nextLine());
            System.out.print("Enter new address: ");
            contact.setAddress(scanner.nextLine());
        } 
        else {
            System.out.println("Invalid index.");
        }
    }

    // Delete contact
    public void deleteContact() {
        System.out.print("Enter contact index (1-" + contacts.size() + "): ");
        int index = scanner.nextInt() - 1;
        scanner.nextLine(); // Consume newline left-over

        if (index >= 0 && index < contacts.size()) 
        {
            contacts.remove(index);
            System.out.println("Deleted successfully");
        } 
        else {
            System.out.println("Invalid index.");
        }
    }

    // View contacts
    public void viewContacts() {
        if (contacts.isEmpty()) {
            System.out.println("Empty");
            return;
        } 

        for (int i = 0; i < contacts.size(); i++) 
        {
            Contact contact = contacts.get(i);
            System.out.println((i + 1) + ". Name: " + contact.getName() +
                    ", Phone: " + contact.getPhone() +
                    ", Email: " + contact.getEmail() +
                    ", Address: " + contact.getAddress());
        }
    }

    // Main menu
    public void run() {
        while (true) {
            System.out.println("1. Add Contact");
            System.out.println("2. Update Contact");
            System.out.println("3. Delete Contact");
            System.out.println("4. View Contacts");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            int option = scanner.nextInt();
            scanner.nextLine(); 

            switch (option) {
                case 1:
                    addContact();
                    break;
                case 2:
                    updateContact();
                    break;
                case 3:
                    deleteContact();
                    break;
                case 4:
                    viewContacts();
                    break;
                case 5:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid option.");
            }
        }
    }
}
class P {
    public static void main(String[] args) {
        ContactManager contactManager = new ContactManager();
        contactManager.run();
    }
}