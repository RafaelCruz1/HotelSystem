package Application;

import model.Exception.DomainException;
import model.entities.Reservation;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Program {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        try {
            System.out.print("Numero do quarto: ");
            int number = sc.nextInt();
            System.out.print("Check-in date (dd/MM/yyyy): ");
            Date checkin = sdf.parse(sc.next());
            System.out.print("Check-out date (dd/MM/yyyy): ");
            Date checkout = sdf.parse(sc.next());

            Reservation reservation = new Reservation(number, checkin, checkout);
            System.out.println("Reserva: " + reservation);

            System.out.println();
            System.out.println("Atualização da reserva: ");
            System.out.print("Check-in date (dd/MM/yyyy): ");
            checkin = sdf.parse(sc.next());
            System.out.print("Check-out date (dd/MM/yyyy): ");
            checkout = sdf.parse(sc.next());
            reservation.updateDates(checkin,checkout);
            System.out.println("Reserva: "+ reservation);

        } catch (ParseException e){
            System.out.println("Data invalida ");
        } catch (DomainException e){
            System.out.println("Erro: " + e.getMessage());
        } catch (RuntimeException e){
            System.out.println("Erro inexperado. ");
        }
        
        sc.close();
    }
}

