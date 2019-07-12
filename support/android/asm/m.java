package support.android.asm;

import android.support.transition.Transition;
import android.support.transition.Transition.e;
import java.util.ArrayList;

public class m
  implements Transition.e
{
  public m(ASN1Integer paramASN1Integer, Object paramObject1, ArrayList paramArrayList1, Object paramObject2, ArrayList paramArrayList2, Object paramObject3, ArrayList paramArrayList3) {}
  
  public void a(Transition paramTransition) {}
  
  public void b(Transition paramTransition) {}
  
  public void c(Transition paramTransition) {}
  
  public void d(Transition paramTransition) {}
  
  public void e(Transition paramTransition)
  {
    paramTransition = t;
    if (paramTransition != null) {
      g.replaceTargets(paramTransition, r, null);
    }
    paramTransition = c;
    if (paramTransition != null) {
      g.replaceTargets(paramTransition, b, null);
    }
    paramTransition = e;
    if (paramTransition != null) {
      g.replaceTargets(paramTransition, n, null);
    }
  }
}
