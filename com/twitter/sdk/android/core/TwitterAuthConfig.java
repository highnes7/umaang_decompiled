package com.twitter.sdk.android.core;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import f.u.a.a.a.r;

public class TwitterAuthConfig
  implements Parcelable
{
  public static final Parcelable.Creator<TwitterAuthConfig> CREATOR = (Parcelable.Creator)new r();
  public static final int KEYCODE_F10 = 140;
  public final String mModuleName;
  public final String mModulePackage;
  
  public TwitterAuthConfig(Parcel paramParcel)
  {
    mModulePackage = paramParcel.readString();
    mModuleName = paramParcel.readString();
  }
  
  public TwitterAuthConfig(String paramString1, String paramString2)
  {
    if ((paramString1 != null) && (paramString2 != null))
    {
      mModulePackage = readString(paramString1);
      mModuleName = readString(paramString2);
      return;
    }
    throw new IllegalArgumentException("TwitterAuthConfig must not be created with null consumer key or secret.");
  }
  
  public static String readString(String paramString)
  {
    if (paramString != null) {
      return paramString.trim();
    }
    return null;
  }
  
  public int convert()
  {
    return 140;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String getModuleName()
  {
    return mModuleName;
  }
  
  public String getModulePackage()
  {
    return mModulePackage;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(mModulePackage);
    paramParcel.writeString(mModuleName);
  }
}
