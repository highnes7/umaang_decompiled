package f.sufficientlysecure.rootcommands.util;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import com.google.android.android.internal.zzeye;
import com.google.android.android.internal.zzeyl;
import com.google.android.android.internal.zzeyn;
import f.h.a.Factory;
import f.h.a.MimeMessage;
import f.l.a.b.d;
import in.spicedigital.umang.activities.LoginScreen;
import java.io.IOException;
import java.io.PrintStream;
import java.security.GeneralSecurityException;
import java.security.SignatureException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import k.a.a.m.AllCapsTransformationMethod;
import org.apache.http.impl.auth.NTLMEngineImpl;
import org.aspectj.lang.JoinPoint;
import org.spongycastle.asn1.ASN1Encodable;
import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1ObjectIdentifier;
import org.spongycastle.asn1.ASN1OctetString;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.ASN1TaggedObject;
import org.spongycastle.asn1.DERSequence;
import org.spongycastle.asn1.DERTaggedObject;
import org.spongycastle.jcajce.provider.config.ConfigurableProvider;
import org.spongycastle.math.ec.ECFieldElement;
import org.spongycastle.pqc.crypto.xmss.DefaultXMSSMTOid;
import org.spongycastle.util.Arrays;
import org.xbill.DNS.TextParseException;
import org.xbill.DNS.Tokenizer;

public class StringBuilder
{
  public static d a(boolean paramBoolean1, boolean paramBoolean2)
  {
    return new d().setId(paramBoolean1).read(paramBoolean2);
  }
  
  public static int add(Class paramClass, int paramInt1, int paramInt2)
  {
    return (paramClass.getName().hashCode() + paramInt1) * paramInt2;
  }
  
  public static String add(int paramInt1, String paramString, int paramInt2)
  {
    java.lang.StringBuilder localStringBuilder = new java.lang.StringBuilder(paramInt1);
    localStringBuilder.append(paramString);
    localStringBuilder.append(paramInt2);
    return localStringBuilder.toString();
  }
  
  public static java.lang.StringBuilder addAlias(ConfigurableProvider paramConfigurableProvider, String paramString1, String paramString2)
  {
    paramConfigurableProvider.addAlgorithm(paramString1, paramString2);
    return new java.lang.StringBuilder();
  }
  
  public static java.lang.StringBuilder addAlias(ConfigurableProvider paramConfigurableProvider, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    paramConfigurableProvider.addAlgorithm(paramString1, paramString2);
    paramConfigurableProvider.addAlgorithm(paramString3, paramString4);
    return new java.lang.StringBuilder();
  }
  
  public static java.lang.StringBuilder addAlias(ConfigurableProvider paramConfigurableProvider, String paramString1, ASN1ObjectIdentifier paramASN1ObjectIdentifier, String paramString2)
  {
    paramConfigurableProvider.addAlgorithm(paramString1, paramASN1ObjectIdentifier, paramString2);
    return new java.lang.StringBuilder();
  }
  
  public static void addAlias(java.lang.StringBuilder paramStringBuilder, String paramString1, String paramString2, ConfigurableProvider paramConfigurableProvider, String paramString3)
  {
    paramStringBuilder.append(paramString1);
    paramStringBuilder.append(paramString2);
    paramConfigurableProvider.addAlgorithm(paramString3, paramStringBuilder.toString());
  }
  
  public static DERSequence addCapability(ASN1EncodableVector paramASN1EncodableVector1, ASN1Encodable paramASN1Encodable, ASN1EncodableVector paramASN1EncodableVector2)
  {
    paramASN1EncodableVector1.add(paramASN1Encodable);
    return new DERSequence(paramASN1EncodableVector2);
  }
  
  public static int addEntry(JoinPoint paramJoinPoint, MimeMessage paramMimeMessage)
  {
    Factory.aspectOf().before(paramJoinPoint);
    return paramMimeMessage.getFlags();
  }
  
  public static void addOptional(boolean paramBoolean, int paramInt, ASN1Encodable paramASN1Encodable, ASN1EncodableVector paramASN1EncodableVector)
  {
    paramASN1EncodableVector.add(new DERTaggedObject(paramBoolean, paramInt, paramASN1Encodable));
  }
  
  public static float append(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    return (paramFloat1 - paramFloat2) * paramFloat3 + paramFloat4;
  }
  
  public static int append(Object paramObject, int paramInt)
  {
    return String.valueOf(paramObject).length() + paramInt;
  }
  
  public static String append(int paramInt, String paramString1, String paramString2, String paramString3)
  {
    java.lang.StringBuilder localStringBuilder = new java.lang.StringBuilder(paramInt);
    localStringBuilder.append(paramString1);
    localStringBuilder.append(paramString2);
    localStringBuilder.append(paramString3);
    return localStringBuilder.toString();
  }
  
  public static String append(RecyclerView paramRecyclerView, java.lang.StringBuilder paramStringBuilder)
  {
    paramStringBuilder.append(paramRecyclerView.exceptionLabel());
    return paramStringBuilder.toString();
  }
  
  public static String append(Object paramObject, java.lang.StringBuilder paramStringBuilder, String paramString)
  {
    paramStringBuilder.append(paramObject.toString());
    paramStringBuilder.append(paramString);
    return paramStringBuilder.toString();
  }
  
  public static String append(String paramString1, String paramString2, String paramString3)
  {
    java.lang.StringBuilder localStringBuilder = new java.lang.StringBuilder();
    localStringBuilder.append(paramString1);
    localStringBuilder.append(paramString2);
    localStringBuilder.append(paramString3);
    return localStringBuilder.toString();
  }
  
  public static String append(java.lang.StringBuilder paramStringBuilder, int paramInt, char paramChar)
  {
    paramStringBuilder.append(paramInt);
    paramStringBuilder.append(paramChar);
    return paramStringBuilder.toString();
  }
  
  public static String append(java.lang.StringBuilder paramStringBuilder, int paramInt, String paramString)
  {
    paramStringBuilder.append(paramInt);
    paramStringBuilder.append(paramString);
    return paramStringBuilder.toString();
  }
  
  public static String append(java.lang.StringBuilder paramStringBuilder, Object paramObject, String paramString)
  {
    paramStringBuilder.append(paramObject);
    paramStringBuilder.append(paramString);
    return paramStringBuilder.toString();
  }
  
  public static String append(java.lang.StringBuilder paramStringBuilder, String paramString1, String paramString2)
  {
    paramStringBuilder.append(paramString1);
    paramStringBuilder.append(paramString2);
    return paramStringBuilder.toString();
  }
  
  public static String append(java.lang.StringBuilder paramStringBuilder, String paramString1, String paramString2, String paramString3)
  {
    paramStringBuilder.append(paramString1);
    paramStringBuilder.append(paramString2);
    paramStringBuilder.append(paramString3);
    return paramStringBuilder.toString();
  }
  
  public static java.lang.StringBuilder append(String paramString)
  {
    java.lang.StringBuilder localStringBuilder = new java.lang.StringBuilder();
    localStringBuilder.append(paramString);
    return localStringBuilder;
  }
  
  public static java.lang.StringBuilder append(String paramString1, int paramInt, String paramString2)
  {
    java.lang.StringBuilder localStringBuilder = new java.lang.StringBuilder();
    localStringBuilder.append(paramString1);
    localStringBuilder.append(paramInt);
    localStringBuilder.append(paramString2);
    return localStringBuilder;
  }
  
  public static java.lang.StringBuilder append(String paramString1, Object paramObject, String paramString2)
  {
    java.lang.StringBuilder localStringBuilder = new java.lang.StringBuilder();
    localStringBuilder.append(paramString1);
    localStringBuilder.append(paramObject);
    localStringBuilder.append(paramString2);
    return localStringBuilder;
  }
  
  public static java.lang.StringBuilder append(String paramString1, String paramString2)
  {
    java.lang.StringBuilder localStringBuilder = new java.lang.StringBuilder();
    localStringBuilder.append(paramString1);
    localStringBuilder.append(paramString2);
    return localStringBuilder;
  }
  
  public static java.lang.StringBuilder append(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    java.lang.StringBuilder localStringBuilder = new java.lang.StringBuilder();
    localStringBuilder.append(paramString1);
    localStringBuilder.append(paramString2);
    localStringBuilder.append(paramString3);
    localStringBuilder.append(paramString4);
    localStringBuilder.append(paramString5);
    return localStringBuilder;
  }
  
  public static java.lang.StringBuilder append(java.lang.StringBuilder paramStringBuilder, Object paramObject, ConfigurableProvider paramConfigurableProvider, String paramString1, String paramString2)
  {
    paramStringBuilder.append(paramObject);
    paramConfigurableProvider.addAlgorithm(paramStringBuilder.toString(), paramString1);
    paramStringBuilder = new java.lang.StringBuilder();
    paramStringBuilder.append(paramString2);
    return paramStringBuilder;
  }
  
  public static java.lang.StringBuilder append(java.lang.StringBuilder paramStringBuilder, String paramString1, String paramString2, SQLiteDatabase paramSQLiteDatabase, String paramString3)
  {
    paramStringBuilder.append(paramString1);
    paramStringBuilder.append(paramString2);
    paramSQLiteDatabase.execSQL(paramStringBuilder.toString());
    paramStringBuilder = new java.lang.StringBuilder();
    paramStringBuilder.append(paramString3);
    return paramStringBuilder;
  }
  
  public static void append(String paramString, int paramInt)
  {
    java.lang.StringBuilder localStringBuilder = new java.lang.StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append(paramInt);
    localStringBuilder.toString();
  }
  
  public static void append(String paramString, Object paramObject)
  {
    java.lang.StringBuilder localStringBuilder = new java.lang.StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append(paramObject);
    localStringBuilder.toString();
  }
  
  public static void append(java.lang.StringBuilder paramStringBuilder, String paramString1, char paramChar, String paramString2)
  {
    paramStringBuilder.append(paramString1);
    paramStringBuilder.append(paramChar);
    paramStringBuilder.append(paramString2);
  }
  
  public static void append(java.lang.StringBuilder paramStringBuilder, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    paramStringBuilder.append(paramString1);
    paramStringBuilder.append(paramString2);
    paramStringBuilder.append(paramString3);
    paramStringBuilder.append(paramString4);
  }
  
  public static String apply(Exception paramException, java.lang.StringBuilder paramStringBuilder)
  {
    paramStringBuilder.append(paramException.toString());
    return paramStringBuilder.toString();
  }
  
  public static ASN1EncodableVector buildUnauthenticatedAttributes(ASN1EncodableVector paramASN1EncodableVector1, ASN1EncodableVector paramASN1EncodableVector2)
  {
    paramASN1EncodableVector2.add(new DERSequence(paramASN1EncodableVector1));
    return new ASN1EncodableVector();
  }
  
  public static void configure(java.lang.StringBuilder paramStringBuilder, Object paramObject, ConfigurableProvider paramConfigurableProvider, String paramString)
  {
    paramStringBuilder.append(paramObject);
    paramConfigurableProvider.addAlgorithm(paramStringBuilder.toString(), paramString);
  }
  
  public static Dialog create(Context paramContext, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    paramContext = new Dialog(paramContext);
    paramContext.getWindow();
    paramContext.requestWindowFeature(paramInt1);
    paramContext.setContentView(paramInt2);
    paramContext.setCancelable(paramBoolean);
    paramContext.show();
    return paramContext;
  }
  
  public static String decode(ASN1Sequence paramASN1Sequence, java.lang.StringBuilder paramStringBuilder)
  {
    paramStringBuilder.append(paramASN1Sequence.size());
    return paramStringBuilder.toString();
  }
  
  public static java.lang.StringBuilder defaultAction(java.lang.StringBuilder paramStringBuilder, Object paramObject, ConfigurableProvider paramConfigurableProvider, String paramString)
  {
    paramStringBuilder.append(paramObject);
    paramConfigurableProvider.addAlgorithm(paramStringBuilder.toString(), paramString);
    return new java.lang.StringBuilder();
  }
  
  public static int digest(zzeye paramZzeye, zzeyn paramZzeyn, int paramInt1, int paramInt2)
  {
    paramZzeye.digest(paramZzeyn);
    paramZzeye.zzcsn();
    return paramInt1 + paramInt2;
  }
  
  public static String e(Exception paramException, java.lang.StringBuilder paramStringBuilder)
  {
    paramStringBuilder.append(paramException.getMessage());
    return paramStringBuilder.toString();
  }
  
  public static boolean evaluate(LoginScreen paramLoginScreen, String paramString)
  {
    return LoginScreen.e(paramLoginScreen).getText().toString().equalsIgnoreCase(paramString);
  }
  
  public static void fill(int paramInt1, int paramInt2, int paramInt3, Object paramObject1, int paramInt4, Object paramObject2, int paramInt5)
  {
    System.arraycopy(paramObject1, paramInt4, paramObject2, paramInt5, paramInt1 - paramInt2 - paramInt3);
  }
  
  public static String format(String paramString, int paramInt1, int paramInt2)
  {
    return paramString.substring(paramInt2, paramString.length() + paramInt1);
  }
  
  public static String generate(GeneralSecurityException paramGeneralSecurityException, java.lang.StringBuilder paramStringBuilder)
  {
    paramStringBuilder.append(paramGeneralSecurityException.getMessage());
    return paramStringBuilder.toString();
  }
  
  public static Intent get(Context paramContext, Class paramClass, String paramString1, String paramString2)
  {
    paramContext = new Intent(paramContext, paramClass);
    paramContext.putExtra(paramString1, paramString2);
    return paramContext;
  }
  
  public static Object get(List paramList, int paramInt)
  {
    return paramList.get(paramList.size() + paramInt);
  }
  
  public static String get(IOException paramIOException, java.lang.StringBuilder paramStringBuilder)
  {
    paramStringBuilder.append(paramIOException.getMessage());
    return paramStringBuilder.toString();
  }
  
  public static String get(Class paramClass, java.lang.StringBuilder paramStringBuilder, String paramString)
  {
    paramStringBuilder.append(paramClass.getName());
    paramStringBuilder.append(paramString);
    return paramStringBuilder.toString();
  }
  
  public static String get(String paramString, long paramLong)
  {
    java.lang.StringBuilder localStringBuilder = new java.lang.StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append(paramLong);
    return localStringBuilder.toString();
  }
  
  public static TextParseException get(String paramString1, String paramString2, Tokenizer paramTokenizer)
  {
    java.lang.StringBuilder localStringBuilder = new java.lang.StringBuilder();
    localStringBuilder.append(paramString1);
    localStringBuilder.append(paramString2);
    return paramTokenizer.exception(localStringBuilder.toString());
  }
  
  public static void get(String paramString1, String paramString2)
  {
    java.lang.StringBuilder localStringBuilder = new java.lang.StringBuilder();
    localStringBuilder.append(paramString1);
    localStringBuilder.append(paramString2);
    localStringBuilder.toString();
  }
  
  public static boolean getBoolean(AppCompatActivity paramAppCompatActivity, int paramInt, String paramString)
  {
    return paramString.equalsIgnoreCase(paramAppCompatActivity.getResources().getString(paramInt));
  }
  
  public static byte[] getKey(ASN1Sequence paramASN1Sequence, int paramInt)
  {
    return Arrays.clone(ASN1OctetString.getInstance(paramASN1Sequence.getObjectAt(paramInt)).getOctets());
  }
  
  public static String getString(Activity paramActivity, String paramString)
  {
    return paramActivity.getIntent().getExtras().getString(paramString);
  }
  
  public static java.lang.StringBuilder getTag(JoinPoint paramJoinPoint, String paramString)
  {
    Factory.aspectOf().before(paramJoinPoint);
    return new java.lang.StringBuilder(paramString);
  }
  
  public static StringBuffer getText(String paramString)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append(paramString);
    return localStringBuffer;
  }
  
  public static String getVersion(ASN1TaggedObject paramASN1TaggedObject, java.lang.StringBuilder paramStringBuilder)
  {
    paramStringBuilder.append(paramASN1TaggedObject.getTagNo());
    return paramStringBuilder.toString();
  }
  
  public static View getView(AppCompatActivity paramAppCompatActivity, int paramInt1, Activity paramActivity, String paramString, int paramInt2)
  {
    paramAppCompatActivity.setContentView(paramInt1);
    k.a.a.m.Log.execute(paramActivity, paramString);
    return paramAppCompatActivity.findViewById(paramInt2);
  }
  
  public static View inflate(ViewGroup paramViewGroup1, int paramInt, ViewGroup paramViewGroup2, boolean paramBoolean)
  {
    return LayoutInflater.from(paramViewGroup1.getContext()).inflate(paramInt, paramViewGroup2, paramBoolean);
  }
  
  public static void inflate(AppCompatActivity paramAppCompatActivity, Toolbar paramToolbar, boolean paramBoolean)
  {
    paramAppCompatActivity.setSupportActionBar(paramToolbar);
    paramAppCompatActivity.getSupportActionBar().setDisplayHomeAsUpEnabled(paramBoolean);
  }
  
  public static void init(AppCompatActivity paramAppCompatActivity, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    paramAppCompatActivity.findViewById(paramInt1).setVisibility(paramInt2);
    paramAppCompatActivity.findViewById(paramInt3).setVisibility(paramInt4);
  }
  
  public static void insert(String paramString1, String paramString2, org.apache.commons.logging.Log paramLog)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append(paramString1);
    localStringBuffer.append(paramString2);
    paramLog.debug(localStringBuffer.toString());
  }
  
  public static ASN1ObjectIdentifier intern(String paramString)
  {
    return new ASN1ObjectIdentifier(paramString).intern();
  }
  
  public static int layout(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    return paramInt1 + paramInt2 + paramInt3 + paramInt4;
  }
  
  public static long length(long paramLong1, long paramLong2, long paramLong3, long paramLong4)
  {
    return paramLong1 * paramLong2 + paramLong3 + paramLong4;
  }
  
  public static ECFieldElement multiplyPlusProduct(ECFieldElement paramECFieldElement1, ECFieldElement paramECFieldElement2, ECFieldElement paramECFieldElement3)
  {
    return paramECFieldElement1.square().add(paramECFieldElement2).add(paramECFieldElement3);
  }
  
  public static ArrayList newArrayList(Object paramObject)
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(paramObject);
    return localArrayList;
  }
  
  public static void println(String paramString, Object paramObject, PrintStream paramPrintStream)
  {
    java.lang.StringBuilder localStringBuilder = new java.lang.StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append(paramObject);
    paramPrintStream.println(localStringBuilder.toString());
  }
  
  public static Bundle put(String paramString1, String paramString2)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString(paramString1, paramString2);
    return localBundle;
  }
  
  public static void put(int paramInt, String paramString, Map paramMap, Object paramObject)
  {
    paramMap.put(paramObject, new DefaultXMSSMTOid(paramInt, paramString));
  }
  
  public static String replace(java.lang.StringBuilder paramStringBuilder, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    paramStringBuilder.append(paramString1);
    paramStringBuilder.append(paramString2);
    paramStringBuilder.append(paramString3);
    paramStringBuilder.append(paramString4);
    return paramStringBuilder.toString();
  }
  
  public static void setAllCaps(EditText paramEditText)
  {
    paramEditText.setTransformationMethod(new AllCapsTransformationMethod());
  }
  
  public static void setText(AppCompatActivity paramAppCompatActivity, int paramInt, TextView paramTextView)
  {
    paramTextView.setText(paramAppCompatActivity.getResources().getString(paramInt));
  }
  
  public static void show(AppCompatActivity paramAppCompatActivity, int paramInt1, Context paramContext, int paramInt2)
  {
    Toast.makeText(paramContext, paramAppCompatActivity.getResources().getString(paramInt1), paramInt2).show();
  }
  
  public static void show(AppCompatActivity paramAppCompatActivity, int paramInt, Intent paramIntent, String paramString)
  {
    paramIntent.putExtra(paramString, paramAppCompatActivity.getResources().getString(paramInt));
  }
  
  public static void showDialog(AppCompatActivity paramAppCompatActivity, int paramInt, Context paramContext)
  {
    k.a.a.m.Log.showDialog(paramContext, paramAppCompatActivity.getResources().getString(paramInt));
  }
  
  public static String sign(SignatureException paramSignatureException, java.lang.StringBuilder paramStringBuilder)
  {
    paramStringBuilder.append(paramSignatureException.getMessage());
    return paramStringBuilder.toString();
  }
  
  public static int size(Object[] paramArrayOfObject, int paramInt1, int paramInt2)
  {
    return (zzeyl.hashCode(paramArrayOfObject) + paramInt1) * paramInt2;
  }
  
  public static String slice(String paramString, int paramInt1, int paramInt2)
  {
    return paramString.substring(paramString.indexOf(paramInt1) + paramInt2);
  }
  
  public static void startActivity(Activity paramActivity, Class paramClass)
  {
    paramActivity.startActivity(new Intent(paramActivity, paramClass));
  }
  
  public static String substring(String paramString, int paramInt1, int paramInt2)
  {
    return paramString.substring(paramInt2, paramString.length() - paramInt1);
  }
  
  public static String substring(String paramString1, String paramString2)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append(paramString1);
    localStringBuffer.append(paramString2);
    return localStringBuffer.toString();
  }
  
  public static java.lang.StringBuilder toHtml(java.lang.StringBuilder paramStringBuilder, String paramString1, String paramString2, ConfigurableProvider paramConfigurableProvider, String paramString3)
  {
    paramStringBuilder.append(paramString1);
    paramStringBuilder.append(paramString2);
    paramConfigurableProvider.addAlgorithm(paramString3, paramStringBuilder.toString());
    return new java.lang.StringBuilder();
  }
  
  public static String toString(Object paramObject, java.lang.StringBuilder paramStringBuilder)
  {
    paramStringBuilder.append(paramObject.getClass().getName());
    return paramStringBuilder.toString();
  }
  
  public static String toString(String paramString, int paramInt)
  {
    java.lang.StringBuilder localStringBuilder = new java.lang.StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append(paramInt);
    return localStringBuilder.toString();
  }
  
  public static String toString(String paramString1, int paramInt, String paramString2)
  {
    java.lang.StringBuilder localStringBuilder = new java.lang.StringBuilder();
    localStringBuilder.append(paramString1);
    localStringBuilder.append(paramInt);
    localStringBuilder.append(paramString2);
    return localStringBuilder.toString();
  }
  
  public static String toString(String paramString, Object paramObject)
  {
    java.lang.StringBuilder localStringBuilder = new java.lang.StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append(paramObject);
    return localStringBuilder.toString();
  }
  
  public static String toString(String paramString1, Object paramObject, String paramString2)
  {
    java.lang.StringBuilder localStringBuilder = new java.lang.StringBuilder();
    localStringBuilder.append(paramString1);
    localStringBuilder.append(paramObject);
    localStringBuilder.append(paramString2);
    return localStringBuilder.toString();
  }
  
  public static String toString(String paramString1, String paramString2)
  {
    java.lang.StringBuilder localStringBuilder = new java.lang.StringBuilder();
    localStringBuilder.append(paramString1);
    localStringBuilder.append(paramString2);
    return localStringBuilder.toString();
  }
  
  public static String toString(java.lang.StringBuilder paramStringBuilder, Object paramObject, char paramChar)
  {
    paramStringBuilder.append(paramObject);
    paramStringBuilder.append(paramChar);
    return paramStringBuilder.toString();
  }
  
  public static void toString(String paramString1, String paramString2, String paramString3)
  {
    java.lang.StringBuilder localStringBuilder = new java.lang.StringBuilder();
    localStringBuilder.append(paramString1);
    localStringBuilder.append(paramString2);
    localStringBuilder.append(paramString3);
    localStringBuilder.toString();
  }
  
  public static int translate(String paramString1, String paramString2)
  {
    java.lang.StringBuilder localStringBuilder = new java.lang.StringBuilder();
    localStringBuilder.append(paramString1);
    localStringBuilder.append(paramString2);
    return localStringBuilder.toString().length();
  }
  
  public static int update(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    return NTLMEngineImpl.rotintlft(paramInt1 + paramInt2 + paramInt3, paramInt4);
  }
  
  public static void update(Activity paramActivity, String paramString1, Intent paramIntent, String paramString2)
  {
    paramIntent.putExtra(paramString2, paramActivity.getIntent().getStringExtra(paramString1));
  }
  
  public static void write(java.lang.StringBuilder paramStringBuilder, String paramString1, String paramString2, String paramString3)
  {
    paramStringBuilder.append(paramString1);
    paramStringBuilder.append(paramString2);
    paramStringBuilder.append(paramString3);
  }
}
