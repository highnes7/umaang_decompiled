package f.g.c.io;

import java.io.IOException;

public abstract class TokenFormulaParser
{
  public StringBuilder line = new StringBuilder();
  public boolean pos;
  
  public TokenFormulaParser() {}
  
  private boolean parse(boolean paramBoolean)
    throws IOException
  {
    String str2 = line.toString();
    String str1;
    if (pos)
    {
      if (paramBoolean) {
        str1 = "\r\n";
      } else {
        str1 = "\r";
      }
    }
    else if (paramBoolean) {
      str1 = "\n";
    } else {
      str1 = "";
    }
    handleLine(str2, str1);
    line = new StringBuilder();
    pos = false;
    return paramBoolean;
  }
  
  public abstract void handleLine(String paramString1, String paramString2)
    throws IOException;
  
  public void parse()
    throws IOException
  {
    if ((pos) || (line.length() > 0)) {
      parse(false);
    }
  }
  
  public void parse(char[] paramArrayOfChar, int paramInt1, int paramInt2)
    throws IOException
  {
    boolean bool;
    if ((pos) && (paramInt2 > 0))
    {
      if (paramArrayOfChar[paramInt1] == '\n') {
        bool = true;
      } else {
        bool = false;
      }
      parse(bool);
      if (bool)
      {
        i = paramInt1 + 1;
        break label51;
      }
    }
    int i = paramInt1;
    label51:
    int j = paramInt1 + paramInt2;
    paramInt2 = i;
    paramInt1 = i;
    while (paramInt1 < j)
    {
      i = paramArrayOfChar[paramInt1];
      if (i != 10)
      {
        if (i != 13)
        {
          i = paramInt2;
          break label191;
        }
        line.append(paramArrayOfChar, paramInt2, paramInt1 - paramInt2);
        pos = true;
        i = paramInt1 + 1;
        paramInt2 = paramInt1;
        if (i < j)
        {
          if (paramArrayOfChar[i] == '\n') {
            bool = true;
          } else {
            bool = false;
          }
          parse(bool);
          paramInt2 = paramInt1;
          if (bool) {
            paramInt2 = i;
          }
        }
      }
      else
      {
        line.append(paramArrayOfChar, paramInt2, paramInt1 - paramInt2);
        parse(true);
        paramInt2 = paramInt1;
      }
      i = paramInt2 + 1;
      paramInt1 = paramInt2;
      label191:
      paramInt1 += 1;
      paramInt2 = i;
    }
    line.append(paramArrayOfChar, paramInt2, j - paramInt2);
  }
}
