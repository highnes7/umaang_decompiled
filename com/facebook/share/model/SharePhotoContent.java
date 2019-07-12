package com.facebook.share.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public final class SharePhotoContent
  extends ShareContent<SharePhotoContent, Builder>
{
  public static final Parcelable.Creator<SharePhotoContent> CREATOR = new Parcelable.Creator()
  {
    public SharePhotoContent createFromParcel(Parcel paramAnonymousParcel)
    {
      return new SharePhotoContent(paramAnonymousParcel);
    }
    
    public SharePhotoContent[] newArray(int paramAnonymousInt)
    {
      return new SharePhotoContent[paramAnonymousInt];
    }
  };
  public final List<SharePhoto> photos;
  
  public SharePhotoContent(Parcel paramParcel)
  {
    super(paramParcel);
    photos = Collections.unmodifiableList(SharePhoto.Builder.readListFrom(paramParcel));
  }
  
  public SharePhotoContent(Builder paramBuilder)
  {
    super(paramBuilder);
    photos = Collections.unmodifiableList(photos);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public List getPhotos()
  {
    return photos;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    super.writeToParcel(paramParcel, paramInt);
    SharePhoto.Builder.writeListTo(paramParcel, photos);
  }
  
  public static class Builder
    extends ShareContent.Builder<SharePhotoContent, Builder>
  {
    public final List<SharePhoto> photos = new ArrayList();
    
    public Builder() {}
    
    public Builder addPhoto(SharePhoto paramSharePhoto)
    {
      if (paramSharePhoto != null) {
        photos.add(new SharePhoto.Builder().readFrom(paramSharePhoto).build());
      }
      return this;
    }
    
    public Builder addPhotos(List paramList)
    {
      if (paramList != null)
      {
        paramList = paramList.iterator();
        while (paramList.hasNext()) {
          addPhoto((SharePhoto)paramList.next());
        }
      }
      return this;
    }
    
    public SharePhotoContent build()
    {
      return new SharePhotoContent(this, null);
    }
    
    public Builder readFrom(Parcel paramParcel)
    {
      return readFrom((SharePhotoContent)paramParcel.readParcelable(SharePhotoContent.class.getClassLoader()));
    }
    
    public Builder readFrom(SharePhotoContent paramSharePhotoContent)
    {
      if (paramSharePhotoContent == null) {
        return this;
      }
      return ((Builder)super.readFrom(paramSharePhotoContent)).addPhotos(paramSharePhotoContent.getPhotos());
    }
    
    public Builder setPhotos(List paramList)
    {
      photos.clear();
      addPhotos(paramList);
      return this;
    }
  }
}
