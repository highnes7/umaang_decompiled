package com.google.android.android.internal;

import android.accounts.Account;
import android.os.Bundle;
import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.android.auth.AccountChangeEventsRequest;
import com.google.android.android.auth.AccountChangeEventsResponse;

public abstract interface zzee
  extends IInterface
{
  public abstract Bundle getData(Account paramAccount)
    throws RemoteException;
  
  public abstract Bundle getData(Account paramAccount, String paramString, Bundle paramBundle)
    throws RemoteException;
  
  public abstract Bundle getData(String paramString, Bundle paramBundle)
    throws RemoteException;
  
  public abstract AccountChangeEventsResponse getSuggestions(AccountChangeEventsRequest paramAccountChangeEventsRequest)
    throws RemoteException;
}
