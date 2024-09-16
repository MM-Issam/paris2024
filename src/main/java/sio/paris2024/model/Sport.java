/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sio.paris2024.model;

import java.util.ArrayList;

/**
 *
 * @author zakina
 */
public class Sport {
    private int id;
    private String nom ;
    private ArrayList<Epreuve> lesEpreuves;
    private ArrayList<Sport> lesSports ;
    private Epreuve epreuve;
    public Sport() {
    }

    public Sport(int id, String nom) {
        this.id = id;
        this.nom = nom;
    }

    public Sport(int id) {
        this.id = id;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public ArrayList<Sport> getLesSports() {
        return lesSports;
    }

    public void setLesSports(ArrayList<Sport> lesSport) {
        this.lesSports = lesSports;
    }
    
    public void addSport(Sport s){
        
        if (lesSports == null){
            lesSports = new ArrayList<Sport>();
        }
        lesSports.add(s);
    }

    public ArrayList<Epreuve> getLesEpreuves() {
        return lesEpreuves;
    }

    public void setLesEpreuves(ArrayList<Epreuve> lesEpreuves) {
        this.lesEpreuves = lesEpreuves;
    }

    public Epreuve getEpreuve() {
        return epreuve;
    }

    public void setEpreuve(Epreuve epreuve) {
        this.epreuve = epreuve;
    }
    
}
