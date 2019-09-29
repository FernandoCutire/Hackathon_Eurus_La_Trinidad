import java.io.*;
import java.net.URL;
import java.net.*;


  public class download_URL implements Runnable {
	 
	 String link;
	 File out;
	 
	 public download_URL(String link, File out) {
		 
		 this.link = link;
		 this.out = out;
		 
	 }
	 
	 @Override

	public void run() {
		 
		 try {
			 URL url = new URL(link);
			 HttpURLConnection http = (HttpURLConnection)url.openConnection();
			 double fileSize = (double)http.getContentLengthLong();
			BufferedInputStream in = new BufferedInputStream(http.getInputStream());
			FileOutputStream fos = new FileOutputStream(this.out);
			BufferedOutputStream bout = new BufferedOutputStream(fos, 1024);
			byte[] buffer = new byte [1024];
			double downloaded = 0.00;
			int read=0;
			double percentDownloaded = 0.00;
			while ((read =in.read(buffer, 0, 1024)) >=0) {
				bout.write(buffer, 0, read);
				downloaded += read;
				percentDownloaded = (downloaded*100/fileSize);
				String percent = String.format("%.4f", percentDownloaded);
				System.out.println("descarga"+percent+ "% de un archivo");
			}
			bout.close();
			in.close();
			System.out.println("descarga completa.");
		 }
		catch (IOException ex){
            ex.printStackTrace();
	}

}
  }
  
  