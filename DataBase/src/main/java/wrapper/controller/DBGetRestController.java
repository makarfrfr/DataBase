package wrapper.controller;


import org.springframework.web.bind.annotation.*;
import wrapper.model.Entity;
import wrapper.model.course.Course;
import wrapper.model.stat.log.CourseLog;
import wrapper.model.stat.log.UserLog;
import wrapper.model.storage.Material;
import wrapper.model.storage.Task;
import wrapper.model.user.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@RestController
@RequestMapping(value = "/get")
public class DBGetRestController {

    @PersistenceContext
    private EntityManager em;

    // CONTENT

    @CrossOrigin
    @RequestMapping(value = "/material", method = RequestMethod.GET)
    public Material material(@RequestParam(value="id", required = true, defaultValue = "0") long material_id) {
        return em.find(Material.class, material_id);
    }

    @CrossOrigin
    @RequestMapping(value = "/task", method = RequestMethod.GET )
    public Task task (@RequestParam(value="name", required = false, defaultValue = "1") String name) {
        return null;
    }

    // END OF CONTENT


    // USERS

    @CrossOrigin
    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public User user (@RequestParam(value="id", required = true, defaultValue = "1") long user_id) {
        return em.find(User.class, user_id);
    }

    @CrossOrigin
    @RequestMapping(value = "/userLog", method = RequestMethod.GET)
    public UserLog userLog (@RequestParam(value="id", required = false, defaultValue = "1") String id) {
        return null;
    }

    // END OF USERS

    // COURSE

    @CrossOrigin
    @RequestMapping(value = "/course", method = RequestMethod.GET)
    public Course course (@RequestParam(value="id", required = false, defaultValue = "1") String id) {
        return null;
    }

    @CrossOrigin
    @RequestMapping(value = "/courseLog", method = RequestMethod.GET)
    public CourseLog courseLog (@RequestParam(value="id", required = false, defaultValue = "1") String id) {
        return null;
    }

    // END OF COURSE

    @CrossOrigin
    @RequestMapping(value = "/getEntityByGUID", method = RequestMethod.GET)
    public Entity entity (@RequestParam(value="guid", required = true, defaultValue = "0") long guid) {
        return em.find(Entity.class, guid);
    }
}