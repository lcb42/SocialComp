public class Main {

    public static void main(String[] args) {
        System.out.println();

        // Do the thing
        //set up an instance of a database
        DBSetup setup = new DBSetup();
        DB db = new DB();
        setup.createNewDatabase("comp3208.db", db.c);

        //Insert data from file into comp3208.db
        setup.insertData("training_large.csv");


        db.loadRatings();
        db.createTestTrainingSet();
        db.finish();

    }
}
