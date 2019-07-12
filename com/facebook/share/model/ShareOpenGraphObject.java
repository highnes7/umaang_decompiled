package com.facebook.share.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;

public final class ShareOpenGraphObject
  extends ShareOpenGraphValueContainer<ShareOpenGraphObject, Builder>
{
  public static final Parcelable.Creator<ShareOpenGraphObject> CREATOR = new Parcelable.Creator()
  {
    public ShareOpenGraphObject createFromParcel(Parcel paramAnonymousParcel)
    {
      return new ShareOpenGraphObject(paramAnonymousParcel);
    }
    
    public ShareOpenGraphObject[] newArray(int paramAnonymousInt)
    {
      return new ShareOpenGraphObject[paramAnonymousInt];
    }
  };
  
  public ShareOpenGraphObject(Parcel paramParcel)
  {
    super(paramParcel);
  }
  
  public ShareOpenGraphObject(Builder paramBuilder)
  {
    super(paramBuilder);
  }
  
  public static final class Builder
    extends ShareOpenGraphValueContainer.Builder<ShareOpenGraphObject, Builder>
  {
    public Builder()
    {
      putBoolean("fbsdk:create_object", true);
    }
    
    public ShareOpenGraphObject build()
    {
      return new ShareOpenGraphObject(this, null);
    }
    
    public Builder readFrom(Parcel paramParcel)
    {
      return (Builder)readFrom((ShareOpenGraphObject)paramParcel.readParcelable(ShareOpenGraphObject.class.getClassLoader()));
    }
  }
}
