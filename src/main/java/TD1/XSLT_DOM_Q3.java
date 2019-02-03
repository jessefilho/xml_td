package TD1;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;



public class XSLT_DOM_Q3 {
	
	public static void main(String[] args) {
		String xmlInputFile = "bd.xml";
		String xsltInputFile = "bd.xsl";
		String xmlOutoutFile = "index.html";
		
		try {
			//XML Source
			Source xmlSource = new StreamSource(new FileInputStream(xmlInputFile));
			//XSL Source
			Source xsltSource = new StreamSource(new FileInputStream(xsltInputFile));
			Result transResult = new StreamResult(new FileOutputStream(xmlOutoutFile));
			
			
			TransformerFactory tf = TransformerFactory.newInstance();
			try {
				Transformer t = tf.newTransformer(xsltSource);
				try {
					t.transform(xmlSource, transResult);
				} catch (TransformerException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} catch (TransformerConfigurationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
}
