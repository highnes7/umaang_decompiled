package com.google.android.android.auth;

import android.content.Intent;

public class UserRecoverableAuthException
  extends GoogleAuthException
{
  public final Intent mIntent;
  
  public UserRecoverableAuthException(String paramString, Intent paramIntent)
  {
    super(paramString);
    mIntent = paramIntent;
  }
  
  public Intent getIntent()
  {
    Intent localIntent = mIntent;
    if (localIntent == null) {
      return null;
    }
    return new Intent(localIntent);
  }
}
