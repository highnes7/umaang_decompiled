package support.android.graphics.drawable;

import android.animation.TypeEvaluator;
import b.b.a.N;
import f.sufficientlysecure.rootcommands.util.StringBuilder;

@N({b.b.a.N.a.b})
public class Type
  implements TypeEvaluator
{
  public static final Type LONG_TYPE = new Type();
  
  public Type() {}
  
  public static Type a()
  {
    return LONG_TYPE;
  }
  
  public Object evaluate(float paramFloat, Object paramObject1, Object paramObject2)
  {
    int i = ((Integer)paramObject1).intValue();
    float f1 = (i >> 24 & 0xFF) / 255.0F;
    float f3 = (i >> 16 & 0xFF) / 255.0F;
    float f4 = (i >> 8 & 0xFF) / 255.0F;
    float f5 = (i & 0xFF) / 255.0F;
    i = ((Integer)paramObject2).intValue();
    float f2 = (i >> 24 & 0xFF) / 255.0F;
    float f8 = (i >> 16 & 0xFF) / 255.0F;
    float f7 = (i >> 8 & 0xFF) / 255.0F;
    float f6 = (i & 0xFF) / 255.0F;
    f3 = (float)Math.pow(f3, 2.2D);
    f4 = (float)Math.pow(f4, 2.2D);
    f5 = (float)Math.pow(f5, 2.2D);
    f8 = (float)Math.pow(f8, 2.2D);
    f7 = (float)Math.pow(f7, 2.2D);
    f6 = (float)Math.pow(f6, 2.2D);
    f1 = StringBuilder.append(f2, f1, paramFloat, f1);
    f2 = StringBuilder.append(f8, f3, paramFloat, f3);
    f3 = StringBuilder.append(f7, f4, paramFloat, f4);
    paramFloat = StringBuilder.append(f6, f5, paramFloat, f5);
    f2 = (float)Math.pow(f2, 0.45454545454545453D);
    f3 = (float)Math.pow(f3, 0.45454545454545453D);
    paramFloat = (float)Math.pow(paramFloat, 0.45454545454545453D);
    i = Math.round(f1 * 255.0F);
    int j = Math.round(f2 * 255.0F);
    int k = Math.round(f3 * 255.0F);
    return Integer.valueOf(Math.round(paramFloat * 255.0F) | j << 16 | i << 24 | k << 8);
  }
}
