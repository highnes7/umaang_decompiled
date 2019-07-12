package support.android.asm;

import android.support.transition.Transition;
import android.view.ViewGroup;

public abstract class Attribute
{
  public Attribute() {}
  
  public abstract long a(ViewGroup paramViewGroup, Transition paramTransition, Edit paramEdit1, Edit paramEdit2);
  
  public abstract void a(Edit paramEdit);
  
  public abstract String[] a();
}
