package Application;

import model.entities.Reservation;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Program {

    public static void main(String[] args) throws ParseException {
        Scanner sc = new Scanner(System.in);

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        System.out.print("Numero do quarto: ");
        int number = sc.nextInt();
        System.out.print("Check-in date (dd/MM/yyyy): ");
        Date checkin = sdf.parse(sc.next());
        System.out.print("Check-out date (dd/MM/yyyy): ");
        Date checkout = sdf.parse(sc.next());

        if (!checkout.after(checkin)){
            System.out.println("Erro na reserva: O Check-out não pode ser antes do Check-in.");
        } else {
            Reservation reservation = new Reservation(number, checkin,checkout);
            System.out.println("Reserva: "+ reservation);

            System.out.println();
            System.out.println("Atualização da reserva: ");
            System.out.print("Check-in date (dd/MM/yyyy): ");
            checkin = sdf.parse(sc.next());
            System.out.print("Check-out date (dd/MM/yyyy): ");
            checkout = sdf.parse(sc.next());

            Date now = new Date();
            if (checkin.before(now) || checkout.before(now)){
                System.out.println("Data invalida.");
            }else if (!checkout.after(checkin)){
                System.out.println("Erro na reserva: O Check-out não pode ser antes do Check-in.");
            }else{
                reservation.updateDates(checkin,checkout);
                System.out.println("Reserva: "+ reservation);
            }
        }
        sc.close();
    }
}
