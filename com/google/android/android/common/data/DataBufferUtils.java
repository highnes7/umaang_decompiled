package com.google.android.android.common.data;

import android.os.Bundle;
import java.util.ArrayList;
import java.util.Iterator;

public final class DataBufferUtils
{
  public DataBufferUtils() {}
  
  public static ArrayList freezeAndClose(DataBuffer paramDataBuffer)
  {
    ArrayList localArrayList = new ArrayList(paramDataBuffer.getCount());
    try
    {
      Iterator localIterator = paramDataBuffer.iterator();
      for (;;)
      {
        boolean bool = localIterator.hasNext();
        if (!bool) {
          break;
        }
        localArrayList.add(((Freezable)localIterator.next()).freeze());
      }
      paramDataBuffer.close();
      return localArrayList;
    }
    catch (Throwable localThrowable)
    {
      paramDataBuffer.close();
      throw localThrowable;
    }
  }
  
  public static boolean hasData(DataBuffer paramDataBuffer)
  {
    return (paramDataBuffer != null) && (paramDataBuffer.getCount() > 0);
  }
  
  public static boolean hasNextPage(DataBuffer paramDataBuffer)
  {
    paramDataBuffer = paramDataBuffer.zzafi();
    return (paramDataBuffer != null) && (paramDataBuffer.getString("next_page_token") != null);
  }
  
  public static boolean hasPrevPage(DataBuffer paramDataBuffer)
  {
    paramDataBuffer = paramDataBuffer.zzafi();
    return (paramDataBuffer != null) && (paramDataBuffer.getString("prev_page_token") != null);
  }
}
