package com.facebook;

public class FacebookServiceException
  extends FacebookException
{
  public static final long serialVersionUID = 1L;
  public final FacebookRequestError error;
  
  public FacebookServiceException(FacebookRequestError paramFacebookRequestError, String paramString)
  {
    super(paramString);
    error = paramFacebookRequestError;
  }
  
  public final FacebookRequestError getRequestError()
  {
    return error;
  }
  
  public final String toString()
  {
    StringBuilder localStringBuilder = f.sufficientlysecure.rootcommands.util.StringBuilder.append("{FacebookServiceException: ", "httpResponseCode: ");
    localStringBuilder.append(error.getRequestStatusCode());
    localStringBuilder.append(", facebookErrorCode: ");
    localStringBuilder.append(error.getErrorCode());
    localStringBuilder.append(", facebookErrorType: ");
    localStringBuilder.append(error.getErrorType());
    localStringBuilder.append(", message: ");
    localStringBuilder.append(error.getErrorMessage());
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }
}
