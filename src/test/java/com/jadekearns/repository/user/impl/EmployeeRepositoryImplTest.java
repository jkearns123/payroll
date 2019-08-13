package com.jadekearns.repository.user.impl;

import com.jadekearns.domain.user.Employee;
import com.jadekearns.factory.user.EmployeeFactory;
import com.jadekearns.repository.user.EmployeeRepository;
import org.junit.*;
import org.junit.runners.MethodSorters;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.*;

@FixMethodOrder
        (MethodSorters.NAME_ASCENDING)
public class EmployeeRepositoryImplTest {


    private String firstName = "John";
    private String lastName = "Doe";

    //update------private static Set<Employee> employees = new HashSet<>();


    private EmployeeRepository employeeRepository;
    private Employee employee;

    private Employee getSavedEmployee(){
        Set<Employee> savedEmployees = this.employeeRepository.getAll();
        return savedEmployees.iterator().next();
    }

    @Before
    public void setUp() throws Exception {
        this.employeeRepository = EmployeeRepositoryImpl.getRepository();
    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void d_getAll() {

        System.out.println(this.employeeRepository.getAll());
        Assert.assertEquals(1,this.employeeRepository.getAll().size());

    }

    @Test
    public void a_create() {
        Employee e = EmployeeFactory.buildEmployee(firstName,lastName);
        Employee saveE = this.employeeRepository.create(e);
        System.out.println(saveE);
        Assert.assertEquals(1, this.employeeRepository.getAll().size());
        Assert.assertEquals("John",saveE.getEmployeeFirstName());
        Assert.assertEquals("Doe",saveE.getEmployeeLastName());
        Assert.assertNotNull(saveE.getEmployeeNumber());
        //assertEquals(this.employeeRepository.);

    }

    @Test
    public void b_update() {

/*        String updateFirstName = "Jane";

        Employee employee = getSavedEmployee();

        //Employee updateEmployeeName = EmployeeFactory.buildEmployee(updateFirstName,lastName);

        Employee copyOfEmployee = new Employee.Builder().copy(employee).employeeFirstName(updateFirstName).employeeLastName(lastName).build();

        //Employee copyOfCustomer = new Employee.Builder().copy(employee).employeeFirstName(updateFirstName).build();
        Employee updatedCustomer = this.employeeRepository.update(copyOfEmployee);

        System.out.println(this.employeeRepository.getAll());*/


/*        String updateFirstName = "Jane";

        Employee updateCustomerName = EmployeeFactory.buildEmployee(updateFirstName,lastName);
        Employee copyOfEmployee = new Employee.Builder().copy(employee).employeeFirstName(updateFirstName).employeeLastName(lastName).build();
        Employee updated = new Employee.Builder().copy(getSavedEmployee()).employeeFirstName(updateFirstName).build();
        System.out.println("In update, updated: " + updated);
        this.employeeRepository.update(updated);

        Assert.assertSame(updateFirstName,updated.getEmployeeFirstName());
        System.out.println("Array includes: " + this.employeeRepository.getAll());*/

//----------------------------------------------------
        String updateFirstName = "Jane";
        Employee saved = getSavedEmployee();

        Employee updateCustomerName = EmployeeFactory.buildEmployee(updateFirstName,lastName);
        this.employeeRepository.update(saved);
        Employee copyOfEmployee = new Employee.Builder().copy(employee).employeeFirstName(updateFirstName).employeeLastName(lastName).build();
        Employee updated = new Employee.Builder().copy(getSavedEmployee()).employeeFirstName(updateFirstName).build();
        System.out.println("In update, updated: " + updated);
        this.employeeRepository.update(updated);

        Assert.assertSame(updateFirstName,updated.getEmployeeFirstName());
        System.out.println("Array includes: " + this.employeeRepository.getAll());

/*        String newFirstName = "Jane";
        Employee updateEmployee = new Employee.Builder().copy(employee).employeeFirstName(newFirstName).build();
        employees.add(employeeRepository.update(updateEmployee));
        Assert.assertEquals(updateEmployee, employeeRepository.read(updateEmployee.getEmployeeNumber()));*/

//-------------------------------------------------------

/*        String updateFirstName = "Jane";

        Employee employee = getSavedEmployee();
        Employee copyOfEmployee = new Employee.Builder().copy(employee).employeeFirstName(updateFirstName).employeeLastName(lastName).build();
        Employee updatedEmployee = this.employeeRepository.update(copyOfEmployee);

        System.out.println("Updated Record: " + updatedEmployee.getEmployeeFirstName() + " " + updatedEmployee.getEmployeeLastName());*/


    }

    @Test
    public void e_delete() {
        Employee saved = getSavedEmployee();
        this.employeeRepository.delete(saved.getEmployeeNumber());

        System.out.println("In array after deleted: " + employeeRepository.getAll());

        Assert.assertEquals(0,this.employeeRepository.getAll().size());
    }

    @Test
    public void c_read() {
        Employee savedEmployee = getSavedEmployee();
        Employee read = this.employeeRepository.read(savedEmployee.getEmployeeNumber());
        System.out.println("In read: " + read);

        Assert.assertSame(read,savedEmployee);
    }
}