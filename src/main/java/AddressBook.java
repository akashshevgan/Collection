import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class AddressBook extends Contact{

    Person person;
    Contact contact;

    public Person getPerson() {

        return person;
    }

    public void setPerson(Person person) {

        this.person = person;
    }

    public Contact getContact() {

        return contact;
    }

    public void setContact(Contact contact) {

        this.contact = contact;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AddressBook that = (AddressBook) o;
        return person.equals(that.person) && contact.equals(that.contact);
    }

    @Override
    public int hashCode() {
        return Objects.hash(person, contact);
    }

    public static void main(String[] args) {

        System.out.println("Welcome to Address Book Program");
        List<AddressBook> addressBooks = new ArrayList<>();
        System.out.println("add address book 1 please enter");
        addRecord(addressBooks);
        System.out.println("add address book 2 please enter");
        addRecord(addressBooks);
        System.out.println("add address book 3 please enter");
        addRecord(addressBooks);
        System.out.println("enter person first name for delete");
        Scanner in = new Scanner(System.in);
        String firstName = in.nextLine();
        AddressBook addressBook = searchRecord(firstName, addressBooks);
        if (addressBook==null){
            System.out.println("record not found");
            System.exit(0);
        }
        addressBooks.remove(addressBook);
        System.out.println("record deleted");
        recordAfterDelete(addressBooks);

        System.out.println("if you want to search by state enter 1 or city enter 2");
        Scanner choice = new Scanner(System.in);
        int a = in.nextInt();


        if(a==1){
            System.out.println("Enter state name ");
            String s = in.nextLine();
            searchByCity(s,addressBooks);
            System.out.println(searchByCity(s,addressBooks));
        }else {
            System.out.println("Enter City name ");
            String s = in.nextLine();
            System.out.println(searchByCity(s,addressBooks));
        }
        System.out.println("if you want to count by state enter 1 or city enter 2");

        if(a==1){
            System.out.println("Enter state name ");
            String s = in.nextLine();
            System.out.println(searchByCity(s,addressBooks));
        }else {
            System.out.println("Enter City name ");
            String s = in.nextLine();
            System.out.println(countByCity(s,addressBooks));
        }

    }

    static AddressBook searchRecord(String firstName, List<AddressBook> addressBooks){
        for(AddressBook addressBook: addressBooks){
            if(addressBook.getPerson().getFirstName().equals(firstName)){
                return addressBook;
            }
        }
        return null;
    }

    static AddressBook searchByCity(String city, List<AddressBook> addressBooks){
        for(AddressBook addressBook: addressBooks){
            if(addressBook.getContact().getCity(city)){
                return addressBook;
            }
        }
        return null;
    }

    static AddressBook searchByState(String state, List<AddressBook> addressBooks){
        for(AddressBook addressBook: addressBooks){
            if(addressBook.getContact().getState(state)){
                return addressBook;
            }
        }
        return null;
    }

    static AddressBook countByCity(String city, List<AddressBook> addressBooks){
        for(AddressBook addressBook: addressBooks){
            if(addressBook.getContact().getCity(city)){
                return addressBook;
           }
        }
        return null;
    }

    static AddressBook countByState(String state, List<AddressBook> addressBooks){
        for(AddressBook addressBook: addressBooks){
            if(addressBook.getContact().getState(state)){
                return addressBook;
            }
        }
        return null;
    }

    static AddressBook recordAfterDelete(List<AddressBook> addressBooks){
        for(AddressBook addressBook: addressBooks){
            System.out.println("FirstName = " + addressBook.getPerson().getFirstName());
            System.out.println("lastName = " + addressBook.getPerson().getLastName());
            System.out.println("City = " + addressBook.getContact().getCity());
            System.out.println("Email = " + addressBook.getContact().getEmail());
            System.out.println("State = " + addressBook.getContact().getState());
            System.out.println("PhoneNumber = " + addressBook.getContact().getPhoneNumber());
            System.out.println("Zipcode = " + addressBook.getContact().getZipCode());
        }
        return null;
    }

    static void addRecord(List<AddressBook> addressBooks){

        Scanner in = new Scanner(System.in);
        Person person = new Person();
        Contact contact = new Contact();
        System.out.println("Enter first name ");
        String s = in.nextLine();
        person.setFirstName(s);
        System.out.println("Enter last name ");
        s = in.nextLine();
        person.setLastName(s);
        System.out.println("Enter city ");
        s = in.nextLine();
        contact.setCity(s);
        System.out.println("Enter email ");
        s = in.nextLine();
        contact.setEmail(s);
        System.out.println("Enter state ");
        s = in.nextLine();
        contact.setState(s);
        System.out.println("Enter phone number ");
        int a = in.nextInt();
        contact.setPhoneNumber(a);
        System.out.println("Enter zipcode ");
        a = in.nextInt();
        contact.setZipCode(a);

        System.out.println("Record added in address book");

        AddressBook addressBook = new AddressBook();
        addressBook.setPerson(person);
        addressBook.setContact(contact);
        addressBooks.add(addressBook);

        System.out.println("FirstName = " + addressBook.getPerson().getFirstName());
        System.out.println("lastName = " + addressBook.getPerson().getLastName());
        System.out.println("City = " + addressBook.getContact().getCity());
        System.out.println("Email = " + addressBook.getContact().getEmail());
        System.out.println("State = " + addressBook.getContact().getState());
        System.out.println("PhoneNumber = " + addressBook.getContact().getPhoneNumber());
        System.out.println("Zipcode = " + addressBook.getContact().getZipCode());
    }
}

class Person {
    String firstName;
    String lastName;

    public String getFirstName() {

        return firstName;
    }

    public void setFirstName(String firstName) {

        this.firstName = firstName;
    }

    public String getLastName() {

        return lastName;
    }

    public void setLastName(String lastName) {

        this.lastName = lastName;
    }
}
