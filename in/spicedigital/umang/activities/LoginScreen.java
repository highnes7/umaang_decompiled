package in.spicedigital.umang.activities;

import android.app.Activity;
import android.app.Dialog;
import android.content.ContextWrapper;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.os.AsyncTask;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v4.package_7.ActivityCompat;
import android.support.v4.package_7.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.text.TextWatcher;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.TextView;
import android.widget.Toast;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookSdk;
import com.facebook.appevents.AppEventsLogger;
import com.facebook.internal.CallbackManagerImpl;
import com.facebook.login.LoginManager;
import com.google.android.android.auth.dashclock.Auth;
import com.google.android.android.auth.dashclock.signin.GoogleSignInAccount;
import com.google.android.android.auth.dashclock.signin.GoogleSignInApi;
import com.google.android.android.auth.dashclock.signin.GoogleSignInOptions;
import com.google.android.android.auth.dashclock.signin.GoogleSignInOptions.Builder;
import com.google.android.android.auth.dashclock.signin.GoogleSignInResult;
import com.google.android.android.common.ConnectionResult;
import com.google.android.android.common.package_9.GoogleApiClient;
import com.google.android.android.common.package_9.GoogleApiClient.Builder;
import com.google.android.android.common.package_9.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.android.common.package_9.PendingResult;
import com.google.android.android.common.package_9.ResultCallback;
import f.objectweb.asm.e;
import f.objectweb.asm.h;
import f.u.a.a.a.a.l;
import internal.view.menu.k;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.Executor;
import k.a.a.a.Aj;
import k.a.a.a.Bj;
import k.a.a.a.Dj;
import k.a.a.a.Ej;
import k.a.a.a.Fj;
import k.a.a.a.Gj;
import k.a.a.a.Hj;
import k.a.a.a.Nj;
import k.a.a.a.Oj;
import k.a.a.a.Pj;
import k.a.a.a.Qj;
import k.a.a.a.Rj;
import k.a.a.a.Sj;
import k.a.a.a.Tj;
import k.a.a.a.Uj;
import k.a.a.a.Vj;
import k.a.a.a.Xj;
import k.a.a.a.Yj;
import k.a.a.a._j;
import k.a.a.a.ak;
import k.a.a.a.bk;
import k.a.a.a.ck;
import k.a.a.a.dk;
import k.a.a.a.ek;
import k.a.a.a.fk;
import k.a.a.a.gk;
import k.a.a.a.nj;
import k.a.a.a.oj;
import k.a.a.a.pj;
import k.a.a.a.qj;
import k.a.a.a.rj;
import k.a.a.a.tj;
import k.a.a.a.uj;
import k.a.a.a.vj;
import k.a.a.a.wj;
import k.a.a.a.xj;
import k.a.a.a.yj;
import k.a.a.a.zj;
import k.a.a.c.w;
import k.a.a.l.m;
import k.a.a.l.o;
import k.a.a.l.q;
import k.a.a.m.Log;
import k.a.a.m.Ma;
import org.json.JSONObject;
import support.android.v4.content.ContextCompat;

public class LoginScreen
  extends BaseActivity
  implements GoogleApiClient.OnConnectionFailedListener
{
  public static final int CV_CAP_PROP_IOS_DEVICE_FOCUS = 9001;
  public static final int KEYCODE_F10 = 140;
  public final int REQUEST_CODE_ASK_PERMISSIONS = 123;
  public EditText a;
  public LinearLayout activity;
  public EditText b;
  public EditText c;
  public Button d;
  public ArrayList<w> data;
  public LinearLayout doneButton;
  public TextWatcher filterTextWatcher = (TextWatcher)new Uj(this);
  public String found = "google";
  public String fragment = "LoginScreen";
  public boolean g;
  public ArrayList<String> id;
  public ImageView image;
  public ImageView item;
  public LinearLayout l;
  public ImageView list;
  public LinearLayout mCancelButton;
  public ImageView mClearButton;
  public RadioButton mContext;
  public ImageView mDeleteButton;
  public GoogleSignInOptions mDialog;
  public GoogleApiClient mFavorites;
  public TextView mInfo;
  public RadioButton mIsDefault;
  public CallbackManager mListView;
  public String mMessageText = "twitter";
  public k mPopup;
  public ImageView mShare;
  public ArrayList<String> name;
  public ImageView nextButton;
  public TextView path;
  public ImageView prevButton;
  public LinearLayout r;
  public ImageView settings;
  public LinearLayout text;
  public RadioButton theme;
  public k.a.a.m.f this$0;
  public RadioButton title;
  public String translation;
  public RadioGroup type;
  public String updater = "fb";
  public TextView user;
  public TextView versionName;
  public ImageView view;
  public l y;
  
  public LoginScreen() {}
  
  private void a()
  {
    if (this$0.get(k.a.a.m.f.t, "false").equalsIgnoreCase("true"))
    {
      Object localObject = Typeface.create("sans-serif-", 0);
      localObject = new h(this).a(new f.objectweb.asm.f[] { new e(path, getResources().getString(2131755897), getResources().getString(2131755898)).b((Typeface)localObject) });
      ((h)localObject).a(true);
      ((h)localObject).c(true);
      ((h)localObject).c();
      this$0.append(k.a.a.m.f.t, "false");
    }
  }
  
  private void add(String paramString1, String paramString2, String paramString3)
  {
    f.sufficientlysecure.rootcommands.util.StringBuilder.get("Requesting Login for == ", paramString1);
    this$0.append(k.a.a.m.f.this$0, "");
    try
    {
      JSONObject localJSONObject2 = Log.execute(this);
      JSONObject localJSONObject1 = localJSONObject2;
      boolean bool = paramString1.equalsIgnoreCase("OTP");
      if (bool)
      {
        paramString1 = localJSONObject1;
      }
      else
      {
        bool = paramString1.equalsIgnoreCase("MOB");
        if (bool)
        {
          paramString1 = new Ma();
          paramString3 = c;
          localJSONObject2.put("mno", paramString3.getText().toString());
          localJSONObject2.put("type", "mobm");
          paramString3 = a;
          localJSONObject2.put("lid", paramString1.a(Log.toString(this, paramString3.getText().toString().trim())));
          paramString1 = localJSONObject1;
        }
        else
        {
          bool = paramString1.equalsIgnoreCase("SOC");
          paramString1 = localJSONObject1;
          if (bool)
          {
            localJSONObject2.put("type", "soc");
            localJSONObject2.put("lid", paramString3);
            localJSONObject2.put("stype", paramString2);
            paramString1 = localJSONObject1;
          }
        }
      }
    }
    catch (Exception paramString1)
    {
      k.a.a.m.StringBuilder.append((Exception)paramString1);
      paramString1 = null;
    }
    if (paramString1 != null) {
      ((AsyncTask)new q((k.a.a.i.List)new Nj(this, paramString2), paramString1, this)).execute(new Object[0]);
    }
  }
  
  private boolean add()
  {
    if (g)
    {
      if (b.getText().toString().length() < 12)
      {
        finishWithError(getResources().getString(2131755664));
        return false;
      }
      if (!Log.apply(b.getText().toString()))
      {
        finishWithError(getResources().getString(2131755666));
        return false;
      }
    }
    else
    {
      if (b.getText().toString().length() < 16)
      {
        finishWithError(getResources().getString(2131755665));
        return false;
      }
      if (!Log.matches(b.getText().toString()))
      {
        finishWithError(getResources().getString(2131755667));
        return false;
      }
    }
    return true;
  }
  
  private void addToFavorites(GoogleSignInResult paramGoogleSignInResult)
  {
    if (paramGoogleSignInResult != null)
    {
      if (paramGoogleSignInResult.isSuccess())
      {
        paramGoogleSignInResult = paramGoogleSignInResult.getSignInAccount();
        localObject = f.sufficientlysecure.rootcommands.util.StringBuilder.append("Google ID = ");
        ((StringBuilder)localObject).append(paramGoogleSignInResult.getId());
        ((StringBuilder)localObject).append(" == Name == ");
        ((StringBuilder)localObject).append(paramGoogleSignInResult.getDisplayName());
        ((StringBuilder)localObject).toString();
        add("SOC", found, paramGoogleSignInResult.getId());
        return;
      }
      paramGoogleSignInResult = Auth.GoogleSignInApi;
      localObject = mFavorites;
    }
    try
    {
      paramGoogleSignInResult = paramGoogleSignInResult.signOut((GoogleApiClient)localObject);
      localObject = new Gj(this);
      localObject = (ResultCallback)localObject;
      paramGoogleSignInResult.setResultCallback((ResultCallback)localObject);
      return;
    }
    catch (Exception paramGoogleSignInResult) {}
    paramGoogleSignInResult = Auth.GoogleSignInApi;
    Object localObject = mFavorites;
    try
    {
      paramGoogleSignInResult = paramGoogleSignInResult.signOut((GoogleApiClient)localObject);
      localObject = new Hj(this);
      localObject = (ResultCallback)localObject;
      paramGoogleSignInResult.setResultCallback((ResultCallback)localObject);
      return;
    }
    catch (Exception paramGoogleSignInResult)
    {
      k.a.a.m.StringBuilder.append(paramGoogleSignInResult);
      return;
    }
  }
  
  private String apply(String paramString1, String paramString2, int paramInt)
  {
    String str = translation;
    if ((str != null) && (str.length() > 1))
    {
      int i = translate(translation);
      int j = translate(paramString1);
      paramString1 = new StringBuilder();
      paramString1.append(i);
      paramString1.append(" =//= ");
      paramString1.append(j);
      paramString1.append(" ==//==");
      paramString1.append(paramInt);
      paramString1.toString();
      if (j < i)
      {
        paramString1 = new StringBuilder();
        paramString1.append(paramString2.substring(0, paramInt));
        paramString1.append(paramString2.substring(paramInt));
        return toString(replace(paramString1.toString()));
      }
    }
    return paramString2;
  }
  
  private boolean checkPermission(java.util.List paramList, String paramString)
  {
    if (ContextCompat.checkSelfPermission(this, paramString) != 0)
    {
      paramList.add(paramString);
      if (!ActivityCompat.shouldShowRequestPermissionRationale(this, paramString)) {
        return false;
      }
    }
    return true;
  }
  
  private void clear()
  {
    this$0.append(k.a.a.m.f.this$0, "");
    JSONObject localJSONObject2;
    try
    {
      JSONObject localJSONObject3 = Log.execute(this);
      JSONObject localJSONObject1 = localJSONObject3;
      EditText localEditText = b;
      localJSONObject3.put("aadhr", localEditText.getText().toString());
      localJSONObject3.put("ort", "loginadhr");
    }
    catch (Exception localException)
    {
      k.a.a.m.StringBuilder.append(localException);
      localJSONObject2 = null;
    }
    if (localJSONObject2 != null) {
      new k.a.a.l.List((k.a.a.i.List)new Oj(this), "https://app.umang.gov.in/umang/coreapi/ws2/initaadhv1", localJSONObject2, this).execute(new Object[0]);
    }
  }
  
  private void d()
  {
    y = new l();
    y.a(this, new Fj(this));
  }
  
  private void finishWithError(String paramString)
  {
    Toast.makeText(this, paramString, 1).show();
  }
  
  private boolean get()
  {
    if (c.getText().toString().trim().isEmpty())
    {
      finishWithError(getResources().getString(2131755929));
      return false;
    }
    if (c.getText().toString().length() < 10)
    {
      finishWithError(getResources().getString(2131755671));
      return false;
    }
    if (!"6789".contains(c.getText().toString().substring(0, 1)))
    {
      finishWithError(getResources().getString(2131756113));
      return false;
    }
    if ((a.getText().toString().length() != 0) && (a.getText().toString().length() >= 4)) {
      return true;
    }
    finishWithError(getResources().getString(2131755674));
    return false;
  }
  
  private boolean getValue()
  {
    if (c.getText().toString().trim().isEmpty())
    {
      finishWithError(getResources().getString(2131755929));
      return false;
    }
    if (c.getText().toString().length() < 10)
    {
      finishWithError(getResources().getString(2131755671));
      return false;
    }
    if (!"6789".contains(c.getText().toString().substring(0, 1)))
    {
      finishWithError(getResources().getString(2131756113));
      return false;
    }
    return true;
  }
  
  private void getView()
  {
    a.setEnabled(false);
    a.setFocusable(false);
    d.setText(getResources().getString(2131755339));
    theme.setChecked(true);
    title.setChecked(false);
  }
  
  private void handleMessages()
  {
    startActivityForResult(Auth.GoogleSignInApi.getSignInIntent(mFavorites), 9001);
  }
  
  private void init()
  {
    a.setEnabled(true);
    a.setFocusable(true);
    a.setFocusableInTouchMode(true);
    a.requestFocus();
    d.setText(getResources().getString(2131755891));
    theme.setChecked(false);
    title.setChecked(true);
  }
  
  private void initialize()
  {
    JSONObject localJSONObject2;
    try
    {
      JSONObject localJSONObject3 = Log.execute(this);
      JSONObject localJSONObject1 = localJSONObject3;
      EditText localEditText = c;
      localJSONObject3.put("mno", localEditText.getText().toString());
      localJSONObject3.put("ort", "loginmob");
    }
    catch (Exception localException)
    {
      k.a.a.m.StringBuilder.append(localException);
      localJSONObject2 = null;
    }
    if (localJSONObject2 != null) {
      ((AsyncTask)new m((k.a.a.i.List)new _j(this), localJSONObject2, this)).execute(new Object[0]);
    }
  }
  
  private void loadData(String paramString)
  {
    Object localObject;
    try
    {
      JSONObject localJSONObject2 = Log.execute(this);
      JSONObject localJSONObject1 = localJSONObject2;
      localJSONObject2.remove("lang");
      localJSONObject2.put("lang", paramString);
    }
    catch (Exception localException)
    {
      k.a.a.m.StringBuilder.append(localException);
      localObject = null;
    }
    if (localObject != null)
    {
      paramString = new o((k.a.a.i.List)new Yj(this, paramString), (JSONObject)localObject, this);
      localObject = AsyncTask.THREAD_POOL_EXECUTOR;
      ((AsyncTask)paramString).executeOnExecutor((Executor)localObject, new Object[0]);
    }
  }
  
  private void onActivityCreated()
  {
    Dialog localDialog = f.sufficientlysecure.rootcommands.util.StringBuilder.create(this, 1, 2131492944, true);
    ((TextView)localDialog.findViewById(2131297215)).setOnClickListener((View.OnClickListener)new Qj(this, localDialog));
    ((ImageView)localDialog.findViewById(2131296402)).setOnClickListener((View.OnClickListener)new Rj(this, localDialog));
    ((ImageView)localDialog.findViewById(2131296403)).setOnClickListener((View.OnClickListener)new Sj(this, localDialog));
    ((ImageView)localDialog.findViewById(2131296404)).setOnClickListener((View.OnClickListener)new Tj(this, localDialog));
  }
  
  private void parse()
  {
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    if (!checkPermission(localArrayList2, "android.permission.ACCESS_FINE_LOCATION")) {
      localArrayList1.add("GPS");
    }
    if (!checkPermission(localArrayList2, "android.permission.READ_PHONE_STATE")) {
      localArrayList1.add("Read Phone State");
    }
    if (localArrayList2.size() > 0)
    {
      if (localArrayList1.size() > 0)
      {
        this$0.append(k.a.a.m.f.r, "true");
        ActivityCompat.requestPermissions(this, (String[])localArrayList2.toArray(new String[localArrayList2.size()]), 123);
        return;
      }
      ActivityCompat.requestPermissions(this, (String[])localArrayList2.toArray(new String[localArrayList2.size()]), 123);
    }
  }
  
  private String replace(String paramString)
  {
    return paramString.toString().replaceAll("[^0-9]", "");
  }
  
  private void showDialog()
  {
    Dialog localDialog = new Dialog(this);
    localDialog.getWindow();
    localDialog.requestWindowFeature(1);
    localDialog.setContentView(2131492931);
    localDialog.setCancelable(false);
    TextView localTextView1 = (TextView)localDialog.findViewById(2131296574);
    TextView localTextView2 = (TextView)localDialog.findViewById(2131297122);
    localTextView1.setOnClickListener((View.OnClickListener)new Vj(this, localDialog));
    localTextView2.setOnClickListener((View.OnClickListener)new Xj(this));
    localDialog.show();
  }
  
  private void showKeyboard()
  {
    getWindow().setSoftInputMode(3);
    ((InputMethodManager)getSystemService("input_method")).toggleSoftInput(1, 0);
  }
  
  private String toString(String paramString)
  {
    Object localObject = "";
    int j = 0;
    int i = 0;
    while (j < paramString.length())
    {
      localObject = f.sufficientlysecure.rootcommands.util.StringBuilder.append((String)localObject);
      ((StringBuilder)localObject).append(paramString.charAt(j));
      String str = ((StringBuilder)localObject).toString();
      localObject = str;
      int k = i + 1;
      i = k;
      if (k == 4)
      {
        localObject = f.sufficientlysecure.rootcommands.util.StringBuilder.toString(str, " ");
        i = 0;
      }
      j += 1;
    }
    if (paramString.length() == 12) {
      return f.sufficientlysecure.rootcommands.util.StringBuilder.format((String)localObject, -1, 0);
    }
    return localObject;
  }
  
  private int translate(String paramString)
  {
    return paramString.replaceAll(" ", "").length();
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    try
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("calling onActivityResult ");
      ((StringBuilder)localObject).append(paramInt1);
      ((StringBuilder)localObject).toString();
      if (paramInt1 == 9001)
      {
        localObject = Auth.GoogleSignInApi;
        addToFavorites(((GoogleSignInApi)localObject).getSignInResultFromIntent(paramIntent));
        return;
      }
      if (paramInt1 == 140)
      {
        localObject = y;
        ((l)localObject).a(paramInt1, paramInt2, paramIntent);
        return;
      }
      localObject = mListView;
      ((CallbackManager)localObject).onActivityResult(paramInt1, paramInt2, paramIntent);
      return;
    }
    catch (Exception paramIntent)
    {
      k.a.a.m.StringBuilder.append(paramIntent);
    }
  }
  
  public void onConnectionFailed(ConnectionResult paramConnectionResult) {}
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2131493139);
    Log.execute(this, "Login Screen");
    try
    {
      Log.inject(this, findViewById(2131297260));
      FacebookSdk.sdkInitialize(getApplicationContext());
      AppEventsLogger.activateApp(this);
      Log.init(this);
      mListView = new CallbackManagerImpl();
      mDialog = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN).requestProfile().build();
      mFavorites = new GoogleApiClient.Builder(this).enableAutoManage(this, this).addApi(Auth.GOOGLE_SIGN_IN_API, mDialog).build();
      this$0 = new k.a.a.m.f(this);
      paramBundle = this$0;
      Object localObject = k.a.a.m.f.uri;
      try
      {
        paramBundle.append((String)localObject, "false");
      }
      catch (Exception paramBundle)
      {
        k.a.a.m.StringBuilder.append(paramBundle);
      }
      showKeyboard();
      text = ((LinearLayout)findViewById(2131297057));
      c = ((EditText)findViewById(2131297119));
      a = ((EditText)findViewById(2131297139));
      list = ((ImageView)findViewById(2131297101));
      doneButton = ((LinearLayout)findViewById(2131297120));
      l = ((LinearLayout)findViewById(2131296287));
      doneButton.setBackgroundResource(2131231220);
      l.setBackgroundResource(2131231221);
      doneButton.setBackgroundResource(2131231222);
      b = ((EditText)findViewById(2131296283));
      mCancelButton = ((LinearLayout)findViewById(2131296479));
      mDeleteButton = ((ImageView)findViewById(2131296484));
      mClearButton = ((ImageView)findViewById(2131296769));
      versionName = ((TextView)findViewById(2131296960));
      path = ((TextView)findViewById(2131297934));
      user = ((TextView)findViewById(2131297931));
      nextButton = ((ImageView)findViewById(2131296532));
      nextButton.setOnClickListener((View.OnClickListener)new yj(this));
      prevButton = ((ImageView)findViewById(2131296536));
      prevButton.setOnClickListener((View.OnClickListener)new Pj(this));
      image = ((ImageView)findViewById(2131296529));
      image.setOnClickListener((View.OnClickListener)new ak(this));
      theme = ((RadioButton)findViewById(2131297363));
      title = ((RadioButton)findViewById(2131297362));
      theme.setOnClickListener((View.OnClickListener)new bk(this));
      title.setOnClickListener((View.OnClickListener)new ck(this));
      if (this$0.get(k.a.a.m.f.value, "remove").equalsIgnoreCase("remove")) {
        text.setVisibility(8);
      } else {
        text.setVisibility(0);
      }
      c.addTextChangedListener((TextWatcher)new dk(this));
      a.addTextChangedListener((TextWatcher)new ek(this));
      b.addTextChangedListener(filterTextWatcher);
      activity = ((LinearLayout)findViewById(2131297065));
      r = ((LinearLayout)findViewById(2131297064));
      type = ((RadioGroup)findViewById(2131297347));
      mIsDefault = ((RadioButton)findViewById(2131296280));
      mContext = ((RadioButton)findViewById(2131297995));
      item = ((ImageView)findViewById(2131296926));
      activity.setVisibility(0);
      r.setVisibility(8);
      d = ((Button)findViewById(2131297061));
      d.setText(getResources().getString(2131755891));
      mIsDefault.setChecked(true);
      mContext.setChecked(false);
      g = true;
      type.setOnCheckedChangeListener((RadioGroup.OnCheckedChangeListener)new fk(this));
      d.setOnClickListener((View.OnClickListener)new gk(this));
      mInfo = ((TextView)findViewById(2131297399));
      mInfo.setOnClickListener((View.OnClickListener)new nj(this));
      findViewById(2131297725).setOnClickListener((View.OnClickListener)new oj(this));
      doneButton.setOnClickListener((View.OnClickListener)new pj(this));
      l.setOnClickListener((View.OnClickListener)new qj(this));
      mShare = ((ImageView)findViewById(2131296780));
      paramBundle = Arrays.asList(new String[] { "email", "public_profile" });
      mShare.setOnClickListener((View.OnClickListener)new rj(this, paramBundle));
      LoginManager.getInstance().registerCallback(mListView, (FacebookCallback)new tj(this));
      view = ((ImageView)findViewById(2131296842));
      view.setOnClickListener((View.OnClickListener)new uj(this));
      settings = ((ImageView)findViewById(2131297916));
      settings.setOnClickListener((View.OnClickListener)new vj(this));
      user.setOnClickListener((View.OnClickListener)new wj(this));
      path.setOnClickListener((View.OnClickListener)new xj(this));
      if ((Build.VERSION.SDK_INT > 22) && (this$0.get(k.a.a.m.f.r, "false").equalsIgnoreCase("false"))) {
        parse();
      }
      id = Log.read(this);
      name = Log.parse();
      data = new ArrayList();
      paramBundle = this$0.get(k.a.a.m.f.c, "en");
      int i = 0;
      while (i < name.size())
      {
        localObject = new w();
        ((w)localObject).c((String)name.get(i));
        ((w)localObject).a((String)id.get(i));
        if (((String)name.get(i)).equalsIgnoreCase(paramBundle))
        {
          ((w)localObject).a(true);
          versionName.setText(((String)id.get(i)).toUpperCase());
        }
        else
        {
          ((w)localObject).a(false);
        }
        data.add(localObject);
        i += 1;
      }
      mCancelButton.setOnClickListener((View.OnClickListener)new zj(this));
      mDeleteButton.setOnClickListener((View.OnClickListener)new Aj(this));
      mClearButton.setOnClickListener((View.OnClickListener)new Bj(this));
      list.setOnClickListener((View.OnClickListener)new Dj(this));
      item.setOnClickListener((View.OnClickListener)new Ej(this));
      a();
      if (activity.getVisibility() == 0)
      {
        if (theme.isChecked())
        {
          d.setText(getResources().getString(2131755339));
          return;
        }
        d.setText(getResources().getString(2131755891));
        return;
      }
      d.setText(getResources().getString(2131755339));
      return;
    }
    catch (Exception paramBundle)
    {
      for (;;) {}
    }
  }
  
  public void onDestroy()
  {
    super.onDestroy();
  }
  
  public void onResume()
  {
    super.onResume();
    if (activity.getVisibility() == 0)
    {
      if (theme.isChecked())
      {
        d.setText(getResources().getString(2131755339));
        return;
      }
      d.setText(getResources().getString(2131755891));
      return;
    }
    d.setText(getResources().getString(2131755339));
  }
}
