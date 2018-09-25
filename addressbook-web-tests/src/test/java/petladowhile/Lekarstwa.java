package petladowhile;

public class Lekarstwa {

    public static void main(String[] arg) {
        String[] lekarstwa =
                {
                        "nifurosazyd", "apap", "nurofen"
                };
        String[] dni =
                {
                        "pon", "wt", "sr", "czw", "pt", "sob", "nd"
                };


        /*int b = 0;

        while (b < dni.length) {
            System.out.println(dni[b]);
            b++;
            int c = 0;
            while (c < lekarstwa.length)
            {

                System.out.println(lekarstwa[c]);
                c++;
            }

        }


    }*/


                for(String blabla: dni)
                {
                    System.out.println(blabla);
                }

        }
    }


