package com.google.android.android.internal;

import java.util.Iterator;
import java.util.NoSuchElementException;

public final class zzeul
  implements Iterator
{
  public final int limit = zzomz.size();
  public int position = 0;
  
  public zzeul(zzeuk paramZzeuk) {}
  
  private final byte nextByte()
  {
    zzeuk localZzeuk = zzomz;
    int i = position;
    position = (i + 1);
    try
    {
      byte b = localZzeuk.zzji(i);
      return b;
    }
    catch (IndexOutOfBoundsException localIndexOutOfBoundsException)
    {
      throw new NoSuchElementException(localIndexOutOfBoundsException.getMessage());
    }
  }
  
  public final boolean hasNext()
  {
    return position < limit;
  }
  
  public final void remove()
  {
    throw new UnsupportedOperationException();
  }
}
