package Item87Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import Item87.Address;
import Item87.Employee;
import Item87.Person;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import org.junit.jupiter.api.Test;

public class SerializationTest {

    @Test
    void testSerialization() throws IOException, ClassNotFoundException {
        Person person = new Person();
        person.setAge(20);
        person.setName("Joe");

        FileOutputStream fileOutputStream
            = new FileOutputStream("yourfile.txt");
        ObjectOutputStream objectOutputStream
            = new ObjectOutputStream(fileOutputStream);
        objectOutputStream.writeObject(person);
        objectOutputStream.flush();
        objectOutputStream.close();

        FileInputStream fileInputStream
            = new FileInputStream("yourfile.txt");
        ObjectInputStream objectInputStream
            = new ObjectInputStream(fileInputStream);
        Person p2 = (Person) objectInputStream.readObject();
        objectInputStream.close();

        assertEquals(p2.getAge(), person.getAge());
        assertEquals(p2.getName(), person.getName());
    }

    @Test
    void testCustomDeserialization()
        throws IOException, ClassNotFoundException {
        Person p = new Person();
        p.setAge(20);
        p.setName("Joe");

        Address a = new Address();
        a.setHouseNumber(1);

        Employee e = new Employee();
        e.setPerson(p);
        e.setAddress(a);

        FileOutputStream fileOutputStream
            = new FileOutputStream("yourfile2.txt");
        ObjectOutputStream objectOutputStream
            = new ObjectOutputStream(fileOutputStream);
        objectOutputStream.writeObject(e);
        objectOutputStream.flush();
        objectOutputStream.close();

        FileInputStream fileInputStream
            = new FileInputStream("yourfile2.txt");
        ObjectInputStream objectInputStream
            = new ObjectInputStream(fileInputStream);
        Employee e2 = (Employee) objectInputStream.readObject();
        objectInputStream.close();

        assertEquals(e2.getPerson().getAge(), e.getPerson().getAge());
        assertEquals(e2.getAddress().getHouseNumber(), e.getAddress().getHouseNumber());
    }
}
