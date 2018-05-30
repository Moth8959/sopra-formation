package formation.test;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import formation.dao.EleveDao;
import formation.dao.FormateurDao;
import formation.model.Formateur;

public class TestJPASpring {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		
		EleveDao eleveDao = (EleveDao) context.getBean("eleveDao");
		
		EleveDao eleveDao2 = context.getBean(EleveDao.class);
		
		FormateurDao formateurDao = context.getBean(FormateurDao.class);
		formateurDao.save(new Formateur("SULTAN", 15, true));
		formateurDao.findOneByNom("SULTAN");
		
		context.close();

	}

}
