package com.google.android.android.internal;

import android.accounts.Account;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.android.auth.AccountChangeEventsRequest;
import com.google.android.android.auth.AccountChangeEventsResponse;

public final class zzeg
  extends zzeb
  implements zzee
{
  public zzeg(IBinder paramIBinder)
  {
    super(paramIBinder, "com.google.android.auth.IAuthManagerService");
  }
  
  public final Bundle getData(Account paramAccount)
    throws RemoteException
  {
    Object localObject = zzax();
    zzed.append((Parcel)localObject, paramAccount);
    paramAccount = get(7, (Parcel)localObject);
    localObject = (Bundle)zzed.get(paramAccount, Bundle.CREATOR);
    paramAccount.recycle();
    return localObject;
  }
  
  public final Bundle getData(Account paramAccount, String paramString, Bundle paramBundle)
    throws RemoteException
  {
    Parcel localParcel = zzax();
    zzed.append(localParcel, paramAccount);
    localParcel.writeString(paramString);
    zzed.append(localParcel, paramBundle);
    paramAccount = get(5, localParcel);
    paramString = (Bundle)zzed.get(paramAccount, Bundle.CREATOR);
    paramAccount.recycle();
    return paramString;
  }
  
  public final Bundle getData(String paramString, Bundle paramBundle)
    throws RemoteException
  {
    Parcel localParcel = zzax();
    localParcel.writeString(paramString);
    zzed.append(localParcel, paramBundle);
    paramString = get(2, localParcel);
    paramBundle = (Bundle)zzed.get(paramString, Bundle.CREATOR);
    paramString.recycle();
    return paramBundle;
  }
  
  public final AccountChangeEventsResponse getSuggestions(AccountChangeEventsRequest paramAccountChangeEventsRequest)
    throws RemoteException
  {
    Object localObject = zzax();
    zzed.append((Parcel)localObject, paramAccountChangeEventsRequest);
    paramAccountChangeEventsRequest = get(3, (Parcel)localObject);
    localObject = (AccountChangeEventsResponse)zzed.get(paramAccountChangeEventsRequest, AccountChangeEventsResponse.CREATOR);
    paramAccountChangeEventsRequest.recycle();
    return localObject;
  }
}
