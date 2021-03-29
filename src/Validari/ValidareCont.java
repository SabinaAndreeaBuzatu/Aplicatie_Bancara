package Validari;

public class ValidareCont {


            public void vIBAN(String IBAN) {
                if (!IBAN.matches("^[A-Z]{2}[0-9]{2}[A-Z]{4}[0-9]{16,18}$"))
                    System.out.println("IBAN-ul nu este valid");
            }

            public void vDataAcordare(String DataAcordare) {
                if (!DataAcordare.matches("^([0123]\\d)[- /.]([01]\\d)[- /.]([012]\\d\\d\\d)$"))
                    System.out.println("Data acordarii nu este valida");
            }

            public void vSold(double Sold) {
                if (Sold < 0)
                    System.out.println("Soldul nu este valid");
            }

            public void vValuta(String Valuta) {
                if (!Valuta.matches("^[A-Z]+$"))
                    System.out.println("Valuta nu este valida");
            }
        }



