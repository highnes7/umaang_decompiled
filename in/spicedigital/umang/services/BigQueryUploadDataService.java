package in.spicedigital.umang.services;

import android.app.IntentService;
import android.content.Context;
import android.content.Intent;
import android.content.res.AssetManager;
import f.g.org.jivesoftware.initializer.Logger;
import f.g.org.jivesoftware.initializer.core.AbstractNode;
import f.g.org.jivesoftware.initializer.core.GenericData;
import f.g.org.jivesoftware.initializer.core.Protos.UpdatePayment.Builder;
import f.g.org.jivesoftware.initializer.core.Token;
import f.g.org.jivesoftware.initializer.h;
import f.g.org.org.http.AnnotationVisitor;
import f.g.org.org.http.HttpTransport;
import f.g.org.org.http.parse.NetHttpTransport;
import f.g.org.org.org.internal.Element;
import f.g.org.org.org.objectweb.asm.Item;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.GeneralSecurityException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import k.a.a.c.i;
import k.a.a.m.Log;

public class BigQueryUploadDataService
  extends IntentService
{
  public static final HttpTransport INSTANCE = new NetHttpTransport(null, null, null);
  public static final f.g.org.org.stream.JsonFactory UTF_8 = new f.g.org.org.stream.util.JsonFactory();
  public static final List<String> context = Arrays.asList(new String[] { "https://www.googleapis.com/auth/bigquery" });
  public final String SAVEFILE = "BigQueryUploadService";
  
  public BigQueryUploadDataService()
  {
    super("BigQueryUploadDataService");
  }
  
  private File copy(InputStream paramInputStream, Context paramContext)
  {
    try
    {
      paramContext = new File(paramContext.getFilesDir(), ".p12");
      FileOutputStream localFileOutputStream = new FileOutputStream(paramContext);
      byte[] arrayOfByte = new byte['?'];
      for (;;)
      {
        int i = paramInputStream.read(arrayOfByte);
        if (i <= 0) {
          break;
        }
        localFileOutputStream.write(arrayOfByte, 0, i);
      }
      localFileOutputStream.close();
      paramInputStream.close();
      return paramContext;
    }
    catch (IOException paramInputStream)
    {
      for (;;) {}
    }
    return null;
  }
  
  public void onHandleIntent(Intent paramIntent)
  {
    try
    {
      boolean bool = paramIntent.getStringExtra("auth").equalsIgnoreCase("n");
      k.a.a.m.f localF;
      String str;
      if (bool)
      {
        localF = new k.a.a.m.f(this);
        str = k.a.a.m.f.version;
        bool = localF.add(str, "n").equalsIgnoreCase("y");
        if (bool)
        {
          bool = paramIntent.getStringExtra("type").equalsIgnoreCase("exception");
          if (bool)
          {
            parse(this, paramIntent.getStringExtra("log"));
            return;
          }
          parse(this, paramIntent.getStringExtra("type"), paramIntent.getStringExtra("resCode"), paramIntent.getStringExtra("rc"), paramIntent.getStringExtra("rd"));
        }
      }
      else
      {
        localF = new k.a.a.m.f(this);
        str = k.a.a.m.f.subject;
        bool = localF.add(str, "y").equalsIgnoreCase("y");
        if (bool)
        {
          bool = paramIntent.getStringExtra("type").equalsIgnoreCase("exception");
          if (bool)
          {
            parse(this, paramIntent.getStringExtra("log"));
            return;
          }
          parse(this, paramIntent.getStringExtra("type"), paramIntent.getStringExtra("resCode"), paramIntent.getStringExtra("rc"), paramIntent.getStringExtra("rd"));
          return;
        }
      }
    }
    catch (Exception paramIntent)
    {
      k.a.a.m.StringBuilder.append((Exception)paramIntent);
    }
  }
  
  public void parse(Context paramContext, String paramString)
  {
    try
    {
      Object localObject1 = paramContext.getAssets();
      localObject4 = null;
      try
      {
        localObject1 = ((AssetManager)localObject1).open("UMANG-ef4fc4a0fc27.p12");
      }
      catch (IOException localIOException1)
      {
        k.a.a.m.StringBuilder.append(localIOException1);
        localObject2 = null;
      }
      Object localObject2 = copy((InputStream)localObject2, paramContext);
      try
      {
        localObject5 = new Item();
        localObject6 = INSTANCE;
        localObject5 = ((Item)localObject5).a((HttpTransport)localObject6);
        localObject6 = UTF_8;
        localObject5 = ((Item)localObject5).a((f.g.org.org.stream.JsonFactory)localObject6);
        localObject6 = context;
        localObject2 = ((Item)localObject5).a((Collection)localObject6).b("umang-bigquery@umang-c17d7.iam.gserviceaccount.com").a((File)localObject2).a();
      }
      catch (IOException localIOException2) {}catch (GeneralSecurityException localGeneralSecurityException) {}
      localObject3 = (Exception)localGeneralSecurityException;
      k.a.a.m.StringBuilder.append((Exception)localObject3);
      localObject3 = localObject4;
      localObject4 = INSTANCE;
      localObject5 = UTF_8;
      localObject3 = new h((HttpTransport)localObject4, (f.g.org.org.stream.JsonFactory)localObject5, (AnnotationVisitor)localObject3).setTitle("BigQuery-Service-Accounts/0.1").a((AnnotationVisitor)localObject3).a();
      localObject4 = new AbstractNode();
    }
    catch (Exception paramContext)
    {
      Object localObject4;
      Object localObject5;
      Object localObject6;
      Object localObject3;
      label196:
      k.a.a.m.StringBuilder.append((Exception)paramContext);
      return;
    }
    try
    {
      localObject5 = new Date();
      localObject6 = Locale.US;
      ((AbstractNode)localObject4).clone("ts", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", (Locale)localObject6).format((Date)localObject5));
    }
    catch (Exception localException)
    {
      break label196;
    }
    ((AbstractNode)localObject4).clone("env", "P");
    ((AbstractNode)localObject4).clone("ver", Log.getVersion(paramContext));
    ((AbstractNode)localObject4).clone("did", Log.getValue(paramContext));
    ((AbstractNode)localObject4).clone("hmk", Log.get());
    ((AbstractNode)localObject4).clone("hmd", Log.getName());
    ((AbstractNode)localObject4).clone("osver", Log.execute());
    ((AbstractNode)localObject4).clone("mcc", Log.start(paramContext));
    ((AbstractNode)localObject4).clone("mnc", Log.get(paramContext));
    ((AbstractNode)localObject4).clone("lac", Log.parse(paramContext));
    ((AbstractNode)localObject4).clone("log", paramString);
    ((AbstractNode)localObject4).clone("udf1", "");
    ((AbstractNode)localObject4).clone("udf2", "");
    paramContext = new GenericData();
    paramContext.set(String.valueOf(System.currentTimeMillis()));
    paramContext.set((Map)localObject4);
    paramString = new ArrayList();
    paramString.add(paramContext);
    paramContext = new Token().setValue(paramString);
    paramContext = ((f.g.org.jivesoftware.initializer.f)localObject3).getLogger().e("616074837787", "umang_data", "exception_logs", paramContext).execute();
    paramContext = (Protos.UpdatePayment.Builder)paramContext;
    paramString = new StringBuilder();
    paramString.append("resp : ");
    paramString.append(paramContext.toString());
    paramString.toString();
  }
  
  public void parse(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    try
    {
      Object localObject1 = paramContext.getAssets();
      Object localObject4 = null;
      try
      {
        localObject1 = ((AssetManager)localObject1).open("UMANG-ef4fc4a0fc27.p12");
      }
      catch (IOException localIOException1)
      {
        k.a.a.m.StringBuilder.append(localIOException1);
        localObject2 = null;
      }
      Object localObject2 = copy((InputStream)localObject2, paramContext);
      try
      {
        localObject5 = new Item();
        localObject6 = INSTANCE;
        localObject5 = ((Item)localObject5).a((HttpTransport)localObject6);
        localObject6 = UTF_8;
        localObject5 = ((Item)localObject5).a((f.g.org.org.stream.JsonFactory)localObject6);
        localObject6 = context;
        localObject2 = ((Item)localObject5).a((Collection)localObject6).b("umang-bigquery@umang-c17d7.iam.gserviceaccount.com").a((File)localObject2).a();
      }
      catch (IOException localIOException2) {}catch (GeneralSecurityException localGeneralSecurityException) {}
      localObject3 = (Exception)localGeneralSecurityException;
      k.a.a.m.StringBuilder.append((Exception)localObject3);
      localObject3 = localObject4;
      localObject4 = INSTANCE;
      localObject5 = UTF_8;
      localObject5 = new h((HttpTransport)localObject4, (f.g.org.org.stream.JsonFactory)localObject5, (AnnotationVisitor)localObject3).setTitle("BigQuery-Service-Accounts/0.1").a((AnnotationVisitor)localObject3).a();
      localObject6 = new AbstractNode();
      boolean bool = paramString1.equalsIgnoreCase("https://app.umang.gov.in/umang/coreapi/opn/ws2/instancekey");
      if (!bool)
      {
        bool = paramString1.equalsIgnoreCase("https://app.umang.gov.in/umang/coreapi/opn/ws2/skey");
        if (!bool)
        {
          try
          {
            localObject4 = new k.a.a.m.System(paramContext).get().get();
            localObject3 = localObject4;
            try
            {
              localObject7 = new StringBuilder();
              ((StringBuilder)localObject7).append("XXXX");
              ((StringBuilder)localObject7).append(((String)localObject4).substring(4));
              localObject4 = ((StringBuilder)localObject7).toString();
              localObject3 = localObject4;
            }
            catch (Exception localException1) {}
            k.a.a.m.StringBuilder.append(localException2);
          }
          catch (Exception localException2)
          {
            localObject3 = "";
          }
          break label294;
        }
      }
      localObject3 = "";
    }
    catch (Exception paramContext)
    {
      Object localObject5;
      Object localObject6;
      Object localObject3;
      Object localObject7;
      label294:
      Date localDate;
      label332:
      k.a.a.m.StringBuilder.append((Exception)paramContext);
      return;
    }
    try
    {
      localDate = new Date();
      localObject7 = Locale.US;
      ((AbstractNode)localObject6).clone("ts", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", (Locale)localObject7).format(localDate));
    }
    catch (Exception localException3)
    {
      break label332;
    }
    ((AbstractNode)localObject6).clone("api", paramString1);
    ((AbstractNode)localObject6).clone("env", "P");
    ((AbstractNode)localObject6).clone("ver", Log.getVersion(paramContext));
    ((AbstractNode)localObject6).clone("did", Log.getValue(paramContext));
    ((AbstractNode)localObject6).clone("imei", "");
    ((AbstractNode)localObject6).clone("hmk", Log.get());
    ((AbstractNode)localObject6).clone("hmd", Log.getName());
    ((AbstractNode)localObject6).clone("osver", Log.execute());
    ((AbstractNode)localObject6).clone("tkn", "");
    ((AbstractNode)localObject6).clone("mcc", Log.start(paramContext));
    ((AbstractNode)localObject6).clone("mnc", Log.get(paramContext));
    ((AbstractNode)localObject6).clone("lac", Log.parse(paramContext));
    ((AbstractNode)localObject6).clone("mno", localObject3);
    ((AbstractNode)localObject6).clone("resCode", paramString2);
    ((AbstractNode)localObject6).clone("rc", paramString3);
    ((AbstractNode)localObject6).clone("rd", paramString4);
    ((AbstractNode)localObject6).clone("udf1", Log.getLocalIpAddress(paramContext));
    ((AbstractNode)localObject6).clone("udf2", "");
    ((AbstractNode)localObject6).clone("udf3", "");
    paramString1 = new StringBuilder();
    paramString1.append("MyUtils.getNewtorkInfo(mContext)...........");
    paramString1.append(Log.getLocalIpAddress(paramContext));
    paramString1.toString();
    paramContext = new GenericData();
    paramContext.set(String.valueOf(System.currentTimeMillis()));
    paramContext.set((Map)localObject6);
    paramString1 = new ArrayList();
    paramString1.add(paramContext);
    paramContext = new Token().setValue(paramString1);
    paramContext = ((f.g.org.jivesoftware.initializer.f)localObject5).getLogger().e("616074837787", "umang_data", "api_data", paramContext).execute();
    paramContext = (Protos.UpdatePayment.Builder)paramContext;
    paramString1 = new StringBuilder();
    paramString1.append("resp : ");
    paramString1.append(paramContext.toString());
    paramString1.toString();
  }
}
