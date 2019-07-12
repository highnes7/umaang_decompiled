package support.android.v4.content.asm;

import android.content.res.TypedArray;
import android.os.Build.VERSION;
import android.util.Base64;
import android.util.TypedValue;
import android.util.Xml;
import b.b.a.N;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import support.android.internal.JsonReader.1;

@N({b.b.a.N.a.b})
public class Resources
{
  public static final int DELAY_WAIT_FOR_RUNNER_TO_STOP = 500;
  public static final int FULL = 1;
  public static final int Icode_DUP = -1;
  public static final int MIN_FLING_VELOCITY = 400;
  public static final int MONTHS = 1;
  public static final int NONE = 0;
  
  public Resources() {}
  
  public static void add(XmlPullParser paramXmlPullParser)
    throws XmlPullParserException, IOException
  {
    int i = 1;
    while (i > 0)
    {
      int j = paramXmlPullParser.next();
      if (j != 2)
      {
        if (j == 3) {
          i -= 1;
        }
      }
      else {
        i += 1;
      }
    }
  }
  
  public static Object create(XmlPullParser paramXmlPullParser, android.content.res.Resources paramResources)
    throws XmlPullParserException, IOException
  {
    paramXmlPullParser.require(2, null, "font-family");
    if (paramXmlPullParser.getName().equals("font-family")) {
      return initialize(paramXmlPullParser, paramResources);
    }
    add(paramXmlPullParser);
    return null;
  }
  
  public static Object createFromXml(XmlPullParser paramXmlPullParser, android.content.res.Resources paramResources)
    throws XmlPullParserException, IOException
  {
    int i;
    do
    {
      i = paramXmlPullParser.next();
    } while ((i != 2) && (i != 1));
    if (i == 2) {
      return create(paramXmlPullParser, paramResources);
    }
    paramXmlPullParser = new XmlPullParserException("No start tag found");
    throw paramXmlPullParser;
  }
  
  public static int getType(TypedArray paramTypedArray, int paramInt)
  {
    if (Build.VERSION.SDK_INT >= 21) {
      return paramTypedArray.getType(paramInt);
    }
    TypedValue localTypedValue = new TypedValue();
    paramTypedArray.getValue(paramInt, localTypedValue);
    return type;
  }
  
  public static List getValue(android.content.res.Resources paramResources, int paramInt)
  {
    if (paramInt == 0) {
      return Collections.emptyList();
    }
    TypedArray localTypedArray = paramResources.obtainTypedArray(paramInt);
    try
    {
      int i = localTypedArray.length();
      if (i == 0)
      {
        paramResources = Collections.emptyList();
        localTypedArray.recycle();
        return paramResources;
      }
      ArrayList localArrayList = new ArrayList();
      i = getType(localTypedArray, 0);
      if (i == 1)
      {
        paramInt = 0;
        for (;;)
        {
          i = localTypedArray.length();
          if (paramInt >= i) {
            break;
          }
          i = localTypedArray.getResourceId(paramInt, 0);
          if (i != 0) {
            localArrayList.add(read(paramResources.getStringArray(i)));
          }
          paramInt += 1;
        }
      }
      localArrayList.add(read(paramResources.getStringArray(paramInt)));
      localTypedArray.recycle();
      return localArrayList;
    }
    catch (Throwable paramResources)
    {
      localTypedArray.recycle();
      throw paramResources;
    }
  }
  
  public static Object initialize(XmlPullParser paramXmlPullParser, android.content.res.Resources paramResources)
    throws XmlPullParserException, IOException
  {
    java.lang.Object localObject = paramResources.obtainAttributes(Xml.asAttributeSet(paramXmlPullParser), JsonReader.1.FontFamily);
    String str1 = ((TypedArray)localObject).getString(JsonReader.1.FontFamily_fontProviderAuthority);
    String str2 = ((TypedArray)localObject).getString(JsonReader.1.FontFamily_fontProviderPackage);
    String str3 = ((TypedArray)localObject).getString(JsonReader.1.FontFamily_fontProviderQuery);
    int i = ((TypedArray)localObject).getResourceId(JsonReader.1.FontFamily_fontProviderCerts, 0);
    int j = ((TypedArray)localObject).getInteger(JsonReader.1.FontFamily_fontProviderFetchStrategy, 1);
    int k = ((TypedArray)localObject).getInteger(JsonReader.1.FontFamily_fontProviderFetchTimeout, 500);
    ((TypedArray)localObject).recycle();
    if ((str1 != null) && (str2 != null) && (str3 != null))
    {
      while (paramXmlPullParser.next() != 3) {
        add(paramXmlPullParser);
      }
      return new h(new support.android.v4.tts.h(str1, str2, str3, getValue(paramResources, i)), j, k);
    }
    localObject = new ArrayList();
    while (paramXmlPullParser.next() != 3) {
      if (paramXmlPullParser.getEventType() == 2) {
        if (paramXmlPullParser.getName().equals("font")) {
          ((List)localObject).add(loadHeadersFromResource(paramXmlPullParser, paramResources));
        } else {
          add(paramXmlPullParser);
        }
      }
    }
    if (((List)localObject).isEmpty()) {
      return null;
    }
    return new x((f[])((List)localObject).toArray(new f[((List)localObject).size()]));
  }
  
  public static f loadHeadersFromResource(XmlPullParser paramXmlPullParser, android.content.res.Resources paramResources)
    throws XmlPullParserException, IOException
  {
    paramResources = paramResources.obtainAttributes(Xml.asAttributeSet(paramXmlPullParser), JsonReader.1.FontFamilyFont);
    int i;
    if (paramResources.hasValue(JsonReader.1.FontFamilyFont_fontWeight)) {
      i = JsonReader.1.FontFamilyFont_fontWeight;
    } else {
      i = JsonReader.1.FontFamilyFont_android_fontWeight;
    }
    int k = paramResources.getInt(i, 400);
    if (paramResources.hasValue(JsonReader.1.FontFamilyFont_fontStyle)) {
      i = JsonReader.1.FontFamilyFont_fontStyle;
    } else {
      i = JsonReader.1.FontFamilyFont_android_fontStyle;
    }
    boolean bool;
    if (1 == paramResources.getInt(i, 0)) {
      bool = true;
    } else {
      bool = false;
    }
    if (paramResources.hasValue(JsonReader.1.FontFamilyFont_ttcIndex)) {
      i = JsonReader.1.FontFamilyFont_ttcIndex;
    } else {
      i = JsonReader.1.FontFamilyFont_android_ttcIndex;
    }
    if (paramResources.hasValue(JsonReader.1.FontFamilyFont_fontVariationSettings)) {
      j = JsonReader.1.FontFamilyFont_fontVariationSettings;
    } else {
      j = JsonReader.1.FontFamilyFont_android_fontVariationSettings;
    }
    String str1 = paramResources.getString(j);
    int j = paramResources.getInt(i, 0);
    if (paramResources.hasValue(JsonReader.1.FontFamilyFont_font)) {
      i = JsonReader.1.FontFamilyFont_font;
    } else {
      i = JsonReader.1.FontFamilyFont_android_font;
    }
    int m = paramResources.getResourceId(i, 0);
    String str2 = paramResources.getString(i);
    paramResources.recycle();
    while (paramXmlPullParser.next() != 3) {
      add(paramXmlPullParser);
    }
    return new f(str2, k, bool, str1, j, m);
  }
  
  public static List read(String[] paramArrayOfString)
  {
    ArrayList localArrayList = new ArrayList();
    int j = paramArrayOfString.length;
    int i = 0;
    while (i < j)
    {
      localArrayList.add(Base64.decode(paramArrayOfString[i], 0));
      i += 1;
    }
    return localArrayList;
  }
}
