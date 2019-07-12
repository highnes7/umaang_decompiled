package support.android.v4.view;

import android.os.Build.VERSION;
import android.view.LayoutInflater;
import android.view.LayoutInflater.Factory;
import android.view.LayoutInflater.Factory2;
import java.lang.reflect.Field;

public final class LayoutInflaterCompatHC
{
  public static final String TAG = "LayoutInflaterCompatHC";
  public static boolean sCheckedField;
  public static Field sLayoutInflaterFactory2Field;
  
  public LayoutInflaterCompatHC() {}
  
  public static void forceSetFactory2(LayoutInflater paramLayoutInflater, LayoutInflater.Factory2 paramFactory2)
  {
    if (!sCheckedField) {}
    try
    {
      localObject = LayoutInflater.class.getDeclaredField("mFactory2");
      sLayoutInflaterFactory2Field = (Field)localObject;
      localObject = sLayoutInflaterFactory2Field;
      ((Field)localObject).setAccessible(true);
    }
    catch (NoSuchFieldException localNoSuchFieldException)
    {
      Object localObject;
      for (;;) {}
    }
    localObject = f.sufficientlysecure.rootcommands.util.StringBuilder.append("forceSetFactory2 Could not find field 'mFactory2' on class ");
    ((StringBuilder)localObject).append(LayoutInflater.class.getName());
    ((StringBuilder)localObject).append("; inflation may have unexpected results.");
    ((StringBuilder)localObject).toString();
    sCheckedField = true;
    localObject = sLayoutInflaterFactory2Field;
    if (localObject != null)
    {
      try
      {
        ((Field)localObject).set(paramLayoutInflater, paramFactory2);
        return;
      }
      catch (IllegalAccessException paramFactory2)
      {
        for (;;) {}
      }
      paramFactory2 = new StringBuilder();
      paramFactory2.append("forceSetFactory2 could not set the Factory2 on LayoutInflater ");
      paramFactory2.append(paramLayoutInflater);
      paramFactory2.append("; inflation may have unexpected results.");
      paramFactory2.toString();
      return;
    }
  }
  
  public static LayoutInflaterFactory getFactory(LayoutInflater paramLayoutInflater)
  {
    paramLayoutInflater = paramLayoutInflater.getFactory();
    if ((paramLayoutInflater instanceof LayoutInflaterCompatBase.FactoryWrapper)) {
      return mDelegateFactory;
    }
    return null;
  }
  
  public static void setFactory(LayoutInflater paramLayoutInflater, LayoutInflater.Factory2 paramFactory2)
  {
    paramLayoutInflater.setFactory2(paramFactory2);
    if (Build.VERSION.SDK_INT < 21)
    {
      LayoutInflater.Factory localFactory = paramLayoutInflater.getFactory();
      if ((localFactory instanceof LayoutInflater.Factory2))
      {
        forceSetFactory2(paramLayoutInflater, (LayoutInflater.Factory2)localFactory);
        return;
      }
      forceSetFactory2(paramLayoutInflater, paramFactory2);
    }
  }
  
  public static void setFactory(LayoutInflater paramLayoutInflater, LayoutInflaterFactory paramLayoutInflaterFactory)
  {
    int i = Build.VERSION.SDK_INT;
    Object localObject2 = null;
    Object localObject1 = null;
    if (i >= 21)
    {
      if (paramLayoutInflaterFactory != null) {
        localObject1 = new LayoutInflaterCompatBase.FactoryWrapper(paramLayoutInflaterFactory);
      }
      paramLayoutInflater.setFactory2((LayoutInflater.Factory2)localObject1);
      return;
    }
    localObject1 = localObject2;
    if (paramLayoutInflaterFactory != null) {
      localObject1 = new LayoutInflaterCompatBase.FactoryWrapper(paramLayoutInflaterFactory);
    }
    paramLayoutInflater.setFactory2((LayoutInflater.Factory2)localObject1);
    paramLayoutInflaterFactory = paramLayoutInflater.getFactory();
    if ((paramLayoutInflaterFactory instanceof LayoutInflater.Factory2))
    {
      forceSetFactory2(paramLayoutInflater, (LayoutInflater.Factory2)paramLayoutInflaterFactory);
      return;
    }
    forceSetFactory2(paramLayoutInflater, (LayoutInflater.Factory2)localObject1);
  }
}
