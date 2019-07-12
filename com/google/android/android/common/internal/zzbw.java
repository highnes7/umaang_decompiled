package com.google.android.android.common.internal;

import android.content.Context;
import android.view.View;
import com.google.android.android.dynamic.Integer;
import com.google.android.android.dynamic.InvalidPatternException;
import com.google.android.android.dynamic.LockFactory;
import com.google.android.gms.dynamic.zzp;

public final class zzbw
  extends zzp<com.google.android.gms.common.internal.zzbc>
{
  public static final zzbw zzfwe = new zzbw();
  
  public zzbw()
  {
    super("com.google.android.gms.common.ui.SignInButtonCreatorImpl");
  }
  
  public static View build(Context paramContext, int paramInt1, int paramInt2)
    throws InvalidPatternException
  {
    return zzfwe.process(paramContext, paramInt1, paramInt2);
  }
  
  private final View process(Context paramContext, int paramInt1, int paramInt2)
    throws InvalidPatternException
  {
    try
    {
      localObject = new zzbu(1, paramInt1, paramInt2, null);
      Integer localInteger = new Integer(paramContext);
      paramContext = zzcu(paramContext);
      paramContext = (zzbc)paramContext;
      paramContext = Integer.get(paramContext.getChat(localInteger, (zzbu)localObject));
      return (View)paramContext;
    }
    catch (Exception paramContext)
    {
      Object localObject = new StringBuilder(64);
      ((StringBuilder)localObject).append("Could not get button with size ");
      ((StringBuilder)localObject).append(paramInt1);
      ((StringBuilder)localObject).append(" and color ");
      ((StringBuilder)localObject).append(paramInt2);
      throw new InvalidPatternException(((StringBuilder)localObject).toString(), paramContext);
    }
  }
}
