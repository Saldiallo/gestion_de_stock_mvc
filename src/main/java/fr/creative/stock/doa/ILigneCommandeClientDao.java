package fr.creative.stock.doa;

import java.util.List;

import fr.creative.stock.entities.LigneCommandeClient;

public interface ILigneCommandeClientDao extends IGenericDao<LigneCommandeClient> {

	List<LigneCommandeClient> getByIdCommande(Long idCommandeClient);

}
