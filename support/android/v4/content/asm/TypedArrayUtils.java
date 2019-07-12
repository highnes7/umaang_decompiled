package support.android.v4.content.asm;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.TypedValue;
import b.b.a.N;
import org.xmlpull.v1.XmlPullParser;

@N({b.b.a.N.a.b})
public class TypedArrayUtils
{
  public static final String NAMESPACE = "http://schemas.android.com/apk/res/android";
  
  public TypedArrayUtils() {}
  
  public static Attribute a(TypedArray paramTypedArray, XmlPullParser paramXmlPullParser, Resources.Theme paramTheme, String paramString, int paramInt1, int paramInt2)
  {
    if (get(paramXmlPullParser, paramString))
    {
      paramXmlPullParser = new TypedValue();
      paramTypedArray.getValue(paramInt1, paramXmlPullParser);
      int i = type;
      if ((i >= 28) && (i <= 31)) {
        return Attribute.read(data);
      }
      paramTypedArray = Attribute.read(paramTypedArray.getResources(), paramTypedArray.getResourceId(paramInt1, 0), paramTheme);
      if (paramTypedArray != null) {
        return paramTypedArray;
      }
    }
    return Attribute.read(paramInt2);
  }
  
  public static boolean get(XmlPullParser paramXmlPullParser, String paramString)
  {
    return paramXmlPullParser.getAttributeValue("http://schemas.android.com/apk/res/android", paramString) != null;
  }
  
  public static boolean getBoolean(TypedArray paramTypedArray, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    return paramTypedArray.getBoolean(paramInt1, paramTypedArray.getBoolean(paramInt2, paramBoolean));
  }
  
  public static boolean getBoolean(TypedArray paramTypedArray, XmlPullParser paramXmlPullParser, String paramString, int paramInt, boolean paramBoolean)
  {
    if (!get(paramXmlPullParser, paramString)) {
      return paramBoolean;
    }
    return paramTypedArray.getBoolean(paramInt, paramBoolean);
  }
  
  public static Drawable getDrawable(TypedArray paramTypedArray, int paramInt1, int paramInt2)
  {
    Drawable localDrawable2 = paramTypedArray.getDrawable(paramInt1);
    Drawable localDrawable1 = localDrawable2;
    if (localDrawable2 == null) {
      localDrawable1 = paramTypedArray.getDrawable(paramInt2);
    }
    return localDrawable1;
  }
  
  public static int getInt(TypedArray paramTypedArray, int paramInt1, int paramInt2, int paramInt3)
  {
    return paramTypedArray.getInt(paramInt1, paramTypedArray.getInt(paramInt2, paramInt3));
  }
  
  public static int getInt(TypedArray paramTypedArray, XmlPullParser paramXmlPullParser, String paramString, int paramInt1, int paramInt2)
  {
    if (!get(paramXmlPullParser, paramString)) {
      return paramInt2;
    }
    return paramTypedArray.getResourceId(paramInt1, paramInt2);
  }
  
  public static float getNamedFloat(TypedArray paramTypedArray, XmlPullParser paramXmlPullParser, String paramString, int paramInt, float paramFloat)
  {
    if (!get(paramXmlPullParser, paramString)) {
      return paramFloat;
    }
    return paramTypedArray.getFloat(paramInt, paramFloat);
  }
  
  public static int getResourceId(TypedArray paramTypedArray, int paramInt1, int paramInt2, int paramInt3)
  {
    return paramTypedArray.getResourceId(paramInt1, paramTypedArray.getResourceId(paramInt2, paramInt3));
  }
  
  public static int getString(TypedArray paramTypedArray, XmlPullParser paramXmlPullParser, String paramString, int paramInt1, int paramInt2)
  {
    if (!get(paramXmlPullParser, paramString)) {
      return paramInt2;
    }
    return paramTypedArray.getInt(paramInt1, paramInt2);
  }
  
  public static TypedValue getString(TypedArray paramTypedArray, XmlPullParser paramXmlPullParser, String paramString, int paramInt)
  {
    if (!get(paramXmlPullParser, paramString)) {
      return null;
    }
    return paramTypedArray.peekValue(paramInt);
  }
  
  public static String getString(TypedArray paramTypedArray, int paramInt1, int paramInt2)
  {
    String str2 = paramTypedArray.getString(paramInt1);
    String str1 = str2;
    if (str2 == null) {
      str1 = paramTypedArray.getString(paramInt2);
    }
    return str1;
  }
  
  public static CharSequence getText(TypedArray paramTypedArray, int paramInt1, int paramInt2)
  {
    CharSequence localCharSequence2 = paramTypedArray.getText(paramInt1);
    CharSequence localCharSequence1 = localCharSequence2;
    if (localCharSequence2 == null) {
      localCharSequence1 = paramTypedArray.getText(paramInt2);
    }
    return localCharSequence1;
  }
  
  public static CharSequence[] getTextArray(TypedArray paramTypedArray, int paramInt1, int paramInt2)
  {
    CharSequence[] arrayOfCharSequence2 = paramTypedArray.getTextArray(paramInt1);
    CharSequence[] arrayOfCharSequence1 = arrayOfCharSequence2;
    if (arrayOfCharSequence2 == null) {
      arrayOfCharSequence1 = paramTypedArray.getTextArray(paramInt2);
    }
    return arrayOfCharSequence1;
  }
  
  public static String getValue(TypedArray paramTypedArray, XmlPullParser paramXmlPullParser, String paramString, int paramInt)
  {
    if (!get(paramXmlPullParser, paramString)) {
      return null;
    }
    return paramTypedArray.getString(paramInt);
  }
  
  public static TypedArray obtainAttributes(Resources paramResources, Resources.Theme paramTheme, AttributeSet paramAttributeSet, int[] paramArrayOfInt)
  {
    if (paramTheme == null) {
      return paramResources.obtainAttributes(paramAttributeSet, paramArrayOfInt);
    }
    return paramTheme.obtainStyledAttributes(paramAttributeSet, paramArrayOfInt, 0, 0);
  }
  
  public static int readString(TypedArray paramTypedArray, XmlPullParser paramXmlPullParser, String paramString, int paramInt1, int paramInt2)
  {
    if (!get(paramXmlPullParser, paramString)) {
      return paramInt2;
    }
    return paramTypedArray.getColor(paramInt1, paramInt2);
  }
  
  public static int resolveAttribute(Context paramContext, int paramInt1, int paramInt2)
  {
    TypedValue localTypedValue = new TypedValue();
    paramContext.getTheme().resolveAttribute(paramInt1, localTypedValue, true);
    if (resourceId != 0) {
      return paramInt1;
    }
    return paramInt2;
  }
}
