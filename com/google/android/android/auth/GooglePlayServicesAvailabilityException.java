package com.google.android.android.auth;

import android.content.Intent;

public class GooglePlayServicesAvailabilityException
  extends UserRecoverableAuthException
{
  public final int zzdxr;
  
  public GooglePlayServicesAvailabilityException(int paramInt, String paramString, Intent paramIntent)
  {
    super(paramString, paramIntent);
    zzdxr = paramInt;
  }
  
  public int getConnectionStatusCode()
  {
    return zzdxr;
  }
}
