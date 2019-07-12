package com.google.android.android.auth.dashclock.signin.internal;

import android.os.RemoteException;
import com.google.android.android.auth.dashclock.signin.GoogleSignInAccount;
import com.google.android.android.auth.dashclock.signin.GoogleSignInResult;
import com.google.android.android.common.package_9.Status;
import com.google.android.android.common.package_9.internal.Log;

public final class FavoritesArrayAdapter
  extends ArrayAdapter
{
  public FavoritesArrayAdapter(Model paramModel) {}
  
  public final void add(GoogleSignInAccount paramGoogleSignInAccount, Status paramStatus)
    throws RemoteException
  {
    if (paramGoogleSignInAccount != null)
    {
      Model localModel = zzecw;
      zzecu.trim(paramGoogleSignInAccount, zzecv);
    }
    zzecw.setResult(new GoogleSignInResult(paramGoogleSignInAccount, paramStatus));
  }
}
