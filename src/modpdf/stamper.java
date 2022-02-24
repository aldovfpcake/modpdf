/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modpdf;

/**
 *
 * @author avlea
 */
import java.io.FileOutputStream;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfStamper;
import com.itextpdf.text.pdf.parser.PdfTextExtractor;
import java.text.SimpleDateFormat;  
import java.util.Date;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
        
 
/**
 * This class is used to modify an existing pdf file using iText jar.
 * @author w3spoint
 */
public class stamper {
	public static void main(String args[]){
                 Establece();
                 String texto = " ";
                 String Cuilb = "20-20423873-2";
		try {
		    //Create PdfReader instance.
		    PdfReader pdfReader = new PdfReader("c:\\suerut\\listados\\PIERDOMINIC-ENERO-2022I.pdf");	
 
		    //Create PdfStamper instance.
		    PdfStamper pdfStamper = new PdfStamper(pdfReader,
			new FileOutputStream("c:\\suerut\\listados\\PIERDOMINIC-ENERO-2022I-B.pdf"));
 
		    //Create BaseFont instance.
		    BaseFont baseFont = BaseFont.createFont(
	                BaseFont.TIMES_ROMAN, 
	                BaseFont.CP1252, BaseFont.NOT_EMBEDDED);
 
		    //Get the number of pages in pdf.
		    int pages = pdfReader.getNumberOfPages(); 
 
		    //Iterate the pdf through pages.
		    for(int i=1; i<=pages; i++) { 
			//Contain the pdf data.
			PdfContentByte pageContentByte = 
					pdfStamper.getOverContent(i);
                        
                        texto= texto+ PdfTextExtractor.getTextFromPage(pdfReader, i);
                        boolean encontrado = false;
                        encontrado = texto.contains(Cuilb);
                        if (encontrado = true){
                            System.out.println("Legajo Encontrado" + Cuilb);
                        }
                        
			pageContentByte.beginText();
			//Set text font and size.
			pageContentByte.setFontAndSize(baseFont,12);
 
		      //	pageContentByte.setTextMatrix(350, 740);
 
                        pageContentByte.setTextMatrix(320,80);
			//Write text
                        String firma;
                        firma = "firmado Conforme Coronel Federico\n"+ Establece();
			pageContentByte.showText(firma);
			pageContentByte.endText();
		    }
 
		    //Close the pdfStamper.
		    pdfStamper.close();	
 
		    System.out.println("PDF modified successfully.");
                    System.out.println("Texto Pdf" +texto);
		} catch (Exception e) {
		    e.printStackTrace();
		}
	}

       static String Establece(){
        // Your code here!
      // Date date = new Date();
       // Dd  = new LocalDateTime,now();
       // LocalDateTime Dia = Date.now();
       //Specifying the format of the date using SimpleDateFormat
       
       //SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy  hh:mm:ss");
       //String dateString = sdf.format(date);  
     //  System.out.println("Date in the format of MM-dd-yyyy : "+dateString);  
          LocalDateTime myDateObj = LocalDateTime.now();  
          System.out.println("Before formatting: " + myDateObj);  
          DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");  
          String formattedDate = myDateObj.format(myFormatObj);  
          return formattedDate;
      }





}