package com.thinking.machines.hr.tags;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
public class GuardTagHandler extends TagSupport
{
public GuardTagHandler()
{
reset();
}
private void reset()
{
//do nothing
}
public int doStartTag()
{
String userName=(String)pageContext.getAttribute("userName",PageContext.SESSION_SCOPE);
if(userName==null)
{
return super.EVAL_BODY_INCLUDE;
}

if(userName.length()==0)
{
return super.EVAL_BODY_INCLUDE;
}
return super.SKIP_BODY;
}
public int doEndTag()
{
return super.SKIP_BODY;
}



}