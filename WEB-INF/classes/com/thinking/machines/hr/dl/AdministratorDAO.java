package com.thinking.machines.hr.dl;
import java.sql.*;
public class AdministratorDAO
{
public AdministratorDTO getByUserName(String userName)throws DAOException
{
Connection connection=null;
PreparedStatement preparedStatement;
ResultSet resultSet;
try
{
if(userName==null)throw new DAOException("User Name: "+userName+" is Invalid");
userName=userName.trim();
if(userName.length()==0)
{
throw new DAOException("User Name: "+userName+" is Invalid");
}
connection=DAOConnection.getConnection();
preparedStatement=connection.prepareStatement("select * from administrator where uname=?");
preparedStatement.setString(1,userName);
resultSet=preparedStatement.executeQuery();
if(resultSet.next()==false)
{
resultSet.close();
preparedStatement.close();
connection.close();
throw new DAOException("Invalid UserName: "+userName);
}
AdministratorDTO administrator=new AdministratorDTO();
administrator.setUserName(resultSet.getString("uname"));
administrator.setPassword(resultSet.getString("pwd"));
resultSet.close();
preparedStatement.close();
connection.close();
return administrator;



}catch(SQLException sqlException)
{
throw new DAOException(sqlException.getMessage());
}
}
}