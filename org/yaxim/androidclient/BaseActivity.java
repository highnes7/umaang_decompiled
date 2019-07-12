package org.yaxim.androidclient;

import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AlertDialog.Builder;
import android.support.v7.app.AppCompatActivity;
import android.view.ContextThemeWrapper;
import f.libs.asm.b;
import in.spicedigital.umang.application.MyApplication;
import java.util.concurrent.Executor;
import k.a.a.i.List;
import k.a.a.l.a;
import k.a.a.m.Config;
import k.a.a.m.Log;
import k.a.a.m.N;
import k.a.a.m.StringBuilder;
import k.a.a.m.f;
import org.json.JSONObject;

public class BaseActivity
  extends AppCompatActivity
{
  public final String packageName = "BaseActivity";
  public f pref;
  
  public BaseActivity() {}
  
  private void initiateKeys(Context paramContext)
  {
    try
    {
      N.a(this, "umang_al_n");
      paramContext = new f(paramContext);
      String str = f.l;
      boolean bool = paramContext.add(str, "").equalsIgnoreCase("");
      if (!bool)
      {
        str = MyApplication.s;
        bool = str.equalsIgnoreCase("");
        if (bool)
        {
          str = f.INTEGER;
          str = N.a("umang_al_n", paramContext.add(str, ""));
          MyApplication.s = str;
          str = f.LONG;
          str = N.a("umang_al_n", paramContext.add(str, ""));
          MyApplication.c = str;
          str = f.Q;
          str = N.a("umang_al_n", paramContext.add(str, ""));
          MyApplication.t = str;
          str = f.H;
          str = N.a("umang_al_n", paramContext.add(str, ""));
          MyApplication.g = str;
          str = f.E;
          str = N.a("umang_al_n", paramContext.add(str, ""));
          MyApplication.q = str;
          str = f.F;
          str = N.a("umang_al_n", paramContext.add(str, ""));
          MyApplication.m = str;
          str = f.V;
          str = N.a("umang_al_n", paramContext.add(str, ""));
          MyApplication.b = str;
          str = f.l;
          str = N.a("umang_al_n", paramContext.add(str, ""));
          MyApplication.f = str;
          str = f.FLOAT;
          str = N.a("umang_al_n", paramContext.add(str, ""));
          MyApplication.a = str;
          str = f.DOUBLE;
          str = N.a("umang_al_n", paramContext.add(str, ""));
          MyApplication.versionName = str;
          str = f.NULL;
          paramContext = N.a("umang_al_n", paramContext.add(str, ""));
          MyApplication.packageName = paramContext;
          return;
        }
      }
    }
    catch (Exception paramContext)
    {
      StringBuilder.append(paramContext);
      try
      {
        b.d(paramContext);
        return;
      }
      catch (Exception paramContext)
      {
        StringBuilder.append(paramContext);
      }
    }
  }
  
  private void sendAuthRequest()
  {
    Object localObject3;
    Object localObject2;
    try
    {
      localObject3 = Log.execute(this);
      Object localObject1 = localObject3;
      ((JSONObject)localObject3).put("khash", Log.doInBackground(this));
      ((JSONObject)localObject3).put("rType", "key");
    }
    catch (Exception localException)
    {
      StringBuilder.append(localException);
      localObject2 = null;
    }
    if (localObject2 != null)
    {
      localObject2 = new a((List)new BaseActivity.1(this), "https://app.umang.gov.in/umang/coreapi/opn/ws2/skey", (JSONObject)localObject2, this);
      localObject3 = AsyncTask.THREAD_POOL_EXECUTOR;
      ((AsyncTask)localObject2).executeOnExecutor((Executor)localObject3, new Object[0]);
    }
  }
  
  private void showError(Throwable paramThrowable)
  {
    StringBuilder.e(paramThrowable);
    new AlertDialog.Builder(this).setMessage(paramThrowable.getMessage()).setPositiveButton(17039370, (DialogInterface.OnClickListener)new BaseActivity.2(this)).show();
  }
  
  public void attachBaseContext(Context paramContext)
  {
    super.attachBaseContext(Config.init(paramContext));
  }
  
  public void onAttachedToWindow()
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:659)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\n");
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    pref = new f(this);
    initiateKeys(this);
    if ((!pref.add(f.l, "").equalsIgnoreCase("")) && (MyApplication.s.equalsIgnoreCase(""))) {
      sendAuthRequest();
    }
  }
}
