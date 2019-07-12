package com.github.mikephil.charting.utils;

import android.content.res.AssetManager;
import android.os.Environment;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.Entry;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FileUtils
{
  public static final String LOG = "MPChart-FileUtils";
  
  public FileUtils() {}
  
  public static List loadBarEntriesFromAssets(AssetManager paramAssetManager, String paramString)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: fail exe a5 = a4\n\tat com.googlecode.dex2jar.ir.ts.an.BaseAnalyze.exec(BaseAnalyze.java:92)\n\tat com.googlecode.dex2jar.ir.ts.an.BaseAnalyze.exec(BaseAnalyze.java:1)\n\tat com.googlecode.dex2jar.ir.ts.Cfg.dfs(Cfg.java:255)\n\tat com.googlecode.dex2jar.ir.ts.an.BaseAnalyze.analyze0(BaseAnalyze.java:75)\n\tat com.googlecode.dex2jar.ir.ts.an.BaseAnalyze.analyze(BaseAnalyze.java:69)\n\tat com.googlecode.dex2jar.ir.ts.UnSSATransformer.transform(UnSSATransformer.java:274)\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:163)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\nCaused by: java.lang.NullPointerException\n");
  }
  
  public static List loadEntriesFromAssets(AssetManager paramAssetManager, String paramString)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: fail exe a5 = a4\n\tat com.googlecode.dex2jar.ir.ts.an.BaseAnalyze.exec(BaseAnalyze.java:92)\n\tat com.googlecode.dex2jar.ir.ts.an.BaseAnalyze.exec(BaseAnalyze.java:1)\n\tat com.googlecode.dex2jar.ir.ts.Cfg.dfs(Cfg.java:255)\n\tat com.googlecode.dex2jar.ir.ts.an.BaseAnalyze.analyze0(BaseAnalyze.java:75)\n\tat com.googlecode.dex2jar.ir.ts.an.BaseAnalyze.analyze(BaseAnalyze.java:69)\n\tat com.googlecode.dex2jar.ir.ts.UnSSATransformer.transform(UnSSATransformer.java:274)\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:163)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\nCaused by: java.lang.NullPointerException\n");
  }
  
  public static List loadEntriesFromFile(String paramString)
  {
    Object localObject1 = new File(Environment.getExternalStorageDirectory(), paramString);
    paramString = new ArrayList();
    try
    {
      localObject1 = new BufferedReader(new FileReader((File)localObject1));
      for (;;)
      {
        Object localObject2 = ((BufferedReader)localObject1).readLine();
        if (localObject2 == null) {
          break;
        }
        localObject2 = ((String)localObject2).split("#");
        int j = localObject2.length;
        int i = 0;
        Object localObject3;
        float f;
        if (j <= 2)
        {
          localObject3 = localObject2[0];
          f = Float.parseFloat((String)localObject3);
          localObject2 = localObject2[1];
          paramString.add(new Entry(f, Integer.parseInt((String)localObject2)));
        }
        else
        {
          localObject3 = new float[localObject2.length - 1];
          while (i < localObject3.length)
          {
            String str = localObject2[i];
            f = Float.parseFloat(str);
            localObject3[i] = f;
            i += 1;
          }
          localObject2 = localObject2[(localObject2.length - 1)];
          paramString.add(new BarEntry((float[])localObject3, Integer.parseInt((String)localObject2)));
        }
      }
      return paramString;
    }
    catch (IOException localIOException)
    {
      localIOException.toString();
    }
  }
  
  public static void saveToSdCard(List paramList, String paramString)
  {
    paramString = new File(Environment.getExternalStorageDirectory(), paramString);
    if (!paramString.exists()) {
      try
      {
        paramString.createNewFile();
      }
      catch (IOException localIOException)
      {
        localIOException.toString();
      }
    }
    try
    {
      paramString = new BufferedWriter(new FileWriter(paramString, true));
      paramList = paramList.iterator();
      for (;;)
      {
        boolean bool = paramList.hasNext();
        if (!bool) {
          break;
        }
        Object localObject = paramList.next();
        localObject = (Entry)localObject;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(((Entry)localObject).getVal());
        localStringBuilder.append("#");
        localStringBuilder.append(((Entry)localObject).getXIndex());
        paramString.append(localStringBuilder.toString());
        paramString.newLine();
      }
      paramString.close();
      return;
    }
    catch (IOException paramList)
    {
      paramList.toString();
    }
  }
}
