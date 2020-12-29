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
    public void viewByCity()
    {
        String city;
        Dictionary infoCity=new Hashtable();
        System.out.println("Enter city name:");
        city=s.nextLine();
        List<Person> streamList=person.stream().filter(person1 ->city.equals(person1.getCity()) ).collect(Collectors.toList());
        System.out.println("Persons in city: "+streamList);
        for(Person a:person)
        {
            if(a.city.equals(city))
            {
                infoCity.put(a.firstName,city);
            }
        }
        System.out.println("The Dictionary Contains:"+infoCity);
    }
    public void viewByState()
    {
        String state;
        Dictionary infoState=new Hashtable();
        System.out.println("Enter State name:");
        state=s.nextLine();
        List<Person> streamList=person.stream().filter(person1 ->state.equals(person1.getState()) ).collect(Collectors.toList());
        System.out.println("Persons in State: "+streamList);
        for(Person a:person)
        {
            if(a.city.equals(state))
            {
                infoState.put(a.firstName,state);
            }

        }
        System.out.println("The Dictionary Contains:"+infoState);
    }
    public void viewCountByCity()
    {
        String city;
        System.out.println("Enter city name:");
        city=s.nextLine();
        int cnt= (int) person.stream().filter(person1 ->city.equals(person1.getCity()) ).count();
        System.out.println("Total Person Count in "+city+" city is:"+cnt);
    }
    public void viewCountByState()
    {
        String state;
        System.out.println("Enter city name:");
        state=s.nextLine();
        int cnt= (int) person.stream().filter(person1 ->state.equals(person1.getState()) ).count();
        System.out.println("Total Person Count in "+state+" city is:"+cnt);
    }
    public void sortByName()
    {
        List<Person> nameSortedList=person.stream().sorted((e1,e2)->e1.getFirstName().compareTo(e2.getFirstName())).collect(Collectors.toList());
        System.out.println("Sorted Persons Alphabetically\n: "+nameSortedList);
    }
    public void sortByCity()
    {
        List<Person> citySortedList=person.stream().sorted((e1,e2)->e1.getCity().compareTo(e2.getCity())).collect(Collectors.toList());
        System.out.println("Sorted Persons by City\n: "+citySortedList);
    }
    public void sortByState()
    {
        List<Person> stateSortedList=person.stream().sorted((e1,e2)->e1.getState().compareTo(e2.getState())).collect(Collectors.toList());
        System.out.println("Sorted Persons by State\n: "+stateSortedList);
    }
    public void sortByZip()
    {
        List<Person> zipSortedList=person.stream().sorted((e1,e2)->e1.getState().compareTo(e2.getState())).collect(Collectors.toList());
        System.out.println("Sorted Persons by Zip\n: "+zipSortedList);
    }
}
