package TD1;

import java.io.File;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.stream.Collectors;



import java.util.function.Function;


import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;



import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;


import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

public class ParsingDOM_Q1 {
	
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
		
		//Manipulation des noueds
		Element root = document.getDocumentElement();
		NodeList children = root.getChildNodes();
		System.out.println(" ");
		System.out.println(" ");
		System.out.println("---------- QUESTION 1.1 ----------");
		
//		System.out.println(children.item(1).getNodeName());
//		//Titre film
//		System.out.println(children.item(1).getChildNodes().item(1).getFirstChild().getNodeValue());
//		//l’année de sortie
//		System.out.println(children.item(1).getAttributes().getNamedItem("annee").getNodeValue());
//		//les acteurs
//		//FILM/ROLES/ROLE/PRENON
//		System.out.println(children.item(1).getChildNodes().item(9).getChildNodes().item(1).getChildNodes().item(1).getFirstChild().getNodeValue());
//		//FILM/ROLES/ROLE/NOM
//		System.out.println(children.item(1).getChildNodes().item(9).getChildNodes().item(1).getChildNodes().item(3).getFirstChild().getNodeValue());
		
		
		
		//calculer le nombre de films réalisés par année
		int countFilme = 0;
		List<String> an = new ArrayList<String>();
		for (int i = 1; i < children.getLength(); i++) {
			if (i%2 != 0) {
				//System.out.println("#"+ i);
				String year = children.item(i).getAttributes().getNamedItem("annee").getNodeValue();
				an.add(year);
				
				//System.out.println(an);
			}
		}
		
		
		
		Map<String, Long> result_GroupByYear =
                an.stream().collect(
                        Collectors.groupingBy(
                                Function.identity(), Collectors.counting()
                        )
                );
		//calculer le nombre de films réalisés par année
		System.out.println(" ");
        System.out.println(result_GroupByYear);
		
		
	}
	

}
