package com.google.android.android.auth.dashclock.credentials;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import b.b.a.G;
import com.google.android.android.common.internal.zzbp;
import com.google.android.android.internal.zzbck;
import com.google.android.android.internal.zzbcn;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public final class CredentialRequest
  extends zzbck
{
  public static final Parcelable.Creator<com.google.android.gms.auth.api.credentials.CredentialRequest> CREATOR = new DiscreteSeekBar.CustomState.1();
  public int zzdxs;
  public final boolean zzeal;
  public final String[] zzeam;
  public final CredentialPickerConfig zzean;
  public final CredentialPickerConfig zzeao;
  public final boolean zzeap;
  public final String zzeaq;
  public final String zzear;
  public final boolean zzeas;
  
  public CredentialRequest(int paramInt, boolean paramBoolean1, String[] paramArrayOfString, CredentialPickerConfig paramCredentialPickerConfig1, CredentialPickerConfig paramCredentialPickerConfig2, boolean paramBoolean2, String paramString1, String paramString2, boolean paramBoolean3)
  {
    zzdxs = paramInt;
    zzeal = paramBoolean1;
    zzbp.append(paramArrayOfString);
    zzeam = ((String[])paramArrayOfString);
    paramArrayOfString = paramCredentialPickerConfig1;
    if (paramCredentialPickerConfig1 == null) {
      paramArrayOfString = new CredentialPickerConfig.Builder().build();
    }
    zzean = paramArrayOfString;
    paramArrayOfString = paramCredentialPickerConfig2;
    if (paramCredentialPickerConfig2 == null) {
      paramArrayOfString = new CredentialPickerConfig.Builder().build();
    }
    zzeao = paramArrayOfString;
    if (paramInt < 3)
    {
      zzeap = true;
      zzeaq = null;
      zzear = null;
    }
    else
    {
      zzeap = paramBoolean2;
      zzeaq = paramString1;
      zzear = paramString2;
    }
    zzeas = paramBoolean3;
  }
  
  public CredentialRequest(Builder paramBuilder)
  {
    this(4, zzeal, zzeam, zzean, zzeao, zzeap, zzeaq, zzear, false);
  }
  
  public final String[] getAccountTypes()
  {
    return zzeam;
  }
  
  public final Set getAccountTypesSet()
  {
    return new HashSet(Arrays.asList(zzeam));
  }
  
  public final CredentialPickerConfig getCredentialHintPickerConfig()
  {
    return zzeao;
  }
  
  public final CredentialPickerConfig getCredentialPickerConfig()
  {
    return zzean;
  }
  
  public final String getIdTokenNonce()
  {
    return zzear;
  }
  
  public final String getServerClientId()
  {
    return zzeaq;
  }
  
  public final boolean getSupportsPasswordLogin()
  {
    return isPasswordLoginSupported();
  }
  
  public final boolean isIdTokenRequested()
  {
    return zzeap;
  }
  
  public final boolean isPasswordLoginSupported()
  {
    return zzeal;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = zzbcn.writeValue(paramParcel);
    zzbcn.onAction(paramParcel, 1, isPasswordLoginSupported());
    zzbcn.a(paramParcel, 2, getAccountTypes(), false);
    zzbcn.addMenuItem(paramParcel, 3, getCredentialPickerConfig(), paramInt, false);
    zzbcn.addMenuItem(paramParcel, 4, getCredentialHintPickerConfig(), paramInt, false);
    zzbcn.onAction(paramParcel, 5, isIdTokenRequested());
    zzbcn.append(paramParcel, 6, getServerClientId(), false);
    zzbcn.append(paramParcel, 7, getIdTokenNonce(), false);
    zzbcn.setCustomVar(paramParcel, 1000, zzdxs);
    zzbcn.onAction(paramParcel, 8, zzeas);
    zzbcn.zzah(paramParcel, i);
  }
  
  public final class Builder
  {
    public boolean zzeal;
    public String[] zzeam;
    public CredentialPickerConfig zzean;
    public CredentialPickerConfig zzeao;
    public boolean zzeap = false;
    @G
    public String zzeaq = null;
    @G
    public String zzear;
    public boolean zzeas = false;
    
    public Builder() {}
    
    public final CredentialRequest build()
    {
      if (zzeam == null) {
        zzeam = new String[0];
      }
      if ((!zzeal) && (zzeam.length == 0)) {
        throw new IllegalStateException("At least one authentication method must be specified");
      }
      return new CredentialRequest(this);
    }
    
    public final Builder setAccountTypes(String... paramVarArgs)
    {
      String[] arrayOfString = paramVarArgs;
      if (paramVarArgs == null) {
        arrayOfString = new String[0];
      }
      zzeam = arrayOfString;
      return this;
    }
    
    public final Builder setCredentialHintPickerConfig(CredentialPickerConfig paramCredentialPickerConfig)
    {
      zzeao = paramCredentialPickerConfig;
      return this;
    }
    
    public final Builder setCredentialPickerConfig(CredentialPickerConfig paramCredentialPickerConfig)
    {
      zzean = paramCredentialPickerConfig;
      return this;
    }
    
    public final Builder setIdTokenNonce(String paramString)
    {
      zzear = paramString;
      return this;
    }
    
    public final Builder setIdTokenRequested(boolean paramBoolean)
    {
      zzeap = paramBoolean;
      return this;
    }
    
    public final Builder setPasswordLoginSupported(boolean paramBoolean)
    {
      zzeal = paramBoolean;
      return this;
    }
    
    public final Builder setServerClientId(String paramString)
    {
      zzeaq = paramString;
      return this;
    }
    
    public final Builder setSupportsPasswordLogin(boolean paramBoolean)
    {
      return setPasswordLoginSupported(paramBoolean);
    }
  }
}
