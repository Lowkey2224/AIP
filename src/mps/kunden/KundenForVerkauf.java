package mps.kunden;

import mps.kunden.dtos.KundeDTO;

import java.util.List;

/**
 * User: Loki
 * Date: 02.12.13
 * Time: 17:55
 */
public interface KundenForVerkauf {
    /**
     * Gibt alle Kunden mit dem entsprechenden Namen zurück. gibt eine leere
     * Liste zurück falls kein Kunde gefunden wurde
     * @param name Kundenname
     * @return Eine Liste mit allen Kunden die den uebergebenen Namen haben.
     * Gibt eine leere Liste zurueck falls kein Kunde gefunden wurde.
     */
    public List<KundeDTO> findKundenByName(String name);

    /**
     * Gibt den Kunden mit der uebergebenen Kundennummer zurueck. Null wenn kein Kunde gefunden wurde.
     * @param nr Kundennummer
     * @return Kunde||null
     */
    public KundeDTO findOneKundeByNr(int nr);

    /**
     * Erstellt einen Kunden, mit dem Ubergebenen Namen, und Adresse
     * Gibt einen Kunden zurueck, der zusaetzlich eine Kundennummer hat.
     * Sucht NICHT nach einem Kunden mit ggfs gleichem Namen!
     * @param name Name
     * @param addresse Adresse
     * @return Ein neues Kundenobjekt.
     */
    public KundeDTO createKunde(String name, String addresse);
}
