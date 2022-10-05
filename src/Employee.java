import java.util.ArrayList;
import java.util.Scanner;

public class Employee {
    private ArrayList<Employee> employee;
    private Person person;
    private Contract contract;


    public Employee() {
        this.employeeRegistration();
    }

    private Person newPerson(){

        Scanner keyboard = new Scanner(System.in);

        System.out.print("Nome do funcionário: ");
        String nameEmployee = keyboard.nextLine();

        System.out.print("Data de nascimento: ");
        String birthDate = keyboard.nextLine();

        return new Person(nameEmployee, birthDate);

    }

    private Contract newContract(){

        Scanner keyboard = new Scanner(System.in);

        System.out.print("Tipo do contrato: ");
        String typeContract = keyboard.nextLine();

        System.out.print("Data de contratação: ");
        String admissionDate = keyboard.nextLine();

        System.out.print("Salário: ");
        double wage = keyboard.nextDouble();

        System.out.print("Número de filhos menores de idade: ");
        int numberMinorChildren = keyboard.nextInt();

        return new Contract(typeContract, admissionDate, wage, numberMinorChildren);
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

    public double grossSalary(double employHours, Contract contract){

        double grossSalary = contract.getWage();

        if(typeContract(contract) == 1){
            return grossSalary;

        } else if(typeContract(contract) == 2){
            return (grossSalary * employHours);

        }

        return 0.0;
    }

    private int typeContract(Contract contract){

        String typeContractInTiny = contract.getTypeContract().toLowerCase();

        if(typeContractInTiny.equals("efetivo")){
            return 1;

        } else if(typeContractInTiny.equals("horista")){

            return 2;
        }

        return 0;

    }

    public double getDiscountINSS (Double grossSalary) {

        double discount = 0.0;
        double aliquot = getAliquotINSS(grossSalary);

        if (grossSalary > 5531.31){
            discount = (5531.31 * aliquot);
            return discount;
        }

        return  (discount * aliquot);
    }

    private double getAliquotINSS(double grossSalary){
        double aliquot = 0.0;

        if (grossSalary <= 1659.38) {
            aliquot = 0.08;
        } else if(1659.39 <= grossSalary && grossSalary <= 2765.66) {
            aliquot = 0.09;
        } else if(2765.67 <= grossSalary) {
            aliquot = 0.11;
        }

        return aliquot;
    }

    public double getDiscountIT(double grossSalary){
        double discount = 0.0;

        if (1903.99 <= grossSalary && grossSalary <= 2826.65) {
            discount = (grossSalary * 0.075) - 142.8;
        } else if(2826.66 <= grossSalary && grossSalary <= 3751.05) {
            discount = (grossSalary * 0.15) - 354.8;
        } else if(3751.06 <= grossSalary && grossSalary <= 4664.68) {
            discount = (grossSalary * 0.225) - 636.13;
        } else {
            discount = (grossSalary * 0.275) - 869.36;
        }

        return discount;
    }

    public double getNetSalary(double grossSalary){
        
        double discountINSS = getDiscountINSS(grossSalary);
        double discountIT = getDiscountIT(grossSalary);

        return (grossSalary - discountIT - discountINSS);
    }

    public void employeeRegistration(){
        this.newPerson();
        this.newContract();
        employee = new ArrayList<Employee>();
        employee.add(new Employee());

    }

    public void payroll(ArrayList<Employee> employee){

        Person person = getPerson();
        Contract contract = getContract();

        System.out.println("FOLHA DE PAGAMENTO:");

        for(int i = 0; i < employee.size(); i++)
        {
            System.out.printf("Funcionário: %s");
        }
    }



}
