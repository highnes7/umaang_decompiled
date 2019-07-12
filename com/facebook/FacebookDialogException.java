package com.facebook;

public class FacebookDialogException
  extends FacebookException
{
  public static final long serialVersionUID = 1L;
  public int errorCode;
  public String failingUrl;
  
  public FacebookDialogException(String paramString1, int paramInt, String paramString2)
  {
    super(paramString1);
    errorCode = paramInt;
    failingUrl = paramString2;
  }
  
  public int getErrorCode()
  {
    return errorCode;
  }
  
  public String getFailingUrl()
  {
    return failingUrl;
  }
  
  public final String toString()
  {
    StringBuilder localStringBuilder = f.sufficientlysecure.rootcommands.util.StringBuilder.append("{FacebookDialogException: ", "errorCode: ");
    localStringBuilder.append(getErrorCode());
    localStringBuilder.append(", message: ");
    localStringBuilder.append(getMessage());
    localStringBuilder.append(", url: ");
    localStringBuilder.append(getFailingUrl());
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }
}
