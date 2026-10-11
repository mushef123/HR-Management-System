package com.thinking.machines.hr.bl;
import com.thinking.machines.hr.dl.*;
import com.thinking.machines.hr.beans.*;
import java.util.*;
public class DesignationBL
{
public List<DesignationBean>getAll()
{
List<DesignationBean>designation=null;
try
{
List<DesignationDTO>dlDesignation=new ArrayList<>();
DesignationBean designationBean;
DesignationDAO designationDAO=new DesignationDAO();
designation=new LinkedList<>();
dlDesignation=designationDAO.getAll();

for(DesignationDTO designationDTO:dlDesignation)
{
designationBean=new DesignationBean();
designationBean.setCode(designationDTO.getCode());
designationBean.setTitle(designationDTO.getTitle());
designation.add(designationBean);
}




}catch(DAOException daoException)
{
System.out.println(daoException.getMessage());
}
return designation;



}
}