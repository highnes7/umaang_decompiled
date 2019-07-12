package com.google.android.android.auth.dashclock.signin;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;
import com.google.android.android.auth.dashclock.signin.internal.AccountAuthenticator;

public final class RevocationBoundService
  extends Service
{
  public RevocationBoundService() {}
  
  public final IBinder onBind(Intent paramIntent)
  {
    if ("com.google.android.gms.auth.api.signin.RevocationBoundService.disconnect".equals(paramIntent.getAction()))
    {
      Log.isLoggable("RevocationService", 2);
      return new AccountAuthenticator(this);
    }
    paramIntent = String.valueOf(paramIntent.getAction());
    if (paramIntent.length() != 0) {
      "Unknown action sent to RevocationBoundService: ".concat(paramIntent);
    } else {
      new String("Unknown action sent to RevocationBoundService: ");
    }
    return null;
  }
}
