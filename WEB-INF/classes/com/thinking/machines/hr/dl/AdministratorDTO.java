package com.thinking.machines.hr.dl;
public class AdministratorDTO implements java.io.Serializable,Comparable<AdministratorDTO>
{
private String userName;
private String password;
public AdministratorDTO()
{
this.userName="";
this.password="";
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
public boolean equals(Object other)
{
if(!(other instanceof AdministratorDTO))return false;
 AdministratorDTO administrator=(AdministratorDTO)other;
return this.userName.equalsIgnoreCase(administrator.getUserName());
}
public int hashCode()
{
return this.userName.toLowerCase().hashCode();
}
public int compareTo(AdministratorDTO administrator)
{
return this.userName.compareTo(administrator.getUserName()); 
}

}