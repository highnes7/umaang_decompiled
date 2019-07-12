package support.android.asm;

import android.view.View;
import java.util.Map;

public abstract class XYPlot
  extends Attribute
{
  public static final String A = "android:visibilityPropagation:center";
  public static final String F = "android:visibilityPropagation:visibility";
  public static final String[] c = { "android:visibilityPropagation:visibility", "android:visibilityPropagation:center" };
  
  public XYPlot() {}
  
  public static int a(Edit paramEdit, int paramInt)
  {
    if (paramEdit == null) {
      return -1;
    }
    paramEdit = (int[])values.get("android:visibilityPropagation:center");
    if (paramEdit == null) {
      return -1;
    }
    return paramEdit[paramInt];
  }
  
  public void a(Edit paramEdit)
  {
    View localView = view;
    Integer localInteger = (Integer)values.get("android:visibility:visibility");
    Object localObject = localInteger;
    if (localInteger == null) {
      localObject = Integer.valueOf(localView.getVisibility());
    }
    values.put("android:visibilityPropagation:visibility", localObject);
    localObject = new int[2];
    localView.getLocationOnScreen((int[])localObject);
    int i = localObject[0];
    localObject[0] = (Math.round(localView.getTranslationX()) + i);
    i = localObject[0];
    localObject[0] = (localView.getWidth() / 2 + i);
    i = localObject[1];
    localObject[1] = (Math.round(localView.getTranslationY()) + i);
    i = localObject[1];
    localObject[1] = (localView.getHeight() / 2 + i);
    values.put("android:visibilityPropagation:center", localObject);
  }
  
  public String[] a()
  {
    return c;
  }
  
  public int b(Edit paramEdit)
  {
    if (paramEdit == null) {
      return 8;
    }
    paramEdit = (Integer)values.get("android:visibilityPropagation:visibility");
    if (paramEdit == null) {
      return 8;
    }
    return paramEdit.intValue();
  }
  
  public int c(Edit paramEdit)
  {
    return a(paramEdit, 1);
  }
  
  public int d(Edit paramEdit)
  {
    return a(paramEdit, 0);
  }
}
