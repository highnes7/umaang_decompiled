package android.support.design.resources;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.support.v7.content.res.AppCompatResources;
import b.b.a.N;

@N({b.b.a.N.a.b})
public class MaterialResources
{
  public MaterialResources() {}
  
  public static ColorStateList getColorStateList(Context paramContext, TypedArray paramTypedArray, int paramInt)
  {
    if (paramTypedArray.hasValue(paramInt))
    {
      int i = paramTypedArray.getResourceId(paramInt, 0);
      if (i != 0)
      {
        paramContext = AppCompatResources.getColorStateList(paramContext, i);
        if (paramContext != null) {
          return paramContext;
        }
      }
    }
    return paramTypedArray.getColorStateList(paramInt);
  }
  
  public static Drawable getDrawable(Context paramContext, TypedArray paramTypedArray, int paramInt)
  {
    if (paramTypedArray.hasValue(paramInt))
    {
      int i = paramTypedArray.getResourceId(paramInt, 0);
      if (i != 0)
      {
        paramContext = AppCompatResources.getDrawable(paramContext, i);
        if (paramContext != null) {
          return paramContext;
        }
      }
    }
    return paramTypedArray.getDrawable(paramInt);
  }
  
  public static int getIndexWithValue(TypedArray paramTypedArray, int paramInt1, int paramInt2)
  {
    if (paramTypedArray.hasValue(paramInt1)) {
      return paramInt1;
    }
    return paramInt2;
  }
  
  public static TextAppearance getTextAppearance(Context paramContext, TypedArray paramTypedArray, int paramInt)
  {
    if (paramTypedArray.hasValue(paramInt))
    {
      paramInt = paramTypedArray.getResourceId(paramInt, 0);
      if (paramInt != 0) {
        return new TextAppearance(paramContext, paramInt);
      }
    }
    return null;
  }
}
