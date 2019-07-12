package support.android.v4.internal;

import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Build.VERSION;
import b.b.x.n.p;
import support.android.v4.util.Type;

public final class l
{
  public static final ThreadLocal<p<Rect, Rect>> d = new ThreadLocal();
  public static final String e = "?";
  public static final String m = "m";
  
  public l() {}
  
  public static Type a()
  {
    Type localType = (Type)d.get();
    if (localType == null)
    {
      localType = new Type(new Rect(), new Rect());
      d.set(localType);
      return localType;
    }
    ((Rect)c).setEmpty();
    ((Rect)b).setEmpty();
    return localType;
  }
  
  public static boolean draw(Paint paramPaint, String paramString)
  {
    if (Build.VERSION.SDK_INT >= 23) {
      return paramPaint.hasGlyph(paramString);
    }
    int k = paramString.length();
    if ((k == 1) && (Character.isWhitespace(paramString.charAt(0)))) {
      return true;
    }
    float f2 = paramPaint.measureText("?");
    float f4 = paramPaint.measureText("m");
    float f3 = paramPaint.measureText(paramString);
    float f1 = 0.0F;
    if (f3 == 0.0F) {
      return false;
    }
    if (paramString.codePointCount(0, paramString.length()) > 1)
    {
      if (f3 > f4 * 2.0F) {
        return false;
      }
      int j;
      for (int i = 0; i < k; i = j)
      {
        j = Character.charCount(paramString.codePointAt(i)) + i;
        f1 += paramPaint.measureText(paramString, i, j);
      }
      if (f3 >= f1) {
        return false;
      }
    }
    if (f3 != f2) {
      return true;
    }
    Type localType = a();
    paramPaint.getTextBounds("?", 0, 2, (Rect)c);
    paramPaint.getTextBounds(paramString, 0, k, (Rect)b);
    return ((Rect)c).equals(b) ^ true;
  }
}
