package com.facebook.share.model;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;

public abstract class ShareOpenGraphValueContainer<P extends ShareOpenGraphValueContainer, E extends Builder>
  implements ShareModel
{
  public final Bundle bundle;
  
  public ShareOpenGraphValueContainer(Parcel paramParcel)
  {
    bundle = paramParcel.readBundle(Builder.class.getClassLoader());
  }
  
  public ShareOpenGraphValueContainer(Builder paramBuilder)
  {
    bundle = ((Bundle)bundle.clone());
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean getBoolean(String paramString, boolean paramBoolean)
  {
    return bundle.getBoolean(paramString, paramBoolean);
  }
  
  public boolean[] getBooleanArray(String paramString)
  {
    return bundle.getBooleanArray(paramString);
  }
  
  public Bundle getBundle()
  {
    return (Bundle)bundle.clone();
  }
  
  public double getDouble(String paramString, double paramDouble)
  {
    return bundle.getDouble(paramString, paramDouble);
  }
  
  public double[] getDoubleArray(String paramString)
  {
    return bundle.getDoubleArray(paramString);
  }
  
  public int getInt(String paramString, int paramInt)
  {
    return bundle.getInt(paramString, paramInt);
  }
  
  public int[] getIntArray(String paramString)
  {
    return bundle.getIntArray(paramString);
  }
  
  public long getLong(String paramString, long paramLong)
  {
    return bundle.getLong(paramString, paramLong);
  }
  
  public long[] getLongArray(String paramString)
  {
    return bundle.getLongArray(paramString);
  }
  
  public ShareOpenGraphObject getObject(String paramString)
  {
    paramString = bundle.get(paramString);
    if ((paramString instanceof ShareOpenGraphObject)) {
      return (ShareOpenGraphObject)paramString;
    }
    return null;
  }
  
  public ArrayList getObjectArrayList(String paramString)
  {
    Object localObject = bundle.getParcelableArrayList(paramString);
    if (localObject == null) {
      return null;
    }
    paramString = new ArrayList();
    localObject = ((ArrayList)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      Parcelable localParcelable = (Parcelable)((Iterator)localObject).next();
      if ((localParcelable instanceof ShareOpenGraphObject)) {
        paramString.add((ShareOpenGraphObject)localParcelable);
      }
    }
    return paramString;
  }
  
  public SharePhoto getPhoto(String paramString)
  {
    paramString = bundle.getParcelable(paramString);
    if ((paramString instanceof SharePhoto)) {
      return (SharePhoto)paramString;
    }
    return null;
  }
  
  public ArrayList getPhotoArrayList(String paramString)
  {
    Object localObject = bundle.getParcelableArrayList(paramString);
    if (localObject == null) {
      return null;
    }
    paramString = new ArrayList();
    localObject = ((ArrayList)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      Parcelable localParcelable = (Parcelable)((Iterator)localObject).next();
      if ((localParcelable instanceof SharePhoto)) {
        paramString.add((SharePhoto)localParcelable);
      }
    }
    return paramString;
  }
  
  public Object getProperty(String paramString)
  {
    return bundle.get(paramString);
  }
  
  public String getString(String paramString)
  {
    return bundle.getString(paramString);
  }
  
  public ArrayList getStringArrayList(String paramString)
  {
    return bundle.getStringArrayList(paramString);
  }
  
  public Set keySet()
  {
    return bundle.keySet();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeBundle(bundle);
  }
  
  public static abstract class Builder<P extends ShareOpenGraphValueContainer, E extends Builder>
    implements ShareModelBuilder<P, E>
  {
    public Bundle bundle = new Bundle();
    
    public Builder() {}
    
    public Builder putBoolean(String paramString, boolean paramBoolean)
    {
      bundle.putBoolean(paramString, paramBoolean);
      return this;
    }
    
    public Builder putBooleanArray(String paramString, boolean[] paramArrayOfBoolean)
    {
      bundle.putBooleanArray(paramString, paramArrayOfBoolean);
      return this;
    }
    
    public Builder putDouble(String paramString, double paramDouble)
    {
      bundle.putDouble(paramString, paramDouble);
      return this;
    }
    
    public Builder putDoubleArray(String paramString, double[] paramArrayOfDouble)
    {
      bundle.putDoubleArray(paramString, paramArrayOfDouble);
      return this;
    }
    
    public Builder putInt(String paramString, int paramInt)
    {
      bundle.putInt(paramString, paramInt);
      return this;
    }
    
    public Builder putIntArray(String paramString, int[] paramArrayOfInt)
    {
      bundle.putIntArray(paramString, paramArrayOfInt);
      return this;
    }
    
    public Builder putLong(String paramString, long paramLong)
    {
      bundle.putLong(paramString, paramLong);
      return this;
    }
    
    public Builder putLongArray(String paramString, long[] paramArrayOfLong)
    {
      bundle.putLongArray(paramString, paramArrayOfLong);
      return this;
    }
    
    public Builder putObject(String paramString, ShareOpenGraphObject paramShareOpenGraphObject)
    {
      bundle.putParcelable(paramString, paramShareOpenGraphObject);
      return this;
    }
    
    public Builder putObjectArrayList(String paramString, ArrayList paramArrayList)
    {
      bundle.putParcelableArrayList(paramString, paramArrayList);
      return this;
    }
    
    public Builder putPhoto(String paramString, SharePhoto paramSharePhoto)
    {
      bundle.putParcelable(paramString, paramSharePhoto);
      return this;
    }
    
    public Builder putPhotoArrayList(String paramString, ArrayList paramArrayList)
    {
      bundle.putParcelableArrayList(paramString, paramArrayList);
      return this;
    }
    
    public Builder putString(String paramString1, String paramString2)
    {
      bundle.putString(paramString1, paramString2);
      return this;
    }
    
    public Builder putStringArrayList(String paramString, ArrayList paramArrayList)
    {
      bundle.putStringArrayList(paramString, paramArrayList);
      return this;
    }
    
    public Builder readFrom(ShareOpenGraphValueContainer paramShareOpenGraphValueContainer)
    {
      if (paramShareOpenGraphValueContainer != null) {
        bundle.putAll(paramShareOpenGraphValueContainer.getBundle());
      }
      return this;
    }
  }
}
