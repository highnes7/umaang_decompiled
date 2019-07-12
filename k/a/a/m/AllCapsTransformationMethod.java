package k.a.a.m;

import android.graphics.Rect;
import android.text.method.TransformationMethod;
import android.view.View;

public class AllCapsTransformationMethod
  implements TransformationMethod
{
  public char mLocale = '?';
  
  public AllCapsTransformationMethod() {}
  
  public CharSequence getTransformation(CharSequence paramCharSequence, View paramView)
  {
    return (CharSequence)new J.a(this, paramCharSequence);
  }
  
  public void onFocusChanged(View paramView, CharSequence paramCharSequence, boolean paramBoolean, int paramInt, Rect paramRect) {}
}
