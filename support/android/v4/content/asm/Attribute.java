package support.android.v4.content.asm;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.content.res.XmlResourceParser;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.util.Xml;
import b.b.a.N;
import java.io.IOException;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

@N({b.b.a.N.a.b})
public final class Attribute
{
  public static final String CVS_ID = "ComplexColorCompat";
  public int a;
  public final Shader b;
  public final ColorStateList w;
  
  public Attribute(Shader paramShader, ColorStateList paramColorStateList, int paramInt)
  {
    b = paramShader;
    w = paramColorStateList;
    a = paramInt;
  }
  
  public static Attribute create(Resources paramResources, int paramInt, Resources.Theme paramTheme)
    throws IOException, XmlPullParserException
  {
    XmlResourceParser localXmlResourceParser = paramResources.getXml(paramInt);
    AttributeSet localAttributeSet = Xml.asAttributeSet(localXmlResourceParser);
    do
    {
      paramInt = localXmlResourceParser.next();
    } while ((paramInt != 2) && (paramInt != 1));
    if (paramInt == 2)
    {
      String str = localXmlResourceParser.getName();
      paramInt = -1;
      int i = str.hashCode();
      if (i != 89650992)
      {
        if ((i == 1191572447) && (str.equals("selector"))) {
          paramInt = 0;
        }
      }
      else if (str.equals("gradient")) {
        paramInt = 1;
      }
      if (paramInt != 0)
      {
        if (paramInt == 1) {
          return get(Status.inflate(paramResources, localXmlResourceParser, localAttributeSet, paramTheme));
        }
        paramResources = new StringBuilder();
        paramResources.append(localXmlResourceParser.getPositionDescription());
        paramResources.append(": unsupported complex color tag ");
        paramResources.append(str);
        throw new XmlPullParserException(paramResources.toString());
      }
      return get(Type.create(paramResources, localXmlResourceParser, localAttributeSet, paramTheme));
    }
    paramResources = new XmlPullParserException("No start tag found");
    throw paramResources;
  }
  
  public static Attribute get(ColorStateList paramColorStateList)
  {
    return new Attribute(null, paramColorStateList, paramColorStateList.getDefaultColor());
  }
  
  public static Attribute get(Shader paramShader)
  {
    return new Attribute(paramShader, null, 0);
  }
  
  public static Attribute read(int paramInt)
  {
    return new Attribute(null, null, paramInt);
  }
  
  public static Attribute read(Resources paramResources, int paramInt, Resources.Theme paramTheme)
  {
    try
    {
      paramResources = create(paramResources, paramInt, paramTheme);
      return paramResources;
    }
    catch (Exception paramResources)
    {
      for (;;) {}
    }
    return null;
  }
  
  public void a(int paramInt)
  {
    a = paramInt;
  }
  
  public boolean a()
  {
    return (size()) || (a != 0);
  }
  
  public boolean a(int[] paramArrayOfInt)
  {
    if (equals())
    {
      ColorStateList localColorStateList = w;
      int i = localColorStateList.getColorForState(paramArrayOfInt, localColorStateList.getDefaultColor());
      if (i != a)
      {
        a = i;
        return true;
      }
    }
    return false;
  }
  
  public boolean equals()
  {
    if (b == null)
    {
      ColorStateList localColorStateList = w;
      if ((localColorStateList != null) && (localColorStateList.isStateful())) {
        return true;
      }
    }
    return false;
  }
  
  public int getColor()
  {
    return a;
  }
  
  public Shader getValue()
  {
    return b;
  }
  
  public boolean size()
  {
    return b != null;
  }
}
