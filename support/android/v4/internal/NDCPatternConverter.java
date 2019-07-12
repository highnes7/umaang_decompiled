package support.android.v4.internal;

import android.graphics.Typeface;
import b.b.a.K;
import b.b.a.N;
import java.lang.reflect.Array;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

@K(28)
@N({b.b.a.N.a.b})
public class NDCPatternConverter
  extends ClassWriter
{
  public static final String ACTION_UPDATE_ALL = "createFromFamiliesWithDefault";
  public static final String CANCEL_MENU = "TypefaceCompatApi28Impl";
  public static final String DEFAULT_FONT_FAMILY = "sans-serif";
  public static final int Icode_DUP = -1;
  
  public NDCPatternConverter() {}
  
  public Typeface get(Object paramObject)
  {
    Object localObject = target;
    try
    {
      localObject = Array.newInstance((Class)localObject, 1);
      Array.set(localObject, 0, paramObject);
      paramObject = method;
      paramObject = paramObject.invoke(null, new Object[] { localObject, "sans-serif", Integer.valueOf(-1), Integer.valueOf(-1) });
      return (Typeface)paramObject;
    }
    catch (InvocationTargetException paramObject) {}catch (IllegalAccessException paramObject) {}
    throw new RuntimeException(paramObject);
  }
  
  public Method newInstance(Class paramClass)
    throws NoSuchMethodException
  {
    paramClass = Array.newInstance(paramClass, 1).getClass();
    Class localClass = Integer.TYPE;
    paramClass = Typeface.class.getDeclaredMethod("createFromFamiliesWithDefault", new Class[] { paramClass, String.class, localClass, localClass });
    paramClass.setAccessible(true);
    return paramClass;
  }
}
