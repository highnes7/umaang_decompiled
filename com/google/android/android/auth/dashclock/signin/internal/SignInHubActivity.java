package com.google.android.android.auth.dashclock.signin.internal;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.app.LoaderManager.LoaderCallbacks;
import android.support.v4.package_7.FragmentActivity;
import android.support.v4.package_7.LoaderManager;
import android.view.accessibility.AccessibilityEvent;
import com.google.android.android.auth.dashclock.signin.GoogleSignInAccount;
import com.google.android.android.auth.dashclock.signin.SignInAccount;
import com.google.android.android.common.package_9.GoogleApiClient;
import com.google.android.android.common.package_9.Status;
import com.google.android.gms.common.annotation.KeepName;
import support.android.v4.content.Loader;

@KeepName
public class SignInHubActivity
  extends FragmentActivity
{
  public Phrase zzede;
  public boolean zzedf = false;
  public SignInConfiguration zzedg;
  public boolean zzedh;
  public int zzedi;
  public Intent zzedj;
  
  public SignInHubActivity() {}
  
  private final void zzaar()
  {
    getSupportLoaderManager().initLoader(0, null, new zza(null));
  }
  
  private final void zzay(int paramInt)
  {
    Status localStatus = new Status(1, paramInt, null, null);
    Intent localIntent = new Intent();
    localIntent.putExtra("googleSignInStatus", localStatus);
    setResult(0, localIntent);
    finish();
  }
  
  public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent paramAccessibilityEvent)
  {
    return true;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (zzedf) {
      return;
    }
    setResult(0);
    if (paramInt1 != 40962) {
      return;
    }
    if (paramIntent != null)
    {
      Object localObject = (SignInAccount)paramIntent.getParcelableExtra("signInAccount");
      if ((localObject != null) && (((SignInAccount)localObject).getGoogleSignInAccount() != null))
      {
        localObject = ((SignInAccount)localObject).getGoogleSignInAccount();
        zzede.trim((GoogleSignInAccount)localObject, zzedg.zzaaq());
        paramIntent.removeExtra("signInAccount");
        paramIntent.putExtra("googleSignInAccount", (Parcelable)localObject);
        zzedh = true;
        zzedi = paramInt2;
        zzedj = paramIntent;
        zzaar();
        return;
      }
      if (paramIntent.hasExtra("errorCode"))
      {
        zzay(paramIntent.getIntExtra("errorCode", 8));
        return;
      }
    }
    zzay(8);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    zzede = Phrase.zzbl(this);
    Intent localIntent = getIntent();
    if (!"com.google.android.gms.auth.GOOGLE_SIGN_IN".equals(localIntent.getAction()))
    {
      String str = String.valueOf(localIntent.getAction());
      if (str.length() != 0) {
        "Unknown action: ".concat(str);
      } else {
        new String("Unknown action: ");
      }
      finish();
    }
    zzedg = ((SignInConfiguration)localIntent.getParcelableExtra("config"));
    if (zzedg == null)
    {
      setResult(0);
      finish();
      return;
    }
    if (paramBundle == null)
    {
      paramBundle = new Intent("com.google.android.gms.auth.GOOGLE_SIGN_IN");
      paramBundle.setPackage("com.google.android.gms");
      paramBundle.putExtra("config", zzedg);
    }
    try
    {
      startActivityForResult(paramBundle, 40962);
      return;
    }
    catch (ActivityNotFoundException paramBundle)
    {
      for (;;) {}
    }
    zzedf = true;
    zzay(17);
    return;
    zzedh = paramBundle.getBoolean("signingInGoogleApiClients");
    if (zzedh)
    {
      zzedi = paramBundle.getInt("signInResultCode");
      zzedj = ((Intent)paramBundle.getParcelable("signInResultData"));
      zzaar();
      return;
    }
  }
  
  public void onSaveInstanceState(Bundle paramBundle)
  {
    super.onSaveInstanceState(paramBundle);
    paramBundle.putBoolean("signingInGoogleApiClients", zzedh);
    if (zzedh)
    {
      paramBundle.putInt("signInResultCode", zzedi);
      paramBundle.putParcelable("signInResultData", zzedj);
    }
  }
  
  public final class zza
    implements LoaderManager.LoaderCallbacks<Void>
  {
    public zza() {}
    
    public final Loader onCreateLoader(int paramInt, Bundle paramBundle)
    {
      return new AccountLoader(SignInHubActivity.this, GoogleApiClient.zzafo());
    }
    
    public final void onLoaderReset(Loader paramLoader) {}
  }
}
