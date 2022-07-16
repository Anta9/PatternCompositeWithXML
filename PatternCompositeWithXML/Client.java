import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
// import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
// import org.w3c.dom.Node;
// import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import java.io.IOException;
public class Client{
 
   public static void main(String argv[])throws ParserConfigurationException,
   SAXException, IOException   {
      try {
 
         DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
         DocumentBuilder docBuilder = dbFactory.newDocumentBuilder();
       Document doc = docBuilder.newDocument();
         Element racine = doc.createElement("repertoire");
      
         doc.appendChild(racine);
       
        
        Dossier bigDossier =new Dossier("Tree");
        String path ="/home/anta/Bureau/codes/dossier0";
        File file =new File (path);
        GetFile arbre= new GetFile();
        arbre.xmlFile(file, bigDossier,doc, racine );

        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        DOMSource source = new DOMSource(doc);
        StreamResult resultat = new StreamResult(new File("monFichier.xml"));
     
        transformer.transform(source, resultat);
     
        // System.out.println("Fichier sauvegardé avec succès!");
     
      }catch (ParserConfigurationException pce) {
        pce.printStackTrace();
     } catch (TransformerException tfe) {
        tfe.printStackTrace();
     }
     try
     {   
       File file = new File ("monFichier.xml");
      DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
      DocumentBuilder db = dbf.newDocumentBuilder();
      Document document = db.parse(file);
      document.getDocumentElement().normalize();

      System.out.println("        " + document.getDocumentElement().getNodeName());
     Print write=new Print();
     write.printTree( document.getDocumentElement());
     


     }
     catch(IOException e) {
         System.out.println(e);
     } 
  }
   }

   
   
  


          

            
        
        

