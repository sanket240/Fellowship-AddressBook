import java.util.Scanner;

public class AddressBookMain {
    public static void main(String args[]){
        int choice=1,person_count,i;
        Scanner s=new Scanner(System.in);
        PersonMethods personmethods=new PersonMethods();
        while (choice!=0)
        {
            System.out.println("1.Add Person\n2.Update Person\n3.Delete Person\n4.Display Person");
            System.out.println("Enter your choice:");
            choice=s.nextInt();
            switch (choice)
            {
                case 1:
                    System.out.println("Enter Number of persons:");
                    person_count=s.nextInt();
                    for(i=0;i<person_count;i++)
                    {
                        personmethods.CreatePerson();
                    }
                    break;
                case 2:
                    System.out.println("Enter name of person to Update");
                    String name=s.next();
                    System.out.println("Enter what to update(city/state/phone/zip):");
                    String update=s.next();
                    personmethods.UpdatePerson(name,update);
                    break;
                case 3:
                    System.out.println("Enter name of person to Delete");
                    String n=s.next();
                    personmethods.DeletePerson(n);
                    break;
                case 4:
                    personmethods.ViewPerson();
                    break;
            }
        }
    }
}