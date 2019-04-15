package fr.creative.stock.doa.impl;

import java.util.List;

import javax.persistence.Query;

import fr.creative.stock.doa.ILigneCommandeClientDao;
import fr.creative.stock.entities.LigneCommandeClient;

public class LigneCommandeClientDaoImpl extends GenericDaoImpl<LigneCommandeClient> implements ILigneCommandeClientDao{

	@SuppressWarnings("unchecked")
	@Override
	public List<LigneCommandeClient> getByIdCommande(Long idCommandeClient) {
		String queryString="SELECT lc FROM "+LigneCommandeClient.class.getSimpleName()+" lc WHERE lc.commandeClient.idCommandeClient =:x";
		Query query=em.createQuery(queryString);
		query.setParameter("x",idCommandeClient);
		return query.getResultList();
	}

}
