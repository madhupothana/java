import java.util.*;
abstract class Loan{
    private String accountNo;
    private String accountTitle;
    private String address;
    private String loanType;
    private String nominee;
    private String startDate;
    private double loanAmount;
    private double totalPaid;
    private double totalToBePaid;
    private int noOfInstallments;
    private int installmentsPaid;
    private int loanTerm;
    static float rateOfInt=6.0f;
    public Loan(String a1,String a2,String a3,String a4,double a5,int a6,int a7,double a8,double a9,String a10,int a11,String a12){
        accountNo=a1;
        accountTitle=a2;
        address=a3;
        loanType=a4;
        loanAmount=a5;
        noOfInstallments=a6;
        installmentsPaid=a7;
        totalToBePaid=a8;
        totalPaid=a9;
        nominee=a10;
        loanTerm=a11;
        startDate=a12;
    }
    public String getAccountNo(){
        return accountNo;
    }
    public String getAccountTitle(){
        return accountTitle;
    }
    public String getAddress(){
        return address;
    }
    public String getNominee(){
        return nominee;
    }
    public String getStartDate(){
        return startDate;
    }
    public String getLoanType(){
        return loanType;
    }
    public double getLoanAmount(){
        return loanAmount;
    }
    public double getTotalToBePaid(){
        return totalToBePaid;
    }
    public void setTotalToBePaid(double amt){
        totalToBePaid+=amt;
    }
    public double getTotalPaid(){
        return totalPaid;
    }
    public int getInstallmentsPaid(){
        return installmentsPaid;
    }
    public int getNoOfInstallments(){
        return noOfInstallments;
    }
    public int getLoanTerm(){
        return loanTerm;
    }
    public void payEMI(double amt){
        totalPaid+=amt;
        installmentsPaid++;
    }
    abstract public double calEMI();
    abstract public double CalTotalToBePaid();
}
class GoldLoan extends Loan{
    public GoldLoan(String a1,String a2,String a3,String a4,double a5,int a6,int a7,double a8,double a9,String a10,int a11,String a12){
        super(a1,a2,a3,a4,a5,a6,a7,a8,a9,a10,a11,a12);
    }
    public double CalTotalToBePaid(){
        double d=this.calEMI()+this.getLoanAmount();
        this.setTotalToBePaid(d);
        return d;
    }
    public double calEMI(){
        float f=(this.rateOfInt/12)/100;
        return this.getLoanAmount()*f*((Math.pow((1+f),this.getLoanTerm()))/(Math.pow((1+f),this.getLoanTerm())-1));
    }
}
class MortguageLoan extends Loan{
    public MortguageLoan(String a1,String a2,String a3,String a4,double a5,int a6,int a7,double a8,double a9,String a10,int a11,String a12){
        super(a1,a2,a3,a4,a5,a6,a7,a8,a9,a10,a11,a12);
    }
    public double CalTotalToBePaid(){
        double d=this.calEMI()+this.getLoanAmount();
        this.setTotalToBePaid(d);
        return d;
    }
    public double calEMI(){
        float f=(this.rateOfInt/12)/100;
        return this.getLoanAmount()*f*((Math.pow((1+f),this.getLoanTerm()))/(Math.pow((1+f),this.getLoanTerm())-1));
    }
}
class VehicleLoan extends Loan{
    public VehicleLoan(String a1,String a2,String a3,String a4,double a5,int a6,int a7,double a8,double a9,String a10,int a11,String a12){
        super(a1,a2,a3,a4,a5,a6,a7,a8,a9,a10,a11,a12);
    }
    public double CalTotalToBePaid(){
        double d=this.calEMI()+this.getLoanAmount();
        this.setTotalToBePaid(d);
        return d;
    }
    public double calEMI(){
        float f=(this.rateOfInt/12)/100;
        return this.getLoanAmount()*f*((Math.pow((1+f),this.getLoanTerm()))/(Math.pow((1+f),this.getLoanTerm())-1));
    }
}
class EMICalculator{
    public double GenerateEMI(Loan l1){
        if(l1 instanceof GoldLoan){
            GoldLoan g1=(GoldLoan)l1;
            return g1.calEMI();
        }
        else if(l1 instanceof VehicleLoan){
            VehicleLoan v1=(VehicleLoan)l1;
            return v1.calEMI();
        }
        else{
            MortguageLoan m1=(MortguageLoan)l1;
            return m1.calEMI();
        }
    }
}
class TotalToPayCalculator{
    public double CalTotalToPay(Loan l1){
        if(l1 instanceof GoldLoan){
            GoldLoan g1=(GoldLoan)l1;
            return g1.CalTotalToBePaid();
        }
        else if(l1 instanceof VehicleLoan){
            VehicleLoan v1=(VehicleLoan)l1;
            return v1.CalTotalToBePaid();
        }
        else{
            MortguageLoan m1=(MortguageLoan)l1;
            return m1.CalTotalToBePaid();
        }
    }
}
class Main{
    public static void main(String args[]){
        GoldLoan t1=new GoldLoan("123","savings","jrg","gold",10000,4,0,10000,0,"Father",12,"10-08-2002");
        System.out.println(t1.CalTotalToBePaid()+"t1\n");
        GoldLoan t2=new GoldLoan("123","savings","jrg","gold",100000,4,0,10000,0,"Father",12,"10-08-2002");
        System.out.println(t2.CalTotalToBePaid()+"t2\n");
        GoldLoan t3=new GoldLoan("123","savings","jrg","gold",1000000,4,0,10000,0,"Father",12,"10-08-2002");
        System.out.println(t3.CalTotalToBePaid()+"t3\n");
        EMICalculator emi1=new EMICalculator();
        System.out.println(emi1.GenerateEMI(t1));
        TotalToPayCalculator ttpc1=new TotalToPayCalculator();
        System.out.println(ttpc1.CalTotalToPay(t1));
    }
}





