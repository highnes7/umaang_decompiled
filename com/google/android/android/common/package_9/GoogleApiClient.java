package com.google.android.android.common.package_9;

import android.accounts.Account;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.v4.package_7.FragmentActivity;
import android.view.View;
import com.google.android.android.common.ConnectionResult;
import com.google.android.android.common.GoogleApiAvailability;
import com.google.android.android.common.internal.AccountInformation;
import com.google.android.android.common.internal.Service;
import com.google.android.android.common.internal.zzbp;
import com.google.android.android.common.package_9.internal.ActivityBase;
import com.google.android.android.common.package_9.internal.ByteArrayBuffer;
import com.google.android.android.common.package_9.internal.Logger;
import com.google.android.android.common.package_9.internal.zzbd;
import com.google.android.android.common.package_9.internal.zzcf;
import com.google.android.android.common.package_9.internal.zzcj;
import com.google.android.android.common.package_9.internal.zzcv;
import com.google.android.android.common.package_9.internal.zzdg;
import com.google.android.android.internal.zzcpp;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.internal.zzs;
import com.google.android.gms.internal.zzcps;
import f.sufficientlysecure.rootcommands.util.StringBuilder;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;
import support.android.v4.util.ArrayMap;

public abstract class GoogleApiClient
{
  public static final int SIGN_IN_MODE_OPTIONAL = 2;
  public static final int SIGN_IN_MODE_REQUIRED = 1;
  public static final Set<com.google.android.gms.common.api.GoogleApiClient> zzfha = Collections.newSetFromMap(new WeakHashMap());
  
  public GoogleApiClient() {}
  
  public static void dumpAll(String paramString, FileDescriptor paramFileDescriptor, PrintWriter paramPrintWriter, String[] paramArrayOfString)
  {
    Set localSet = zzfha;
    int i = 0;
    try
    {
      String str = String.valueOf(paramString).concat("  ");
      Iterator localIterator = zzfha.iterator();
      while (localIterator.hasNext())
      {
        GoogleApiClient localGoogleApiClient = (GoogleApiClient)localIterator.next();
        paramPrintWriter.append(paramString).append("GoogleApiClient#").println(i);
        localGoogleApiClient.dump(str, paramFileDescriptor, paramPrintWriter, paramArrayOfString);
        i += 1;
      }
      return;
    }
    catch (Throwable paramString)
    {
      throw paramString;
    }
  }
  
  public static Set zzafo()
  {
    Set localSet1 = zzfha;
    try
    {
      Set localSet2 = zzfha;
      return localSet2;
    }
    catch (Throwable localThrowable)
    {
      throw localThrowable;
    }
  }
  
  public abstract ConnectionResult blockingConnect();
  
  public abstract ConnectionResult blockingConnect(long paramLong, TimeUnit paramTimeUnit);
  
  public abstract PendingResult clearDefaultAccountAndReconnect();
  
  public abstract void connect();
  
  public void connect(int paramInt)
  {
    throw new UnsupportedOperationException();
  }
  
  public Logger d(Logger paramLogger)
  {
    throw new UnsupportedOperationException();
  }
  
  public boolean deleteAccount(zzcv paramZzcv)
  {
    throw new UnsupportedOperationException();
  }
  
  public abstract void disconnect();
  
  public abstract void dump(String paramString, FileDescriptor paramFileDescriptor, PrintWriter paramPrintWriter, String[] paramArrayOfString);
  
  public void ensureInitialized(zzdg paramZzdg)
  {
    throw new UnsupportedOperationException();
  }
  
  public Logger get(Logger paramLogger)
  {
    throw new UnsupportedOperationException();
  }
  
  public Api.zze getChange(Api.zzc paramZzc)
  {
    throw new UnsupportedOperationException();
  }
  
  public abstract ConnectionResult getConnectionResult(Sample paramSample);
  
  public Context getContext()
  {
    throw new UnsupportedOperationException();
  }
  
  public Looper getLooper()
  {
    throw new UnsupportedOperationException();
  }
  
  public boolean has(Sample paramSample)
  {
    throw new UnsupportedOperationException();
  }
  
  public abstract boolean hasConnectedApi(Sample paramSample);
  
  public abstract boolean isConnected();
  
  public abstract boolean isConnecting();
  
  public abstract boolean isConnectionCallbacksRegistered(ConnectionCallbacks paramConnectionCallbacks);
  
  public abstract boolean isConnectionFailedListenerRegistered(OnConnectionFailedListener paramOnConnectionFailedListener);
  
  public abstract void reconnect();
  
  public abstract void registerConnectionCallbacks(ConnectionCallbacks paramConnectionCallbacks);
  
  public abstract void registerConnectionFailedListener(OnConnectionFailedListener paramOnConnectionFailedListener);
  
  public void removeAccount(zzdg paramZzdg)
  {
    throw new UnsupportedOperationException();
  }
  
  public zzcj setResolution(Object paramObject)
  {
    throw new UnsupportedOperationException();
  }
  
  public abstract void stopAutoManage(FragmentActivity paramFragmentActivity);
  
  public abstract void unregisterConnectionCallbacks(ConnectionCallbacks paramConnectionCallbacks);
  
  public abstract void unregisterConnectionFailedListener(OnConnectionFailedListener paramOnConnectionFailedListener);
  
  public void zzafp()
  {
    throw new UnsupportedOperationException();
  }
  
  public final class Builder
  {
    public Looper zzakg = getMainLooper();
    public Account zzduz;
    public String zzdxc = getPackageName();
    public final Set<com.google.android.gms.common.api.Scope> zzfhb = new HashSet();
    public final Set<com.google.android.gms.common.api.Scope> zzfhc = new HashSet();
    public int zzfhd;
    public View zzfhe;
    public String zzfhf = getClass().getName();
    public final Map<Api<?>, zzs> zzfhg = new ArrayMap();
    public final Map<Api<?>, com.google.android.gms.common.api.Api.ApiOptions> zzfhh = new ArrayMap();
    public zzcf zzfhi;
    public int zzfhj = -1;
    public GoogleApiClient.OnConnectionFailedListener zzfhk;
    public GoogleApiAvailability zzfhl = GoogleApiAvailability.zzffi;
    public com.google.android.gms.common.api.Api.zza<? extends zzcps, com.google.android.gms.internal.zzcpt> zzfhm = zzcpp.zzdwq;
    public final ArrayList<com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks> zzfhn = new ArrayList();
    public final ArrayList<com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener> zzfho = new ArrayList();
    public boolean zzfhp = false;
    
    public Builder() {}
    
    public Builder(GoogleApiClient.ConnectionCallbacks paramConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener paramOnConnectionFailedListener)
    {
      this();
      zzbp.get(paramConnectionCallbacks, "Must provide a connected listener");
      zzfhn.add(paramConnectionCallbacks);
      zzbp.get(paramOnConnectionFailedListener, "Must provide a connection failed listener");
      zzfho.add(paramOnConnectionFailedListener);
    }
    
    private final void execute(Sample paramSample, Api.ApiOptions paramApiOptions, Scope... paramVarArgs)
    {
      paramApiOptions = new HashSet(paramSample.zzafc().resolve(paramApiOptions));
      int j = paramVarArgs.length;
      int i = 0;
      while (i < j)
      {
        paramApiOptions.add(paramVarArgs[i]);
        i += 1;
      }
      zzfhg.put(paramSample, new Service(paramApiOptions));
    }
    
    public final Builder addApi(Sample paramSample)
    {
      zzbp.get(paramSample, "Api must not be null");
      zzfhh.put(paramSample, null);
      paramSample = paramSample.zzafc().resolve(null);
      zzfhc.addAll(paramSample);
      zzfhb.addAll(paramSample);
      return this;
    }
    
    public final Builder addApi(Sample paramSample, Api.ApiOptions.HasOptions paramHasOptions)
    {
      zzbp.get(paramSample, "Api must not be null");
      zzbp.get(paramHasOptions, "Null options are not permitted for this Api");
      zzfhh.put(paramSample, paramHasOptions);
      paramSample = paramSample.zzafc().resolve(paramHasOptions);
      zzfhc.addAll(paramSample);
      zzfhb.addAll(paramSample);
      return this;
    }
    
    public final Builder addApiIfAvailable(Sample paramSample, Api.ApiOptions.HasOptions paramHasOptions, Scope... paramVarArgs)
    {
      zzbp.get(paramSample, "Api must not be null");
      zzbp.get(paramHasOptions, "Null options are not permitted for this Api");
      zzfhh.put(paramSample, paramHasOptions);
      execute(paramSample, paramHasOptions, paramVarArgs);
      return this;
    }
    
    public final Builder addApiIfAvailable(Sample paramSample, Scope... paramVarArgs)
    {
      zzbp.get(paramSample, "Api must not be null");
      zzfhh.put(paramSample, null);
      execute(paramSample, null, paramVarArgs);
      return this;
    }
    
    public final Builder addConnectionCallbacks(GoogleApiClient.ConnectionCallbacks paramConnectionCallbacks)
    {
      zzbp.get(paramConnectionCallbacks, "Listener must not be null");
      zzfhn.add(paramConnectionCallbacks);
      return this;
    }
    
    public final Builder addOnConnectionFailedListener(GoogleApiClient.OnConnectionFailedListener paramOnConnectionFailedListener)
    {
      zzbp.get(paramOnConnectionFailedListener, "Listener must not be null");
      zzfho.add(paramOnConnectionFailedListener);
      return this;
    }
    
    public final Builder addScope(Scope paramScope)
    {
      zzbp.get(paramScope, "Scope must not be null");
      zzfhb.add(paramScope);
      return this;
    }
    
    public final GoogleApiClient build()
    {
      zzbp.get(zzfhh.isEmpty() ^ true, "must call addApi() to add at least one API");
      AccountInformation localAccountInformation = zzafr();
      Object localObject1 = null;
      Map localMap = localAccountInformation.zzajt();
      ArrayMap localArrayMap1 = new ArrayMap();
      ArrayMap localArrayMap2 = new ArrayMap();
      ArrayList localArrayList = new ArrayList();
      Iterator localIterator = zzfhh.keySet().iterator();
      int j = 0;
      boolean bool;
      while (localIterator.hasNext())
      {
        localObject2 = (Sample)localIterator.next();
        Object localObject3 = zzfhh.get(localObject2);
        if (localMap.get(localObject2) != null) {
          bool = true;
        } else {
          bool = false;
        }
        localArrayMap1.put(localObject2, Boolean.valueOf(bool));
        Object localObject4 = new ByteArrayBuffer((Sample)localObject2, bool);
        localArrayList.add(localObject4);
        Api.zza localZza = ((Sample)localObject2).zzafd();
        localObject4 = localZza.getTemplate(GoogleApiClient.this, zzakg, localAccountInformation, localObject3, (GoogleApiClient.ConnectionCallbacks)localObject4, (GoogleApiClient.OnConnectionFailedListener)localObject4);
        localArrayMap2.put(((Sample)localObject2).zzafe(), localObject4);
        i = j;
        if (localZza.getPriority() == 1) {
          if (localObject3 != null) {
            i = 1;
          } else {
            i = 0;
          }
        }
        j = i;
        if (((Api.zze)localObject4).zzaal()) {
          if (localObject1 == null)
          {
            localObject1 = localObject2;
            j = i;
          }
          else
          {
            localObject2 = ((Sample)localObject2).getName();
            localObject1 = ((Sample)localObject1).getName();
            throw new IllegalStateException(StringBuilder.append(StringBuilder.append(localObject1, StringBuilder.append(localObject2, 21)), (String)localObject2, " cannot be used with ", (String)localObject1));
          }
        }
      }
      if (localObject1 != null) {
        if (j == 0)
        {
          if (zzduz == null) {
            bool = true;
          } else {
            bool = false;
          }
          zzbp.checkState(bool, "Must not set an account in GoogleApiClient.Builder when using %s. Set account in GoogleSignInOptions.Builder instead", new Object[] { ((Sample)localObject1).getName() });
          zzbp.checkState(zzfhb.equals(zzfhc), "Must not set scopes in GoogleApiClient.Builder when using %s. Set account in GoogleSignInOptions.Builder instead.", new Object[] { ((Sample)localObject1).getName() });
        }
        else
        {
          localObject1 = ((Sample)localObject1).getName();
          throw new IllegalStateException(StringBuilder.append(StringBuilder.append(localObject1, 82), "With using ", (String)localObject1, ", GamesOptions can only be specified within GoogleSignInOptions.Builder"));
        }
      }
      int i = zzbd.transform(localArrayMap2.values(), true);
      Object localObject2 = new zzbd(GoogleApiClient.this, new ReentrantLock(), zzakg, localAccountInformation, zzfhl, zzfhm, localArrayMap1, zzfhn, zzfho, localArrayMap2, zzfhj, i, localArrayList, false);
      localObject1 = GoogleApiClient.zzfha;
      try
      {
        GoogleApiClient.zzfha.add(localObject2);
        if (zzfhj >= 0)
        {
          ActivityBase.onCreate(zzfhi).onActivityResult(zzfhj, (GoogleApiClient)localObject2, zzfhk);
          return localObject2;
        }
      }
      catch (Throwable localThrowable)
      {
        throw localThrowable;
      }
      return localThrowable;
    }
    
    public final Builder enableAutoManage(FragmentActivity paramFragmentActivity, int paramInt, GoogleApiClient.OnConnectionFailedListener paramOnConnectionFailedListener)
    {
      paramFragmentActivity = new zzcf(paramFragmentActivity);
      boolean bool;
      if (paramInt >= 0) {
        bool = true;
      } else {
        bool = false;
      }
      zzbp.get(bool, "clientId must be non-negative");
      zzfhj = paramInt;
      zzfhk = paramOnConnectionFailedListener;
      zzfhi = paramFragmentActivity;
      return this;
    }
    
    public final Builder enableAutoManage(FragmentActivity paramFragmentActivity, GoogleApiClient.OnConnectionFailedListener paramOnConnectionFailedListener)
    {
      return enableAutoManage(paramFragmentActivity, 0, paramOnConnectionFailedListener);
    }
    
    public final Builder setAccountName(String paramString)
    {
      if (paramString == null) {
        paramString = null;
      } else {
        paramString = new Account(paramString, "com.google");
      }
      zzduz = paramString;
      return this;
    }
    
    public final Builder setGravityForPopups(int paramInt)
    {
      zzfhd = paramInt;
      return this;
    }
    
    public final Builder setHandler(Handler paramHandler)
    {
      zzbp.get(paramHandler, "Handler must not be null");
      zzakg = paramHandler.getLooper();
      return this;
    }
    
    public final Builder setViewForPopups(View paramView)
    {
      zzbp.get(paramView, "View must not be null");
      zzfhe = paramView;
      return this;
    }
    
    public final Builder useDefaultAccount()
    {
      return setAccountName("<<default account>>");
    }
    
    public final AccountInformation zzafr()
    {
      com.google.android.android.internal.zzcpt localZzcpt = com.google.android.android.internal.zzcpt.zzjno;
      if (zzfhh.containsKey(zzcpp.CURSOR_POSITION)) {
        localZzcpt = (com.google.android.android.internal.zzcpt)zzfhh.get(zzcpp.CURSOR_POSITION);
      }
      return new AccountInformation(zzduz, zzfhb, zzfhg, zzfhd, zzfhe, zzdxc, zzfhf, localZzcpt);
    }
  }
  
  public abstract interface ConnectionCallbacks
  {
    public static final int CAUSE_NETWORK_LOST = 2;
    public static final int CAUSE_SERVICE_DISCONNECTED = 1;
    
    public abstract void onConnected(Bundle paramBundle);
    
    public abstract void onConnectionSuspended(int paramInt);
  }
  
  public abstract interface OnConnectionFailedListener
  {
    public abstract void onConnectionFailed(ConnectionResult paramConnectionResult);
  }
}
