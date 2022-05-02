package Modelo;

import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;

public class FormatoFechas {

    /**
     * Formatea una fecha de tipo {@link Date} con el patron 'd-MMMM-yyyy' y
     * retorna la fecha ahora en cadena {@link String}
     * <p>
     * -ejemplo: 11-noviembre-2016
     * <p>
     * @param fecha {@link Date} fecha que se desea formatear
     * @return fecha formateada como cadena {@link String}
     */
    public static String dateFormatToString(Date fecha) {
        SimpleDateFormat sdf = new SimpleDateFormat("d-MMMM-yyyy");
        String fechaFormateada = sdf.format(fecha);
        return fechaFormateada;
    }
    
    public static String getMonthWord(Date fecha) {
        Calendar calendar=Calendar.getInstance();
        calendar.setTime(fecha);
        int month=0;
        String mes="";
        try{
            month=calendar.get(Calendar.MONTH);
        }catch(Exception ex){
            System.out.println(ex);
        }
        switch(month){
            case 0:{
                mes="Enero";
                break;
            }
            case 1:{
                mes="Febrero";
                break;
            }
            case 2:{
                mes="Marzo";
                break;
            }
            case 3:{
                mes="Abril";
                break;
            }
            case 4:{
                mes="Mayo";
                break;
            }
            case 5:{
                mes="Junio";
                break;
            }
            case 6:{
                mes="Julio";
                break;
            }
            case 7:{
                mes="Agosto";
                break;
            }
            case 8:{
                mes="Septiembre";
                break;
            }
            case 9:{
                mes="Octubre";
                break;
            }
            case 10:{
                mes="Noviembre";
                break;
            }
            case 11:{
                mes="Diciembre";
                break;
            }
            default:{
                mes="Sin mes";
                break;
            }
        }
        return mes;
    }
    
    public static String getYear(Date fecha) {
        Calendar calendar=Calendar.getInstance();
        calendar.setTime(fecha);
        int year=0;
        String mes="";
        try{
            year=calendar.get(Calendar.YEAR);
        }catch(Exception ex){
            System.out.println(ex);
        }
        mes=year+"";
        return mes;
    }
    
    public static int getMonthNumber(Date fecha) {
        Calendar calendar=Calendar.getInstance();
        calendar.setTime(fecha);
        int month=0;
        try{
            month=calendar.get(Calendar.MONTH);
        }catch(Exception ex){
            System.out.println(ex);
        }
        return month;
    }
    
    public static int getHour(Date fecha) {
        Calendar calendar=Calendar.getInstance();
        calendar.setTime(fecha);
        int hour=0;
        try{
            hour=calendar.get(Calendar.HOUR_OF_DAY);
        }catch(Exception ex){
            System.out.println(ex);
        }
        return hour;
    }
    
    public static boolean compruebaPeriodo(Date inicio,Date fin){
        int diferenciaYear = Integer.parseInt(getYear(fin))-Integer.parseInt(getYear(inicio));
        if(diferenciaYear<=1){
            if (getMonthNumber(fin) - getMonthNumber(inicio) <= 6) {
                System.out.println(getMonthNumber(fin) - getMonthNumber(inicio) + "");
                return true;
            } else {
                return false;
            }
            
        } else {
            return false;  
        }
    }
    
    public static Date getFormatDate(LocalDate localDate) {
        Instant instant = Instant.from(localDate.atStartOfDay(ZoneId.systemDefault()));
        Date date = Date.from(instant);
        return date;
    }
    
}
