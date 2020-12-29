import java.util.*;
import java.util.stream.Collectors;
public class PersonMethods {
    Scanner s = new Scanner(System.in);
    ArrayList<Person> person = new ArrayList<>();
    public void CreatePerson() {
        Person person1 = new Person();
        System.out.println("Enter Your First Name");
        Scanner scanner = new Scanner(System.in);
        person1.firstName = scanner.nextLine();
       checkDuplicates(person1.firstName, person); //Checking Duplicates
        System.out.println("Enter Your Last Name");
        person1.lastName = scanner.nextLine();
        System.out.println("Enter Your city Name");
        person1.city = scanner.nextLine();
        System.out.println("Enter Your state Name");
        person1.state = scanner.nextLine();
        System.out.println("Enter Your phone Number");
        person1.phNo = scanner.nextLine();
        System.out.println("Enter Your zip");
        person1.zip = scanner.nextInt();
        System.out.println("Added Successfully");
        person.add(person1);
    }
    public void UpdatePerson(String name, String update) //Update Person
    {
        int flag = 0;
        for (Person p : person) {
            if (p.firstName.equals(name)) {
                flag = 1;
                switch (update) {
                    case "city":
                        System.out.println("Enter city name to update:");
                        p.city = s.nextLine();
                        break;
                    case "state":
                        System.out.println("Enter state name to update:");
                        p.state = s.nextLine();
                        break;
                    case "phone":
                        System.out.println("Enter phone number to update:");
                        p.phNo = s.nextLine();
                        break;
                    case "zip":
                        System.out.println("Enter Your zip");
                        p.zip = s.nextInt();
                        break;
                }
            }
        }
        if (flag == 0)
            System.out.println("Person Not Found");
        else
            System.out.println("Updated Successfully");

    }

    public void DeletePerson(String name) //Delete Person
    {
        int flag = 0;
        Iterator<Person> itr = person.iterator();
        while (itr.hasNext())
        {
            Person person = itr.next();
            if (person.firstName.equals(name)) {
                flag = 1;
                itr.remove();
            }
        }
        if (flag == 0)

            System.out.println("Person Not found");
         else
            System.out.println("Deleted Person");

    }
    public void ViewPerson()
    {
        for (Person p : person)
        {
            System.out.println(p);
        }
    }
    public void checkDuplicates(String name, ArrayList<Person> personList)
    {
        Iterator<Person> iterator=personList.iterator();
        while (iterator.hasNext())
        {
            Person person=iterator.next();
            if(person.getFirstName().equals(name)){
                System.out.println("Person Already Present");
                CreatePerson();
            }
        }
    }
    public void searchByCity()
    {
        String city;
        System.out.println("Enter city name:");
        city=s.nextLine();
        // Person p= (Person) person.stream().filter(person1 ->city.equals(person1.getCity()) ).findAny().orElse(null);
        List<Person> streamList=person.stream().filter(person1 ->city.equals(person1.getCity()) ).collect(Collectors.toList());
        System.out.println("Persons in city: "+streamList);
    }
    public void searchByState()
    {
        String state;
        System.out.println("Enter State name:");
        state=s.nextLine();
        List<Person> streamList=person.stream().filter(person1 ->state.equals(person1.getState()) ).collect(Collectors.toList());
        System.out.println("Persons in State: "+streamList);
    }
}
