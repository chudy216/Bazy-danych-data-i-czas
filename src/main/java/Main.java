import java.sql.*;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Scanner;

public class Main {
    private static Statement stmt;
    public static void main(String[] args) throws SQLException {
        Connection conn = DBConnection.createNewDBConnection();
        Scanner myObj = new Scanner(System.in);
        System.out.println("1. Zaloguj");
        System.out.println("2. Rejestracja");
        int logowanie = myObj.nextInt();
        if (logowanie == 1) {
            Statement stmt1 = conn.createStatement();
            int zalogowano = 0;
            while (zalogowano<1){
            System.out.println("podaj login");
            String login = myObj.next();
            System.out.println("podaj hasło");
            String haslo = myObj.next();
            ResultSet logowanko = stmt1.executeQuery("SELECT * FROM user");
            while (logowanko.next()) {
                String k1 = logowanko.getString("Login");
                String k2 = logowanko.getString("Hasło");
                if (login.equals(k1)){
                    if (haslo.equals(k2)) {
                        zalogowano = zalogowano+1;
                    }
                }
                if (zalogowano<1){
                    System.out.println("Złe dane, wprowadź jeszcze raz");
                }
            }}
            System.out.println("1. Odczytaj dane");
            System.out.println("2. Wprowadź dane");
            ZonedDateTime czas = ZonedDateTime.of(LocalDateTime.now(), ZoneId.of("Poland"));
            DateTimeFormatter formatter = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.SHORT);
            String formatted = formatter.format(czas);
            int wybierz = myObj.nextInt();
            if (wybierz == 1) {
                System.out.println("Wybierz które dane chcesz wyświetlić: ");
                System.out.println("1.Koło");
                System.out.println("2.Prostokąt");
                System.out.println("3.Kwadrat");
                int wyswietl = myObj.nextInt();
                System.out.println("czas pobrania");
                System.out.println(formatted);

                if (wyswietl == 1) {
                    ResultSet kolo = stmt1.executeQuery("SELECT * FROM koła");
                    while (kolo.next()) {
                        String k1 = kolo.getString("id");
                        String k2 = kolo.getString("promień");
                        System.out.println("id " + k1 + " | promień " + k2);
                        System.out.println();}
                    }
                    if (wyswietl == 2) {
                        ResultSet prostokat = stmt1.executeQuery("SELECT * FROM prostokąty");
                        while (prostokat.next()) {
                            String k1 = prostokat.getString("id");
                            String k2 = prostokat.getString("Szerokość");
                            String k3 = prostokat.getString("Długość");
                            System.out.println("id " + k1 + " | Szerokość " + k2 + " | Długość " + k3);
                            System.out.println();
                        }

                    }
                    if (wyswietl == 3) {
                        ResultSet kwadrat = stmt1.executeQuery("SELECT * FROM kwadraty");
                        while (kwadrat.next()) {
                            String k1 = kwadrat.getString("id");
                            String k2 = kwadrat.getString("bok");
                            System.out.println("id "+k1+" | Szerokość "+k2);
                            System.out.println();}
                    }
                    if (wyswietl == 4) {
                        System.out.println("źle podałeś");
                    }
                } else if (wybierz == 2) {
                    System.out.println("Wybierz figurę którą chcesz dodać to bazy: ");
                    System.out.println("1.Koło");
                    System.out.println("2.Prostokąt");
                    System.out.println("3.Kwadrat");
                    int dodaj = myObj.nextInt();
                    if (dodaj == 1) {
                        System.out.println("Podaj promień koła");
                        double radius = myObj.nextDouble();
                        String sqlInsert2 = "INSERT INTO koła (id, promień) VALUES (NULL, ?)";
                        PreparedStatement stmtInsert2 = conn.prepareStatement(sqlInsert2);
                        stmtInsert2.setString(1, String.valueOf(radius));
                        stmtInsert2.execute();
                        System.out.println("czas wpisania");
                        System.out.println(formatted);
                    } else if (dodaj == 2) {
                        System.out.println("Podaj szerokość prostokąta");
                        double width = myObj.nextDouble();
                        System.out.println("Podaj wysokość prostokąta");
                        double length = myObj.nextDouble();
                        String sqlInsert2 = "INSERT INTO prostokąty (id, Szerokość, Długość) VALUES (NULL, ?, ?)";
                        PreparedStatement stmtInsert2 = conn.prepareStatement(sqlInsert2);
                        stmtInsert2.setString(1, String.valueOf(width));
                        stmtInsert2.setString(2, String.valueOf(length));
                        stmtInsert2.execute();
                        System.out.println("czas wpisania");
                        System.out.println(formatted);
                    } else if (dodaj == 3) {
                        System.out.println("Podaj bok kwadratu");
                        double side = myObj.nextDouble();
                        String sqlInsert2 = "INSERT INTO kwadraty (id, bok) VALUES (NULL, ?)";
                        PreparedStatement stmtInsert2 = conn.prepareStatement(sqlInsert2);
                        stmtInsert2.setString(1, String.valueOf(side));
                        stmtInsert2.execute();
                        System.out.println("czas wpisania");
                        System.out.println(formatted);
                    } else {
                        System.out.println("źle podałeś");
                    }
                } else {
                    System.out.println("źle podałeś");
                }
            } else if (logowanie == 2) {
                System.out.println("podaj login");
                String login = myObj.next();
                System.out.println("podaj hasło");
                String haslo = myObj.next();
                System.out.println("powtórz hasło");
                String potwierdz = myObj.next();
                while (!(haslo.equals(potwierdz))) {
                    System.out.println("hasła się różnią, podaj hasło jeszcze raz");
                    haslo = myObj.next();
                    System.out.println("powtórz hasło");
                    potwierdz = myObj.next();
                }
                String sqlInsert2 = "INSERT INTO user (id, Login, Hasło) VALUES (NULL, ?, ?)";
                PreparedStatement stmtInsert2 = conn.prepareStatement(sqlInsert2);
                stmtInsert2.setString(1, String.valueOf(login));
                stmtInsert2.setString(2, haslo);
                stmtInsert2.execute();
                System.out.println("Zarejestrowano użytkownika " + login);
            }
        }
    }
