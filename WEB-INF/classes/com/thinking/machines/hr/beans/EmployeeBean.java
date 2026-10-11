package com.thinking.machines.hr.beans;
import java.io.*;
import java.util.*;
import java.math.*;
import java.text.*;
public class EmployeeBean implements java.io.Serializable,Comparable<EmployeeBean>
{
    private String employeeId;
    private String name;
    private int designationCode;
    private String designation;
    private String dateOfBirth;
    private String gender;
    private boolean isIndian;
    private String basicSalary;
    private String panNumber;
    private String aadharCardNumber;
 // Default Constructor
public EmployeeBean()
{
    this.employeeId = "";
    this.name = "";
    this.designationCode = 0;
    this.designation = "";
    this.dateOfBirth = "";
    this.gender = "";
    this.isIndian = false;
    this.basicSalary = null;
    this.panNumber = "";
    this.aadharCardNumber = "";
}
public boolean IsMale(String gender)
{
return gender.equals("M");
}
public boolean IsFemale(String gender)
{
return gender.equals("F");  
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

    // Getter and Setter for designation
    public String getdesignation()
    {
        return designation;
    }

    public void setdesignation(String designation)
    {
        this.designation = designation;
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
    public String getDateOfBirth()
    {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth)
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
    public String getBasicSalary()
    {
        return basicSalary;
    }

    public void setBasicSalary(String basicSalary)
    {
        this.basicSalary = basicSalary;
    }

    // Getter and Setter for panNumber
    public String getPanNumber()
    {
        return panNumber;
    }

    public void setPanNumber(String panNumber)
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
        if(!(other instanceof EmployeeBean))return false;
        EmployeeBean employee=(EmployeeBean)other;
        return this.employeeId.equalsIgnoreCase(employee.employeeId);
    }
    public int hashCode()
    {
        return this.employeeId.hashCode();
    }
    public int compareTo(EmployeeBean employee)
    {
        return this.employeeId.compareToIgnoreCase(employee.employeeId);
    }
    
}
