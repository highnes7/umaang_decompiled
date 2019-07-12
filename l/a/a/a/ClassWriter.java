package l.a.a.a;

import l.a.a.a.a.b.ECPoint;
import l.a.a.a.a.c.ModernAsyncTask;
import l.a.a.a.a.c.Request.Priority;
import l.a.a.a.a.c.UnsupportedDataException;
import l.a.a.a.a.c.m;

public class ClassWriter<Result>
  extends m<Void, Void, Result>
{
  public static final String threshold = "KitInitialization";
  public final n<Result> h;
  
  public ClassWriter(Item paramItem)
  {
    h = paramItem;
  }
  
  private ECPoint get(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(h.getId());
    localStringBuilder.append(".");
    localStringBuilder.append(paramString);
    paramString = new ECPoint(localStringBuilder.toString(), "KitInitialization");
    paramString.assertECMultiplier();
    return paramString;
  }
  
  public void a(Object paramObject)
  {
    h.post(paramObject);
    paramObject = new StringBuilder();
    paramObject.append(h.getId());
    paramObject.append(" Initialization was cancelled");
    paramObject = new j(paramObject.toString());
    h.a.a(paramObject);
  }
  
  public void c(Object paramObject)
  {
    h.a(paramObject);
    h.a.a(paramObject);
  }
  
  public Object execute(Void... paramVarArgs)
  {
    ECPoint localECPoint = get("doInBackground");
    if (!isCancelled()) {
      paramVarArgs = h.run();
    } else {
      paramVarArgs = null;
    }
    localECPoint.add();
    return paramVarArgs;
  }
  
  public void execute()
  {
    ECPoint localECPoint = get("onPreExecute");
    Item localItem = h;
    try
    {
      boolean bool = localItem.onCreate();
      localECPoint.add();
      if (bool) {
        break label57;
      }
    }
    catch (Throwable localThrowable) {}catch (Exception localException)
    {
      for (;;)
      {
        f.get().d("Fabric", "Failure onPreExecute()", localException);
        localECPoint.add();
      }
      return;
    }
    catch (UnsupportedDataException localUnsupportedDataException)
    {
      throw localUnsupportedDataException;
    }
    cancel(true);
    return;
    label57:
    localECPoint.add();
    cancel(true);
    throw localUnsupportedDataException;
  }
  
  public Request.Priority getPriority()
  {
    return Request.Priority.NORMAL;
  }
}
