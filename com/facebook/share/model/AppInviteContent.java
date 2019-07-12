package com.facebook.share.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;

public final class AppInviteContent
  implements ShareModel
{
  public static final Parcelable.Creator<AppInviteContent> CREATOR = new Parcelable.Creator()
  {
    public AppInviteContent createFromParcel(Parcel paramAnonymousParcel)
    {
      return new AppInviteContent(paramAnonymousParcel);
    }
    
    public AppInviteContent[] newArray(int paramAnonymousInt)
    {
      return new AppInviteContent[paramAnonymousInt];
    }
  };
  public final String applinkUrl;
  public final String previewImageUrl;
  
  public AppInviteContent(Parcel paramParcel)
  {
    applinkUrl = paramParcel.readString();
    previewImageUrl = paramParcel.readString();
  }
  
  public AppInviteContent(Builder paramBuilder)
  {
    applinkUrl = applinkUrl;
    previewImageUrl = previewImageUrl;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String getApplinkUrl()
  {
    return applinkUrl;
  }
  
  public String getPreviewImageUrl()
  {
    return previewImageUrl;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(applinkUrl);
    paramParcel.writeString(previewImageUrl);
  }
  
  public static class Builder
    implements ShareModelBuilder<AppInviteContent, Builder>
  {
    public String applinkUrl;
    public String previewImageUrl;
    
    public Builder() {}
    
    public AppInviteContent build()
    {
      return new AppInviteContent(this, null);
    }
    
    public Builder readFrom(Parcel paramParcel)
    {
      return readFrom((AppInviteContent)paramParcel.readParcelable(AppInviteContent.class.getClassLoader()));
    }
    
    public Builder readFrom(AppInviteContent paramAppInviteContent)
    {
      if (paramAppInviteContent == null) {
        return this;
      }
      return setApplinkUrl(paramAppInviteContent.getApplinkUrl()).setPreviewImageUrl(paramAppInviteContent.getPreviewImageUrl());
    }
    
    public Builder setApplinkUrl(String paramString)
    {
      applinkUrl = paramString;
      return this;
    }
    
    public Builder setPreviewImageUrl(String paramString)
    {
      previewImageUrl = paramString;
      return this;
    }
  }
}
