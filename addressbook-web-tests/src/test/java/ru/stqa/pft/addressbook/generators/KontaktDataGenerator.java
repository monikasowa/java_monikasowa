package ru.stqa.pft.addressbook.generators;

import com.beust.jcommander.JCommander;
import com.beust.jcommander.Parameter;
import com.beust.jcommander.ParameterException;
import com.thoughtworks.xstream.XStream;
import ru.stqa.pft.addressbook.model.GroupData;
import ru.stqa.pft.addressbook.model.KontaktData;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

public class KontaktDataGenerator {


        @Parameter(names = "-c", description = "Kontakt count")
        public int count;

        @Parameter(names = "-f", description = "Target file")
        public String file;

        @Parameter(names = "-d", description = "Data format")
        public String format;

        public static void main(String[] args) throws IOException {
            ru.stqa.pft.addressbook.generators.KontaktDataGenerator generator = new ru.stqa.pft.addressbook.generators.KontaktDataGenerator();
            JCommander JCommander = new JCommander(generator);
            try {
                JCommander.parse(args);
            } catch (ParameterException ex) {
                JCommander.usage();
                return;
            }
            generator.run();
        }
        private void run() throws IOException {
            List<KontaktData> kontakts = generateKontakts(count);
            if (format.equals("csv"))
                saveAsCsv(kontakts, new File(file));
            else if(format.equals("xml"))
            {
                saveAsXml(kontakts, new File(file));
            }
            else
            {
                System.out.println("Unrecognized format" + format);
            }
        }

    private void saveAsXml(List<KontaktData> kontakts, File file) throws IOException {
            XStream xstream = new XStream();
            xstream.processAnnotations(KontaktData.class);
            String xml = xstream.toXML(kontakts);
            Writer writer = new FileWriter(file);
            writer.write(xml);
            writer.close();
        }
        private void saveAsCsv(List<KontaktData> kontakts, File file)throws IOException {
            System.out.println(new File(".").getAbsolutePath());
            Writer writer = new FileWriter(file);
            for (KontaktData kontakt : kontakts) {
                writer.write(String.format("%s;%s;%s\n", kontakt.getFirstName(),kontakt.getLastName()
                        ,kontakt.getAddress(), kontakt.getMail(), kontakt.getHomePhone()
                        ,kontakt.getMobilePhone(), kontakt.getWorkPhone()));
            }
            writer.close();
        }
        private List<KontaktData> generateKontakts(int count) {
            List<KontaktData> kontakts = new ArrayList<KontaktData>();
            for (int i = 0; i < count; i++) {
                kontakts.add(new KontaktData().withFirstname(String.format("firstname %s", i))
                        .withLastname(String.format("lastname %s", i)).withAddress(String.format("address %s", i))
                        .withMail(String.format("mail %s", i)).withHomePhone(String.format("home %s", i))
                        .withMobilePhone(String.format("nobile %s", i)).withWorkPhone(String.format("work %s", i)));
            }
            return kontakts;
        }
        
    }


