public class Main {

    public static void main(String[] args) {
        System.out.println();

        // Do the thing
        //set up an instance of a database
        DBSetup setup = new DBSetup();
        setup.createNewDatabase("comp3208.db");

        //Insert data from file into comp3208.db
        setup.insertData("training_large.csv");

        DB db = new DB();
        db.loadRatings();
        db.createTestTrainingSet();
        db.finish();

    }
}
