package repository;
import model.DirectoryOffice;
import org.apache.deltaspike.data.api.AbstractEntityRepository;
import org.apache.deltaspike.data.api.Repository;
import org.apache.deltaspike.data.api.criteria.Criteria;
import org.apache.deltaspike.data.api.criteria.CriteriaSupport;

import java.util.List;

@Repository(forEntity = DirectoryOffice.class)
public abstract class DirectoryOfficeRepository extends AbstractEntityRepository<DirectoryOffice,Long> implements CriteriaSupport<DirectoryOffice> {

    public List<DirectoryOffice> getAll() {
        Criteria<DirectoryOffice, DirectoryOffice> generalQuery = criteria();

        return generalQuery.getResultList();
    }
}
