package support.android.v4.text;

import android.text.SpannableStringBuilder;
import java.util.Locale;

public final class BidiFormatter
{
  public static final int DEFAULT_FLAGS = 2;
  public static final BidiFormatter DEFAULT_LTR_INSTANCE = new BidiFormatter(false, 2, b);
  public static final BidiFormatter DEFAULT_RTL_INSTANCE = new BidiFormatter(true, 2, b);
  public static final int DIR_LTR = -1;
  public static final int DIR_RTL = 1;
  public static final int DIR_UNKNOWN = 0;
  public static final String EMPTY_STRING = "";
  public static final int FLAG_STEREO_RESET = 2;
  public static final char LRE = '?';
  public static final char LRM = '?';
  public static final String LRM_STRING;
  public static final char PDF = '?';
  public static final char RLE = '?';
  public static final char RLM = '?';
  public static final String RLM_STRING;
  public static final TextDirectionHeuristicCompat b = TextDirectionHeuristicsCompat.FIRSTSTRONG_LTR;
  public final TextDirectionHeuristicCompat mDefaultTextDirectionHeuristicCompat;
  public final int mFlags;
  public final boolean mIsRtlContext;
  
  static
  {
    LRM_STRING = Character.toString('?');
    RLM_STRING = Character.toString('?');
  }
  
  public BidiFormatter(boolean paramBoolean, int paramInt, TextDirectionHeuristicCompat paramTextDirectionHeuristicCompat)
  {
    mIsRtlContext = paramBoolean;
    mFlags = paramInt;
    mDefaultTextDirectionHeuristicCompat = paramTextDirectionHeuristicCompat;
  }
  
  public static BidiFormatter build(boolean paramBoolean)
  {
    TextDirectionHeuristicCompat localTextDirectionHeuristicCompat = b;
    if (localTextDirectionHeuristicCompat == b) {
      return Attribute.getInstance(paramBoolean);
    }
    return new BidiFormatter(paramBoolean, 2, localTextDirectionHeuristicCompat);
  }
  
  public static int getEntryDir(CharSequence paramCharSequence)
  {
    return new DirectionalityEstimator(false).getEntryDir();
  }
  
  public static int getExitDir(CharSequence paramCharSequence)
  {
    return new DirectionalityEstimator(false).getExitDir();
  }
  
  public static BidiFormatter getInstance()
  {
    return new Attribute().read();
  }
  
  public static BidiFormatter getInstance(Locale paramLocale)
  {
    return new Attribute(paramLocale).read();
  }
  
  public static boolean getLayoutDirectionFromLocale(Locale paramLocale)
  {
    return TextUtilsCompat.getLayoutDirectionFromLocale(paramLocale) == 1;
  }
  
  private String markAfter(CharSequence paramCharSequence, TextDirectionHeuristicCompat paramTextDirectionHeuristicCompat)
  {
    boolean bool = paramTextDirectionHeuristicCompat.isRtl(paramCharSequence, 0, paramCharSequence.length());
    if ((!mIsRtlContext) && ((bool) || (getExitDir(paramCharSequence) == 1))) {
      return LRM_STRING;
    }
    if ((mIsRtlContext) && ((!bool) || (getExitDir(paramCharSequence) == -1))) {
      return RLM_STRING;
    }
    return "";
  }
  
  private String markBefore(CharSequence paramCharSequence, TextDirectionHeuristicCompat paramTextDirectionHeuristicCompat)
  {
    boolean bool = paramTextDirectionHeuristicCompat.isRtl(paramCharSequence, 0, paramCharSequence.length());
    if ((!mIsRtlContext) && ((bool) || (getEntryDir(paramCharSequence) == 1))) {
      return LRM_STRING;
    }
    if ((mIsRtlContext) && ((!bool) || (getEntryDir(paramCharSequence) == -1))) {
      return RLM_STRING;
    }
    return "";
  }
  
  public CharSequence getPackageName(CharSequence paramCharSequence)
  {
    return unicodeWrap(paramCharSequence, mDefaultTextDirectionHeuristicCompat, true);
  }
  
  public boolean getStereoReset()
  {
    return (mFlags & 0x2) != 0;
  }
  
  public boolean isRtl(CharSequence paramCharSequence)
  {
    return mDefaultTextDirectionHeuristicCompat.isRtl(paramCharSequence, 0, paramCharSequence.length());
  }
  
  public boolean isRtl(String paramString)
  {
    return isRtl(paramString);
  }
  
  public boolean isRtlContext()
  {
    return mIsRtlContext;
  }
  
  public CharSequence unicodeWrap(CharSequence paramCharSequence, TextDirectionHeuristicCompat paramTextDirectionHeuristicCompat)
  {
    return unicodeWrap(paramCharSequence, paramTextDirectionHeuristicCompat, true);
  }
  
  public CharSequence unicodeWrap(CharSequence paramCharSequence, TextDirectionHeuristicCompat paramTextDirectionHeuristicCompat, boolean paramBoolean)
  {
    if (paramCharSequence == null) {
      return null;
    }
    boolean bool = paramTextDirectionHeuristicCompat.isRtl(paramCharSequence, 0, paramCharSequence.length());
    SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder();
    if ((getStereoReset()) && (paramBoolean))
    {
      if (bool) {
        paramTextDirectionHeuristicCompat = TextDirectionHeuristicsCompat.RTL;
      } else {
        paramTextDirectionHeuristicCompat = TextDirectionHeuristicsCompat.LTR;
      }
      localSpannableStringBuilder.append(markBefore(paramCharSequence, paramTextDirectionHeuristicCompat));
    }
    if (bool != mIsRtlContext)
    {
      char c;
      if (bool) {
        c = '?';
      } else {
        c = '?';
      }
      localSpannableStringBuilder.append(c);
      localSpannableStringBuilder.append(paramCharSequence);
      localSpannableStringBuilder.append('?');
    }
    else
    {
      localSpannableStringBuilder.append(paramCharSequence);
    }
    if (paramBoolean)
    {
      if (bool) {
        paramTextDirectionHeuristicCompat = TextDirectionHeuristicsCompat.RTL;
      } else {
        paramTextDirectionHeuristicCompat = TextDirectionHeuristicsCompat.LTR;
      }
      localSpannableStringBuilder.append(markAfter(paramCharSequence, paramTextDirectionHeuristicCompat));
    }
    return localSpannableStringBuilder;
  }
  
  public CharSequence unicodeWrap(CharSequence paramCharSequence, boolean paramBoolean)
  {
    return unicodeWrap(paramCharSequence, mDefaultTextDirectionHeuristicCompat, paramBoolean);
  }
  
  public String unicodeWrap(String paramString)
  {
    return unicodeWrap(paramString, mDefaultTextDirectionHeuristicCompat, true);
  }
  
  public String unicodeWrap(String paramString, TextDirectionHeuristicCompat paramTextDirectionHeuristicCompat)
  {
    return unicodeWrap(paramString, paramTextDirectionHeuristicCompat, true);
  }
  
  public String unicodeWrap(String paramString, TextDirectionHeuristicCompat paramTextDirectionHeuristicCompat, boolean paramBoolean)
  {
    if (paramString == null) {
      return null;
    }
    return unicodeWrap(paramString, paramTextDirectionHeuristicCompat, paramBoolean).toString();
  }
  
  public String unicodeWrap(String paramString, boolean paramBoolean)
  {
    return unicodeWrap(paramString, mDefaultTextDirectionHeuristicCompat, paramBoolean);
  }
  
  public class DirectionalityEstimator
  {
    public static final byte[] DIR_TYPE_CACHE = new byte['?'];
    public static final int DIR_TYPE_CACHE_SIZE = 1792;
    public int charIndex;
    public final boolean isHtml;
    public char lastChar;
    public final int length;
    
    static
    {
      int i = 0;
      while (i < 1792)
      {
        DIR_TYPE_CACHE[i] = Character.getDirectionality(i);
        i += 1;
      }
    }
    
    public DirectionalityEstimator(boolean paramBoolean)
    {
      isHtml = paramBoolean;
      length = length();
    }
    
    public static byte getCachedDirectionality(char paramChar)
    {
      if (paramChar < '?') {
        return DIR_TYPE_CACHE[paramChar];
      }
      return Character.getDirectionality(paramChar);
    }
    
    private byte skipEntityBackward()
    {
      int i = charIndex;
      int j;
      do
      {
        j = charIndex;
        if (j <= 0) {
          break;
        }
        CharSequence localCharSequence = BidiFormatter.this;
        j -= 1;
        charIndex = j;
        lastChar = localCharSequence.charAt(j);
        j = lastChar;
        if (j == 38) {
          return 12;
        }
      } while (j != 59);
      charIndex = i;
      lastChar = ';';
      return 13;
    }
    
    private byte skipEntityForward()
    {
      char c;
      do
      {
        int i = charIndex;
        if (i >= length) {
          break;
        }
        CharSequence localCharSequence = BidiFormatter.this;
        charIndex = (i + 1);
        c = localCharSequence.charAt(i);
        lastChar = c;
      } while (c != ';');
      return 12;
    }
    
    private byte skipTagBackward()
    {
      int j = charIndex;
      CharSequence localCharSequence;
      do
      {
        k = charIndex;
        if (k <= 0) {
          break;
        }
        localCharSequence = BidiFormatter.this;
        k -= 1;
        charIndex = k;
        lastChar = localCharSequence.charAt(k);
        k = lastChar;
        if (k == 60) {
          return 12;
        }
        if (k == 62) {
          break;
        }
      } while ((k != 34) && (k != 39));
      int k = lastChar;
      for (;;)
      {
        int m = charIndex;
        if (m <= 0) {
          break;
        }
        localCharSequence = BidiFormatter.this;
        m -= 1;
        charIndex = m;
        int i = localCharSequence.charAt(m);
        lastChar = i;
        if (i == k) {
          break;
        }
      }
      charIndex = j;
      lastChar = '>';
      return 13;
    }
    
    private byte skipTagForward()
    {
      int j = charIndex;
      CharSequence localCharSequence;
      do
      {
        k = charIndex;
        if (k >= length) {
          break;
        }
        localCharSequence = BidiFormatter.this;
        charIndex = (k + 1);
        lastChar = localCharSequence.charAt(k);
        k = lastChar;
        if (k == 62) {
          return 12;
        }
      } while ((k != 34) && (k != 39));
      int k = lastChar;
      for (;;)
      {
        int m = charIndex;
        if (m >= length) {
          break;
        }
        localCharSequence = BidiFormatter.this;
        charIndex = (m + 1);
        int i = localCharSequence.charAt(m);
        lastChar = i;
        if (i == k) {
          break;
        }
      }
      charIndex = j;
      lastChar = '<';
      return 13;
    }
    
    public byte dirTypeBackward()
    {
      lastChar = charAt(charIndex - 1);
      int i;
      if (Character.isLowSurrogate(lastChar))
      {
        i = Character.codePointBefore(BidiFormatter.this, charIndex);
        charIndex -= Character.charCount(i);
        return Character.getDirectionality(i);
      }
      charIndex -= 1;
      byte b2 = getCachedDirectionality(lastChar);
      byte b1 = b2;
      if (isHtml)
      {
        i = lastChar;
        if (i == 62) {
          return skipTagBackward();
        }
        b1 = b2;
        if (i == 59) {
          b1 = skipEntityBackward();
        }
      }
      return b1;
    }
    
    public byte dirTypeForward()
    {
      lastChar = charAt(charIndex);
      int i;
      if (Character.isHighSurrogate(lastChar))
      {
        i = Character.codePointAt(BidiFormatter.this, charIndex);
        int j = charIndex;
        charIndex = (Character.charCount(i) + j);
        return Character.getDirectionality(i);
      }
      charIndex += 1;
      byte b = getCachedDirectionality(lastChar);
      if (isHtml)
      {
        i = lastChar;
        if (i == 60) {
          return skipTagForward();
        }
        if (i == 38)
        {
          skipEntityForward();
          return 12;
        }
      }
      return b;
    }
    
    public int getEntryDir()
    {
      charIndex = 0;
      int k = 0;
      int j = 0;
      int i = 0;
      while ((charIndex < length) && (k == 0))
      {
        int m = dirTypeForward();
        if (m != 0)
        {
          if ((m != 1) && (m != 2))
          {
            if (m == 9) {}
          }
          else {
            switch (m)
            {
            default: 
              break;
            case 18: 
              i -= 1;
              j = 0;
              break;
            case 16: 
            case 17: 
              i += 1;
              j = 1;
              break;
            case 14: 
            case 15: 
              i += 1;
              j = -1;
              continue;
              if (i != 0) {
                break label153;
              }
              return 1;
            }
          }
        }
        else
        {
          if (i == 0) {
            return -1;
          }
          label153:
          k = i;
        }
      }
      if (k == 0) {
        return 0;
      }
      if (j != 0) {
        return j;
      }
      while (charIndex > 0) {
        switch (dirTypeBackward())
        {
        default: 
          break;
        case 18: 
          i += 1;
          break;
        case 16: 
        case 17: 
          if (k == i) {
            return 1;
          }
        case 14: 
        case 15: 
          if (k == i) {
            return -1;
          }
          i -= 1;
        }
      }
      return 0;
    }
    
    public int getExitDir()
    {
      charIndex = length;
      int j = 0;
      int i = 0;
      while (charIndex > 0)
      {
        int k = dirTypeBackward();
        if (k != 0)
        {
          if ((k != 1) && (k != 2))
          {
            if (k == 9) {}
          }
          else {
            switch (k)
            {
            default: 
              if (j != 0) {
                continue;
              }
              break;
            case 18: 
              i += 1;
              break;
            case 16: 
            case 17: 
              if (j == i) {
                return 1;
              }
            case 14: 
            case 15: 
              if (j == i) {
                return -1;
              }
              i -= 1;
              continue;
              if (i == 0) {
                return 1;
              }
              if (j != 0) {
                continue;
              }
              break;
            }
          }
        }
        else
        {
          if (i == 0) {
            return -1;
          }
          if (j == 0) {
            j = i;
          }
        }
      }
      return 0;
    }
  }
}
