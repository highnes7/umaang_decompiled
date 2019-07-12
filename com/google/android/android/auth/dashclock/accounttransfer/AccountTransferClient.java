package com.google.android.android.auth.dashclock.accounttransfer;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.Context;
import android.os.RemoteException;
import com.google.android.android.common.internal.zzbp;
import com.google.android.android.common.package_9.PropertyInfo;
import com.google.android.android.common.package_9.Sample;
import com.google.android.android.common.package_9.Status;
import com.google.android.android.common.package_9.internal.RealmObject;
import com.google.android.android.internal.zzarr;
import com.google.android.android.internal.zzaru;
import com.google.android.android.internal.zzarv;
import com.google.android.android.internal.zzarx;
import com.google.android.android.internal.zzarz;
import com.google.android.android.internal.zzasb;
import com.google.android.android.internal.zzasd;
import com.google.android.android.tasks.Task;
import com.google.android.gms.auth.api.accounttransfer.zzo;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.zza;
import com.google.android.gms.common.api.internal.zzdd;
import com.google.android.gms.internal.zzaro;
import com.google.android.gms.internal.zzarq;

public class AccountTransferClient
  extends com.google.android.gms.common.api.GoogleApi<zzo>
{
  public static final com.google.android.gms.common.api.Api.zzf<zzarq> zzdyp = new com.google.android.android.common.package_9.Api.zzf();
  public static final Api.zza<zzarq, zzo> zzdyq = new Engine();
  public static final Api<zzo> zzdyr = new Sample("AccountTransfer.ACCOUNT_TRANSFER_API", zzdyq, zzdyp);
  
  public AccountTransferClient(Activity paramActivity)
  {
    super(paramActivity, zzdyr, null, new PropertyInfo().setFlags(new RealmObject()).zzafn());
  }
  
  public AccountTransferClient(Context paramContext)
  {
    super(paramContext, zzdyr, null, new PropertyInfo().setFlags(new RealmObject()).zzafn());
  }
  
  public static void append(com.google.android.android.tasks.TaskCompletionSource paramTaskCompletionSource, Status paramStatus)
  {
    paramStatus = String.valueOf(paramStatus.zzafu());
    if (paramStatus.length() != 0) {
      paramStatus = "Exception with Status code=".concat(paramStatus);
    } else {
      paramStatus = new String("Exception with Status code=");
    }
    paramTaskCompletionSource.setException(new Ref.BooleanRef(paramStatus));
  }
  
  public Task getDeviceMetaData(String paramString)
  {
    zzbp.append(paramString);
    return getLastKnownLocation(new NavitMapDownloader(this, new zzarr(1, paramString)));
  }
  
  public Task notifyCompletion(String paramString, int paramInt)
  {
    zzbp.append(paramString);
    return sendData(new ASN1OctetString(this, new zzarx(1, paramString, paramInt)));
  }
  
  public Task retrieveData(String paramString)
  {
    zzbp.append(paramString);
    return getLastKnownLocation(new Email(this, new zzarz(1, paramString)));
  }
  
  public Task sendData(String paramString, byte[] paramArrayOfByte)
  {
    zzbp.append(paramString);
    zzbp.append(paramArrayOfByte);
    return sendData(new Bookmark(this, new zzasb(1, paramString, paramArrayOfByte)));
  }
  
  public Task showUserChallenge(String paramString, PendingIntent paramPendingIntent)
  {
    zzbp.append(paramString);
    zzbp.append(paramPendingIntent);
    return sendData(new MainActivity(this, new zzasd(1, paramString, paramPendingIntent)));
  }
  
  public class zza<T>
    extends zzaro
  {
    public zza() {}
    
    public final void onFailure(Status paramStatus)
    {
      printStackTrace(paramStatus);
    }
  }
  
  public abstract class zzb<T>
    extends zzdd<zzarq, T>
  {
    public com.google.android.gms.tasks.TaskCompletionSource<T> zzdzc;
    
    public zzb() {}
    
    public abstract void downloadData(zzarv paramZzarv)
      throws RemoteException;
    
    public final void printStackTrace(Status paramStatus)
    {
      AccountTransferClient.append(zzdzc, paramStatus);
    }
    
    public final void setResult(Object paramObject)
    {
      zzdzc.setResult(paramObject);
    }
  }
  
  public abstract class zzc
    extends com.google.android.gms.auth.api.accounttransfer.AccountTransferClient.zzb<Void>
  {
    public zzaru zzdzd = new SearchFragment.2(this);
    
    public zzc()
    {
      super();
    }
  }
}
