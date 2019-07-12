package support.android.asm;

import android.animation.LayoutTransition;
import android.view.View;
import android.view.ViewGroup;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class PopupWindowCompat
{
  public static final int CALENDARS_INDEX_CAN_ORGANIZER_RESPOND = 4;
  public static final String PAGE_KEY = "ViewGroupUtilsApi14";
  public static Field field;
  public static Method sGetWindowLayoutTypeMethod;
  public static boolean sGetWindowLayoutTypeMethodAttempted;
  public static LayoutTransition target;
  public static boolean value;
  
  public PopupWindowCompat() {}
  
  /* Error */
  public static void getWindowLayoutType(LayoutTransition paramLayoutTransition)
  {
    // Byte code:
    //   0: getstatic 35	support/android/asm/PopupWindowCompat:sGetWindowLayoutTypeMethodAttempted	Z
    //   3: ifne +32 -> 35
    //   6: ldc 37
    //   8: ldc 39
    //   10: iconst_0
    //   11: anewarray 41	java/lang/Class
    //   14: invokevirtual 45	java/lang/Class:getDeclaredMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   17: astore_1
    //   18: aload_1
    //   19: putstatic 47	support/android/asm/PopupWindowCompat:sGetWindowLayoutTypeMethod	Ljava/lang/reflect/Method;
    //   22: getstatic 47	support/android/asm/PopupWindowCompat:sGetWindowLayoutTypeMethod	Ljava/lang/reflect/Method;
    //   25: astore_1
    //   26: aload_1
    //   27: iconst_1
    //   28: invokevirtual 53	java/lang/reflect/Method:setAccessible	(Z)V
    //   31: iconst_1
    //   32: putstatic 35	support/android/asm/PopupWindowCompat:sGetWindowLayoutTypeMethodAttempted	Z
    //   35: getstatic 47	support/android/asm/PopupWindowCompat:sGetWindowLayoutTypeMethod	Ljava/lang/reflect/Method;
    //   38: astore_1
    //   39: aload_1
    //   40: ifnull +21 -> 61
    //   43: aload_1
    //   44: aload_0
    //   45: iconst_0
    //   46: anewarray 4	java/lang/Object
    //   49: invokevirtual 57	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   52: pop
    //   53: return
    //   54: astore_1
    //   55: goto -24 -> 31
    //   58: astore_0
    //   59: return
    //   60: astore_0
    //   61: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	62	0	paramLayoutTransition	LayoutTransition
    //   17	27	1	localMethod	Method
    //   54	1	1	localNoSuchMethodException	NoSuchMethodException
    // Exception table:
    //   from	to	target	type
    //   6	18	54	java/lang/NoSuchMethodException
    //   26	31	54	java/lang/NoSuchMethodException
    //   43	53	58	java/lang/IllegalAccessException
    //   43	53	60	java/lang/reflect/InvocationTargetException
  }
  
  public static void init(ViewGroup paramViewGroup, boolean paramBoolean)
  {
    Object localObject = target;
    boolean bool = false;
    if (localObject == null)
    {
      target = new DownloadsFragment.1();
      target.setAnimator(2, null);
      target.setAnimator(0, null);
      target.setAnimator(1, null);
      target.setAnimator(3, null);
      target.setAnimator(4, null);
    }
    if (paramBoolean)
    {
      localObject = paramViewGroup.getLayoutTransition();
      if (localObject != null)
      {
        if (((LayoutTransition)localObject).isRunning()) {
          getWindowLayoutType((LayoutTransition)localObject);
        }
        if (localObject != target) {
          paramViewGroup.setTag(R.id.transition_layout_save, localObject);
        }
      }
      paramViewGroup.setLayoutTransition(target);
      return;
    }
    paramViewGroup.setLayoutTransition(null);
    if (!value) {}
    try
    {
      localObject = ViewGroup.class.getDeclaredField("mLayoutSuppressed");
      field = (Field)localObject;
      localObject = field;
      ((Field)localObject).setAccessible(true);
    }
    catch (NoSuchFieldException localIllegalAccessException1)
    {
      try
      {
        paramBoolean = ((Field)localObject).getBoolean(paramViewGroup);
        if (!paramBoolean) {
          break label173;
        }
        localObject = field;
      }
      catch (IllegalAccessException localIllegalAccessException1)
      {
        try
        {
          ((Field)localObject).setBoolean(paramViewGroup, false);
          for (;;)
          {
            if (paramBoolean) {
              paramViewGroup.requestLayout();
            }
            localObject = (LayoutTransition)paramViewGroup.getTag(R.id.transition_layout_save);
            if (localObject == null) {
              return;
            }
            paramViewGroup.setTag(R.id.transition_layout_save, null);
            paramViewGroup.setLayoutTransition((LayoutTransition)localObject);
            return;
            localNoSuchFieldException = localNoSuchFieldException;
            break;
            localIllegalAccessException1 = localIllegalAccessException1;
            paramBoolean = bool;
          }
        }
        catch (IllegalAccessException localIllegalAccessException2)
        {
          for (;;) {}
        }
      }
    }
    value = true;
    localObject = field;
    paramBoolean = bool;
    if (localObject != null) {}
    label173:
  }
}
