package com.facebook.internal;

public class InternalSettings
{
  public static volatile String mCustomUserAgent;
  
  public InternalSettings() {}
  
  public static String getCustomUserAgent()
  {
    return mCustomUserAgent;
  }
  
  public static void setCustomUserAgent(String paramString)
  {
    mCustomUserAgent = paramString;
  }
}
