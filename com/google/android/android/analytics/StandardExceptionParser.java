package com.google.android.android.analytics;

import android.content.Context;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class StandardExceptionParser
  implements ExceptionParser
{
  public final TreeSet<String> zzdlh = new TreeSet();
  
  public StandardExceptionParser(Context paramContext, Collection paramCollection)
  {
    setIncludedPackages(paramContext, paramCollection);
  }
  
  public StackTraceElement getBestStackTraceElement(Throwable paramThrowable)
  {
    paramThrowable = paramThrowable.getStackTrace();
    if ((paramThrowable != null) && (paramThrowable.length != 0))
    {
      int j = paramThrowable.length;
      int i = 0;
      while (i < j)
      {
        StackTraceElement localStackTraceElement = paramThrowable[i];
        String str = localStackTraceElement.getClassName();
        Iterator localIterator = zzdlh.iterator();
        while (localIterator.hasNext()) {
          if (str.startsWith((String)localIterator.next())) {
            return localStackTraceElement;
          }
        }
        i += 1;
      }
      return paramThrowable[0];
    }
    return null;
  }
  
  public Throwable getCause(Throwable paramThrowable)
  {
    while (paramThrowable.getCause() != null) {
      paramThrowable = paramThrowable.getCause();
    }
    return paramThrowable;
  }
  
  public String getDescription(String paramString, Throwable paramThrowable)
  {
    return getDescription(getCause(paramThrowable), getBestStackTraceElement(getCause(paramThrowable)), paramString);
  }
  
  public String getDescription(Throwable paramThrowable, StackTraceElement paramStackTraceElement, String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramThrowable.getClass().getSimpleName());
    if (paramStackTraceElement != null)
    {
      paramThrowable = paramStackTraceElement.getClassName().split("\\.");
      if ((paramThrowable != null) && (paramThrowable.length > 0)) {
        paramThrowable = paramThrowable[(paramThrowable.length - 1)];
      } else {
        paramThrowable = "unknown";
      }
      localStringBuilder.append(String.format(" (@%s:%s:%s)", new Object[] { paramThrowable, paramStackTraceElement.getMethodName(), Integer.valueOf(paramStackTraceElement.getLineNumber()) }));
    }
    if (paramString != null) {
      localStringBuilder.append(String.format(" {%s}", new Object[] { paramString }));
    }
    return localStringBuilder.toString();
  }
  
  public void setIncludedPackages(Context paramContext, Collection paramCollection)
  {
    zzdlh.clear();
    Object localObject = new HashSet();
    if (paramCollection != null) {
      ((Set)localObject).addAll(paramCollection);
    }
    if (paramContext != null) {
      ((Set)localObject).add(paramContext.getApplicationContext().getPackageName());
    }
    paramContext = ((Set)localObject).iterator();
    while (paramContext.hasNext())
    {
      paramCollection = (String)paramContext.next();
      int i = 1;
      localObject = zzdlh.iterator();
      while (((Iterator)localObject).hasNext())
      {
        String str = (String)((Iterator)localObject).next();
        if (!paramCollection.startsWith(str))
        {
          if (!str.startsWith(paramCollection)) {
            break;
          }
          zzdlh.remove(str);
          break;
        }
        i = 0;
      }
      if (i != 0) {
        zzdlh.add(paramCollection);
      }
    }
  }
}
