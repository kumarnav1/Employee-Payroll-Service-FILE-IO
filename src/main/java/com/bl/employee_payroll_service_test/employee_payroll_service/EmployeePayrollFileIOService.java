package com.bl.employee_payroll_service_test.employee_payroll_service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

public class EmployeePayrollFileIOService {

    public static String PAYROLL_FILE_NAME = "src/main/resources/payroll-file2.txt";

    public long countEntries() {
        long entries = 0;
        try {
            entries = Files.lines(new File("src/main/resources/payroll-file.txt").toPath()).count();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return entries;
    }

    public List<EmployeePayrollData> readData() {
        List<EmployeePayrollData> employeePayrollList = new ArrayList<>();
        try {
            Files.lines(new File("src/main/resources/payroll-file.txt").toPath())
                    .map(String::trim).forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return employeePayrollList;
    }
}