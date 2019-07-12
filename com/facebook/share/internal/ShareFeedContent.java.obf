package com.facebook.share.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.facebook.share.model.ShareContent;
import com.facebook.share.model.ShareContent.Builder;

public class ShareFeedContent
  extends ShareContent<ShareFeedContent, Builder>
{
  public static final Parcelable.Creator<ShareFeedContent> CREATOR = new Parcelable.Creator()
  {
    public ShareFeedContent createFromParcel(Parcel paramAnonymousParcel)
    {
      return new ShareFeedContent(paramAnonymousParcel);
    }
    
    public ShareFeedContent[] newArray(int paramAnonymousInt)
    {
      return new ShareFeedContent[paramAnonymousInt];
    }
  };
  public final String link;
  public final String linkCaption;
  public final String linkDescription;
  public final String linkName;
  public final String mediaSource;
  public final String picture;
  public final String toId;
  
  public ShareFeedContent(Parcel paramParcel)
  {
    super(paramParcel);
    toId = paramParcel.readString();
    link = paramParcel.readString();
    linkName = paramParcel.readString();
    linkCaption = paramParcel.readString();
    linkDescription = paramParcel.readString();
    picture = paramParcel.readString();
    mediaSource = paramParcel.readString();
  }
  
  public ShareFeedContent(Builder paramBuilder)
  {
    super(paramBuilder);
    toId = toId;
    link = link;
    linkName = linkName;
    linkCaption = linkCaption;
    linkDescription = linkDescription;
    picture = picture;
    mediaSource = mediaSource;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String getLink()
  {
    return link;
  }
  
  public String getLinkCaption()
  {
    return linkCaption;
  }
  
  public String getLinkDescription()
  {
    return linkDescription;
  }
  
  public String getLinkName()
  {
    return linkName;
  }
  
  public String getMediaSource()
  {
    return mediaSource;
  }
  
  public String getPicture()
  {
    return picture;
  }
  
  public String getToId()
  {
    return toId;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    super.writeToParcel(paramParcel, paramInt);
    paramParcel.writeString(toId);
    paramParcel.writeString(link);
    paramParcel.writeString(linkName);
    paramParcel.writeString(linkCaption);
    paramParcel.writeString(linkDescription);
    paramParcel.writeString(picture);
    paramParcel.writeString(mediaSource);
  }
  
  public static final class Builder
    extends ShareContent.Builder<ShareFeedContent, Builder>
  {
    public String link;
    public String linkCaption;
    public String linkDescription;
    public String linkName;
    public String mediaSource;
    public String picture;
    public String toId;
    
    public Builder() {}
    
    public ShareFeedContent build()
    {
      return new ShareFeedContent(this);
    }
    
    public Builder readFrom(Parcel paramParcel)
    {
      return readFrom((ShareFeedContent)paramParcel.readParcelable(ShareFeedContent.class.getClassLoader()));
    }
    
    public Builder readFrom(ShareFeedContent paramShareFeedContent)
    {
      if (paramShareFeedContent == null) {
        return this;
      }
      return ((Builder)super.readFrom(paramShareFeedContent)).setToId(paramShareFeedContent.getToId()).setLink(paramShareFeedContent.getLink()).setLinkName(paramShareFeedContent.getLinkName()).setLinkCaption(paramShareFeedContent.getLinkCaption()).setLinkDescription(paramShareFeedContent.getLinkDescription()).setPicture(paramShareFeedContent.getPicture()).setMediaSource(paramShareFeedContent.getMediaSource());
    }
    
    public Builder setLink(String paramString)
    {
      link = paramString;
      return this;
    }
    
    public Builder setLinkCaption(String paramString)
    {
      linkCaption = paramString;
      return this;
    }
    
    public Builder setLinkDescription(String paramString)
    {
      linkDescription = paramString;
      return this;
    }
    
    public Builder setLinkName(String paramString)
    {
      linkName = paramString;
      return this;
    }
    
    public Builder setMediaSource(String paramString)
    {
      mediaSource = paramString;
      return this;
    }
    
    public Builder setPicture(String paramString)
    {
      picture = paramString;
      return this;
    }
    
    public Builder setToId(String paramString)
    {
      toId = paramString;
      return this;
    }
  }
}
