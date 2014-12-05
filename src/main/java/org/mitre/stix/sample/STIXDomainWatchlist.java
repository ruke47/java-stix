package org.mitre.stix.sample;

import java.io.IOException;
import java.net.URL;
import java.util.Scanner;

import javax.xml.bind.JAXBException;
import javax.xml.parsers.ParserConfigurationException;

import org.mitre.stix.stix_1.STIXType;

/**
 * Reads in
 * https://raw.githubusercontent.com/STIXProject/schemas/master/samples/
 * STIX_Domain_Watchlist.xml into the JAXB Document Model and then marshals it
 * back out to XML.
 * 
 * @author nemonik (Michael Joseph Walsh <github.com@nemonik.com>)
 *
 */
public class STIXDomainWatchlist {

	public STIXDomainWatchlist() {
	}

	public static void main(String[] args) throws JAXBException, IOException,
			ParserConfigurationException {

		@SuppressWarnings("resource")
		String text = new Scanner(
				new URL(
						"https://raw.githubusercontent.com/STIXProject/schemas/master/samples/STIX_Domain_Watchlist.xml")
						.openStream(), "UTF-8").useDelimiter("\\A").next();

		STIXType stix = (STIXType) STIXType.fromXMLString(text);

		System.out.println(stix.toXMLString());
	}
}