package f.libs.asm.menu;

import android.os.Bundle;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import l.a.a.a.Log;
import l.a.a.a.f;

public class ResponseProxyHandler
  implements InvocationHandler
{
  public ResponseProxyHandler(l paramL) {}
  
  public Object invoke(Object paramObject, Method paramMethod, Object[] paramArrayOfObject)
  {
    String str = paramMethod.getName();
    int i = 0;
    paramMethod = paramArrayOfObject;
    if (paramArrayOfObject == null) {
      paramMethod = new Object[0];
    }
    if ((paramMethod.length == 1) && (str.equals("equals"))) {
      return Boolean.valueOf(invoke(paramObject, paramMethod[0]));
    }
    if ((paramMethod.length == 0) && (str.equals("hashCode"))) {
      return Integer.valueOf(super.hashCode());
    }
    if ((paramMethod.length == 0) && (str.equals("toString"))) {
      return super.toString();
    }
    if ((paramMethod.length == 4) && (str.equals("onEvent")) && (l.a(paramMethod)))
    {
      paramObject = (String)paramMethod[0];
      paramArrayOfObject = (String)paramMethod[1];
      Bundle localBundle = (Bundle)paramMethod[2];
      if ((paramObject != null) && (!paramObject.equals("crash")))
      {
        l.b(l.a(f), paramArrayOfObject, localBundle);
        return null;
      }
    }
    paramObject = new StringBuilder(f.sufficientlysecure.rootcommands.util.StringBuilder.append("Unexpected method invoked on AppMeasurement.EventListener: ", str, "("));
    while (i < paramMethod.length)
    {
      if (i > 0) {
        paramObject.append(", ");
      }
      paramObject.append(paramMethod[i].getClass().getName());
      i += 1;
    }
    paramObject.append("); returning null");
    f.get().e("CrashlyticsCore", paramObject.toString());
    return null;
  }
  
  public boolean invoke(Object paramObject1, Object paramObject2)
  {
    if (paramObject1 == paramObject2) {
      return true;
    }
    return (paramObject2 != null) && (Proxy.isProxyClass(paramObject2.getClass())) && (super.equals(Proxy.getInvocationHandler(paramObject2)));
  }
}
