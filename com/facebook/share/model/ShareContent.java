package com.facebook.share.model;

import android.net.Uri;
import android.os.Parcel;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public abstract class ShareContent<P extends ShareContent, E extends Builder>
  implements ShareModel
{
  public final Uri contentUrl;
  public final String locationId;
  public final List<String> peopleIds;
  public final String placeId;
  
  public ShareContent(Parcel paramParcel)
  {
    contentUrl = ((Uri)paramParcel.readParcelable(Uri.class.getClassLoader()));
    peopleIds = readUnmodifiableStringList(paramParcel);
    placeId = paramParcel.readString();
    locationId = paramParcel.readString();
  }
  
  public ShareContent(Builder paramBuilder)
  {
    contentUrl = contentUrl;
    peopleIds = peopleIds;
    placeId = placeId;
    locationId = Text;
  }
  
  private List readUnmodifiableStringList(Parcel paramParcel)
  {
    ArrayList localArrayList = new ArrayList();
    paramParcel.readStringList(localArrayList);
    if (localArrayList.size() == 0) {
      return null;
    }
    return Collections.unmodifiableList(localArrayList);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public Uri getContentUrl()
  {
    return contentUrl;
  }
  
  public List getPeopleIds()
  {
    return peopleIds;
  }
  
  public String getPlaceId()
  {
    return placeId;
  }
  
  public String getRef()
  {
    return locationId;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeParcelable(contentUrl, 0);
    paramParcel.writeStringList(peopleIds);
    paramParcel.writeString(placeId);
    paramParcel.writeString(locationId);
  }
  
  public static abstract class Builder<P extends ShareContent, E extends Builder>
    implements ShareModelBuilder<P, E>
  {
    public String Text;
    public Uri contentUrl;
    public List<String> peopleIds;
    public String placeId;
    
    public Builder() {}
    
    public Builder readFrom(ShareContent paramShareContent)
    {
      if (paramShareContent == null) {
        return this;
      }
      return setContentUrl(paramShareContent.getContentUrl()).setPeopleIds(paramShareContent.getPeopleIds()).setPlaceId(paramShareContent.getPlaceId()).setRef(paramShareContent.getRef());
    }
    
    public Builder setContentUrl(Uri paramUri)
    {
      contentUrl = paramUri;
      return this;
    }
    
    public Builder setPeopleIds(List paramList)
    {
      if (paramList == null) {
        paramList = null;
      } else {
        paramList = Collections.unmodifiableList(paramList);
      }
      peopleIds = paramList;
      return this;
    }
    
    public Builder setPlaceId(String paramString)
    {
      placeId = paramString;
      return this;
    }
    
    public Builder setRef(String paramString)
    {
      Text = paramString;
      return this;
    }
  }
}
