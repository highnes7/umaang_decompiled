package com.facebook;

public class FacebookAuthorizationException
  extends FacebookException
{
  public static final long serialVersionUID = 1L;
  
  public FacebookAuthorizationException() {}
  
  public FacebookAuthorizationException(String paramString)
  {
    super(paramString);
  }
  
  public FacebookAuthorizationException(String paramString, Throwable paramThrowable)
  {
    super(paramString, paramThrowable);
  }
  
  public FacebookAuthorizationException(Throwable paramThrowable)
  {
    super(paramThrowable);
  }
}
