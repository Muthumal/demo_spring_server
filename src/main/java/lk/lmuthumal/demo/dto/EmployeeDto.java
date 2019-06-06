package lk.lmuthumal.demo.dto;

import lk.lmuthumal.demo.Entity.Employee;

public class EmployeeDto {
    private int employeeId;
    private String firstName;
    private String lastName;
    private int companyId;
    private String email;
    private String phoneNo;

    public EmployeeDto() {
    }

    public EmployeeDto(String firstName, String lastName, int companyId, String email, String phoneNo) {
        this.setFirstName(firstName);
        this.setLastName(lastName);
        this.setCompanyId(companyId);
        this.setEmail(email);
        this.setPhoneNo(phoneNo);
    }

    public EmployeeDto(int employeeId, String firstName, String lastName, int companyId, String email, String phoneNo) {
        this.setEmployeeId(employeeId);
        this.setFirstName(firstName);
        this.setLastName(lastName);
        this.setCompanyId(companyId);
        this.setEmail(email);
        this.setPhoneNo(phoneNo);
    }

    public EmployeeDto(Employee byId) {
        this.setEmployeeId(byId.getEmployeeId());
        this.setFirstName(byId.getFirstName());
        this.setLastName(byId.getLastName());
        this.setCompanyId(byId.getCompany().getCompanyId());
        this.setEmail(byId.getEmail());
        this.setPhoneNo(byId.getPhoneNo());
    }


    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getCompanyId() {
        return companyId;
    }

    public void setCompanyId(int companyId) {
        this.companyId = companyId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }
}
