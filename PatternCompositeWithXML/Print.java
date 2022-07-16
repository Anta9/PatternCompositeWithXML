
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
public class Print {
    public void place(int pos){
            
        if(pos > 1){
             for(int i=0; i<pos; i++){
                System.out.print("│");
                System.out.print("    ");
            }
        }
    }
    static int pos=2; 
    Dossier monDossier=new Dossier("");
    public void printTree(Node noeud)throws ParserConfigurationException, SAXException {
      
        
                NodeList nList = noeud.getChildNodes();
            
            // System.out.println("──────────────────────────────");
            for (int temp = 0; temp < nList.getLength(); temp++) {
                Node nNode = nList.item(temp);
                if(nNode.getNodeName()=="Directory"){
                   
                    if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                        Element eElement = (Element) nNode;
                        
                        
                        Dossier dossier =new Dossier(eElement.getAttribute("name"));
                        place(pos);
                        pos++; 
                        System.out.print("├───");
                        dossier.afficher();
                        // System.out.println(eElement.getAttribute("name"));
                        
                        printTree(nNode);
                        
                        pos--;
                    }
                }
                else if (nNode.getNodeName()=="File"){
                    if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                        Element eElement = (Element) nNode;
                        Fichier fichier= new Fichier(eElement.getAttribute("name"));

                        place (pos);
                        System.out.print("├───");
                        fichier.afficher();
                        // System.out.println(eElement.getAttribute("name"));

                       
                       
                    }
                }
                
            }
        
    }
    
}
