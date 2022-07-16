import java.io.File;
// import javax.xml.parsers.DocumentBuilder;
// import javax.xml.parsers.DocumentBuilderFactory;
// import javax.xml.parsers.ParserConfigurationException;
// import javax.xml.transform.Transformer;
// import javax.xml.transform.TransformerException;
// import javax.xml.transform.TransformerFactory;
// import javax.xml.transform.dom.DOMSource;
// import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class GetFile {

	
	

 public void xmlFile(File file, Dossier dossier, Document doc, Element element ) {
	

	
	if (!file.isDirectory()) {
	
		Fichier fichier= new Fichier(file.getName());
		//fichier.afficher();
		fichier.createXmlElement(element, doc);

		// dossier.ajouter(fichier);

		}

	if (file.isDirectory()) {
		Dossier dossier2= new Dossier(file.getName());
		dossier2.createXmlElement(element, doc);
		Element doss = doc.createElement("Directory");
        Attr attr = doc.createAttribute("name");
        attr.setValue(file.getName());
		doss.setAttributeNode(attr);
        element.appendChild(doss);
	
	// dossier.ajouter(dossier2);
		File[] children = file.listFiles();

	for (File child : children) {
			
			this.xmlFile(child, dossier2, doc, doss);
	}
}
 }
	

}
