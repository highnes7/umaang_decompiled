package support.android.v4.widget;

import android.graphics.Rect;
import java.util.ArrayList;
import java.util.Collections;

public class ClassReader
{
  public ClassReader() {}
  
  public static Object a(Object paramObject, ArrayList paramArrayList, boolean paramBoolean)
  {
    int j = paramArrayList.size();
    int i;
    if (paramObject == null) {
      i = j;
    } else {
      i = paramArrayList.indexOf(paramObject);
    }
    i -= 1;
    if (i >= 0) {
      return paramArrayList.get(i);
    }
    if ((paramBoolean) && (j > 0)) {
      return paramArrayList.get(j - 1);
    }
    return null;
  }
  
  public static Object a(Object paramObject1, c paramC, Item paramItem, Object paramObject2, int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    int j = paramC.a(paramObject1);
    ArrayList localArrayList = new ArrayList(j);
    int i = 0;
    while (i < j)
    {
      localArrayList.add(paramC.a(paramObject1, i));
      i += 1;
    }
    Collections.sort(localArrayList, new a(paramBoolean1, paramItem));
    if (paramInt != 1)
    {
      if (paramInt == 2) {
        return invoke(paramObject2, localArrayList, paramBoolean2);
      }
      throw new IllegalArgumentException("direction must be one of {FOCUS_FORWARD, FOCUS_BACKWARD}.");
    }
    return a(paramObject2, localArrayList, paramBoolean2);
  }
  
  public static Object a(Object paramObject1, c paramC, Item paramItem, Object paramObject2, Rect paramRect, int paramInt)
  {
    Rect localRect1 = new Rect(paramRect);
    int i = 0;
    if (paramInt != 17)
    {
      if (paramInt != 33)
      {
        if (paramInt != 66)
        {
          if (paramInt == 130) {
            localRect1.offset(0, -(paramRect.height() + 1));
          } else {
            throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
          }
        }
        else {
          localRect1.offset(-(paramRect.width() + 1), 0);
        }
      }
      else {
        localRect1.offset(0, paramRect.height() + 1);
      }
    }
    else {
      localRect1.offset(paramRect.width() + 1, 0);
    }
    Object localObject1 = null;
    int j = paramC.a(paramObject1);
    Rect localRect2 = new Rect();
    while (i < j)
    {
      Object localObject2 = paramC.a(paramObject1, i);
      if (localObject2 != paramObject2)
      {
        paramItem.a(localObject2, localRect2);
        if (b(paramInt, paramRect, localRect2, localRect1))
        {
          localRect1.set(localRect2);
          localObject1 = localObject2;
        }
      }
      i += 1;
    }
    return localObject1;
  }
  
  public static boolean a(int paramInt, Rect paramRect1, Rect paramRect2)
  {
    if (paramInt != 17)
    {
      if (paramInt != 33)
      {
        if (paramInt != 66)
        {
          if (paramInt == 130) {
            return bottom <= top;
          }
          throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
        }
        return right <= left;
      }
      return top >= bottom;
    }
    return left >= right;
  }
  
  public static boolean a(int paramInt, Rect paramRect1, Rect paramRect2, Rect paramRect3)
  {
    boolean bool = arrowScroll(paramInt, paramRect1, paramRect2);
    if (!arrowScroll(paramInt, paramRect1, paramRect3))
    {
      if (!bool) {
        return false;
      }
      if (!a(paramInt, paramRect1, paramRect3)) {
        return true;
      }
      if (paramInt != 17)
      {
        if (paramInt == 66) {
          return true;
        }
        return b(paramInt, paramRect1, paramRect2) < create(paramInt, paramRect1, paramRect3);
      }
    }
    else
    {
      return false;
    }
    return true;
  }
  
  public static boolean arrowScroll(int paramInt, Rect paramRect1, Rect paramRect2)
  {
    if (paramInt != 17)
    {
      if (paramInt != 33)
      {
        if (paramInt == 66) {
          break label64;
        }
        if (paramInt != 130) {
          throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
        }
      }
      return (right >= left) && (left <= right);
    }
    label64:
    return (bottom >= top) && (top <= bottom);
  }
  
  public static int b(int paramInt1, int paramInt2)
  {
    return paramInt2 * paramInt2 + paramInt1 * 13 * paramInt1;
  }
  
  public static int b(int paramInt, Rect paramRect1, Rect paramRect2)
  {
    return Math.max(0, evaluate(paramInt, paramRect1, paramRect2));
  }
  
  public static boolean b(int paramInt, Rect paramRect1, Rect paramRect2, Rect paramRect3)
  {
    if (!load(paramRect1, paramRect2, paramInt)) {
      return false;
    }
    if (!load(paramRect1, paramRect3, paramInt)) {
      return true;
    }
    if (a(paramInt, paramRect1, paramRect2, paramRect3)) {
      return true;
    }
    if (a(paramInt, paramRect1, paramRect3, paramRect2)) {
      return false;
    }
    return b(b(paramInt, paramRect1, paramRect2), show(paramInt, paramRect1, paramRect2)) < b(b(paramInt, paramRect1, paramRect3), show(paramInt, paramRect1, paramRect3));
  }
  
  public static int create(int paramInt, Rect paramRect1, Rect paramRect2)
  {
    return Math.max(1, load(paramInt, paramRect1, paramRect2));
  }
  
  public static int evaluate(int paramInt, Rect paramRect1, Rect paramRect2)
  {
    int i;
    if (paramInt != 17) {
      if (paramInt != 33) {
        if (paramInt != 66) {
          if (paramInt == 130)
          {
            i = top;
            paramInt = bottom;
          }
        }
      }
    }
    for (;;)
    {
      return i - paramInt;
      throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
      i = left;
      paramInt = right;
      continue;
      i = top;
      paramInt = bottom;
      continue;
      i = left;
      paramInt = right;
    }
  }
  
  public static Object invoke(Object paramObject, ArrayList paramArrayList, boolean paramBoolean)
  {
    int j = paramArrayList.size();
    int i;
    if (paramObject == null) {
      i = -1;
    } else {
      i = paramArrayList.lastIndexOf(paramObject);
    }
    i += 1;
    if (i < j) {
      return paramArrayList.get(i);
    }
    if ((paramBoolean) && (j > 0)) {
      return paramArrayList.get(0);
    }
    return null;
  }
  
  public static int load(int paramInt, Rect paramRect1, Rect paramRect2)
  {
    int i;
    if (paramInt != 17) {
      if (paramInt != 33) {
        if (paramInt != 66) {
          if (paramInt == 130)
          {
            i = bottom;
            paramInt = bottom;
          }
        }
      }
    }
    for (;;)
    {
      return i - paramInt;
      throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
      i = right;
      paramInt = right;
      continue;
      i = top;
      paramInt = top;
      continue;
      i = left;
      paramInt = left;
    }
  }
  
  public static boolean load(Rect paramRect1, Rect paramRect2, int paramInt)
  {
    if (paramInt != 17)
    {
      if (paramInt != 33)
      {
        if (paramInt != 66)
        {
          if (paramInt == 130)
          {
            paramInt = top;
            i = top;
            return ((paramInt < i) || (bottom <= i)) && (bottom < bottom);
          }
          throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
        }
        paramInt = left;
        i = left;
        return ((paramInt < i) || (right <= i)) && (right < right);
      }
      paramInt = bottom;
      i = bottom;
      return ((paramInt > i) || (top >= i)) && (top > top);
    }
    paramInt = right;
    int i = right;
    return ((paramInt > i) || (left >= i)) && (left > left);
  }
  
  public static int show(int paramInt, Rect paramRect1, Rect paramRect2)
  {
    if (paramInt != 17)
    {
      if (paramInt != 33)
      {
        if (paramInt == 66) {
          break label73;
        }
        if (paramInt != 130) {
          throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
        }
      }
      paramInt = left;
      i = paramRect1.width() / 2;
      j = left;
      return Math.abs(i + paramInt - (paramRect2.width() / 2 + j));
    }
    label73:
    paramInt = top;
    int i = paramRect1.height() / 2;
    int j = top;
    return Math.abs(i + paramInt - (paramRect2.height() / 2 + j));
  }
}
