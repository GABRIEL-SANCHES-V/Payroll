
import java.util.ArrayList;
import java.util.Scanner;

public class Employee {
    private final Person person;
    private final Contract contract;


    public Employee() {
        this.person = newPerson();
        this.contract = newContract();
    }

    private Person newPerson(){

        Scanner keyboard = new Scanner(System.in);

        System.out.print("Nome do funcionário: ");
        String nameEmployee = keyboard.nextLine();

        System.out.print("Data de nascimento (dd/mm/aaaa): ");
        String birthdate = keyboard.nextLine();

        return new Person(nameEmployee, birthdate);

    }

    private Contract newContract(){

        Scanner keyboard = new Scanner(System.in);

        System.out.print("Tipo do contrato: ");
        String typeContract = keyboard.nextLine();

        while (!typeContract.toLowerCase().equals("efetivo") && !typeContract.toLowerCase().equals("horista")){
            System.out.println("Tipo de contrato invalido.");
            System.out.print("Digite novamente o tipo do contrato: ");
            typeContract = keyboard.nextLine();
        }

        double grossHours = 160.0;

        if (typeContract.toLowerCase().equals("horista")) {
            System.out.print("Horas brutas: ");
            grossHours = keyboard.nextDouble();
            keyboard.nextLine();
        }

        System.out.print("Data de contratação (dd/mm/aaaa): ");
        String admissionDate = keyboard.nextLine();

        System.out.print("Salário: ");
        double wage = keyboard.nextDouble();

        System.out.print("Número de filhos menores de idade: ");
        int numberMinorChildren = keyboard.nextInt();

        return new Contract(typeContract, admissionDate, wage, numberMinorChildren, grossHours);
    }

    public Person getPerson(){
        return person;
    }

    public Contract getContract(){
        return contract;
    }

    public void setNumberMinorChildren (int numberMinorChildren){
        this.contract.setNumberMinorChildren(numberMinorChildren);
    }

    public int getNumberMinorChildren() {
        return contract.getNumberMinorChildren();
    }

    public void setTypeContract (String typeContract){
        this.contract.setTypeContract(typeContract);
    }

    public String getTypeContract (){
        return contract.getTypeContract();
    }

    public void setAdmissionDate (String admissionDate){
        this.contract.setAdmissionDate(admissionDate);
    }

    public String getAdmissionDate (){
        return contract.getAdmissionDate();
    }

    public void setWage (double wage){
        this.contract.setWage(wage);
    }

    public double getWage(){
        return contract.getWage();
    }

    protected void setWorkHours (double workHours){
        this.contract.setWorkHours(workHours);
    }

    protected double setWorkHours (){
        return contract.getWorkHours();
    }

}
