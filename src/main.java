public class main {
    public static void main(String[] args){
        // Le os funcionarios passando como parametro o numero de funcionario que deseja cadastrar
        Company company = new Company(2);
        // Faz a folha de pagamento
        company.payroll(company.employees);
    }
}
