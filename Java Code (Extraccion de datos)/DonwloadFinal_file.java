import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

class ret{
	/*public String array() {
		String array [6]*/
	//}
	String b;
	void asignar(String a) {
		b= a;
	}
	String ret() {
		return b.substring(6);
	}
	
}
public class DonwloadFinal_file  {

	public static void main(String[] args)  {
		
		try {
			
	
		
		
		ret obj = new ret();
		String links []= new String[4];
			
		
		    links[0] ="https://www.datosabiertos.gob.pa/dataset/mef-presupuesto-del-estado-2019";
			links[1]="https://www.datosabiertos.gob.pa/dataset/mef-cronograma-de-pago-de-cuentas-parciales-2019";
			links[2]="https://www.datosabiertos.gob.pa/dataset/mef-deuda-publica-acumulada-2019";
			links[3]="https://www.datosabiertos.gob.pa/dataset/mef-presupuesto-institucional-2019";
			
			
		for (int i=0; i<5; i++) {	
		String adress =links[i] ;
		URL pagelocation = new URL (adress);
		Scanner sc = new Scanner (pagelocation.openStream());
		
		while (sc.hasNext()) {
			String line = sc.next();
			if (line.contains( "href=\"https://") && line.contains(".csv")) {
				
				String abc =line;
				
			    obj.asignar(abc);
				//System.out.println(line);				
			}
		}
		
	
			System.out.println(obj.ret());
			
			
				String link = obj.ret();	
				
				File out = new File ("C:\\portafolios\\test" + i + ".csv");

				new Thread(new download_URL(link, out)).start();		
			
			
		//}				
		
	}
		}
		catch (Exception e){
			
	 }
				
		
		
  }
}


