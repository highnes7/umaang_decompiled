package com.google.android.android.common.package_9;

public class ApiException
  extends Exception
{
  public final Status mStatus;
  
  public ApiException(Status paramStatus)
  {
    super(localStringBuilder.toString());
    mStatus = paramStatus;
  }
  
  public int getStatusCode()
  {
    return mStatus.getStatusCode();
  }
  
  public String getStatusMessage()
  {
    return mStatus.getStatusMessage();
  }
}
