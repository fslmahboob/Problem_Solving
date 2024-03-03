    public int getTotalBirthsRankedHigher(int year, String name, String gender){
        // RE-DO!
        // CAN'T USE MULTIPLE LOOPS AS REQUIRES CREATION OF NEW PARSERS
        // CREATE SEPARATE METHODS THAT YOU CAN CALL WITHIN THE WHILE LOOP INSTEAD
        
        
        // Get the rank of the current name
        int rank = 0;
        
        // Initialise counters
        int countG = 0;
        int countB = 0;
              
        // new FileResource to get CSVParser
        FileResource fr = new FileResource();
        CSVParser parser1 = fr.getCSVParser(false);
        CSVParser parser2 = fr.getCSVParser(false);
        
        // Loop through each row in the CSV to get rank
        for (CSVRecord row1 : parser1){
            if (row1.get(1).equals("F")){
                countG += 1;
                if (row1.get(1).equals(gender) && row1.get(0).equals(name)){
                    rank = countG;
                }
            } else {
                countB += 1;
                if (row1.get(1).equals(gender) && row1.get(0).equals(name)){
                    rank = countB;
                }
            }
        }
        
        // Initialise counter for total births
        int sumBirths = 0;
        
        System.out.println("Rank1: " + rank);
        
        // Do a while loop to keep subtracting that rank until it is zero
        while (rank > 0){
            // Decrease rank value by 1 to find next higher ranked
            rank -= 1;
            
            // Initialise counters for ranking
            int namesG = 0;
            int namesB = 0;
            
            // Initialise storing of the next higher ranked name
            //String newName = "";

            //CSVRecord currRank = null;
            
            // Loop through all the rows to get the next name higher ranked
            for (CSVRecord row2 : parser2){
                // String variable that stores the gender of each row
                String g = row2.get(1);
                if (g.equals("F")){
                    namesG += 1;
                    if (rank == namesG && g.equals(gender)){
                        //newName = row.get(0);
                        sumBirths += Integer.parseInt(row2.get(2));
                    }
                } else {
                    namesB += 1;
                    System.out.println("SumBirths1: " + sumBirths);
                    System.out.println("Rank2: " + rank);
                    System.out.println("namesB: " + namesB);
                    if (rank == namesB && g.equals(gender)){
                        //newName = row.get(0);
                        System.out.println("sumbirths " + row2.get(2));
                        sumBirths += Integer.parseInt(row2.get(2));
                        System.out.println("SumBirths2: " + sumBirths);
                    }
                }
            }
            System.out.println("Rank3: " + rank);
            System.out.println("SumBirths3: " + sumBirths);
        }
        return sumBirths;
    }
    
    public void testgetTotalBirthsRankedHigher(){
        int sumBirths = getTotalBirthsRankedHigher(2012, "Ethan", "M");
        System.out.println("Total Births Ranked Higher: " + sumBirths);
    }