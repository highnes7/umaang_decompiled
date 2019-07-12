package com.facebook.share.model;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;

public final class ShareLinkContent
  extends ShareContent<ShareLinkContent, Builder>
{
  public static final Parcelable.Creator<ShareLinkContent> CREATOR = new Parcelable.Creator()
  {
    public ShareLinkContent createFromParcel(Parcel paramAnonymousParcel)
    {
      return new ShareLinkContent(paramAnonymousParcel);
    }
    
    public ShareLinkContent[] newArray(int paramAnonymousInt)
    {
      return new ShareLinkContent[paramAnonymousInt];
    }
  };
  public final String contentDescription;
  public final String contentTitle;
  public final Uri imageUrl;
  
  public ShareLinkContent(Parcel paramParcel)
  {
    super(paramParcel);
    contentDescription = paramParcel.readString();
    contentTitle = paramParcel.readString();
    imageUrl = ((Uri)paramParcel.readParcelable(Uri.class.getClassLoader()));
  }
  
  public ShareLinkContent(Builder paramBuilder)
  {
    super(paramBuilder);
    contentDescription = contentDescription;
    contentTitle = contentTitle;
    imageUrl = imageUrl;
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
  
  public Uri getImageUrl()
  {
    return imageUrl;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    super.writeToParcel(paramParcel, paramInt);
    paramParcel.writeString(contentDescription);
    paramParcel.writeString(contentTitle);
    paramParcel.writeParcelable(imageUrl, 0);
  }
  
  public static final class Builder
    extends ShareContent.Builder<ShareLinkContent, Builder>
  {
    public String contentDescription;
    public String contentTitle;
    public Uri imageUrl;
    
    public Builder() {}
    
    public ShareLinkContent build()
    {
      return new ShareLinkContent(this);
    }
    
    public Builder readFrom(Parcel paramParcel)
    {
      return readFrom((ShareLinkContent)paramParcel.readParcelable(ShareLinkContent.class.getClassLoader()));
    }
    
    public Builder readFrom(ShareLinkContent paramShareLinkContent)
    {
      if (paramShareLinkContent == null) {
        return this;
      }
      return ((Builder)super.readFrom(paramShareLinkContent)).setContentDescription(paramShareLinkContent.getContentDescription()).setImageUrl(paramShareLinkContent.getImageUrl()).setContentTitle(paramShareLinkContent.getContentTitle());
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
    
    public Builder setImageUrl(Uri paramUri)
    {
      imageUrl = paramUri;
      return this;
    }
  }
}
