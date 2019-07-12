package com.facebook.share.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.facebook.share.model.ShareModel;
import com.facebook.share.model.ShareModelBuilder;

public class LikeContent
  implements ShareModel
{
  public static final Parcelable.Creator<LikeContent> CREATOR = new Parcelable.Creator()
  {
    public LikeContent createFromParcel(Parcel paramAnonymousParcel)
    {
      return new LikeContent(paramAnonymousParcel);
    }
    
    public LikeContent[] newArray(int paramAnonymousInt)
    {
      return new LikeContent[paramAnonymousInt];
    }
  };
  public final String objectId;
  public final String objectType;
  
  public LikeContent(Parcel paramParcel)
  {
    objectId = paramParcel.readString();
    objectType = paramParcel.readString();
  }
  
  public LikeContent(Builder paramBuilder)
  {
    objectId = objectId;
    objectType = objectType;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String getObjectId()
  {
    return objectId;
  }
  
  public String getObjectType()
  {
    return objectType;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(objectId);
    paramParcel.writeString(objectType);
  }
  
  public static class Builder
    implements ShareModelBuilder<LikeContent, Builder>
  {
    public String objectId;
    public String objectType;
    
    public Builder() {}
    
    public LikeContent build()
    {
      return new LikeContent(this, null);
    }
    
    public Builder readFrom(Parcel paramParcel)
    {
      return readFrom((LikeContent)paramParcel.readParcelable(LikeContent.class.getClassLoader()));
    }
    
    public Builder readFrom(LikeContent paramLikeContent)
    {
      if (paramLikeContent == null) {
        return this;
      }
      return setObjectId(paramLikeContent.getObjectId()).setObjectType(paramLikeContent.getObjectType());
    }
    
    public Builder setObjectId(String paramString)
    {
      objectId = paramString;
      return this;
    }
    
    public Builder setObjectType(String paramString)
    {
      objectType = paramString;
      return this;
    }
  }
}
