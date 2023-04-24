package com.teamrl.app.components;
//lead auth:JacobFarrow(20007972)
import com.teamrl.app.Activity;
import com.teamrl.app.Admin;
import com.teamrl.app.User;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
//lead auth:JacobFarrow(20007972)
    /**
     * !WARNING! DEVELOPMENT AND TESTING PURPOSES ONLY !WARNING!
     * Data should be generated manually via user input in production
     */
public class DataGenerator {
        //auth:JacobFarrow(20007972)
        private final String[] FORENAMES = new String[] {"Adrian", "Akim","Amy", "Amirah", "Alice", "Alicia", "Andre",
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

        private final String[] ACTIVITY_NAMES = new String[]{"A_CHESS_SOCIETY", "ACTIVITIES_COMMITTEE","AFGHAN_SOCIETY","AFRICAN_CARIBBEAN_SOCIETY", "ALE_BEER_CIDER_SOCIETY","ANIME_CLUB",
                "APPLIED_ARTIFICIAL_INTELLIGENCE_SOCIETY", "ASSOCIATION_FOR_WOMEN_IN_COMPUTING","BAKING_SOCIETY", "BENGALI_SOCIETY", "BIOMEDICAL_ENGINEERING_SOCIETY", "BIOMEDICAL_SCIENCE_SOCIETY", "BOLLYWOOD_DANCE_STUDIO", "BOLO_CROSSFIT_REHAB_SOCIETY",
                "BRADFORD_OPTHALMIC_OPTICS_STUDENT_ASSOCIATION","BRADFORD_ASSOCIATION_OF_PHARMACY_STUDENTS", "BRADFORD_KUWAITI_SOCIETY", "BRADFORD_UNIVERSITY_START_UP_SOCIETY", "BREADS_AND_SPREADS_SOCIETY", "BRITISH_RED_CROSS_SOCIETY", "BRADFORD_UNIVERSITY_GAMING_SOCIETY",
                "CHEMICAL_ENGINEERING_SOCIETY", "CHRISTIAN_UNION", "CLINICAL_SCIENCES_SOCIETY", "CROCHETING_SOCIETY", "CULINARY","DATA_SCIENCE_SOCIETY","ECONOMICS","FILM_MAKING", "FIVE_A_SIDE", "FORENSIC_AND_ARCHEOLOGICAL_SCIENCE_SOCIETY", "GO_KARTING","HENNA_SOCIETY",
                "HIKING_SOCIETY", "HONG_KONG_SOCIETY","ICE_SKATING_SOCIETY", "INDIAN_SOCIETY", "INTERNATIONAL_BUSINESS_AND_MANAGEMENT_ASSOCIATION", "ISLAMIC_AHLULBAYT_SOCIETY", "ISLAMIC_THEOLOGY_SOCIETY", "ISLAMIC SOCIETY","JAPANESE_CULTURE_SOCIETY", "JUI_JITSU",
                "KASHMIR_SOCIETY", "KOREAN_CULTURE_SOCIETY", "KUWAIT_BRADFORD_SOCIETY", "LAW_SOCIETY", "LGBTQ+_SOCIETY","MARKETING_ACADEMICS_PARACTITIONERS_AND_STUDENTS_SOCIETY", "MEDITATION_SOCIETY", "MIDWIFERY", "MUSIC_SOCIETY","NEWJOY_INTERNATIONAL_GOSPEL_CHURCH",
                "NIGERIAN_STUDENTS_SOCIETY_BRADFORD", "NURSING_SOCIETY","PAKISTAN_SOCIETY", "PARAMEDIC_SOCIETY", "PEACE_SOCIETY", "PENSA_BRADFORD", "POSTGRADUATE_RESEARCH_SOCIETY", "PHOTOGRAPHY_CLUB", "PHYSIOTHERAPY_SOCIETY", "PI_SOCIETY", "PLANT_BASED_VEGAN_SOCIETY", "POETRY_SOCIETY",
                "POKEMON_GO_SOCIETY", "PSYCHOLOGY_SOCIETY", "PUBLIC_HEALTH_SOCIETY","QUIZ_SOCIETY","RAMAIR_SOCIETY", "REDEEMED_STUDENTS_CHRISTIAN_FELLOWSHIP","SADAQAH_JARIYAH_SOCIETY", "SAMBO_MARTIAL_ART", "SCI-FI SOCIETY", "SELF_DEFENCE", "SHUFFLEBOARD_SOCIETY", "SOCIAL_JUSTICE_SOCIETY",
                "SOCIETY_OF_FINTECH_STUDENTS", "STARGAZING", "STOMP_AND_CLAP_MAJORETTES", "SUSTAINABILITY_SOCIETY","TABLE_TENNIS", "THE_BRADFORD_FOOSBALLERS", "TIMBRE_GOSPEL","UBU_LISHI", "UBUTESTER","VIDEO_GAMES_AND_ESPORTS_SOCIETY", "VISUAL_ARTS_SOCIETY", "WINNER_STUDENT_FELLOWSHIP_FELLOWSHIP", "YA_LIFE"};

        private final String[] PASS_VERBS = new String[]{"acts","acted","acting","breaks","broke","breaking","cuts","cut","cutting","dances","danced","dancing", "elopes","eloped","eloping",
                "farts","farted","farting","gleams","gleamed","gleaming","hopes","hoped","hoping","ignites","ignited","igniting","jeers","jeered","jeering","kicks","kicked","kicking",
                "loves","loved","loving","magnifies","magnified","magnifying","names","named","naming","occurs","occured","occuring","parks","parked","parking","quaffs","quaffed","quaffing",
                "rains","rained","raining","smokes","smoked","smoking","tacks","tacked","tacking","uncorks","uncorked","uncorking","vents","vented","venting","waits","waited","waiting",
                "yells","yelled","yelling", "zooms","zoomed","zooming"};

        private final String[] PASS_NOUNS = new String[]{ "anchor","apricot","aztec", "beach","bowl","button", "car","city","coffee", "dawn","dolphin","drum", "eagle","egyptian","eyelash",
                "fact","fire","food", "garden","grass","guitar", "hand","hero","house", "ibex","iceberg","itinerary", "jackal","jellyfish","jewel",
                "kayak","kenya","koala", "lake","lemon","lunch", "mail","meal","music", "nacho","nimbus","nymph", "oasis","octopus","outlook",
                "park","picture","policy", "quail","queen","quinoa", "rabbit","recipe","rule", "sachet","skeleton","smudge", "table","teacher","truck",
                "ukulele","ulcer","utensil", "valley","velocity","voltage", "wall","wealth","waste", "xalam","xanthium","xiphias", "yacht","yoke","yurt", "zebra", "zealot", "zygote"};

        private final String[] PASS_ADVERB = new String[]{"abruptly","accidentally","always", "badly","below","bitterly","boldly", "bravely", "brightly","calmly","clearly","cheerfully","confidently", "deftly","devotedly",
                "eagerly","elegantly","either","eminently", "faintly","faithfully","far","finally","fortunately","gleefully","gracefully", "happily","heroically","honestly", "innocently",
                "jokingly","kindly","lazily","merrily","nosily","obediently", "partially","perfectly","politely","poorly","powerfully", "quaintly","robustly","safely",
                "victoriously","vivaciously","warmly","wearily","wastefully", "yearly"};

        private final String[] PASS_ADJ = new String[]{"adorable","adventurous","aggressive","accidentally","always", "bad","better","bored","bold", "brave", "bright","calm","clear","cheerful","confident", "deft","devoted",
                "eager","elegant","evil","eminent", "faint","faithful","foolish","funny","fortunate", "gentle","gifted","grieving","healthy","heroic","honest","hungry", "ill","important", "impossible","inexpensive","innocent","inquisitive",
                "jealous","jittery","jolly","joyous","kind","lazy","light","lively","lonely","long","lovely","lucky","magnificent","misty","modern","motionless","muddy","mushy","mysterious","nasty","naughty","nervous","nice","nutty",
                "obedient","obnoxious","odd","outrageous","outstanding","panicky","perfect","plain","pleasant","poised","poor","powerful","precious","prickly","proud","putrid","puzzled","quaint",
                "real","relieved","repulsive","rich","scary","selfish","shiny","shy","silly","sleepy","smiling","smoggy","sore","sparkling","splendid","spotless","stormy","strange","stupid",
                "successful","super","talented","tame","tasty","tender","tense","terrible","thankful","thoughtful","thoughtless","tired","tough","troubled","ugliest","ugly","uninterested","unsightly","unusual",
                "upset","uptight","vast","victorious","vivacious","wandering","weary","wicked","wild","witty","worried","worrisome","wrong","zany", "zealous"};





        private final String[] LINKS = new String[]{"aliquamsem", "pulvinarelementum","senectusetnetus", "nislcondimentum", "volutpatdiam", "lacussedviverra"};
        private final String[] URL = new String[]{".org", ".com", ".nl", ".de", ".ac.uk", ".net", ".io", ".ce", ".za", ".shop", ".online", ".pizza",".diamond"};


        private final String[] EXECUTIVE_ROLES = new String[] {"President","Vice-President","Treasurer", "Secretary", "Member"};

        private final String LOREM_IPSUM_SHORT = "donec ultrices tincidunt arcu non";
        private final String LOREM_IPSUM_MEDIUM = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. " +
                "Lectus proin nibh nisl condimentum id.";
        private final String LOREM_IPSUM_LONG = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua." +
                "Nulla pellentesque dignissim enim sit amet. Tincidunt dui ut ornare lectus sit amet est. " +
                "Mattis vulputate enim nulla aliquet porttitor lacus luctus accumsan. " +
                "Viverra aliquet eget sit amet tellus cras adipiscing enim.";

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
                boolean staffChance = random.nextInt(10) < 1; //1:10 --> if we get 0 out of 0-9

                //generate user attributes of random values
                String surname = generateSurname();
                String forename = generateForename();
                String email = generateEmail(surname, forename);
                String password = generatePassword();
                String startY = generateStartYear();
                String ub = generateUB(staffChance, startY);
                String endY = generateEndYear(staffChance, startY);
                boolean admin = false;
                if(!staffChance){
                    admin = random.nextInt(10) < 1;
                }
                User u = new User(surname,forename,ub,email,password,generateDOB(), startY, endY, admin, staffChance);
                if(!userList.contains(u))
                {
                    //user is not a duplicate
                    userList.add(u);
                }
            }
            //default sort the list by surname
            Collections.sort(userList, new BeanComparator("surname"));
            return userList;
        }

        public Admin generateAdmin(int memberCount){
            String act = ACTIVITY_NAMES[random.nextInt(ACTIVITY_NAMES.length-1)];
            String role = EXECUTIVE_ROLES[random.nextInt(EXECUTIVE_ROLES.length-1)];
            ArrayList<String> members = new ArrayList<>();

            for(int i = 0; i<memberCount; i++)
            {
                String fn = FORENAMES[random.nextInt(FORENAMES.length)-1] + SURNAMES[random.nextInt(SURNAMES.length-1)];
                members.add(fn);
            }

            Admin a = new Admin(act,role,members,null);
            return a;
        }

        public ArrayList<Activity> generateActivities(int count)
        {
            ArrayList<Activity> activities = new ArrayList<>();
            return activities;
        }



        private String generateForename()
        {
            return this.FORENAMES[random.nextInt(this.FORENAMES.length)];
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
            String initial = forename.substring(0,1);

            if(surname.indexOf(" ") > 0)
            {
                //there is a space, remove it
                String pre = surname.substring(0, surname.indexOf(" "));
                String suf = surname.substring(surname.indexOf(" ")+1);
                surname = pre+suf;
            }
            if(surname.indexOf("'") > 0)
            {
                //there is an apostrophe, remove it
                String pre = surname.substring(0, surname.indexOf("'"));
                String suf = surname.substring(surname.indexOf("'")+1);
                surname = pre+suf;
            }
            if(surname.indexOf("-") > 0)
            {
                //there is a hyphen, remove it
                String pre = surname.substring(0, surname.indexOf("-"));
                String suf = surname.substring(surname.indexOf("-")+1);
                surname = pre+suf;
            }


            String mail = initial+surname;
            return mail+MAIL_SUFFIX;
        }

        private String generateUB(boolean staff, String startYear)
        {
            String s = "";
            int loopLength = UB_MAX_LENGTH;
            if(staff){
                loopLength-=3;
                s="900"; //MAGIC NUMBER! all staff id start with 900
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
            int mnth = random.nextInt(12)+1;
            String month = Integer.toString(mnth); //months 1-12
            if(month.length() < 2){
                month = "0"+month;
            }

            int year = 1950 + random.nextInt((2006-1950+1));
            // years 1950-2005 (min of 18 years?) - dynamically allocate these

            //months have different days
            switch(mnth)
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
            //remember nextInt is EXCLUSIVE!!!
            day = random.nextInt(bound)+1;
            //parse string
            s+= day + "/" + month + "/" + year;
            return s;

        }

        private String generateEndYear(boolean staffChance, String startYear) {
            String e = "";
            if(!staffChance)
            {
                e = Integer.toString(Integer.valueOf(startYear) + 3);
            }
            return e;
        }

        private String generatePassword()
        {
            String s = "";

            //get random adj&noun
            String adj =  PASS_ADJ[random.nextInt(PASS_ADJ.length-1)];
            adj = adj.substring(0,1).toUpperCase() + adj.substring(1);
            String noun = PASS_NOUNS[random.nextInt(PASS_NOUNS.length-1)];
            noun = noun.substring(0,1).toUpperCase() + noun.substring(1);
            s+=adj+noun; //we have a basic password AaaaBbbb


            boolean numWords = random.nextInt( 2) == 0;

            if(numWords)
            {
                //gen third word (adverb)
                String adv = PASS_ADVERB[random.nextInt(PASS_ADVERB.length-1)];
                adv = adv.substring(0,1).toUpperCase() + adv.substring(1);

                //gen fourth word (verb)
                String v =PASS_VERBS[random.nextInt(PASS_VERBS.length-1)];;
                v = v.substring(0,1).toUpperCase() + v.substring(1);

                //concatenate
                s+=adv+v; //complexPassword AaaBbbCccDdd
            }


            //s==String AdjectiveNoun + (optional) Adverb + Verb
            //length>complexity
            //e.g. BraveOctopusCheerfullySmoking > P1r4t35!(etc)
            //easier to remember strong password > randomised

            return s;
        }

    }
