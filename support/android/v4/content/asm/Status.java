package support.android.v4.content.asm;

import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.graphics.LinearGradient;
import android.graphics.RadialGradient;
import android.graphics.Shader;
import android.graphics.Shader.TileMode;
import android.graphics.SweepGradient;
import android.util.AttributeSet;
import android.util.Xml;
import b.b.a.N;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import support.android.internal.JsonReader.1;

@N({b.b.a.N.a.b})
public final class Status
{
  public static final int CREATED = 1;
  public static final int WARN = 0;
  public static final int WARNING = 2;
  
  public Status() {}
  
  public static Vector3D add(Vector3D paramVector3D, int paramInt1, int paramInt2, boolean paramBoolean, int paramInt3)
  {
    if (paramVector3D != null) {
      return paramVector3D;
    }
    if (paramBoolean) {
      return new Vector3D(paramInt1, paramInt3, paramInt2);
    }
    return new Vector3D(paramInt1, paramInt2);
  }
  
  public static Shader.TileMode create(int paramInt)
  {
    if (paramInt != 1)
    {
      if (paramInt != 2) {
        return Shader.TileMode.CLAMP;
      }
      return Shader.TileMode.MIRROR;
    }
    return Shader.TileMode.REPEAT;
  }
  
  public static Shader create(Resources paramResources, XmlPullParser paramXmlPullParser, Resources.Theme paramTheme)
    throws XmlPullParserException, IOException
  {
    AttributeSet localAttributeSet = Xml.asAttributeSet(paramXmlPullParser);
    int i;
    do
    {
      i = paramXmlPullParser.next();
    } while ((i != 2) && (i != 1));
    if (i == 2) {
      return inflate(paramResources, paramXmlPullParser, localAttributeSet, paramTheme);
    }
    paramResources = new XmlPullParserException("No start tag found");
    throw paramResources;
  }
  
  public static Shader inflate(Resources paramResources, XmlPullParser paramXmlPullParser, AttributeSet paramAttributeSet, Resources.Theme paramTheme)
    throws IOException, XmlPullParserException
  {
    Object localObject = paramXmlPullParser.getName();
    if (((String)localObject).equals("gradient"))
    {
      localObject = TypedArrayUtils.obtainAttributes(paramResources, paramTheme, paramAttributeSet, JsonReader.1.GradientColor);
      float f1 = TypedArrayUtils.getNamedFloat((TypedArray)localObject, paramXmlPullParser, "startX", JsonReader.1.GradientColor_android_startX, 0.0F);
      float f2 = TypedArrayUtils.getNamedFloat((TypedArray)localObject, paramXmlPullParser, "startY", JsonReader.1.GradientColor_android_startY, 0.0F);
      float f3 = TypedArrayUtils.getNamedFloat((TypedArray)localObject, paramXmlPullParser, "endX", JsonReader.1.GradientColor_android_endX, 0.0F);
      float f4 = TypedArrayUtils.getNamedFloat((TypedArray)localObject, paramXmlPullParser, "endY", JsonReader.1.GradientColor_android_endY, 0.0F);
      float f5 = TypedArrayUtils.getNamedFloat((TypedArray)localObject, paramXmlPullParser, "centerX", JsonReader.1.GradientColor_android_centerX, 0.0F);
      float f6 = TypedArrayUtils.getNamedFloat((TypedArray)localObject, paramXmlPullParser, "centerY", JsonReader.1.GradientColor_android_centerY, 0.0F);
      int i = TypedArrayUtils.getString((TypedArray)localObject, paramXmlPullParser, "type", JsonReader.1.GradientColor_android_type, 0);
      int j = TypedArrayUtils.readString((TypedArray)localObject, paramXmlPullParser, "startColor", JsonReader.1.GradientColor_android_startColor, 0);
      boolean bool = TypedArrayUtils.get(paramXmlPullParser, "centerColor");
      int k = TypedArrayUtils.readString((TypedArray)localObject, paramXmlPullParser, "centerColor", JsonReader.1.GradientColor_android_centerColor, 0);
      int m = TypedArrayUtils.readString((TypedArray)localObject, paramXmlPullParser, "endColor", JsonReader.1.GradientColor_android_endColor, 0);
      int n = TypedArrayUtils.getString((TypedArray)localObject, paramXmlPullParser, "tileMode", JsonReader.1.GradientColor_android_tileMode, 0);
      float f7 = TypedArrayUtils.getNamedFloat((TypedArray)localObject, paramXmlPullParser, "gradientRadius", JsonReader.1.GradientColor_android_gradientRadius, 0.0F);
      ((TypedArray)localObject).recycle();
      paramResources = add(parse(paramResources, paramXmlPullParser, paramAttributeSet, paramTheme), j, m, bool, k);
      if (i != 1)
      {
        if (i != 2) {
          return new LinearGradient(f1, f2, f3, f4, z, v, create(n));
        }
        return new SweepGradient(f5, f6, z, v);
      }
      if (f7 > 0.0F) {
        return new RadialGradient(f5, f6, f7, z, v, create(n));
      }
      throw new XmlPullParserException("<gradient> tag requires 'gradientRadius' attribute with radial type");
    }
    paramResources = new StringBuilder();
    paramResources.append(paramXmlPullParser.getPositionDescription());
    paramResources.append(": invalid gradient color tag ");
    paramResources.append((String)localObject);
    throw new XmlPullParserException(paramResources.toString());
  }
  
  public static Vector3D parse(Resources paramResources, XmlPullParser paramXmlPullParser, AttributeSet paramAttributeSet, Resources.Theme paramTheme)
    throws XmlPullParserException, IOException
  {
    int i = paramXmlPullParser.getDepth() + 1;
    ArrayList localArrayList1 = new ArrayList(20);
    ArrayList localArrayList2 = new ArrayList(20);
    for (;;)
    {
      int j = paramXmlPullParser.next();
      if (j == 1) {
        break label244;
      }
      int k = paramXmlPullParser.getDepth();
      if ((k < i) && (j == 3)) {
        break label244;
      }
      if ((j == 2) && (k <= i) && (paramXmlPullParser.getName().equals("item")))
      {
        TypedArray localTypedArray = TypedArrayUtils.obtainAttributes(paramResources, paramTheme, paramAttributeSet, JsonReader.1.GradientColorItem);
        boolean bool1 = localTypedArray.hasValue(JsonReader.1.GradientColorItem_android_color);
        boolean bool2 = localTypedArray.hasValue(JsonReader.1.GradientColorItem_android_offset);
        if ((!bool1) || (!bool2)) {
          break;
        }
        j = localTypedArray.getColor(JsonReader.1.GradientColorItem_android_color, 0);
        float f = localTypedArray.getFloat(JsonReader.1.GradientColorItem_android_offset, 0.0F);
        localTypedArray.recycle();
        localArrayList2.add(Integer.valueOf(j));
        localArrayList1.add(Float.valueOf(f));
      }
    }
    paramResources = new StringBuilder();
    paramResources.append(paramXmlPullParser.getPositionDescription());
    paramResources.append(": <item> tag requires a 'color' attribute and a 'offset' ");
    paramResources.append("attribute!");
    throw new XmlPullParserException(paramResources.toString());
    label244:
    if (localArrayList2.size() > 0) {
      return new Vector3D(localArrayList2, localArrayList1);
    }
    return null;
  }
}
