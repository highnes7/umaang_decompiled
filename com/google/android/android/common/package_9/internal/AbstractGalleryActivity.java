package com.google.android.android.common.package_9.internal;

import android.app.PendingIntent;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import com.google.android.android.common.ConnectionResult;
import com.google.android.android.common.GoogleApiAvailability;
import com.google.android.gms.common.api.internal.zzp;
import java.util.concurrent.atomic.AtomicReference;

public abstract class AbstractGalleryActivity
  extends LifecycleCallback
  implements DialogInterface.OnCancelListener
{
  public volatile boolean mStarted;
  public final GoogleApiAvailability zzfhl;
  public final AtomicReference<zzp> zzfiw = new AtomicReference(null);
  public final Handler zzfix = new Handler(Looper.getMainLooper());
  
  public AbstractGalleryActivity(zzcg paramZzcg)
  {
    this(paramZzcg, GoogleApiAvailability.zzffi);
  }
  
  public AbstractGalleryActivity(zzcg paramZzcg, GoogleApiAvailability paramGoogleApiAvailability)
  {
    super(paramZzcg);
    zzfhl = paramGoogleApiAvailability;
  }
  
  public static int get(Fragment paramFragment)
  {
    if (paramFragment == null) {
      return -1;
    }
    return paramFragment.zzagc();
  }
  
  public final void clear(ConnectionResult paramConnectionResult, int paramInt)
  {
    paramConnectionResult = new Fragment(paramConnectionResult, paramInt);
    if (zzfiw.compareAndSet(null, paramConnectionResult)) {
      zzfix.post(new IonBitmapRequestBuilder.1(this, paramConnectionResult));
    }
  }
  
  public abstract void handleMessage(ConnectionResult paramConnectionResult, int paramInt);
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    Fragment localFragment2 = (Fragment)zzfiw.get();
    int j = 1;
    int i = 1;
    Fragment localFragment1;
    if (paramInt1 != 1)
    {
      if (paramInt1 != 2)
      {
        localFragment1 = localFragment2;
      }
      else
      {
        j = zzfhl.isGooglePlayServicesAvailable(getActivity());
        if (j == 0) {
          paramInt1 = i;
        } else {
          paramInt1 = 0;
        }
        if (localFragment2 == null) {
          return;
        }
        localFragment1 = localFragment2;
        paramInt2 = paramInt1;
        if (localFragment2.zzagd().getErrorCode() != 18) {
          break label173;
        }
        localFragment1 = localFragment2;
        paramInt2 = paramInt1;
        if (j != 18) {
          break label173;
        }
      }
    }
    else
    {
      if (paramInt2 == -1)
      {
        localFragment1 = localFragment2;
        paramInt2 = j;
        break label173;
      }
      localFragment1 = localFragment2;
      if (paramInt2 == 0)
      {
        paramInt1 = 13;
        if (paramIntent != null) {
          paramInt1 = paramIntent.getIntExtra("<<ResolutionFailureErrorDetail>>", 13);
        }
        localFragment1 = new Fragment(new ConnectionResult(paramInt1, null), get(localFragment2));
        zzfiw.set(localFragment1);
      }
    }
    paramInt2 = 0;
    label173:
    if (paramInt2 != 0)
    {
      zzagb();
      return;
    }
    if (localFragment1 != null) {
      handleMessage(localFragment1.zzagd(), localFragment1.zzagc());
    }
  }
  
  public void onCancel(DialogInterface paramDialogInterface)
  {
    handleMessage(new ConnectionResult(13, null), get((Fragment)zzfiw.get()));
    zzagb();
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    if (paramBundle != null)
    {
      AtomicReference localAtomicReference = zzfiw;
      if (paramBundle.getBoolean("resolving_error", false)) {
        paramBundle = new Fragment(new ConnectionResult(paramBundle.getInt("failed_status"), (PendingIntent)paramBundle.getParcelable("failed_resolution")), paramBundle.getInt("failed_client_id", -1));
      } else {
        paramBundle = null;
      }
      localAtomicReference.set(paramBundle);
    }
  }
  
  public final void onSaveInstanceState(Bundle paramBundle)
  {
    Fragment localFragment = (Fragment)zzfiw.get();
    if (localFragment != null)
    {
      paramBundle.putBoolean("resolving_error", true);
      paramBundle.putInt("failed_client_id", localFragment.zzagc());
      paramBundle.putInt("failed_status", localFragment.zzagd().getErrorCode());
      paramBundle.putParcelable("failed_resolution", localFragment.zzagd().getResolution());
    }
  }
  
  public void onStart()
  {
    mStarted = true;
  }
  
  public void onStop()
  {
    mStarted = false;
  }
  
  public abstract void zzafw();
  
  public final void zzagb()
  {
    zzfiw.set(null);
    zzafw();
  }
}
