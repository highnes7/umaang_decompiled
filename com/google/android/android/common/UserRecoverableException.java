package com.google.android.android.common;

import android.content.Intent;

public class UserRecoverableException
  extends Exception
{
  public final Intent mIntent;
  
  public UserRecoverableException(String paramString, Intent paramIntent)
  {
    super(paramString);
    mIntent = paramIntent;
  }
  
  public Intent getIntent()
  {
    return new Intent(mIntent);
  }
}
