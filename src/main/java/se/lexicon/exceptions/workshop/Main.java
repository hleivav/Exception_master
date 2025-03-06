package se.lexicon.exceptions.workshop;

import java.io.IOException;
import java.util.List;

import se.lexicon.exceptions.workshop.data_access.NameService;
import se.lexicon.exceptions.workshop.domain.Person;
import se.lexicon.exceptions.workshop.exception.DuplicateNameException;
import se.lexicon.exceptions.workshop.fileIO.CSVReader_Writer;

public class Main {
	public static void main(String[] args) throws IOException {
        //TODO:

		List <String> maleFirstNames = CSVReader_Writer.getMaleFirstNames();
        List <String> femaleFirstNames = CSVReader_Writer.getFemaleFirstNames();
        List <String> lastNames = null;
        try {
            lastNames = CSVReader_Writer.getLastNames();
        } catch (IOException e){
            System.out.println("Error occurred trying to read the file.");
        }



        NameService nameService = new NameService(maleFirstNames, femaleFirstNames,lastNames);
        try {
            nameService.addFemaleFirstName("Olivia");
        } catch (DuplicateNameException e ){
            System.out.println(e.toString());
        }

        try {
            nameService.addMaleFirstName(("August"));
        } catch (DuplicateNameException e) {
            System.out.println(e.toString());
        }

        Person test = nameService.getNewRandomPerson();
        System.out.println(test);

        try {
            nameService.addLastName("Lundqvist");
        } catch (DuplicateNameException e){
            System.out.println(e.toString());
        }
	}

}
