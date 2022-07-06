package com.bl.employee_payroll_service_test.employee_payroll_service;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EmployeePayrollService {
    public List<EmployeePayrollData> employeePayrollList;

    public enum IOService {CONSOLE_IO, FILE_IO}

    public EmployeePayrollService(List<EmployeePayrollData> employeePayrollList) {
        this.employeePayrollList = employeePayrollList;
    }

    public EmployeePayrollService() {
        employeePayrollList = new ArrayList<>();
    }

    public static void main(String[] args) {
        EmployeePayrollService employeePayrollService = new EmployeePayrollService();
        Scanner consoleInputReader = new Scanner(System.in);
        employeePayrollService.printWelcomeMessage();
        employeePayrollService.readEmployeePayrollData(consoleInputReader);
    }

    public void printWelcomeMessage() {
        System.out.println("Welcome To The Employee Payroll Service System");
    }

    private void readEmployeePayrollData(Scanner consoleInputReader) {
        System.out.println("Enter Employee ID : ");
        int id = consoleInputReader.nextInt();
        consoleInputReader.nextLine();
        System.out.println("Enter Employee Name : ");
        String name = consoleInputReader.nextLine();
        System.out.println("Enter Employee Salary : ");
        double salary = consoleInputReader.nextDouble();
        employeePayrollList.add(new EmployeePayrollData(id, name, salary));
    }

    public long countEntries(IOService ioService) {
        if (ioService.equals(IOService.FILE_IO))
            return new EmployeePayrollFileIOService().countEntries();
        return 0;
    }

    public long readEmployeePayrollData(IOService ioService){
        if (ioService.equals(IOService.FILE_IO))
            this.employeePayrollList = new EmployeePayrollFileIOService().readData();
        return employeePayrollList.size();
    }
}