package support.android.v4.text;

import java.util.Locale;

public final class Attribute
{
  public TextDirectionHeuristicCompat b;
  public boolean c;
  public int d;
  
  public Attribute()
  {
    b(BidiFormatter.getLayoutDirectionFromLocale(Locale.getDefault()));
  }
  
  public Attribute(Locale paramLocale)
  {
    b(BidiFormatter.getLayoutDirectionFromLocale(paramLocale));
  }
  
  public Attribute(boolean paramBoolean)
  {
    c = paramBoolean;
    b = BidiFormatter.b;
    d = 2;
  }
  
  private void b(boolean paramBoolean)
  {
    c = paramBoolean;
    b = BidiFormatter.b;
    d = 2;
  }
  
  public static BidiFormatter getInstance(boolean paramBoolean)
  {
    if (paramBoolean) {
      return BidiFormatter.DEFAULT_RTL_INSTANCE;
    }
    return BidiFormatter.DEFAULT_LTR_INSTANCE;
  }
  
  public Attribute a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      d |= 0x2;
      return this;
    }
    d &= 0xFFFFFFFD;
    return this;
  }
  
  public BidiFormatter read()
  {
    if ((d == 2) && (b == BidiFormatter.b)) {
      return getInstance(c);
    }
    return new BidiFormatter(c, d, b);
  }
  
  public Attribute setValue(TextDirectionHeuristicCompat paramTextDirectionHeuristicCompat)
  {
    b = paramTextDirectionHeuristicCompat;
    return this;
  }
}
