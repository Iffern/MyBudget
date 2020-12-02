package dao;

import com.google.inject.Inject;
import com.google.inject.Provider;
import model.Operation;

import javax.persistence.EntityManager;

public class OperationDao extends GenericDao<Operation>  {

    @Inject
    public OperationDao(EntityManager entityManager) {
        super(entityManager, Operation.class);
    }
}
