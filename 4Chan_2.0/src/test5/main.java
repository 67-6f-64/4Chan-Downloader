package test5;

import java.io.File;
import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class main {
		public main(String aurl,String dir, window win) {
			
			
			String fileName = aurl.substring( aurl.lastIndexOf('/')+1, aurl.length() );
			System.out.println("url : " + aurl);
			System.out.println("Fn : " + fileName);
			System.out.println("dir : " + dir);
			
			

			 Document doc;
			try {
				doc = Jsoup.connect(aurl).get();
			} catch (IOException ee) {
				// TODO Auto-generated catch block
				ee.printStackTrace();
				return;
			}  
			win.addListItem(  doc.title());
			 Elements newsHeadlines = doc.select("a[href*=i.4cdn.org]");
			 int i = 0;
			 for (Element headline : newsHeadlines) {
				 
				 
				 System.out.println(" hmm " + headline.html());
				
				 if(headline.html().contains("img")) {
					 
					 
				 }else {
					   i = i + 1;
					    win.addListItem("  File downloading: " + headline.absUrl("href") +  " " + i);
						boolean f =  new File( dir + doc.title().replace("\\", "").replace("?", "")  ).mkdirs();
						//textPane.setText(textPane.getText() + "\n" + " Folder created?" + f + " - " +  "c:\\Users\\charl\\Documents\\4chanDownload\\" + doc.title().replace("\\", "").replace("/", ""));
						 download d = new download(headline.absUrl("href"),dir + doc.title().replace("\\", "").replace("?",""), win);
				 
				 }

			 }
			
			
			
		}
}
