package com.google.android.android.dynamite;

import dalvik.system.BaseDexClassLoader;
import dalvik.system.PathClassLoader;

public final class Loader
  extends PathClassLoader
{
  public Loader(String paramString, ClassLoader paramClassLoader)
  {
    super(paramString, paramClassLoader);
  }
  
  public final Class loadClass(String paramString, boolean paramBoolean)
    throws ClassNotFoundException
  {
    if ((!paramString.startsWith("java.")) && (!paramString.startsWith("android."))) {}
    try
    {
      Class localClass = findClass(paramString);
      return localClass;
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
      for (;;) {}
    }
    return super.loadClass(paramString, paramBoolean);
  }
}
