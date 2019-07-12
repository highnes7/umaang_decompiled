package com.google.android.android.auth.dashclock.credentials;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.android.common.internal.ReflectedParcelable;
import com.google.android.android.internal.zzbck;
import com.google.android.android.internal.zzbcn;
import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public final class CredentialPickerConfig
  extends zzbck
  implements ReflectedParcelable
{
  public static final Parcelable.Creator<com.google.android.gms.auth.api.credentials.CredentialPickerConfig> CREATOR = new VerticalProgressBar.SavedState.1();
  public final boolean mShowCancelButton;
  public int zzdxs;
  public final boolean zzeah;
  @Deprecated
  public final boolean zzeai;
  public final int zzeaj;
  
  public CredentialPickerConfig(int paramInt1, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, int paramInt2)
  {
    zzdxs = paramInt1;
    zzeah = paramBoolean1;
    mShowCancelButton = paramBoolean2;
    paramBoolean1 = true;
    int i = 1;
    if (paramInt1 < 2)
    {
      zzeai = paramBoolean3;
      paramInt1 = i;
      if (paramBoolean3) {
        paramInt1 = 3;
      }
      zzeaj = paramInt1;
      return;
    }
    if (paramInt2 != 3) {
      paramBoolean1 = false;
    }
    zzeai = paramBoolean1;
    zzeaj = paramInt2;
  }
  
  public CredentialPickerConfig(Builder paramBuilder)
  {
    this(2, zzeah, mShowCancelButton, false, zzeak);
  }
  
  public final boolean isForNewAccount()
  {
    return zzeaj == 3;
  }
  
  public final boolean shouldShowAddAccountButton()
  {
    return zzeah;
  }
  
  public final boolean shouldShowCancelButton()
  {
    return mShowCancelButton;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramInt = zzbcn.writeValue(paramParcel);
    zzbcn.onAction(paramParcel, 1, shouldShowAddAccountButton());
    zzbcn.onAction(paramParcel, 2, shouldShowCancelButton());
    zzbcn.onAction(paramParcel, 3, isForNewAccount());
    zzbcn.setCustomVar(paramParcel, 4, zzeaj);
    zzbcn.setCustomVar(paramParcel, 1000, zzdxs);
    zzbcn.zzah(paramParcel, paramInt);
  }
  
  public class Builder
  {
    public boolean mShowCancelButton = true;
    public boolean zzeah = false;
    public int zzeak = 1;
    
    public Builder() {}
    
    public CredentialPickerConfig build()
    {
      return new CredentialPickerConfig(this);
    }
    
    public Builder setForNewAccount(boolean paramBoolean)
    {
      int i;
      if (paramBoolean) {
        i = 3;
      } else {
        i = 1;
      }
      zzeak = i;
      return this;
    }
    
    public Builder setPrompt(int paramInt)
    {
      zzeak = paramInt;
      return this;
    }
    
    public Builder setShowAddAccountButton(boolean paramBoolean)
    {
      zzeah = paramBoolean;
      return this;
    }
    
    public Builder setShowCancelButton(boolean paramBoolean)
    {
      mShowCancelButton = paramBoolean;
      return this;
    }
  }
  
  @Retention(RetentionPolicy.SOURCE)
  public @interface Prompt
  {
    public static final int CONTINUE = 1;
    public static final int SIGN_IN = 2;
    public static final int SIGN_UP = 3;
  }
}
