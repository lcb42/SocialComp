public class Main {

    public static void main(String[] args) {
        System.out.println();

        // Only to run first time ********************
        //set up an instance of a database
        DB db = new DB();
        db.createNewDatabase("comp3208.db");

        //Insert data from file into comp3208.db
        db.readData("training_small.csv");

        //********************************************

        db.loadRatings();
        db.createTestTrainingSet();
        db.finish();

    }
}
