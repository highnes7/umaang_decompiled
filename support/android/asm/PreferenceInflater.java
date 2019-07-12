package support.android.asm;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.Resources.NotFoundException;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.support.transition.Transition;
import android.util.AttributeSet;
import android.util.Xml;
import android.view.InflateException;
import android.view.ViewGroup;
import b.b.x.n.b;
import java.io.IOException;
import java.lang.reflect.Constructor;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import support.android.v4.content.asm.TypedArrayUtils;
import support.android.v4.util.ArrayMap;
import support.android.v4.util.SimpleArrayMap;

public class PreferenceInflater
{
  public static final b<String, Constructor> CONSTRUCTOR_MAP = new ArrayMap();
  public static final Class<?>[] CONSTRUCTOR_SIGNATURE = { Context.class, AttributeSet.class };
  public final Context mContext;
  
  public PreferenceInflater(Context paramContext)
  {
    mContext = paramContext;
  }
  
  public static PreferenceInflater cloneInContext(Context paramContext)
  {
    return new PreferenceInflater(paramContext);
  }
  
  private Object create(AttributeSet paramAttributeSet, Class paramClass, String paramString)
  {
    String str = paramAttributeSet.getAttributeValue(null, "class");
    if (str != null)
    {
      ArrayMap localArrayMap = CONSTRUCTOR_MAP;
      try
      {
        Constructor localConstructor = (Constructor)CONSTRUCTOR_MAP.get(str);
        paramString = localConstructor;
        if (localConstructor == null)
        {
          Class localClass = mContext.getClassLoader().loadClass(str).asSubclass(paramClass);
          paramString = localConstructor;
          if (localClass != null)
          {
            localConstructor = localClass.getConstructor(CONSTRUCTOR_SIGNATURE);
            paramString = localConstructor;
            localConstructor.setAccessible(true);
            CONSTRUCTOR_MAP.put(str, localConstructor);
          }
        }
        paramAttributeSet = paramString.newInstance(new Object[] { mContext, paramAttributeSet });
        return paramAttributeSet;
      }
      catch (Throwable paramAttributeSet)
      {
        try
        {
          throw paramAttributeSet;
        }
        catch (Exception paramAttributeSet)
        {
          paramString = new StringBuilder();
          paramString.append("Could not instantiate ");
          paramString.append(paramClass);
          paramString.append(" class ");
          paramString.append(str);
          throw new InflateException(paramString.toString(), paramAttributeSet);
        }
      }
    }
    throw new InflateException(f.sufficientlysecure.rootcommands.util.StringBuilder.toString(paramString, " tag must have a 'class' attribute"));
  }
  
  private Transition inflate(XmlPullParser paramXmlPullParser, AttributeSet paramAttributeSet, Transition paramTransition)
    throws XmlPullParserException, IOException
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: fail exe a13 = a12\n\tat com.googlecode.dex2jar.ir.ts.an.BaseAnalyze.exec(BaseAnalyze.java:92)\n\tat com.googlecode.dex2jar.ir.ts.an.BaseAnalyze.exec(BaseAnalyze.java:1)\n\tat com.googlecode.dex2jar.ir.ts.Cfg.dfs(Cfg.java:255)\n\tat com.googlecode.dex2jar.ir.ts.an.BaseAnalyze.analyze0(BaseAnalyze.java:75)\n\tat com.googlecode.dex2jar.ir.ts.an.BaseAnalyze.analyze(BaseAnalyze.java:69)\n\tat com.googlecode.dex2jar.ir.ts.UnSSATransformer.transform(UnSSATransformer.java:274)\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:163)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\nCaused by: java.lang.NullPointerException\n");
  }
  
  private ClassWriter inflate(XmlPullParser paramXmlPullParser, AttributeSet paramAttributeSet, ViewGroup paramViewGroup)
    throws XmlPullParserException, IOException
  {
    int i = paramXmlPullParser.getDepth();
    ClassWriter localClassWriter = null;
    for (;;)
    {
      int j = paramXmlPullParser.next();
      if (((j == 3) && (paramXmlPullParser.getDepth() <= i)) || (j == 1)) {
        break label137;
      }
      if (j == 2)
      {
        String str = paramXmlPullParser.getName();
        if (str.equals("transitionManager"))
        {
          localClassWriter = new ClassWriter();
        }
        else
        {
          if ((!str.equals("transition")) || (localClassWriter == null)) {
            break;
          }
          init(paramAttributeSet, paramXmlPullParser, paramViewGroup, localClassWriter);
        }
      }
    }
    paramAttributeSet = f.sufficientlysecure.rootcommands.util.StringBuilder.append("Unknown scene name: ");
    paramAttributeSet.append(paramXmlPullParser.getName());
    throw new RuntimeException(paramAttributeSet.toString());
    label137:
    return localClassWriter;
  }
  
  private void init(AttributeSet paramAttributeSet, XmlPullParser paramXmlPullParser, ViewGroup paramViewGroup, ClassWriter paramClassWriter)
    throws Resources.NotFoundException
  {
    TypedArray localTypedArray = mContext.obtainStyledAttributes(paramAttributeSet, R.styleable.SeekBarPreference);
    int i = TypedArrayUtils.getInt(localTypedArray, paramXmlPullParser, "transition", 2, -1);
    int j = TypedArrayUtils.getInt(localTypedArray, paramXmlPullParser, "fromScene", 0, -1);
    Object localObject = null;
    if (j < 0) {
      paramAttributeSet = null;
    } else {
      paramAttributeSet = Label.a(paramViewGroup, j, mContext);
    }
    j = TypedArrayUtils.getInt(localTypedArray, paramXmlPullParser, "toScene", 1, -1);
    if (j < 0) {
      paramXmlPullParser = localObject;
    } else {
      paramXmlPullParser = Label.a(paramViewGroup, j, mContext);
    }
    if (i >= 0)
    {
      paramViewGroup = inflate(i);
      if (paramViewGroup != null) {
        if (paramXmlPullParser != null)
        {
          if (paramAttributeSet == null) {
            paramClassWriter.get(paramXmlPullParser, paramViewGroup);
          } else {
            paramClassWriter.put(paramAttributeSet, paramXmlPullParser, paramViewGroup);
          }
        }
        else {
          throw new RuntimeException(f.sufficientlysecure.rootcommands.util.StringBuilder.toString("No toScene for transition ID ", i));
        }
      }
    }
    localTypedArray.recycle();
  }
  
  private void init(XmlPullParser paramXmlPullParser, AttributeSet paramAttributeSet, Transition paramTransition)
    throws XmlPullParserException, IOException
  {
    int i = paramXmlPullParser.getDepth();
    for (;;)
    {
      int j = paramXmlPullParser.next();
      if (((j == 3) && (paramXmlPullParser.getDepth() <= i)) || (j == 1)) {
        return;
      }
      if (j == 2) {
        if (paramXmlPullParser.getName().equals("target"))
        {
          TypedArray localTypedArray = mContext.obtainStyledAttributes(paramAttributeSet, R.styleable.SVGImageView);
          j = TypedArrayUtils.getInt(localTypedArray, paramXmlPullParser, "targetId", 1, 0);
          Object localObject;
          String str;
          if (j != 0)
          {
            paramTransition.addTarget(j);
          }
          else
          {
            j = TypedArrayUtils.getInt(localTypedArray, paramXmlPullParser, "excludeId", 2, 0);
            if (j != 0)
            {
              paramTransition.excludeTarget(j, true);
            }
            else
            {
              localObject = TypedArrayUtils.getValue(localTypedArray, paramXmlPullParser, "targetName", 4);
              if (localObject != null)
              {
                paramTransition.addTarget((String)localObject);
              }
              else
              {
                localObject = TypedArrayUtils.getValue(localTypedArray, paramXmlPullParser, "excludeName", 5);
                if (localObject != null)
                {
                  paramTransition.excludeTarget((String)localObject, true);
                }
                else
                {
                  str = TypedArrayUtils.getValue(localTypedArray, paramXmlPullParser, "excludeClass", 3);
                  localObject = str;
                  if (str == null) {}
                }
              }
            }
          }
          try
          {
            paramTransition.excludeTarget(Class.forName(str), true);
            break label248;
            str = TypedArrayUtils.getValue(localTypedArray, paramXmlPullParser, "targetClass", 0);
            localObject = str;
            if (str != null) {
              paramTransition.addTarget(Class.forName(str));
            }
            label248:
            localTypedArray.recycle();
          }
          catch (ClassNotFoundException paramXmlPullParser)
          {
            localTypedArray.recycle();
            throw new RuntimeException(f.sufficientlysecure.rootcommands.util.StringBuilder.toString("Could not create ", (String)localObject), paramXmlPullParser);
          }
        }
      }
    }
    paramAttributeSet = f.sufficientlysecure.rootcommands.util.StringBuilder.append("Unknown scene name: ");
    paramAttributeSet.append(paramXmlPullParser.getName());
    throw new RuntimeException(paramAttributeSet.toString());
  }
  
  public Transition inflate(int paramInt)
  {
    XmlResourceParser localXmlResourceParser = mContext.getResources().getXml(paramInt);
    try
    {
      Transition localTransition = inflate(localXmlResourceParser, Xml.asAttributeSet(localXmlResourceParser), null);
      localXmlResourceParser.close();
      return localTransition;
    }
    catch (Throwable localThrowable) {}catch (IOException localIOException)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(localXmlResourceParser.getPositionDescription());
      localStringBuilder.append(": ");
      localStringBuilder.append(localIOException.getMessage());
      throw new InflateException(localStringBuilder.toString(), localIOException);
    }
    catch (XmlPullParserException localXmlPullParserException)
    {
      throw new InflateException(localXmlPullParserException.getMessage(), localXmlPullParserException);
    }
    localXmlResourceParser.close();
    throw localXmlPullParserException;
  }
  
  public ClassWriter inflate(int paramInt, ViewGroup paramViewGroup)
  {
    XmlResourceParser localXmlResourceParser = mContext.getResources().getXml(paramInt);
    try
    {
      paramViewGroup = inflate(localXmlResourceParser, Xml.asAttributeSet(localXmlResourceParser), paramViewGroup);
      localXmlResourceParser.close();
      return paramViewGroup;
    }
    catch (Throwable paramViewGroup) {}catch (IOException paramViewGroup)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(localXmlResourceParser.getPositionDescription());
      ((StringBuilder)localObject).append(": ");
      ((StringBuilder)localObject).append(paramViewGroup.getMessage());
      localObject = new InflateException(((StringBuilder)localObject).toString());
      ((Exception)localObject).initCause(paramViewGroup);
      throw ((Throwable)localObject);
    }
    catch (XmlPullParserException paramViewGroup)
    {
      Object localObject = new InflateException(paramViewGroup.getMessage());
      ((Exception)localObject).initCause(paramViewGroup);
      throw ((Throwable)localObject);
    }
    localXmlResourceParser.close();
    throw paramViewGroup;
  }
}
