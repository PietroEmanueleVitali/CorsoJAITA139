import StudentHandler.Student;
import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {

    String name;
    String surname;
    String birthDate;

    int studentClass;
    char section;
    float[] votes = new float[6]; //ordine: italiano, matematica, scienze, inglese, educazione fisica, fisica
    // String name, String surname, String yearOfBirth, int studentClass, char section, float[] votes
    
    //Esempio di questo mostro:
    //Student test = new Student("Giovanni", "ciao", "15-09-2011", 5, 'a', new float[]{4f,5f,6f,8f,9f,8f});

    File StudentFile = new File("src/dati.txt");
    Scanner fileReader = new Scanner(StudentFile);

    ArrayList<Student> studentList = new ArrayList<>();

    while(fileReader.hasNextLine())
    {
        name = fileReader.nextLine(); 
        surname = fileReader.nextLine(); 
        birthDate = fileReader.nextLine(); 
        studentClass = Integer.parseInt(fileReader.nextLine());
        section = fileReader.nextLine().charAt(0);
        for(int i = 0; i < votes.length; i++)
        {
            votes[i] = Float.parseFloat(fileReader.nextLine());
        } 

        studentList.add(new Student(name, surname, birthDate, studentClass, section, votes));
    }

    //giusto per vedere se tutto funziona
    for (Student student : studentList)
    {
        System.out.println(student);
        System.out.println(student.ageCalculator());
        System.out.println(student.erasmus());
        System.out.println(student.isPromoted());
        System.out.println(student.hasScholarship());
    }
        

    

    }
}
