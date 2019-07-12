package com.facebook.share.model;

import android.os.Bundle;
import android.os.Parcel;

public abstract class ShareMedia
  implements ShareModel
{
  public final Bundle params;
  
  public ShareMedia(Parcel paramParcel)
  {
    params = paramParcel.readBundle();
  }
  
  public ShareMedia(Builder paramBuilder)
  {
    params = new Bundle(params);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public Bundle getParameters()
  {
    return new Bundle(params);
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeBundle(params);
  }
  
  public static abstract class Builder<M extends ShareMedia, B extends Builder>
    implements ShareModelBuilder<M, B>
  {
    public Bundle params = new Bundle();
    
    public Builder() {}
    
    public Builder readFrom(ShareMedia paramShareMedia)
    {
      if (paramShareMedia == null) {
        return this;
      }
      return setParameters(paramShareMedia.getParameters());
    }
    
    public Builder setParameter(String paramString1, String paramString2)
    {
      params.putString(paramString1, paramString2);
      return this;
    }
    
    public Builder setParameters(Bundle paramBundle)
    {
      params.putAll(paramBundle);
      return this;
    }
  }
}
