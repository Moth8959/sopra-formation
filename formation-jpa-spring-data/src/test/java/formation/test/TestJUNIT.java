package formation.test;

import java.util.Optional;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import formation.dao.FormateurDao;
import formation.model.Formateur;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={ "/applicationContext.xml" })
public class TestJUNIT {
	
	@Autowired
	public FormateurDao formateurDao;
	
	
	@Test
	public void FormateurDaoTest() {
		
		int sizeIni = formateurDao.findAll().size();
		
		Formateur formateur = new Formateur("SULTAN", 15, true);
		
		formateurDao.save(formateur);
		
		Optional<Formateur> formateurFind = formateurDao.findById(formateur.getId());
		
		Assert.assertEquals("SULTAN", formateurFind.get().getNom());
		Assert.assertEquals(new Integer(15), formateurFind.get().getExperience());
		Assert.assertEquals(true, formateurFind.get().getReferent());
		
		formateur.setNom("RAZON");
		formateur.setExperience(10);
		formateur.setReferent(false);
		
		formateurDao.save(formateur);
		formateurFind = formateurDao.findById(formateur.getId());
		
		Assert.assertEquals("RAZON", formateurFind.get().getNom());
		Assert.assertEquals(new Integer(10), formateurFind.get().getExperience());
		Assert.assertEquals(false, formateurFind.get().getReferent());
		
//		formateurFind = formateurDao.findOneByNom("RAZON");
		Assert.assertEquals("RAZON", formateurFind.get().getNom());
		
		int sizeEnd = formateurDao.findAll().size();
		Assert.assertEquals(sizeIni+1, sizeEnd);
		
		formateurDao.delete(formateurFind.get());
		formateurFind = formateurDao.findById(formateur.getId());
		if(formateurFind.isPresent()) {
			Assert.fail();
		}
		
		int sizeUltimate = formateurDao.findAll().size();
		Assert.assertEquals(sizeIni, sizeUltimate);
		
	}

}
