
import org.w3c.dom.Element;
import org.w3c.dom.Document;
    public abstract class Composant{
    
       String name;
    
        public abstract void afficher();
        abstract void createXmlElement(Element element,  Document document);
    
        public Composant(String name){
            
            this.name=name;
        }
        public String showName(){
            return this.name;
        }
    
       
        
        
    }
    

