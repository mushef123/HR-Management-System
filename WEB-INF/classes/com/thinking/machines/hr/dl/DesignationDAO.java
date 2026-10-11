package com.thinking.machines.hr.dl;
import java.util.*;
import java.sql.*;

public class DesignationDAO
{
    public void add(DesignationDTO designation)throws DAOException
    {
        Connection connection=null;
        PreparedStatement preparedStatement=null;
        ResultSet resultSet=null;
        try
        {
            connection=DAOConnection.getConnection();
            preparedStatement=connection.prepareStatement("select code from designation where title=?");
            preparedStatement.setString(1,designation.getTitle());
            resultSet=preparedStatement.executeQuery();
            if(resultSet.next())
            {
                resultSet.close();
                preparedStatement.close();
                connection.close();
                throw new DAOException("Designation: "+designation.getTitle()+" Already Exists");
            }
            resultSet.close();
            preparedStatement.close();
            preparedStatement=connection.prepareStatement("insert into designation (title) values(?)",Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1,designation.getTitle());
            preparedStatement.executeUpdate();
           resultSet=preparedStatement.getGeneratedKeys();
resultSet.next();
int code=resultSet.getInt(1);
                      
 designation.setCode(code);
            resultSet.close();
            preparedStatement.close();
            connection.close();
        

        }catch(SQLException sqlException)
        {
            throw new DAOException(sqlException.getMessage());
        }
    }
    public DesignationDTO getByCode(int code)throws DAOException
    {
        try
        {
            Connection connection=DAOConnection.getConnection();
            PreparedStatement preparedStatement;
            ResultSet resultSet;
            preparedStatement=connection.prepareStatement("select * from designation where code=?");
            preparedStatement.setInt(1,code);
            resultSet=preparedStatement.executeQuery();
            if(resultSet.next()==false)
            {
                resultSet.close();
                preparedStatement.close();
                connection.close();
                throw new DAOException("Invalid Designation Code: "+code);
            }
            
            DesignationDTO designation=new DesignationDTO();
            designation.setCode(resultSet.getInt("code"));
            designation.setTitle(resultSet.getString("title").trim());
            
            resultSet.close();
            preparedStatement.close();
            connection.close();
        return designation;
        }catch(SQLException sqlException)
        {
            throw new DAOException(sqlException.getMessage());
        }
        
    }
    public void update(DesignationDTO designation)throws DAOException
    {
        int code=designation.getCode();
        String title=designation.getTitle().trim();
        try
        {
            Connection connection=DAOConnection.getConnection();
            PreparedStatement preparedStatement;
            ResultSet resultSet;
            preparedStatement=connection.prepareStatement("select * from designation where code=?");
            preparedStatement.setInt(1,code);
            resultSet=preparedStatement.executeQuery();
            if(resultSet.next()==false)
            {
                resultSet.close();
                preparedStatement.close();
                connection.close();
                throw new DAOException("Invalid Code: "+code);
            }
            resultSet.close();
            preparedStatement.close();
            preparedStatement=connection.prepareStatement("select * from designation where title=? and code!=?");
            preparedStatement.setString(1,title);
            preparedStatement.setInt(2,code);
            resultSet=preparedStatement.executeQuery();
            if(resultSet.next()==true)
            {
                resultSet.close();
                preparedStatement.close();
                connection.close();
                throw new DAOException(title+" already Exists");

            }
                resultSet.close();
                preparedStatement.close();
                preparedStatement=connection.prepareStatement("update designation set title=? where code=?");
                preparedStatement.setString(1,title);
                preparedStatement.setInt(2,code);
                preparedStatement.executeUpdate();
                preparedStatement.close();
                connection.close();





        }catch(SQLException exception)
        {
            throw new DAOException(exception.getMessage());
        }
    }
    public void delete(int code)throws DAOException
    {
        try
        {
            Connection connection=DAOConnection.getConnection();
            PreparedStatement preparedStatement;
            preparedStatement=connection.prepareStatement("select * from designation where code=?");
            preparedStatement.setInt(1,code);
            ResultSet resultSet;
            resultSet=preparedStatement.executeQuery();
            if(resultSet.next()==false)
            {
                resultSet.close();
                preparedStatement.close();
                connection.close();
                throw new DAOException("Invalid Designation Code: "+code);
            }
resultSet.close();
preparedStatement.close();
preparedStatement=connection.prepareStatement("select gender from employee where designation_code=?");
preparedStatement.setInt(1,code);
resultSet=preparedStatement.executeQuery();
if(resultSet.next())
{
resultSet.close();
preparedStatement.close();
connection.close();
throw new DAOException("Designation can not be deleted,Because it can be alloted to Employee"); 
}

		

            resultSet.close();
            preparedStatement.close();
            preparedStatement=connection.prepareStatement("delete from designation where code=?");
            preparedStatement.setInt(1,code);
            preparedStatement.executeUpdate();
            preparedStatement.close();
            connection.close();







        }catch(SQLException sqlException)
        {
            throw new DAOException(sqlException.getMessage());
        }
    }
    public List<DesignationDTO>getAll()throws DAOException
    {
        List<DesignationDTO>designations;
        try
        {
            DesignationDTO designationDTO;
designations=new LinkedList<>();
            Connection connection=DAOConnection.getConnection();
            Statement statement=connection.createStatement();
            ResultSet resultSet=statement.executeQuery("select * from designation order by title");
int code=0;
String title=" ";
while(resultSet.next())
{
    code=resultSet.getInt("code");
    title=resultSet.getString("title").trim();//very very important
    designationDTO=new DesignationDTO();
    designationDTO.setCode(code);
    designationDTO.setTitle(title);
    designations.add(designationDTO);

}
resultSet.close();
statement.close();
connection.close();
        }catch(Exception exception)
        {
            throw new DAOException(exception.getMessage());
        }
        return designations;

    }
public boolean designationCodeExists(int designationCode)throws DAOException
{
try
{
boolean exists=false;
Connection connection=DAOConnection.getConnection();
PreparedStatement preparedStatement;
ResultSet resultSet;
preparedStatement=connection.prepareStatement("select code from designation Where code=?");
preparedStatement.setInt(1,designationCode);
resultSet=preparedStatement.executeQuery();
exists=resultSet.next();
preparedStatement.close();
resultSet.close();
connection.close();
return exists;
}catch(SQLException exception)
{
throw new DAOException(exception.getMessage());
}
}
}