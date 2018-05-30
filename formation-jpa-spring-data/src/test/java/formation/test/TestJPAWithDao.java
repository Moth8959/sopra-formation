package formation.test;

import java.util.Date;
import java.util.Optional;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import formation.dao.EleveDao;
import formation.dao.FormateurDao;
import formation.dao.FormationDao;
import formation.dao.RessourceDao;
import formation.dao.SalleDao;
import formation.model.Adresse;
import formation.model.CPU;
import formation.model.Eleve;
import formation.model.Formateur;
import formation.model.Formation;
import formation.model.Ordinateur;
import formation.model.Ressource;
import formation.model.Salle;

public class TestJPAWithDao {
	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

		EleveDao eleveDao = context.getBean(EleveDao.class);
		FormateurDao formateurDao = context.getBean(FormateurDao.class);
		FormationDao formationDao = context.getBean(FormationDao.class);
		RessourceDao ressourceDao = context.getBean(RessourceDao.class);
		SalleDao salleDao = context.getBean(SalleDao.class);

		Eleve diakho = new Eleve("KEBE", "Diakho", 27);
		eleveDao.save(diakho);

		diakho.setAge(22);

		diakho = eleveDao.save(diakho);

		Ordinateur ordi128 = new Ordinateur("AJC-128", "TERRA", CPU.i5, 8);

		ressourceDao.save(ordi128);

		Optional<Ressource> ordi128Find = ressourceDao.findById(ordi128.getId());

		Formateur olivier = new Formateur("Olivier", 20, true);

		formateurDao.save(olivier);

		Salle saphir = new Salle(4, "Saphir", 20);

		saphir.setAdr(new Adresse("6 rue rougemont", "75009", "Paris"));

		salleDao.save(saphir);

		Formation fakir = new Formation();
		fakir.setDtDebut(new Date());
		fakir.setSalle(saphir);
		fakir.setFormateur(olivier);

		formationDao.save(fakir);
		
		Formation fakirFind =  formationDao.findOneWithFormateur(fakir.getId());

		System.out.println(fakirFind.getFormateur().getNom());
		
		context.close();
	}
}
