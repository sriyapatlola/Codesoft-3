import java.util.ArrayList;
import java.util.Scanner;
public class codesoft{
static class Contacts {
    private String name;
    private String mobilenumber;
    private String emailid;
    public Contacts(String name, String mobilenumber, String emailid) {
        this.name = name;
        this.mobilenumber = mobilenumber;
        this.emailid = emailid;
    }
    public String togetname() {
        return name;
    }
    public String togetmobilenumber() {
        return mobilenumber;
    }
    public String togetEmailid() {
        return emailid;
    }
    @Override
    public String toString() {
        return "Name: " + name + ", mobile number: " + mobilenumber + ", Email id: " + emailid;
    }
}
static class AddressBook {
    private ArrayList<Contacts> details = new ArrayList<>();

    public void addContact(Contacts contact) {
        details.add(contact);
    }
    public void deleteContact(Contacts contact) {
        details.remove(contact);
    }
    public Contacts searchContact(String name) {
        for (Contacts contact : details) {
            if (contact.togetname().equalsIgnoreCase(name)) {
                return contact;
            }
        }
        return null;
    }
    public ArrayList<Contacts> AllContacts() {
        return details;
    }
}
 public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        AddressBook alldetails = new AddressBook();
        while (true) {
            System.out.println("ADRESS BOOK SYSTEM");
            System.out.println();
            System.out.println("choose from the following options");
            System.out.println("1)- Add a new contact ");
            System.out.println("2)- delete a contact");
            System.out.println("3)-  Search for a contact");
            System.out.println("4)-  show all the contacts");
            System.out.println("5)-  exit");
            System.out.println();
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline
            switch (choice) {
                case 1:
                    System.out.print("Enter the name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter the mobile number: ");
                    String mobilenumber = scanner.nextLine();
                    System.out.print("Enter email id: ");
                    String emailid = scanner.nextLine();
                    Contacts newContact = new Contacts(name, mobilenumber, emailid);
                    alldetails.addContact(newContact);
                    System.out.println("Contact added successfully.");
                     System.out.println();
                    break;
                case 2:
                    System.out.print("Enter the name of the contact to remove: ");
                    String contactToRemove = scanner.nextLine();
                    Contacts deletedContact = alldetails.searchContact(contactToRemove);
                    if (deletedContact != null) {
                        alldetails.deleteContact(deletedContact);
                        System.out.println("Contact removed successfully.");
                        System.out.println();
                    } else {
                        System.out.println("Contact not found.");
                         System.out.println();
                    }
                    break;
                case 3:
                    System.out.print("Enter the name of the contact to search: ");
                    String contactToSearch = scanner.nextLine();
                    Contacts contactfound = alldetails.searchContact(contactToSearch);
                    if (contactfound != null) {
                        System.out.println("Contact has been found: " + contactfound);
                    } else {
                        System.out.println("Contact not found.");
                         System.out.println();
                    }
                    break;
                case 4:
                    ArrayList<Contacts> allContacts = alldetails.AllContacts();
                    if (!allContacts.isEmpty()) {
                        System.out.println("All Contacts:");
                         System.out.println();
                        for (Contacts contact : allContacts) {
                            System.out.println(contact);
                        }
                    } else {
                        System.out.println("No contacts found in the address book.");
                    }
                    break;
                case 5:
                    System.out.println("Exit!!");
                    System.exit(0);
                    break;

                default:
                    System.out.println("Incorrect choice. Please select a valid option.");
            }
    }
}








}