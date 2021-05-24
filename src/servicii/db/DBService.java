package servicii.db;
import produse.*;
import client.*;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class DBService {
    public DBService() throws ClassNotFoundException, SQLException {
    Class.forName("com.mysql.cj.jdbc.Driver");
   }

    public void addCutie(InchiriereCutieValori c) throws SQLException {

        Connection connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/banca","root","root-pass");
        Statement statement = connect.createStatement();
        try{statement.execute("insert into cutie values (\""+c.getNrCutie()+"\",\""+c.getContc()+"\",\""+c.getPragValoriDeclarat()+"\",\""+c.getDataAcordare()+"\",\""+c.getAdresa()+"\",\""+c.getValuta()+"\")");
            System.out.println("Cutia de valori a fost adaugata! :) ");}
        catch(SQLIntegrityConstraintViolationException e){
            System.out.println("Cutia exista deja ! :(");
        }


    }
public void addClient(Client c) throws SQLException {

        Connection connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/banca","root","root-pass");
    Statement statement = connect.createStatement();
    try{statement.execute("insert into client values (\""+c.getCNP()+"\",\""+c.getNume()+"\",\""+c.getPrenume()+"\",\""+c.getDataNasterii()+"\")");
        System.out.println("Clientul a fost adaugat! :) ");}
    catch(SQLIntegrityConstraintViolationException e){
        System.out.println("Clientul exista deja ! :(");
    }


}
public void addCont(ContCurent c) throws SQLException {

        Connection connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/banca","root","root-pass");
        Statement statement = connect.createStatement();
       try {
           statement.execute("insert into contcurent values (\"" + c.getIBAN() + "\",\"" + c.getCNP() + "\",\"" + c.getValuta() + "\",\"" + c.getSold() + "\",\"" + c.getDataAcordare() + "\",\"" + c.gettipcont() + "\",\"" + c.getComisionA() + "\")");
           System.out.println("Contul a fost adaugat! :) ");  }
       catch(SQLIntegrityConstraintViolationException e){
           System.out.println("Contul exista deja ! :( ");}

    }
    public void addDepozit(Depozit c) throws SQLException {

        Connection connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/banca","root","root-pass");
        Statement statement = connect.createStatement();
        try {
            statement.execute("insert into depozit values (\"" + c.getIBAN() + "\",\"" + c.getIBANcontc() + "\",\"" + c.getValuta() + "\",\"" + c.getSold() + "\",\"" + c.getDataAcordare() + "\",\"" + c.gettipcont() + "\",\"" + c.getComisionA() + "\",\"" + c.getDobanda() + "\")");
            System.out.println("Depozitul a fost adaugat! :) "); }
        catch(SQLIntegrityConstraintViolationException e){
            System.out.println("Depozitul exista deja ! :( ");}

    }

    public void addCredit(Credit c) throws SQLException {

        Connection connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/banca","root","root-pass");
        Statement statement = connect.createStatement();
      try {
          statement.execute("insert into credit values (\"" + c.getIBAN() + "\",\"" + c.getIBANcontc() + "\",\"" + c.getValuta() + "\",\"" + c.getSold() + "\",\"" + c.getDataAcordare() + "\",\"" + c.gettipcont() + "\",\"" + c.getComisionA() + "\",\"" + c.getDobanda() + "\",\"" + c.getDurataluni() + "\",\"" + c.getRatac() + "\",\"" + c.getRatePlatite() + "\",\""+c.getSumaAcordata()+"\")");
          System.out.println("Creditul a fost adaugat! :) "); }
      catch (SQLIntegrityConstraintViolationException e)
      { System.out.println("Creditul exista deja! :( ");}

    }
      public Pair< Cont , Integer> nrcard(List<Cont> c, Card cc)
      {
          for(int j=0;j<c.size();j++)
          for (int i=0;i<c.get(j).getcard().size();i++)
      if (c.get(j).getcard().get(i).getNrCard().equals(cc.getNrCard()))
      return new Pair(c.get(j),i);
return null;
      }
    public void addCard(List<Cont> cont,Card c) throws SQLException {
        Pair<Cont, Integer> x  =nrcard(cont, c);
        try {
            Connection connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/banca", "root", "root-pass");
            Statement statement = connect.createStatement();
           // Statement statement2 = connect.createStatement();
            if (x.getFirst().gettipcont().equals("Cont curent"))
                statement.execute("insert into card values (\"" + x.getFirst().getcard().get(x.getSecond()).getNrCard() + "\",\"" + x.getFirst().getIBAN() + "\",NULL,NULL,\"" + x.getFirst().getcard().get(x.getSecond()).getPin() + "\",\"" + x.getFirst().getcard().get(x.getSecond()).getDataExp() + "\",\"" + x.getFirst().getcard().get(x.getSecond()).getCVV() + "\")");
            else if (x.getFirst().gettipcont().equals("Depozit"))
                statement.execute("insert into card values (\"" + x.getFirst().getcard().get(x.getSecond()).getNrCard() + "\",NULL,\"" + x.getFirst().getIBAN() + "\",NULL,\"" + x.getFirst().getcard().get(x.getSecond()).getPin() + "\",\"" + x.getFirst().getcard().get(x.getSecond()).getDataExp() + "\",\"" + x.getFirst().getcard().get(x.getSecond()).getCVV() + "\")");
            else if (x.getFirst().gettipcont().equals("Credit cu dobanda fixa") || x.getFirst().gettipcont().equals("Credit cu dobanda variabila"))
                statement.execute("insert into card values (\"" + x.getFirst().getcard().get(x.getSecond()).getNrCard() + "\",NULL,NULL,\"" + x.getFirst().getIBAN() + "\",\"" + x.getFirst().getcard().get(x.getSecond()).getPin() + "\",\"" + x.getFirst().getcard().get(x.getSecond()).getDataExp() + "\",\"" + x.getFirst().getcard().get(x.getSecond()).getCVV() + "\")");
            System.out.println("Cardul a fost adaugat! :) ");
        }
        catch(NullPointerException e){}
        catch (SQLIntegrityConstraintViolationException e){ System.out.println("Cardul exista deja! :(");}

    }
    public Client readClient(String cnp) throws SQLException {
        Connection connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/banca","root","root-pass");
        Statement statement = connect.createStatement();
        ResultSet rs=  statement.executeQuery("select * from client");

        int i=0;
        Client aux;
       while (rs.next())
        {   if(rs.getString(1).equals(cnp)) {
            aux = new Client();
            aux.setCNP(rs.getString(1));
            aux.setNume(rs.getString(2));
            aux.setPrenume(rs.getString(3));
            aux.setDataNasterii(rs.getString(4));
            return aux;
        }}

        System.out.println("In baza de date nu exista clientul cu cnp " +cnp);
       return null;


    }
    public List<Client> readAllClient() throws SQLException {
        Connection connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/banca","root","root-pass");
        Statement statement = connect.createStatement();
        ResultSet rs=  statement.executeQuery("select * from client");
        List <Client> clienti = new ArrayList<>();
        int i=0;
        Client aux;
        while (rs.next())
        {
            aux=new Client();
            aux.setCNP(rs.getString(1));
        aux.setNume(rs.getString(2));
        aux.setPrenume(rs.getString(3));
        aux.setDataNasterii(rs.getString(4));
        clienti.add(aux);
        i++;
        }


  return clienti;



    }
    public List<InchiriereCutieValori> readAllCutie() throws SQLException {
        Connection connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/banca","root","root-pass");
        Statement statement = connect.createStatement();
        ResultSet rs=  statement.executeQuery("select * from cutie");
        List <InchiriereCutieValori> cutii = new ArrayList<>();
        int i=0;
        InchiriereCutieValori aux;
        while (rs.next())
        {
            aux=new InchiriereCutieValori();
            aux.setNrCutie(rs.getString(1));
            aux.setContc(rs.getString(2));
            aux.setPragValoriDeclarat(Double.parseDouble(rs.getString(3)));
            aux.setDataAcordare(rs.getString(4));
            aux.setAdresa(rs.getString(5));
            aux.setValuta(rs.getString(6));
            aux.comision();
            cutii.add(aux);
            i++;
        }


        return cutii;



    }
    public ContCurent readContCurent(String iban) throws SQLException {
        Connection connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/banca","root","root-pass");
        Statement statement = connect.createStatement();
        ResultSet rs=  statement.executeQuery("select * from  contcurent");
        int i=0;
        ContCurent aux;
        while (rs.next())
        {   if (rs.getString(1).equals(iban))
        { aux=new ContCurent();
            aux.setIBAN(rs.getString(1));
            aux.setcnp(rs.getString(2));
            aux.setValuta(rs.getString(3));
            aux.setSold(Double.parseDouble(rs.getString(4)));
            aux.setDataAcordare(rs.getString(5));
            aux.settipcont(rs.getString(6));
            aux.setComisionA(Double.parseDouble(rs.getString(7)));
        return aux;}

        }

        System.out.println("In baza de date nu exista contul cu IBAN " +iban);
        return null;




    }
    public List<Cont> readAllContCurent() throws SQLException {
        Connection connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/banca","root","root-pass");
        Statement statement = connect.createStatement();
        ResultSet rs=  statement.executeQuery("select * from  contcurent");
        List <Cont> conturi = new ArrayList<>();
        int i=0;
        ContCurent aux;
        while (rs.next())
        {
            aux=new ContCurent();
            aux.setIBAN(rs.getString(1));
            aux.setcnp(rs.getString(2));
            aux.setValuta(rs.getString(3));
            aux.setSold(Double.parseDouble(rs.getString(4)));
            aux.setDataAcordare(rs.getString(5));
            aux.settipcont(rs.getString(6));
            aux.setComisionA(Double.parseDouble(rs.getString(7)));
            conturi.add(aux);
            i++;
        }
        List<Cont> c=addCardCont(conturi);
        return c;



    }
    public Depozit readDepozit(String iban) throws SQLException {
        Connection connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/banca","root","root-pass");
        Statement statement = connect.createStatement();
        ResultSet rs=  statement.executeQuery("select * from  contcurent");
        int i=0;
        Depozit aux;
        while (rs.next())
        {  if(rs.getString(1).equals(iban))
        {aux=new Depozit();
            aux.setIBAN(rs.getString(1));
            aux.setIBANcontc(rs.getString(2));
            aux.setValuta(rs.getString(3));
            aux.setSold(Double.parseDouble(rs.getString(4)));
            aux.setDataAcordare(rs.getString(5));
            aux.settipcont(rs.getString(6));
            aux.setComisionA(Double.parseDouble(rs.getString(7)));
            aux.setDobanda(Double.parseDouble(rs.getString(8)));
        return aux;}

        }

        System.out.println("In baza de date nu exista depozitul cu IBAN " +iban);
        return null;


    }
    public List<Cont> readAllDepozit() throws SQLException {
        Connection connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/banca","root","root-pass");
        Statement statement = connect.createStatement();
        ResultSet rs=  statement.executeQuery("select * from  depozit");
        List <Cont> depozite = new ArrayList<>();
        int i=0;
        Depozit aux;
        while (rs.next())
        {
            aux=new Depozit();
            aux.setIBAN(rs.getString(1));
            aux.setIBANcontc(rs.getString(2));
            aux.setValuta(rs.getString(3));
            aux.setSold(Double.parseDouble(rs.getString(4)));
            aux.setDataAcordare(rs.getString(5));
            aux.settipcont(rs.getString(6));
            aux.setComisionA(Double.parseDouble(rs.getString(7)));
            aux.setDobanda(Double.parseDouble(rs.getString(8)));
            depozite.add(aux);
            i++;
        }


        List<Cont> c=addCardDepozit(depozite);
        return c;



    }
    public Credit readCredit(String iban) throws SQLException {
        Connection connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/banca","root","root-pass");
        Statement statement = connect.createStatement();
        ResultSet rs=  statement.executeQuery("select * from  credit");
        List <Credit> credite = new ArrayList<>();
        int i=0;
        Credit aux;
        while (rs.next())
        {  if (rs.getString(6).equals("Credit cu dobanda variabila"))
        {   if(rs.getString(1).equals(iban))
        {  aux=new CreditFlex();
            aux.setIBAN(rs.getString(1));
            aux.setIBANcontc(rs.getString(2));
            aux.setValuta(rs.getString(3));
            aux.setSold(Double.parseDouble(rs.getString(4)));
            aux.setDataAcordare(rs.getString(5));
            aux.settipcont(rs.getString(6));
            aux.setComisionA(Double.parseDouble(rs.getString(7)));
            aux.setDobanda(Double.parseDouble(rs.getString(8)));
            aux.setDurataluni(Integer.parseInt(rs.getString(9)));
            aux.setRatePlatite(Integer.parseInt(rs.getString(11)));
            aux.setSumaAcordata(Double.parseDouble(rs.getString(12)));
            return aux;}}
        else if (rs.getString(6).equals("Credit cu dobanda fixa"))
        {   if(rs.getString(1).equals(iban))
        { aux=new CreditFix();
            aux.setIBAN(rs.getString(1));
            aux.setIBANcontc(rs.getString(2));
            aux.setValuta(rs.getString(3));
            aux.setSold(Double.parseDouble(rs.getString(4)));
            aux.setDataAcordare(rs.getString(5));
            aux.settipcont(rs.getString(6));
            aux.setComisionA(Double.parseDouble(rs.getString(7)));
            aux.setDobanda(Double.parseDouble(rs.getString(8)));
            aux.setDurataluni(Integer.parseInt(rs.getString(9)));
            aux.setRatePlatite(Integer.parseInt(rs.getString(11)));
            aux.setSumaAcordata(Double.parseDouble(rs.getString(12)));
         return aux;
            }
        }}

        System.out.println("In baza de date nu exista creditul cu IBAN " +iban);
        return null;


    }
    public List<Cont> readAllCredit() throws SQLException {
        Connection connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/banca","root","root-pass");
        Statement statement = connect.createStatement();
        ResultSet rs=  statement.executeQuery("select * from  credit");
        List <Cont> credite = new ArrayList<>();
        int i=0;
        Credit aux;
        while (rs.next())
        {  if (rs.getString(6).equals("Credit cu dobanda variabila"))
        {   aux=new CreditFlex();
            aux.setIBAN(rs.getString(1));
            aux.setIBANcontc(rs.getString(2));
            aux.setValuta(rs.getString(3));
            aux.setSold(Double.parseDouble(rs.getString(4)));
            aux.setDataAcordare(rs.getString(5));
            aux.settipcont(rs.getString(6));
            aux.setComisionA(Double.parseDouble(rs.getString(7)));
            aux.setDobanda(Double.parseDouble(rs.getString(8)));
            aux.setDurataluni(Integer.parseInt(rs.getString(9)));
            aux.setRatePlatite(Integer.parseInt(rs.getString(11)));
            aux.setSumaAcordata(Double.parseDouble(rs.getString(12)));
            aux.calcrata();
            credite.add(aux);
            i++;}
        else if (rs.getString(6).equals("Credit cu dobanda fixa"))
            {   aux=new CreditFix();
            aux.setIBAN(rs.getString(1));
            aux.setIBANcontc(rs.getString(2));
            aux.setValuta(rs.getString(3));
            aux.setSold(Double.parseDouble(rs.getString(4)));
            aux.setDataAcordare(rs.getString(5));
            aux.settipcont(rs.getString(6));
            aux.setComisionA(Double.parseDouble(rs.getString(7)));
            aux.setDobanda(Double.parseDouble(rs.getString(8)));
                aux.setDurataluni(Integer.parseInt(rs.getString(9)));
                aux.setRatePlatite(Integer.parseInt(rs.getString(11)));
                aux.setSumaAcordata(Double.parseDouble(rs.getString(12)));
                aux.calcrata();
            credite.add(aux);
            i++;
        }}

        List<Cont> c=addCardCredit(credite);
        return c;

    }
    public Card readCard(String nr) throws SQLException {
        Connection connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/banca","root","root-pass");
        Statement statement = connect.createStatement();
        ResultSet rs=  statement.executeQuery("select * from card");
        int i=0;
        Card aux;
        while (rs.next())
        { if(rs.getString(1).equals(nr))
        {aux=new Card();
            aux.setNrCard(rs.getString(1));
            aux.setPin(rs.getString(5));
            aux.setDataExp(rs.getString(6));
            aux.setCVV(rs.getString(7));
             return aux;
        }}
        System.out.println("In baza de date nu exista cardul cu numarul" +nr);
        return null;

    }
    public List<Card> readAllCard() throws SQLException {
        Connection connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/banca","root","root-pass");
        Statement statement = connect.createStatement();
        ResultSet rs=  statement.executeQuery("select * from card");
        List<Card> carduri= new ArrayList<>();
        int i=0;
        Card aux;
        while (rs.next())
        {
            aux=new Card();
            aux.setNrCard(rs.getString(1));
            aux.setPin(rs.getString(5));
            aux.setDataExp(rs.getString(6));
            aux.setCVV(rs.getString(7));

        carduri.add(aux);}
    return carduri;}
    public  List<Cont>  addCardCredit(List<Cont> conturi) throws SQLException {
        Connection connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/banca","root","root-pass");
        Statement statement = connect.createStatement();
        ResultSet rs=  statement.executeQuery("select * from card");


        Card aux;
        while (rs.next()) {
            aux = new Card();
            aux.setNrCard(rs.getString(1));
            aux.setPin(rs.getString(5));
            aux.setDataExp(rs.getString(6));
            aux.setCVV(rs.getString(7));
            try {  for (int j = 0; j < conturi.size(); j++)
                 if (!(rs.getString(4).equals("NULL")) && (conturi.get(j).gettipcont().equals("Credit cu dobanda fixa") || conturi.get(j).gettipcont().equals("Credit cu dobanda variabila"))) {

                    if (rs.getString(4).equals(conturi.get(j).getIBAN()))
                        conturi.get(j).setCardelem(aux);
                }



            } catch (NullPointerException e) {
            }
        }

        return conturi;



    }
    public  List<Cont>  addCardDepozit(List<Cont> conturi) throws SQLException {
        Connection connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/banca","root","root-pass");
        Statement statement = connect.createStatement();
        ResultSet rs=  statement.executeQuery("select * from card");


        Card aux;
        while (rs.next()) {
            aux = new Card();
            aux.setNrCard(rs.getString(1));
            aux.setPin(rs.getString(5));
            aux.setDataExp(rs.getString(6));
            aux.setCVV(rs.getString(7));
            try {  for (int j = 0; j < conturi.size(); j++)
                if (!(rs.getString(3).equals("NULL")) && conturi.get(j).gettipcont().equals("Depozit")) {

                    if (rs.getString(3).equals(conturi.get(j).getIBAN()))
                        conturi.get(j).setCardelem(aux);
                }



            } catch (NullPointerException e) {
            }
        }

        return conturi;



    }
    public  List<Cont>  addCardCont(List<Cont> conturi) throws SQLException {
        Connection connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/banca","root","root-pass");
        Statement statement = connect.createStatement();
        ResultSet rs=  statement.executeQuery("select * from card");


        Card aux;
        while (rs.next()) {
            aux = new Card();
            aux.setNrCard(rs.getString(1));
            aux.setPin(rs.getString(5));
            aux.setDataExp(rs.getString(6));
            aux.setCVV(rs.getString(7));
            try {  for (int j = 0; j < conturi.size(); j++)
                if (!(rs.getString(2).equals("NULL")) && conturi.get(j).gettipcont().equals("Cont curent")) {
                        if (rs.getString(2).equals(conturi.get(j).getIBAN()))
                            conturi.get(j).setCardelem(aux);
                }


            } catch (NullPointerException e) {
            }
        }

        return conturi;



    }


    public void updateClient(Client c) throws SQLException {
        Connection connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/banca","root","root-pass");
        Statement statement = connect.createStatement();
       try{ statement.execute("update client set  Nume = \""+c.getNume()+"\",Prenume = \""+c.getPrenume()+"\",data_nasterii= \""+c.getDataNasterii()+"\" where cnp like "+c.getCNP());
   System.out.println("Update efectuat! Client");}
      catch(SQLSyntaxErrorException e)
        { System.out.println("IBAN-ul nu corespunde cu un IBAN existent in baza de date. Clientul nu exista!");}



    }

    public void updateCont(ContCurent c) throws SQLException {

        Connection connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/banca","root","root-pass");
        Statement statement = connect.createStatement();
        try{statement.execute("update contcurent set CNP= \""+c.getCNP()+"\", Valuta=  \""+c.getValuta()+"\",sold= \""+c.getSold()+"\",data_acordare=\""+c.getDataAcordare()+"\",tip_cont\""+c.gettipcont()+"\",comision=\""+c.getComisionA()+"\" where IBAN like" +c.getIBAN() );
        System.out.println("Update efectuat! Cont");}
           catch(SQLSyntaxErrorException e)
        { System.out.println("IBAN-ul nu corespunde cu un IBAN existent in baza de date. Contul nu exista!");}


    }
    public void updateDepozit(Depozit c) throws SQLException {

        Connection connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/banca","root","root-pass");
        Statement statement = connect.createStatement();
       try{ statement.execute("update depozit set IBANC= \""+c.getIBANcontc()+"\", Valuta=  \""+c.getValuta()+"\",sold= \""+c.getSold()+"\",data_acordare=\""+c.getDataAcordare()+"\",tip_cont\""+c.gettipcont()+"\",comision=\""+c.getComisionA()+"\", dobanda=\""+c.getDobanda()+"\" where IBAN like" +c.getIBAN() );
        System.out.println("Update efectuat! Depozit");}
           catch(SQLSyntaxErrorException e)
        { System.out.println("IBAN-ul nu corespunde cu un IBAN existent in baza de date. Depozitul nu exista!");}


    }

    public void updateCredit(Credit c) throws SQLException {

        Connection connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/banca","root","root-pass");
        Statement statement = connect.createStatement();
        try{statement.execute("update credit set IBANC= \""+c.getIBANcontc()+"\", Valuta=  \""+c.getValuta()+"\",sold= \""+c.getSold()+"\",data_acordare=\""+c.getDataAcordare()+"\",tip_cont\""+c.gettipcont()+"\",comision=\""+c.getComisionA()+"\", dobanda=\""+c.getDobanda()+"\",durataLuni=\""+c.getDurataluni()+"\",rata=\""+c.getRatac()+"\",ratePlatite=\""+c.getRatePlatite()+"\" where IBAN like" +c.getIBAN() );
        System.out.println("Update efectuat! Credit");}
        catch(SQLSyntaxErrorException e)
        { System.out.println("IBAN-ul nu corespunde cu un IBAN existent in baza de date. Creditul nu exista!");}

    }

    ////PT CARD NU E FACUT UPDATE

    public void deleteClient(Client c) throws SQLException {  Connection connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/banca","root","root-pass");
        Statement statement = connect.createStatement();
        statement.execute("delete from client where cnp like "+c.getCNP());
    }
    public void deleteCont(ContCurent c) throws SQLException {  Connection connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/banca","root","root-pass");
        Statement statement = connect.createStatement();
        statement.execute("delete from contcurent where IBAN like \""+c.getIBAN()+"\"");
    }
    public void deleteCard(Card c) throws SQLException {  Connection connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/banca","root","root-pass");
        Statement statement = connect.createStatement();
        statement.execute("delete from card where IBAN like \""+c.getNrCard()+"\"");
    }
    public void deleteDepozit(Depozit c) throws SQLException {  Connection connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/banca","root","root-pass");
        Statement statement = connect.createStatement();
        statement.execute("delete from depozit where IBAN like \""+c.getIBAN()+"\"");
    }
    public void deleteCredit(Credit c) throws SQLException {  Connection connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/banca","root","root-pass");
        Statement statement = connect.createStatement();
        statement.execute("delete from credit where IBAN like \""+c.getIBAN()+"\"");
    }
    public void deleteCutie(InchiriereCutieValori c) throws SQLException {  Connection connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/banca","root","root-pass");
        Statement statement = connect.createStatement();
        statement.execute("delete from cutie where Nr like \""+c.getNrCutie()+"\"");
    }




}
