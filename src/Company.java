import java.util.ArrayList;

public class Company {

    ArrayList<Employee> employees = new ArrayList<Employee>();

    public Company(int num){
        this.employees = getEmployees(num);
    }

    private ArrayList<Employee> getEmployees(int employeesCont) {

        ArrayList<Employee> newEmployees = new ArrayList<Employee>();

        for (int i = 0; i < employeesCont; i++) {
            newEmployees.add(new Employee());
            System.out.println("========================================================================================");
        }

        return newEmployees;
    }

    public void payroll(ArrayList<Employee> employees){

        System.out.println("FOLHA DE PAGAMENTO: ");
        System.out.println("NOME: SALÁRIO BRUTO | DISCONTO INSS | DISCONTO IR | SALÁRIO LÍQUIDO");

        for (Employee employee : employees){
            double grossSalary = grossSalary(employee.getContract());
            double discountINSS = getDiscountINSS(grossSalary);
            double discountIT = getDiscountIT(grossSalary);
            double netSalary = getNetSalary(grossSalary);
            System.out.printf("%s: R$ %.2f | R$ %.2f | R$ %.2f | R$ %.2f\n", employee.getPerson().getName(),grossSalary, discountINSS, discountIT, netSalary);
        }
    }

    protected double grossSalary(Contract contract){

        double grossSalary = contract.getWage();

        if(typeContract(contract) == 1){
            return grossSalary;

        } else if(typeContract(contract) == 2){
            return (grossSalary * contract.getWorkHours());

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

    private double getDiscountINSS (double grossSalary) {

        double discount = 0.0;
        double aliquot = getAliquotINSS(grossSalary);

        if (grossSalary > 5531.31){
            discount = (5531.31 * aliquot);
            return discount;
        }

        return  (grossSalary * aliquot);
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

    private double getDiscountIT(double grossSalary){
        double discount = 0.0;

        if (1903.99 <= grossSalary && grossSalary <= 2826.65) {
            discount = (grossSalary * 0.075) - 142.8;
        } else if(2826.66 <= grossSalary && grossSalary <= 3751.05) {
            discount = (grossSalary * 0.15) - 354.8;
        } else if(3751.06 <= grossSalary && grossSalary <= 4664.68) {
            discount = (grossSalary * 0.225) - 636.13;
        } else if (grossSalary > 4664.68) {
            discount = (grossSalary * 0.275) - 869.36;
        }

        return discount;
    }

    private double getNetSalary(double grossSalary){

        double discountINSS = getDiscountINSS(grossSalary);
        double discountIT = getDiscountIT(grossSalary);

        return (grossSalary - discountIT - discountINSS);
    }
}
