package com.facebook.share.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;

public final class ShareOpenGraphAction
  extends ShareOpenGraphValueContainer<ShareOpenGraphAction, Builder>
{
  public static final Parcelable.Creator<ShareOpenGraphAction> CREATOR = new Parcelable.Creator()
  {
    public ShareOpenGraphAction createFromParcel(Parcel paramAnonymousParcel)
    {
      return new ShareOpenGraphAction(paramAnonymousParcel);
    }
    
    public ShareOpenGraphAction[] newArray(int paramAnonymousInt)
    {
      return new ShareOpenGraphAction[paramAnonymousInt];
    }
  };
  
  public ShareOpenGraphAction(Parcel paramParcel)
  {
    super(paramParcel);
  }
  
  public ShareOpenGraphAction(Builder paramBuilder)
  {
    super(paramBuilder);
  }
  
  public String getActionType()
  {
    return getString("og:type");
  }
  
  public static final class Builder
    extends ShareOpenGraphValueContainer.Builder<ShareOpenGraphAction, Builder>
  {
    public static final String ACTION_TYPE_KEY = "og:type";
    
    public Builder() {}
    
    public ShareOpenGraphAction build()
    {
      return new ShareOpenGraphAction(this, null);
    }
    
    public Builder readFrom(Parcel paramParcel)
    {
      return readFrom((ShareOpenGraphAction)paramParcel.readParcelable(ShareOpenGraphAction.class.getClassLoader()));
    }
    
    public Builder readFrom(ShareOpenGraphAction paramShareOpenGraphAction)
    {
      if (paramShareOpenGraphAction == null) {
        return this;
      }
      super.readFrom(paramShareOpenGraphAction);
      return ((Builder)this).setActionType(paramShareOpenGraphAction.getActionType());
    }
    
    public Builder setActionType(String paramString)
    {
      putString("og:type", paramString);
      return this;
    }
  }
}
