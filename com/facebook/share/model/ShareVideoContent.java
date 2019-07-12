package com.facebook.share.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;

public final class ShareVideoContent
  extends ShareContent<ShareVideoContent, Builder>
  implements ShareModel
{
  public static final Parcelable.Creator<ShareVideoContent> CREATOR = new Parcelable.Creator()
  {
    public ShareVideoContent createFromParcel(Parcel paramAnonymousParcel)
    {
      return new ShareVideoContent(paramAnonymousParcel);
    }
    
    public ShareVideoContent[] newArray(int paramAnonymousInt)
    {
      return new ShareVideoContent[paramAnonymousInt];
    }
  };
  public final String contentDescription;
  public final String contentTitle;
  public final SharePhoto previewPhoto;
  public final ShareVideo video;
  
  public ShareVideoContent(Parcel paramParcel)
  {
    super(paramParcel);
    contentDescription = paramParcel.readString();
    contentTitle = paramParcel.readString();
    SharePhoto.Builder localBuilder = new SharePhoto.Builder().readFrom(paramParcel);
    if ((localBuilder.getImageUrl() == null) && (localBuilder.getBitmap() == null)) {
      previewPhoto = null;
    } else {
      previewPhoto = localBuilder.build();
    }
    video = new ShareVideo.Builder().readFrom(paramParcel).build();
  }
  
  public ShareVideoContent(Builder paramBuilder)
  {
    super(paramBuilder);
    contentDescription = contentDescription;
    contentTitle = contentTitle;
    previewPhoto = previewPhoto;
    video = video;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String getContentDescription()
  {
    return contentDescription;
  }
  
  public String getContentTitle()
  {
    return contentTitle;
  }
  
  public SharePhoto getPreviewPhoto()
  {
    return previewPhoto;
  }
  
  public ShareVideo getVideo()
  {
    return video;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    super.writeToParcel(paramParcel, paramInt);
    paramParcel.writeString(contentDescription);
    paramParcel.writeString(contentTitle);
    paramParcel.writeParcelable(previewPhoto, 0);
    paramParcel.writeParcelable(video, 0);
  }
  
  public static final class Builder
    extends ShareContent.Builder<ShareVideoContent, Builder>
  {
    public String contentDescription;
    public String contentTitle;
    public SharePhoto previewPhoto;
    public ShareVideo video;
    
    public Builder() {}
    
    public ShareVideoContent build()
    {
      return new ShareVideoContent(this);
    }
    
    public Builder readFrom(Parcel paramParcel)
    {
      return readFrom((ShareVideoContent)paramParcel.readParcelable(ShareVideoContent.class.getClassLoader()));
    }
    
    public Builder readFrom(ShareVideoContent paramShareVideoContent)
    {
      if (paramShareVideoContent == null) {
        return this;
      }
      return ((Builder)super.readFrom(paramShareVideoContent)).setContentDescription(paramShareVideoContent.getContentDescription()).setContentTitle(paramShareVideoContent.getContentTitle()).setPreviewPhoto(paramShareVideoContent.getPreviewPhoto()).setVideo(paramShareVideoContent.getVideo());
    }
    
    public Builder setContentDescription(String paramString)
    {
      contentDescription = paramString;
      return this;
    }
    
    public Builder setContentTitle(String paramString)
    {
      contentTitle = paramString;
      return this;
    }
    
    public Builder setPreviewPhoto(SharePhoto paramSharePhoto)
    {
      if (paramSharePhoto == null) {
        paramSharePhoto = null;
      } else {
        paramSharePhoto = new SharePhoto.Builder().readFrom(paramSharePhoto).build();
      }
      previewPhoto = paramSharePhoto;
      return this;
    }
    
    public Builder setVideo(ShareVideo paramShareVideo)
    {
      if (paramShareVideo == null) {
        return this;
      }
      video = new ShareVideo.Builder().readFrom(paramShareVideo).build();
      return this;
    }
  }
}
