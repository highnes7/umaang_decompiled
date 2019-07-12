package com.github.mikephil.charting.data;

import android.os.Parcel;
import android.os.ParcelFormatException;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class Entry
  implements Parcelable
{
  public static final Parcelable.Creator<Entry> CREATOR = new Parcelable.Creator()
  {
    public Entry createFromParcel(Parcel paramAnonymousParcel)
    {
      return new Entry(paramAnonymousParcel);
    }
    
    public Entry[] newArray(int paramAnonymousInt)
    {
      return new Entry[paramAnonymousInt];
    }
  };
  public Object mData = null;
  public float mVal = 0.0F;
  public int mXIndex = 0;
  
  public Entry(float paramFloat, int paramInt)
  {
    mVal = paramFloat;
    mXIndex = paramInt;
  }
  
  public Entry(float paramFloat, int paramInt, Object paramObject)
  {
    this(paramFloat, paramInt);
    mData = paramObject;
  }
  
  public Entry(Parcel paramParcel)
  {
    mVal = paramParcel.readFloat();
    mXIndex = paramParcel.readInt();
    if (paramParcel.readInt() == 1) {
      mData = paramParcel.readParcelable(Object.class.getClassLoader());
    }
  }
  
  public Entry copy()
  {
    return new Entry(mVal, mXIndex, mData);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equalTo(Entry paramEntry)
  {
    if (paramEntry == null) {
      return false;
    }
    if (mData != mData) {
      return false;
    }
    if (mXIndex != mXIndex) {
      return false;
    }
    return Math.abs(mVal - mVal) <= 1.0E-5F;
  }
  
  public Object getData()
  {
    return mData;
  }
  
  public float getVal()
  {
    return mVal;
  }
  
  public int getXIndex()
  {
    return mXIndex;
  }
  
  public void setData(Object paramObject)
  {
    mData = paramObject;
  }
  
  public void setVal(float paramFloat)
  {
    mVal = paramFloat;
  }
  
  public void setXIndex(int paramInt)
  {
    mXIndex = paramInt;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = f.sufficientlysecure.rootcommands.util.StringBuilder.append("Entry, xIndex: ");
    localStringBuilder.append(mXIndex);
    localStringBuilder.append(" val (sum): ");
    localStringBuilder.append(getVal());
    return localStringBuilder.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeFloat(mVal);
    paramParcel.writeInt(mXIndex);
    Object localObject = mData;
    if (localObject != null)
    {
      if ((localObject instanceof Parcelable))
      {
        paramParcel.writeInt(1);
        paramParcel.writeParcelable((Parcelable)mData, paramInt);
        return;
      }
      throw new ParcelFormatException("Cannot parcel an Entry with non-parcelable data");
    }
    paramParcel.writeInt(0);
  }
}
