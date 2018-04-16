package database.controller;

import database.model.storage.Material;
import org.springframework.http.HttpStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;

@CrossOrigin
@Transactional
@RestController
@RequestMapping(value = "/post")
public class PostController {

    @PersistenceContext(type = PersistenceContextType.TRANSACTION)
    private EntityManager em;


    @ResponseStatus(value = HttpStatus.OK)
    @RequestMapping(value = "/insertMaterial", method = RequestMethod.POST)
    public Material insertMaterial (@RequestBody Material material) {

        Material newInstance = new Material(material);

        em.persist(newInstance.content.versionDescription);
        em.persist(newInstance.content);
        em.persist(newInstance.versionDescription);
        em.persist(newInstance);
        em.flush();

        return newInstance;
    }

    @ResponseStatus(value = HttpStatus.OK)
    @RequestMapping(value = "/updateMaterial", method = RequestMethod.POST)
    public Material updateMaterial (@RequestBody Material material) {

        Material newInstance = new Material(material);
        newInstance.GUID = material.GUID;

        em.merge(newInstance.content);
        em.merge(newInstance);
        em.flush();

        return newInstance;
    }

}
