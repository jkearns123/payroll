package com.jadekearns.service.user.impl;

import com.jadekearns.domain.user.Employee;
import com.jadekearns.factory.user.EmployeeFactory;
import com.jadekearns.repository.user.EmployeeRepository;
import com.jadekearns.repository.user.impl.EmployeeRepositoryImpl;
import org.junit.*;
import org.junit.runners.MethodSorters;

import java.util.Set;

import static org.junit.Assert.*;
@FixMethodOrder
        (MethodSorters.NAME_ASCENDING)
public class EmployeeServiceImplTest {

    private String firstName = "John";
    private String lastName = "Doe";

    private EmployeeRepository repository;
    private Employee employee;

    private Employee getSavedEmployee(){
        Set<Employee> savedEmployees = this.repository.getAll();
        return savedEmployees.iterator().next();
    }

    @Before
    public void setUp() throws Exception {
        this.repository = EmployeeRepositoryImpl.getRepository();
    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void d_getAll() {
        Set<Employee>employees = this.repository.getAll();
        System.out.println("In getall, all: " + employees);

        Assert.assertEquals(2,this.repository.getAll().size());
    }

    @Test
    public void a_create() {
        Employee createEmployee = EmployeeFactory.buildEmployee(firstName,lastName);
        Employee saveEmployee = this.repository.create(createEmployee);
        System.out.println("In create, created: " + saveEmployee);

        Assert.assertNotNull(saveEmployee);

        Assert.assertSame("John", createEmployee.getEmployeeFirstName());
    }

    @Test
    public void b_update() {

        String updateFirstName = "Jane";
        Employee employee = EmployeeFactory.buildEmployee(updateFirstName,lastName);

        repository.create(employee);
        Employee inRepo = repository.read(employee.getEmployeeNumber());


        repository.update(employee);

        Assert.assertEquals(employee.getEmployeeFirstName(), inRepo.getEmployeeFirstName());
    }

    @Test
    public void e_delete() {
        Employee saved = getSavedEmployee();
        this.repository.delete(saved.getEmployeeNumber());

        System.out.println("In array after deleted: " + repository.getAll());

        Assert.assertEquals(1,this.repository.getAll().size());
    }

    @Test
    public void c_read() {
        Employee savedEmployee = getSavedEmployee();
        Employee read = this.repository.read(savedEmployee.getEmployeeNumber());
        System.out.println("In read: " + read);

        Assert.assertSame(read,savedEmployee);
    }
}