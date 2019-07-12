package support.android.v4.media.session;

import android.view.Menu;
import b.b.a.N;

@N({b.b.a.N.a.b})
public abstract interface SupportMenu
  extends Menu
{
  public static final int ACCESS_LEVEL_NONE = 0;
  public static final int CATEGORY_MASK = -65536;
  public static final int CATEGORY_SHIFT = 16;
  public static final int USER_MASK = 65535;
  public static final int USER_SHIFT = 4;
  public static final int voice_input = 69647;
  
  public abstract void setGroupDividerEnabled(boolean paramBoolean);
}
