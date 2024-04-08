/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.testws.services;

import com.mycompany.testws.Promedio;
import com.mycompany.testws.Persona;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author Kevin Emiro Ospinal
 */
@Path("/service")
public class Service {

    private static Map<Integer, Persona> personas = new HashMap<>();

    static {
        for (int i = 0; i < 10; i++) {
            Persona persona = new Persona();
            persona.setId((i + 1));
            persona.setFullname("mipersona" + (i + 1));
            persona.setAge(new Random().nextInt(20 + (i + 1)));
            personas.put((i + 1), persona);
        }
    }

    public class DatosJson {

        private String compañia;
        private double sumatoria;

        public DatosJson() {
            compañia = "Federico S.A";
        }

        public String getCompañia() {
            return compañia;
        }

        public void sumatoria() {
            double temp = 0;

            for (Persona entry : personas.values()) {
                temp += entry.getSalario();
            }
            this.sumatoria = temp;
        }

        public double getSumatoria() {
            sumatoria();
            return sumatoria;
        }
    }

    

    DatosJson datosJson = new DatosJson();

    @GET
    @Path("/getPersonByIdJson/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Persona getPersonByIdJson(@PathParam("id") int id) {
        return personas.get(id);
    }

    @GET
    @Path("/getPersonByIdXML/{id}")
    @Produces(MediaType.APPLICATION_XML)
    public Persona getPersonByIdXML(@PathParam("id") int id) {
        return personas.get(id);
    }

    @GET
    @Path("/getAllPersonsInXML")
    @Produces(MediaType.APPLICATION_XML)
    public List<Persona> getAllPersonsInXML() {
        return new ArrayList<>(personas.values());
    }

    @GET
    @Path("/getPromedio")
    @Produces(MediaType.APPLICATION_XML)
    public Promedio getPromedio() {
        double temp = 0;

        for (Persona entry : personas.values()) {
            temp += entry.getSalario();
        }
        temp /= personas.size();
        return new Promedio(temp);
    }

    @GET
    @Path("/getSumatoria")
    @Produces(MediaType.APPLICATION_JSON)
    public DatosJson getSumatoria() {
        return datosJson;
    }

    @GET
    @Path("/getAllPersonsInJson")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Persona> getAllPersonsInJson() {
        return new ArrayList<>(personas.values());
    }

    @POST
    @Path("/addAllPersonsInJSON")
    public List<Persona> addAllPersonsInJSON(List<Persona> pr) {
        for (Persona persona : pr) {
            personas.put(persona.getId(), persona);
        }
        return new ArrayList<Persona>(personas.values());

    }

}
