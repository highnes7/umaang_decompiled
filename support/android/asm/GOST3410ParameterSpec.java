package support.android.asm;

import android.view.View;
import android.view.WindowId;
import b.b.a.K;

@K(18)
public class GOST3410ParameterSpec
  implements Object
{
  public final WindowId digestParamSetOID;
  
  public GOST3410ParameterSpec(View paramView)
  {
    digestParamSetOID = paramView.getWindowId();
  }
  
  public boolean equals(java.lang.Object paramObject)
  {
    return ((paramObject instanceof GOST3410ParameterSpec)) && (digestParamSetOID.equals(digestParamSetOID));
  }
  
  public int hashCode()
  {
    return digestParamSetOID.hashCode();
  }
}
