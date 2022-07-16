
import org.w3c.dom.Element;
import org.w3c.dom.Document;
import org.w3c.dom.Attr;
public class Fichier extends Composant {
String name;
    public Fichier (String name)

	{
        super(name);
        }
	public void afficher() 

	{
		System.out.printf("├────"+showName()+ "\n");
	}
	public void createXmlElement(Element element, Document doc){
        Element file = doc.createElement("File");
        Attr attr = doc.createAttribute("name");
        attr.setValue(this.showName());
		file.setAttributeNode(attr);
        element.appendChild(file);
  


    }
}
