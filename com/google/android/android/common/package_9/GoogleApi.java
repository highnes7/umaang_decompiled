package com.google.android.android.common.package_9;

import android.accounts.Account;
import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.os.Handler;
import android.os.Looper;
import com.google.android.android.auth.dashclock.signin.GoogleSignInAccount;
import com.google.android.android.common.internal.AccountInformation;
import com.google.android.android.common.internal.Quaternion;
import com.google.android.android.common.package_9.internal.Log;
import com.google.android.android.common.package_9.internal.Logger;
import com.google.android.android.common.package_9.internal.Msg;
import com.google.android.android.common.package_9.internal.RealmObject;
import com.google.android.android.common.package_9.internal.zzak;
import com.google.android.android.common.package_9.internal.zzbr;
import com.google.android.android.common.package_9.internal.zzbx;
import com.google.android.android.common.package_9.internal.zzcw;
import com.google.android.android.common.package_9.internal.zzcz;
import com.google.android.android.common.package_9.internal.zzdd;
import com.google.android.android.tasks.Task;
import com.google.android.android.tasks.TaskCompletionSource;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.internal.zzh;
import java.util.Collection;
import java.util.Collections;

public class GoogleApi<O extends com.google.android.gms.common.api.Api.ApiOptions>
{
  public final Context mContext;
  public final int mInstanceId;
  public final Looper zzakg;
  public final Api<O> zzfdg;
  public final O zzfgr;
  public final zzh<O> zzfgs;
  public final GoogleApiClient zzfgt;
  public final zzcz zzfgu;
  public final com.google.android.android.common.package_9.internal.zzbp zzfgv;
  
  public GoogleApi(Activity paramActivity, Sample paramSample, Api.ApiOptions paramApiOptions, zza paramZza)
  {
    com.google.android.android.common.internal.zzbp.get(paramActivity, "Null activity is not permitted.");
    com.google.android.android.common.internal.zzbp.get(paramSample, "Api must not be null.");
    com.google.android.android.common.internal.zzbp.get(paramZza, "Settings must not be null; use Settings.DEFAULT_SETTINGS instead.");
    mContext = paramActivity.getApplicationContext();
    zzfdg = paramSample;
    zzfgr = paramApiOptions;
    zzakg = zzfgy;
    zzfgs = new Msg(zzfdg, zzfgr);
    zzfgt = new zzbx(this);
    zzfgv = com.google.android.android.common.package_9.internal.zzbp.zzca(mContext);
    mInstanceId = zzfgv.zzahq();
    zzfgu = zzfgx;
    zzak.submit(paramActivity, zzfgv, zzfgs);
    zzfgv.notifyError(this);
  }
  
  public GoogleApi(Activity paramActivity, Sample paramSample, Api.ApiOptions paramApiOptions, zzcz paramZzcz)
  {
    this(paramActivity, paramSample, paramApiOptions, new PropertyInfo().setFlags(paramZzcz).setFlags(paramActivity.getMainLooper()).zzafn());
  }
  
  public GoogleApi(Context paramContext, Sample paramSample, Looper paramLooper)
  {
    com.google.android.android.common.internal.zzbp.get(paramContext, "Null context is not permitted.");
    com.google.android.android.common.internal.zzbp.get(paramSample, "Api must not be null.");
    com.google.android.android.common.internal.zzbp.get(paramLooper, "Looper must not be null.");
    mContext = paramContext.getApplicationContext();
    zzfdg = paramSample;
    zzfgr = null;
    zzakg = paramLooper;
    zzfgs = new Msg(paramSample);
    zzfgt = new zzbx(this);
    zzfgv = com.google.android.android.common.package_9.internal.zzbp.zzca(mContext);
    mInstanceId = zzfgv.zzahq();
    zzfgu = new RealmObject();
  }
  
  public GoogleApi(Context paramContext, Sample paramSample, Api.ApiOptions paramApiOptions, Looper paramLooper, zzcz paramZzcz)
  {
    this(paramContext, paramSample, null, new PropertyInfo().setFlags(paramLooper).setFlags(paramZzcz).zzafn());
  }
  
  public GoogleApi(Context paramContext, Sample paramSample, Api.ApiOptions paramApiOptions, zza paramZza)
  {
    com.google.android.android.common.internal.zzbp.get(paramContext, "Null context is not permitted.");
    com.google.android.android.common.internal.zzbp.get(paramSample, "Api must not be null.");
    com.google.android.android.common.internal.zzbp.get(paramZza, "Settings must not be null; use Settings.DEFAULT_SETTINGS instead.");
    mContext = paramContext.getApplicationContext();
    zzfdg = paramSample;
    zzfgr = paramApiOptions;
    zzakg = zzfgy;
    zzfgs = new Msg(zzfdg, zzfgr);
    zzfgt = new zzbx(this);
    zzfgv = com.google.android.android.common.package_9.internal.zzbp.zzca(mContext);
    mInstanceId = zzfgv.zzahq();
    zzfgu = zzfgx;
    zzfgv.notifyError(this);
  }
  
  public GoogleApi(Context paramContext, Sample paramSample, Api.ApiOptions paramApiOptions, zzcz paramZzcz)
  {
    this(paramContext, paramSample, paramApiOptions, new PropertyInfo().setFlags(paramZzcz).zzafn());
  }
  
  private final Logger create(int paramInt, Logger paramLogger)
  {
    paramLogger.zzagg();
    zzfgv.output(this, paramInt, paramLogger);
    return paramLogger;
  }
  
  private final Task toString(int paramInt, zzdd paramZzdd)
  {
    TaskCompletionSource localTaskCompletionSource = new TaskCompletionSource();
    zzfgv.playSong(this, paramInt, paramZzdd, localTaskCompletionSource, zzfgu);
    return localTaskCompletionSource.getTask();
  }
  
  private final Quaternion zzafm()
  {
    Quaternion localQuaternion = new Quaternion();
    Object localObject = zzfgr;
    if ((localObject instanceof Api.ApiOptions.HasGoogleSignInAccountOptions)) {
      localObject = ((Api.ApiOptions.HasGoogleSignInAccountOptions)localObject).getGoogleSignInAccount().getAccount();
    } else if ((localObject instanceof Api.ApiOptions.HasAccountOptions)) {
      localObject = ((Api.ApiOptions.HasAccountOptions)localObject).getAccount();
    } else {
      localObject = null;
    }
    localQuaternion = localQuaternion.add((Account)localObject);
    localObject = zzfgr;
    if ((localObject instanceof Api.ApiOptions.HasGoogleSignInAccountOptions))
    {
      localObject = ((Api.ApiOptions.HasGoogleSignInAccountOptions)localObject).getGoogleSignInAccount();
      if (localObject != null)
      {
        localObject = ((GoogleSignInAccount)localObject).getGrantedScopes();
        break label102;
      }
    }
    localObject = Collections.emptySet();
    label102:
    return localQuaternion.set((Collection)localObject);
  }
  
  public final Logger add(Logger paramLogger)
  {
    create(2, paramLogger);
    return paramLogger;
  }
  
  public final Logger create(Logger paramLogger)
  {
    create(0, paramLogger);
    return paramLogger;
  }
  
  public final Context getApplicationContext()
  {
    return mContext;
  }
  
  public final int getInstanceId()
  {
    return mInstanceId;
  }
  
  public final Task getLastKnownLocation(zzdd paramZzdd)
  {
    return toString(0, paramZzdd);
  }
  
  public final Looper getLooper()
  {
    return zzakg;
  }
  
  public Api.zze getTemplate(Looper paramLooper, zzbr paramZzbr)
  {
    AccountInformation localAccountInformation = zzafm().zzfz(mContext.getPackageName()).zzga(mContext.getClass().getName()).zzajz();
    return zzfdg.zzafd().getTemplate(mContext, paramLooper, localAccountInformation, zzfgr, paramZzbr, paramZzbr);
  }
  
  public final Logger log(Logger paramLogger)
  {
    create(1, paramLogger);
    return paramLogger;
  }
  
  public zzcw requestSync(Context paramContext, Handler paramHandler)
  {
    return new zzcw(paramContext, paramHandler, zzafm().zzajz(), zzcw.zzfpd);
  }
  
  public final Task sendData(zzdd paramZzdd)
  {
    return toString(1, paramZzdd);
  }
  
  public final Sample zzafj()
  {
    return zzfdg;
  }
  
  public final Msg zzafk()
  {
    return zzfgs;
  }
  
  public final GoogleApiClient zzafl()
  {
    return zzfgt;
  }
  
  public final class zza
  {
    public static final zza zzfgw = new PropertyInfo().zzafn();
    public final Looper zzfgy;
    
    public zza(Account paramAccount, Looper paramLooper)
    {
      zzfgy = paramLooper;
    }
  }
}
