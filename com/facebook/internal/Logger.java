package com.facebook.internal;

import android.util.Log;
import com.facebook.FacebookSdk;
import com.facebook.LoggingBehavior;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

public class Logger
{
  public static final String LOG_TAG_BASE = "FacebookSDK.";
  public static final HashMap<String, String> stringsToReplace = new HashMap();
  public final LoggingBehavior behavior;
  public StringBuilder contents;
  public final String name;
  public int priority = 3;
  
  public Logger(LoggingBehavior paramLoggingBehavior, String paramString)
  {
    Validate.notNullOrEmpty(paramString, "tag");
    behavior = paramLoggingBehavior;
    name = f.sufficientlysecure.rootcommands.util.StringBuilder.toString("FacebookSDK.", paramString);
    contents = new StringBuilder();
  }
  
  public static void e(LoggingBehavior paramLoggingBehavior, int paramInt, String paramString1, String paramString2)
  {
    if (FacebookSdk.isLoggingBehaviorEnabled(paramLoggingBehavior))
    {
      String str = replaceStrings(paramString2);
      paramString2 = paramString1;
      if (!paramString1.startsWith("FacebookSDK.")) {
        paramString2 = f.sufficientlysecure.rootcommands.util.StringBuilder.toString("FacebookSDK.", paramString1);
      }
      Log.println(paramInt, paramString2, str);
      if (paramLoggingBehavior == LoggingBehavior.DEVELOPER_ERRORS) {
        new Exception().printStackTrace();
      }
    }
  }
  
  public static void log(LoggingBehavior paramLoggingBehavior, int paramInt, String paramString1, String paramString2, Object... paramVarArgs)
  {
    if (FacebookSdk.isLoggingBehaviorEnabled(paramLoggingBehavior)) {
      e(paramLoggingBehavior, paramInt, paramString1, String.format(paramString2, paramVarArgs));
    }
  }
  
  public static void log(LoggingBehavior paramLoggingBehavior, String paramString1, String paramString2)
  {
    e(paramLoggingBehavior, 3, paramString1, paramString2);
  }
  
  public static void logError(LoggingBehavior paramLoggingBehavior, String paramString1, String paramString2, Object... paramVarArgs)
  {
    if (FacebookSdk.isLoggingBehaviorEnabled(paramLoggingBehavior)) {
      e(paramLoggingBehavior, 3, paramString1, String.format(paramString2, paramVarArgs));
    }
  }
  
  public static void registerAccessToken(String paramString)
  {
    try
    {
      if (!FacebookSdk.isLoggingBehaviorEnabled(LoggingBehavior.INCLUDE_ACCESS_TOKENS)) {
        registerStringToReplace(paramString, "ACCESS_TOKEN_REMOVED");
      }
      return;
    }
    catch (Throwable paramString)
    {
      throw paramString;
    }
  }
  
  public static void registerStringToReplace(String paramString1, String paramString2)
  {
    try
    {
      stringsToReplace.put(paramString1, paramString2);
      return;
    }
    catch (Throwable paramString1)
    {
      throw paramString1;
    }
  }
  
  public static String replaceStrings(String paramString)
  {
    try
    {
      Iterator localIterator = stringsToReplace.entrySet().iterator();
      while (localIterator.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)localIterator.next();
        paramString = paramString.replace((CharSequence)localEntry.getKey(), (CharSequence)localEntry.getValue());
      }
      return paramString;
    }
    catch (Throwable paramString)
    {
      throw paramString;
    }
  }
  
  private boolean shouldLog()
  {
    return FacebookSdk.isLoggingBehaviorEnabled(behavior);
  }
  
  public void append(String paramString)
  {
    if (shouldLog()) {
      contents.append(paramString);
    }
  }
  
  public void append(String paramString, Object... paramVarArgs)
  {
    if (shouldLog()) {
      contents.append(String.format(paramString, paramVarArgs));
    }
  }
  
  public void append(StringBuilder paramStringBuilder)
  {
    if (shouldLog()) {
      contents.append(paramStringBuilder);
    }
  }
  
  public void appendKeyValue(String paramString, Object paramObject)
  {
    append("  %s:\t%s\n", new Object[] { paramString, paramObject });
  }
  
  public String getContents()
  {
    return replaceStrings(contents.toString());
  }
  
  public int getPriority()
  {
    return priority;
  }
  
  public void logString(String paramString)
  {
    e(behavior, priority, name, paramString);
  }
  
  public void setLevel()
  {
    logString(contents.toString());
    contents = new StringBuilder();
  }
  
  public void setPriority(int paramInt)
  {
    Validate.oneOf(Integer.valueOf(paramInt), "value", new Object[] { Integer.valueOf(7), Integer.valueOf(3), Integer.valueOf(6), Integer.valueOf(4), Integer.valueOf(2), Integer.valueOf(5) });
    priority = paramInt;
  }
}
