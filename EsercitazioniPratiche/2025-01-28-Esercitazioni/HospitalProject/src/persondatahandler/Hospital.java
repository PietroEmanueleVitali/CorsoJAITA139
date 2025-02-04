package persondatahandler;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Hospital {

    public ArrayList<Person> hospitalPoeple = new ArrayList<>();

    public Hospital(String path1, String path2, String path3)
    {
        for (String filePath : new String[]{path1, path2, path3})
        {
            try{
                Scanner fileReader = new Scanner(new File(filePath));
                while(fileReader.hasNextLine())
                {
                    String[] lineContent = fileReader.nextLine().split(",");
                    if(filePath.equalsIgnoreCase("res/pazienti.txt"))
                    {
                        hospitalPoeple.add(new Patient(lineContent[0], lineContent[1],lineContent[2],lineContent[3],lineContent[4],lineContent[5],lineContent[6]));
                    }
                    else if(filePath.equalsIgnoreCase("res/dottori.txt"))
                    {
                        hospitalPoeple.add(new Doctor(lineContent[0], lineContent[1],lineContent[2],lineContent[3],lineContent[4],lineContent[5],lineContent[6]));
                    }
                    else if(filePath.equalsIgnoreCase("res/chirurghi.txt"))
                    {
                        hospitalPoeple.add(new Surgeon(lineContent[0], lineContent[1],lineContent[2],lineContent[3],lineContent[4],lineContent[5],lineContent[6], lineContent[7], lineContent[8]));
                    }
                    else{
                        System.out.println("path non trovato");
                    }
                }
            }catch(FileNotFoundException e){
                System.out.println("Non è stato possibile trovare il file: " + filePath);
            }catch(NullPointerException e) {
                System.out.println("Al file arriva una reference nulla");
            }
        }
    }

    @Override
    public String toString() {
    
        String returntostring = "";

         for(var people : hospitalPoeple)
         {
            returntostring += people.toString() + "\n";
         }

         return returntostring;
    }

    public void patientList(){
        for(var people : hospitalPoeple)
        {
            if(people instanceof  Patient p)
                System.out.println(p.toString());
        }
    }
    public void doctorList(){
        for(var people : hospitalPoeple)
        {
            if(people instanceof  Doctor doctor)
                System.out.println(doctor.toString());
        }
    }

    public void doctorListWithEx(){
        for(var people : hospitalPoeple)
        {
            if(people instanceof  Doctor doctor)
                if(doctor.getYearsOfWork() > 10)
                    System.out.println(doctor.toString());
        }
    }

    public void doctorListForCity(String city){
        for(var people : hospitalPoeple)
        {
            if(people instanceof  Doctor doctor)
                if(doctor.getResidence().equalsIgnoreCase(city))
                    System.out.println(doctor.toString());
        }
    }
    public void doctorGood(){
        for(var people : hospitalPoeple)
        {
            if(people instanceof  Doctor doctor)
                if(doctor.goodDoctor())
                    System.out.println(doctor.toString());
        }
    }

    public double doctorAverageEarnings(String specialization){
        double average = 0;
        int count = 0;
        for(var people : hospitalPoeple)
        {
            if(people instanceof  Doctor doctor)
                if(doctor.getResidence().equalsIgnoreCase(specialization))
                    {
                        average += doctor.getSalary();
                        count ++;
                    }
        }
        return average/count;
    }

    public void priceFortreatment()
    {
        int total = 0;
        for(var people : hospitalPoeple)
        {
            if(people instanceof  Patient p)
                System.out.println(p.getName() + " deve pagare: " + p.howMuchForThis());
        }
    }

    public void mostPopularDepartment()
    {
        ArrayList<String> department = new ArrayList<>();

        for(var people : hospitalPoeple)
        {
            if(people instanceof  Patient p)
                {
                    department.add(p.getDepartment());
                }
        }

        int counter = 0;
        int theHighest = 0;
        String departmentName = "";
        for(int i = 0; i < department.size(); i++)
        {
            counter = 0;
            for(int j = 0; j < department.size(); j++)
            {
                if(department.get(i).equalsIgnoreCase(department.get(j)))
                {
                    counter++;
                }    
            }
            if(theHighest < counter)
            {
                theHighest = counter;
                departmentName = department.get(i);
            }
        }

        System.out.println("Il reparto con più persone è: " + departmentName);
    }



     /*
            "9 - Reparto con più pazienti");

  */

}
