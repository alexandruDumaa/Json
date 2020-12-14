package com.cmc.hibernate.excepciones;

import java.util.Date;

public class DetallesError {

	private Date timestamp;
    private String mensaje;
    private String detalles;
    
    public DetallesError(Date timestamp, String mensaje, String detalles) {
        super();
        this.timestamp = timestamp;
        this.mensaje = mensaje;
        this.detalles = detalles;
   }

   public Date getTimestamp() {
        return timestamp;
   }

   public String getMensaje() {
        return mensaje;
   }

   public String getDetalles() {
        return detalles;
   }
}
