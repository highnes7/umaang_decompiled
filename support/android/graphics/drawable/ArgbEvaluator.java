package support.android.graphics.drawable;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.Resources.NotFoundException;
import android.content.res.Resources.Theme;
import android.content.res.XmlResourceParser;
import android.os.Build.VERSION;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import b.b.a.N;
import java.io.IOException;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import support.android.v4.view.animation.FastOutLinearInInterpolator;
import support.android.v4.view.animation.FastOutSlowInInterpolator;
import support.android.v4.view.animation.LinearOutSlowInInterpolator;

@N({b.b.a.N.a.b})
public class ArgbEvaluator
{
  public ArgbEvaluator() {}
  
  public static Interpolator createFromXml(Context paramContext, Resources paramResources, Resources.Theme paramTheme, XmlPullParser paramXmlPullParser)
    throws XmlPullParserException, IOException
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: fail exe a11 = a10\n\tat com.googlecode.dex2jar.ir.ts.an.BaseAnalyze.exec(BaseAnalyze.java:92)\n\tat com.googlecode.dex2jar.ir.ts.an.BaseAnalyze.exec(BaseAnalyze.java:1)\n\tat com.googlecode.dex2jar.ir.ts.Cfg.dfs(Cfg.java:255)\n\tat com.googlecode.dex2jar.ir.ts.an.BaseAnalyze.analyze0(BaseAnalyze.java:75)\n\tat com.googlecode.dex2jar.ir.ts.an.BaseAnalyze.analyze(BaseAnalyze.java:69)\n\tat com.googlecode.dex2jar.ir.ts.UnSSATransformer.transform(UnSSATransformer.java:274)\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:163)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\nCaused by: java.lang.NullPointerException\n");
  }
  
  public static Interpolator loadAnimator(Context paramContext, int paramInt)
    throws Resources.NotFoundException
  {
    if (Build.VERSION.SDK_INT >= 21) {
      return AnimationUtils.loadInterpolator(paramContext, paramInt);
    }
    Object localObject3 = null;
    Object localObject2 = null;
    Object localObject1 = null;
    if (paramInt == 17563663)
    {
      try
      {
        paramContext = new FastOutSlowInInterpolator();
        return paramContext;
      }
      catch (Throwable paramContext)
      {
        break label248;
      }
      catch (IOException paramContext)
      {
        break label123;
      }
      catch (XmlPullParserException paramContext) {}
    }
    else
    {
      if (paramInt == 17563661)
      {
        paramContext = new FastOutLinearInInterpolator();
        return paramContext;
      }
      if (paramInt == 17563662)
      {
        paramContext = new LinearOutSlowInInterpolator();
        return paramContext;
      }
      XmlResourceParser localXmlResourceParser = paramContext.getResources().getAnimation(paramInt);
      localObject2 = localXmlResourceParser;
      localObject1 = localObject2;
      localObject3 = localObject2;
      paramContext = createFromXml(paramContext, paramContext.getResources(), paramContext.getTheme(), localXmlResourceParser);
      localXmlResourceParser.close();
      return paramContext;
    }
    label123:
    localObject1 = localObject3;
    localObject2 = new StringBuilder();
    localObject1 = localObject3;
    ((StringBuilder)localObject2).append("Can't load animation resource ID #0x");
    localObject1 = localObject3;
    ((StringBuilder)localObject2).append(Integer.toHexString(paramInt));
    localObject1 = localObject3;
    localObject2 = new Resources.NotFoundException(((StringBuilder)localObject2).toString());
    localObject1 = localObject3;
    ((Exception)localObject2).initCause(paramContext);
    localObject1 = localObject3;
    throw ((Throwable)localObject2);
    localObject1 = localObject2;
    localObject3 = new StringBuilder();
    localObject1 = localObject2;
    ((StringBuilder)localObject3).append("Can't load animation resource ID #0x");
    localObject1 = localObject2;
    ((StringBuilder)localObject3).append(Integer.toHexString(paramInt));
    localObject1 = localObject2;
    localObject3 = new Resources.NotFoundException(((StringBuilder)localObject3).toString());
    localObject1 = localObject2;
    ((Exception)localObject3).initCause(paramContext);
    localObject1 = localObject2;
    throw ((Throwable)localObject3);
    label248:
    if (localObject1 != null) {
      localObject1.close();
    }
    throw paramContext;
  }
}
