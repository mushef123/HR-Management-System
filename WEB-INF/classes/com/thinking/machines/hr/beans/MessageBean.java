package com.thinking.machines.hr.beans;
public class MessageBean implements java.io.Serializable
{
String heading;
String message;
boolean generateButtons;
boolean generateTwoButtons;
String buttonOneText;
String buttonTwoText;
String buttonOneAction;
String buttonTwoAction;
public MessageBean()
{
heading="";
message="";
generateButtons=false;
generateTwoButtons=false;
}
public void setHeading(String heading)
{
this.heading=heading;
}
public String getHeading()
{
return this.heading;
}
public void setMessage(String message)
{
this.message=message;
}
public String getMessage()
{
return this.message;
}
public void setGenerateButtons(boolean generateButtons)
{
this.generateButtons=generateButtons;
}
public boolean getGenerateButtons()
{
return this.generateButtons;
}
public void setGenerateTwoButtons(boolean generateTwoButtons)
{
this.generateTwoButtons=generateTwoButtons;
}
public boolean getGenerateTwoButtons()
{
return this.generateTwoButtons;
}
public void setButtonOneText(String buttonOneText)
{
this.buttonOneText=buttonOneText;
}
public String getButtonOneText()
{
return this.buttonOneText;
}
public void setButtonOneAction(String buttonOneAction)
{
this.buttonOneAction=buttonOneAction;
}
public String getButtonOneAction()
{
return this.buttonOneAction;
}
public void setButtonTwoText(String buttonTwoText)
{
this.buttonTwoText=buttonTwoText;
}
public String getButtonTwoText()
{
return this.buttonTwoText;
}
public void setButtonTwoAction(String buttonTwoAction)
{
this.buttonTwoAction=buttonTwoAction;
}
public String getButtonTwoAction()
{
return this.buttonTwoAction;
}

}
