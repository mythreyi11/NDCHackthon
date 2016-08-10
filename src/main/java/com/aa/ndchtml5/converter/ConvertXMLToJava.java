package com.aa.ndchtml5.converter;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import com.aa.ndchtml5.domain.Offers;

public class ConvertXMLToJava {
	/*public static void main(String[] args) {

		 try {

			File file = new File("C:\\Sample Projects\\NdcHtml5\\src\\main\\resources\\static\\core\\Offers.xml");
			JAXBContext jaxbContext = JAXBContext.newInstance(Offers.class);

			Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
			Offers offers = (Offers) jaxbUnmarshaller.unmarshal(file);
			System.out.println(offers.toString());

		  } catch (JAXBException e) {
			e.printStackTrace();
		  }

		}*/
	
	
	public static Offers getOffers(){
			Offers offers = null;
		 try {

				File file = new File("C:\\Users\\989572\\eclipse-mars-workspace\\NdcHtml5\\src\\main\\resources\\static\\core\\Offers.xml");
				//File file = new File("C:\\Sample Projects\\NdcHtml5\\src\\main\\resources\\static\\core\\Offers.xml");
				JAXBContext jaxbContext = JAXBContext.newInstance(Offers.class);

				Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
				offers = (Offers) jaxbUnmarshaller.unmarshal(file);
				

			  } catch (JAXBException e) {
				e.printStackTrace();
			  }

		return offers;
	}
	
	public static void persistOffers(Offers offers) {
		try {

			File file = new File(
					"C:\\Users\\989572\\eclipse-mars-workspace\\NdcHtml5\\src\\main\\resources\\static\\core\\PersistedOffers.xml");
			//File file = new File("C:\\Sample Projects\\NdcHtml5\\src\\main\\resources\\static\\core\\PersistedOffers.xml");
			JAXBContext jaxbContext = JAXBContext.newInstance(Offers.class);

			Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
			jaxbMarshaller.marshal(offers, file);

		} catch (JAXBException e) {
			e.printStackTrace();
		}

	}
}

