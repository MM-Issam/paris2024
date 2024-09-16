/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sio.paris2024.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import sio.paris2024.model.Epreuve;
import sio.paris2024.model.Sport;

/**
 *
 * @author zakina
 */
public class DaoSport {
    
    Connection cnx;
    static PreparedStatement requeteSql = null;
    static ResultSet resultatRequete = null;
    
    public static ArrayList<Sport> getLesSports(Connection cnx){
        
        ArrayList<Sport> lesSports = new ArrayList<Sport>();
        try{
            requeteSql = cnx.prepareStatement("select * from sport ");                        
            //System.out.println("REQ="+ requeteSql);
            resultatRequete = requeteSql.executeQuery();
            
            while (resultatRequete.next()){
                
                Sport s = new Sport();
                   s.setId(resultatRequete.getInt("id"));
                   s.setNom(resultatRequete.getString("nom"));
               
                
                lesSports.add(s);
            }
           
        }
        catch (SQLException e){
            e.printStackTrace();
            System.out.println("La requête de getLesPompiers e généré une erreur");
        }
        return lesSports;
    }
    
    
    
       public static Sport getSportById(Connection cnx, int idSport) {
        Sport s = new Sport();
        ArrayList<Epreuve> epreuves = new ArrayList<>();
        try {
            requeteSql = cnx.prepareStatement("select s.id as s_id, s.nom as s_nom, e.id as e_id, e.nom as e_nom " +
                         "from sport s inner join epreuve e " +
                         "on s.id = e.sport_id " +
                         "where s.id = ?");
            requeteSql.setInt(1, idSport);
            resultatRequete = requeteSql.executeQuery();

            while (resultatRequete.next()) {
                if (s.getId() == 0) {
                    s.setId(resultatRequete.getInt("s_id"));
                    s.setNom(resultatRequete.getString("s_nom"));
                }
                Epreuve e = new Epreuve();
                e.setId(resultatRequete.getInt("e_id"));
                e.setNom(resultatRequete.getString("e_nom"));
                epreuves.add(e);
            }
            s.setLesEpreuves(epreuves);
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("La requête de getSportById a généré une erreur");
        }
        return s;
    }
    
     public static Sport addSport(Connection connection, Sport spo){      
        int idGenere = -1;
        try
        {
            //preparation de la requete
            // id (clé primaire de la table epreuve) est en auto_increment,donc on ne renseigne pas cette valeur
            // la paramètre RETURN_GENERATED_KEYS est ajouté à la requête afin de pouvoir récupérer l'id généré par la bdd (voir ci-dessous)
            // supprimer ce paramètre en cas de requête sans auto_increment.
            requeteSql=connection.prepareStatement("INSERT INTO sport (nom)\n" +
                    "VALUES (?)", requeteSql.RETURN_GENERATED_KEYS );
            requeteSql.setString(1, spo.getNom());      

           /* Exécution de la requête */
            requeteSql.executeUpdate();
            
             // Récupération de id auto-généré par la bdd dans la table client
            resultatRequete = requeteSql.getGeneratedKeys();
            while ( resultatRequete.next() ) {
                idGenere = resultatRequete.getInt( 1 );
                spo.setId(idGenere);
                
                spo = DaoSport.getSportById(connection, spo.getId());
            }
            
         
        }   
        catch (SQLException e) 
        {
            e.printStackTrace();
            //out.println("Erreur lors de l’établissement de la connexion");
        }
        return spo ;    
    }
    
    
}
