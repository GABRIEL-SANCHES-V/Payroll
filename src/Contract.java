public class Contract {
    private String typeContract;
    private String admissionDate;
    private double wage;
    private int numberMinorChildren;
    private double workHours;

    protected Contract(String typeContract, String admissionDate, double wage, int numberMinorChildren, double workHours){

        setTypeContract(typeContract);
        setAdmissionDate(admissionDate);
        setWage(wage);
        setNumberMinorChildren(numberMinorChildren);
        setWorkHours(workHours);
    }

    protected void setTypeContract (String typeContract){
        this.typeContract = typeContract;
    }

    protected String getTypeContract (){
        return typeContract;
    }

    protected void setAdmissionDate (String admissionDate){
        this.admissionDate = admissionDate;
    }

    protected String getAdmissionDate (){
        return admissionDate;
    }

    protected void setWage (double wage){
        this.wage = wage;
    }

    protected double getWage(){
        return wage;
    }

    protected void setNumberMinorChildren (int numberMinorChildren){
        this.numberMinorChildren = numberMinorChildren;
    }

    protected int getNumberMinorChildren() {
        return numberMinorChildren;
    }

    protected void setWorkHours (double workHours){
        this.workHours = workHours;
    }

    protected double getWorkHours (){
        return workHours;
    }

}
