package com.example.demo;

import com.example.demo.model.Employee;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.StringUtils;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.*;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

//@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = DemoApplication.class)
public class JoinQueryTest {

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    EntityManager em;

    @Test
    public void testEmployeeSelfJoin() {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Employee> cq = cb.createQuery(Employee.class);
        Root<Employee> root = cq.from(Employee.class);

        Subquery<Long> sub = cq.subquery(Long.class);
        Root<Employee> subRoot = sub.from(Employee.class);

        //self join --- employee(e1) join manager(e2)
        Join<Employee, Employee> selfJoin = subRoot.join("manager", JoinType.INNER);
        Predicate subP = cb.equal(subRoot.get("flag"), true);

        sub.where(subP);
        sub.select(selfJoin.get("id"));

        Predicate flagP = cb.equal(root.get("flag"), false);
        //not in the ids obtained from subQuery
        Predicate idNot = cb.not(root.get("id").in(sub));
        // Predicate sortBy = cb.(root.get("id").in(sub));
        Predicate finalP = cb.and(flagP, idNot);
        cq.where(finalP);
        Expression<Integer> exp = root.get("id");
        cq.groupBy(root.get("id"));

        TypedQuery<Employee> query = em.createQuery(cq.select(root));
        List<Employee> empList = query.getResultList();

        log.info("empList :  {} ", empList);
    }
}
