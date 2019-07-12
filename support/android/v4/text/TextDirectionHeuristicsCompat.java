package support.android.v4.text;

import java.nio.CharBuffer;
import java.util.Locale;

public final class TextDirectionHeuristicsCompat
{
  public static final TextDirectionHeuristicCompat ANYRTL_LTR = new TextDirectionHeuristicInternal(AnyStrong.INSTANCE_RTL, false);
  public static final TextDirectionHeuristicCompat FIRSTSTRONG_LTR;
  public static final TextDirectionHeuristicCompat FIRSTSTRONG_RTL;
  public static final TextDirectionHeuristicCompat LOCALE = TextDirectionHeuristicLocale.INSTANCE;
  public static final TextDirectionHeuristicCompat LTR = new TextDirectionHeuristicInternal(null, false);
  public static final TextDirectionHeuristicCompat RTL = new TextDirectionHeuristicInternal(null, true);
  public static final int STATE_FALSE = 1;
  public static final int STATE_TRUE = 0;
  public static final int STATE_UNKNOWN = 2;
  
  static
  {
    FIRSTSTRONG_LTR = new TextDirectionHeuristicInternal(FirstStrong.INSTANCE, false);
    FIRSTSTRONG_RTL = new TextDirectionHeuristicInternal(FirstStrong.INSTANCE, true);
  }
  
  public TextDirectionHeuristicsCompat() {}
  
  public static int isRtlText(int paramInt)
  {
    if (paramInt != 0)
    {
      if ((paramInt != 1) && (paramInt != 2)) {
        return 2;
      }
      return 0;
    }
    return 1;
  }
  
  public static int isRtlTextOrFormat(int paramInt)
  {
    if (paramInt != 0)
    {
      if ((paramInt != 1) && (paramInt != 2)) {}
      switch (paramInt)
      {
      default: 
        return 2;
      case 16: 
      case 17: 
        return 0;
      }
    }
    return 1;
  }
  
  public class AnyStrong
    implements TextDirectionHeuristicsCompat.TextDirectionAlgorithm
  {
    public static final AnyStrong INSTANCE_LTR = new AnyStrong(false);
    public static final AnyStrong INSTANCE_RTL = new AnyStrong(true);
    public final boolean mLookForRtl;
    
    public AnyStrong()
    {
      mLookForRtl = this$1;
    }
    
    public int checkRtl(CharSequence paramCharSequence, int paramInt1, int paramInt2)
    {
      throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.e1expr(TypeTransformer.java:496)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:713)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\n");
    }
  }
  
  public class FirstStrong
    implements TextDirectionHeuristicsCompat.TextDirectionAlgorithm
  {
    public static final FirstStrong INSTANCE = new FirstStrong();
    
    public FirstStrong() {}
    
    public int checkRtl(CharSequence paramCharSequence, int paramInt1, int paramInt2)
    {
      int j = 2;
      int i = paramInt1;
      while ((i < paramInt2 + paramInt1) && (j == 2))
      {
        j = TextDirectionHeuristicsCompat.isRtlTextOrFormat(Character.getDirectionality(paramCharSequence.charAt(i)));
        i += 1;
      }
      return j;
    }
  }
  
  public abstract interface TextDirectionAlgorithm
  {
    public abstract int checkRtl(CharSequence paramCharSequence, int paramInt1, int paramInt2);
  }
  
  public abstract class TextDirectionHeuristicImpl
    implements TextDirectionHeuristicCompat
  {
    public TextDirectionHeuristicImpl() {}
    
    private boolean doCheck(CharSequence paramCharSequence, int paramInt1, int paramInt2)
    {
      paramInt1 = checkRtl(paramCharSequence, paramInt1, paramInt2);
      if (paramInt1 != 0)
      {
        if (paramInt1 != 1) {
          return defaultIsRtl();
        }
        return false;
      }
      return true;
    }
    
    public abstract boolean defaultIsRtl();
    
    public boolean isRtl(CharSequence paramCharSequence, int paramInt1, int paramInt2)
    {
      if ((paramCharSequence != null) && (paramInt1 >= 0) && (paramInt2 >= 0) && (paramCharSequence.length() - paramInt2 >= paramInt1))
      {
        if (TextDirectionHeuristicsCompat.this == null) {
          return defaultIsRtl();
        }
        return doCheck(paramCharSequence, paramInt1, paramInt2);
      }
      throw new IllegalArgumentException();
    }
    
    public boolean isRtl(char[] paramArrayOfChar, int paramInt1, int paramInt2)
    {
      return isRtl(CharBuffer.wrap(paramArrayOfChar), paramInt1, paramInt2);
    }
  }
  
  public class TextDirectionHeuristicInternal
    extends TextDirectionHeuristicsCompat.TextDirectionHeuristicImpl
  {
    public final boolean mDefaultIsRtl;
    
    public TextDirectionHeuristicInternal(boolean paramBoolean)
    {
      super();
      mDefaultIsRtl = paramBoolean;
    }
    
    public boolean defaultIsRtl()
    {
      return mDefaultIsRtl;
    }
  }
  
  public class TextDirectionHeuristicLocale
    extends TextDirectionHeuristicsCompat.TextDirectionHeuristicImpl
  {
    public static final TextDirectionHeuristicLocale INSTANCE = new TextDirectionHeuristicLocale();
    
    public TextDirectionHeuristicLocale()
    {
      super();
    }
    
    public boolean defaultIsRtl()
    {
      return TextUtilsCompat.getLayoutDirectionFromLocale(Locale.getDefault()) == 1;
    }
  }
}
