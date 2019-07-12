package com.google.android.android.common.images;

import android.net.Uri;
import com.google.android.android.common.internal.zzbf;
import java.util.Arrays;

public final class BitmapLoader
{
  public final Uri uri;
  
  public BitmapLoader(Uri paramUri)
  {
    uri = paramUri;
  }
  
  public final boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof BitmapLoader)) {
      return false;
    }
    if (this == paramObject) {
      return true;
    }
    return zzbf.equal(uri, uri);
  }
  
  public final int hashCode()
  {
    return Arrays.hashCode(new Object[] { uri });
  }
}
