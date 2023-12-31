package com.ksp.structuralpatterns;

/**
 * The Composite pattern is used to treat a group of objects uniformly.
 */
import java.util.ArrayList;
import java.util.List;

// Component
interface Department {
    void printDepartmentName();
}

// Leaf
class FinancialDepartment implements Department {
    
    public void printDepartmentName() {
        System.out.println("Financial Department");
    }
}

// Leaf
class SalesDepartment implements Department {
    
    public void printDepartmentName() {
        System.out.println("Sales Department");
    }
}

// Composite
class HeadDepartment implements Department {
    private List<Department> departments = new ArrayList<Department>();

    public void addDepartment(Department department) {
        departments.add(department);
    }

    public void removeDepartment(Department department) {
        departments.remove(department);
    }

    
    public void printDepartmentName() {
        System.out.println("Head Department");
        departments.forEach(Department::printDepartmentName);
    }
}

// Client
public class CompositeExample {
    public static void main(String[] args) {
        Department financialDepartment = new FinancialDepartment();
        Department salesDepartment = new SalesDepartment();

        HeadDepartment headDepartment = new HeadDepartment();
        headDepartment.addDepartment(financialDepartment);
        headDepartment.addDepartment(salesDepartment);

        headDepartment.printDepartmentName();
    }
}
