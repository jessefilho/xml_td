package TD1;

import java.io.File;
import java.util.concurrent.ExecutionException;


import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;

import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;



import org.w3c.dom.Document;

public class WriteDOM {
	
	public static void main(String[] args) throws Exception {
		File f = new File("Films.xml");
		
		//recuperer une instance de factory qui se chargera  de fournir un parseur
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		
		
		//créer le parseur à travers factory
		DocumentBuilder builder = factory.newDocumentBuilder();
		
		//parser le fichier .xml via l'objet builder et recuperer un objet document representant
		//la hierarchie d'objet crée  pendant le parsing
		Document document = builder.parse(f);
		
		TransformerFactory tFactory = TransformerFactory.newInstance();
		Transformer transformer = tFactory.newTransformer();
		DOMSource source = new DOMSource(document);
		
		StreamResult result =  new StreamResult(System.out);
		transformer.transform(source, result);
		
		
	}
	

}
