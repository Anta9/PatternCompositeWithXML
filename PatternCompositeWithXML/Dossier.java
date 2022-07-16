import org.w3c.dom.Document;
import org.w3c.dom.Element;
// import org.w3c.dom.Attr;
import java.util.ArrayList;
public class Dossier extends Composant{
   
    ArrayList <Composant> dossier= new ArrayList<Composant>();
    
    

public Dossier(String name)
    {
    
        super(name);
    }
    public void afficher()

    {
        System.out.println(showName()+"\n");
        for (Composant c: dossier)

        {
            
            c.afficher();
        }
    
}
public void ajouter(Composant c)
	{
		this.dossier.add(c);
	}
    public void createXmlElement(Element element, Document doc){
        Element doss = doc.createElement("Directory");
        

        for (Composant c: dossier){
        

        c.createXmlElement(doss, doc);
    
        }
  


    }
        
}
