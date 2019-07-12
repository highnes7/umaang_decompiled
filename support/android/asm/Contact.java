package support.android.asm;

import android.support.transition.ChangeTransform.b;
import android.util.Property;

public final class Contact
  extends Property<ChangeTransform.b, float[]>
{
  public Contact(Class paramClass, String paramString)
  {
    super(paramClass, paramString);
  }
  
  public float[] get(ChangeTransform.b paramB)
  {
    return null;
  }
  
  public void setValue(ChangeTransform.b paramB, float[] paramArrayOfFloat)
  {
    paramB.visitFrame(paramArrayOfFloat);
  }
}
