package com.thinking.machines.hr.beans;
public class ErrorBean implements java.io.Serializable
{
String error;
String panNumberErrorSection;
String aadharCardNumberErrorSection;
public ErrorBean()
{
this.error="";
this.panNumberErrorSection="";
this.aadharCardNumberErrorSection="";
}
public void setError(String error)
{
this.error=error;
}
public String getError()
{
return this.error;
}
public void setPanNumberErrorSection(String panNumberErrorSection)
{
this.panNumberErrorSection=panNumberErrorSection;
}
public String getPanNumberErrorSection()
{
return this.panNumberErrorSection;
}
public void setAadharCardNumberErrorSection(String aadharCardNumberErrorSection)
{
this.aadharCardNumberErrorSection=aadharCardNumberErrorSection;
}
public String getAadharCardNumberErrorSection()
{
return this.aadharCardNumberErrorSection;
}


} 