package com.thinking.machines.hr.dl;
import java.io.*;
import java.util.*;
import java.math.*;
import java.text.*;
public class EmployeeDTO implements java.io.Serializable,Comparable<EmployeeDTO>
{
    private String employeeId;
    private String name;
    private int designationCode;
    private String title;
    private String designation;
    private Date dateOfBirth;
    private String gender;
    private boolean isIndian;
    private BigDecimal basicSalary;
    private String panNumber;
    private String aadharCardNumber;

 // Default Constructor
public EmployeeDTO()
{
    this.employeeId = "";
    this.name = "";
    this.designationCode = 0;
    this.title = "";
    this.designation = "";
    this.dateOfBirth = null;
    this.gender = "";
    this.isIndian = false;
    this.basicSalary = null;
    this.panNumber = "";
    this.aadharCardNumber = "";
}
    public String getEmployeeId()
    {
        return employeeId;
    }

    public void setEmployeeId(String employeeId)
    {
        this.employeeId = employeeId;
    }

    // Getter and Setter for name
    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    // Getter and Setter for designationCode
    public int getDesignationCode()
    {
        return designationCode;
    }

    public void setDesignationCode(int designationCode)
    {
        this.designationCode = designationCode;
    }

    // Getter and Setter for title
    public String getTitle()
    {
        return title;
    }

    public void setTitle(String title)
    {
        this.title = title;
    }

    // Getter and Setter for designation
    public String getDesignation()
    {
        return designation;
    }

    public void setDesignation(String designation)
    {
        this.designation = designation;
    }

    // Getter and Setter for dateOfBirth
    public Date getDateOfBirth()
    {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth)
    {
        this.dateOfBirth = dateOfBirth;
    }

    // Getter and Setter for gender
    public String getGender()
    {
        return gender;
    }

    public void setGender(String gender)
    {
        this.gender = gender;
    }

    // Getter and Setter for isIndian
    public boolean getIsIndian()
    {
        return isIndian;
    }

    public void setIsIndian(boolean isIndian)
    {
        this.isIndian = isIndian;
    }

    // Getter and Setter for basicSalary
    public BigDecimal getBasicSalary()
    {
        return basicSalary;
    }

    public void setBasicSalary(BigDecimal basicSalary)
    {
        this.basicSalary = basicSalary;
    }

    // Getter and Setter for panNumber
    public String getPANNumber()
    {
        return panNumber;
    }

    public void setPANNumber(String panNumber)
    {
        this.panNumber = panNumber;
    }

    // Getter and Setter for aadharCardNumber
    public String getAadharCardNumber()
    {
        return aadharCardNumber;
    }

    public void setAadharCardNumber(String aadharCardNumber)
    {
        this.aadharCardNumber = aadharCardNumber;
    }
    public boolean equals(Object other)
    {
        if(!(other instanceof EmployeeDTO))return false;
        EmployeeDTO employee=(EmployeeDTO)other;
        return this.employeeId.equalsIgnoreCase(employee.employeeId);
    }
    public int hashCode()
    {
        return this.employeeId.hashCode();
    }
    public int compareTo(EmployeeDTO employee)
    {
        return this.employeeId.compareToIgnoreCase(employee.employeeId);
    }
    
}
