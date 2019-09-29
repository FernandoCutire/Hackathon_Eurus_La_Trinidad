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
  
  
  /*links[0] ="https://www.datosabiertos.gob.pa/dataset/mef-presupuesto-del-estado-2019";
			links[1] ="https://www.aeronautica.gob.pa/recursos/index.php?c=transparencia";	
			links[2] ="https://www.ana.gob.pa/w_ana/index.php/transparencia/transparencia/ejecucion-presupuestaria";
			links[3]="http://www.innovacion.gob.pa/finanzas";
			links[4]="https://amp.gob.pa/transparencia/estructura-y-ejecucion-presupuestaria/";
			links[5]="http://www.anati.gob.pa/index.php/10-2-estructura-y-ejecucion-presupuestaria";
			links[6]="https://www.antai.gob.pa/seccion_transparencia/#tab-id-2";
			links[7]="https://arap.gob.pa/transparencia/";
			links[8]="http://www.aaud.gob.pa/index.asp?sec=Transparencia/Articulo10&id=EstEjePre";
			links[9]="https://ampyme.gob.pa/?page_id=21075";
			links[10]="https://www.asep.gob.pa/?page_id=11770";
			links[11]="http://www.transito.gob.pa/transparencia";
			links[12]="https://www.aupsa.gob.pa/index.php/transparencia/";
			links[13]="http://www.bomberos.gob.pa/2018/10/10-2-estructura-presupuestaria/";
			links[14]="http://www.css.gob.pa/informacionfinancierapresupuestaria.html";
			links[15]="https://www.ifarhu.gob.pa/transparencia/10-2-estructura-y-ejecucion-presupuestaria/";
			links[16]="http://www.inadeh.edu.pa/transparencia";
			links[17]="https://www.elmetrodepanama.com/transparencia-3/estructura-presupuestaria-funcionamiento/";
			links[18]="https://www.senacyt.gob.pa/articulo-10/";
			links[19]="http://www.utp.ac.pa/informes-de-ejecucion-presupuestaria";
			links[20]="https://www.up.ac.pa/transparencia";*/
