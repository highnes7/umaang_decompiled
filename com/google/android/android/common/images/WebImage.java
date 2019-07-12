package com.google.android.android.common.images;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.android.common.internal.zzbf;
import com.google.android.android.internal.zzbck;
import com.google.android.android.internal.zzbcn;
import java.util.Arrays;
import java.util.Locale;
import org.json.JSONException;
import org.json.JSONObject;

public final class WebImage
  extends zzbck
{
  public static final Parcelable.Creator<com.google.android.gms.common.images.WebImage> CREATOR = new VerticalProgressBar.SavedState.1();
  public final int zzakq;
  public final int zzakr;
  public int zzdxs;
  public final Uri zzeuy;
  
  public WebImage(int paramInt1, Uri paramUri, int paramInt2, int paramInt3)
  {
    zzdxs = paramInt1;
    zzeuy = paramUri;
    zzakq = paramInt2;
    zzakr = paramInt3;
  }
  
  public WebImage(Uri paramUri)
    throws IllegalArgumentException
  {
    this(paramUri, 0, 0);
  }
  
  public WebImage(Uri paramUri, int paramInt1, int paramInt2)
    throws IllegalArgumentException
  {
    this(1, paramUri, paramInt1, paramInt2);
    if (paramUri != null)
    {
      if ((paramInt1 >= 0) && (paramInt2 >= 0)) {
        return;
      }
      throw new IllegalArgumentException("width and height must not be negative");
    }
    throw new IllegalArgumentException("url cannot be null");
  }
  
  public WebImage(JSONObject paramJSONObject)
    throws IllegalArgumentException
  {
    this(fromJson(paramJSONObject), paramJSONObject.optInt("width", 0), paramJSONObject.optInt("height", 0));
  }
  
  public static Uri fromJson(JSONObject paramJSONObject)
  {
    if (paramJSONObject.has("url")) {}
    try
    {
      paramJSONObject = Uri.parse(paramJSONObject.getString("url"));
      return paramJSONObject;
    }
    catch (JSONException paramJSONObject)
    {
      for (;;) {}
    }
    return null;
  }
  
  public final boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if (paramObject != null)
    {
      if (!(paramObject instanceof WebImage)) {
        return false;
      }
      paramObject = (WebImage)paramObject;
      if ((zzbf.equal(zzeuy, zzeuy)) && (zzakq == zzakq) && (zzakr == zzakr)) {
        return true;
      }
    }
    return false;
  }
  
  public final int getHeight()
  {
    return zzakr;
  }
  
  public final Uri getUrl()
  {
    return zzeuy;
  }
  
  public final int getWidth()
  {
    return zzakq;
  }
  
  public final int hashCode()
  {
    return Arrays.hashCode(new Object[] { zzeuy, Integer.valueOf(zzakq), Integer.valueOf(zzakr) });
  }
  
  public final JSONObject toJson()
  {
    JSONObject localJSONObject = new JSONObject();
    Uri localUri = zzeuy;
    try
    {
      localJSONObject.put("url", localUri.toString());
      int i = zzakq;
      localJSONObject.get("width", i);
      i = zzakr;
      localJSONObject.get("height", i);
      return localJSONObject;
    }
    catch (JSONException localJSONException) {}
    return localJSONObject;
  }
  
  public final String toString()
  {
    return String.format(Locale.US, "Image %dx%d %s", new Object[] { Integer.valueOf(zzakq), Integer.valueOf(zzakr), zzeuy.toString() });
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = zzbcn.writeValue(paramParcel);
    zzbcn.setCustomVar(paramParcel, 1, zzdxs);
    zzbcn.addMenuItem(paramParcel, 2, getUrl(), paramInt, false);
    zzbcn.setCustomVar(paramParcel, 3, getWidth());
    zzbcn.setCustomVar(paramParcel, 4, getHeight());
    zzbcn.zzah(paramParcel, i);
  }
}
