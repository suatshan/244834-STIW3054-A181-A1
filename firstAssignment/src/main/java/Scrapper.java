import com.jaunt.*;
import com.jaunt.component.Table;

import java.util.ArrayList;
import java.util.List;

public class Scrapper {
    public List<DataFile> findAll() {

       List<DataFile>data=new ArrayList<DataFile>();
        try {
            //data = new ArrayList();
            UserAgent userAgent = new UserAgent(); //create new userAgent (headless browser).
            userAgent.visit("https://ms.wikipedia.org/wiki/Malaysia"); //visit a url

            Element tables = userAgent.doc.findEach("<table class=wikitable>").getElement(1);// get second table
            Table table = new Table(tables);//create Table component


            for(int a=0;a<=23;a++) {

                String result = String.valueOf(table.getTextFromRow(a));

                result = result.substring(1, result.indexOf(","));
                System.out.println("Tajuk:" + result);

                String result2=String.valueOf(table.getTextFromRow(a));
                result2=result2.substring(result2.lastIndexOf(',')+1);
                System.out.println("Maklumat:" + result2);
                System.out.println("");

                data.add(new DataFile(result, result2));
            }


        } catch (ResponseException e) {
            e.printStackTrace();
            return null;
        }
        catch (NotFound notFound) {
            notFound.printStackTrace();
            return null;
        }
        return data;
    }}





