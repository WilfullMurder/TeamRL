package com.example.teamRl;

import java.util.ArrayList;
import java.util.Random;
//auth:JacobFarrow(20007972)

/**
 * !WARNING! DEVELOPMENT AND TESTING PURPOSES ONLY !WARNING!
 * Data should be generated manually via user input in production
 */
public class DataGenerator {
    private final String[] GIVEN_NAMES = new String[] {"Adrian", "Akim","Amy", "Amirah", "Alice", "Alicia", "Andre",
            "Babette", "Benedict", "Bethany", "Bjorn", "Bruno", "Bryoni", "Caitrionagh","Carlos", "Camelia", "Celine", "Chen","Christian",
            "Daena","Daniel", "Daphne", "Delphinah","Diego","Dimitri", "Eduardo", "Ealasidde", "Ekatrina","Elias", "Eleanor","Emilio",
            "Fabiannah","Fang Hua","Fanny","Finn","Franc","Frobisher", "Gabriella","Gail", "Giovanni","Giselle", "Habibah","Harmony","Haruto","Hippolyta", "Hudson",
            "Ianthe","Ileane","Ives", "Ishmael", "Itai", "Ivan", "Jaana", "Jai", "Jemimah","Johan", "Jorge","Julietta",
            "Kacey","Kacper", "Kaito","Kamiko","Kelechi","Kiranpal","Labdhi","Lars","Leif","Leisel","Liam","Lyneth", "Ma","Magnus","Malik","Mario","Mehitabel","Muriel",
            "Nada","Nathan","Neiva","Nicolette","Noel","Nolan", "Oba","Odetta","Omaka","Orion","Orlando", "Paavani","Paolo","Pelle","Petunia","Portia","Prince",
            "Qadira","Qianna","Quinella", "Rabi","Ramon","Remi","Renora","Rieko","Ritsu", "Sa","Sami","Samyar","Sebille","Sergei","Sheilagh",
            "Taa","Tai","Teagan","Titania", "Uberta","Udaya","Usagi","Ulhas", "Vachya","Vedah","Victor","Vivienne", "Wachiwi","Wendeline","Whitney","Wolf",
            "Xalbadora","Xenobia","Xiu Mei", "Yaa","Yemina","Yolanada","Yoshi", "Zaafirah","Zane","Zelda","Zsuzsanna"};

    private final String[] SURNAMES = new String[] {"Ab Adam", "Ainscough", "Akess", "Al-Qanawati", "Baalham", "Bacherach", "Beesly","Birss", "Caffyn", "Campilyon", "Chue","Czentner",
            "D'Hoe", "Dacre", "Docwra","Duignan", "Eabry", "Edkyns", "Elsam","Eyres", "Faelor", "Farquhar", "Fernihaugh","Fitzharris",
            "Gaddesden", "Ghisnes", "Gimblet","Goetz", "Habatell", "Haide", "Hertzbrunn","Howys", "I'Anson","Ihde","Inskippe","Isam",
            "Jack","Jeffcoat","Jinby","Jupp", "Kalwa","Kehir","Keough","Kilpatrick", "La Lane","Le Lean","Lediard","Lickford",
            "Maarafi","McCarty","Mewboorn","Mimet","Naggs","Newf","Nokes","Nutt", "O'Donnchadha","Olmsted","Orgle","Oystin",
            "Packman","Pedwardine","Phillipides","Puttuck","Quatermaine","Quatrucci","Questead","Quirke", "Radmoore","Realf","Rhavan","Roandeau",
            "Saban","Scantelberry","Selous","Shiloo", "Tabb","Tabourdeaux","Tetlow","Treagust", "Ubank","Udal","Ulfe","Uvedale","Van Der Bilt","Van Engers","Viccermane","Von Fumetti",
            "Wackinshaw","Weinister","Wharfer","Wilderspine", "Yair","Yapp","Yearker","Yoxal", "Zacksfield","Zealand","Zehender","Zionzee",};

    private final String[] EXECUTIVE_ROLES = new String[] {"President","Vice-President","Treasurer", "Secretary", "Member"};

    private final String LOREM_IPSUM = "";

    private final String MAIL_SUFFIX = "@fakeEmail.ac.uk";
    private final int UB_MAX_LENGTH = 8;

    private Random random = new Random();

    /**
     * Generate a bunch of User data for testing purposes
     * @param count the desired amount of users - EXCLUSIVE!
     * @return the ArrayList<User>
     */
    public ArrayList<User> generateUserData(int count)
    {
        ArrayList<User> userList = new ArrayList<>();

        for(int i=0; i<count; i++)
        {
            String surname = generateSurname();
            String forename = generateGivenName();
            String email = generateEmail(surname, forename);
            String startY = generateStartYear();
            boolean staffChance = random.nextInt(10) < 1;
            String ub = generateUB(staffChance, startY);
            String endY = generateEndYear(staffChance, startY);

            User u = new User(surname,forename,ub,email,generateDOB(), startY, endY);
            //here we need to generate all the random info for the user class
            //using the private gen functions
            if(!userList.contains(u))
            {
                //user is not a duplicate
                userList.add(u);
            }
        }

        //Collections.sort(userList);
        return userList;
    }

    private String generateEndYear(boolean staffChance, String startYear) {
        String e = "";
        if(!staffChance)
        {
            e = Integer.toString(Integer.valueOf(startYear) + 3);
        }
        return e;
    }

    private String generateGivenName()
    {
        return this.GIVEN_NAMES[random.nextInt(this.GIVEN_NAMES.length)];
    }
    private String generateSurname()
    {
        return this.SURNAMES[random.nextInt(this.SURNAMES.length)];
    }
    private String generateRandomRole()
    {
        return this.EXECUTIVE_ROLES[random.nextInt(this.EXECUTIVE_ROLES.length)];
    }
    private String generateEmail(String surname, String forename)
    {
        String initial = forename.substring(0);
        String mail = initial+surname;
        return mail+MAIL_SUFFIX;
    }

    private String generateUB(boolean staff, String startYear)
    {
        String s = "";
        int loopLength = UB_MAX_LENGTH;
        if(staff){
            loopLength-=3;
            s="900";
        }
        else{
            loopLength-=2;
            s=startYear.substring(2);
        }
        for(int i = 0; i<loopLength; i++)
        {

            int x = random.nextInt(10)+1;
            s+= Integer.toString(x);
        }

        return s;
    }

    private String generateStartYear()
    {
        String year = "20";
        int y1 = 2;
        int y2 = random.nextInt(4)+1;

        year += Integer.toString(y1);
        year += Integer.toString(y2);
        return year;
    }

    /**
     * generate a valid D.O.B in dd-mm-yyyy format
     * @return a valid D.O.B string
     */
    private String generateDOB()
    {
        String s = "";
        int day = 0;
        int bound = 32; //default upper bound is 32
        int month = random.nextInt(12)+1; //months 1-12
        int year = 1950 + random.nextInt((2006-1950+1));
        // years 1950-2005 (min of 18 years?) - dynamically allocate these

        //months have different days
        switch(month)
        {
            case 2:
                //it is february
                if(year%4!=0)
                {
                    //non-leap year
                    bound = 29;
                }
                else {
                    bound = 30;
                }
                break;
            //30 days have april, june, september, november
            case 4:
            case 6:
            case 9:
            case 11:
                bound = 31;
                break;
        }
        //generate a day between 1 and (bound-1)
        day = random.nextInt(bound)+1;
        //parse string
        s+= day + "/" + month + "/" + year;
        return s;

    }
}
