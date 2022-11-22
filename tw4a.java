/*
A company has two types of employees – FullTime and Partime. 
The company records for each employee his/her name, age, 
address, salary and gender. 

Given the basic salary of the FullTime employee the components of his/her gross salary 
are: Dearness allowance – 75% of basic salary, HRA – 7.5% 
of basic salary, IT – 10% of basic. 

The salary of a Partime employee is dependent on the 
qualification, experience, number of working hours and 
the rate per hour, as below:


Model this as a problem of hierarchical inheritance by:
1) Identifying the super class with its data members 
and member functions.
2) Identify the sub-class/sub-classes and their associated 
data members and member functions.
Test the program by creating objects of the classes that 
are so identified.
*/

package tw4a;

class Employee{
    //name, age, address, salary and gender.
    String name, addr, gender;
    int age;
    double sal;
    
    
    //initialize
    Employee(String name, String addr, String gender, int age){
        this.name = name;
        this.addr = addr;
        this.gender = gender;
        this.age = age;
    }
    void dispDetails(){
        System.out.println("Name:"+name);
        System.out.println("Addr:"+addr);
        System.out.println("Gender:"+gender);
        System.out.println("Age:"+age);
        System.out.println("Sal:"+sal);
    }    
}

class FTEmployee extends Employee{
    double basicSal;
    FTEmployee(String name, String addr, String gender, int age,double basicSal){
        super(name,addr,gender,age);
        this.basicSal = basicSal;
    }

    void computeSal(){
        sal = basicSal*(1+0.75+0.075-0.1);
    }
}

class PTEmployee extends Employee{
    String qual;
    int exp, numHrs;
    
    PTEmployee(String name, String addr, String gender, int age,String qual,int exp,int numHrs){
        super(name,addr,gender,age);
        this.qual = qual;
        this.exp = exp;
        this.numHrs = numHrs;
    }
    
    void computeSal(){
        switch(qual){
            case "Phd":
                if(exp<=5){
                    sal = numHrs*800;
                }else if(exp<=10){
                    sal = numHrs*1200;
                }
                else{
                    sal = numHrs*1500;
                }
                break;
               
            case "MTech":
                if(exp<=5){
                    sal = numHrs*500;
                }else if(exp<=10){
                    sal = numHrs*700;
                }
                else{
                    sal = numHrs*1000;
                }
                break;
                
            case "BE":
                if(exp<=5){
                    sal = numHrs*300;
                }else if(exp<=10){
                    sal = numHrs*400;
                }
                else{
                    sal = numHrs*500;
                }
                break;
        }
    }
}
public class TW4a {

    public static void main(String[] args) {
            FTEmployee ftEmp = new FTEmployee("Naren","Udyambag", "Male",25,10000);
            ftEmp.computeSal();
            ftEmp.dispDetails();
            
            PTEmployee ptEmp1 = new PTEmployee("Amit","Gandhinagar", "Male",30,"Phd",11,6);
            ptEmp1.computeSal();
            ptEmp1.dispDetails();
            
            PTEmployee ptEmp2 = new PTEmployee("Amita","Gandhinagar", "Female",30,"MTech",8,10);
            ptEmp2.computeSal();
            ptEmp2.dispDetails();
    }
}
