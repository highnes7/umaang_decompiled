package f.libs.asm.menu;

import java.io.File;

public final class FileList
  implements Qa.c
{
  public FileList(ClassWriter paramClassWriter) {}
  
  public File[] get()
  {
    return mFile.toByteArray();
  }
  
  public File[] getFile()
  {
    return mFile.listFiles();
  }
  
  public File[] listFiles()
  {
    return mFile.getParent().listFiles();
  }
}
