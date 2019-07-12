package com.google.android.android.common.package_9;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.content.IntentSender.SendIntentException;
import android.os.Bundle;
import com.google.android.android.common.ConnectionResult;
import com.google.android.android.common.GoogleApiAvailability;
import com.google.android.android.common.package_9.internal.zzbp;

public class GoogleApiActivity
  extends Activity
  implements DialogInterface.OnCancelListener
{
  public int zzfgz = 0;
  
  public GoogleApiActivity() {}
  
  public static Intent createIntent(Context paramContext, PendingIntent paramPendingIntent, int paramInt, boolean paramBoolean)
  {
    paramContext = new Intent(paramContext, com.google.android.gms.common.api.GoogleApiActivity.class);
    paramContext.putExtra("pending_intent", paramPendingIntent);
    paramContext.putExtra("failing_client_id", paramInt);
    paramContext.putExtra("notify_manager", paramBoolean);
    return paramContext;
  }
  
  public static PendingIntent createPendingIntent(Context paramContext, PendingIntent paramPendingIntent, int paramInt)
  {
    return PendingIntent.getActivity(paramContext, 0, createIntent(paramContext, paramPendingIntent, paramInt, true), 134217728);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramInt1 == 1)
    {
      boolean bool = getIntent().getBooleanExtra("notify_manager", true);
      zzfgz = 0;
      setResult(paramInt2, paramIntent);
      if (bool)
      {
        paramIntent = zzbp.zzca(this);
        if (paramInt2 != -1)
        {
          if (paramInt2 == 0) {
            paramIntent.onPageChanged(new ConnectionResult(13, null), getIntent().getIntExtra("failing_client_id", -1));
          }
        }
        else {
          paramIntent.zzafw();
        }
      }
    }
    else if (paramInt1 == 2)
    {
      zzfgz = 0;
      setResult(paramInt2, paramIntent);
    }
    finish();
  }
  
  public void onCancel(DialogInterface paramDialogInterface)
  {
    zzfgz = 0;
    setResult(0);
    finish();
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    if (paramBundle != null) {
      zzfgz = paramBundle.getInt("resolution");
    }
    if (zzfgz != 1)
    {
      Object localObject = getIntent().getExtras();
      if (localObject == null)
      {
        finish();
        return;
      }
      paramBundle = (PendingIntent)((Bundle)localObject).get("pending_intent");
      localObject = (Integer)((Bundle)localObject).get("error_code");
      if ((paramBundle == null) && (localObject == null))
      {
        finish();
        return;
      }
      if (paramBundle != null) {}
      try
      {
        startIntentSenderForResult(paramBundle.getIntentSender(), 1, null, 0, 0, 0);
        zzfgz = 1;
        return;
      }
      catch (IntentSender.SendIntentException paramBundle)
      {
        for (;;) {}
      }
      finish();
      return;
      GoogleApiAvailability.zzffi.showErrorDialogFragment(this, ((Integer)localObject).intValue(), 2, this);
      zzfgz = 1;
      return;
    }
  }
  
  public void onSaveInstanceState(Bundle paramBundle)
  {
    paramBundle.putInt("resolution", zzfgz);
    super.onSaveInstanceState(paramBundle);
  }
}
