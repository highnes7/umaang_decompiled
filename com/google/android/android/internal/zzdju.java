package com.google.android.android.internal;

import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;

public final class zzdju
  extends zzdjr
{
  public final zzdjs zzlic = new zzdjs();
  
  public zzdju() {}
  
  public final void printStackTrace(Throwable paramThrowable)
  {
    paramThrowable.printStackTrace();
    paramThrowable = zzlic.get(paramThrowable, false);
    if (paramThrowable == null) {
      return;
    }
    try
    {
      Iterator localIterator = paramThrowable.iterator();
      while (localIterator.hasNext())
      {
        Throwable localThrowable2 = (Throwable)localIterator.next();
        System.err.print("Suppressed: ");
        localThrowable2.printStackTrace();
      }
      return;
    }
    catch (Throwable localThrowable1)
    {
      throw localThrowable1;
    }
  }
  
  public final void printStackTrace(Throwable paramThrowable, PrintStream paramPrintStream)
  {
    paramThrowable.printStackTrace(paramPrintStream);
    paramThrowable = zzlic.get(paramThrowable, false);
    if (paramThrowable == null) {
      return;
    }
    try
    {
      Iterator localIterator = paramThrowable.iterator();
      while (localIterator.hasNext())
      {
        Throwable localThrowable = (Throwable)localIterator.next();
        paramPrintStream.print("Suppressed: ");
        localThrowable.printStackTrace(paramPrintStream);
      }
      return;
    }
    catch (Throwable paramPrintStream)
    {
      throw paramPrintStream;
    }
  }
  
  public final void printStackTrace(Throwable paramThrowable, PrintWriter paramPrintWriter)
  {
    paramThrowable.printStackTrace(paramPrintWriter);
    paramThrowable = zzlic.get(paramThrowable, false);
    if (paramThrowable == null) {
      return;
    }
    try
    {
      Iterator localIterator = paramThrowable.iterator();
      while (localIterator.hasNext())
      {
        Throwable localThrowable = (Throwable)localIterator.next();
        paramPrintWriter.print("Suppressed: ");
        localThrowable.printStackTrace(paramPrintWriter);
      }
      return;
    }
    catch (Throwable paramPrintWriter)
    {
      throw paramPrintWriter;
    }
  }
}
