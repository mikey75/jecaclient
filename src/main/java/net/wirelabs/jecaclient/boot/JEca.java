package net.wirelabs.jecaclient.boot;

import lombok.extern.slf4j.Slf4j;
import net.wirelabs.jecaclient.core.Utils;
import net.wirelabs.jecaclient.gui.swing.MainWindow;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.awt.*;
import java.io.File;

/**
 * Main thread invoker - reads config and instantiates MainWindow;
 * Everything else is in there ...
 *
 * @author Michał Szwaczko
 */
@Slf4j
public class JEca {

    public static Conf configuration = new Conf();

    public static void main(String[] args) {
        // TODO: it would be nice to let user specify client.xml file on commandline perhaps
        EventQueue.invokeLater(() -> {

            Utils.setLook("Metal", 10);
            log.info("Starting application");
            try {
                Unmarshaller u = JAXBContext.newInstance(Conf.class).createUnmarshaller();
                configuration = (Conf) u.unmarshal(new File("ecaclient.xml"));

            } catch (JAXBException ex) {
                log.debug("Config file is unreadable or failed parsing, application will start in a default state");
            }

            MainWindow frame = new MainWindow();
            frame.setVisible(true);
            log.info("Application started");

        });

    }

}
