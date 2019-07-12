package k.a.a.m;

public class Label
{
  public static int[][] a;
  public static int[] b = { 0, 4, 3, 2, 1, 5, 6, 7, 8, 9 };
  public static int[][] c;
  
  static
  {
    int[] arrayOfInt1 = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 };
    int[] arrayOfInt2 = { 2, 3, 4, 0, 1, 7, 8, 9, 5, 6 };
    int[] arrayOfInt3 = { 4, 0, 1, 2, 3, 9, 5, 6, 7, 8 };
    int[] arrayOfInt4 = { 7, 6, 5, 9, 8, 2, 1, 0, 4, 3 };
    c = new int[][] { arrayOfInt1, { 1, 2, 3, 4, 0, 6, 7, 8, 9, 5 }, arrayOfInt2, { 3, 4, 0, 1, 2, 8, 9, 5, 6, 7 }, arrayOfInt3, { 5, 9, 8, 7, 6, 0, 4, 3, 2, 1 }, { 6, 5, 9, 8, 7, 1, 0, 4, 3, 2 }, arrayOfInt4, { 8, 7, 6, 5, 9, 3, 2, 1, 0, 4 }, { 9, 8, 7, 6, 5, 4, 3, 2, 1, 0 } };
    arrayOfInt1 = new int[] { 8, 9, 1, 6, 0, 4, 3, 5, 2, 7 };
    a = new int[][] { { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 }, { 1, 5, 7, 6, 2, 8, 3, 0, 9, 4 }, { 5, 8, 0, 3, 7, 9, 6, 1, 4, 2 }, arrayOfInt1, { 9, 4, 5, 3, 1, 2, 6, 8, 7, 0 }, { 4, 2, 8, 6, 5, 7, 3, 9, 0, 1 }, { 2, 7, 9, 3, 8, 0, 6, 4, 1, 5 }, { 7, 0, 4, 6, 9, 1, 3, 2, 5, 8 } };
  }
  
  public Label() {}
  
  public static int[] a(String paramString)
  {
    int[] arrayOfInt = new int[paramString.length()];
    int j;
    for (int i = 0; i < paramString.length(); i = j)
    {
      j = i + 1;
      arrayOfInt[i] = Integer.parseInt(paramString.substring(i, j));
    }
    return a(arrayOfInt);
  }
  
  public static int[] a(int[] paramArrayOfInt)
  {
    int[] arrayOfInt = new int[paramArrayOfInt.length];
    int j;
    for (int i = 0; i < paramArrayOfInt.length; i = j)
    {
      int k = paramArrayOfInt.length;
      j = i + 1;
      arrayOfInt[i] = paramArrayOfInt[(k - j)];
    }
    return arrayOfInt;
  }
  
  public static boolean b(String paramString)
  {
    paramString = a(paramString);
    int i = 0;
    int j = 0;
    while (i < paramString.length)
    {
      j = c[j][a[(i % 8)][paramString[i]]];
      i += 1;
    }
    return j == 0;
  }
}
