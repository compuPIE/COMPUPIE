package pages.helper;

import java.awt.Desktop;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

public class Browser
{
  public Browser(final String file, final String name)
  {
	  try {
		    // TODO add your handling code here:
		    String path = file;
		    System.out.println(path);
		    Path tempOutput = null;
		    String tempFile =name;
		    tempOutput = Files.createTempFile(tempFile, ".pdf");
		    tempOutput.toFile().deleteOnExit();
		    InputStream is = getClass().getClassLoader().getResourceAsStream(file);
		    Files.copy(is,tempOutput,StandardCopyOption.REPLACE_EXISTING);
		    if(Desktop.isDesktopSupported())
		    {
		        Desktop dTop = Desktop.getDesktop();
		        if(dTop.isSupported(Desktop.Action.OPEN))
		        {
		            dTop.open(tempOutput.toFile());
		        }
		    }
		} catch (IOException ex) {}

    }
  
  
}
