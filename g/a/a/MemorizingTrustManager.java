package g.a.a;

import android.app.Activity;
import android.app.Application;
import android.app.Notification.Builder;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.os.Handler;
import android.util.SparseArray;
import java.io.File;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.Principal;
import java.security.cert.Certificate;
import java.security.cert.CertificateEncodingException;
import java.security.cert.CertificateException;
import java.security.cert.CertificateExpiredException;
import java.security.cert.CertificateParsingException;
import java.security.cert.X509Certificate;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;

public class MemorizingTrustManager
  implements X509TrustManager
{
  public static final String DECISION_INTENT = "de.duenndns.ssl.DECISION";
  public static final String DECISION_INTENT_CERT = "de.duenndns.ssl.DECISION.cert";
  public static final String DECISION_INTENT_CHOICE = "de.duenndns.ssl.DECISION.decisionChoice";
  public static final String DECISION_INTENT_ID = "de.duenndns.ssl.DECISION.decisionId";
  public static final String DECISION_TITLE_ID = "de.duenndns.ssl.DECISION.titleId";
  public static String KEYSTORE_DIR = "KeyStore";
  public static String KEYSTORE_FILE = "KeyStore.bks";
  public static final Logger LOGGER = Logger.getLogger(d.class.getName());
  public static final int NOTIFICATION_ID = 100509;
  public static final String TAG = "Trust anchor for certification path not found.";
  public static int decisionId = 0;
  public static SparseArray<b> openDecisions = new SparseArray();
  public KeyStore appKeyStore;
  public X509TrustManager appTrustManager;
  public X509TrustManager defaultTrustManager;
  public Activity foregroundAct;
  public File keyStoreFile;
  public Context master;
  public Handler masterHandler;
  public NotificationManager notificationManager;
  
  public MemorizingTrustManager(Context paramContext)
  {
    init(paramContext);
    appTrustManager = getTrustManager(appKeyStore);
    defaultTrustManager = getTrustManager(null);
  }
  
  public MemorizingTrustManager(Context paramContext, X509TrustManager paramX509TrustManager)
  {
    init(paramContext);
    appTrustManager = getTrustManager(appKeyStore);
    defaultTrustManager = paramX509TrustManager;
  }
  
  private String certChainMessage(X509Certificate[] paramArrayOfX509Certificate, CertificateException paramCertificateException)
  {
    Object localObject = LOGGER;
    Level localLevel = Level.FINE;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("certChainMessage for ");
    localStringBuilder.append(paramCertificateException);
    ((Logger)localObject).log(localLevel, localStringBuilder.toString());
    localObject = new StringBuffer();
    if (paramCertificateException.getCause() != null)
    {
      paramCertificateException = paramCertificateException.getCause();
      if ("Trust anchor for certification path not found.".equals(paramCertificateException.getMessage())) {
        ((StringBuffer)localObject).append(master.getString(e.a.mtm_trust_anchor));
      } else {
        ((StringBuffer)localObject).append(paramCertificateException.getLocalizedMessage());
      }
      ((StringBuffer)localObject).append("\n");
    }
    ((StringBuffer)localObject).append("\n");
    ((StringBuffer)localObject).append(master.getString(e.a.mtm_connect_anyway));
    ((StringBuffer)localObject).append("\n\n");
    ((StringBuffer)localObject).append(master.getString(e.a.mtm_cert_details));
    int j = paramArrayOfX509Certificate.length;
    int i = 0;
    while (i < j)
    {
      certDetails((StringBuffer)localObject, paramArrayOfX509Certificate[i]);
      i += 1;
    }
    return ((StringBuffer)localObject).toString();
  }
  
  private void certDetails(StringBuffer paramStringBuffer, X509Certificate paramX509Certificate)
  {
    SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
    paramStringBuffer.append("\n");
    paramStringBuffer.append(paramX509Certificate.getSubjectDN().toString());
    paramStringBuffer.append("\n");
    paramStringBuffer.append(localSimpleDateFormat.format(paramX509Certificate.getNotBefore()));
    paramStringBuffer.append(" - ");
    paramStringBuffer.append(localSimpleDateFormat.format(paramX509Certificate.getNotAfter()));
    paramStringBuffer.append("\nSHA-256: ");
    paramStringBuffer.append(certHash(paramX509Certificate, "SHA-256"));
    paramStringBuffer.append("\nSHA-1: ");
    paramStringBuffer.append(certHash(paramX509Certificate, "SHA-1"));
    paramStringBuffer.append("\nSigned by: ");
    paramStringBuffer.append(paramX509Certificate.getIssuerDN().toString());
    paramStringBuffer.append("\n");
  }
  
  public static String certHash(X509Certificate paramX509Certificate, String paramString)
  {
    try
    {
      paramString = MessageDigest.getInstance(paramString);
      paramString.update(paramX509Certificate.getEncoded());
      paramX509Certificate = hexString(paramString.digest());
      return paramX509Certificate;
    }
    catch (NoSuchAlgorithmException paramX509Certificate)
    {
      return paramX509Certificate.getMessage();
    }
    catch (CertificateEncodingException paramX509Certificate) {}
    return paramX509Certificate.getMessage();
  }
  
  private int createDecisionId(b paramB)
  {
    SparseArray localSparseArray = openDecisions;
    try
    {
      int i = decisionId;
      openDecisions.put(i, paramB);
      decisionId += 1;
      return i;
    }
    catch (Throwable paramB)
    {
      throw paramB;
    }
  }
  
  public static X509TrustManager[] getInstanceList(Context paramContext)
  {
    return (X509TrustManager[])new X509TrustManager[] { new MemorizingTrustManager(paramContext) };
  }
  
  public static String hexString(byte[] paramArrayOfByte)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    int i = 0;
    while (i < paramArrayOfByte.length)
    {
      localStringBuffer.append(String.format("%02x", new Object[] { Byte.valueOf(paramArrayOfByte[i]) }));
      if (i < paramArrayOfByte.length - 1) {
        localStringBuffer.append(":");
      }
      i += 1;
    }
    return localStringBuffer.toString();
  }
  
  private String hostNameMessage(X509Certificate paramX509Certificate, String paramString)
  {
    localStringBuffer = new StringBuffer();
    localStringBuffer.append(master.getString(e.a.mtm_hostname_mismatch, new Object[] { paramString }));
    localStringBuffer.append("\n\n");
    try
    {
      paramString = paramX509Certificate.getSubjectAlternativeNames();
      if (paramString == null)
      {
        localStringBuffer.append(paramX509Certificate.getSubjectDN());
        localStringBuffer.append("\n");
      }
      else
      {
        paramString = paramString.iterator();
        for (;;)
        {
          boolean bool = paramString.hasNext();
          if (!bool) {
            break;
          }
          Object localObject1 = paramString.next();
          Object localObject2 = (List)localObject1;
          localObject1 = ((List)localObject2).get(1);
          if ((localObject1 instanceof String))
          {
            localStringBuffer.append("[");
            localObject2 = ((List)localObject2).get(0);
            localObject2 = (Integer)localObject2;
            localStringBuffer.append(localObject2);
            localStringBuffer.append("] ");
            localStringBuffer.append(localObject1);
            localStringBuffer.append("\n");
          }
        }
      }
      return localStringBuffer.toString();
    }
    catch (CertificateParsingException paramString)
    {
      paramString.printStackTrace();
      localStringBuffer.append("<Parsing error: ");
      localStringBuffer.append(paramString.getLocalizedMessage());
      localStringBuffer.append(">\n");
      localStringBuffer.append("\n");
      localStringBuffer.append(master.getString(e.a.mtm_connect_anyway));
      localStringBuffer.append("\n\n");
      localStringBuffer.append(master.getString(e.a.mtm_cert_details));
      certDetails(localStringBuffer, paramX509Certificate);
    }
  }
  
  /* Error */
  public static void interactResult(int paramInt1, int paramInt2)
  {
    // Byte code:
    //   0: getstatic 86	g/a/a/MemorizingTrustManager:openDecisions	Landroid/util/SparseArray;
    //   3: astore_2
    //   4: aload_2
    //   5: monitorenter
    //   6: getstatic 86	g/a/a/MemorizingTrustManager:openDecisions	Landroid/util/SparseArray;
    //   9: iload_0
    //   10: invokevirtual 339	android/util/SparseArray:get	(I)Ljava/lang/Object;
    //   13: checkcast 341	g/a/a/b
    //   16: astore_3
    //   17: getstatic 86	g/a/a/MemorizingTrustManager:openDecisions	Landroid/util/SparseArray;
    //   20: iload_0
    //   21: invokevirtual 345	android/util/SparseArray:remove	(I)V
    //   24: aload_2
    //   25: monitorexit
    //   26: aload_3
    //   27: ifnonnull +16 -> 43
    //   30: getstatic 69	g/a/a/MemorizingTrustManager:LOGGER	Ljava/util/logging/Logger;
    //   33: getstatic 348	java/util/logging/Level:SEVERE	Ljava/util/logging/Level;
    //   36: ldc_w 350
    //   39: invokevirtual 134	java/util/logging/Logger:log	(Ljava/util/logging/Level;Ljava/lang/String;)V
    //   42: return
    //   43: aload_3
    //   44: monitorenter
    //   45: aload_3
    //   46: iload_1
    //   47: putfield 353	g/a/a/b:e	I
    //   50: aload_3
    //   51: invokevirtual 356	java/lang/Object:notify	()V
    //   54: aload_3
    //   55: monitorexit
    //   56: return
    //   57: astore_2
    //   58: aload_3
    //   59: monitorexit
    //   60: aload_2
    //   61: athrow
    //   62: astore_3
    //   63: aload_2
    //   64: monitorexit
    //   65: aload_3
    //   66: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	67	0	paramInt1	int
    //   0	67	1	paramInt2	int
    //   3	22	2	localSparseArray	SparseArray
    //   57	7	2	localThrowable1	Throwable
    //   16	43	3	localB	b
    //   62	4	3	localThrowable2	Throwable
    // Exception table:
    //   from	to	target	type
    //   45	56	57	java/lang/Throwable
    //   58	60	57	java/lang/Throwable
    //   6	26	62	java/lang/Throwable
    //   63	65	62	java/lang/Throwable
  }
  
  private boolean isCertKnown(X509Certificate paramX509Certificate)
  {
    KeyStore localKeyStore = appKeyStore;
    try
    {
      paramX509Certificate = localKeyStore.getCertificateAlias(paramX509Certificate);
      if (paramX509Certificate != null) {
        return true;
      }
    }
    catch (KeyStoreException paramX509Certificate) {}
    return false;
  }
  
  private boolean isExpiredException(Throwable paramThrowable)
  {
    Throwable localThrowable;
    do
    {
      if ((paramThrowable instanceof CertificateExpiredException)) {
        return true;
      }
      localThrowable = paramThrowable.getCause();
      paramThrowable = localThrowable;
    } while (localThrowable != null);
    return false;
  }
  
  public static void setKeyStoreFile(String paramString1, String paramString2)
  {
    KEYSTORE_DIR = paramString1;
    KEYSTORE_FILE = paramString2;
  }
  
  public void bindDisplayActivity(Activity paramActivity)
  {
    foregroundAct = paramActivity;
  }
  
  public void checkCertTrusted(X509Certificate[] paramArrayOfX509Certificate, String paramString, boolean paramBoolean)
    throws CertificateException
  {
    Object localObject1 = LOGGER;
    Level localLevel = Level.FINE;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("checkCertTrusted(");
    localStringBuilder.append(paramArrayOfX509Certificate);
    localStringBuilder.append(", ");
    localStringBuilder.append(paramString);
    localStringBuilder.append(", ");
    localStringBuilder.append(paramBoolean);
    localStringBuilder.append(")");
    ((Logger)localObject1).log(localLevel, localStringBuilder.toString());
    localObject1 = LOGGER;
    localLevel = Level.FINE;
    try
    {
      ((Logger)localObject1).log(localLevel, "checkCertTrusted: trying appTrustManager");
      if (paramBoolean)
      {
        localObject1 = appTrustManager;
        ((X509TrustManager)localObject1).checkServerTrusted(paramArrayOfX509Certificate, paramString);
        return;
      }
      localObject1 = appTrustManager;
      ((X509TrustManager)localObject1).checkClientTrusted(paramArrayOfX509Certificate, paramString);
      return;
    }
    catch (CertificateException localCertificateException1)
    {
      LOGGER.log(Level.FINER, "checkCertTrusted: appTrustManager failed", localCertificateException1);
      if (isExpiredException(localCertificateException1))
      {
        LOGGER.log(Level.INFO, "checkCertTrusted: accepting expired certificate from keystore");
        return;
      }
      if (isCertKnown(paramArrayOfX509Certificate[0]))
      {
        LOGGER.log(Level.INFO, "checkCertTrusted: accepting cert already stored in keystore");
        return;
      }
      Object localObject2;
      if (defaultTrustManager != null)
      {
        localObject2 = LOGGER;
        localLevel = Level.FINE;
      }
      try
      {
        ((Logger)localObject2).log(localLevel, "checkCertTrusted: trying defaultTrustManager");
        if (paramBoolean)
        {
          localObject2 = defaultTrustManager;
          ((X509TrustManager)localObject2).checkServerTrusted(paramArrayOfX509Certificate, paramString);
          return;
        }
        localObject2 = defaultTrustManager;
        ((X509TrustManager)localObject2).checkClientTrusted(paramArrayOfX509Certificate, paramString);
        return;
      }
      catch (CertificateException localCertificateException2)
      {
        LOGGER.log(Level.FINER, "checkCertTrusted: defaultTrustManager failed", localCertificateException2);
        interactCert(paramArrayOfX509Certificate, paramString, localCertificateException2);
      }
      throw ((Throwable)localObject2);
    }
  }
  
  public void checkClientTrusted(X509Certificate[] paramArrayOfX509Certificate, String paramString)
    throws CertificateException
  {
    checkCertTrusted(paramArrayOfX509Certificate, paramString, false);
  }
  
  public void checkServerTrusted(X509Certificate[] paramArrayOfX509Certificate, String paramString)
    throws CertificateException
  {
    checkCertTrusted(paramArrayOfX509Certificate, paramString, true);
  }
  
  public void deleteCertificate(String paramString)
    throws KeyStoreException
  {
    appKeyStore.deleteEntry(paramString);
    keyStoreUpdated();
  }
  
  public X509Certificate[] getAcceptedIssuers()
  {
    LOGGER.log(Level.FINE, "getAcceptedIssuers()");
    return defaultTrustManager.getAcceptedIssuers();
  }
  
  public Certificate getCertificate(String paramString)
  {
    KeyStore localKeyStore = appKeyStore;
    try
    {
      paramString = localKeyStore.getCertificate(paramString);
      return paramString;
    }
    catch (KeyStoreException paramString)
    {
      throw new RuntimeException(paramString);
    }
  }
  
  public Enumeration getCertificates()
  {
    Object localObject = appKeyStore;
    try
    {
      localObject = ((KeyStore)localObject).aliases();
      return localObject;
    }
    catch (KeyStoreException localKeyStoreException)
    {
      throw new RuntimeException(localKeyStoreException);
    }
  }
  
  public X509TrustManager getTrustManager(KeyStore paramKeyStore)
  {
    try
    {
      Object localObject = TrustManagerFactory.getInstance("X509");
      ((TrustManagerFactory)localObject).init(paramKeyStore);
      localObject = ((TrustManagerFactory)localObject).getTrustManagers();
      int j = localObject.length;
      int i = 0;
      while (i < j)
      {
        paramKeyStore = localObject[i];
        if ((paramKeyStore instanceof X509TrustManager)) {
          return (X509TrustManager)paramKeyStore;
        }
        i += 1;
      }
      return null;
    }
    catch (Exception localException)
    {
      LOGGER.log(Level.SEVERE, f.sufficientlysecure.rootcommands.util.StringBuilder.toString("getTrustManager(", paramKeyStore, ")"), localException);
    }
  }
  
  public Context getUI()
  {
    Activity localActivity = foregroundAct;
    if (localActivity != null) {
      return localActivity;
    }
    return master;
  }
  
  public void init(Context paramContext)
  {
    master = paramContext;
    masterHandler = new Handler(paramContext.getMainLooper());
    notificationManager = ((NotificationManager)master.getSystemService("notification"));
    if ((paramContext instanceof Application))
    {
      paramContext = (Application)paramContext;
    }
    else if ((paramContext instanceof Service))
    {
      paramContext = ((Service)paramContext).getApplication();
    }
    else
    {
      if (!(paramContext instanceof Activity)) {
        break label148;
      }
      paramContext = ((Activity)paramContext).getApplication();
    }
    paramContext = paramContext.getDir(KEYSTORE_DIR, 0);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramContext);
    localStringBuilder.append(File.separator);
    localStringBuilder.append(KEYSTORE_FILE);
    keyStoreFile = new File(localStringBuilder.toString());
    appKeyStore = loadAppKeyStore();
    return;
    label148:
    throw new ClassCastException("MemorizingTrustManager context must be either Activity or Service!");
  }
  
  public int interact(String paramString, int paramInt)
  {
    b localB = new b();
    int i = createDecisionId(localB);
    masterHandler.post((Runnable)new c(this, i, paramString, paramInt));
    paramString = LOGGER;
    Level localLevel = Level.FINE;
    StringBuilder localStringBuilder = f.sufficientlysecure.rootcommands.util.StringBuilder.append("openDecisions: ");
    localStringBuilder.append(openDecisions);
    localStringBuilder.append(", waiting on ");
    localStringBuilder.append(i);
    paramString.log(localLevel, localStringBuilder.toString());
    try
    {
      localB.wait();
    }
    catch (Throwable paramString)
    {
      try
      {
        throw paramString;
      }
      catch (InterruptedException paramString)
      {
        LOGGER.log(Level.FINER, "InterruptedException", paramString);
      }
    }
    paramString = LOGGER;
    localLevel = Level.FINE;
    localStringBuilder = f.sufficientlysecure.rootcommands.util.StringBuilder.append("finished wait on ", i, ": ");
    localStringBuilder.append(e);
    paramString.log(localLevel, localStringBuilder.toString());
    return e;
  }
  
  public void interactCert(X509Certificate[] paramArrayOfX509Certificate, String paramString, CertificateException paramCertificateException)
    throws CertificateException
  {
    int i = interact(certChainMessage(paramArrayOfX509Certificate, paramCertificateException), e.a.mtm_accept_cert);
    if (i != 2)
    {
      if (i == 3)
      {
        storeCert(paramArrayOfX509Certificate[0]);
        return;
      }
      throw paramCertificateException;
    }
  }
  
  public boolean interactHostname(X509Certificate paramX509Certificate, String paramString)
  {
    int i = interact(hostNameMessage(paramX509Certificate, paramString), e.a.mtm_accept_servername);
    if (i != 2)
    {
      if (i != 3) {
        return false;
      }
      storeCert(paramString, paramX509Certificate);
    }
    return true;
  }
  
  /* Error */
  public void keyStoreUpdated()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 94	g/a/a/MemorizingTrustManager:appKeyStore	Ljava/security/KeyStore;
    //   4: astore_1
    //   5: aload_0
    //   6: astore_3
    //   7: aload_3
    //   8: aload_0
    //   9: aload_1
    //   10: invokevirtual 98	g/a/a/MemorizingTrustManager:getTrustManager	(Ljava/security/KeyStore;)Ljavax/net/ssl/X509TrustManager;
    //   13: putfield 100	g/a/a/MemorizingTrustManager:appTrustManager	Ljavax/net/ssl/X509TrustManager;
    //   16: aconst_null
    //   17: astore_1
    //   18: aload_3
    //   19: getfield 526	g/a/a/MemorizingTrustManager:keyStoreFile	Ljava/io/File;
    //   22: astore_2
    //   23: new 598	java/io/FileOutputStream
    //   26: dup
    //   27: aload_2
    //   28: invokespecial 601	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   31: astore_2
    //   32: aload_2
    //   33: astore_1
    //   34: aload_3
    //   35: getfield 94	g/a/a/MemorizingTrustManager:appKeyStore	Ljava/security/KeyStore;
    //   38: astore_3
    //   39: aload_2
    //   40: astore_1
    //   41: aload_3
    //   42: aload_2
    //   43: ldc_w 603
    //   46: invokevirtual 607	java/lang/String:toCharArray	()[C
    //   49: invokevirtual 611	java/security/KeyStore:store	(Ljava/io/OutputStream;[C)V
    //   52: aload_2
    //   53: invokevirtual 614	java/io/FileOutputStream:close	()V
    //   56: return
    //   57: astore_1
    //   58: getstatic 69	g/a/a/MemorizingTrustManager:LOGGER	Ljava/util/logging/Logger;
    //   61: astore_2
    //   62: getstatic 348	java/util/logging/Level:SEVERE	Ljava/util/logging/Level;
    //   65: astore_3
    //   66: new 117	java/lang/StringBuilder
    //   69: dup
    //   70: invokespecial 118	java/lang/StringBuilder:<init>	()V
    //   73: astore 4
    //   75: goto +119 -> 194
    //   78: astore_3
    //   79: goto +14 -> 93
    //   82: astore_2
    //   83: aload_1
    //   84: astore_3
    //   85: aload_2
    //   86: astore_1
    //   87: goto +140 -> 227
    //   90: astore_3
    //   91: aconst_null
    //   92: astore_2
    //   93: aload_2
    //   94: astore_1
    //   95: getstatic 69	g/a/a/MemorizingTrustManager:LOGGER	Ljava/util/logging/Logger;
    //   98: astore 4
    //   100: aload_2
    //   101: astore_1
    //   102: getstatic 348	java/util/logging/Level:SEVERE	Ljava/util/logging/Level;
    //   105: astore 5
    //   107: aload_2
    //   108: astore_1
    //   109: new 117	java/lang/StringBuilder
    //   112: dup
    //   113: invokespecial 118	java/lang/StringBuilder:<init>	()V
    //   116: astore 6
    //   118: aload_2
    //   119: astore_1
    //   120: aload 6
    //   122: ldc_w 616
    //   125: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   128: pop
    //   129: aload_2
    //   130: astore_1
    //   131: aload 6
    //   133: aload_0
    //   134: getfield 526	g/a/a/MemorizingTrustManager:keyStoreFile	Ljava/io/File;
    //   137: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   140: pop
    //   141: aload_2
    //   142: astore_1
    //   143: aload 6
    //   145: ldc_w 389
    //   148: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   151: pop
    //   152: aload_2
    //   153: astore_1
    //   154: aload 4
    //   156: aload 5
    //   158: aload 6
    //   160: invokevirtual 130	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   163: aload_3
    //   164: invokevirtual 406	java/util/logging/Logger:log	(Ljava/util/logging/Level;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   167: aload_2
    //   168: ifnull +99 -> 267
    //   171: aload_2
    //   172: invokevirtual 614	java/io/FileOutputStream:close	()V
    //   175: return
    //   176: astore_1
    //   177: getstatic 69	g/a/a/MemorizingTrustManager:LOGGER	Ljava/util/logging/Logger;
    //   180: astore_2
    //   181: getstatic 348	java/util/logging/Level:SEVERE	Ljava/util/logging/Level;
    //   184: astore_3
    //   185: new 117	java/lang/StringBuilder
    //   188: dup
    //   189: invokespecial 118	java/lang/StringBuilder:<init>	()V
    //   192: astore 4
    //   194: aload 4
    //   196: ldc_w 616
    //   199: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   202: pop
    //   203: aload_2
    //   204: aload_3
    //   205: aload 4
    //   207: aload_0
    //   208: getfield 526	g/a/a/MemorizingTrustManager:keyStoreFile	Ljava/io/File;
    //   211: ldc_w 389
    //   214: invokestatic 619	f/sufficientlysecure/rootcommands/util/StringBuilder:append	(Ljava/lang/StringBuilder;Ljava/lang/Object;Ljava/lang/String;)Ljava/lang/String;
    //   217: aload_1
    //   218: invokevirtual 406	java/util/logging/Logger:log	(Ljava/util/logging/Level;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   221: return
    //   222: astore_2
    //   223: aload_1
    //   224: astore_3
    //   225: aload_2
    //   226: astore_1
    //   227: aload_3
    //   228: ifnull +37 -> 265
    //   231: aload_3
    //   232: invokevirtual 614	java/io/FileOutputStream:close	()V
    //   235: goto +30 -> 265
    //   238: astore_2
    //   239: getstatic 69	g/a/a/MemorizingTrustManager:LOGGER	Ljava/util/logging/Logger;
    //   242: getstatic 348	java/util/logging/Level:SEVERE	Ljava/util/logging/Level;
    //   245: ldc_w 616
    //   248: invokestatic 556	f/sufficientlysecure/rootcommands/util/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   251: aload_0
    //   252: getfield 526	g/a/a/MemorizingTrustManager:keyStoreFile	Ljava/io/File;
    //   255: ldc_w 389
    //   258: invokestatic 619	f/sufficientlysecure/rootcommands/util/StringBuilder:append	(Ljava/lang/StringBuilder;Ljava/lang/Object;Ljava/lang/String;)Ljava/lang/String;
    //   261: aload_2
    //   262: invokevirtual 406	java/util/logging/Logger:log	(Ljava/util/logging/Level;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   265: aload_1
    //   266: athrow
    //   267: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	268	0	this	MemorizingTrustManager
    //   4	37	1	localObject1	Object
    //   57	27	1	localIOException1	java.io.IOException
    //   86	68	1	localObject2	Object
    //   176	48	1	localIOException2	java.io.IOException
    //   226	40	1	localObject3	Object
    //   22	40	2	localObject4	Object
    //   82	4	2	localThrowable1	Throwable
    //   92	112	2	localLogger	Logger
    //   222	4	2	localThrowable2	Throwable
    //   238	24	2	localIOException3	java.io.IOException
    //   6	60	3	localObject5	Object
    //   78	1	3	localException1	Exception
    //   84	1	3	localIOException4	java.io.IOException
    //   90	74	3	localException2	Exception
    //   184	48	3	localObject6	Object
    //   73	133	4	localObject7	Object
    //   105	52	5	localLevel	Level
    //   116	43	6	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   52	56	57	java/io/IOException
    //   41	52	78	java/lang/Exception
    //   23	32	82	java/lang/Throwable
    //   23	32	90	java/lang/Exception
    //   171	175	176	java/io/IOException
    //   34	39	222	java/lang/Throwable
    //   41	52	222	java/lang/Throwable
    //   95	100	222	java/lang/Throwable
    //   102	107	222	java/lang/Throwable
    //   109	118	222	java/lang/Throwable
    //   120	129	222	java/lang/Throwable
    //   131	141	222	java/lang/Throwable
    //   143	152	222	java/lang/Throwable
    //   154	167	222	java/lang/Throwable
    //   231	235	238	java/io/IOException
  }
  
  /* Error */
  public KeyStore loadAppKeyStore()
  {
    // Byte code:
    //   0: invokestatic 624	java/security/KeyStore:getDefaultType	()Ljava/lang/String;
    //   3: invokestatic 627	java/security/KeyStore:getInstance	(Ljava/lang/String;)Ljava/security/KeyStore;
    //   6: astore_1
    //   7: aload_1
    //   8: aconst_null
    //   9: aconst_null
    //   10: invokevirtual 631	java/security/KeyStore:load	(Ljava/io/InputStream;[C)V
    //   13: aload_0
    //   14: getfield 526	g/a/a/MemorizingTrustManager:keyStoreFile	Ljava/io/File;
    //   17: astore_2
    //   18: new 633	java/io/FileInputStream
    //   21: dup
    //   22: aload_2
    //   23: invokespecial 634	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   26: astore_2
    //   27: aload_1
    //   28: aload_2
    //   29: ldc_w 603
    //   32: invokevirtual 607	java/lang/String:toCharArray	()[C
    //   35: invokevirtual 631	java/security/KeyStore:load	(Ljava/io/InputStream;[C)V
    //   38: aload_1
    //   39: areturn
    //   40: astore_2
    //   41: getstatic 69	g/a/a/MemorizingTrustManager:LOGGER	Ljava/util/logging/Logger;
    //   44: getstatic 348	java/util/logging/Level:SEVERE	Ljava/util/logging/Level;
    //   47: ldc_w 636
    //   50: invokestatic 556	f/sufficientlysecure/rootcommands/util/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   53: aload_0
    //   54: getfield 526	g/a/a/MemorizingTrustManager:keyStoreFile	Ljava/io/File;
    //   57: ldc_w 389
    //   60: invokestatic 619	f/sufficientlysecure/rootcommands/util/StringBuilder:append	(Ljava/lang/StringBuilder;Ljava/lang/Object;Ljava/lang/String;)Ljava/lang/String;
    //   63: aload_2
    //   64: invokevirtual 406	java/util/logging/Logger:log	(Ljava/util/logging/Level;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   67: aload_1
    //   68: areturn
    //   69: getstatic 69	g/a/a/MemorizingTrustManager:LOGGER	Ljava/util/logging/Logger;
    //   72: astore_2
    //   73: getstatic 411	java/util/logging/Level:INFO	Ljava/util/logging/Level;
    //   76: astore_3
    //   77: ldc_w 636
    //   80: invokestatic 556	f/sufficientlysecure/rootcommands/util/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   83: astore 4
    //   85: aload 4
    //   87: aload_0
    //   88: getfield 526	g/a/a/MemorizingTrustManager:keyStoreFile	Ljava/io/File;
    //   91: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   94: pop
    //   95: aload 4
    //   97: ldc_w 638
    //   100: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   103: pop
    //   104: aload_2
    //   105: aload_3
    //   106: aload 4
    //   108: invokevirtual 130	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   111: invokevirtual 134	java/util/logging/Logger:log	(Ljava/util/logging/Level;Ljava/lang/String;)V
    //   114: aload_1
    //   115: areturn
    //   116: astore_1
    //   117: getstatic 69	g/a/a/MemorizingTrustManager:LOGGER	Ljava/util/logging/Logger;
    //   120: getstatic 348	java/util/logging/Level:SEVERE	Ljava/util/logging/Level;
    //   123: ldc_w 640
    //   126: aload_1
    //   127: invokevirtual 406	java/util/logging/Logger:log	(Ljava/util/logging/Level;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   130: aconst_null
    //   131: areturn
    //   132: astore_2
    //   133: goto -64 -> 69
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	136	0	this	MemorizingTrustManager
    //   6	109	1	localKeyStore	KeyStore
    //   116	11	1	localKeyStoreException	KeyStoreException
    //   17	12	2	localObject	Object
    //   40	24	2	localException	Exception
    //   72	33	2	localLogger	Logger
    //   132	1	2	localFileNotFoundException	java.io.FileNotFoundException
    //   76	30	3	localLevel	Level
    //   83	24	4	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   7	13	40	java/lang/Exception
    //   18	27	40	java/lang/Exception
    //   27	38	40	java/lang/Exception
    //   0	7	116	java/security/KeyStoreException
    //   7	13	132	java/io/FileNotFoundException
    //   18	27	132	java/io/FileNotFoundException
    //   27	38	132	java/io/FileNotFoundException
  }
  
  public void startActivityNotification(Intent paramIntent, int paramInt, String paramString)
  {
    paramIntent = PendingIntent.getActivity(master, 0, paramIntent, 0);
    String str = master.getString(e.a.mtm_notification);
    long l = System.currentTimeMillis();
    master.getApplicationContext();
    paramIntent = new Notification.Builder(master).setContentTitle(str).setContentText(paramString).setTicker(paramString).setSmallIcon(17301551).setWhen(l).setContentIntent(paramIntent).setAutoCancel(true).build();
    notificationManager.notify(paramInt + 100509, paramIntent);
  }
  
  public void storeCert(String paramString, Certificate paramCertificate)
  {
    KeyStore localKeyStore = appKeyStore;
    try
    {
      localKeyStore.setCertificateEntry(paramString, paramCertificate);
      keyStoreUpdated();
      return;
    }
    catch (KeyStoreException paramString)
    {
      LOGGER.log(Level.SEVERE, f.sufficientlysecure.rootcommands.util.StringBuilder.toString("storeCert(", paramCertificate, ")"), paramString);
    }
  }
  
  public void storeCert(X509Certificate paramX509Certificate)
  {
    storeCert(paramX509Certificate.getSubjectDN().toString(), paramX509Certificate);
  }
  
  public void unbindDisplayActivity(Activity paramActivity)
  {
    if (foregroundAct == paramActivity) {
      foregroundAct = null;
    }
  }
  
  public HostnameVerifier wrapHostnameVerifier(HostnameVerifier paramHostnameVerifier)
  {
    if (paramHostnameVerifier != null) {
      return (HostnameVerifier)new d.a(this, paramHostnameVerifier);
    }
    throw new IllegalArgumentException("The default verifier may not be null");
  }
}
