package com.google.android.android.auth.dashclock.credentials;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.android.common.internal.ReflectedParcelable;
import com.google.android.android.common.internal.zzbp;
import com.google.android.android.internal.zzbck;
import com.google.android.android.internal.zzbcn;

public final class HintRequest
  extends zzbck
  implements ReflectedParcelable
{
  public static final Parcelable.Creator<com.google.android.gms.auth.api.credentials.HintRequest> CREATOR = new PaymentIntent.Output.1();
  public int zzdxs;
  public final String[] zzeam;
  public final boolean zzeap;
  public final String zzeaq;
  public final String zzear;
  public final CredentialPickerConfig zzeat;
  public final boolean zzeau;
  public final boolean zzeav;
  
  public HintRequest(int paramInt, CredentialPickerConfig paramCredentialPickerConfig, boolean paramBoolean1, boolean paramBoolean2, String[] paramArrayOfString, boolean paramBoolean3, String paramString1, String paramString2)
  {
    zzdxs = paramInt;
    zzbp.append(paramCredentialPickerConfig);
    zzeat = ((CredentialPickerConfig)paramCredentialPickerConfig);
    zzeau = paramBoolean1;
    zzeav = paramBoolean2;
    zzbp.append(paramArrayOfString);
    zzeam = ((String[])paramArrayOfString);
    if (zzdxs < 2)
    {
      zzeap = true;
      zzeaq = null;
      zzear = null;
      return;
    }
    zzeap = paramBoolean3;
    zzeaq = paramString1;
    zzear = paramString2;
  }
  
  public HintRequest(Builder paramBuilder)
  {
    this(2, zzeat, zzeau, zzeav, zzeam, zzeap, zzeaq, zzear);
  }
  
  public final String[] getAccountTypes()
  {
    return zzeam;
  }
  
  public final CredentialPickerConfig getHintPickerConfig()
  {
    return zzeat;
  }
  
  public final String getIdTokenNonce()
  {
    return zzear;
  }
  
  public final String getServerClientId()
  {
    return zzeaq;
  }
  
  public final boolean isEmailAddressIdentifierSupported()
  {
    return zzeau;
  }
  
  public final boolean isIdTokenRequested()
  {
    return zzeap;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = zzbcn.writeValue(paramParcel);
    zzbcn.addMenuItem(paramParcel, 1, getHintPickerConfig(), paramInt, false);
    zzbcn.onAction(paramParcel, 2, isEmailAddressIdentifierSupported());
    zzbcn.onAction(paramParcel, 3, zzeav);
    zzbcn.a(paramParcel, 4, getAccountTypes(), false);
    zzbcn.onAction(paramParcel, 5, isIdTokenRequested());
    zzbcn.append(paramParcel, 6, getServerClientId(), false);
    zzbcn.append(paramParcel, 7, getIdTokenNonce(), false);
    zzbcn.setCustomVar(paramParcel, 1000, zzdxs);
    zzbcn.zzah(paramParcel, i);
  }
  
  public final class Builder
  {
    public String[] zzeam;
    public boolean zzeap = false;
    public String zzeaq;
    public String zzear;
    public CredentialPickerConfig zzeat = new CredentialPickerConfig.Builder().build();
    public boolean zzeau;
    public boolean zzeav;
    
    public Builder() {}
    
    public final HintRequest build()
    {
      if (zzeam == null) {
        zzeam = new String[0];
      }
      if ((!zzeau) && (!zzeav) && (zzeam.length == 0)) {
        throw new IllegalStateException("At least one authentication method must be specified");
      }
      return new HintRequest(this);
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
    
    public final Builder setEmailAddressIdentifierSupported(boolean paramBoolean)
    {
      zzeau = paramBoolean;
      return this;
    }
    
    public final Builder setHintPickerConfig(CredentialPickerConfig paramCredentialPickerConfig)
    {
      zzbp.append(paramCredentialPickerConfig);
      zzeat = ((CredentialPickerConfig)paramCredentialPickerConfig);
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
    
    public final Builder setPhoneNumberIdentifierSupported(boolean paramBoolean)
    {
      zzeav = paramBoolean;
      return this;
    }
    
    public final Builder setServerClientId(String paramString)
    {
      zzeaq = paramString;
      return this;
    }
  }
}
