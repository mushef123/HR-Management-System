package com.thinking.machines.hr.beans;
public class AdministratorBean implements java.io.Serializable
{
String userName;
String password;
public AdministratorBean()
{
userName="";
password="";
}
public void setUserName(String userName)
{
this.userName=userName;
}
public String getUserName()
{
return this.userName;
}

public void setPassword(String password)
{
this.password=password;
}
public String getPassword()
{
return this.password;
}
}