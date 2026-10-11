package com.thinking.machines.hr.dl;
import java.util.*;
import java.io.*;
import java.sql.*;
import java.text.*;
import java.math.*;
public class EmployeeDAO
{
    public void add(EmployeeDTO employee)throws DAOException
    {
        String panNumber=employee.getPANNumber().trim();
        String aadharCardNumber=employee.getAadharCardNumber().trim();
        try
        {
            Connection connection=DAOConnection.getConnection();
            PreparedStatement preparedStatement;
            ResultSet resultSet;
            preparedStatement=connection.prepareStatement("select id from employee where pan_number=?");
            preparedStatement.setString(1,panNumber);
            resultSet=preparedStatement.executeQuery();
if(resultSet.next())
{
    resultSet.close();
    preparedStatement.close();
    connection.close();
    throw new DAOException("PAN number: "+panNumber+" exists");

}
preparedStatement.close();
resultSet.close();

            preparedStatement=connection.prepareStatement("select id from employee where aadhar_card_number=?");
            preparedStatement.setString(1,aadharCardNumber);
            resultSet=preparedStatement.executeQuery();
if(resultSet.next())
{
    resultSet.close();
    preparedStatement.close();
    connection.close();
    throw new DAOException("Aadhar Card number: "+aadharCardNumber+" exists");

}
preparedStatement.close();
resultSet.close();
preparedStatement=connection.prepareStatement("insert into employee(name,designation_code,date_of_birth,gender,is_indian,basic_salary,pan_number,aadhar_card_number ) values(?,?,?,?,?,?,?,?)",Statement.RETURN_GENERATED_KEYS);
preparedStatement.setString(1,employee.getName().trim());
preparedStatement.setInt(2,employee.getDesignationCode());
java.util.Date date=employee.getDateOfBirth();
//java.sql.Date sqlDate=new java.sql.Date(date.getYear()+1900,date.getMonth(),date.getDate());
java.sql.Date sqlDate=new java.sql.Date(date.getTime());

preparedStatement.setDate(3,sqlDate);
preparedStatement.setString(4,employee.getGender());
System.out.println(employee.getIsIndian());
preparedStatement.setBoolean(5,employee.getIsIndian());

preparedStatement.setBigDecimal(6,employee.getBasicSalary());
preparedStatement.setString(7,panNumber);
preparedStatement.setString(8,aadharCardNumber);
preparedStatement.executeUpdate();
resultSet=preparedStatement.getGeneratedKeys();
resultSet.next();//very very imp

int id=resultSet.getInt(1);
employee.setEmployeeId("A"+id);

resultSet.close();
preparedStatement.close();
connection.close();


        }catch(SQLException exception)
        {
            System.out.println(exception.getMessage());
        }
    }

public void update(EmployeeDTO employee)throws DAOException
{
String employeeId=employee.getEmployeeId();
String panNumber=employee.getPANNumber().trim();
String aadharCardNumber=employee.getAadharCardNumber().trim();
int actualEmployeeId=Integer.parseInt(employeeId.substring(1));
try
{
Connection connection;
PreparedStatement preparedStatement;
ResultSet resultSet;
connection=DAOConnection.getConnection();
preparedStatement=connection.prepareStatement("select gender from employee where id=?");
preparedStatement.setInt(1,actualEmployeeId);
resultSet=preparedStatement.executeQuery();
if(resultSet.next()==false)
{
resultSet.close();
preparedStatement.close();
connection.close();
throw new DAOException("Invalid EmployeeId: "+employeeId+" can not Update");
}
resultSet.close();
preparedStatement.close();

preparedStatement=connection.prepareStatement("select gender from employee where pan_number=? and id<>?");
preparedStatement.setString(1,panNumber);
preparedStatement.setInt(2,actualEmployeeId);
resultSet=preparedStatement.executeQuery();
if(resultSet.next()==true)
{
resultSet.close();
preparedStatement.close();
connection.close();
throw new DAOException("PAN Number: "+panNumber+"Exists");
}

resultSet.close();
preparedStatement.close();

preparedStatement=connection.prepareStatement("select gender from employee where aadhar_card_number=? and id<>?");
preparedStatement.setString(1,aadharCardNumber);
preparedStatement.setInt(2,actualEmployeeId);
resultSet=preparedStatement.executeQuery();
if(resultSet.next()==true)
{
resultSet.close();
preparedStatement.close();
connection.close();
throw new DAOException("Aadhar Card Number: "+aadharCardNumber+"Exists");
}

resultSet.close();
preparedStatement.close();

preparedStatement=connection.prepareStatement("update employee set name=?,designation_code=?,date_of_birth=?,gender=?,is_indian=?,basic_salary=?,pan_number=?,aadhar_card_number=? where id=?");
preparedStatement.setString(1,employee.getName());
preparedStatement.setInt(2,employee.getDesignationCode());
java.util.Date dateOfBirth=employee.getDateOfBirth();
java.sql.Date sqlDate=new java.sql.Date(dateOfBirth.getYear(),dateOfBirth.getMonth(),dateOfBirth.getDate());
preparedStatement.setDate(3,sqlDate);
preparedStatement.setString(4,employee.getGender());
preparedStatement.setBoolean(5,employee.getIsIndian());
preparedStatement.setBigDecimal(6,employee.getBasicSalary());
preparedStatement.setString(7,panNumber);
preparedStatement.setString(8,aadharCardNumber);
preparedStatement.setInt(9,actualEmployeeId);
preparedStatement.executeUpdate();
resultSet.close();
preparedStatement.close();
connection.close();









}catch(SQLException exception)
{
throw new DAOException(exception.getMessage());
}













}












public void deleteByEmployeeId(String employeeId)
{
int actualEmployeeId=Integer.parseInt(employeeId.substring(1));
Connection connection;
PreparedStatement preparedStatement;
ResultSet resultSet;
try
{
connection=DAOConnection.getConnection();
preparedStatement=connection.prepareStatement("select gender from employee where id=?");
preparedStatement.setInt(1,actualEmployeeId);
resultSet=preparedStatement.executeQuery();
if(resultSet.next()==false)
{
resultSet.close();
preparedStatement.close();
connection.close();
throw new DAOException("Invalid EmployeeID: "+employeeId);
}
resultSet.close();
preparedStatement.close();
preparedStatement=connection.prepareStatement("delete from employee where id=?");
preparedStatement.setInt(1,actualEmployeeId);
preparedStatement.executeUpdate();
resultSet.close();
preparedStatement.close();
connection.close();









}catch(Exception exception)
{
System.out.println(exception.getMessage());
}









}






    public List<EmployeeDTO>getAll()throws DAOException
    {
        Connection connection;
        
        Statement statement;
         List<EmployeeDTO>employees;
        try
        {
            ResultSet resultSet;
            connection=DAOConnection.getConnection();
            statement=connection.createStatement();
            resultSet=statement.executeQuery("select employee.id,employee.name,employee.designation_code,designation.title,employee.date_of_birth,employee.gender,employee.is_indian,employee.basic_salary,employee.pan_number,employee.aadhar_card_number from employee inner join designation where employee.designation_code=designation.code order by name");
            EmployeeDTO employeeDTO;
            employees=new LinkedList<>();
            while(resultSet.next())
            {
                employeeDTO=new EmployeeDTO();
                employeeDTO.setEmployeeId("A"+resultSet.getInt("id"));
                employeeDTO.setName(resultSet.getString("name"));
                employeeDTO.setDesignationCode(resultSet.getInt("designation_code"));
                employeeDTO.setDesignation(resultSet.getString("title").trim());
                
                employeeDTO.setDateOfBirth(resultSet.getDate("date_of_birth"));
                employeeDTO.setGender(resultSet.getString("gender"));
                employeeDTO.setIsIndian(resultSet.getBoolean("is_indian"));
                employeeDTO.setBasicSalary(resultSet.getBigDecimal("basic_salary"));
                employeeDTO.setPANNumber(resultSet.getString("pan_number").trim());
                employeeDTO.setAadharCardNumber (resultSet.getString("aadhar_card_number").trim());
                employees.add(employeeDTO);

            }
            resultSet.close();
            statement.close();
            connection.close();



        }catch(SQLException exception)
        {
            throw new DAOException(exception.getMessage());
        }
        return employees;
 }
 public EmployeeDTO getByEmployeeId(String employeeId)throws DAOException
 {
    int actualEmployeeId=Integer.parseInt(employeeId.substring(1));
    
  EmployeeDTO employeeDTO=new EmployeeDTO();

    try
    {
        Connection connection;
        PreparedStatement preparedStatement;
        ResultSet resultSet;
        connection=DAOConnection.getConnection();
        preparedStatement=connection.prepareStatement("select gender from employee where id=?");
        preparedStatement.setInt(1,actualEmployeeId);
        resultSet=preparedStatement.executeQuery();
        
        if(resultSet.next()==false)
        {
            resultSet.close();
            preparedStatement.close();
            connection.close();
            throw new DAOException("Invalid EmployeeId: "+employeeId);
        }
        resultSet.close();
        preparedStatement.close();
        preparedStatement=connection.prepareStatement("select employee.id,employee.name,employee.designation_code,designation.title,employee.date_of_birth,employee.gender,employee.is_indian,employee.basic_salary,employee.pan_number,employee.aadhar_card_number from employee inner join designation on employee.designation_code=designation.code and employee.id=?");
        preparedStatement.setInt(1,actualEmployeeId);
        resultSet=preparedStatement.executeQuery();
        if(resultSet.next()==false)
        {
            resultSet.close();
            preparedStatement.close();
            connection.close();
            throw new DAOException("Invalid EmployeeID: "+employeeId);
        }



                employeeDTO=new EmployeeDTO();
                employeeDTO.setEmployeeId("A"+resultSet.getInt("id"));
                employeeDTO.setName(resultSet.getString("name"));
                employeeDTO.setDesignationCode(resultSet.getInt("designation_code"));
                employeeDTO.setDesignation(resultSet.getString("title").trim());
                
                employeeDTO.setDateOfBirth(resultSet.getDate("date_of_birth"));
                employeeDTO.setGender(resultSet.getString("gender"));
                employeeDTO.setIsIndian(resultSet.getBoolean("is_indian"));
                employeeDTO.setBasicSalary(resultSet.getBigDecimal("basic_salary"));
                employeeDTO.setPANNumber(resultSet.getString("pan_number").trim());
                employeeDTO.setAadharCardNumber (resultSet.getString("aadhar_card_number").trim());





    }catch(SQLException sqlException)
    {
        throw new DAOException(sqlException.getMessage());
    }
    return employeeDTO;
 }

public boolean EmployeeIdExists(String employeeId)throws DAOException
 {
    int actualEmployeeId=Integer.parseInt(employeeId.substring(1));
    
        boolean exists=false;
     
    try
    {
           Connection connection;
        PreparedStatement preparedStatement;
        ResultSet resultSet;
        connection=DAOConnection.getConnection();
        preparedStatement=connection.prepareStatement("select gender from employee where id=?");
        preparedStatement.setInt(1,actualEmployeeId);
        resultSet=preparedStatement.executeQuery();
        exists=resultSet.next();

        resultSet.close();
        preparedStatement.close();
        connection.close();
    }catch(SQLException sqlException)
    {
        throw new DAOException(sqlException.getMessage());
    }
    return exists;
 }









public boolean panNumberExists(String panNumber)throws DAOException
{
try
{
boolean exists=false;
Connection connection=DAOConnection.getConnection();
PreparedStatement preparedStatement;
ResultSet resultSet;
preparedStatement=connection.prepareStatement("select gender from employee where pan_number=?");
preparedStatement.setString(1,panNumber);
resultSet=preparedStatement.executeQuery();
exists=resultSet.next();
resultSet.close();
preparedStatement.close();
connection.close();
return exists;
}catch(SQLException exception)
{
throw new DAOException(exception.getMessage());
}
}

public boolean aadharCardNumberExists(String aadharCardNumber)throws DAOException
{
try
{
boolean exists=false;
Connection connection=DAOConnection.getConnection();
PreparedStatement preparedStatement;
ResultSet resultSet;
preparedStatement=connection.prepareStatement("select gender from employee where aadhar_card_number=?");
preparedStatement.setString(1,aadharCardNumber);
resultSet=preparedStatement.executeQuery();
exists=resultSet.next();
resultSet.close();
preparedStatement.close();
connection.close();
return exists;
}catch(SQLException exception)
{
throw new DAOException(exception.getMessage());
}
}



public EmployeeDTO getByPANNumber(String panNumber)throws DAOException
 {
  EmployeeDTO employeeDTO=new EmployeeDTO();

    try
    {
        Connection connection;
        PreparedStatement preparedStatement;
        ResultSet resultSet;
        connection=DAOConnection.getConnection();
        preparedStatement=connection.prepareStatement("select gender from employee where pan_number=?");
        preparedStatement.setString(1,panNumber);
        resultSet=preparedStatement.executeQuery();
        
        if(resultSet.next()==false)
        {
            resultSet.close();
            preparedStatement.close();
            connection.close();
            throw new DAOException("Invalid PANNumber: "+panNumber);
        }
        resultSet.close();
        preparedStatement.close();
        preparedStatement=connection.prepareStatement("select employee.id,employee.name,employee.designation_code,designation.title,employee.date_of_birth,employee.gender,employee.is_indian,employee.basic_salary,employee.pan_number,employee.aadhar_card_number from employee inner join designation on employee.designation_code=designation.code and employee.pan_number=?");
        preparedStatement.setString(1,panNumber);
        resultSet=preparedStatement.executeQuery();
        if(resultSet.next()==false)
        {
            resultSet.close();
            preparedStatement.close();
            connection.close();
            throw new DAOException("Invalid PANNumber: "+panNumber);
        }



                employeeDTO=new EmployeeDTO();
                employeeDTO.setEmployeeId("A"+resultSet.getInt("id"));
                employeeDTO.setName(resultSet.getString("name"));
                employeeDTO.setDesignationCode(resultSet.getInt("designation_code"));
                employeeDTO.setDesignation(resultSet.getString("title").trim());
                
                employeeDTO.setDateOfBirth(resultSet.getDate("date_of_birth"));
                employeeDTO.setGender(resultSet.getString("gender"));
                employeeDTO.setIsIndian(resultSet.getBoolean("is_indian"));
                employeeDTO.setBasicSalary(resultSet.getBigDecimal("basic_salary"));
                employeeDTO.setPANNumber(resultSet.getString("pan_number").trim());
                employeeDTO.setAadharCardNumber (resultSet.getString("aadhar_card_number").trim());





    }catch(SQLException sqlException)
    {
        throw new DAOException(sqlException.getMessage());
    }
    return employeeDTO;
 }



public EmployeeDTO getByAadharCardNumber(String aadharCardNumber)throws DAOException
 {
  EmployeeDTO employeeDTO=new EmployeeDTO();

    try
    {
        Connection connection;
        PreparedStatement preparedStatement;
        ResultSet resultSet;
        connection=DAOConnection.getConnection();
        preparedStatement=connection.prepareStatement("select gender from employee where aadhar_card_number=?");
        preparedStatement.setString(1,aadharCardNumber);
        resultSet=preparedStatement.executeQuery();
        
        if(resultSet.next()==false)
        {
            resultSet.close();
            preparedStatement.close();
            connection.close();
            throw new DAOException("Invalid Aadhar Card Number: "+aadharCardNumber);
        }
        resultSet.close();
        preparedStatement.close();
        preparedStatement=connection.prepareStatement("select employee.id,employee.name,employee.designation_code,designation.title,employee.date_of_birth,employee.gender,employee.is_indian,employee.basic_salary,employee.pan_number,employee.aadhar_card_number from employee inner join designation on employee.designation_code=designation.code and employee.aadhar_card_number=?");
        preparedStatement.setString(1,aadharCardNumber);
        resultSet=preparedStatement.executeQuery();
        if(resultSet.next()==false)
        {
            resultSet.close();
            preparedStatement.close();
            connection.close();
            throw new DAOException("Invalid aadharCardNumber: "+aadharCardNumber);
        }



                employeeDTO=new EmployeeDTO();
                employeeDTO.setEmployeeId("A"+resultSet.getInt("id"));
                employeeDTO.setName(resultSet.getString("name"));
                employeeDTO.setDesignationCode(resultSet.getInt("designation_code"));
                employeeDTO.setDesignation(resultSet.getString("title").trim());
                
                employeeDTO.setDateOfBirth(resultSet.getDate("date_of_birth"));
                employeeDTO.setGender(resultSet.getString("gender"));
                employeeDTO.setIsIndian(resultSet.getBoolean("is_indian"));
                employeeDTO.setBasicSalary(resultSet.getBigDecimal("basic_salary"));
                employeeDTO.setPANNumber(resultSet.getString("pan_number").trim());
                employeeDTO.setAadharCardNumber (resultSet.getString("aadhar_card_number").trim());





    }catch(SQLException sqlException)
    {
        throw new DAOException(sqlException.getMessage());
    }
    return employeeDTO;
 }






}