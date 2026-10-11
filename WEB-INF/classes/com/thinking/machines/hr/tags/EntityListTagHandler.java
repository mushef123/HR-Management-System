package com.thinking.machines.hr.tags;
import com.thinking.machines.hr.bl.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.lang.reflect.*;
import java.util.*;
public class EntityListTagHandler extends BodyTagSupport
{
private String populatorClass;
private String populatorMethod;
private String name;
private List list;
private int index;
public EntityListTagHandler()
{
reset();
}
public void setPopulatorClass(String populatorClass)
{
this.populatorClass=populatorClass;
}
public void setPopulatorMethod(String populatorMethod)
{
this.populatorMethod=populatorMethod;
}
public void setName(String name)
{
this.name=name;
}
public String getPopulatorClass()
{
return this.populatorClass;
}
public String getPopulatorMethod()
{
return this.populatorMethod;
}
public String getName()
{
return this.name;
}
private void reset()
{
index=0;
list=null;
populatorClass=null;
populatorMethod=null;
name=null;
}
public int doStartTag()
{
try
{
if(name==null || name.length()==0)return super.SKIP_BODY;
Class c=Class.forName(populatorClass);
Object obj=c.newInstance();
Class []parameters=new Class[0];
Method method=c.getMethod(populatorMethod,parameters);
list=(List)method.invoke(obj);
if(list==null)return super.SKIP_BODY;
if(list.size()==0)return super.SKIP_BODY;
Object bean=list.get(index);
pageContext.setAttribute(name,bean,PageContext.REQUEST_SCOPE);
pageContext.setAttribute("serialNumber",new Integer(index+1));
index++;

return super.EVAL_BODY_INCLUDE;
}catch(Throwable t)
{
System.out.println(t.getMessage());
return super.SKIP_BODY;

}
}
public int doAfterBody()
{
if(index==list.size())return SKIP_BODY;
Object bean=list.get(index);
pageContext.setAttribute(name,bean,PageContext.REQUEST_SCOPE);
pageContext.setAttribute("serialNumber",new Integer(index+1));
index++;

return super.EVAL_BODY_AGAIN;
}
public int doEndTag()
{
reset();
return super.EVAL_PAGE;
}


}